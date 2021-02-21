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
public class a implements SensorEventListener, a.InterfaceC0966a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private View bUP;
    private MediaPlayer cCX;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private ActivityChat oXG;
    private String oXS;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c pbA;
    private FrameLayout pcA;
    private d pcB;
    private boolean pcE;
    private c pcG;
    private int pcO;
    private boolean pcR;
    private ActivityChat.c pcS;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a pcU;
    private long pcY;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a pcx;
    protected IMListView pcy;
    protected TextView pcz;
    private final int MAX_RETRY_NUM = 3;
    private c pcC = null;
    private boolean pcD = true;
    private Timer pcF = null;
    private HashMap<Long, b> pcH = new HashMap<>();
    private Set<Long> pcI = new HashSet();
    private boolean pcJ = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d pcK = null;
    private int pcL = 1;
    private Timer mTimer = null;
    private boolean pcM = false;
    private boolean pcN = false;
    private int pcP = 0;
    private boolean pcQ = true;
    private BroadcastReceiver pcT = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.pcx.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener oYp = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.ell().eln() != null) {
                d.ell().eln().elg();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b eln;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b elo = d.ell().elo();
            if (elo != null) {
                elo.elg();
            }
            if (Math.abs(f2) > 10.0f && (eln = d.ell().eln()) != null) {
                eln.elg();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver pcV = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.pcG = d.ell().Yz(a.this.mKey);
                if (a.this.pcG != null) {
                    a.this.pcG.ekI();
                }
            }
        }
    };
    private BroadcastReceiver pcW = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.pcG = d.ell().Yz(a.this.mKey);
                        if (a.this.pcG != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.pcG.i(chatMsg);
                            a.this.pcG.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(a.this.oXG, e2);
                }
            }
        }
    };
    private BroadcastReceiver bLP = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.21
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
                    a.this.pcG = d.ell().Yz(a.this.mKey);
                    if (a.this.pcG != null) {
                        a.this.pcG.gw(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(a.this.oXG, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.pcG = d.ell().Yz(a.this.mKey);
                    if (a.this.pcG != null) {
                        a.this.pcG.gw(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(a.this.oXG, e3);
                }
            }
        }
    };
    private BroadcastReceiver pcX = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.pcG = d.ell().Yz(a.this.mKey);
                                if (a.this.pcG != null) {
                                    a.this.pcG.gx(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().c(a.this.oXG, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener pcZ = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.ekR();
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
        this.pcO = 0;
        this.mKey = "";
        this.pcS = null;
        this.pcS = cVar;
        this.mKey = str;
        this.pcO = i;
        this.oXG = activityChat;
        d.ell().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.pcB = new d();
        this.mMsgList.clear();
        this.pcH.clear();
        this.pcI.clear();
        ekL();
        if (f.hJ(this.oXG)) {
            ela();
        }
        ekF();
        this.bUP = view;
        am(this.bUP);
        if (this.oXG.pbr) {
            q(true, System.currentTimeMillis());
        } else {
            NH(0);
        }
        initSensor();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oXG.getApplicationContext(), this.pcZ);
    }

    private void ekF() {
        if (!this.pcR) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oXG.registerReceiver(this.pcT, intentFilter);
            this.pcR = true;
        }
    }

    private void ekG() {
        if (this.pcR) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oXG.unregisterReceiver(this.pcT);
            this.pcR = false;
        }
    }

    public void onPause() {
        this.mSensorManager.unregisterListener(this);
        this.pcM = true;
        ekK();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oXG.getApplicationContext(), this.pcZ);
        d.ell().YA(this.mKey);
        if (this.pcF != null) {
            this.pcF.cancel();
        }
        if (this.pcK != null) {
            this.pcK.dismiss();
        }
        ekM();
        ThemeManager.b(this);
        ekG();
        ekH();
        if (this.oXG.pbr) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oXG, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void ekH() {
        Map<Long, h> eka;
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.paL && (eka = k.hC(this.oXG).eka()) != null && !eka.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : eka.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.ejX());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.B(this.oXG, com.baidu.yuyinala.privatemessage.implugin.util.c.a.piq, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(this.oXG, com.baidu.yuyinala.privatemessage.implugin.util.c.a.pir, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oZQ == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.pcM && ChatInfo.mStatus == 3) {
            if (ChatInfo.oZQ == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.oXG.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C || ChatInfo.oZQ == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.oXG.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.oXG.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    ekJ();
                    ekR();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        ekJ();
                        gz((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            ekR();
                        }
                    } else {
                        ekR();
                    }
                }
            }
        }
        this.pcM = false;
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void onStart() {
    }

    private void initSensor() {
        this.mSensorManager = (SensorManager) this.oXG.getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void am(View view) {
        this.mGestureDetector = new GestureDetector(this.oXG, this.oYp);
        this.pcA = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.pcy = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.pcz = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hz = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().hz(this.oXG.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hz);
        try {
            this.oXS = new JSONObject(hz).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hz);
        this.pcx = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oXG, this.mMsgList, this, this, this, this, this.pcS, this.oXS);
        this.pcx.a(this.oXG);
        this.pcy.setPullRefreshEnable(true);
        this.pcy.setIMListViewListener(this);
        this.pcy.setAdapter((ListAdapter) this.pcx);
        this.pcy.setSelector(new ColorDrawable(0));
        this.pcy.setTranscriptMode(1);
        this.pcy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
            this.pcD = false;
        } else {
            this.pcD = true;
        }
        if (this.pcC != null && this.pcE != this.pcD) {
            ChatMsg chatMsg = this.pcC.mMsg;
            View view = this.pcC.mView;
            Boolean valueOf = Boolean.valueOf(this.pcC.pdo);
            this.pcC.elb();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.pcD) {
                ekS();
            }
        }
        this.pcE = this.pcD;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.pcB.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.pcI.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oXG.getApplicationContext())) {
            a(3, chatMsg);
            ekN();
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
            if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().cj(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        ImBaseEntity ekt;
        if (!(this.oXG instanceof ActivityChat) || !this.oXG.ekq()) {
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
                if ((chatMsg instanceof SignleGraphicTextMsg) && new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).emL() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE && (this.oXG instanceof ActivityChat) && (ekt = this.oXG.ekt()) != null && ekt.mVideoEntity != null && !ekt.mVideoEntity.isShared) {
                    String str = ekt.mVideoEntity.id;
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
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oXG.getApplicationContext())) {
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
        this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.pcJ && ChatInfo.mStatus == 3) {
                    a.this.gy(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekI() {
        this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.pcL == 0) {
                    a.this.pcL = 1;
                    a.this.mMsgList.clear();
                    if (a.this.pcK != null) {
                        a.this.pcK.cancel();
                    }
                    a.this.NH(1);
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().deleteMsg(this.oXG.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                ekR();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekJ() {
        this.mMsgList.clear();
        ekR();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0966a
    public void NC(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oXG, this.oXG.getResources().getString(a.h.bd_im_alertdialog_title), this.oXG.getResources().getString(a.h.bd_im_alertdialog_tip), this.oXG.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oXG.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elr();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a pda;
        final /* synthetic */ int pdb;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.pda = aVar;
            this.pdb = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.pda.elr();
            if (this.pdb < 0 || this.pdb >= a.this.mMsgList.size()) {
                a.this.oXG.showToast(a.this.oXG.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.pdb);
            if (!a.this.oXG.pbr) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().deleteMsg(a.this.oXG.getApplicationContext(), chatMsg);
                if (a.this.pcC != null && a.this.pcC.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.pcC.elb();
                }
                a.this.ekR();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oXG, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.pcC != null && a.this.pcC.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.pcC.elb();
                                }
                                a.this.ekR();
                            }
                        });
                    }
                }
            });
        }
    }

    public void ekK() {
        if (this.pcC != null) {
            this.pcC.elb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.pcy.elF();
        this.pcy.elG();
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
        this.pcU = aVar;
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
                    this.oXG.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void ekL() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oXG.registerReceiver(this.bLP, intentFilter);
        this.oXG.registerReceiver(this.pcX, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oXG.registerReceiver(this.pcV, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oXG.registerReceiver(this.pcW, new IntentFilter("implugin.update.message"));
    }

    private void ekM() {
        this.oXG.unregisterReceiver(this.bLP);
        this.oXG.unregisterReceiver(this.pcX);
        this.oXG.unregisterReceiver(this.pcV);
        this.oXG.unregisterReceiver(this.pcW);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.pcC != null && this.pcC.mMsg.getRowId() != chatMsg.getRowId()) {
            this.pcC.elb();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oZS) {
            if (this.pcC == null) {
                this.pcC = new c(chatMsg, view, z);
                this.pcC.Yy(chatMsg.getLocalUrl());
                return;
            }
            this.pcC.elb();
        } else if (this.pcH.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.pcH.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.pcH.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.pdn < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.pdn++;
                this.pcH.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().markMsgClicked(this.oXG.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN && this.pcQ && chatMsg.getStatus() == 0) {
            bj(this.mMsgList);
            this.pcQ = false;
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
    public void ekN() {
        ekQ();
    }

    public void ekO() {
        this.pcB.obtainMessage(32).sendToTarget();
    }

    public void ekP() {
        this.pcB.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekQ() {
        Message obtainMessage = this.pcB.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void NF(int i) {
        Message obtainMessage = this.pcB.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NG(int i) {
        Message obtainMessage = this.pcB.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekR() {
        this.pcB.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.pcB.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void ekS() {
        this.pcB.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.pcB.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.pcB.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekT() {
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.SMART && this.oXG != null) {
            this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.pcz.setVisibility(0);
                    a.this.pcy.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.pcY == chatMsg.getMsgId()) {
                            a.this.oXG.showToast(a.this.oXG.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.pcY = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oXG);
                        BIMManager.tryConnection(a.this.oXG);
                        String ejT = com.baidu.yuyinala.privatemessage.implugin.d.a.ejT();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(ejT, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + ejT + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gx(arrayList);
                    a.this.oXG.showToast(a.this.oXG.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oXG.showToast(a.this.oXG.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().bu(a.this.oXG.getActivity(), a.this.oXG.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    ekR();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void Yx(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.pcx != null) {
            this.pcx.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        ekR();
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
    public void NH(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.oZQ == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.oZV == 2) {
                        if (a.this.pcO + 5 > 20) {
                            i3 = a.this.pcO + 5;
                            a.this.pcP = 5;
                        } else {
                            a.this.pcP = 20 - a.this.pcO;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(a.this.oXG.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C || ChatInfo.oZQ == ChatInfo.ChatCategory.B2C || ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.pcO + 5 > 20) {
                            i4 = a.this.pcO + 5;
                            a.this.pcP = 5;
                        } else {
                            a.this.pcP = 20 - a.this.pcO;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(a.this.oXG.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oZQ != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(a.this.oXG.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.pcK != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.pcK.cancel();
                                a.this.pcK = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gz((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oZQ == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hB(a.this.oXG.getApplicationContext()).e("416", "show", a.this.pcO, a.this.bj((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.ekT();
                    }
                    a.this.pcN = true;
                    a.this.pcJ = false;
                    a.this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ekV();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.pcL = 0;
                a.this.pcB.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void AN(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.pcK = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oXG);
            this.pcK.setMessage(this.oXG.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.pcK.setCancelable(true);
            this.pcK.show();
        } else if (this.pcK != null) {
            this.pcK.dismiss();
        }
    }

    public void ekU() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.pcL == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oXG;
            if (activityChat != null) {
                if (this.pcK != null) {
                    this.pcK.dismiss();
                }
                this.pcK = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.pcK.setMessage(this.oXG.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.pcK.setCancelable(true);
                this.pcK.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.NH(1);
                    }
                });
                this.pcK.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.pcL == 0) {
                            a.this.pcL = 1;
                            if (a.this.pcK != null) {
                                a.this.pcK.cancel();
                            }
                            a.this.NH(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekV() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.pcJ) {
                Yx(this.oXG.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekW() {
        if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            Yx(this.oXG.getString(a.h.bd_im_user_version_low));
        }
    }

    public void ekX() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.pcN) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ekW();
                    }
                });
            }
        }).start();
    }

    public void ekY() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            ekR();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.pcB.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void ND(final int i) {
        String string = this.oXG.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oXG, this.oXG.getResources().getString(a.h.bd_im_group_reporttile), string, this.oXG.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oXG.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elr();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.elr();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elz().showToast(a.this.oXG, a.this.oXG.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void ekZ() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oXG, this.oXG.getResources().getString(a.h.bd_im_space_title), this.oXG.getResources().getString(a.h.bd_im_space_prompt), this.oXG.getResources().getString(a.h.bd_im_space_chcek), this.oXG.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elr();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elr();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oZS);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().cj(jSONObject.toString(), 9);
            }
        });
    }

    private void ela() {
        this.pcF = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.pcL != 0) {
                    long emB = f.emB();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + emB);
                    if (emB < 300) {
                        a.this.pcB.post(new RunnableC0970a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.c.b.g(this.oXG, "check_sdcard", System.currentTimeMillis() / 1000);
        this.pcF.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ao(int i, boolean z) {
        if (this.bUP != null && !z) {
            this.pbA = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oXG, this.bUP, i, ChatInfo.mUid);
        }
        return this.pbA;
    }

    /* loaded from: classes11.dex */
    private static class e implements Runnable {
        private final SoftReference<a> pdm;

        private e(a aVar) {
            this.pdm = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.pdm.get() != null) {
                try {
                    if (!this.pdm.get().oXG.pbr) {
                        if (this.pdm.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.pdm.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oZQ == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.pdm.get().oXG.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.pdm.get().mMsgList.get(0));
                                } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C || ChatInfo.oZQ == ChatInfo.ChatCategory.B2C || ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.pdm.get().oXG.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.pdm.get().mMsgList.get(0));
                                } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.pdm.get().oXG.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.pdm.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.pdm.get().oXG.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.C2C || ChatInfo.oZQ == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.pdm.get().oXG.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejU().fetchMessageSyncWithState(this.pdm.get().oXG.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.pdm.get().pcy.setRefreshTime();
                        this.pdm.get().pcy.elF();
                        if (pair != null) {
                            this.pdm.get().gz((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.pdm.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.pdm.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.pdm.get().q(true, currentTimeMillis);
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
        private final SoftReference<a> pdm;

        private d(a aVar) {
            this.pdm = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pdm.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.pdm.get().mMsgList.add(chatMsg);
                                this.pdm.get().pcx.notifyDataSetChanged();
                                this.pdm.get().ekQ();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pdm.get().oXG).a(chatMsg, this.pdm.get().mKey);
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
                            this.pdm.get().mMsgList.clear();
                            this.pdm.get().pcx.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.pdm.get().pcx != null) {
                                this.pdm.get().pcx.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.pdm.get().pcx.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.pdm.get().pcx.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.pdm.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.pdm.get().pcy.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.pdm.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.pdm.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.pdm.get().pcx.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.pdm.get().pcy != null) {
                                this.pdm.get().pcy.setSelection(this.pdm.get().pcy.getBottom());
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
                            this.pdm.get().ekU();
                            return;
                        case 30:
                            this.pdm.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.pdm.get().pcy != null && this.pdm.get().pcO > 0) {
                                if (this.pdm.get().pcO + 5 > this.pdm.get().pcx.getCount()) {
                                    this.pdm.get().pcP = this.pdm.get().pcx.getCount() - this.pdm.get().pcO;
                                }
                                if (this.pdm.get().pcP < 3) {
                                    this.pdm.get().pcP = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.pdm.get().pcP);
                                this.pdm.get().pcy.setSelection(this.pdm.get().pcP);
                                return;
                            }
                            return;
                        case 32:
                            this.pdm.get().oXG.showToast(this.pdm.get().oXG.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.pdm.get().oXG.showToast(this.pdm.get().oXG.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.pdm.get().pcy.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pdm.get().oXG).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.pdm.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.pdm.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.pdm.get().mMsgList.iterator();
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
                    if (this.pdm.get().pcJ) {
                        this.pdm.get().pcx.notifyDataSetChanged();
                        this.pdm.get().NG(i4);
                        this.pdm.get().pcJ = false;
                        return;
                    }
                    this.pdm.get().pcx.notifyDataSetChanged();
                    this.pdm.get().pcy.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.pdm.get().oXG.pbr) {
                    BIMManager.mediaSendChatMsg(this.pdm.get().oXG, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Yz = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.ell().Yz(((a) d.this.pdm.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.pdm.get()).ekO();
                            } else if (616 == i) {
                                ((a) d.this.pdm.get()).ekP();
                            }
                            Yz.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pdm.get().oXG).a(chatMsg, this.pdm.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.pdm.get().mMsgList.add(chatMsg);
                this.pdm.get().pcx.notifyDataSetChanged();
                this.pdm.get().ekQ();
                if (this.pdm.get().oXG.pbr) {
                    BIMManager.mediaSendChatMsg(this.pdm.get().oXG, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Yz = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.ell().Yz(((a) d.this.pdm.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.pdm.get()).ekO();
                            } else if (616 == i) {
                                ((a) d.this.pdm.get()).ekP();
                            }
                            Yz.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pdm.get().oXG).a(chatMsg, this.pdm.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.pdm.get().j(chatMsg);
                if (j != -1) {
                    if (!this.pdm.get().pcI.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.pdm.get().j(chatMsg);
                        this.pdm.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.pdm.get().pcy.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.pdm.get().pcy.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.pdm.get().pcy.getChildCount() - this.pdm.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.pdm.get().pcx.K(this.pdm.get().pcy.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.pdm.get().j(chatMsg);
                        ArrayList arrayList = this.pdm.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.pdm.get().mMsgList.add(chatMsg);
                        }
                        this.pdm.get().pcI.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.pdm.get().mMsgList.set(j, chatMsg);
                        this.pdm.get().pcI.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.pdm.get().mMsgList.set(this.pdm.get().j(chatMsg), chatMsg);
                    }
                    this.pdm.get().pcx.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean elE = this.pdm.get().pcy.elE();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.pdm.get().mMsgList.iterator();
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
                    this.pdm.get().a(i2, chatMsg, 4);
                    this.pdm.get().pcx.notifyDataSetChanged();
                    if (elE) {
                        this.pdm.get().ekQ();
                    } else if (ChatInfo.oZQ == ChatInfo.ChatCategory.DUZHAN && this.pdm.get().pcS != null && this.pdm.get().pcN) {
                        this.pdm.get().pcS.ekx();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class RunnableC0970a implements Runnable {
        private final SoftReference<a> pdm;

        private RunnableC0970a(a aVar) {
            this.pdm = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pdm.get() != null) {
                try {
                    this.pdm.get().ekZ();
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
        public int pdn;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean pdo;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.pdo = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Yp(localUrl);
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
                    Yp(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.pdn = 1;
                a.this.pcH.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oXG.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oXG.showToast(a.this.oXG.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oXG.showToast(a.this.oXG.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.pcH.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.pcH.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.pdn = 1;
                a.this.pcH.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oZS) {
                this.mMsg.setStatus(2);
            }
            a.this.ekR();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.ekR();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Yp(String str) {
            a.this.pcH.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.pcC != null) {
                    boolean z = a.this.pcC.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.pcC.elb();
                    if (z) {
                        Yy(str);
                        return;
                    }
                    return;
                }
                Yy(str);
            }
        }

        public void Yy(String str) {
            a.this.pcC = this;
            try {
                a.this.cCX = new MediaPlayer();
                a.this.cCX.setOnCompletionListener(this);
                a.this.cCX.setDataSource(str);
                if (a.this.pcD) {
                    a.this.cCX.setAudioStreamType(3);
                } else {
                    a.this.cCX.setAudioStreamType(0);
                }
                a.this.cCX.prepare();
                a.this.cCX.start();
                Message obtainMessage = a.this.pcB.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void elb() {
            if (a.this.cCX != null) {
                a.this.cCX.stop();
                a.this.cCX.release();
                a.this.cCX = null;
                a.this.pcC = null;
                Message obtainMessage = a.this.pcB.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            elb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oXG.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.pcy.setRefreshTime();
                            a.this.pcy.elF();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oXG.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oXG.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.pcy.setRefreshTime();
                            a.this.pcy.elF();
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
            Message obtainMessage = this.pcB.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
