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
public class a implements SensorEventListener, a.InterfaceC0946a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private SensorManager bBc;
    private Sensor bBe;
    private MediaPlayer ctD;
    private View kGn;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a oAT;
    protected IMListView oAU;
    protected TextView oAV;
    private FrameLayout oAW;
    private d oAX;
    private boolean oBa;
    private c oBc;
    private int oBk;
    private boolean oBn;
    private ActivityChat.c oBo;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a oBq;
    private long oBu;
    private ActivityChat owg;
    private String ows;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c ozX;
    private final int MAX_RETRY_NUM = 3;
    private c oAY = null;
    private boolean oAZ = true;
    private Timer oBb = null;
    private HashMap<Long, b> oBd = new HashMap<>();
    private Set<Long> oBe = new HashSet();
    private boolean oBf = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d oBg = null;
    private int oBh = 1;
    private Timer mTimer = null;
    private boolean oBi = false;
    private boolean oBj = false;
    private int oBl = 0;
    private boolean oBm = true;
    private BroadcastReceiver oBp = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.oAT.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener owQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.egL().egN() != null) {
                d.egL().egN().egG();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b egN;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b egO = d.egL().egO();
            if (egO != null) {
                egO.egG();
            }
            if (Math.abs(f2) > 10.0f && (egN = d.egL().egN()) != null) {
                egN.egG();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver oBr = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.oBc = d.egL().Xp(a.this.mKey);
                if (a.this.oBc != null) {
                    a.this.oBc.egh();
                }
            }
        }
    };
    private BroadcastReceiver oBs = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.oBc = d.egL().Xp(a.this.mKey);
                        if (a.this.oBc != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.oBc.i(chatMsg);
                            a.this.oBc.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(a.this.owg, e2);
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
                    a.this.oBc = d.egL().Xp(a.this.mKey);
                    if (a.this.oBc != null) {
                        a.this.oBc.gr(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(a.this.owg, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.oBc = d.egL().Xp(a.this.mKey);
                    if (a.this.oBc != null) {
                        a.this.oBc.gr(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(a.this.owg, e3);
                }
            }
        }
    };
    private BroadcastReceiver oBt = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.oBc = d.egL().Xp(a.this.mKey);
                                if (a.this.oBc != null) {
                                    a.this.oBc.gs(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.eft().c(a.this.owg, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener oBv = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.egq();
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
        this.oBk = 0;
        this.mKey = "";
        this.oBo = null;
        this.oBo = cVar;
        this.mKey = str;
        this.oBk = i;
        this.owg = activityChat;
        d.egL().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.oAX = new d();
        this.mMsgList.clear();
        this.oBd.clear();
        this.oBe.clear();
        egk();
        if (f.gM(this.owg)) {
            egz();
        }
        egd();
        this.kGn = view;
        al(this.kGn);
        if (this.owg.ozO) {
            j(true, System.currentTimeMillis());
        } else {
            Of(0);
        }
        egg();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.owg.getApplicationContext(), this.oBv);
    }

    private void egd() {
        if (!this.oBn) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.owg.registerReceiver(this.oBp, intentFilter);
            this.oBn = true;
        }
    }

    private void ege() {
        if (this.oBn) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.owg.unregisterReceiver(this.oBp);
            this.oBn = false;
        }
    }

    public void onPause() {
        this.bBc.unregisterListener(this);
        this.oBi = true;
        egj();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.owg.getApplicationContext(), this.oBv);
        d.egL().Xq(this.mKey);
        if (this.oBb != null) {
            this.oBb.cancel();
        }
        if (this.oBg != null) {
            this.oBg.dismiss();
        }
        egl();
        ThemeManager.b(this);
        ege();
        egf();
        if (this.owg.ozO) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.owg, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void egf() {
        Map<Long, h> efy;
        if (ChatInfo.oyr == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.ozi && (efy = k.gD(this.owg).efy()) != null && !efy.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : efy.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + Constants.ACCEPT_TIME_SEPARATOR_SP + hVar.efw());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.A(this.owg, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGL, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(this.owg, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oGM, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.oyr == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.oBi && ChatInfo.mStatus == 3) {
            if (ChatInfo.oyr == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.owg.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C || ChatInfo.oyr == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.owg.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.oyr == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.owg.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    egi();
                    egq();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        egi();
                        gu((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            egq();
                        }
                    } else {
                        egq();
                    }
                }
            }
        }
        this.oBi = false;
        this.bBc.registerListener(this, this.bBe, 3);
    }

    public void onStart() {
    }

    private void egg() {
        this.bBc = (SensorManager) this.owg.getSystemService("sensor");
        this.bBe = this.bBc.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void al(View view) {
        this.mGestureDetector = new GestureDetector(this.owg, this.owQ);
        this.oAW = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.oAU = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.oAV = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String gA = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().gA(this.owg.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + gA);
        try {
            this.ows = new JSONObject(gA).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + gA);
        this.oAT = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.owg, this.mMsgList, this, this, this, this, this.oBo, this.ows);
        this.oAT.a(this.owg);
        this.oAU.setPullRefreshEnable(true);
        this.oAU.setIMListViewListener(this);
        this.oAU.setAdapter((ListAdapter) this.oAT);
        this.oAU.setSelector(new ColorDrawable(0));
        this.oAU.setTranscriptMode(1);
        this.oAU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
        if (sensorEvent.values[0] < this.bBe.getMaximumRange()) {
            this.oAZ = false;
        } else {
            this.oAZ = true;
        }
        if (this.oAY != null && this.oBa != this.oAZ) {
            ChatMsg chatMsg = this.oAY.mMsg;
            View view = this.oAY.mView;
            Boolean valueOf = Boolean.valueOf(this.oAY.oBK);
            this.oAY.egA();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.oAZ) {
                egr();
            }
        }
        this.oBa = this.oAZ;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.oAX.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.oBe.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.owg.getApplicationContext())) {
            a(3, chatMsg);
            egm();
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
            if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().bU(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        String str;
        String str2;
        String str3;
        ImBaseEntity efR;
        if ((this.owg instanceof ActivityChat) && this.owg.efO()) {
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
                        if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).eik() != SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE || !(this.owg instanceof ActivityChat) || (efR = this.owg.efR()) == null || efR.mVideoEntity == null) {
                            str = null;
                        } else if (efR.mVideoEntity.isShared) {
                            str4 = TbConfig.TMP_SHARE_DIR_NAME;
                            str5 = "video";
                            str = null;
                        } else {
                            str4 = "other";
                            str5 = "video";
                            str = efR.mVideoEntity.id;
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
            com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.a(str, LogConfig.KEY_NOTICE, "fsq_msg_send", com.baidu.yuyinala.privatemessage.implugin.a.efi().bfk(), com.baidu.yuyinala.privatemessage.implugin.a.efi().getTag(), str3, null, com.baidu.yuyinala.privatemessage.implugin.a.efi().efg(), com.baidu.yuyinala.privatemessage.implugin.a.efi().efh(), str2, null, null, String.valueOf(chatMsg.getContacter())), false);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void h(ChatMsg chatMsg) {
        if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND + chatMsg.toString());
        }
        g(chatMsg);
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.owg.getApplicationContext())) {
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
    public void gr(final List<ChatMsg> list) {
        this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.oBf && ChatInfo.mStatus == 3) {
                    a.this.gt(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void egh() {
        this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.oBh == 0) {
                    a.this.oBh = 1;
                    a.this.mMsgList.clear();
                    if (a.this.oBg != null) {
                        a.this.oBg.cancel();
                    }
                    a.this.Of(1);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void gs(List<Long> list) {
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.eft().deleteMsg(this.owg.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                egq();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void egi() {
        this.mMsgList.clear();
        egq();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0946a
    public void NZ(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.owg, this.owg.getResources().getString(a.h.bd_im_alertdialog_title), this.owg.getResources().getString(a.h.bd_im_alertdialog_tip), this.owg.getResources().getString(a.h.bd_im_user_zhida_ensure), this.owg.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egR();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a oBw;
        final /* synthetic */ int oBx;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.oBw = aVar;
            this.oBx = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.oBw.egR();
            if (this.oBx < 0 || this.oBx >= a.this.mMsgList.size()) {
                a.this.owg.showToast(a.this.owg.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.oBx);
            if (!a.this.owg.ozO) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.eft().deleteMsg(a.this.owg.getApplicationContext(), chatMsg);
                if (a.this.oAY != null && a.this.oAY.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.oAY.egA();
                }
                a.this.egq();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.owg, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.oAY != null && a.this.oAY.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.oAY.egA();
                                }
                                a.this.egq();
                            }
                        });
                    }
                }
            });
        }
    }

    public void egj() {
        if (this.oAY != null) {
            this.oAY.egA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.oAU.ehf();
        this.oAU.ehg();
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
        this.oBq = aVar;
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
                    this.owg.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void egk() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.owg.registerReceiver(this.mReceiver, intentFilter);
        this.owg.registerReceiver(this.oBt, new IntentFilter(IMConstants.SYNC_ACTION));
        this.owg.registerReceiver(this.oBr, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.owg.registerReceiver(this.oBs, new IntentFilter("implugin.update.message"));
    }

    private void egl() {
        this.owg.unregisterReceiver(this.mReceiver);
        this.owg.unregisterReceiver(this.oBt);
        this.owg.unregisterReceiver(this.oBr);
        this.owg.unregisterReceiver(this.oBs);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.oAY != null && this.oAY.mMsg.getRowId() != chatMsg.getRowId()) {
            this.oAY.egA();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.oyt) {
            if (this.oAY == null) {
                this.oAY = new c(chatMsg, view, z);
                this.oAY.Xo(chatMsg.getLocalUrl());
                return;
            }
            this.oAY.egA();
        } else if (this.oBd.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.oBd.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.oBd.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oBJ < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oBJ++;
                this.oBd.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.eft().markMsgClicked(this.owg.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN && this.oBm && chatMsg.getStatus() == 0) {
            bn(this.mMsgList);
            this.oBm = false;
        }
    }

    public String bn(ArrayList<ChatMsg> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getFromUser() == ChatInfo.mPaid) {
                return arrayList.get(size).getExtLog();
            }
        }
        return null;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void egm() {
        egp();
    }

    public void egn() {
        this.oAX.obtainMessage(32).sendToTarget();
    }

    public void ego() {
        this.oAX.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egp() {
        Message obtainMessage = this.oAX.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void Od(int i) {
        Message obtainMessage = this.oAX.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oe(int i) {
        Message obtainMessage = this.oAX.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egq() {
        this.oAX.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.oAX.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void egr() {
        this.oAX.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.oAX.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.oAX.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egs() {
        if (ChatInfo.oyr == ChatInfo.ChatCategory.SMART && this.owg != null) {
            this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.oAV.setVisibility(0);
                    a.this.oAU.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.oBu == chatMsg.getMsgId()) {
                            a.this.owg.showToast(a.this.owg.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.oBu = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.owg);
                        BIMManager.tryConnection(a.this.owg);
                        String efs = com.baidu.yuyinala.privatemessage.implugin.d.a.efs();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(efs, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + efs + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gs(arrayList);
                    a.this.owg.showToast(a.this.owg.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.owg.showToast(a.this.owg.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().bn(a.this.owg.getActivity(), a.this.owg.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    egq();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void Xn(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.oAT != null) {
            this.oAT.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        egq();
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
    public void Of(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.oyr == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.kbE == 2) {
                        if (a.this.oBk + 5 > 20) {
                            i3 = a.this.oBk + 5;
                            a.this.oBl = 5;
                        } else {
                            a.this.oBl = 20 - a.this.oBk;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(a.this.owg.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C || ChatInfo.oyr == ChatInfo.ChatCategory.B2C || ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.oBk + 5 > 20) {
                            i4 = a.this.oBk + 5;
                            a.this.oBl = 5;
                        } else {
                            a.this.oBl = 20 - a.this.oBk;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(a.this.owg.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.oyr != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(a.this.owg.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.oBg != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.oBg.cancel();
                                a.this.oBg = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gu((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN || ChatInfo.oyr == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.gC(a.this.owg.getApplicationContext()).b("416", "show", a.this.oBk, a.this.bn((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.egs();
                    }
                    a.this.oBj = true;
                    a.this.oBf = false;
                    a.this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.egu();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.oBh = 0;
                a.this.oAX.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void zU(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.oBg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.owg);
            this.oBg.setMessage(this.owg.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.oBg.setCancelable(true);
            this.oBg.show();
        } else if (this.oBg != null) {
            this.oBg.dismiss();
        }
    }

    public void egt() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.oBh == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.owg;
            if (activityChat != null) {
                if (this.oBg != null) {
                    this.oBg.dismiss();
                }
                this.oBg = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.oBg.setMessage(this.owg.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.oBg.setCancelable(true);
                this.oBg.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.Of(1);
                    }
                });
                this.oBg.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.oBh == 0) {
                            a.this.oBh = 1;
                            if (a.this.oBg != null) {
                                a.this.oBg.cancel();
                            }
                            a.this.Of(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egu() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.oyr == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.oBf) {
                Xn(this.owg.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egv() {
        if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            Xn(this.owg.getString(a.h.bd_im_user_version_low));
        }
    }

    public void egw() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.oBj) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.egv();
                    }
                });
            }
        }).start();
    }

    public void egx() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            egq();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.oAX.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void Oa(final int i) {
        String string = this.owg.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.owg, this.owg.getResources().getString(a.h.bd_im_group_reporttile), string, this.owg.getResources().getString(a.h.bd_im_user_zhida_ensure), this.owg.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egR();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.egR();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.egZ().showToast(a.this.owg, a.this.owg.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void egy() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.owg, this.owg.getResources().getString(a.h.bd_im_space_title), this.owg.getResources().getString(a.h.bd_im_space_prompt), this.owg.getResources().getString(a.h.bd_im_space_chcek), this.owg.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egR();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egR();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.oyt);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.eft().bU(jSONObject.toString(), 9);
            }
        });
    }

    private void egz() {
        this.oBb = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.oBh != 0) {
                    long eid = f.eid();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + eid);
                    if (eid < 300) {
                        a.this.oAX.post(new RunnableC0950a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.b.b.g(this.owg, "check_sdcard", System.currentTimeMillis() / 1000);
        this.oBb.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c aq(int i, boolean z) {
        if (this.kGn != null && !z) {
            this.ozX = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.owg, this.kGn, i, ChatInfo.mUid);
        }
        return this.ozX;
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oBI;

        private e(a aVar) {
            this.oBI = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oBI.get() != null) {
                try {
                    if (!this.oBI.get().owg.ozO) {
                        if (this.oBI.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oBI.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.oyr == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.oBI.get().owg.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oBI.get().mMsgList.get(0));
                                } else if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C || ChatInfo.oyr == ChatInfo.ChatCategory.B2C || ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.oBI.get().owg.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oBI.get().mMsgList.get(0));
                                } else if (ChatInfo.oyr == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.oBI.get().owg.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oBI.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.oyr == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.oBI.get().owg.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oyr == ChatInfo.ChatCategory.C2C || ChatInfo.oyr == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.oBI.get().owg.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.oyr == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.eft().fetchMessageSyncWithState(this.oBI.get().owg.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oBI.get().oAU.setRefreshTime();
                        this.oBI.get().oAU.ehf();
                        if (pair != null) {
                            this.oBI.get().gu((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oBI.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oBI.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oBI.get().j(true, currentTimeMillis);
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
        private final SoftReference<a> oBI;

        private d(a aVar) {
            this.oBI = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oBI.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oBI.get().mMsgList.add(chatMsg);
                                this.oBI.get().oAT.notifyDataSetChanged();
                                this.oBI.get().egp();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.gv(this.oBI.get().owg).a(chatMsg, this.oBI.get().mKey);
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
                            this.oBI.get().mMsgList.clear();
                            this.oBI.get().oAT.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oBI.get().oAT != null) {
                                this.oBI.get().oAT.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oBI.get().oAT.aU(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oBI.get().oAT.aV(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oBI.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oBI.get().oAU.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oBI.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oBI.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oBI.get().oAT.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oBI.get().oAU != null) {
                                this.oBI.get().oAU.setSelection(this.oBI.get().oAU.getBottom());
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
                            this.oBI.get().egt();
                            return;
                        case 30:
                            this.oBI.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oBI.get().oAU != null && this.oBI.get().oBk > 0) {
                                if (this.oBI.get().oBk + 5 > this.oBI.get().oAT.getCount()) {
                                    this.oBI.get().oBl = this.oBI.get().oAT.getCount() - this.oBI.get().oBk;
                                }
                                if (this.oBI.get().oBl < 3) {
                                    this.oBI.get().oBl = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oBI.get().oBl);
                                this.oBI.get().oAU.setSelection(this.oBI.get().oBl);
                                return;
                            }
                            return;
                        case 32:
                            this.oBI.get().owg.showToast(this.oBI.get().owg.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oBI.get().owg.showToast(this.oBI.get().owg.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.oBI.get().oAU.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.gv(this.oBI.get().owg).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oBI.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oBI.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oBI.get().mMsgList.iterator();
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
                    if (this.oBI.get().oBf) {
                        this.oBI.get().oAT.notifyDataSetChanged();
                        this.oBI.get().Oe(i4);
                        this.oBI.get().oBf = false;
                        return;
                    }
                    this.oBI.get().oAT.notifyDataSetChanged();
                    this.oBI.get().oAU.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oBI.get().owg.ozO) {
                    BIMManager.mediaSendChatMsg(this.oBI.get().owg, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Xp = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egL().Xp(((a) d.this.oBI.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oBI.get()).egn();
                            } else if (616 == i) {
                                ((a) d.this.oBI.get()).ego();
                            }
                            Xp.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.gv(this.oBI.get().owg).a(chatMsg, this.oBI.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oBI.get().mMsgList.add(chatMsg);
                this.oBI.get().oAT.notifyDataSetChanged();
                this.oBI.get().egp();
                if (this.oBI.get().owg.ozO) {
                    BIMManager.mediaSendChatMsg(this.oBI.get().owg, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c Xp = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egL().Xp(((a) d.this.oBI.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oBI.get()).egn();
                            } else if (616 == i) {
                                ((a) d.this.oBI.get()).ego();
                            }
                            Xp.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.gv(this.oBI.get().owg).a(chatMsg, this.oBI.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oBI.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oBI.get().oBe.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oBI.get().j(chatMsg);
                        this.oBI.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oBI.get().oAU.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oBI.get().oAU.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oBI.get().oAU.getChildCount() - this.oBI.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oBI.get().oAT.F(this.oBI.get().oAU.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oBI.get().j(chatMsg);
                        ArrayList arrayList = this.oBI.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oBI.get().mMsgList.add(chatMsg);
                        }
                        this.oBI.get().oBe.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oBI.get().mMsgList.set(j, chatMsg);
                        this.oBI.get().oBe.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oBI.get().mMsgList.set(this.oBI.get().j(chatMsg), chatMsg);
                    }
                    this.oBI.get().oAT.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean ehe = this.oBI.get().oAU.ehe();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oBI.get().mMsgList.iterator();
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
                    this.oBI.get().a(i2, chatMsg, 4);
                    this.oBI.get().oAT.notifyDataSetChanged();
                    if (ehe) {
                        this.oBI.get().egp();
                    } else if (ChatInfo.oyr == ChatInfo.ChatCategory.DUZHAN && this.oBI.get().oBo != null && this.oBI.get().oBj) {
                        this.oBI.get().oBo.efV();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class RunnableC0950a implements Runnable {
        private final SoftReference<a> oBI;

        private RunnableC0950a(a aVar) {
            this.oBI = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oBI.get() != null) {
                try {
                    this.oBI.get().egy();
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
        public int oBJ;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oBK;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oBK = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Xf(localUrl);
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
                    Xf(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.oBJ = 1;
                a.this.oBd.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.owg.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.owg.showToast(a.this.owg.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.owg.showToast(a.this.owg.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.oBd.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.oBd.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oBJ = 1;
                a.this.oBd.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.oyt) {
                this.mMsg.setStatus(2);
            }
            a.this.egq();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.egq();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Xf(String str) {
            a.this.oBd.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.oAY != null) {
                    boolean z = a.this.oAY.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.oAY.egA();
                    if (z) {
                        Xo(str);
                        return;
                    }
                    return;
                }
                Xo(str);
            }
        }

        public void Xo(String str) {
            a.this.oAY = this;
            try {
                a.this.ctD = new MediaPlayer();
                a.this.ctD.setOnCompletionListener(this);
                a.this.ctD.setDataSource(str);
                if (a.this.oAZ) {
                    a.this.ctD.setAudioStreamType(3);
                } else {
                    a.this.ctD.setAudioStreamType(0);
                }
                a.this.ctD.prepare();
                a.this.ctD.start();
                Message obtainMessage = a.this.oAX.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void egA() {
            if (a.this.ctD != null) {
                a.this.ctD.stop();
                a.this.ctD.release();
                a.this.ctD = null;
                a.this.oAY = null;
                Message obtainMessage = a.this.oAX.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            egA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.owg.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oAU.setRefreshTime();
                            a.this.oAU.ehf();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.owg.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.owg.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.oAU.setRefreshTime();
                            a.this.oAU.ehf();
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
            Message obtainMessage = this.oAX.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
