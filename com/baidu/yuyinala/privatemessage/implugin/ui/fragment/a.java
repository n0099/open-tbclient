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
public class a implements SensorEventListener, a.InterfaceC0964a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private View bUP;
    private MediaPlayer cCX;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private ActivityChat oXg;
    private String oXs;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a pbW;
    protected IMListView pbX;
    protected TextView pbY;
    private FrameLayout pbZ;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c pba;
    private d pca;
    private boolean pcd;
    private c pcf;
    private int pcn;
    private boolean pcq;
    private ActivityChat.c pcr;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a pcu;
    private long pcy;
    private final int MAX_RETRY_NUM = 3;
    private c pcb = null;
    private boolean pcc = true;
    private Timer pce = null;
    private HashMap<Long, b> pcg = new HashMap<>();
    private Set<Long> pch = new HashSet();
    private boolean pci = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d pcj = null;
    private int pck = 1;
    private Timer mTimer = null;
    private boolean pcl = false;
    private boolean pcm = false;
    private int pco = 0;
    private boolean pcp = true;
    private BroadcastReceiver pcs = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.pbW.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener oXP = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.eld().elf() != null) {
                d.eld().elf().ekY();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b elf;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b elg = d.eld().elg();
            if (elg != null) {
                elg.ekY();
            }
            if (Math.abs(f2) > 10.0f && (elf = d.eld().elf()) != null) {
                elf.ekY();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver pcv = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.pcf = d.eld().Yn(a.this.mKey);
                if (a.this.pcf != null) {
                    a.this.pcf.ekA();
                }
            }
        }
    };
    private BroadcastReceiver pcw = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.pcf = d.eld().Yn(a.this.mKey);
                        if (a.this.pcf != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.pcf.i(chatMsg);
                            a.this.pcf.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(a.this.oXg, e2);
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
                    a.this.pcf = d.eld().Yn(a.this.mKey);
                    if (a.this.pcf != null) {
                        a.this.pcf.gw(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(a.this.oXg, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.pcf = d.eld().Yn(a.this.mKey);
                    if (a.this.pcf != null) {
                        a.this.pcf.gw(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(a.this.oXg, e3);
                }
            }
        }
    };
    private BroadcastReceiver pcx = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.pcf = d.eld().Yn(a.this.mKey);
                                if (a.this.pcf != null) {
                                    a.this.pcf.gx(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().c(a.this.oXg, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener pcz = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.ekJ();
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
        this.pcn = 0;
        this.mKey = "";
        this.pcr = null;
        this.pcr = cVar;
        this.mKey = str;
        this.pcn = i;
        this.oXg = activityChat;
        d.eld().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.pca = new d();
        this.mMsgList.clear();
        this.pcg.clear();
        this.pch.clear();
        ekD();
        if (f.hJ(this.oXg)) {
            ekS();
        }
        ekx();
        this.bUP = view;
        am(this.bUP);
        if (this.oXg.paR) {
            q(true, System.currentTimeMillis());
        } else {
            NG(0);
        }
        initSensor();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oXg.getApplicationContext(), this.pcz);
    }

    private void ekx() {
        if (!this.pcq) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oXg.registerReceiver(this.pcs, intentFilter);
            this.pcq = true;
        }
    }

    private void eky() {
        if (this.pcq) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oXg.unregisterReceiver(this.pcs);
            this.pcq = false;
        }
    }

    public void onPause() {
        this.mSensorManager.unregisterListener(this);
        this.pcl = true;
        ekC();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oXg.getApplicationContext(), this.pcz);
        d.eld().Yo(this.mKey);
        if (this.pce != null) {
            this.pce.cancel();
        }
        if (this.pcj != null) {
            this.pcj.dismiss();
        }
        ekE();
        ThemeManager.b(this);
        eky();
        ekz();
        if (this.oXg.paR) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oXg, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void ekz() {
        Map<Long, h> ejS;
        if (ChatInfo.oZq == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.pak && (ejS = k.hC(this.oXg).ejS()) != null && !ejS.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : ejS.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.ejP());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.C(this.oXg, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phN, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(this.oXg, com.baidu.yuyinala.privatemessage.implugin.util.c.a.phO, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oZq == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.pcl && ChatInfo.mStatus == 3) {
            if (ChatInfo.oZq == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.oXg.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C || ChatInfo.oZq == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.oXg.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oZq == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.oXg.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    ekB();
                    ekJ();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        ekB();
                        gz((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            ekJ();
                        }
                    } else {
                        ekJ();
                    }
                }
            }
        }
        this.pcl = false;
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void onStart() {
    }

    private void initSensor() {
        this.mSensorManager = (SensorManager) this.oXg.getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void am(View view) {
        this.mGestureDetector = new GestureDetector(this.oXg, this.oXP);
        this.pbZ = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.pbX = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.pbY = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hz = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().hz(this.oXg.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hz);
        try {
            this.oXs = new JSONObject(hz).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hz);
        this.pbW = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oXg, this.mMsgList, this, this, this, this, this.pcr, this.oXs);
        this.pbW.a(this.oXg);
        this.pbX.setPullRefreshEnable(true);
        this.pbX.setIMListViewListener(this);
        this.pbX.setAdapter((ListAdapter) this.pbW);
        this.pbX.setSelector(new ColorDrawable(0));
        this.pbX.setTranscriptMode(1);
        this.pbX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
            this.pcc = false;
        } else {
            this.pcc = true;
        }
        if (this.pcb != null && this.pcd != this.pcc) {
            ChatMsg chatMsg = this.pcb.mMsg;
            View view = this.pcb.mView;
            Boolean valueOf = Boolean.valueOf(this.pcb.pcO);
            this.pcb.ekT();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.pcc) {
                ekK();
            }
        }
        this.pcd = this.pcc;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.pca.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.pch.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oXg.getApplicationContext())) {
            a(3, chatMsg);
            ekF();
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
            if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().cj(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        ImBaseEntity ekl;
        if (!(this.oXg instanceof ActivityChat) || !this.oXg.eki()) {
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
                if ((chatMsg instanceof SignleGraphicTextMsg) && new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).emD() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE && (this.oXg instanceof ActivityChat) && (ekl = this.oXg.ekl()) != null && ekl.mVideoEntity != null && !ekl.mVideoEntity.isShared) {
                    String str = ekl.mVideoEntity.id;
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
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oXg.getApplicationContext())) {
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
        this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.pci && ChatInfo.mStatus == 3) {
                    a.this.gy(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekA() {
        this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.pck == 0) {
                    a.this.pck = 1;
                    a.this.mMsgList.clear();
                    if (a.this.pcj != null) {
                        a.this.pcj.cancel();
                    }
                    a.this.NG(1);
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().deleteMsg(this.oXg.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                ekJ();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ekB() {
        this.mMsgList.clear();
        ekJ();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0964a
    public void NB(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oXg, this.oXg.getResources().getString(a.h.bd_im_alertdialog_title), this.oXg.getResources().getString(a.h.bd_im_alertdialog_tip), this.oXg.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oXg.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elj();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a pcA;
        final /* synthetic */ int pcB;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.pcA = aVar;
            this.pcB = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.pcA.elj();
            if (this.pcB < 0 || this.pcB >= a.this.mMsgList.size()) {
                a.this.oXg.showToast(a.this.oXg.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.pcB);
            if (!a.this.oXg.paR) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().deleteMsg(a.this.oXg.getApplicationContext(), chatMsg);
                if (a.this.pcb != null && a.this.pcb.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.pcb.ekT();
                }
                a.this.ekJ();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oXg, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.pcb != null && a.this.pcb.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.pcb.ekT();
                                }
                                a.this.ekJ();
                            }
                        });
                    }
                }
            });
        }
    }

    public void ekC() {
        if (this.pcb != null) {
            this.pcb.ekT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.pbX.elx();
        this.pbX.ely();
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
        this.pcu = aVar;
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
                    this.oXg.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void ekD() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oXg.registerReceiver(this.bLP, intentFilter);
        this.oXg.registerReceiver(this.pcx, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oXg.registerReceiver(this.pcv, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oXg.registerReceiver(this.pcw, new IntentFilter("implugin.update.message"));
    }

    private void ekE() {
        this.oXg.unregisterReceiver(this.bLP);
        this.oXg.unregisterReceiver(this.pcx);
        this.oXg.unregisterReceiver(this.pcv);
        this.oXg.unregisterReceiver(this.pcw);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.pcb != null && this.pcb.mMsg.getRowId() != chatMsg.getRowId()) {
            this.pcb.ekT();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oZs) {
            if (this.pcb == null) {
                this.pcb = new c(chatMsg, view, z);
                this.pcb.Ym(chatMsg.getLocalUrl());
                return;
            }
            this.pcb.ekT();
        } else if (this.pcg.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.pcg.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.pcg.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.pcN < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.pcN++;
                this.pcg.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().markMsgClicked(this.oXg.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN && this.pcp && chatMsg.getStatus() == 0) {
            bj(this.mMsgList);
            this.pcp = false;
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
    public void ekF() {
        ekI();
    }

    public void ekG() {
        this.pca.obtainMessage(32).sendToTarget();
    }

    public void ekH() {
        this.pca.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekI() {
        Message obtainMessage = this.pca.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void NE(int i) {
        Message obtainMessage = this.pca.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NF(int i) {
        Message obtainMessage = this.pca.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekJ() {
        this.pca.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.pca.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void ekK() {
        this.pca.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.pca.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.pca.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekL() {
        if (ChatInfo.oZq == ChatInfo.ChatCategory.SMART && this.oXg != null) {
            this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.pbY.setVisibility(0);
                    a.this.pbX.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.pcy == chatMsg.getMsgId()) {
                            a.this.oXg.showToast(a.this.oXg.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.pcy = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oXg);
                        BIMManager.tryConnection(a.this.oXg);
                        String ejL = com.baidu.yuyinala.privatemessage.implugin.d.a.ejL();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(ejL, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + ejL + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gx(arrayList);
                    a.this.oXg.showToast(a.this.oXg.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oXg.showToast(a.this.oXg.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().bv(a.this.oXg.getActivity(), a.this.oXg.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    ekJ();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void Yl(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.pbW != null) {
            this.pbW.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        ekJ();
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
    public void NG(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.oZq == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.oZv == 2) {
                        if (a.this.pcn + 5 > 20) {
                            i3 = a.this.pcn + 5;
                            a.this.pco = 5;
                        } else {
                            a.this.pco = 20 - a.this.pcn;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(a.this.oXg.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C || ChatInfo.oZq == ChatInfo.ChatCategory.B2C || ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.pcn + 5 > 20) {
                            i4 = a.this.pcn + 5;
                            a.this.pco = 5;
                        } else {
                            a.this.pco = 20 - a.this.pcn;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(a.this.oXg.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oZq != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(a.this.oXg.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.pcj != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.pcj.cancel();
                                a.this.pcj = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gz((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oZq == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hB(a.this.oXg.getApplicationContext()).e("416", "show", a.this.pcn, a.this.bj((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.ekL();
                    }
                    a.this.pcm = true;
                    a.this.pci = false;
                    a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ekN();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.pck = 0;
                a.this.pca.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void AN(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.pcj = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oXg);
            this.pcj.setMessage(this.oXg.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.pcj.setCancelable(true);
            this.pcj.show();
        } else if (this.pcj != null) {
            this.pcj.dismiss();
        }
    }

    public void ekM() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.pck == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oXg;
            if (activityChat != null) {
                if (this.pcj != null) {
                    this.pcj.dismiss();
                }
                this.pcj = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.pcj.setMessage(this.oXg.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.pcj.setCancelable(true);
                this.pcj.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.NG(1);
                    }
                });
                this.pcj.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.pck == 0) {
                            a.this.pck = 1;
                            if (a.this.pcj != null) {
                                a.this.pcj.cancel();
                            }
                            a.this.NG(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekN() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oZq == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.pci) {
                Yl(this.oXg.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ekO() {
        if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            Yl(this.oXg.getString(a.h.bd_im_user_version_low));
        }
    }

    public void ekP() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.pcm) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ekO();
                    }
                });
            }
        }).start();
    }

    public void ekQ() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            ekJ();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.pca.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void NC(final int i) {
        String string = this.oXg.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oXg, this.oXg.getResources().getString(a.h.bd_im_group_reporttile), string, this.oXg.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oXg.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elj();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.elj();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.elr().showToast(a.this.oXg, a.this.oXg.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void ekR() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oXg, this.oXg.getResources().getString(a.h.bd_im_space_title), this.oXg.getResources().getString(a.h.bd_im_space_prompt), this.oXg.getResources().getString(a.h.bd_im_space_chcek), this.oXg.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elj();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.elj();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oZs);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().cj(jSONObject.toString(), 9);
            }
        });
    }

    private void ekS() {
        this.pce = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.pck != 0) {
                    long emt = f.emt();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + emt);
                    if (emt < 300) {
                        a.this.pca.post(new RunnableC0968a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.c.b.g(this.oXg, "check_sdcard", System.currentTimeMillis() / 1000);
        this.pce.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ao(int i, boolean z) {
        if (this.bUP != null && !z) {
            this.pba = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oXg, this.bUP, i, ChatInfo.mUid);
        }
        return this.pba;
    }

    /* loaded from: classes11.dex */
    private static class e implements Runnable {
        private final SoftReference<a> pcM;

        private e(a aVar) {
            this.pcM = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.pcM.get() != null) {
                try {
                    if (!this.pcM.get().oXg.paR) {
                        if (this.pcM.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.pcM.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oZq == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.pcM.get().oXg.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.pcM.get().mMsgList.get(0));
                                } else if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C || ChatInfo.oZq == ChatInfo.ChatCategory.B2C || ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.pcM.get().oXg.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.pcM.get().mMsgList.get(0));
                                } else if (ChatInfo.oZq == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.pcM.get().oXg.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.pcM.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oZq == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.pcM.get().oXg.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oZq == ChatInfo.ChatCategory.C2C || ChatInfo.oZq == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.pcM.get().oXg.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oZq == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ejM().fetchMessageSyncWithState(this.pcM.get().oXg.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.pcM.get().pbX.setRefreshTime();
                        this.pcM.get().pbX.elx();
                        if (pair != null) {
                            this.pcM.get().gz((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.pcM.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.pcM.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.pcM.get().q(true, currentTimeMillis);
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
        private final SoftReference<a> pcM;

        private d(a aVar) {
            this.pcM = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.pcM.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.pcM.get().mMsgList.add(chatMsg);
                                this.pcM.get().pbW.notifyDataSetChanged();
                                this.pcM.get().ekI();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pcM.get().oXg).a(chatMsg, this.pcM.get().mKey);
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
                            this.pcM.get().mMsgList.clear();
                            this.pcM.get().pbW.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.pcM.get().pbW != null) {
                                this.pcM.get().pbW.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.pcM.get().pbW.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.pcM.get().pbW.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.pcM.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.pcM.get().pbX.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.pcM.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.pcM.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.pcM.get().pbW.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.pcM.get().pbX != null) {
                                this.pcM.get().pbX.setSelection(this.pcM.get().pbX.getBottom());
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
                            this.pcM.get().ekM();
                            return;
                        case 30:
                            this.pcM.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.pcM.get().pbX != null && this.pcM.get().pcn > 0) {
                                if (this.pcM.get().pcn + 5 > this.pcM.get().pbW.getCount()) {
                                    this.pcM.get().pco = this.pcM.get().pbW.getCount() - this.pcM.get().pcn;
                                }
                                if (this.pcM.get().pco < 3) {
                                    this.pcM.get().pco = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.pcM.get().pco);
                                this.pcM.get().pbX.setSelection(this.pcM.get().pco);
                                return;
                            }
                            return;
                        case 32:
                            this.pcM.get().oXg.showToast(this.pcM.get().oXg.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.pcM.get().oXg.showToast(this.pcM.get().oXg.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.pcM.get().pbX.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pcM.get().oXg).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.pcM.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.pcM.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.pcM.get().mMsgList.iterator();
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
                    if (this.pcM.get().pci) {
                        this.pcM.get().pbW.notifyDataSetChanged();
                        this.pcM.get().NF(i4);
                        this.pcM.get().pci = false;
                        return;
                    }
                    this.pcM.get().pbW.notifyDataSetChanged();
                    this.pcM.get().pbX.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.pcM.get().oXg.paR) {
                    BIMManager.mediaSendChatMsg(this.pcM.get().oXg, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Yn = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eld().Yn(((a) d.this.pcM.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.pcM.get()).ekG();
                            } else if (616 == i) {
                                ((a) d.this.pcM.get()).ekH();
                            }
                            Yn.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pcM.get().oXg).a(chatMsg, this.pcM.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.pcM.get().mMsgList.add(chatMsg);
                this.pcM.get().pbW.notifyDataSetChanged();
                this.pcM.get().ekI();
                if (this.pcM.get().oXg.paR) {
                    BIMManager.mediaSendChatMsg(this.pcM.get().oXg, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Yn = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eld().Yn(((a) d.this.pcM.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.pcM.get()).ekG();
                            } else if (616 == i) {
                                ((a) d.this.pcM.get()).ekH();
                            }
                            Yn.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hv(this.pcM.get().oXg).a(chatMsg, this.pcM.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.pcM.get().j(chatMsg);
                if (j != -1) {
                    if (!this.pcM.get().pch.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.pcM.get().j(chatMsg);
                        this.pcM.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.pcM.get().pbX.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.pcM.get().pbX.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.pcM.get().pbX.getChildCount() - this.pcM.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.pcM.get().pbW.K(this.pcM.get().pbX.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.pcM.get().j(chatMsg);
                        ArrayList arrayList = this.pcM.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.pcM.get().mMsgList.add(chatMsg);
                        }
                        this.pcM.get().pch.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.pcM.get().mMsgList.set(j, chatMsg);
                        this.pcM.get().pch.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.pcM.get().mMsgList.set(this.pcM.get().j(chatMsg), chatMsg);
                    }
                    this.pcM.get().pbW.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean elw = this.pcM.get().pbX.elw();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.pcM.get().mMsgList.iterator();
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
                    this.pcM.get().a(i2, chatMsg, 4);
                    this.pcM.get().pbW.notifyDataSetChanged();
                    if (elw) {
                        this.pcM.get().ekI();
                    } else if (ChatInfo.oZq == ChatInfo.ChatCategory.DUZHAN && this.pcM.get().pcr != null && this.pcM.get().pcm) {
                        this.pcM.get().pcr.ekp();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static class RunnableC0968a implements Runnable {
        private final SoftReference<a> pcM;

        private RunnableC0968a(a aVar) {
            this.pcM = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pcM.get() != null) {
                try {
                    this.pcM.get().ekR();
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
        public int pcN;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean pcO;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.pcO = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Yd(localUrl);
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
                    Yd(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.pcN = 1;
                a.this.pcg.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oXg.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oXg.showToast(a.this.oXg.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oXg.showToast(a.this.oXg.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.pcg.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.pcg.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.pcN = 1;
                a.this.pcg.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oZs) {
                this.mMsg.setStatus(2);
            }
            a.this.ekJ();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.ekJ();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Yd(String str) {
            a.this.pcg.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.pcb != null) {
                    boolean z = a.this.pcb.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.pcb.ekT();
                    if (z) {
                        Ym(str);
                        return;
                    }
                    return;
                }
                Ym(str);
            }
        }

        public void Ym(String str) {
            a.this.pcb = this;
            try {
                a.this.cCX = new MediaPlayer();
                a.this.cCX.setOnCompletionListener(this);
                a.this.cCX.setDataSource(str);
                if (a.this.pcc) {
                    a.this.cCX.setAudioStreamType(3);
                } else {
                    a.this.cCX.setAudioStreamType(0);
                }
                a.this.cCX.prepare();
                a.this.cCX.start();
                Message obtainMessage = a.this.pca.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void ekT() {
            if (a.this.cCX != null) {
                a.this.cCX.stop();
                a.this.cCX.release();
                a.this.cCX = null;
                a.this.pcb = null;
                Message obtainMessage = a.this.pca.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            ekT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oXg.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.pbX.setRefreshTime();
                            a.this.pbX.elx();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oXg.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oXg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.pbX.setRefreshTime();
                            a.this.pbX.elx();
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
            Message obtainMessage = this.pca.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
