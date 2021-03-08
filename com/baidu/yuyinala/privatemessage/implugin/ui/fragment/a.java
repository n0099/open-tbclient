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
/* loaded from: classes10.dex */
public class a implements SensorEventListener, a.InterfaceC0972a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private View bWp;
    private MediaPlayer cEx;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private ActivityChat oZL;
    private String oZX;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c pdG;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a peC;
    protected IMListView peD;
    protected TextView peE;
    private FrameLayout peF;
    private d peG;
    private boolean peJ;
    private c peL;
    private int peT;
    private boolean peW;
    private ActivityChat.c peX;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a peZ;
    private long pfd;
    private final int MAX_RETRY_NUM = 3;
    private c peH = null;
    private boolean peI = true;
    private Timer peK = null;
    private HashMap<Long, b> peM = new HashMap<>();
    private Set<Long> peN = new HashSet();
    private boolean peO = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d peP = null;
    private int peQ = 1;
    private Timer mTimer = null;
    private boolean peR = false;
    private boolean peS = false;
    private int peU = 0;
    private boolean peV = true;
    private BroadcastReceiver peY = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.peC.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener pav = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.elv().elx() != null) {
                d.elv().elx().elq();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b elx;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b ely = d.elv().ely();
            if (ely != null) {
                ely.elq();
            }
            if (Math.abs(f2) > 10.0f && (elx = d.elv().elx()) != null) {
                elx.elq();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver pfa = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.peL = d.elv().YG(a.this.mKey);
                if (a.this.peL != null) {
                    a.this.peL.ekS();
                }
            }
        }
    };
    private BroadcastReceiver pfb = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.peL = d.elv().YG(a.this.mKey);
                        if (a.this.peL != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.peL.i(chatMsg);
                            a.this.peL.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(a.this.oZL, e2);
                }
            }
        }
    };
    private BroadcastReceiver bNp = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.21
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
                    a.this.peL = d.elv().YG(a.this.mKey);
                    if (a.this.peL != null) {
                        a.this.peL.gw(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(a.this.oZL, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.peL = d.elv().YG(a.this.mKey);
                    if (a.this.peL != null) {
                        a.this.peL.gw(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(a.this.oZL, e3);
                }
            }
        }
    };
    private BroadcastReceiver pfc = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.peL = d.elv().YG(a.this.mKey);
                                if (a.this.peL != null) {
                                    a.this.peL.gx(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eke().c(a.this.oZL, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener pfe = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
        @Override // com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener
        public void onMediaChatMsgChangedResult(int i, long j, int i2, long j2, String str, long j3) {
            Log.d("ChatFragment", "BC> code=" + i + ", contactor=" + j + ", msgid=" + j3);
            if (i != 1) {
                if (i == 2) {
                    a.this.r(false, ((ChatMsg) a.this.mMsgList.get(a.this.mMsgList.size() - 1)).getMsgTime());
                } else if (i == 3 && j3 > 0 && a.this.mMsgList != null && a.this.mMsgList.size() > 0) {
                    for (int i3 = 0; i3 < a.this.mMsgList.size(); i3++) {
                        if (((ChatMsg) a.this.mMsgList.get(i3)).getMsgId() == j3) {
                            a.this.mMsgList.remove(i3);
                            a.this.elb();
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
        this.peT = 0;
        this.mKey = "";
        this.peX = null;
        this.peX = cVar;
        this.mKey = str;
        this.peT = i;
        this.oZL = activityChat;
        d.elv().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.peG = new d();
        this.mMsgList.clear();
        this.peM.clear();
        this.peN.clear();
        ekV();
        if (f.hI(this.oZL)) {
            elk();
        }
        ekP();
        this.bWp = view;
        am(this.bWp);
        if (this.oZL.pdx) {
            r(true, System.currentTimeMillis());
        } else {
            NL(0);
        }
        initSensor();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oZL.getApplicationContext(), this.pfe);
    }

    private void ekP() {
        if (!this.peW) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oZL.registerReceiver(this.peY, intentFilter);
            this.peW = true;
        }
    }

    private void ekQ() {
        if (this.peW) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oZL.unregisterReceiver(this.peY);
            this.peW = false;
        }
    }

    public void onPause() {
        this.mSensorManager.unregisterListener(this);
        this.peR = true;
        ekU();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oZL.getApplicationContext(), this.pfe);
        d.elv().YH(this.mKey);
        if (this.peK != null) {
            this.peK.cancel();
        }
        if (this.peP != null) {
            this.peP.dismiss();
        }
        ekW();
        ThemeManager.b(this);
        ekQ();
        ekR();
        if (this.oZL.pdx) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oZL, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void ekR() {
        Map<Long, h> ekk;
        if (ChatInfo.pbX == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.pcR && (ekk = k.hB(this.oZL).ekk()) != null && !ekk.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : ekk.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.ekh());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.B(this.oZL, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkw, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(this.oZL, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pkx, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.pbX == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.peR && ChatInfo.mStatus == 3) {
            if (ChatInfo.pbX == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.oZL.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C || ChatInfo.pbX == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.oZL.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.pbX == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.oZL.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    ekT();
                    elb();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        ekT();
                        gz((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            elb();
                        }
                    } else {
                        elb();
                    }
                }
            }
        }
        this.peR = false;
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void onStart() {
    }

    private void initSensor() {
        this.mSensorManager = (SensorManager) this.oZL.getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void am(View view) {
        this.mGestureDetector = new GestureDetector(this.oZL, this.pav);
        this.peF = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.peD = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.peE = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hy = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().hy(this.oZL.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hy);
        try {
            this.oZX = new JSONObject(hy).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hy);
        this.peC = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oZL, this.mMsgList, this, this, this, this, this.peX, this.oZX);
        this.peC.a(this.oZL);
        this.peD.setPullRefreshEnable(true);
        this.peD.setIMListViewListener(this);
        this.peD.setAdapter((ListAdapter) this.peC);
        this.peD.setSelector(new ColorDrawable(0));
        this.peD.setTranscriptMode(1);
        this.peD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
            this.peI = false;
        } else {
            this.peI = true;
        }
        if (this.peH != null && this.peJ != this.peI) {
            ChatMsg chatMsg = this.peH.mMsg;
            View view = this.peH.mView;
            Boolean valueOf = Boolean.valueOf(this.peH.pft);
            this.peH.ell();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.peI) {
                elc();
            }
        }
        this.peJ = this.peI;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.peG.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.peN.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oZL.getApplicationContext())) {
            a(3, chatMsg);
            ekX();
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
            if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().cj(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        ImBaseEntity ekD;
        if (!(this.oZL instanceof ActivityChat) || !this.oZL.ekA()) {
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
                if ((chatMsg instanceof SignleGraphicTextMsg) && new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).emV() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE && (this.oZL instanceof ActivityChat) && (ekD = this.oZL.ekD()) != null && ekD.mVideoEntity != null && !ekD.mVideoEntity.isShared) {
                    String str = ekD.mVideoEntity.id;
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
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oZL.getApplicationContext())) {
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
    public void gw(final List<ChatMsg> list) {
        this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.peO && ChatInfo.mStatus == 3) {
                    a.this.gy(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekS() {
        this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.peQ == 0) {
                    a.this.peQ = 1;
                    a.this.mMsgList.clear();
                    if (a.this.peP != null) {
                        a.this.peP.cancel();
                    }
                    a.this.NL(1);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void gx(List<Long> list) {
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.eke().deleteMsg(this.oZL.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                elb();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekT() {
        this.mMsgList.clear();
        elb();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0972a
    public void NG(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oZL, this.oZL.getResources().getString(a.h.bd_im_alertdialog_title), this.oZL.getResources().getString(a.h.bd_im_alertdialog_tip), this.oZL.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oZL.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elB();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a pff;
        final /* synthetic */ int pfg;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.pff = aVar;
            this.pfg = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.pff.elB();
            if (this.pfg < 0 || this.pfg >= a.this.mMsgList.size()) {
                a.this.oZL.showToast(a.this.oZL.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.pfg);
            if (!a.this.oZL.pdx) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.eke().deleteMsg(a.this.oZL.getApplicationContext(), chatMsg);
                if (a.this.peH != null && a.this.peH.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.peH.ell();
                }
                a.this.elb();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oZL, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.peH != null && a.this.peH.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.peH.ell();
                                }
                                a.this.elb();
                            }
                        });
                    }
                }
            });
        }
    }

    public void ekU() {
        if (this.peH != null) {
            this.peH.ell();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.peD.elP();
        this.peD.elQ();
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
        this.peZ = aVar;
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
                    this.oZL.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void ekV() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oZL.registerReceiver(this.bNp, intentFilter);
        this.oZL.registerReceiver(this.pfc, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oZL.registerReceiver(this.pfa, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oZL.registerReceiver(this.pfb, new IntentFilter("implugin.update.message"));
    }

    private void ekW() {
        this.oZL.unregisterReceiver(this.bNp);
        this.oZL.unregisterReceiver(this.pfc);
        this.oZL.unregisterReceiver(this.pfa);
        this.oZL.unregisterReceiver(this.pfb);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.peH != null && this.peH.mMsg.getRowId() != chatMsg.getRowId()) {
            this.peH.ell();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.pbZ) {
            if (this.peH == null) {
                this.peH = new c(chatMsg, view, z);
                this.peH.YF(chatMsg.getLocalUrl());
                return;
            }
            this.peH.ell();
        } else if (this.peM.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.peM.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.peM.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.pfs < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.pfs++;
                this.peM.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.eke().markMsgClicked(this.oZL.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN && this.peV && chatMsg.getStatus() == 0) {
            bj(this.mMsgList);
            this.peV = false;
        }
    }

    public String bj(ArrayList<ChatMsg> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getFromUser() == ChatInfo.mPaid) {
                return arrayList.get(size).getExtLog();
            }
        }
        return null;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekX() {
        ela();
    }

    public void ekY() {
        this.peG.obtainMessage(32).sendToTarget();
    }

    public void ekZ() {
        this.peG.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ela() {
        Message obtainMessage = this.peG.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void NJ(int i) {
        Message obtainMessage = this.peG.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NK(int i) {
        Message obtainMessage = this.peG.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elb() {
        this.peG.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.peG.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void elc() {
        this.peG.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.peG.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.peG.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eld() {
        if (ChatInfo.pbX == ChatInfo.ChatCategory.SMART && this.oZL != null) {
            this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.peE.setVisibility(0);
                    a.this.peD.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.pfd == chatMsg.getMsgId()) {
                            a.this.oZL.showToast(a.this.oZL.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.pfd = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oZL);
                        BIMManager.tryConnection(a.this.oZL);
                        String ekd = com.baidu.yuyinala.privatemessage.implugin.d.a.ekd();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(ekd, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + ekd + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gx(arrayList);
                    a.this.oZL.showToast(a.this.oZL.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oZL.showToast(a.this.oZL.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().bu(a.this.oZL.getActivity(), a.this.oZL.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    elb();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void YE(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.peC != null) {
            this.peC.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        elb();
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
    public void NL(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.pbX == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.pcc == 2) {
                        if (a.this.peT + 5 > 20) {
                            i3 = a.this.peT + 5;
                            a.this.peU = 5;
                        } else {
                            a.this.peU = 20 - a.this.peT;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(a.this.oZL.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C || ChatInfo.pbX == ChatInfo.ChatCategory.B2C || ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.peT + 5 > 20) {
                            i4 = a.this.peT + 5;
                            a.this.peU = 5;
                        } else {
                            a.this.peU = 20 - a.this.peT;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(a.this.oZL.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.pbX != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(a.this.oZL.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.peP != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.peP.cancel();
                                a.this.peP = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gz((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN || ChatInfo.pbX == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hA(a.this.oZL.getApplicationContext()).e("416", "show", a.this.peT, a.this.bj((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.eld();
                    }
                    a.this.peS = true;
                    a.this.peO = false;
                    a.this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.elf();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.peQ = 0;
                a.this.peG.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void AM(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.peP = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oZL);
            this.peP.setMessage(this.oZL.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.peP.setCancelable(true);
            this.peP.show();
        } else if (this.peP != null) {
            this.peP.dismiss();
        }
    }

    public void ele() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.peQ == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oZL;
            if (activityChat != null) {
                if (this.peP != null) {
                    this.peP.dismiss();
                }
                this.peP = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.peP.setMessage(this.oZL.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.peP.setCancelable(true);
                this.peP.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.NL(1);
                    }
                });
                this.peP.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.peQ == 0) {
                            a.this.peQ = 1;
                            if (a.this.peP != null) {
                                a.this.peP.cancel();
                            }
                            a.this.NL(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elf() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.pbX == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.peO) {
                YE(this.oZL.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void elg() {
        if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            YE(this.oZL.getString(a.h.bd_im_user_version_low));
        }
    }

    public void elh() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.peS) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.elg();
                    }
                });
            }
        }).start();
    }

    public void eli() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            elb();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.peG.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void NH(final int i) {
        String string = this.oZL.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oZL, this.oZL.getResources().getString(a.h.bd_im_group_reporttile), string, this.oZL.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oZL.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elB();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.elB();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elJ().showToast(a.this.oZL, a.this.oZL.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void elj() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oZL, this.oZL.getResources().getString(a.h.bd_im_space_title), this.oZL.getResources().getString(a.h.bd_im_space_prompt), this.oZL.getResources().getString(a.h.bd_im_space_chcek), this.oZL.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elB();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elB();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.pbZ);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.eke().cj(jSONObject.toString(), 9);
            }
        });
    }

    private void elk() {
        this.peK = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.peQ != 0) {
                    long emL = f.emL();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + emL);
                    if (emL < 300) {
                        a.this.peG.post(new RunnableC0976a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.c.b.g(this.oZL, "check_sdcard", System.currentTimeMillis() / 1000);
        this.peK.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ao(int i, boolean z) {
        if (this.bWp != null && !z) {
            this.pdG = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oZL, this.bWp, i, ChatInfo.mUid);
        }
        return this.pdG;
    }

    /* loaded from: classes10.dex */
    private static class e implements Runnable {
        private final SoftReference<a> pfr;

        private e(a aVar) {
            this.pfr = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.pfr.get() != null) {
                try {
                    if (!this.pfr.get().oZL.pdx) {
                        if (this.pfr.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.pfr.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.pbX == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.pfr.get().oZL.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.pfr.get().mMsgList.get(0));
                                } else if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C || ChatInfo.pbX == ChatInfo.ChatCategory.B2C || ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.pfr.get().oZL.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.pfr.get().mMsgList.get(0));
                                } else if (ChatInfo.pbX == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.pfr.get().oZL.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.pfr.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.pbX == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.pfr.get().oZL.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.pbX == ChatInfo.ChatCategory.C2C || ChatInfo.pbX == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.pfr.get().oZL.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.pbX == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eke().fetchMessageSyncWithState(this.pfr.get().oZL.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.pfr.get().peD.setRefreshTime();
                        this.pfr.get().peD.elP();
                        if (pair != null) {
                            this.pfr.get().gz((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.pfr.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.pfr.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.pfr.get().r(true, currentTimeMillis);
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes10.dex */
    public static class d extends Handler {
        private final SoftReference<a> pfr;

        private d(a aVar) {
            this.pfr = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pfr.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.pfr.get().mMsgList.add(chatMsg);
                                this.pfr.get().peC.notifyDataSetChanged();
                                this.pfr.get().ela();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.pfr.get().oZL).a(chatMsg, this.pfr.get().mKey);
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
                            this.pfr.get().mMsgList.clear();
                            this.pfr.get().peC.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.pfr.get().peC != null) {
                                this.pfr.get().peC.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.pfr.get().peC.aW(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.pfr.get().peC.aX(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.pfr.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.pfr.get().peD.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.pfr.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.pfr.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.pfr.get().peC.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.pfr.get().peD != null) {
                                this.pfr.get().peD.setSelection(this.pfr.get().peD.getBottom());
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
                            this.pfr.get().ele();
                            return;
                        case 30:
                            this.pfr.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.pfr.get().peD != null && this.pfr.get().peT > 0) {
                                if (this.pfr.get().peT + 5 > this.pfr.get().peC.getCount()) {
                                    this.pfr.get().peU = this.pfr.get().peC.getCount() - this.pfr.get().peT;
                                }
                                if (this.pfr.get().peU < 3) {
                                    this.pfr.get().peU = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.pfr.get().peU);
                                this.pfr.get().peD.setSelection(this.pfr.get().peU);
                                return;
                            }
                            return;
                        case 32:
                            this.pfr.get().oZL.showToast(this.pfr.get().oZL.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.pfr.get().oZL.showToast(this.pfr.get().oZL.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.pfr.get().peD.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.pfr.get().oZL).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.pfr.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.pfr.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.pfr.get().mMsgList.iterator();
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
                    if (this.pfr.get().peO) {
                        this.pfr.get().peC.notifyDataSetChanged();
                        this.pfr.get().NK(i4);
                        this.pfr.get().peO = false;
                        return;
                    }
                    this.pfr.get().peC.notifyDataSetChanged();
                    this.pfr.get().peD.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.pfr.get().oZL.pdx) {
                    BIMManager.mediaSendChatMsg(this.pfr.get().oZL, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c YG = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elv().YG(((a) d.this.pfr.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.pfr.get()).ekY();
                            } else if (616 == i) {
                                ((a) d.this.pfr.get()).ekZ();
                            }
                            YG.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.pfr.get().oZL).a(chatMsg, this.pfr.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.pfr.get().mMsgList.add(chatMsg);
                this.pfr.get().peC.notifyDataSetChanged();
                this.pfr.get().ela();
                if (this.pfr.get().oZL.pdx) {
                    BIMManager.mediaSendChatMsg(this.pfr.get().oZL, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c YG = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.elv().YG(((a) d.this.pfr.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.pfr.get()).ekY();
                            } else if (616 == i) {
                                ((a) d.this.pfr.get()).ekZ();
                            }
                            YG.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hu(this.pfr.get().oZL).a(chatMsg, this.pfr.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.pfr.get().j(chatMsg);
                if (j != -1) {
                    if (!this.pfr.get().peN.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.pfr.get().j(chatMsg);
                        this.pfr.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.pfr.get().peD.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.pfr.get().peD.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.pfr.get().peD.getChildCount() - this.pfr.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.pfr.get().peC.K(this.pfr.get().peD.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.pfr.get().j(chatMsg);
                        ArrayList arrayList = this.pfr.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.pfr.get().mMsgList.add(chatMsg);
                        }
                        this.pfr.get().peN.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.pfr.get().mMsgList.set(j, chatMsg);
                        this.pfr.get().peN.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.pfr.get().mMsgList.set(this.pfr.get().j(chatMsg), chatMsg);
                    }
                    this.pfr.get().peC.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean elO = this.pfr.get().peD.elO();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.pfr.get().mMsgList.iterator();
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
                    this.pfr.get().a(i2, chatMsg, 4);
                    this.pfr.get().peC.notifyDataSetChanged();
                    if (elO) {
                        this.pfr.get().ela();
                    } else if (ChatInfo.pbX == ChatInfo.ChatCategory.DUZHAN && this.pfr.get().peX != null && this.pfr.get().peS) {
                        this.pfr.get().peX.ekH();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class RunnableC0976a implements Runnable {
        private final SoftReference<a> pfr;

        private RunnableC0976a(a aVar) {
            this.pfr = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pfr.get() != null) {
                try {
                    this.pfr.get().elj();
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b {
        public int mState;
        public int pfs;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean pft;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.pft = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Yw(localUrl);
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
                    Yw(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.pfs = 1;
                a.this.peM.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oZL.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oZL.showToast(a.this.oZL.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oZL.showToast(a.this.oZL.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.peM.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.peM.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.pfs = 1;
                a.this.peM.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.pbZ) {
                this.mMsg.setStatus(2);
            }
            a.this.elb();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.elb();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Yw(String str) {
            a.this.peM.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.peH != null) {
                    boolean z = a.this.peH.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.peH.ell();
                    if (z) {
                        YF(str);
                        return;
                    }
                    return;
                }
                YF(str);
            }
        }

        public void YF(String str) {
            a.this.peH = this;
            try {
                a.this.cEx = new MediaPlayer();
                a.this.cEx.setOnCompletionListener(this);
                a.this.cEx.setDataSource(str);
                if (a.this.peI) {
                    a.this.cEx.setAudioStreamType(3);
                } else {
                    a.this.cEx.setAudioStreamType(0);
                }
                a.this.cEx.prepare();
                a.this.cEx.start();
                Message obtainMessage = a.this.peG.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void ell() {
            if (a.this.cEx != null) {
                a.this.cEx.stop();
                a.this.cEx.release();
                a.this.cEx = null;
                a.this.peH = null;
                Message obtainMessage = a.this.peG.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            ell();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oZL.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.peD.setRefreshTime();
                            a.this.peD.elP();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.j(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oZL.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oZL.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.peD.setRefreshTime();
                            a.this.peD.elP();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.j(z, list);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.peG.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
