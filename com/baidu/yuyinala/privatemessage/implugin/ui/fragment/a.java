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
import com.baidu.tbadk.TbConfig;
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
/* loaded from: classes4.dex */
public class a implements SensorEventListener, a.InterfaceC0963a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private SensorManager bGk;
    private Sensor bGm;
    private MediaPlayer cAx;
    private View kTH;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private String oLA;
    private ActivityChat oLo;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oPf;
    private long oQC;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a oQb;
    protected IMListView oQc;
    protected TextView oQd;
    private FrameLayout oQe;
    private d oQf;
    private boolean oQi;
    private c oQk;
    private int oQs;
    private boolean oQv;
    private ActivityChat.c oQw;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a oQy;
    private final int MAX_RETRY_NUM = 3;
    private c oQg = null;
    private boolean oQh = true;
    private Timer oQj = null;
    private HashMap<Long, b> oQl = new HashMap<>();
    private Set<Long> oQm = new HashSet();
    private boolean oQn = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d oQo = null;
    private int oQp = 1;
    private Timer mTimer = null;
    private boolean oQq = false;
    private boolean oQr = false;
    private int oQt = 0;
    private boolean oQu = true;
    private BroadcastReceiver oQx = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.oQb.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener oLY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.emA().emC() != null) {
                d.emA().emC().emv();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b emC;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b emD = d.emA().emD();
            if (emD != null) {
                emD.emv();
            }
            if (Math.abs(f2) > 10.0f && (emC = d.emA().emC()) != null) {
                emC.emv();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver oQz = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.oQk = d.emA().YK(a.this.mKey);
                if (a.this.oQk != null) {
                    a.this.oQk.elW();
                }
            }
        }
    };
    private BroadcastReceiver oQA = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.oQk = d.emA().YK(a.this.mKey);
                        if (a.this.oQk != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.oQk.i(chatMsg);
                            a.this.oQk.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(a.this.oLo, e2);
                }
            }
        }
    };
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.21
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
                    a.this.oQk = d.emA().YK(a.this.mKey);
                    if (a.this.oQk != null) {
                        a.this.oQk.gG(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(a.this.oLo, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.oQk = d.emA().YK(a.this.mKey);
                    if (a.this.oQk != null) {
                        a.this.oQk.gG(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(a.this.oLo, e3);
                }
            }
        }
    };
    private BroadcastReceiver oQB = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.oQk = d.emA().YK(a.this.mKey);
                                if (a.this.oQk != null) {
                                    a.this.oQk.gH(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elh().c(a.this.oLo, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener oQD = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
        @Override // com.baidu.android.imsdk.chatmessage.IMediaChatMsgChangedListener
        public void onMediaChatMsgChangedResult(int i, long j, int i2, long j2, String str, long j3) {
            Log.d("ChatFragment", "BC> code=" + i + ", contactor=" + j + ", msgid=" + j3);
            if (i != 1) {
                if (i == 2) {
                    a.this.j(false, ((ChatMsg) a.this.mMsgList.get(a.this.mMsgList.size() - 1)).getMsgTime());
                } else if (i == 3 && j3 > 0 && a.this.mMsgList != null && a.this.mMsgList.size() > 0) {
                    for (int i3 = 0; i3 < a.this.mMsgList.size(); i3++) {
                        if (((ChatMsg) a.this.mMsgList.get(i3)).getMsgId() == j3) {
                            a.this.mMsgList.remove(i3);
                            a.this.emf();
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
        this.oQs = 0;
        this.mKey = "";
        this.oQw = null;
        this.oQw = cVar;
        this.mKey = str;
        this.oQs = i;
        this.oLo = activityChat;
        d.emA().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.oQf = new d();
        this.mMsgList.clear();
        this.oQl.clear();
        this.oQm.clear();
        elZ();
        if (f.hv(this.oLo)) {
            emo();
        }
        elS();
        this.kTH = view;
        an(this.kTH);
        if (this.oLo.oOW) {
            j(true, System.currentTimeMillis());
        } else {
            Pd(0);
        }
        elV();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oLo.getApplicationContext(), this.oQD);
    }

    private void elS() {
        if (!this.oQv) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oLo.registerReceiver(this.oQx, intentFilter);
            this.oQv = true;
        }
    }

    private void elT() {
        if (this.oQv) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oLo.unregisterReceiver(this.oQx);
            this.oQv = false;
        }
    }

    public void onPause() {
        this.bGk.unregisterListener(this);
        this.oQq = true;
        elY();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oLo.getApplicationContext(), this.oQD);
        d.emA().YL(this.mKey);
        if (this.oQj != null) {
            this.oQj.cancel();
        }
        if (this.oQo != null) {
            this.oQo.dismiss();
        }
        ema();
        ThemeManager.b(this);
        elT();
        elU();
        if (this.oLo.oOW) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oLo, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void elU() {
        Map<Long, h> eln;
        if (ChatInfo.oNz == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.oOq && (eln = k.hm(this.oLo).eln()) != null && !eln.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : eln.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.elk());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.C(this.oLo, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVT, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(this.oLo, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVU, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oNz == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.oQq && ChatInfo.mStatus == 3) {
            if (ChatInfo.oNz == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oLo.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C || ChatInfo.oNz == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oLo.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oNz == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oLo.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    elX();
                    emf();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        elX();
                        gJ((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            emf();
                        }
                    } else {
                        emf();
                    }
                }
            }
        }
        this.oQq = false;
        this.bGk.registerListener(this, this.bGm, 3);
    }

    public void onStart() {
    }

    private void elV() {
        this.bGk = (SensorManager) this.oLo.getSystemService("sensor");
        this.bGm = this.bGk.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void an(View view) {
        this.mGestureDetector = new GestureDetector(this.oLo, this.oLY);
        this.oQe = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.oQc = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.oQd = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hj = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().hj(this.oLo.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hj);
        try {
            this.oLA = new JSONObject(hj).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hj);
        this.oQb = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oLo, this.mMsgList, this, this, this, this, this.oQw, this.oLA);
        this.oQb.a(this.oLo);
        this.oQc.setPullRefreshEnable(true);
        this.oQc.setIMListViewListener(this);
        this.oQc.setAdapter((ListAdapter) this.oQb);
        this.oQc.setSelector(new ColorDrawable(0));
        this.oQc.setTranscriptMode(1);
        this.oQc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
        if (sensorEvent.values[0] < this.bGm.getMaximumRange()) {
            this.oQh = false;
        } else {
            this.oQh = true;
        }
        if (this.oQg != null && this.oQi != this.oQh) {
            ChatMsg chatMsg = this.oQg.mMsg;
            View view = this.oQg.mView;
            Boolean valueOf = Boolean.valueOf(this.oQg.oQS);
            this.oQg.emp();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.oQh) {
                emg();
            }
        }
        this.oQi = this.oQh;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.oQf.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.oQm.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oLo.getApplicationContext())) {
            a(3, chatMsg);
            emb();
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
            if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().bZ(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        String str;
        String str2;
        String str3;
        ImBaseEntity elG;
        if ((this.oLo instanceof ActivityChat) && this.oLo.elD()) {
            String str4 = "";
            String str5 = "";
            switch (chatMsg.getMsgType()) {
                case 0:
                    str = null;
                    str2 = "text";
                    str3 = "other";
                    break;
                case 1:
                    str = null;
                    str2 = "graph";
                    str3 = "other";
                    break;
                case 2:
                    str = null;
                    str2 = "voice";
                    str3 = "other";
                    break;
                case 8:
                    if (chatMsg instanceof SignleGraphicTextMsg) {
                        if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).eoa() != SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE || !(this.oLo instanceof ActivityChat) || (elG = this.oLo.elG()) == null || elG.mVideoEntity == null) {
                            str = null;
                        } else if (elG.mVideoEntity.isShared) {
                            str4 = TbConfig.TMP_SHARE_DIR_NAME;
                            str5 = "video";
                            str = null;
                        } else {
                            str4 = "other";
                            str5 = "video";
                            str = elG.mVideoEntity.id;
                        }
                        str2 = str5;
                        str3 = str4;
                        break;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                default:
                    str = null;
                    str2 = "";
                    str3 = "";
                    break;
            }
            com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.a(str, "notice", "fsq_msg_send", com.baidu.yuyinala.privatemessage.implugin.a.ekW().bip(), com.baidu.yuyinala.privatemessage.implugin.a.ekW().getTag(), str3, null, com.baidu.yuyinala.privatemessage.implugin.a.ekW().ekU(), com.baidu.yuyinala.privatemessage.implugin.a.ekW().ekV(), str2, null, null, String.valueOf(chatMsg.getContacter())), false);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void h(ChatMsg chatMsg) {
        if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND + chatMsg.toString());
        }
        g(chatMsg);
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oLo.getApplicationContext())) {
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
    public void gG(final List<ChatMsg> list) {
        this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.oQn && ChatInfo.mStatus == 3) {
                    a.this.gI(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void elW() {
        this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.oQp == 0) {
                    a.this.oQp = 1;
                    a.this.mMsgList.clear();
                    if (a.this.oQo != null) {
                        a.this.oQo.cancel();
                    }
                    a.this.Pd(1);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void gH(List<Long> list) {
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elh().deleteMsg(this.oLo.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                emf();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void elX() {
        this.mMsgList.clear();
        emf();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0963a
    public void OX(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oLo, this.oLo.getResources().getString(a.h.bd_im_alertdialog_title), this.oLo.getResources().getString(a.h.bd_im_alertdialog_tip), this.oLo.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oLo.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emG();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a oQE;
        final /* synthetic */ int oQF;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.oQE = aVar;
            this.oQF = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.oQE.emG();
            if (this.oQF < 0 || this.oQF >= a.this.mMsgList.size()) {
                a.this.oLo.showToast(a.this.oLo.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.oQF);
            if (!a.this.oLo.oOW) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().deleteMsg(a.this.oLo.getApplicationContext(), chatMsg);
                if (a.this.oQg != null && a.this.oQg.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.oQg.emp();
                }
                a.this.emf();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oLo, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.oQg != null && a.this.oQg.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.oQg.emp();
                                }
                                a.this.emf();
                            }
                        });
                    }
                }
            });
        }
    }

    public void elY() {
        if (this.oQg != null) {
            this.oQg.emp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.oQc.emU();
        this.oQc.emV();
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
        this.oQy = aVar;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.b
    @SuppressLint({"NewApi"})
    public void f(View view, int i, boolean z) {
        ChatMsg chatMsg = null;
        if (i >= 0 && i < this.mMsgList.size()) {
            chatMsg = this.mMsgList.get(i);
        }
        if (chatMsg != null) {
            switch (chatMsg.getMsgType()) {
                case 1:
                case 2:
                case 8:
                    this.oLo.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void elZ() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oLo.registerReceiver(this.mReceiver, intentFilter);
        this.oLo.registerReceiver(this.oQB, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oLo.registerReceiver(this.oQz, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oLo.registerReceiver(this.oQA, new IntentFilter("implugin.update.message"));
    }

    private void ema() {
        this.oLo.unregisterReceiver(this.mReceiver);
        this.oLo.unregisterReceiver(this.oQB);
        this.oLo.unregisterReceiver(this.oQz);
        this.oLo.unregisterReceiver(this.oQA);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.oQg != null && this.oQg.mMsg.getRowId() != chatMsg.getRowId()) {
            this.oQg.emp();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oNB) {
            if (this.oQg == null) {
                this.oQg = new c(chatMsg, view, z);
                this.oQg.YJ(chatMsg.getLocalUrl());
                return;
            }
            this.oQg.emp();
        } else if (this.oQl.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.oQl.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.oQl.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oQR < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oQR++;
                this.oQl.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().markMsgClicked(this.oLo.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN && this.oQu && chatMsg.getStatus() == 0) {
            bq(this.mMsgList);
            this.oQu = false;
        }
    }

    public String bq(ArrayList<ChatMsg> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getFromUser() == ChatInfo.mPaid) {
                return arrayList.get(size).getExtLog();
            }
        }
        return null;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void emb() {
        eme();
    }

    public void emc() {
        this.oQf.obtainMessage(32).sendToTarget();
    }

    public void emd() {
        this.oQf.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eme() {
        Message obtainMessage = this.oQf.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void Pb(int i) {
        Message obtainMessage = this.oQf.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc(int i) {
        Message obtainMessage = this.oQf.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emf() {
        this.oQf.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.oQf.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void emg() {
        this.oQf.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.oQf.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.oQf.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emh() {
        if (ChatInfo.oNz == ChatInfo.ChatCategory.SMART && this.oLo != null) {
            this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oQd.setVisibility(0);
                    a.this.oQc.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.oQC == chatMsg.getMsgId()) {
                            a.this.oLo.showToast(a.this.oLo.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.oQC = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oLo);
                        BIMManager.tryConnection(a.this.oLo);
                        String elg = com.baidu.yuyinala.privatemessage.implugin.d.a.elg();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(elg, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + elg + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gH(arrayList);
                    a.this.oLo.showToast(a.this.oLo.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oLo.showToast(a.this.oLo.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().br(a.this.oLo.getActivity(), a.this.oLo.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    emf();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void YI(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.oQb != null) {
            this.oQb.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        emf();
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
    public void Pd(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.oNz == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.kpk == 2) {
                        if (a.this.oQs + 5 > 20) {
                            i3 = a.this.oQs + 5;
                            a.this.oQt = 5;
                        } else {
                            a.this.oQt = 20 - a.this.oQs;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(a.this.oLo.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C || ChatInfo.oNz == ChatInfo.ChatCategory.B2C || ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.oQs + 5 > 20) {
                            i4 = a.this.oQs + 5;
                            a.this.oQt = 5;
                        } else {
                            a.this.oQt = 20 - a.this.oQs;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(a.this.oLo.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oNz != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(a.this.oLo.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.oQo != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.oQo.cancel();
                                a.this.oQo = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gJ((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oNz == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hl(a.this.oLo.getApplicationContext()).e("416", "show", a.this.oQs, a.this.bq((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.emh();
                    }
                    a.this.oQr = true;
                    a.this.oQn = false;
                    a.this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.emj();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.oQp = 0;
                a.this.oQf.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void Ay(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.oQo = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oLo);
            this.oQo.setMessage(this.oLo.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.oQo.setCancelable(true);
            this.oQo.show();
        } else if (this.oQo != null) {
            this.oQo.dismiss();
        }
    }

    public void emi() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.oQp == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oLo;
            if (activityChat != null) {
                if (this.oQo != null) {
                    this.oQo.dismiss();
                }
                this.oQo = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.oQo.setMessage(this.oLo.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.oQo.setCancelable(true);
                this.oQo.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.Pd(1);
                    }
                });
                this.oQo.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.oQp == 0) {
                            a.this.oQp = 1;
                            if (a.this.oQo != null) {
                                a.this.oQo.cancel();
                            }
                            a.this.Pd(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emj() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oNz == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.oQn) {
                YI(this.oLo.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emk() {
        if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            YI(this.oLo.getString(a.h.bd_im_user_version_low));
        }
    }

    public void eml() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.oQr) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.emk();
                    }
                });
            }
        }).start();
    }

    public void emm() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            emf();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.oQf.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void OY(final int i) {
        String string = this.oLo.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oLo, this.oLo.getResources().getString(a.h.bd_im_group_reporttile), string, this.oLo.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oLo.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emG();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.emG();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emO().showToast(a.this.oLo, a.this.oLo.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void emn() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oLo, this.oLo.getResources().getString(a.h.bd_im_space_title), this.oLo.getResources().getString(a.h.bd_im_space_prompt), this.oLo.getResources().getString(a.h.bd_im_space_chcek), this.oLo.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emG();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emG();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oNB);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.elh().bZ(jSONObject.toString(), 9);
            }
        });
    }

    private void emo() {
        this.oQj = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.oQp != 0) {
                    long enT = f.enT();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + enT);
                    if (enT < 300) {
                        a.this.oQf.post(new RunnableC0967a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.b.b.g(this.oLo, "check_sdcard", System.currentTimeMillis() / 1000);
        this.oQj.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c aq(int i, boolean z) {
        if (this.kTH != null && !z) {
            this.oPf = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oLo, this.kTH, i, ChatInfo.mUid);
        }
        return this.oPf;
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oQQ;

        private e(a aVar) {
            this.oQQ = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oQQ.get() != null) {
                try {
                    if (!this.oQQ.get().oLo.oOW) {
                        if (this.oQQ.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oQQ.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oNz == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oQQ.get().oLo.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oQQ.get().mMsgList.get(0));
                                } else if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C || ChatInfo.oNz == ChatInfo.ChatCategory.B2C || ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oQQ.get().oLo.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oQQ.get().mMsgList.get(0));
                                } else if (ChatInfo.oNz == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oQQ.get().oLo.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oQQ.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oNz == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oQQ.get().oLo.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oNz == ChatInfo.ChatCategory.C2C || ChatInfo.oNz == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oQQ.get().oLo.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oNz == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elh().fetchMessageSyncWithState(this.oQQ.get().oLo.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oQQ.get().oQc.setRefreshTime();
                        this.oQQ.get().oQc.emU();
                        if (pair != null) {
                            this.oQQ.get().gJ((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oQQ.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oQQ.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oQQ.get().j(true, currentTimeMillis);
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes4.dex */
    public static class d extends Handler {
        private final SoftReference<a> oQQ;

        private d(a aVar) {
            this.oQQ = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oQQ.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oQQ.get().mMsgList.add(chatMsg);
                                this.oQQ.get().oQb.notifyDataSetChanged();
                                this.oQQ.get().eme();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQQ.get().oLo).a(chatMsg, this.oQQ.get().mKey);
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
                            this.oQQ.get().mMsgList.clear();
                            this.oQQ.get().oQb.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oQQ.get().oQb != null) {
                                this.oQQ.get().oQb.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oQQ.get().oQb.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oQQ.get().oQb.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oQQ.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oQQ.get().oQc.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oQQ.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oQQ.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oQQ.get().oQb.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oQQ.get().oQc != null) {
                                this.oQQ.get().oQc.setSelection(this.oQQ.get().oQc.getBottom());
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
                            this.oQQ.get().emi();
                            return;
                        case 30:
                            this.oQQ.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oQQ.get().oQc != null && this.oQQ.get().oQs > 0) {
                                if (this.oQQ.get().oQs + 5 > this.oQQ.get().oQb.getCount()) {
                                    this.oQQ.get().oQt = this.oQQ.get().oQb.getCount() - this.oQQ.get().oQs;
                                }
                                if (this.oQQ.get().oQt < 3) {
                                    this.oQQ.get().oQt = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oQQ.get().oQt);
                                this.oQQ.get().oQc.setSelection(this.oQQ.get().oQt);
                                return;
                            }
                            return;
                        case 32:
                            this.oQQ.get().oLo.showToast(this.oQQ.get().oLo.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oQQ.get().oLo.showToast(this.oQQ.get().oLo.getString(a.h.bd_im_error_msg_sheild_me_tips));
                            return;
                    }
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }

        private void R(Message message) {
            long j;
            boolean z;
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                if (arrayList == null || arrayList.size() < 20) {
                    this.oQQ.get().oQc.setPullRefreshEnable(false);
                }
                if (arrayList == null) {
                    j = 0;
                } else {
                    int i = 0;
                    j = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        ChatMsg chatMsg = (ChatMsg) arrayList.get(i2);
                        if (chatMsg.getMsgType() == 1 && chatMsg.getStatus() == 1) {
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQQ.get().oLo).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oQQ.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oQQ.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oQQ.get().mMsgList.iterator();
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
                    if (this.oQQ.get().oQn) {
                        this.oQQ.get().oQb.notifyDataSetChanged();
                        this.oQQ.get().Pc(i4);
                        this.oQQ.get().oQn = false;
                        return;
                    }
                    this.oQQ.get().oQb.notifyDataSetChanged();
                    this.oQQ.get().oQc.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oQQ.get().oLo.oOW) {
                    BIMManager.mediaSendChatMsg(this.oQQ.get().oLo, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c YK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emA().YK(((a) d.this.oQQ.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oQQ.get()).emc();
                            } else if (616 == i) {
                                ((a) d.this.oQQ.get()).emd();
                            }
                            YK.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQQ.get().oLo).a(chatMsg, this.oQQ.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oQQ.get().mMsgList.add(chatMsg);
                this.oQQ.get().oQb.notifyDataSetChanged();
                this.oQQ.get().eme();
                if (this.oQQ.get().oLo.oOW) {
                    BIMManager.mediaSendChatMsg(this.oQQ.get().oLo, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c YK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emA().YK(((a) d.this.oQQ.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oQQ.get()).emc();
                            } else if (616 == i) {
                                ((a) d.this.oQQ.get()).emd();
                            }
                            YK.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQQ.get().oLo).a(chatMsg, this.oQQ.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oQQ.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oQQ.get().oQm.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oQQ.get().j(chatMsg);
                        this.oQQ.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oQQ.get().oQc.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oQQ.get().oQc.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oQQ.get().oQc.getChildCount() - this.oQQ.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oQQ.get().oQb.F(this.oQQ.get().oQc.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oQQ.get().j(chatMsg);
                        ArrayList arrayList = this.oQQ.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oQQ.get().mMsgList.add(chatMsg);
                        }
                        this.oQQ.get().oQm.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oQQ.get().mMsgList.set(j, chatMsg);
                        this.oQQ.get().oQm.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oQQ.get().mMsgList.set(this.oQQ.get().j(chatMsg), chatMsg);
                    }
                    this.oQQ.get().oQb.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean emT = this.oQQ.get().oQc.emT();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oQQ.get().mMsgList.iterator();
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
                    this.oQQ.get().a(i2, chatMsg, 4);
                    this.oQQ.get().oQb.notifyDataSetChanged();
                    if (emT) {
                        this.oQQ.get().eme();
                    } else if (ChatInfo.oNz == ChatInfo.ChatCategory.DUZHAN && this.oQQ.get().oQw != null && this.oQQ.get().oQr) {
                        this.oQQ.get().oQw.elK();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class RunnableC0967a implements Runnable {
        private final SoftReference<a> oQQ;

        private RunnableC0967a(a aVar) {
            this.oQQ = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oQQ.get() != null) {
                try {
                    this.oQQ.get().emn();
                } catch (Exception e) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "fragment had destroyed");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b {
        public int mState;
        public int oQR;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oQS;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oQS = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    YA(localUrl);
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
                    YA(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.oQR = 1;
                a.this.oQl.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oLo.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oLo.showToast(a.this.oLo.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oLo.showToast(a.this.oLo.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.oQl.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.oQl.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oQR = 1;
                a.this.oQl.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oNB) {
                this.mMsg.setStatus(2);
            }
            a.this.emf();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.emf();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void YA(String str) {
            a.this.oQl.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.oQg != null) {
                    boolean z = a.this.oQg.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.oQg.emp();
                    if (z) {
                        YJ(str);
                        return;
                    }
                    return;
                }
                YJ(str);
            }
        }

        public void YJ(String str) {
            a.this.oQg = this;
            try {
                a.this.cAx = new MediaPlayer();
                a.this.cAx.setOnCompletionListener(this);
                a.this.cAx.setDataSource(str);
                if (a.this.oQh) {
                    a.this.cAx.setAudioStreamType(3);
                } else {
                    a.this.cAx.setAudioStreamType(0);
                }
                a.this.cAx.prepare();
                a.this.cAx.start();
                Message obtainMessage = a.this.oQf.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void emp() {
            if (a.this.cAx != null) {
                a.this.cAx.stop();
                a.this.cAx.release();
                a.this.cAx = null;
                a.this.oQg = null;
                Message obtainMessage = a.this.oQf.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            emp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oLo.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oQc.setRefreshTime();
                            a.this.oQc.emU();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oLo.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oLo.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oQc.setRefreshTime();
                            a.this.oQc.emU();
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
            Message obtainMessage = this.oQf.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
