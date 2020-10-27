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
import com.baidu.live.tbadk.log.LogConfig;
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
import com.xiaomi.mipush.sdk.Constants;
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
public class a implements SensorEventListener, a.InterfaceC0925a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private SensorManager bwC;
    private Sensor bwE;
    private MediaPlayer cpq;
    private View kAe;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private ActivityChat ole;
    private String olq;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ooY;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a opV;
    protected IMListView opW;
    protected TextView opX;
    private FrameLayout opY;
    private d opZ;
    private boolean oqc;
    private c oqe;
    private int oqm;
    private boolean oqp;
    private ActivityChat.c oqq;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a oqs;
    private long oqw;
    private final int MAX_RETRY_NUM = 3;
    private c oqa = null;
    private boolean oqb = true;
    private Timer oqd = null;
    private HashMap<Long, b> oqf = new HashMap<>();
    private Set<Long> oqg = new HashSet();
    private boolean oqh = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d oqi = null;
    private int oqj = 1;
    private Timer mTimer = null;
    private boolean oqk = false;
    private boolean oql = false;
    private int oqn = 0;
    private boolean oqo = true;
    private BroadcastReceiver oqr = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.opV.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener olQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.ecY().eda() != null) {
                d.ecY().eda().ecT();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b eda;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b edb = d.ecY().edb();
            if (edb != null) {
                edb.ecT();
            }
            if (Math.abs(f2) > 10.0f && (eda = d.ecY().eda()) != null) {
                eda.ecT();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver oqt = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.oqe = d.ecY().Xa(a.this.mKey);
                if (a.this.oqe != null) {
                    a.this.oqe.ecu();
                }
            }
        }
    };
    private BroadcastReceiver oqu = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.oqe = d.ecY().Xa(a.this.mKey);
                        if (a.this.oqe != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.oqe.i(chatMsg);
                            a.this.oqe.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(a.this.ole, e2);
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
                    a.this.oqe = d.ecY().Xa(a.this.mKey);
                    if (a.this.oqe != null) {
                        a.this.oqe.gi(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(a.this.ole, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.oqe = d.ecY().Xa(a.this.mKey);
                    if (a.this.oqe != null) {
                        a.this.oqe.gi(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(a.this.ole, e3);
                }
            }
        }
    };
    private BroadcastReceiver oqv = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.oqe = d.ecY().Xa(a.this.mKey);
                                if (a.this.oqe != null) {
                                    a.this.oqe.gj(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().c(a.this.ole, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener oqx = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.ecD();
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
        this.oqm = 0;
        this.mKey = "";
        this.oqq = null;
        this.oqq = cVar;
        this.mKey = str;
        this.oqm = i;
        this.ole = activityChat;
        d.ecY().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.opZ = new d();
        this.mMsgList.clear();
        this.oqf.clear();
        this.oqg.clear();
        ecx();
        if (f.gO(this.ole)) {
            ecM();
        }
        ecq();
        this.kAe = view;
        ah(this.kAe);
        if (this.ole.ooP) {
            j(true, System.currentTimeMillis());
        } else {
            Nh(0);
        }
        ect();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.ole.getApplicationContext(), this.oqx);
    }

    private void ecq() {
        if (!this.oqp) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.ole.registerReceiver(this.oqr, intentFilter);
            this.oqp = true;
        }
    }

    private void ecr() {
        if (this.oqp) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.ole.unregisterReceiver(this.oqr);
            this.oqp = false;
        }
    }

    public void onPause() {
        this.bwC.unregisterListener(this);
        this.oqk = true;
        ecw();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.ole.getApplicationContext(), this.oqx);
        d.ecY().Xb(this.mKey);
        if (this.oqd != null) {
            this.oqd.cancel();
        }
        if (this.oqi != null) {
            this.oqi.dismiss();
        }
        ecy();
        ThemeManager.b(this);
        ecr();
        ecs();
        if (this.ole.ooP) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.ole, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void ecs() {
        Map<Long, h> ebL;
        if (ChatInfo.ons == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.ooj && (ebL = k.gF(this.ole).ebL()) != null && !ebL.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : ebL.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + Constants.ACCEPT_TIME_SEPARATOR_SP + hVar.ebJ());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.A(this.ole, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovP, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(this.ole, com.baidu.yuyinala.privatemessage.implugin.util.b.a.ovQ, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.ons == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.oqk && ChatInfo.mStatus == 3) {
            if (ChatInfo.ons == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.ole.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.ons == ChatInfo.ChatCategory.C2C || ChatInfo.ons == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.ole.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.ons == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.ole.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    ecv();
                    ecD();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        ecv();
                        gl((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            ecD();
                        }
                    } else {
                        ecD();
                    }
                }
            }
        }
        this.oqk = false;
        this.bwC.registerListener(this, this.bwE, 3);
    }

    public void onStart() {
    }

    private void ect() {
        this.bwC = (SensorManager) this.ole.getSystemService("sensor");
        this.bwE = this.bwC.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void ah(View view) {
        this.mGestureDetector = new GestureDetector(this.ole, this.olQ);
        this.opY = (FrameLayout) view.findViewById(a.g.bd_im_chating_list_root);
        this.opW = (IMListView) view.findViewById(a.g.bd_im_listView);
        this.opX = (TextView) view.findViewById(a.g.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String gC = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().gC(this.ole.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + gC);
        try {
            this.olq = new JSONObject(gC).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + gC);
        this.opV = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.ole, this.mMsgList, this, this, this, this, this.oqq, this.olq);
        this.opV.a(this.ole);
        this.opW.setPullRefreshEnable(true);
        this.opW.setIMListViewListener(this);
        this.opW.setAdapter((ListAdapter) this.opV);
        this.opW.setSelector(new ColorDrawable(0));
        this.opW.setTranscriptMode(1);
        this.opW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
        if (sensorEvent.values[0] < this.bwE.getMaximumRange()) {
            this.oqb = false;
        } else {
            this.oqb = true;
        }
        if (this.oqa != null && this.oqc != this.oqb) {
            ChatMsg chatMsg = this.oqa.mMsg;
            View view = this.oqa.mView;
            Boolean valueOf = Boolean.valueOf(this.oqa.oqM);
            this.oqa.ecN();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.oqb) {
                ecE();
            }
        }
        this.oqc = this.oqb;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.opZ.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.oqg.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.ole.getApplicationContext())) {
            a(3, chatMsg);
            ecz();
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
            if (ChatInfo.ons == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().bT(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        String str;
        String str2;
        String str3;
        ImBaseEntity ece;
        if ((this.ole instanceof ActivityChat) && this.ole.ecb()) {
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
                        if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).eex() != SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE || !(this.ole instanceof ActivityChat) || (ece = this.ole.ece()) == null || ece.mVideoEntity == null) {
                            str = null;
                        } else if (ece.mVideoEntity.isShared) {
                            str4 = TbConfig.TMP_SHARE_DIR_NAME;
                            str5 = "video";
                            str = null;
                        } else {
                            str4 = "other";
                            str5 = "video";
                            str = ece.mVideoEntity.id;
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
            com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.a(str, LogConfig.KEY_NOTICE, "fsq_msg_send", com.baidu.yuyinala.privatemessage.implugin.a.ebv().bdr(), com.baidu.yuyinala.privatemessage.implugin.a.ebv().getTag(), str3, null, com.baidu.yuyinala.privatemessage.implugin.a.ebv().ebt(), com.baidu.yuyinala.privatemessage.implugin.a.ebv().ebu(), str2, null, null, String.valueOf(chatMsg.getContacter())), false);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void h(ChatMsg chatMsg) {
        if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND + chatMsg.toString());
        }
        g(chatMsg);
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.ole.getApplicationContext())) {
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
    public void gi(final List<ChatMsg> list) {
        this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.oqh && ChatInfo.mStatus == 3) {
                    a.this.gk(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ecu() {
        this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.oqj == 0) {
                    a.this.oqj = 1;
                    a.this.mMsgList.clear();
                    if (a.this.oqi != null) {
                        a.this.oqi.cancel();
                    }
                    a.this.Nh(1);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void gj(List<Long> list) {
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().deleteMsg(this.ole.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                ecD();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ecv() {
        this.mMsgList.clear();
        ecD();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0925a
    public void Nb(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.ole, this.ole.getResources().getString(a.i.bd_im_alertdialog_title), this.ole.getResources().getString(a.i.bd_im_alertdialog_tip), this.ole.getResources().getString(a.i.bd_im_user_zhida_ensure), this.ole.getResources().getString(a.i.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.ede();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a oqy;
        final /* synthetic */ int oqz;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.oqy = aVar;
            this.oqz = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.oqy.ede();
            if (this.oqz < 0 || this.oqz >= a.this.mMsgList.size()) {
                a.this.ole.showToast(a.this.ole.getString(a.i.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.oqz);
            if (!a.this.ole.ooP) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().deleteMsg(a.this.ole.getApplicationContext(), chatMsg);
                if (a.this.oqa != null && a.this.oqa.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.oqa.ecN();
                }
                a.this.ecD();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.ole, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.oqa != null && a.this.oqa.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.oqa.ecN();
                                }
                                a.this.ecD();
                            }
                        });
                    }
                }
            });
        }
    }

    public void ecw() {
        if (this.oqa != null) {
            this.oqa.ecN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.opW.eds();
        this.opW.edt();
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
        this.oqs = aVar;
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
                    this.ole.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void ecx() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.ole.registerReceiver(this.mReceiver, intentFilter);
        this.ole.registerReceiver(this.oqv, new IntentFilter(IMConstants.SYNC_ACTION));
        this.ole.registerReceiver(this.oqt, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.ole.registerReceiver(this.oqu, new IntentFilter("implugin.update.message"));
    }

    private void ecy() {
        this.ole.unregisterReceiver(this.mReceiver);
        this.ole.unregisterReceiver(this.oqv);
        this.ole.unregisterReceiver(this.oqt);
        this.ole.unregisterReceiver(this.oqu);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.oqa != null && this.oqa.mMsg.getRowId() != chatMsg.getRowId()) {
            this.oqa.ecN();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.onu) {
            if (this.oqa == null) {
                this.oqa = new c(chatMsg, view, z);
                this.oqa.WZ(chatMsg.getLocalUrl());
                return;
            }
            this.oqa.ecN();
        } else if (this.oqf.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.oqf.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.oqf.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oqL < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oqL++;
                this.oqf.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().markMsgClicked(this.ole.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN && this.oqo && chatMsg.getStatus() == 0) {
            bm(this.mMsgList);
            this.oqo = false;
        }
    }

    public String bm(ArrayList<ChatMsg> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getFromUser() == ChatInfo.mPaid) {
                return arrayList.get(size).getExtLog();
            }
        }
        return null;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void ecz() {
        ecC();
    }

    public void ecA() {
        this.opZ.obtainMessage(32).sendToTarget();
    }

    public void ecB() {
        this.opZ.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecC() {
        Message obtainMessage = this.opZ.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void Nf(int i) {
        Message obtainMessage = this.opZ.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ng(int i) {
        Message obtainMessage = this.opZ.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecD() {
        this.opZ.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.opZ.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void ecE() {
        this.opZ.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gk(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.opZ.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.opZ.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecF() {
        if (ChatInfo.ons == ChatInfo.ChatCategory.SMART && this.ole != null) {
            this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.opX.setVisibility(0);
                    a.this.opW.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.oqw == chatMsg.getMsgId()) {
                            a.this.ole.showToast(a.this.ole.getString(a.i.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.oqw = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.ole);
                        BIMManager.tryConnection(a.this.ole);
                        String ebF = com.baidu.yuyinala.privatemessage.implugin.d.a.ebF();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(ebF, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + ebF + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gj(arrayList);
                    a.this.ole.showToast(a.this.ole.getString(a.i.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.ole.showToast(a.this.ole.getString(a.i.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().bq(a.this.ole.getActivity(), a.this.ole.getString(a.i.bd_im_error_msg_sheild_me_tips));
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
                    ecD();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void WY(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.opV != null) {
            this.opV.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        ecD();
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
    public void Nh(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.ons == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.jUX == 2) {
                        if (a.this.oqm + 5 > 20) {
                            i3 = a.this.oqm + 5;
                            a.this.oqn = 5;
                        } else {
                            a.this.oqn = 20 - a.this.oqm;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(a.this.ole.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.ons == ChatInfo.ChatCategory.C2C || ChatInfo.ons == ChatInfo.ChatCategory.B2C || ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.oqm + 5 > 20) {
                            i4 = a.this.oqm + 5;
                            a.this.oqn = 5;
                        } else {
                            a.this.oqn = 20 - a.this.oqm;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(a.this.ole.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.ons != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(a.this.ole.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.oqi != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.oqi.cancel();
                                a.this.oqi = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gl((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN || ChatInfo.ons == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.gE(a.this.ole.getApplicationContext()).b("416", "show", a.this.oqm, a.this.bm((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.ecF();
                    }
                    a.this.oql = true;
                    a.this.oqh = false;
                    a.this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ecH();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.oqj = 0;
                a.this.opZ.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void zC(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.oqi = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.ole);
            this.oqi.setMessage(this.ole.getResources().getString(a.i.bd_im_listview_header_hint_loading));
            this.oqi.setCancelable(true);
            this.oqi.show();
        } else if (this.oqi != null) {
            this.oqi.dismiss();
        }
    }

    public void ecG() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.oqj == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.ole;
            if (activityChat != null) {
                if (this.oqi != null) {
                    this.oqi.dismiss();
                }
                this.oqi = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.oqi.setMessage(this.ole.getResources().getString(a.i.bd_im_listview_header_hint_loading));
                this.oqi.setCancelable(true);
                this.oqi.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.Nh(1);
                    }
                });
                this.oqi.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.oqj == 0) {
                            a.this.oqj = 1;
                            if (a.this.oqi != null) {
                                a.this.oqi.cancel();
                            }
                            a.this.Nh(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecH() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.ons == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.oqh) {
                WY(this.ole.getString(a.i.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecI() {
        if (ChatInfo.ons == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            WY(this.ole.getString(a.i.bd_im_user_version_low));
        }
    }

    public void ecJ() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.oql) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ecI();
                    }
                });
            }
        }).start();
    }

    public void ecK() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            ecD();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.opZ.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void Nc(final int i) {
        String string = this.ole.getResources().getString(a.i.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.ole, this.ole.getResources().getString(a.i.bd_im_group_reporttile), string, this.ole.getResources().getString(a.i.bd_im_user_zhida_ensure), this.ole.getResources().getString(a.i.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.ede();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.ede();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.edm().showToast(a.this.ole, a.this.ole.getString(a.i.bd_im_group_report));
                }
            }
        });
    }

    public void ecL() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.ole, this.ole.getResources().getString(a.i.bd_im_space_title), this.ole.getResources().getString(a.i.bd_im_space_prompt), this.ole.getResources().getString(a.i.bd_im_space_chcek), this.ole.getResources().getString(a.i.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.ede();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.ede();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.onu);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().bT(jSONObject.toString(), 9);
            }
        });
    }

    private void ecM() {
        this.oqd = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.oqj != 0) {
                    long eeq = f.eeq();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + eeq);
                    if (eeq < 300) {
                        a.this.opZ.post(new RunnableC0929a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.b.b.g(this.ole, "check_sdcard", System.currentTimeMillis() / 1000);
        this.oqd.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c aq(int i, boolean z) {
        if (this.kAe != null && !z) {
            this.ooY = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.ole, this.kAe, i, ChatInfo.mUid);
        }
        return this.ooY;
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oqK;

        private e(a aVar) {
            this.oqK = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oqK.get() != null) {
                try {
                    if (!this.oqK.get().ole.ooP) {
                        if (this.oqK.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oqK.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.ons == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.oqK.get().ole.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oqK.get().mMsgList.get(0));
                                } else if (ChatInfo.ons == ChatInfo.ChatCategory.C2C || ChatInfo.ons == ChatInfo.ChatCategory.B2C || ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.oqK.get().ole.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oqK.get().mMsgList.get(0));
                                } else if (ChatInfo.ons == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.oqK.get().ole.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oqK.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.ons == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.oqK.get().ole.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.ons == ChatInfo.ChatCategory.C2C || ChatInfo.ons == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.oqK.get().ole.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.ons == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ebG().fetchMessageSyncWithState(this.oqK.get().ole.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oqK.get().opW.setRefreshTime();
                        this.oqK.get().opW.eds();
                        if (pair != null) {
                            this.oqK.get().gl((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oqK.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oqK.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oqK.get().j(true, currentTimeMillis);
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
        private final SoftReference<a> oqK;

        private d(a aVar) {
            this.oqK = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oqK.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oqK.get().mMsgList.add(chatMsg);
                                this.oqK.get().opV.notifyDataSetChanged();
                                this.oqK.get().ecC();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oqK.get().ole).a(chatMsg, this.oqK.get().mKey);
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
                            this.oqK.get().mMsgList.clear();
                            this.oqK.get().opV.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oqK.get().opV != null) {
                                this.oqK.get().opV.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oqK.get().opV.aT(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oqK.get().opV.aU(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oqK.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oqK.get().opW.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oqK.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oqK.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oqK.get().opV.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oqK.get().opW != null) {
                                this.oqK.get().opW.setSelection(this.oqK.get().opW.getBottom());
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
                            this.oqK.get().ecG();
                            return;
                        case 30:
                            this.oqK.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oqK.get().opW != null && this.oqK.get().oqm > 0) {
                                if (this.oqK.get().oqm + 5 > this.oqK.get().opV.getCount()) {
                                    this.oqK.get().oqn = this.oqK.get().opV.getCount() - this.oqK.get().oqm;
                                }
                                if (this.oqK.get().oqn < 3) {
                                    this.oqK.get().oqn = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oqK.get().oqn);
                                this.oqK.get().opW.setSelection(this.oqK.get().oqn);
                                return;
                            }
                            return;
                        case 32:
                            this.oqK.get().ole.showToast(this.oqK.get().ole.getString(a.i.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oqK.get().ole.showToast(this.oqK.get().ole.getString(a.i.bd_im_error_msg_sheild_me_tips));
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
                    this.oqK.get().opW.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oqK.get().ole).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oqK.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oqK.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oqK.get().mMsgList.iterator();
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
                    if (this.oqK.get().oqh) {
                        this.oqK.get().opV.notifyDataSetChanged();
                        this.oqK.get().Ng(i4);
                        this.oqK.get().oqh = false;
                        return;
                    }
                    this.oqK.get().opV.notifyDataSetChanged();
                    this.oqK.get().opW.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oqK.get().ole.ooP) {
                    BIMManager.mediaSendChatMsg(this.oqK.get().ole, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Xa = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.ecY().Xa(((a) d.this.oqK.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oqK.get()).ecA();
                            } else if (616 == i) {
                                ((a) d.this.oqK.get()).ecB();
                            }
                            Xa.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oqK.get().ole).a(chatMsg, this.oqK.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oqK.get().mMsgList.add(chatMsg);
                this.oqK.get().opV.notifyDataSetChanged();
                this.oqK.get().ecC();
                if (this.oqK.get().ole.ooP) {
                    BIMManager.mediaSendChatMsg(this.oqK.get().ole, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Xa = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.ecY().Xa(((a) d.this.oqK.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oqK.get()).ecA();
                            } else if (616 == i) {
                                ((a) d.this.oqK.get()).ecB();
                            }
                            Xa.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oqK.get().ole).a(chatMsg, this.oqK.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oqK.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oqK.get().oqg.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oqK.get().j(chatMsg);
                        this.oqK.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oqK.get().opW.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oqK.get().opW.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oqK.get().opW.getChildCount() - this.oqK.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oqK.get().opV.D(this.oqK.get().opW.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oqK.get().j(chatMsg);
                        ArrayList arrayList = this.oqK.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oqK.get().mMsgList.add(chatMsg);
                        }
                        this.oqK.get().oqg.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oqK.get().mMsgList.set(j, chatMsg);
                        this.oqK.get().oqg.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oqK.get().mMsgList.set(this.oqK.get().j(chatMsg), chatMsg);
                    }
                    this.oqK.get().opV.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean edr = this.oqK.get().opW.edr();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oqK.get().mMsgList.iterator();
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
                    this.oqK.get().a(i2, chatMsg, 4);
                    this.oqK.get().opV.notifyDataSetChanged();
                    if (edr) {
                        this.oqK.get().ecC();
                    } else if (ChatInfo.ons == ChatInfo.ChatCategory.DUZHAN && this.oqK.get().oqq != null && this.oqK.get().oql) {
                        this.oqK.get().oqq.eci();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class RunnableC0929a implements Runnable {
        private final SoftReference<a> oqK;

        private RunnableC0929a(a aVar) {
            this.oqK = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oqK.get() != null) {
                try {
                    this.oqK.get().ecL();
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
        public int oqL;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oqM;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oqM = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    WQ(localUrl);
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
                    WQ(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.oqL = 1;
                a.this.oqf.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.ole.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.ole.showToast(a.this.ole.getString(a.i.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.ole.showToast(a.this.ole.getString(a.i.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.oqf.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.oqf.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oqL = 1;
                a.this.oqf.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.onu) {
                this.mMsg.setStatus(2);
            }
            a.this.ecD();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.ecD();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void WQ(String str) {
            a.this.oqf.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.oqa != null) {
                    boolean z = a.this.oqa.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.oqa.ecN();
                    if (z) {
                        WZ(str);
                        return;
                    }
                    return;
                }
                WZ(str);
            }
        }

        public void WZ(String str) {
            a.this.oqa = this;
            try {
                a.this.cpq = new MediaPlayer();
                a.this.cpq.setOnCompletionListener(this);
                a.this.cpq.setDataSource(str);
                if (a.this.oqb) {
                    a.this.cpq.setAudioStreamType(3);
                } else {
                    a.this.cpq.setAudioStreamType(0);
                }
                a.this.cpq.prepare();
                a.this.cpq.start();
                Message obtainMessage = a.this.opZ.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void ecN() {
            if (a.this.cpq != null) {
                a.this.cpq.stop();
                a.this.cpq.release();
                a.this.cpq = null;
                a.this.oqa = null;
                Message obtainMessage = a.this.opZ.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            ecN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.ole.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.opW.setRefreshTime();
                            a.this.opW.eds();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.ole.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.ole.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.opW.setRefreshTime();
                            a.this.opW.eds();
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
            Message obtainMessage = this.opZ.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
