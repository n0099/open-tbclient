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
public class a implements SensorEventListener, a.InterfaceC0960a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private View bRa;
    private MediaPlayer cAB;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private ActivityChat oMW;
    private String oNi;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oQO;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a oRK;
    protected IMListView oRL;
    protected TextView oRM;
    private FrameLayout oRN;
    private d oRO;
    private boolean oRR;
    private c oRT;
    private int oSb;
    private boolean oSe;
    private ActivityChat.c oSf;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a oSh;
    private long oSl;
    private final int MAX_RETRY_NUM = 3;
    private c oRP = null;
    private boolean oRQ = true;
    private Timer oRS = null;
    private HashMap<Long, b> oRU = new HashMap<>();
    private Set<Long> oRV = new HashSet();
    private boolean oRW = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d oRX = null;
    private int oRY = 1;
    private Timer mTimer = null;
    private boolean oRZ = false;
    private boolean oSa = false;
    private int oSc = 0;
    private boolean oSd = true;
    private BroadcastReceiver oSg = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.oRK.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener oNF = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.eiJ().eiL() != null) {
                d.eiJ().eiL().eiE();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b eiL;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b eiM = d.eiJ().eiM();
            if (eiM != null) {
                eiM.eiE();
            }
            if (Math.abs(f2) > 10.0f && (eiL = d.eiJ().eiL()) != null) {
                eiL.eiE();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver oSi = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.oRT = d.eiJ().Xm(a.this.mKey);
                if (a.this.oRT != null) {
                    a.this.oRT.eig();
                }
            }
        }
    };
    private BroadcastReceiver oSj = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.oRT = d.eiJ().Xm(a.this.mKey);
                        if (a.this.oRT != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.oRT.i(chatMsg);
                            a.this.oRT.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(a.this.oMW, e2);
                }
            }
        }
    };
    private BroadcastReceiver bIf = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.21
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
                    a.this.oRT = d.eiJ().Xm(a.this.mKey);
                    if (a.this.oRT != null) {
                        a.this.oRT.gy(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(a.this.oMW, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.oRT = d.eiJ().Xm(a.this.mKey);
                    if (a.this.oRT != null) {
                        a.this.oRT.gy(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(a.this.oMW, e3);
                }
            }
        }
    };
    private BroadcastReceiver oSk = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.oRT = d.eiJ().Xm(a.this.mKey);
                                if (a.this.oRT != null) {
                                    a.this.oRT.gz(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().c(a.this.oMW, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener oSm = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.eip();
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
        this.oSb = 0;
        this.mKey = "";
        this.oSf = null;
        this.oSf = cVar;
        this.mKey = str;
        this.oSb = i;
        this.oMW = activityChat;
        d.eiJ().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.oRO = new d();
        this.mMsgList.clear();
        this.oRU.clear();
        this.oRV.clear();
        eij();
        if (f.hG(this.oMW)) {
            eiy();
        }
        eid();
        this.bRa = view;
        ap(this.bRa);
        if (this.oMW.oQF) {
            q(true, System.currentTimeMillis());
        } else {
            Nl(0);
        }
        initSensor();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oMW.getApplicationContext(), this.oSm);
    }

    private void eid() {
        if (!this.oSe) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oMW.registerReceiver(this.oSg, intentFilter);
            this.oSe = true;
        }
    }

    private void eie() {
        if (this.oSe) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oMW.unregisterReceiver(this.oSg);
            this.oSe = false;
        }
    }

    public void onPause() {
        this.mSensorManager.unregisterListener(this);
        this.oRZ = true;
        eii();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oMW.getApplicationContext(), this.oSm);
        d.eiJ().Xn(this.mKey);
        if (this.oRS != null) {
            this.oRS.cancel();
        }
        if (this.oRX != null) {
            this.oRX.dismiss();
        }
        eik();
        ThemeManager.b(this);
        eie();
        eif();
        if (this.oMW.oQF) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oMW, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void eif() {
        Map<Long, h> ehy;
        if (ChatInfo.oPg == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.oPZ && (ehy = k.hz(this.oMW).ehy()) != null && !ehy.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : ehy.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.ehv());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.D(this.oMW, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXA, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.c.b.e(this.oMW, com.baidu.yuyinala.privatemessage.implugin.util.c.a.oXB, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oPg == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.oRZ && ChatInfo.mStatus == 3) {
            if (ChatInfo.oPg == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oMW.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C || ChatInfo.oPg == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oMW.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oPg == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oMW.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    eih();
                    eip();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        eih();
                        gB((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            eip();
                        }
                    } else {
                        eip();
                    }
                }
            }
        }
        this.oRZ = false;
        this.mSensorManager.registerListener(this, this.mSensor, 3);
    }

    public void onStart() {
    }

    private void initSensor() {
        this.mSensorManager = (SensorManager) this.oMW.getSystemService("sensor");
        this.mSensor = this.mSensorManager.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void ap(View view) {
        this.mGestureDetector = new GestureDetector(this.oMW, this.oNF);
        this.oRN = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.oRL = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.oRM = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hw = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().hw(this.oMW.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hw);
        try {
            this.oNi = new JSONObject(hw).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hw);
        this.oRK = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oMW, this.mMsgList, this, this, this, this, this.oSf, this.oNi);
        this.oRK.a(this.oMW);
        this.oRL.setPullRefreshEnable(true);
        this.oRL.setIMListViewListener(this);
        this.oRL.setAdapter((ListAdapter) this.oRK);
        this.oRL.setSelector(new ColorDrawable(0));
        this.oRL.setTranscriptMode(1);
        this.oRL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
            this.oRQ = false;
        } else {
            this.oRQ = true;
        }
        if (this.oRP != null && this.oRR != this.oRQ) {
            ChatMsg chatMsg = this.oRP.mMsg;
            View view = this.oRP.mView;
            Boolean valueOf = Boolean.valueOf(this.oRP.oSB);
            this.oRP.eiz();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.oRQ) {
                eiq();
            }
        }
        this.oRR = this.oRQ;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.oRO.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.oRV.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oMW.getApplicationContext())) {
            a(3, chatMsg);
            eil();
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
            if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().ci(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        ImBaseEntity ehR;
        if (!(this.oMW instanceof ActivityChat) || !this.oMW.ehO()) {
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
                if ((chatMsg instanceof SignleGraphicTextMsg) && new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).ekl() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE && (this.oMW instanceof ActivityChat) && (ehR = this.oMW.ehR()) != null && ehR.mVideoEntity != null && !ehR.mVideoEntity.isShared) {
                    String str = ehR.mVideoEntity.id;
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
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oMW.getApplicationContext())) {
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
        this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.oRW && ChatInfo.mStatus == 3) {
                    a.this.gA(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void eig() {
        this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.oRY == 0) {
                    a.this.oRY = 1;
                    a.this.mMsgList.clear();
                    if (a.this.oRX != null) {
                        a.this.oRX.cancel();
                    }
                    a.this.Nl(1);
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().deleteMsg(this.oMW.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                eip();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void eih() {
        this.mMsgList.clear();
        eip();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0960a
    public void Nf(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oMW, this.oMW.getResources().getString(a.h.bd_im_alertdialog_title), this.oMW.getResources().getString(a.h.bd_im_alertdialog_tip), this.oMW.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oMW.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.eiP();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a oSn;
        final /* synthetic */ int oSo;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.oSn = aVar;
            this.oSo = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.oSn.eiP();
            if (this.oSo < 0 || this.oSo >= a.this.mMsgList.size()) {
                a.this.oMW.showToast(a.this.oMW.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.oSo);
            if (!a.this.oMW.oQF) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().deleteMsg(a.this.oMW.getApplicationContext(), chatMsg);
                if (a.this.oRP != null && a.this.oRP.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.oRP.eiz();
                }
                a.this.eip();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oMW, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.oRP != null && a.this.oRP.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.oRP.eiz();
                                }
                                a.this.eip();
                            }
                        });
                    }
                }
            });
        }
    }

    public void eii() {
        if (this.oRP != null) {
            this.oRP.eiz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.oRL.ejd();
        this.oRL.eje();
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
        this.oSh = aVar;
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
                    this.oMW.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void eij() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oMW.registerReceiver(this.bIf, intentFilter);
        this.oMW.registerReceiver(this.oSk, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oMW.registerReceiver(this.oSi, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oMW.registerReceiver(this.oSj, new IntentFilter("implugin.update.message"));
    }

    private void eik() {
        this.oMW.unregisterReceiver(this.bIf);
        this.oMW.unregisterReceiver(this.oSk);
        this.oMW.unregisterReceiver(this.oSi);
        this.oMW.unregisterReceiver(this.oSj);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.oRP != null && this.oRP.mMsg.getRowId() != chatMsg.getRowId()) {
            this.oRP.eiz();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oPi) {
            if (this.oRP == null) {
                this.oRP = new c(chatMsg, view, z);
                this.oRP.Xl(chatMsg.getLocalUrl());
                return;
            }
            this.oRP.eiz();
        } else if (this.oRU.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.oRU.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.oRU.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oSA < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oSA++;
                this.oRU.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().markMsgClicked(this.oMW.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN && this.oSd && chatMsg.getStatus() == 0) {
            bk(this.mMsgList);
            this.oSd = false;
        }
    }

    public String bk(ArrayList<ChatMsg> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getFromUser() == ChatInfo.mPaid) {
                return arrayList.get(size).getExtLog();
            }
        }
        return null;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void eil() {
        eio();
    }

    public void eim() {
        this.oRO.obtainMessage(32).sendToTarget();
    }

    public void ein() {
        this.oRO.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eio() {
        Message obtainMessage = this.oRO.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void Nj(int i) {
        Message obtainMessage = this.oRO.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nk(int i) {
        Message obtainMessage = this.oRO.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eip() {
        this.oRO.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.oRO.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void eiq() {
        this.oRO.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gA(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.oRO.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gB(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.oRO.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eir() {
        if (ChatInfo.oPg == ChatInfo.ChatCategory.SMART && this.oMW != null) {
            this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oRM.setVisibility(0);
                    a.this.oRL.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.oSl == chatMsg.getMsgId()) {
                            a.this.oMW.showToast(a.this.oMW.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.oSl = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oMW);
                        BIMManager.tryConnection(a.this.oMW);
                        String ehr = com.baidu.yuyinala.privatemessage.implugin.d.a.ehr();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(ehr, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + ehr + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gz(arrayList);
                    a.this.oMW.showToast(a.this.oMW.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oMW.showToast(a.this.oMW.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().bw(a.this.oMW.getActivity(), a.this.oMW.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    eip();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void Xk(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.oRK != null) {
            this.oRK.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        eip();
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
    public void Nl(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.oPg == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.oPl == 2) {
                        if (a.this.oSb + 5 > 20) {
                            i3 = a.this.oSb + 5;
                            a.this.oSc = 5;
                        } else {
                            a.this.oSc = 20 - a.this.oSb;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(a.this.oMW.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C || ChatInfo.oPg == ChatInfo.ChatCategory.B2C || ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.oSb + 5 > 20) {
                            i4 = a.this.oSb + 5;
                            a.this.oSc = 5;
                        } else {
                            a.this.oSc = 20 - a.this.oSb;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(a.this.oMW.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oPg != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(a.this.oMW.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.oRX != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.oRX.cancel();
                                a.this.oRX = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gB((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oPg == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hy(a.this.oMW.getApplicationContext()).e("416", "show", a.this.oSb, a.this.bk((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.eir();
                    }
                    a.this.oSa = true;
                    a.this.oRW = false;
                    a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.eit();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.oRY = 0;
                a.this.oRO.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void Au(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.oRX = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oMW);
            this.oRX.setMessage(this.oMW.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.oRX.setCancelable(true);
            this.oRX.show();
        } else if (this.oRX != null) {
            this.oRX.dismiss();
        }
    }

    public void eis() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.oRY == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oMW;
            if (activityChat != null) {
                if (this.oRX != null) {
                    this.oRX.dismiss();
                }
                this.oRX = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.oRX.setMessage(this.oMW.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.oRX.setCancelable(true);
                this.oRX.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.Nl(1);
                    }
                });
                this.oRX.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.oRY == 0) {
                            a.this.oRY = 1;
                            if (a.this.oRX != null) {
                                a.this.oRX.cancel();
                            }
                            a.this.Nl(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eit() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oPg == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.oRW) {
                Xk(this.oMW.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eiu() {
        if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            Xk(this.oMW.getString(a.h.bd_im_user_version_low));
        }
    }

    public void eiv() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.oSa) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eiu();
                    }
                });
            }
        }).start();
    }

    public void eiw() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            eip();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.oRO.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void Ng(final int i) {
        String string = this.oMW.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oMW, this.oMW.getResources().getString(a.h.bd_im_group_reporttile), string, this.oMW.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oMW.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.eiP();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.eiP();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.eiX().showToast(a.this.oMW, a.this.oMW.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void eix() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oMW, this.oMW.getResources().getString(a.h.bd_im_space_title), this.oMW.getResources().getString(a.h.bd_im_space_prompt), this.oMW.getResources().getString(a.h.bd_im_space_chcek), this.oMW.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.eiP();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.eiP();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oPi);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().ci(jSONObject.toString(), 9);
            }
        });
    }

    private void eiy() {
        this.oRS = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.oRY != 0) {
                    long ekb = f.ekb();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + ekb);
                    if (ekb < 300) {
                        a.this.oRO.post(new RunnableC0964a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.c.b.g(this.oMW, "check_sdcard", System.currentTimeMillis() / 1000);
        this.oRS.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ao(int i, boolean z) {
        if (this.bRa != null && !z) {
            this.oQO = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oMW, this.bRa, i, ChatInfo.mUid);
        }
        return this.oQO;
    }

    /* loaded from: classes10.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oSz;

        private e(a aVar) {
            this.oSz = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oSz.get() != null) {
                try {
                    if (!this.oSz.get().oMW.oQF) {
                        if (this.oSz.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oSz.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oPg == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oSz.get().oMW.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oSz.get().mMsgList.get(0));
                                } else if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C || ChatInfo.oPg == ChatInfo.ChatCategory.B2C || ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oSz.get().oMW.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oSz.get().mMsgList.get(0));
                                } else if (ChatInfo.oPg == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oSz.get().oMW.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oSz.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oPg == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oSz.get().oMW.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oPg == ChatInfo.ChatCategory.C2C || ChatInfo.oPg == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oSz.get().oMW.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oPg == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.ehs().fetchMessageSyncWithState(this.oSz.get().oMW.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oSz.get().oRL.setRefreshTime();
                        this.oSz.get().oRL.ejd();
                        if (pair != null) {
                            this.oSz.get().gB((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oSz.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oSz.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oSz.get().q(true, currentTimeMillis);
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
        private final SoftReference<a> oSz;

        private d(a aVar) {
            this.oSz = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oSz.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oSz.get().mMsgList.add(chatMsg);
                                this.oSz.get().oRK.notifyDataSetChanged();
                                this.oSz.get().eio();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hs(this.oSz.get().oMW).a(chatMsg, this.oSz.get().mKey);
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
                            this.oSz.get().mMsgList.clear();
                            this.oSz.get().oRK.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oSz.get().oRK != null) {
                                this.oSz.get().oRK.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oSz.get().oRK.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oSz.get().oRK.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oSz.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oSz.get().oRL.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oSz.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oSz.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oSz.get().oRK.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oSz.get().oRL != null) {
                                this.oSz.get().oRL.setSelection(this.oSz.get().oRL.getBottom());
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
                            this.oSz.get().eis();
                            return;
                        case 30:
                            this.oSz.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oSz.get().oRL != null && this.oSz.get().oSb > 0) {
                                if (this.oSz.get().oSb + 5 > this.oSz.get().oRK.getCount()) {
                                    this.oSz.get().oSc = this.oSz.get().oRK.getCount() - this.oSz.get().oSb;
                                }
                                if (this.oSz.get().oSc < 3) {
                                    this.oSz.get().oSc = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oSz.get().oSc);
                                this.oSz.get().oRL.setSelection(this.oSz.get().oSc);
                                return;
                            }
                            return;
                        case 32:
                            this.oSz.get().oMW.showToast(this.oSz.get().oMW.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oSz.get().oMW.showToast(this.oSz.get().oMW.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.oSz.get().oRL.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hs(this.oSz.get().oMW).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oSz.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oSz.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oSz.get().mMsgList.iterator();
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
                    if (this.oSz.get().oRW) {
                        this.oSz.get().oRK.notifyDataSetChanged();
                        this.oSz.get().Nk(i4);
                        this.oSz.get().oRW = false;
                        return;
                    }
                    this.oSz.get().oRK.notifyDataSetChanged();
                    this.oSz.get().oRL.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oSz.get().oMW.oQF) {
                    BIMManager.mediaSendChatMsg(this.oSz.get().oMW, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Xm = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eiJ().Xm(((a) d.this.oSz.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oSz.get()).eim();
                            } else if (616 == i) {
                                ((a) d.this.oSz.get()).ein();
                            }
                            Xm.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hs(this.oSz.get().oMW).a(chatMsg, this.oSz.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oSz.get().mMsgList.add(chatMsg);
                this.oSz.get().oRK.notifyDataSetChanged();
                this.oSz.get().eio();
                if (this.oSz.get().oMW.oQF) {
                    BIMManager.mediaSendChatMsg(this.oSz.get().oMW, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Xm = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.eiJ().Xm(((a) d.this.oSz.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oSz.get()).eim();
                            } else if (616 == i) {
                                ((a) d.this.oSz.get()).ein();
                            }
                            Xm.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hs(this.oSz.get().oMW).a(chatMsg, this.oSz.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oSz.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oSz.get().oRV.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oSz.get().j(chatMsg);
                        this.oSz.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oSz.get().oRL.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oSz.get().oRL.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oSz.get().oRL.getChildCount() - this.oSz.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oSz.get().oRK.K(this.oSz.get().oRL.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oSz.get().j(chatMsg);
                        ArrayList arrayList = this.oSz.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oSz.get().mMsgList.add(chatMsg);
                        }
                        this.oSz.get().oRV.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oSz.get().mMsgList.set(j, chatMsg);
                        this.oSz.get().oRV.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oSz.get().mMsgList.set(this.oSz.get().j(chatMsg), chatMsg);
                    }
                    this.oSz.get().oRK.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean ejc = this.oSz.get().oRL.ejc();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oSz.get().mMsgList.iterator();
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
                    this.oSz.get().a(i2, chatMsg, 4);
                    this.oSz.get().oRK.notifyDataSetChanged();
                    if (ejc) {
                        this.oSz.get().eio();
                    } else if (ChatInfo.oPg == ChatInfo.ChatCategory.DUZHAN && this.oSz.get().oSf != null && this.oSz.get().oSa) {
                        this.oSz.get().oSf.ehV();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class RunnableC0964a implements Runnable {
        private final SoftReference<a> oSz;

        private RunnableC0964a(a aVar) {
            this.oSz = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oSz.get() != null) {
                try {
                    this.oSz.get().eix();
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
        public int oSA;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oSB;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oSB = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Xc(localUrl);
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
                    Xc(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.oSA = 1;
                a.this.oRU.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oMW.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oMW.showToast(a.this.oMW.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oMW.showToast(a.this.oMW.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.oRU.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.oRU.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oSA = 1;
                a.this.oRU.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oPi) {
                this.mMsg.setStatus(2);
            }
            a.this.eip();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.eip();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Xc(String str) {
            a.this.oRU.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.oRP != null) {
                    boolean z = a.this.oRP.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.oRP.eiz();
                    if (z) {
                        Xl(str);
                        return;
                    }
                    return;
                }
                Xl(str);
            }
        }

        public void Xl(String str) {
            a.this.oRP = this;
            try {
                a.this.cAB = new MediaPlayer();
                a.this.cAB.setOnCompletionListener(this);
                a.this.cAB.setDataSource(str);
                if (a.this.oRQ) {
                    a.this.cAB.setAudioStreamType(3);
                } else {
                    a.this.cAB.setAudioStreamType(0);
                }
                a.this.cAB.prepare();
                a.this.cAB.start();
                Message obtainMessage = a.this.oRO.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void eiz() {
            if (a.this.cAB != null) {
                a.this.cAB.stop();
                a.this.cAB.release();
                a.this.cAB = null;
                a.this.oRP = null;
                Message obtainMessage = a.this.oRO.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            eiz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oMW.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oRL.setRefreshTime();
                            a.this.oRL.ejd();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oMW.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oMW.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oRL.setRefreshTime();
                            a.this.oRL.ejd();
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
            Message obtainMessage = this.oRO.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
