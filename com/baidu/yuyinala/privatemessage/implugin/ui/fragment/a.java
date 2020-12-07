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
    private View kTF;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private ActivityChat oLm;
    private String oLy;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a oPZ;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oPd;
    private long oQA;
    protected IMListView oQa;
    protected TextView oQb;
    private FrameLayout oQc;
    private d oQd;
    private boolean oQg;
    private c oQi;
    private int oQq;
    private boolean oQt;
    private ActivityChat.c oQu;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a oQw;
    private final int MAX_RETRY_NUM = 3;
    private c oQe = null;
    private boolean oQf = true;
    private Timer oQh = null;
    private HashMap<Long, b> oQj = new HashMap<>();
    private Set<Long> oQk = new HashSet();
    private boolean oQl = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d oQm = null;
    private int oQn = 1;
    private Timer mTimer = null;
    private boolean oQo = false;
    private boolean oQp = false;
    private int oQr = 0;
    private boolean oQs = true;
    private BroadcastReceiver oQv = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.oPZ.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener oLW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.emz().emB() != null) {
                d.emz().emB().emu();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b emB;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b emC = d.emz().emC();
            if (emC != null) {
                emC.emu();
            }
            if (Math.abs(f2) > 10.0f && (emB = d.emz().emB()) != null) {
                emB.emu();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver oQx = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.oQi = d.emz().YK(a.this.mKey);
                if (a.this.oQi != null) {
                    a.this.oQi.elV();
                }
            }
        }
    };
    private BroadcastReceiver oQy = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.oQi = d.emz().YK(a.this.mKey);
                        if (a.this.oQi != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.oQi.i(chatMsg);
                            a.this.oQi.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(a.this.oLm, e2);
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
                    a.this.oQi = d.emz().YK(a.this.mKey);
                    if (a.this.oQi != null) {
                        a.this.oQi.gG(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(a.this.oLm, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.oQi = d.emz().YK(a.this.mKey);
                    if (a.this.oQi != null) {
                        a.this.oQi.gG(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(a.this.oLm, e3);
                }
            }
        }
    };
    private BroadcastReceiver oQz = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.oQi = d.emz().YK(a.this.mKey);
                                if (a.this.oQi != null) {
                                    a.this.oQi.gH(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.elg().c(a.this.oLm, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener oQB = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.eme();
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
        this.oQq = 0;
        this.mKey = "";
        this.oQu = null;
        this.oQu = cVar;
        this.mKey = str;
        this.oQq = i;
        this.oLm = activityChat;
        d.emz().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.oQd = new d();
        this.mMsgList.clear();
        this.oQj.clear();
        this.oQk.clear();
        elY();
        if (f.hv(this.oLm)) {
            emn();
        }
        elR();
        this.kTF = view;
        an(this.kTF);
        if (this.oLm.oOU) {
            j(true, System.currentTimeMillis());
        } else {
            Pd(0);
        }
        elU();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.oLm.getApplicationContext(), this.oQB);
    }

    private void elR() {
        if (!this.oQt) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.oLm.registerReceiver(this.oQv, intentFilter);
            this.oQt = true;
        }
    }

    private void elS() {
        if (this.oQt) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.oLm.unregisterReceiver(this.oQv);
            this.oQt = false;
        }
    }

    public void onPause() {
        this.bGk.unregisterListener(this);
        this.oQo = true;
        elX();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.oLm.getApplicationContext(), this.oQB);
        d.emz().YL(this.mKey);
        if (this.oQh != null) {
            this.oQh.cancel();
        }
        if (this.oQm != null) {
            this.oQm.dismiss();
        }
        elZ();
        ThemeManager.b(this);
        elS();
        elT();
        if (this.oLm.oOU) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.oLm, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void elT() {
        Map<Long, h> elm;
        if (ChatInfo.oNx == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.oOo && (elm = k.hm(this.oLm).elm()) != null && !elm.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : elm.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + "," + hVar.elj());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.C(this.oLm, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVR, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(this.oLm, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oVS, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oNx == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.oQo && ChatInfo.mStatus == 3) {
            if (ChatInfo.oNx == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oLm.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C || ChatInfo.oNx == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oLm.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oNx == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oLm.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    elW();
                    eme();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        elW();
                        gJ((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            eme();
                        }
                    } else {
                        eme();
                    }
                }
            }
        }
        this.oQo = false;
        this.bGk.registerListener(this, this.bGm, 3);
    }

    public void onStart() {
    }

    private void elU() {
        this.bGk = (SensorManager) this.oLm.getSystemService("sensor");
        this.bGm = this.bGk.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void an(View view) {
        this.mGestureDetector = new GestureDetector(this.oLm, this.oLW);
        this.oQc = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.oQa = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.oQb = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String hj = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().hj(this.oLm.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + hj);
        try {
            this.oLy = new JSONObject(hj).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + hj);
        this.oPZ = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.oLm, this.mMsgList, this, this, this, this, this.oQu, this.oLy);
        this.oPZ.a(this.oLm);
        this.oQa.setPullRefreshEnable(true);
        this.oQa.setIMListViewListener(this);
        this.oQa.setAdapter((ListAdapter) this.oPZ);
        this.oQa.setSelector(new ColorDrawable(0));
        this.oQa.setTranscriptMode(1);
        this.oQa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
            this.oQf = false;
        } else {
            this.oQf = true;
        }
        if (this.oQe != null && this.oQg != this.oQf) {
            ChatMsg chatMsg = this.oQe.mMsg;
            View view = this.oQe.mView;
            Boolean valueOf = Boolean.valueOf(this.oQe.oQQ);
            this.oQe.emo();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.oQf) {
                emf();
            }
        }
        this.oQg = this.oQf;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.oQd.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.oQk.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oLm.getApplicationContext())) {
            a(3, chatMsg);
            ema();
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
            if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().bZ(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        String str;
        String str2;
        String str3;
        ImBaseEntity elF;
        if ((this.oLm instanceof ActivityChat) && this.oLm.elC()) {
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
                        if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).enZ() != SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE || !(this.oLm instanceof ActivityChat) || (elF = this.oLm.elF()) == null || elF.mVideoEntity == null) {
                            str = null;
                        } else if (elF.mVideoEntity.isShared) {
                            str4 = TbConfig.TMP_SHARE_DIR_NAME;
                            str5 = "video";
                            str = null;
                        } else {
                            str4 = "other";
                            str5 = "video";
                            str = elF.mVideoEntity.id;
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
            com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.a(str, "notice", "fsq_msg_send", com.baidu.yuyinala.privatemessage.implugin.a.ekV().bip(), com.baidu.yuyinala.privatemessage.implugin.a.ekV().getTag(), str3, null, com.baidu.yuyinala.privatemessage.implugin.a.ekV().ekT(), com.baidu.yuyinala.privatemessage.implugin.a.ekV().ekU(), str2, null, null, String.valueOf(chatMsg.getContacter())), false);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void h(ChatMsg chatMsg) {
        if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND + chatMsg.toString());
        }
        g(chatMsg);
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.oLm.getApplicationContext())) {
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
        this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.oQl && ChatInfo.mStatus == 3) {
                    a.this.gI(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void elV() {
        this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.oQn == 0) {
                    a.this.oQn = 1;
                    a.this.mMsgList.clear();
                    if (a.this.oQm != null) {
                        a.this.oQm.cancel();
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().deleteMsg(this.oLm.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                eme();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void elW() {
        this.mMsgList.clear();
        eme();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0963a
    public void OX(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oLm, this.oLm.getResources().getString(a.h.bd_im_alertdialog_title), this.oLm.getResources().getString(a.h.bd_im_alertdialog_tip), this.oLm.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oLm.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emF();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a oQC;
        final /* synthetic */ int oQD;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.oQC = aVar;
            this.oQD = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.oQC.emF();
            if (this.oQD < 0 || this.oQD >= a.this.mMsgList.size()) {
                a.this.oLm.showToast(a.this.oLm.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.oQD);
            if (!a.this.oLm.oOU) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.elg().deleteMsg(a.this.oLm.getApplicationContext(), chatMsg);
                if (a.this.oQe != null && a.this.oQe.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.oQe.emo();
                }
                a.this.eme();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.oLm, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.oQe != null && a.this.oQe.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.oQe.emo();
                                }
                                a.this.eme();
                            }
                        });
                    }
                }
            });
        }
    }

    public void elX() {
        if (this.oQe != null) {
            this.oQe.emo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.oQa.emT();
        this.oQa.emU();
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
        this.oQw = aVar;
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
                    this.oLm.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void elY() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.oLm.registerReceiver(this.mReceiver, intentFilter);
        this.oLm.registerReceiver(this.oQz, new IntentFilter(IMConstants.SYNC_ACTION));
        this.oLm.registerReceiver(this.oQx, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.oLm.registerReceiver(this.oQy, new IntentFilter("implugin.update.message"));
    }

    private void elZ() {
        this.oLm.unregisterReceiver(this.mReceiver);
        this.oLm.unregisterReceiver(this.oQz);
        this.oLm.unregisterReceiver(this.oQx);
        this.oLm.unregisterReceiver(this.oQy);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.oQe != null && this.oQe.mMsg.getRowId() != chatMsg.getRowId()) {
            this.oQe.emo();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oNz) {
            if (this.oQe == null) {
                this.oQe = new c(chatMsg, view, z);
                this.oQe.YJ(chatMsg.getLocalUrl());
                return;
            }
            this.oQe.emo();
        } else if (this.oQj.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.oQj.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.oQj.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oQP < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oQP++;
                this.oQj.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.elg().markMsgClicked(this.oLm.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN && this.oQs && chatMsg.getStatus() == 0) {
            bq(this.mMsgList);
            this.oQs = false;
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
    public void ema() {
        emd();
    }

    public void emb() {
        this.oQd.obtainMessage(32).sendToTarget();
    }

    public void emc() {
        this.oQd.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emd() {
        Message obtainMessage = this.oQd.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void Pb(int i) {
        Message obtainMessage = this.oQd.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pc(int i) {
        Message obtainMessage = this.oQd.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eme() {
        this.oQd.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.oQd.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void emf() {
        this.oQd.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gI(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.oQd.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gJ(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.oQd.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emg() {
        if (ChatInfo.oNx == ChatInfo.ChatCategory.SMART && this.oLm != null) {
            this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oQb.setVisibility(0);
                    a.this.oQa.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.oQA == chatMsg.getMsgId()) {
                            a.this.oLm.showToast(a.this.oLm.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.oQA = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.oLm);
                        BIMManager.tryConnection(a.this.oLm);
                        String elf = com.baidu.yuyinala.privatemessage.implugin.d.a.elf();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(elf, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + elf + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gH(arrayList);
                    a.this.oLm.showToast(a.this.oLm.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.oLm.showToast(a.this.oLm.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().br(a.this.oLm.getActivity(), a.this.oLm.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    eme();
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
        if (this.oPZ != null) {
            this.oPZ.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        eme();
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
                if (ChatInfo.oNx == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.kpi == 2) {
                        if (a.this.oQq + 5 > 20) {
                            i3 = a.this.oQq + 5;
                            a.this.oQr = 5;
                        } else {
                            a.this.oQr = 20 - a.this.oQq;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(a.this.oLm.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C || ChatInfo.oNx == ChatInfo.ChatCategory.B2C || ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.oQq + 5 > 20) {
                            i4 = a.this.oQq + 5;
                            a.this.oQr = 5;
                        } else {
                            a.this.oQr = 20 - a.this.oQq;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(a.this.oLm.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oNx != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(a.this.oLm.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.oQm != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.oQm.cancel();
                                a.this.oQm = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gJ((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oNx == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.hl(a.this.oLm.getApplicationContext()).e("416", "show", a.this.oQq, a.this.bq((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.emg();
                    }
                    a.this.oQp = true;
                    a.this.oQl = false;
                    a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.emi();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.oQn = 0;
                a.this.oQd.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void Ay(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.oQm = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.oLm);
            this.oQm.setMessage(this.oLm.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.oQm.setCancelable(true);
            this.oQm.show();
        } else if (this.oQm != null) {
            this.oQm.dismiss();
        }
    }

    public void emh() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.oQn == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.oLm;
            if (activityChat != null) {
                if (this.oQm != null) {
                    this.oQm.dismiss();
                }
                this.oQm = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.oQm.setMessage(this.oLm.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.oQm.setCancelable(true);
                this.oQm.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.Pd(1);
                    }
                });
                this.oQm.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.oQn == 0) {
                            a.this.oQn = 1;
                            if (a.this.oQm != null) {
                                a.this.oQm.cancel();
                            }
                            a.this.Pd(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emi() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oNx == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.oQl) {
                YI(this.oLm.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void emj() {
        if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            YI(this.oLm.getString(a.h.bd_im_user_version_low));
        }
    }

    public void emk() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.oQp) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.emj();
                    }
                });
            }
        }).start();
    }

    public void eml() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            eme();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.oQd.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void OY(final int i) {
        String string = this.oLm.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oLm, this.oLm.getResources().getString(a.h.bd_im_group_reporttile), string, this.oLm.getResources().getString(a.h.bd_im_user_zhida_ensure), this.oLm.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emF();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.emF();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.emN().showToast(a.this.oLm, a.this.oLm.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void emm() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.oLm, this.oLm.getResources().getString(a.h.bd_im_space_title), this.oLm.getResources().getString(a.h.bd_im_space_prompt), this.oLm.getResources().getString(a.h.bd_im_space_chcek), this.oLm.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emF();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.emF();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oNz);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.elg().bZ(jSONObject.toString(), 9);
            }
        });
    }

    private void emn() {
        this.oQh = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.oQn != 0) {
                    long enS = f.enS();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + enS);
                    if (enS < 300) {
                        a.this.oQd.post(new RunnableC0967a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.b.b.g(this.oLm, "check_sdcard", System.currentTimeMillis() / 1000);
        this.oQh.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c aq(int i, boolean z) {
        if (this.kTF != null && !z) {
            this.oPd = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.oLm, this.kTF, i, ChatInfo.mUid);
        }
        return this.oPd;
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oQO;

        private e(a aVar) {
            this.oQO = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oQO.get() != null) {
                try {
                    if (!this.oQO.get().oLm.oOU) {
                        if (this.oQO.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oQO.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oNx == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oQO.get().oLm.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oQO.get().mMsgList.get(0));
                                } else if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C || ChatInfo.oNx == ChatInfo.ChatCategory.B2C || ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oQO.get().oLm.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oQO.get().mMsgList.get(0));
                                } else if (ChatInfo.oNx == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oQO.get().oLm.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oQO.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oNx == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oQO.get().oLm.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oNx == ChatInfo.ChatCategory.C2C || ChatInfo.oNx == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oQO.get().oLm.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oNx == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.elg().fetchMessageSyncWithState(this.oQO.get().oLm.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oQO.get().oQa.setRefreshTime();
                        this.oQO.get().oQa.emT();
                        if (pair != null) {
                            this.oQO.get().gJ((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oQO.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oQO.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oQO.get().j(true, currentTimeMillis);
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
        private final SoftReference<a> oQO;

        private d(a aVar) {
            this.oQO = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oQO.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oQO.get().mMsgList.add(chatMsg);
                                this.oQO.get().oPZ.notifyDataSetChanged();
                                this.oQO.get().emd();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQO.get().oLm).a(chatMsg, this.oQO.get().mKey);
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
                            this.oQO.get().mMsgList.clear();
                            this.oQO.get().oPZ.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oQO.get().oPZ != null) {
                                this.oQO.get().oPZ.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oQO.get().oPZ.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oQO.get().oPZ.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oQO.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oQO.get().oQa.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oQO.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oQO.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oQO.get().oPZ.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oQO.get().oQa != null) {
                                this.oQO.get().oQa.setSelection(this.oQO.get().oQa.getBottom());
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
                            this.oQO.get().emh();
                            return;
                        case 30:
                            this.oQO.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oQO.get().oQa != null && this.oQO.get().oQq > 0) {
                                if (this.oQO.get().oQq + 5 > this.oQO.get().oPZ.getCount()) {
                                    this.oQO.get().oQr = this.oQO.get().oPZ.getCount() - this.oQO.get().oQq;
                                }
                                if (this.oQO.get().oQr < 3) {
                                    this.oQO.get().oQr = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oQO.get().oQr);
                                this.oQO.get().oQa.setSelection(this.oQO.get().oQr);
                                return;
                            }
                            return;
                        case 32:
                            this.oQO.get().oLm.showToast(this.oQO.get().oLm.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oQO.get().oLm.showToast(this.oQO.get().oLm.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.oQO.get().oQa.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQO.get().oLm).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oQO.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oQO.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oQO.get().mMsgList.iterator();
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
                    if (this.oQO.get().oQl) {
                        this.oQO.get().oPZ.notifyDataSetChanged();
                        this.oQO.get().Pc(i4);
                        this.oQO.get().oQl = false;
                        return;
                    }
                    this.oQO.get().oPZ.notifyDataSetChanged();
                    this.oQO.get().oQa.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oQO.get().oLm.oOU) {
                    BIMManager.mediaSendChatMsg(this.oQO.get().oLm, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c YK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emz().YK(((a) d.this.oQO.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oQO.get()).emb();
                            } else if (616 == i) {
                                ((a) d.this.oQO.get()).emc();
                            }
                            YK.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQO.get().oLm).a(chatMsg, this.oQO.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oQO.get().mMsgList.add(chatMsg);
                this.oQO.get().oPZ.notifyDataSetChanged();
                this.oQO.get().emd();
                if (this.oQO.get().oLm.oOU) {
                    BIMManager.mediaSendChatMsg(this.oQO.get().oLm, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c YK = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.emz().YK(((a) d.this.oQO.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oQO.get()).emb();
                            } else if (616 == i) {
                                ((a) d.this.oQO.get()).emc();
                            }
                            YK.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.hf(this.oQO.get().oLm).a(chatMsg, this.oQO.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oQO.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oQO.get().oQk.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oQO.get().j(chatMsg);
                        this.oQO.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oQO.get().oQa.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oQO.get().oQa.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oQO.get().oQa.getChildCount() - this.oQO.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oQO.get().oPZ.F(this.oQO.get().oQa.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oQO.get().j(chatMsg);
                        ArrayList arrayList = this.oQO.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oQO.get().mMsgList.add(chatMsg);
                        }
                        this.oQO.get().oQk.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oQO.get().mMsgList.set(j, chatMsg);
                        this.oQO.get().oQk.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oQO.get().mMsgList.set(this.oQO.get().j(chatMsg), chatMsg);
                    }
                    this.oQO.get().oPZ.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean emS = this.oQO.get().oQa.emS();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oQO.get().mMsgList.iterator();
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
                    this.oQO.get().a(i2, chatMsg, 4);
                    this.oQO.get().oPZ.notifyDataSetChanged();
                    if (emS) {
                        this.oQO.get().emd();
                    } else if (ChatInfo.oNx == ChatInfo.ChatCategory.DUZHAN && this.oQO.get().oQu != null && this.oQO.get().oQp) {
                        this.oQO.get().oQu.elJ();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class RunnableC0967a implements Runnable {
        private final SoftReference<a> oQO;

        private RunnableC0967a(a aVar) {
            this.oQO = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oQO.get() != null) {
                try {
                    this.oQO.get().emm();
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
        public int oQP;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oQQ;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oQQ = z;
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
                bVar.oQP = 1;
                a.this.oQj.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.oLm.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.oLm.showToast(a.this.oLm.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.oLm.showToast(a.this.oLm.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.oQj.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.oQj.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oQP = 1;
                a.this.oQj.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oNz) {
                this.mMsg.setStatus(2);
            }
            a.this.eme();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.eme();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void YA(String str) {
            a.this.oQj.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.oQe != null) {
                    boolean z = a.this.oQe.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.oQe.emo();
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
            a.this.oQe = this;
            try {
                a.this.cAx = new MediaPlayer();
                a.this.cAx.setOnCompletionListener(this);
                a.this.cAx.setDataSource(str);
                if (a.this.oQf) {
                    a.this.cAx.setAudioStreamType(3);
                } else {
                    a.this.cAx.setAudioStreamType(0);
                }
                a.this.cAx.prepare();
                a.this.cAx.start();
                Message obtainMessage = a.this.oQd.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void emo() {
            if (a.this.cAx != null) {
                a.this.cAx.stop();
                a.this.cAx.release();
                a.this.cAx = null;
                a.this.oQe = null;
                Message obtainMessage = a.this.oQd.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            emo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.oLm.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oQa.setRefreshTime();
                            a.this.oQa.emT();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.oLm.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.oLm.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oQa.setRefreshTime();
                            a.this.oQa.emT();
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
            Message obtainMessage = this.oQd.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
