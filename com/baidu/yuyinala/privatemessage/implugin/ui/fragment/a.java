package com.baidu.yuyinala.privatemessage.implugin.ui.fragment;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener;
import com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener;
import com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.android.imsdk.chatmessage.messages.NotifyCustomerMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.yuyinala.privatemessage.implugin.a.a;
import com.baidu.yuyinala.privatemessage.implugin.common.ChatInfo;
import com.baidu.yuyinala.privatemessage.implugin.entity.ImBaseEntity;
import com.baidu.yuyinala.privatemessage.implugin.f.h;
import com.baidu.yuyinala.privatemessage.implugin.f.k;
import com.baidu.yuyinala.privatemessage.implugin.ui.activity.ActivityChat;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c;
import com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
import com.baidu.yuyinala.privatemessage.implugin.util.f;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a implements SensorEventListener, a.InterfaceC0977a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private View bVM;
    private MediaPlayer cFn;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private String oRJ;
    private ActivityChat oRx;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oVp;
    private int oWC;
    private boolean oWF;
    private ActivityChat.c oWG;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a oWI;
    private long oWM;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a oWl;
    protected IMListView oWm;
    protected TextView oWn;
    private FrameLayout oWo;
    private d oWp;
    private boolean oWs;
    private c oWu;
    private final int MAX_RETRY_NUM = 3;
    private c oWq = null;
    private boolean oWr = true;
    private Timer oWt = null;
    private HashMap<Long, b> oWv = new HashMap<>();
    private Set<Long> oWw = new HashSet();
    private boolean oWx = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d oWy = null;
    private int oWz = 1;
    private Timer mTimer = null;
    private boolean oWA = false;
    private boolean oWB = false;
    private int oWD = 0;
    private boolean oWE = true;
    private BroadcastReceiver oWH = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.oWl.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener oSg = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.emD().emF() != null) {
                d.emD().emF().emy();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b emF;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b emG = d.emD().emG();
            if (emG != null) {
                emG.emy();
            }
            if (Math.abs(f2) > 10.0f && (emF = d.emD().emF()) != null) {
                emF.emy();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver oWJ = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.oWu = d.emD().Yt(a.this.mKey);
                if (a.this.oWu != null) {
                    a.this.oWu.ema();
                }
            }
        }
    };
    private BroadcastReceiver oWK = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.oWu = d.emD().Yt(a.this.mKey);
                        if (a.this.oWu != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.oWu.i(chatMsg);
                            a.this.oWu.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elm().c(a.this.oRx, e2);
                }
            }
        }
    };
    private BroadcastReceiver bMR = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.21
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (IMConstants.MESSAGE_ACTION.equals(action)) {
                try {
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(IMConstants.MESSAGE);
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < parcelableArrayListExtra.size(); i++) {
                        if (((ChatMsg) parcelableArrayListExtra.get(i)).getContacter() == ChatInfo.mContacter || ((ChatMsg) parcelableArrayListExtra.get(i)).getMsgType() == 21) {
                            arrayList.add(parcelableArrayListExtra.get(i));
                        }
                    }
                    a.this.oWu = d.emD().Yt(a.this.mKey);
                    if (a.this.oWu != null) {
                        a.this.oWu.gy(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elm().c(a.this.oRx, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.oWu = d.emD().Yt(a.this.mKey);
                    if (a.this.oWu != null) {
                        a.this.oWu.gy(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elm().c(a.this.oRx, e3);
                }
            }
        }
    };
    private BroadcastReceiver oWL = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (IMConstants.SYNC_ACTION.equals(intent.getAction())) {
                try {
                    if (intent.getIntExtra(IMConstants.SYNC_TYPE, -1) == 0) {
                        ArrayList arrayList = new ArrayList();
                        if (intent.getIntExtra(IMConstants.SYNC_STATUS, -1) == 0) {
                            long longExtra = intent.getLongExtra(IMConstants.SYNC_MSGID, -1L);
                            if (longExtra != -1) {
                                arrayList.add(Long.valueOf(longExtra));
                                a.this.oWu = d.emD().Yt(a.this.mKey);
                                if (a.this.oWu != null) {
                                    a.this.oWu.gz(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elm().c(a.this.oRx, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener oWN = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
        @Override // com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener
        public void onMediaChatMsgChangedResult(int i, long j, int i2, long j2, String str, long j3) {
            Log.d("ChatFragment", "BC> code=" + i + ", contactor=" + j + ", msgid=" + j3);
            if (i != 1) {
                if (i == 2) {
                    a.this.q(false, ((ChatMsg) a.this.mMsgList.get(a.this.mMsgList.size() - 1)).getMsgTime());
                } else if (i == 3 && j3 > 0 && a.this.mMsgList != null && a.this.mMsgList.size() > 0) {
                    for (int i3 = 0; i3 < a.this.mMsgList.size(); i3++) {
                        if (((ChatMsg) a.this.mMsgList.get(i3)).getMsgId() == j3) {
                            a.this.mMsgList.remove(i3);
                            a.this.emj();
                            return;
                        }
                    }
                }
            }
        }
    };

    public static a a(ActivityChat activityChat, View view, String str, ActivityChat.c cVar, int i) {
        return new a(activityChat, view, cVar, str, i);
    }

    public a(ActivityChat activityChat, View view, ActivityChat.c cVar, String str, int i) {
        this.oWC = 0;
        this.mKey = "";
        this.oWG = null;
        this.oWG = cVar;
        this.mKey = str;
        this.oWC = i;
        this.oRx = activityChat;
        d.emD().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.oWp = new d();
        this.mMsgList.clear();
        this.oWv.clear();
        this.oWw.clear();
        emd();
        if (f.hI(this.oRx)) {
            ems();
        }
        elX();
        this.bVM = view;
        ap(this.bVM);
        if (this.oRx.oVg) {
            q(true, System.currentTimeMillis());
        } else {
            OS(0);
        }
        initSensor();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oRx.getApplicationContext(), this.oWN);
    }

    private void elX() {
        if (!this.oWF) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oRx.registerReceiver(this.oWH, intentFilter);
            this.oWF = true;
        }
    }

    private void elY() {
        if (this.oWF) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oRx.unregisterReceiver(this.oWH);
            this.oWF = false;
        }
    }

    public void onPause() {
        this.mSensorManager.unregisterListener(this);
        this.oWA = true;
        emc();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oRx.getApplicationContext(), this.oWN);
        d.emD().Yu(this.mKey);
        if (this.oWt != null) {
            this.oWt.cancel();
        }
        if (this.oWy != null) {
            this.oWy.dismiss();
        }
        eme();
        ThemeManager.b(this);
        elY();
        elZ();
        if (this.oRx.oVg) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oRx, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void elZ() {
        Map<Long, h> els;
        if (ChatInfo.oTH == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.oUA && (els = k.hB(this.oRx).els()) != null && !els.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : els.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.elp());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.D(this.oRx, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pcd, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(this.oRx, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pce, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oTH == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.oWA && ChatInfo.mStatus == 3) {
            if (ChatInfo.oTH == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oRx.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C || ChatInfo.oTH == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oRx.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oTH == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oRx.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    emb();
                    emj();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        emb();
                        gB((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            emj();
                        }
                    } else {
                        emj();
                    }
                }
            }
        }
        this.oWA = false;
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void onStart() {
    }

    private void initSensor() {
        this.mSensorManager = (SensorManager) this.oRx.getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void ap(View view) {
        this.mGestureDetector = new GestureDetector(this.oRx, this.oSg);
        this.oWo = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.oWm = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.oWn = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hy = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().hy(this.oRx.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hy);
        try {
            this.oRJ = new JSONObject(hy).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hy);
        this.oWl = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oRx, this.mMsgList, this, this, this, this, this.oWG, this.oRJ);
        this.oWl.a(this.oRx);
        this.oWm.setPullRefreshEnable(true);
        this.oWm.setIMListViewListener(this);
        this.oWm.setAdapter((ListAdapter) this.oWl);
        this.oWm.setSelector(new ColorDrawable(0));
        this.oWm.setTranscriptMode(1);
        this.oWm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                a.this.mGestureDetector.onTouchEvent(motionEvent);
                return false;
            }
        });
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] < this.mSensor.getMaximumRange()) {
            this.oWr = false;
        } else {
            this.oWr = true;
        }
        if (this.oWq != null && this.oWs != this.oWr) {
            ChatMsg chatMsg = this.oWq.mMsg;
            View view = this.oWq.mView;
            Boolean valueOf = Boolean.valueOf(this.oWq.oXc);
            this.oWq.emt();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.oWr) {
                emk();
            }
        }
        this.oWs = this.oWr;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.oWp.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.oWw.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oRx.getApplicationContext())) {
            a(3, chatMsg);
            emf();
            return;
        }
        a(3, chatMsg);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void c(ChatMsg chatMsg) {
        JSONObject jSONObject = new JSONObject();
        try {
            int msgType = chatMsg.getMsgType();
            jSONObject.put("type", msgType);
            if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C) {
                jSONObject.put("currentId", ChatInfo.mUid);
            }
            String msgContent = chatMsg.getMsgContent();
            if (msgType == 1 && !TextUtils.isEmpty(chatMsg.getLocalUrl())) {
                jSONObject.put("path", chatMsg.getLocalUrl());
            } else if (msgType == 8) {
                JSONObject jSONObject2 = new JSONObject(msgContent);
                jSONObject2.put("sti_type", 1);
                jSONObject2.put("sti_cover1", ((SignleGraphicTextMsg) chatMsg).getCover());
                String covers = ((SignleGraphicTextMsg) chatMsg).getCovers();
                if (!TextUtils.isEmpty(covers)) {
                    jSONObject2.put("sti_cover1", covers);
                }
                jSONObject2.put("ext", chatMsg.getmExtJson());
                msgContent = jSONObject2.toString();
            }
            jSONObject.put("content", msgContent);
            LogUtils.d("ChatFragment", "--onForwardMessage--msgType=" + msgType + ", content = " + msgContent);
        } catch (JSONException e2) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage());
        }
        com.baidu.yuyinala.privatemessage.implugin.d.b.elm().ch(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        ImBaseEntity elL;
        if (!(this.oRx instanceof ActivityChat) || !this.oRx.elI()) {
            return;
        }
        switch (chatMsg.getMsgType()) {
            case 0:
                return;
            case 1:
                return;
            case 2:
                return;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                return;
            case 8:
                if ((chatMsg instanceof SignleGraphicTextMsg) && new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).eoh() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE && (this.oRx instanceof ActivityChat) && (elL = this.oRx.elL()) != null && elL.mVideoEntity != null && !elL.mVideoEntity.isShared) {
                    String str = elL.mVideoEntity.id;
                    return;
                }
                return;
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void h(ChatMsg chatMsg) {
        if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND + chatMsg.toString());
        }
        g(chatMsg);
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oRx.getApplicationContext())) {
            if (chatMsg.getMsgType() == 0) {
                a(2, chatMsg);
                return;
            } else {
                a(1, chatMsg);
                return;
            }
        }
        a(2, chatMsg);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void i(ChatMsg chatMsg) {
        a(3, chatMsg);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void gy(final List<ChatMsg> list) {
        this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.oWx && ChatInfo.mStatus == 3) {
                    a.this.gA(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ema() {
        this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.oWz == 0) {
                    a.this.oWz = 1;
                    a.this.mMsgList.clear();
                    if (a.this.oWy != null) {
                        a.this.oWy.cancel();
                    }
                    a.this.OS(1);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void gz(List<Long> list) {
        int size = this.mMsgList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                int i3 = size - 1;
                while (true) {
                    if (i3 < 0) {
                        break;
                    } else if (this.mMsgList.get(i3).getMsgId() != list.get(i2).longValue()) {
                        i3--;
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elm().deleteMsg(this.oRx.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                emj();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void emb() {
        this.mMsgList.clear();
        emj();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0977a
    public void OM(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oRx, this.oRx.getResources().getString(a.h.bd_im_alertdialog_title), this.oRx.getResources().getString(a.h.bd_im_alertdialog_tip), this.oRx.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oRx.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emJ();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a oWO;
        final /* synthetic */ int oWP;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.oWO = aVar;
            this.oWP = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.oWO.emJ();
            if (this.oWP < 0 || this.oWP >= a.this.mMsgList.size()) {
                a.this.oRx.showToast(a.this.oRx.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.oWP);
            if (!a.this.oRx.oVg) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.elm().deleteMsg(a.this.oRx.getApplicationContext(), chatMsg);
                if (a.this.oWq != null && a.this.oWq.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.oWq.emt();
                }
                a.this.emj();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oRx, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.oWq != null && a.this.oWq.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.oWq.emt();
                                }
                                a.this.emj();
                            }
                        });
                    }
                }
            });
        }
    }

    public void emc() {
        if (this.oWq != null) {
            this.oWq.emt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.oWm.emX();
        this.oWm.emY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(ChatMsg chatMsg) {
        for (int size = this.mMsgList.size() - 1; size >= 0; size--) {
            if (chatMsg.getRowId() == this.mMsgList.get(size).getRowId()) {
                return size;
            }
        }
        return -1;
    }

    public void a(com.baidu.yuyinala.privatemessage.implugin.ui.activity.a aVar) {
        this.oWI = aVar;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.b
    @SuppressLint({"NewApi"})
    public void g(View view, int i, boolean z) {
        ChatMsg chatMsg = null;
        if (i >= 0 && i < this.mMsgList.size()) {
            chatMsg = this.mMsgList.get(i);
        }
        if (chatMsg != null) {
            switch (chatMsg.getMsgType()) {
                case 1:
                case 2:
                case 8:
                    this.oRx.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void emd() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oRx.registerReceiver(this.bMR, intentFilter);
        this.oRx.registerReceiver(this.oWL, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oRx.registerReceiver(this.oWJ, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oRx.registerReceiver(this.oWK, new IntentFilter("implugin.update.message"));
    }

    private void eme() {
        this.oRx.unregisterReceiver(this.bMR);
        this.oRx.unregisterReceiver(this.oWL);
        this.oRx.unregisterReceiver(this.oWJ);
        this.oRx.unregisterReceiver(this.oWK);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.oWq != null && this.oWq.mMsg.getRowId() != chatMsg.getRowId()) {
            this.oWq.emt();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oTJ) {
            if (this.oWq == null) {
                this.oWq = new c(chatMsg, view, z);
                this.oWq.Ys(chatMsg.getLocalUrl());
                return;
            }
            this.oWq.emt();
        } else if (this.oWv.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.oWv.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.oWv.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oXb < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oXb++;
                this.oWv.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.elm().markMsgClicked(this.oRx.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN && this.oWE && chatMsg.getStatus() == 0) {
            bp(this.mMsgList);
            this.oWE = false;
        }
    }

    public String bp(ArrayList<ChatMsg> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getFromUser() == ChatInfo.mPaid) {
                return arrayList.get(size).getExtLog();
            }
        }
        return null;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void emf() {
        emi();
    }

    public void emg() {
        this.oWp.obtainMessage(32).sendToTarget();
    }

    public void emh() {
        this.oWp.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emi() {
        Message obtainMessage = this.oWp.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void OQ(int i) {
        Message obtainMessage = this.oWp.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OR(int i) {
        Message obtainMessage = this.oWp.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emj() {
        this.oWp.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.oWp.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void emk() {
        this.oWp.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gA(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.oWp.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.oWp.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eml() {
        if (ChatInfo.oTH == ChatInfo.ChatCategory.SMART && this.oRx != null) {
            this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oWn.setVisibility(0);
                    a.this.oWm.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.oWM == chatMsg.getMsgId()) {
                            a.this.oRx.showToast(a.this.oRx.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.oWM = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oRx);
                        BIMManager.tryConnection(a.this.oRx);
                        String ell = com.baidu.yuyinala.privatemessage.implugin.d.a.ell();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(ell, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
                            @Override // com.baidu.android.imsdk.account.ILoginListener
                            public void onLoginResult(int i2, String str) {
                                LogUtils.i("ChatFragment", "ImSdk 发送失败重连重发 onLoginResult errorcode：" + i2 + "， info：" + str);
                                if (i2 == 0) {
                                    a.this.b(chatMsg);
                                }
                            }

                            @Override // com.baidu.android.imsdk.account.ILoginListener
                            public void onLogoutResult(int i2, String str, int i3) {
                            }
                        });
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + ell + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gz(arrayList);
                    a.this.oRx.showToast(a.this.oRx.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oRx.showToast(a.this.oRx.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emR().bw(a.this.oRx.getActivity(), a.this.oRx.getString(a.h.bd_im_error_msg_sheild_me_tips));
                }
            }
        });
        if (chatMsg != null) {
            k(chatMsg);
            LogUtils.i("ChatFragment", "errorCode:" + i + "--msg:" + chatMsg.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(ChatMsg chatMsg) {
        if (this.mMsgList != null) {
            Iterator<ChatMsg> it = this.mMsgList.iterator();
            while (it.hasNext()) {
                ChatMsg next = it.next();
                if (next.getSendMsgId().equals(chatMsg.getSendMsgId())) {
                    next.setStatus(0);
                    emj();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void Yr(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.oWl != null) {
            this.oWl.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        emj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, ChatMsg chatMsg, int i2) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "AAA " + i + "  " + chatMsg.getMsgId());
        if (i == -1 || chatMsg.getMsgType() == 1012) {
            return -1;
        }
        if (i2 == 10) {
            Iterator<ChatMsg> it = this.mMsgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatMsg next = it.next();
                if (chatMsg.getMsgId() == next.getMsgId() && chatMsg.getRowId() == next.getRowId()) {
                    Log.i("ChatFragment", "MSG_ID_FETCH_MSG message ==    " + chatMsg.getMsgId());
                    i = -1;
                    break;
                } else if (!TextUtils.isEmpty(chatMsg.getMsgKey()) && chatMsg.getMsgKey().equals(next.getMsgKey())) {
                    i = -1;
                    break;
                }
            }
        } else if (i2 == 4) {
            Iterator<ChatMsg> it2 = this.mMsgList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                ChatMsg next2 = it2.next();
                if (chatMsg.getMsgId() == next2.getMsgId()) {
                    Log.i("ChatFragment", "MSG_ID_RECEIVE_MSG message  duplicate  " + chatMsg.getMsgId());
                    i = -1;
                    break;
                } else if (!TextUtils.isEmpty(chatMsg.getMsgKey()) && chatMsg.getMsgKey().equals(next2.getMsgKey())) {
                    i = -1;
                    break;
                }
            }
        }
        if (i != -1) {
            Log.i("ChatFragment", "MSG_ID_RECEIVE_MSG message  add  " + chatMsg.getMsgId());
            this.mMsgList.add(i, chatMsg);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OS(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.oTH == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.oTM == 2) {
                        if (a.this.oWC + 5 > 20) {
                            i3 = a.this.oWC + 5;
                            a.this.oWD = 5;
                        } else {
                            a.this.oWD = 20 - a.this.oWC;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(a.this.oRx.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C || ChatInfo.oTH == ChatInfo.ChatCategory.B2C || ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.oWC + 5 > 20) {
                            i4 = a.this.oWC + 5;
                            a.this.oWD = 5;
                        } else {
                            a.this.oWD = 20 - a.this.oWC;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(a.this.oRx.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oTH != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(a.this.oRx.getApplicationContext(), 0, 17L, 20, null);
                }
                if (fetchMessageSyncWithState == null || fetchMessageSyncWithState.first == null) {
                    i2 = -1;
                } else {
                    i2 = ((Integer) fetchMessageSyncWithState.first).intValue();
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "status " + i2 + " ,time: " + i);
                if (i2 != 0 || i != 0) {
                    if (a.this.mTimer != null) {
                        a.this.mTimer.cancel();
                        a.this.mTimer = null;
                    }
                    a.this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.oWy != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.oWy.cancel();
                                a.this.oWy = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gB((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oTH == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hA(a.this.oRx.getApplicationContext()).e("416", "show", a.this.oWC, a.this.bp((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.eml();
                    }
                    a.this.oWB = true;
                    a.this.oWx = false;
                    a.this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.emn();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.oWz = 0;
                a.this.oWp.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void Ay(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.oWy = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oRx);
            this.oWy.setMessage(this.oRx.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.oWy.setCancelable(true);
            this.oWy.show();
        } else if (this.oWy != null) {
            this.oWy.dismiss();
        }
    }

    public void emm() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.oWz == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oRx;
            if (activityChat != null) {
                if (this.oWy != null) {
                    this.oWy.dismiss();
                }
                this.oWy = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.oWy.setMessage(this.oRx.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.oWy.setCancelable(true);
                this.oWy.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.OS(1);
                    }
                });
                this.oWy.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.oWz == 0) {
                            a.this.oWz = 1;
                            if (a.this.oWy != null) {
                                a.this.oWy.cancel();
                            }
                            a.this.OS(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emn() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oTH == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.oWx) {
                Yr(this.oRx.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emo() {
        if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            Yr(this.oRx.getString(a.h.bd_im_user_version_low));
        }
    }

    public void emp() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.oWB) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.emo();
                    }
                });
            }
        }).start();
    }

    public void emq() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            emj();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.oWp.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void ON(final int i) {
        String string = this.oRx.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oRx, this.oRx.getResources().getString(a.h.bd_im_group_reporttile), string, this.oRx.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oRx.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emJ();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.emJ();
                if (i < a.this.mMsgList.size()) {
                    ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.get(i);
                    String jsonContent = chatMsg.getJsonContent();
                    if (chatMsg.getMsgType() == 2 || chatMsg.getMsgType() == 1) {
                        try {
                            str = new JSONObject(jsonContent).optString("url");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = "";
                        }
                    } else {
                        if (chatMsg.getMsgType() == 0) {
                            try {
                                str = new JSONObject(jsonContent).optString("text");
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                        str = "";
                    }
                    LogUtils.d("ChatFragment", "report content: " + str);
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emR().showToast(a.this.oRx, a.this.oRx.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void emr() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oRx, this.oRx.getResources().getString(a.h.bd_im_space_title), this.oRx.getResources().getString(a.h.bd_im_space_prompt), this.oRx.getResources().getString(a.h.bd_im_space_chcek), this.oRx.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emJ();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emJ();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oTJ);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.elm().ch(jSONObject.toString(), 9);
            }
        });
    }

    private void ems() {
        this.oWt = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.oWz != 0) {
                    long enW = f.enW();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + enW);
                    if (enW < 300) {
                        a.this.oWp.post(new RunnableC0981a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.c.b.g(this.oRx, "check_sdcard", System.currentTimeMillis() / 1000);
        this.oWt.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ao(int i, boolean z) {
        if (this.bVM != null && !z) {
            this.oVp = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oRx, this.bVM, i, ChatInfo.mUid);
        }
        return this.oVp;
    }

    /* loaded from: classes11.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oXa;

        private e(a aVar) {
            this.oXa = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oXa.get() != null) {
                try {
                    if (!this.oXa.get().oRx.oVg) {
                        if (this.oXa.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oXa.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oTH == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oXa.get().oRx.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oXa.get().mMsgList.get(0));
                                } else if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C || ChatInfo.oTH == ChatInfo.ChatCategory.B2C || ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oXa.get().oRx.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oXa.get().mMsgList.get(0));
                                } else if (ChatInfo.oTH == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oXa.get().oRx.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oXa.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oXa.get().oRx.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.C2C || ChatInfo.oTH == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oXa.get().oRx.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oTH == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elm().fetchMessageSyncWithState(this.oXa.get().oRx.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oXa.get().oWm.setRefreshTime();
                        this.oXa.get().oWm.emX();
                        if (pair != null) {
                            this.oXa.get().gB((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oXa.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oXa.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oXa.get().q(true, currentTimeMillis);
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes11.dex */
    public static class d extends Handler {
        private final SoftReference<a> oXa;

        private d(a aVar) {
            this.oXa = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oXa.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oXa.get().mMsgList.add(chatMsg);
                                this.oXa.get().oWl.notifyDataSetChanged();
                                this.oXa.get().emi();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.oXa.get().oRx).a(chatMsg, this.oXa.get().mKey);
                                return;
                            }
                            return;
                        case 2:
                            T(message);
                            return;
                        case 3:
                            S(message);
                            return;
                        case 4:
                            V(message);
                            return;
                        case 5:
                            U(message);
                            return;
                        case 6:
                            this.oXa.get().mMsgList.clear();
                            this.oXa.get().oWl.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oXa.get().oWl != null) {
                                this.oXa.get().oWl.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oXa.get().oWl.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oXa.get().oWl.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oXa.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oXa.get().oWm.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oXa.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oXa.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oXa.get().oWl.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oXa.get().oWm != null) {
                                this.oXa.get().oWm.setSelection(this.oXa.get().oWm.getBottom());
                                return;
                            }
                            return;
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        default:
                            return;
                        case 20:
                            this.oXa.get().emm();
                            return;
                        case 30:
                            this.oXa.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oXa.get().oWm != null && this.oXa.get().oWC > 0) {
                                if (this.oXa.get().oWC + 5 > this.oXa.get().oWl.getCount()) {
                                    this.oXa.get().oWD = this.oXa.get().oWl.getCount() - this.oXa.get().oWC;
                                }
                                if (this.oXa.get().oWD < 3) {
                                    this.oXa.get().oWD = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oXa.get().oWD);
                                this.oXa.get().oWm.setSelection(this.oXa.get().oWD);
                                return;
                            }
                            return;
                        case 32:
                            this.oXa.get().oRx.showToast(this.oXa.get().oRx.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oXa.get().oRx.showToast(this.oXa.get().oRx.getString(a.h.bd_im_error_msg_sheild_me_tips));
                            return;
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }

        private void R(Message message) {
            boolean z;
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                long j = 0;
                if (arrayList == null || arrayList.size() < 20) {
                    this.oXa.get().oWm.setPullRefreshEnable(false);
                }
                if (arrayList != null) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        ChatMsg chatMsg = (ChatMsg) arrayList.get(i2);
                        if (chatMsg.getMsgType() == 1 && chatMsg.getStatus() == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.oXa.get().oRx).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oXa.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oXa.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oXa.get().mMsgList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = false;
                        break;
                    } else if (j == ((ChatMsg) it2.next()).getMsgId()) {
                        z = true;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z) {
                    if (this.oXa.get().oWx) {
                        this.oXa.get().oWl.notifyDataSetChanged();
                        this.oXa.get().OR(i4);
                        this.oXa.get().oWx = false;
                        return;
                    }
                    this.oXa.get().oWl.notifyDataSetChanged();
                    this.oXa.get().oWm.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oXa.get().oRx.oVg) {
                    BIMManager.mediaSendChatMsg(this.oXa.get().oRx, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Yt = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emD().Yt(((a) d.this.oXa.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oXa.get()).emg();
                            } else if (616 == i) {
                                ((a) d.this.oXa.get()).emh();
                            }
                            Yt.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.oXa.get().oRx).a(chatMsg, this.oXa.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oXa.get().mMsgList.add(chatMsg);
                this.oXa.get().oWl.notifyDataSetChanged();
                this.oXa.get().emi();
                if (this.oXa.get().oRx.oVg) {
                    BIMManager.mediaSendChatMsg(this.oXa.get().oRx, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Yt = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emD().Yt(((a) d.this.oXa.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oXa.get()).emg();
                            } else if (616 == i) {
                                ((a) d.this.oXa.get()).emh();
                            }
                            Yt.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.oXa.get().oRx).a(chatMsg, this.oXa.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oXa.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oXa.get().oWw.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oXa.get().j(chatMsg);
                        this.oXa.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oXa.get().oWm.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oXa.get().oWm.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oXa.get().oWm.getChildCount() - this.oXa.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oXa.get().oWl.K(this.oXa.get().oWm.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oXa.get().j(chatMsg);
                        ArrayList arrayList = this.oXa.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oXa.get().mMsgList.add(chatMsg);
                        }
                        this.oXa.get().oWw.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oXa.get().mMsgList.set(j, chatMsg);
                        this.oXa.get().oWw.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oXa.get().mMsgList.set(this.oXa.get().j(chatMsg), chatMsg);
                    }
                    this.oXa.get().oWl.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean emW = this.oXa.get().oWm.emW();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oXa.get().mMsgList.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (chatMsg.getMsgId() == ((ChatMsg) it.next()).getMsgId()) {
                            i2 = -1;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.oXa.get().a(i2, chatMsg, 4);
                    this.oXa.get().oWl.notifyDataSetChanged();
                    if (emW) {
                        this.oXa.get().emi();
                    } else if (ChatInfo.oTH == ChatInfo.ChatCategory.DUZHAN && this.oXa.get().oWG != null && this.oXa.get().oWB) {
                        this.oXa.get().oWG.elP();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class RunnableC0981a implements Runnable {
        private final SoftReference<a> oXa;

        private RunnableC0981a(a aVar) {
            this.oXa = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oXa.get() != null) {
                try {
                    this.oXa.get().emr();
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class b {
        public int mState;
        public int oXb;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oXc;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oXc = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Yj(localUrl);
                    return;
                }
                File cacheDir = com.baidu.yuyinala.privatemessage.implugin.util.a.c.getCacheDir();
                if (cacheDir != null && this.mMsg.getMsgId() != 0 && ((AudioMsg) this.mMsg).getRemoteUrl().length() > 6) {
                    this.mFilePath = cacheDir.getAbsolutePath() + File.separator + String.valueOf(this.mMsg.getMsgId());
                }
                str = ((AudioMsg) this.mMsg).getRemoteUrl();
            } else if (this.mMsg.getMsgType() == 1) {
                File cacheDir2 = com.baidu.yuyinala.privatemessage.implugin.util.a.c.getCacheDir();
                if (cacheDir2 != null && this.mMsg.getMsgId() != 0 && ((ImageMsg) this.mMsg).getRemoteUrl().length() > 6) {
                    this.mFilePath = cacheDir2.getAbsolutePath() + File.separator + String.valueOf(this.mMsg.getMsgId());
                }
                str = ((ImageMsg) this.mMsg).getRemoteUrl();
            }
            if (!TextUtils.isEmpty(this.mFilePath)) {
                if (new File(this.mFilePath).exists()) {
                    Yj(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.oXb = 1;
                a.this.oWv.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oRx.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oRx.showToast(a.this.oRx.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oRx.showToast(a.this.oRx.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.oWv.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.oWv.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oXb = 1;
                a.this.oWv.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oTJ) {
                this.mMsg.setStatus(2);
            }
            a.this.emj();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.emj();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Yj(String str) {
            a.this.oWv.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.oWq != null) {
                    boolean z = a.this.oWq.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.oWq.emt();
                    if (z) {
                        Ys(str);
                        return;
                    }
                    return;
                }
                Ys(str);
            }
        }

        public void Ys(String str) {
            a.this.oWq = this;
            try {
                a.this.cFn = new MediaPlayer();
                a.this.cFn.setOnCompletionListener(this);
                a.this.cFn.setDataSource(str);
                if (a.this.oWr) {
                    a.this.cFn.setAudioStreamType(3);
                } else {
                    a.this.cFn.setAudioStreamType(0);
                }
                a.this.cFn.prepare();
                a.this.cFn.start();
                Message obtainMessage = a.this.oWp.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void emt() {
            if (a.this.cFn != null) {
                a.this.cFn.stop();
                a.this.cFn.release();
                a.this.cFn = null;
                a.this.oWq = null;
                Message obtainMessage = a.this.oWp.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            emt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oRx.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oWm.setRefreshTime();
                            a.this.oWm.emX();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oRx.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oRx.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oWm.setRefreshTime();
                            a.this.oWm.emX();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z, List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.oWp.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
