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
public class a implements SensorEventListener, a.InterfaceC0943a, a.b, a.c, a.d, c, IMListView.a, ThemeManager.a {
    private SensorManager bCN;
    private Sensor bCP;
    private MediaPlayer cvp;
    private View kFY;
    private GestureDetector mGestureDetector;
    private String mKey;
    private ArrayList<ChatMsg> mMsgList;
    private ActivityChat ouC;
    private String ouO;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c oyt;
    private int ozG;
    private boolean ozJ;
    private ActivityChat.c ozK;
    private com.baidu.yuyinala.privatemessage.implugin.ui.activity.a ozM;
    private long ozQ;
    protected com.baidu.yuyinala.privatemessage.implugin.a.a ozp;
    protected IMListView ozq;
    protected TextView ozr;
    private FrameLayout ozs;
    private d ozt;
    private boolean ozw;
    private c ozy;
    private final int MAX_RETRY_NUM = 3;
    private c ozu = null;
    private boolean ozv = true;
    private Timer ozx = null;
    private HashMap<Long, b> ozz = new HashMap<>();
    private Set<Long> ozA = new HashSet();
    private boolean ozB = true;
    private com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d ozC = null;
    private int ozD = 1;
    private Timer mTimer = null;
    private boolean ozE = false;
    private boolean ozF = false;
    private int ozH = 0;
    private boolean ozI = true;
    private BroadcastReceiver ozL = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_SET".equals(intent.getAction())) {
                a.this.ozp.notifyDataSetChanged();
            }
        }
    };
    private GestureDetector.OnGestureListener ovm = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.12
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (d.egN().egP() != null) {
                d.egN().egP().egI();
            }
            return super.onSingleTapConfirmed(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b egP;
            com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.b egQ = d.egN().egQ();
            if (egQ != null) {
                egQ.egI();
            }
            if (Math.abs(f2) > 10.0f && (egP = d.egN().egP()) != null) {
                egP.egI();
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return super.onDown(motionEvent);
        }
    };
    private BroadcastReceiver ozN = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.19
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(IMConstants.MSG_SYNC_COMPLETE)) {
                a.this.ozy = d.egN().XE(a.this.mKey);
                if (a.this.ozy != null) {
                    a.this.ozy.egj();
                }
            }
        }
    };
    private BroadcastReceiver ozO = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.20
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("implugin.update.message".equals(intent.getAction())) {
                try {
                    ChatMsg chatMsg = (ChatMsg) intent.getParcelableExtra("message");
                    if (chatMsg.getContacter() == ChatInfo.mContacter) {
                        a.this.ozy = d.egN().XE(a.this.mKey);
                        if (a.this.ozy != null) {
                            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING receive update message");
                            a.this.ozy.i(chatMsg);
                            a.this.ozy.m(chatMsg);
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(a.this.ouC, e2);
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
                    a.this.ozy = d.egN().XE(a.this.mKey);
                    if (a.this.ozy != null) {
                        a.this.ozy.gr(arrayList);
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(a.this.ouC, e2);
                }
            } else if (IMConstants.CUSTOMER_CHANGE.equals(action)) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.clear();
                    arrayList2.add((NotifyCustomerMsg) intent.getParcelableExtra(IMConstants.MESSAGE));
                    a.this.ozy = d.egN().XE(a.this.mKey);
                    if (a.this.ozy != null) {
                        a.this.ozy.gr(arrayList2);
                    }
                } catch (Exception e3) {
                    Log.e("ChatFragment", e3.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(a.this.ouC, e3);
                }
            }
        }
    };
    private BroadcastReceiver ozP = new BroadcastReceiver() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.22
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
                                a.this.ozy = d.egN().XE(a.this.mKey);
                                if (a.this.ozy != null) {
                                    a.this.ozy.gs(arrayList);
                                }
                                arrayList.clear();
                            }
                        }
                    }
                } catch (Exception e2) {
                    Log.e("ChatFragment", e2.getMessage());
                    com.baidu.yuyinala.privatemessage.implugin.d.b.efv().c(a.this.ouC, e2);
                }
            }
        }
    };
    private IMediaChatMsgChangedListener ozR = new IMediaChatMsgChangedListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.16
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
                            a.this.egs();
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
        this.ozG = 0;
        this.mKey = "";
        this.ozK = null;
        this.ozK = cVar;
        this.mKey = str;
        this.ozG = i;
        this.ouC = activityChat;
        d.egN().a(this.mKey, this);
        this.mMsgList = new ArrayList<>();
        this.ozt = new d();
        this.mMsgList.clear();
        this.ozz.clear();
        this.ozA.clear();
        egm();
        if (f.gO(this.ouC)) {
            egB();
        }
        egf();
        this.kFY = view;
        al(this.kFY);
        if (this.ouC.oyk) {
            j(true, System.currentTimeMillis());
        } else {
            NC(0);
        }
        egi();
        ThemeManager.a(this);
        BIMManager.mediaRegisterChatMsgChangedListener(this.ouC.getApplicationContext(), this.ozR);
    }

    private void egf() {
        if (!this.ozJ) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            this.ouC.registerReceiver(this.ozL, intentFilter);
            this.ozJ = true;
        }
    }

    private void egg() {
        if (this.ozJ) {
            new IntentFilter().addAction("android.intent.action.TIME_SET");
            this.ouC.unregisterReceiver(this.ozL);
            this.ozJ = false;
        }
    }

    public void onPause() {
        this.bCN.unregisterListener(this);
        this.ozE = true;
        egl();
    }

    public void onStop() {
    }

    public void onDestroy() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", MissionEvent.MESSAGE_DESTROY);
        BIMManager.mediaUnRegisterChatMsgChangedListener(this.ouC.getApplicationContext(), this.ozR);
        d.egN().XF(this.mKey);
        if (this.ozx != null) {
            this.ozx.cancel();
        }
        if (this.ozC != null) {
            this.ozC.dismiss();
        }
        egn();
        ThemeManager.b(this);
        egg();
        egh();
        if (this.ouC.oyk) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mMsgList != null && !this.mMsgList.isEmpty()) {
                currentTimeMillis = this.mMsgList.get(this.mMsgList.size() - 1).getMsgTime();
            }
            BIMManager.mediaSetSessionRead(this.ouC, ChatInfo.mUid, currentTimeMillis, null);
        }
    }

    private void egh() {
        Map<Long, h> efA;
        if (ChatInfo.owN == ChatInfo.ChatCategory.SMART && com.baidu.yuyinala.privatemessage.implugin.f.a.oxE && (efA = k.gF(this.ouC).efA()) != null && !efA.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (h hVar : efA.values()) {
                stringBuffer.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR + hVar.getId() + Constants.ACCEPT_TIME_SEPARATOR_SP + hVar.efy());
            }
            if (!TextUtils.isEmpty(stringBuffer.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.A(this.ouC, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFh, stringBuffer.substring(1, stringBuffer.toString().length()));
                com.baidu.yuyinala.privatemessage.implugin.util.b.b.e(this.ouC, com.baidu.yuyinala.privatemessage.implugin.util.b.a.oFi, System.currentTimeMillis());
            }
        }
    }

    public void onResume() {
        Pair<Integer, ArrayList<ChatMsg>> pair = null;
        if ((ChatInfo.mContacter > 0 || ChatInfo.owN == ChatInfo.ChatCategory.SMART) && this.mMsgList.size() > 0 && this.ozE && ChatInfo.mStatus == 3) {
            if (ChatInfo.owN == ChatInfo.ChatCategory.GROUP) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.ouC.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.owN == ChatInfo.ChatCategory.C2C || ChatInfo.owN == ChatInfo.ChatCategory.B2C) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.ouC.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
            } else if (ChatInfo.owN == ChatInfo.ChatCategory.SMART) {
                pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.ouC.getApplicationContext(), 0, 17L, 20, null);
            }
            if (pair != null && pair.second != null) {
                if (((ArrayList) pair.second).size() <= 0) {
                    egk();
                    egs();
                } else {
                    int size = ((ArrayList) pair.second).size();
                    int size2 = this.mMsgList.size() <= 20 ? this.mMsgList.size() : 20;
                    if (size > 0 && size < size2) {
                        egk();
                        gu((List) pair.second);
                    }
                    if (this.mMsgList.size() > 0) {
                        if (this.mMsgList.get(this.mMsgList.size() - 1).getMsgId() != ((ChatMsg) ((ArrayList) pair.second).get(((ArrayList) pair.second).size() - 1)).getMsgId()) {
                            egs();
                        }
                    } else {
                        egs();
                    }
                }
            }
        }
        this.ozE = false;
        this.bCN.registerListener(this, this.bCP, 3);
    }

    public void onStart() {
    }

    private void egi() {
        this.bCN = (SensorManager) this.ouC.getSystemService("sensor");
        this.bCP = this.bCN.getDefaultSensor(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void al(View view) {
        this.mGestureDetector = new GestureDetector(this.ouC, this.ovm);
        this.ozs = (FrameLayout) view.findViewById(a.f.bd_im_chating_list_root);
        this.ozq = (IMListView) view.findViewById(a.f.bd_im_listView);
        this.ozr = (TextView) view.findViewById(a.f.bd_im_empty_smart);
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo  0");
        String gC = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().gC(this.ouC.getApplicationContext());
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 1" + gC);
        try {
            this.ouO = new JSONObject(gC).optString("loginbuid");
        } catch (JSONException e2) {
            LogUtils.e("ChatFragment", "parse json login user info error");
            e2.printStackTrace();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData get login userinfo 2 " + gC);
        this.ozp = new com.baidu.yuyinala.privatemessage.implugin.a.a(this.ouC, this.mMsgList, this, this, this, this, this.ozK, this.ouO);
        this.ozp.a(this.ouC);
        this.ozq.setPullRefreshEnable(true);
        this.ozq.setIMListViewListener(this);
        this.ozq.setAdapter((ListAdapter) this.ozp);
        this.ozq.setSelector(new ColorDrawable(0));
        this.ozq.setTranscriptMode(1);
        this.ozq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.23
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
        if (sensorEvent.values[0] < this.bCP.getMaximumRange()) {
            this.ozv = false;
        } else {
            this.ozv = true;
        }
        if (this.ozu != null && this.ozw != this.ozv) {
            ChatMsg chatMsg = this.ozu.mMsg;
            View view = this.ozu.mView;
            Boolean valueOf = Boolean.valueOf(this.ozu.oAg);
            this.ozu.egC();
            a(chatMsg, view, -1, valueOf.booleanValue());
            if (this.ozv) {
                egt();
            }
        }
        this.ozw = this.ozv;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.listview.IMListView.a
    public void onRefresh() {
        this.ozt.post(new e());
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(ChatMsg chatMsg) {
        if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN) {
            chatMsg.setChatType(7);
        }
        chatMsg.setReSend();
        chatMsg.setStatus(1);
        k(chatMsg);
        this.ozA.add(Long.valueOf(chatMsg.getRowId()));
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.ouC.getApplicationContext())) {
            a(3, chatMsg);
            ego();
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
            if (ChatInfo.owN == ChatInfo.ChatCategory.C2C) {
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
        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().bV(jSONObject.toString(), 5);
    }

    private void g(ChatMsg chatMsg) {
        String str;
        String str2;
        String str3;
        ImBaseEntity efT;
        if ((this.ouC instanceof ActivityChat) && this.ouC.efQ()) {
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
                        if (new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg).eim() != SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE || !(this.ouC instanceof ActivityChat) || (efT = this.ouC.efT()) == null || efT.mVideoEntity == null) {
                            str = null;
                        } else if (efT.mVideoEntity.isShared) {
                            str4 = TbConfig.TMP_SHARE_DIR_NAME;
                            str5 = "video";
                            str = null;
                        } else {
                            str4 = "other";
                            str5 = "video";
                            str = efT.mVideoEntity.id;
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
            com.baidu.yuyinala.privatemessage.implugin.a.j(com.baidu.yuyinala.privatemessage.implugin.a.a(str, LogConfig.KEY_NOTICE, "fsq_msg_send", com.baidu.yuyinala.privatemessage.implugin.a.efk().bfR(), com.baidu.yuyinala.privatemessage.implugin.a.efk().getTag(), str3, null, com.baidu.yuyinala.privatemessage.implugin.a.efk().efi(), com.baidu.yuyinala.privatemessage.implugin.a.efk().efj(), str2, null, null, String.valueOf(chatMsg.getContacter())), false);
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void h(ChatMsg chatMsg) {
        if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", UbcStatConstant.ContentType.UBC_TYPE_IM_SEND + chatMsg.toString());
        }
        g(chatMsg);
        if (com.baidu.yuyinala.privatemessage.implugin.util.e.isConnected(this.ouC.getApplicationContext())) {
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
        this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.24
            @Override // java.lang.Runnable
            public void run() {
                if (com.baidu.yuyinala.privatemessage.implugin.util.c.isDebugMode()) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "receive" + list.toString());
                }
                if (!a.this.ozB && ChatInfo.mStatus == 3) {
                    a.this.gt(list);
                }
            }
        });
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void egj() {
        this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.25
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "Data sync end for broadcast");
                if (a.this.ozD == 0) {
                    a.this.ozD = 1;
                    a.this.mMsgList.clear();
                    if (a.this.ozC != null) {
                        a.this.ozC.cancel();
                    }
                    a.this.NC(1);
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
                        com.baidu.yuyinala.privatemessage.implugin.d.b.efv().deleteMsg(this.ouC.getApplicationContext(), this.mMsgList.remove(i3));
                        break;
                    }
                }
                i = i2 + 1;
            } else {
                egs();
                return;
            }
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void egk() {
        this.mMsgList.clear();
        egs();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.InterfaceC0943a
    public void Nw(int i) {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.ouC, this.ouC.getResources().getString(a.h.bd_im_alertdialog_title), this.ouC.getResources().getString(a.h.bd_im_alertdialog_tip), this.ouC.getResources().getString(a.h.bd_im_user_zhida_ensure), this.ouC.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egT();
            }
        }, new AnonymousClass3(aVar, i));
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$3  reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass3 implements View.OnClickListener {
        final /* synthetic */ com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a ozS;
        final /* synthetic */ int ozT;

        AnonymousClass3(com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar, int i) {
            this.ozS = aVar;
            this.ozT = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.ozS.egT();
            if (this.ozT < 0 || this.ozT >= a.this.mMsgList.size()) {
                a.this.ouC.showToast(a.this.ouC.getString(a.h.bd_im_alertdialog_error));
                return;
            }
            final ChatMsg chatMsg = (ChatMsg) a.this.mMsgList.remove(this.ozT);
            if (!a.this.ouC.oyk) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.efv().deleteMsg(a.this.ouC.getApplicationContext(), chatMsg);
                if (a.this.ozu != null && a.this.ozu.mMsg.getMsgId() == chatMsg.getMsgId()) {
                    a.this.ozu.egC();
                }
                a.this.egs();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(chatMsg.getMsgId()));
            BIMManager.mediaDeleteChatMsg(a.this.ouC, ChatInfo.mUid, arrayList, new IMediaDeleteChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1
                @Override // com.baidu.android.imsdk.chatmessage.IMediaDeleteChatMsgListener
                public void onMediaDeleteChatMsgResult(int i, String str) {
                    Log.d("ChatFragment", "BC> code=" + i + ", strmsg=" + str);
                    if (i == 0) {
                        a.this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (a.this.ozu != null && a.this.ozu.mMsg.getMsgId() == chatMsg.getMsgId()) {
                                    a.this.ozu.egC();
                                }
                                a.this.egs();
                            }
                        });
                    }
                }
            });
        }
    }

    public void egl() {
        if (this.ozu != null) {
            this.ozu.egC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoad() {
        this.ozq.ehh();
        this.ozq.ehi();
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
        this.ozM = aVar;
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
                    this.ouC.showToast("当前不支持查看哦");
                    return;
                default:
                    return;
            }
        }
    }

    private void egm() {
        IntentFilter intentFilter = new IntentFilter(IMConstants.MESSAGE_ACTION);
        intentFilter.addAction(IMConstants.CUSTOMER_CHANGE);
        this.ouC.registerReceiver(this.mReceiver, intentFilter);
        this.ouC.registerReceiver(this.ozP, new IntentFilter(IMConstants.SYNC_ACTION));
        this.ouC.registerReceiver(this.ozN, new IntentFilter(IMConstants.MSG_SYNC_COMPLETE));
        this.ouC.registerReceiver(this.ozO, new IntentFilter("implugin.update.message"));
    }

    private void egn() {
        this.ouC.unregisterReceiver(this.mReceiver);
        this.ouC.unregisterReceiver(this.ozP);
        this.ouC.unregisterReceiver(this.ozN);
        this.ouC.unregisterReceiver(this.ozO);
    }

    private void a(ChatMsg chatMsg, View view, int i, boolean z) {
        if (this.ozu != null && this.ozu.mMsg.getRowId() != chatMsg.getRowId()) {
            this.ozu.egC();
        }
        if (new File(chatMsg.getLocalUrl()).exists() && chatMsg.getFromUser() == ChatInfo.owP) {
            if (this.ozu == null) {
                this.ozu = new c(chatMsg, view, z);
                this.ozu.XD(chatMsg.getLocalUrl());
                return;
            }
            this.ozu.egC();
        } else if (this.ozz.containsKey(Long.valueOf(chatMsg.getMsgId())) && this.ozz.get(Long.valueOf(chatMsg.getMsgId())).mState == 2) {
            b bVar = this.ozz.get(Long.valueOf(chatMsg.getMsgId()));
            if (bVar.oAf < 3) {
                c cVar = new c(chatMsg, view, z);
                bVar.oAf++;
                this.ozz.put(Long.valueOf(chatMsg.getMsgId()), bVar);
                cVar.execute();
            }
        } else {
            if (chatMsg.getMsgType() == 2 && i >= 0 && i < this.mMsgList.size()) {
                com.baidu.yuyinala.privatemessage.implugin.d.b.efv().markMsgClicked(this.ouC.getApplicationContext(), chatMsg);
                this.mMsgList.get(i).setMsgReaded(1);
            }
            new c(chatMsg, view, z).execute();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void k(ChatMsg chatMsg) {
        a(5, chatMsg);
        if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN && this.ozI && chatMsg.getStatus() == 0) {
            bm(this.mMsgList);
            this.ozI = false;
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
    public void ego() {
        egr();
    }

    public void egp() {
        this.ozt.obtainMessage(32).sendToTarget();
    }

    public void egq() {
        this.ozt.obtainMessage(33).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egr() {
        Message obtainMessage = this.ozt.obtainMessage(15);
        obtainMessage.arg1 = this.mMsgList.size() - 1;
        obtainMessage.sendToTarget();
    }

    public void NA(int i) {
        Message obtainMessage = this.ozt.obtainMessage(31);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NB(int i) {
        Message obtainMessage = this.ozt.obtainMessage(15);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egs() {
        this.ozt.obtainMessage(7).sendToTarget();
    }

    private void a(int i, ChatMsg chatMsg) {
        Message obtainMessage = this.ozt.obtainMessage(i);
        obtainMessage.obj = chatMsg;
        if (chatMsg instanceof ImageMsg) {
            obtainMessage.arg1 = ((ImageMsg) chatMsg).getProgress();
        }
        obtainMessage.sendToTarget();
    }

    private void egt() {
        this.ozt.obtainMessage(13).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gt(List<ChatMsg> list) {
        if (list.size() > 0) {
            Message obtainMessage = this.ozt.obtainMessage(4);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gu(List<ChatMsg> list) {
        if (list != null && list.size() > 0) {
            Message obtainMessage = this.ozt.obtainMessage(10);
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egu() {
        if (ChatInfo.owN == ChatInfo.ChatCategory.SMART && this.ouC != null) {
            this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ozr.setVisibility(0);
                    a.this.ozq.setVisibility(8);
                }
            });
        }
    }

    @Override // com.baidu.android.imsdk.chatmessage.ISendMessageListener
    public void onSendMessageResult(final int i, final ChatMsg chatMsg) {
        this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (1001 == i) {
                    if (chatMsg != null) {
                        if (a.this.ozQ == chatMsg.getMsgId()) {
                            a.this.ouC.showToast(a.this.ouC.getString(a.h.bd_im_network_error_send_msg_fail));
                            return;
                        }
                        a.this.ozQ = chatMsg.getMsgId();
                        AccountManager.disconnect(a.this.ouC);
                        BIMManager.tryConnection(a.this.ouC);
                        String efu = com.baidu.yuyinala.privatemessage.implugin.d.a.efu();
                        String bduss = com.baidu.yuyinala.privatemessage.implugin.d.a.getBDUSS();
                        BIMManager.login(efu, bduss, 1, "", "", new ILoginListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.5.1
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
                        LogUtils.i("ChatFragment", "ImSdk loginToIM isLogin：uid：" + efu + "， bduss：" + bduss + "， from：，cfrom：");
                    }
                } else if (1204 == i) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Long.valueOf(chatMsg.getMsgId()));
                    a.this.gs(arrayList);
                    a.this.ouC.showToast(a.this.ouC.getString(a.h.bd_im_zhida_send_error));
                } else if (615 == i) {
                    a.this.ouC.showToast(a.this.ouC.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                } else if (616 == i) {
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().bq(a.this.ouC.getActivity(), a.this.ouC.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    egs();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "LOADING update message status ");
                }
            }
        }
    }

    private void XC(String str) {
        NotifyCustomerMsg notifyCustomerMsg = new NotifyCustomerMsg(0);
        notifyCustomerMsg.setMsgType(-1);
        notifyCustomerMsg.setText(str);
        this.mMsgList.add(notifyCustomerMsg);
        if (this.ozp != null) {
            this.ozp.notifyDataSetChanged();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.c.i("ChatFragment", "=============add error for chat===========");
        egs();
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
    public void NC(final int i) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "fetchMsgData times " + i);
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6
            @Override // java.lang.Runnable
            public void run() {
                Pair<Integer, ArrayList<ChatMsg>> fetchMessageSyncWithState;
                int i2;
                if (ChatInfo.owN == ChatInfo.ChatCategory.GROUP) {
                    int i3 = 20;
                    if (ChatInfo.kaU == 2) {
                        if (a.this.ozG + 5 > 20) {
                            i3 = a.this.ozG + 5;
                            a.this.ozH = 5;
                        } else {
                            a.this.ozH = 20 - a.this.ozG;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(a.this.ouC.getApplicationContext(), 1, ChatInfo.mContacter, i3, null);
                } else if (ChatInfo.owN == ChatInfo.ChatCategory.C2C || ChatInfo.owN == ChatInfo.ChatCategory.B2C || ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN) {
                    int i4 = 20;
                    if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN) {
                        if (a.this.ozG + 5 > 20) {
                            i4 = a.this.ozG + 5;
                            a.this.ozH = 5;
                        } else {
                            a.this.ozH = 20 - a.this.ozG;
                        }
                    }
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(a.this.ouC.getApplicationContext(), 0, ChatInfo.mContacter, i4, null);
                } else if (ChatInfo.owN != ChatInfo.ChatCategory.SMART) {
                    fetchMessageSyncWithState = null;
                } else {
                    fetchMessageSyncWithState = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(a.this.ouC.getApplicationContext(), 0, 17L, 20, null);
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
                    a.this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.ozC != null) {
                                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "dismiss progress");
                                a.this.ozC.cancel();
                                a.this.ozC = null;
                            }
                        }
                    });
                    if (fetchMessageSyncWithState != null && fetchMessageSyncWithState.second != null && ((ArrayList) fetchMessageSyncWithState.second).size() > 0) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "RECEIVETEST fetchMsgData data " + i2);
                        a.this.gu((List) fetchMessageSyncWithState.second);
                        if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN || ChatInfo.owN == ChatInfo.ChatCategory.C2C) {
                            com.baidu.yuyinala.privatemessage.implugin.e.a.gE(a.this.ouC.getApplicationContext()).b("416", "show", a.this.ozG, a.this.bm((ArrayList) fetchMessageSyncWithState.second));
                        }
                    } else {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", "RECEIVETEST fetchMsgData error ");
                        a.this.egu();
                    }
                    a.this.ozF = true;
                    a.this.ozB = false;
                    a.this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.egw();
                        }
                    });
                    return;
                }
                com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "BB fetchMsgData no data ");
                a.this.ozD = 0;
                a.this.ozt.obtainMessage(20).sendToTarget();
            }
        }).start();
    }

    public void zN(boolean z) {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "showSync " + z + " this " + this);
        if (z) {
            this.ozC = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(this.ouC);
            this.ozC.setMessage(this.ouC.getResources().getString(a.h.bd_im_listview_header_hint_loading));
            this.ozC.setCancelable(true);
            this.ozC.show();
        } else if (this.ozC != null) {
            this.ozC.dismiss();
        }
    }

    public void egv() {
        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "initSyncTimer this " + this);
        if (this.ozD == 0) {
            com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "Data syncing -- ");
            ActivityChat activityChat = this.ouC;
            if (activityChat != null) {
                if (this.ozC != null) {
                    this.ozC.dismiss();
                }
                this.ozC = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.d(activityChat);
                this.ozC.setMessage(this.ouC.getResources().getString(a.h.bd_im_listview_header_hint_loading));
                this.ozC.setCancelable(true);
                this.ozC.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.7
                    @Override // android.content.DialogInterface.OnCancelListener
                    public void onCancel(DialogInterface dialogInterface) {
                        a.this.NC(1);
                    }
                });
                this.ozC.show();
                this.mTimer = new Timer(true);
                this.mTimer.schedule(new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.8
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "TimerTask run");
                        if (a.this.ozD == 0) {
                            a.this.ozD = 1;
                            if (a.this.ozC != null) {
                                a.this.ozC.cancel();
                            }
                            a.this.NC(1);
                        }
                    }
                }, 20000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egw() {
        int i = ChatInfo.mStatus;
        if (ChatInfo.owN == ChatInfo.ChatCategory.B2C) {
            if ((i == 1 || i == 2 || i == 4) && this.ozB) {
                XC(this.ouC.getString(a.h.bd_im_zhida_expire));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void egx() {
        if (ChatInfo.owN == ChatInfo.ChatCategory.C2C && 10 == ChatInfo.mStatus) {
            XC(this.ouC.getString(a.h.bd_im_user_version_low));
        }
    }

    public void egy() {
        new Thread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9
            @Override // java.lang.Runnable
            public void run() {
                while (!a.this.ozF) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e2) {
                        com.baidu.yuyinala.privatemessage.implugin.util.c.e("ChatFragment", e2.getMessage() + "");
                    }
                }
                a.this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.egx();
                    }
                });
            }
        }).start();
    }

    public void egz() {
        if (this.mMsgList != null) {
            this.mMsgList.clear();
            egs();
        }
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.c
    public void m(ChatMsg chatMsg) {
        Message obtainMessage = this.ozt.obtainMessage(30);
        obtainMessage.obj = chatMsg;
        obtainMessage.sendToTarget();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void Nx(final int i) {
        String string = this.ouC.getResources().getString(a.h.bd_im_group_reportprompt);
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.ouC, this.ouC.getResources().getString(a.h.bd_im_group_reporttile), string, this.ouC.getResources().getString(a.h.bd_im_user_zhida_ensure), this.ouC.getResources().getString(a.h.bd_im_user_zhida_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egT();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                aVar.egT();
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
                    com.baidu.yuyinala.privatemessage.implugin.ui.material.a.e.ehb().showToast(a.this.ouC, a.this.ouC.getString(a.h.bd_im_group_report));
                }
            }
        });
    }

    public void egA() {
        final com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a aVar = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.a(this.ouC, this.ouC.getResources().getString(a.h.bd_im_space_title), this.ouC.getResources().getString(a.h.bd_im_space_prompt), this.ouC.getResources().getString(a.h.bd_im_space_chcek), this.ouC.getResources().getString(a.h.bd_im_space_cancel));
        aVar.show();
        aVar.a(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egT();
            }
        }, new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aVar.egT();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("key_contactid", ChatInfo.owP);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.baidu.yuyinala.privatemessage.implugin.d.b.efv().bV(jSONObject.toString(), 9);
            }
        });
    }

    private void egB() {
        this.ozx = new Timer(true);
        TimerTask timerTask = new TimerTask() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.15
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (a.this.ozD != 0) {
                    long eif = f.eif();
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("ChatFragment", "DISK freesize is  " + eif);
                    if (eif < 300) {
                        a.this.ozt.post(new RunnableC0947a());
                    }
                }
            }
        };
        com.baidu.yuyinala.privatemessage.implugin.util.b.b.g(this.ouC, "check_sdcard", System.currentTimeMillis() / 1000);
        this.ozx.schedule(timerTask, 4000L);
    }

    public com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c aq(int i, boolean z) {
        if (this.kFY != null && !z) {
            this.oyt = new com.baidu.yuyinala.privatemessage.implugin.ui.material.a.c(this.ouC, this.kFY, i, ChatInfo.mUid);
        }
        return this.oyt;
    }

    /* loaded from: classes4.dex */
    private static class e implements Runnable {
        private final SoftReference<a> oAe;

        private e(a aVar) {
            this.oAe = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Pair<Integer, ArrayList<ChatMsg>> pair = null;
            if (this.oAe.get() != null) {
                try {
                    if (!this.oAe.get().ouC.oyk) {
                        if (this.oAe.get().mMsgList.size() > 0) {
                            if (((ChatMsg) this.oAe.get().mMsgList.get(0)).getMsgId() != 0) {
                                if (ChatInfo.owN == ChatInfo.ChatCategory.GROUP) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.oAe.get().ouC.getApplicationContext(), 1, ChatInfo.mContacter, -20, (ChatMsg) this.oAe.get().mMsgList.get(0));
                                } else if (ChatInfo.owN == ChatInfo.ChatCategory.C2C || ChatInfo.owN == ChatInfo.ChatCategory.B2C || ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.oAe.get().ouC.getApplicationContext(), 0, ChatInfo.mContacter, -20, (ChatMsg) this.oAe.get().mMsgList.get(0));
                                } else if (ChatInfo.owN == ChatInfo.ChatCategory.SMART) {
                                    pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.oAe.get().ouC.getApplicationContext(), 0, 17L, -20, (ChatMsg) this.oAe.get().mMsgList.get(0));
                                }
                            }
                        } else if (ChatInfo.owN == ChatInfo.ChatCategory.GROUP) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.oAe.get().ouC.getApplicationContext(), 1, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.owN == ChatInfo.ChatCategory.C2C || ChatInfo.owN == ChatInfo.ChatCategory.B2C) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.oAe.get().ouC.getApplicationContext(), 0, ChatInfo.mContacter, 20, null);
                        } else if (ChatInfo.owN == ChatInfo.ChatCategory.SMART) {
                            pair = com.baidu.yuyinala.privatemessage.implugin.d.b.efv().fetchMessageSyncWithState(this.oAe.get().ouC.getApplicationContext(), 0, 17L, -20, null);
                        }
                        this.oAe.get().ozq.setRefreshTime();
                        this.oAe.get().ozq.ehh();
                        if (pair != null) {
                            this.oAe.get().gu((List) pair.second);
                            return;
                        }
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.oAe.get().mMsgList.size() > 0) {
                        long msgTime = ((ChatMsg) this.oAe.get().mMsgList.get(0)).getMsgTime();
                        LogUtils.d("ChatFragment", "BC> lastMsg time = " + msgTime);
                        currentTimeMillis = msgTime;
                    }
                    this.oAe.get().j(true, currentTimeMillis);
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
        private final SoftReference<a> oAe;

        private d(a aVar) {
            this.oAe = new SoftReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.oAe.get() != null) {
                try {
                    switch (message.what) {
                        case 1:
                            if (message.obj != null) {
                                ChatMsg chatMsg = (ChatMsg) message.obj;
                                this.oAe.get().mMsgList.add(chatMsg);
                                this.oAe.get().ozp.notifyDataSetChanged();
                                this.oAe.get().egr();
                                com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oAe.get().ouC).a(chatMsg, this.oAe.get().mKey);
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
                            this.oAe.get().mMsgList.clear();
                            this.oAe.get().ozp.notifyDataSetChanged();
                            return;
                        case 7:
                            if (this.oAe.get().ozp != null) {
                                this.oAe.get().ozp.notifyDataSetChanged();
                                return;
                            }
                            return;
                        case 8:
                            if (message.obj != null) {
                                this.oAe.get().ozp.aT(message.obj);
                                return;
                            }
                            return;
                        case 9:
                            if (message.obj != null) {
                                this.oAe.get().ozp.aU(message.obj);
                                return;
                            }
                            return;
                        case 10:
                            R(message);
                            return;
                        case 11:
                            this.oAe.get().onLoad();
                            return;
                        case 12:
                        case 13:
                            return;
                        case 14:
                            if (message.obj != null) {
                                ArrayList arrayList = (ArrayList) message.obj;
                                if (arrayList == null) {
                                    this.oAe.get().ozq.setPullRefreshEnable(false);
                                }
                                if (arrayList != null) {
                                    Collections.reverse(arrayList);
                                    if (message.arg1 == 1) {
                                        this.oAe.get().mMsgList.addAll(arrayList);
                                    } else {
                                        this.oAe.get().mMsgList.addAll(0, arrayList);
                                    }
                                    this.oAe.get().ozp.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 15:
                            if (this.oAe.get().ozq != null) {
                                this.oAe.get().ozq.setSelection(this.oAe.get().ozq.getBottom());
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
                            this.oAe.get().egv();
                            return;
                        case 30:
                            this.oAe.get().l((ChatMsg) message.obj);
                            return;
                        case 31:
                            if (this.oAe.get().ozq != null && this.oAe.get().ozG > 0) {
                                if (this.oAe.get().ozG + 5 > this.oAe.get().ozp.getCount()) {
                                    this.oAe.get().ozH = this.oAe.get().ozp.getCount() - this.oAe.get().ozG;
                                }
                                if (this.oAe.get().ozH < 3) {
                                    this.oAe.get().ozH = 3;
                                }
                                Log.d("ChatFragment", "unreadposition = " + this.oAe.get().ozH);
                                this.oAe.get().ozq.setSelection(this.oAe.get().ozH);
                                return;
                            }
                            return;
                        case 32:
                            this.oAe.get().ouC.showToast(this.oAe.get().ouC.getString(a.h.bd_im_error_msg_unsubscribe_me_tips));
                            return;
                        case 33:
                            this.oAe.get().ouC.showToast(this.oAe.get().ouC.getString(a.h.bd_im_error_msg_sheild_me_tips));
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
                    this.oAe.get().ozq.setPullRefreshEnable(false);
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
                            com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oAe.get().ouC).a((ImageMsg) chatMsg);
                        }
                        int i3 = 0;
                        if (0 != chatMsg.getMsgId()) {
                            Iterator it = this.oAe.get().mMsgList.iterator();
                            while (it.hasNext()) {
                                ChatMsg chatMsg2 = (ChatMsg) it.next();
                                if (chatMsg.getMsgId() < chatMsg2.getMsgId() || (chatMsg.getMsgId() == chatMsg2.getMsgId() && chatMsg.getRowId() < chatMsg2.getRowId())) {
                                    break;
                                }
                                i3++;
                            }
                            if (-1 != i3 && this.oAe.get().a(i3, chatMsg, 10) == 0 && j < chatMsg.getMsgId()) {
                                j = chatMsg.getMsgId();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                int i4 = 0;
                Iterator it2 = this.oAe.get().mMsgList.iterator();
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
                    if (this.oAe.get().ozB) {
                        this.oAe.get().ozp.notifyDataSetChanged();
                        this.oAe.get().NB(i4);
                        this.oAe.get().ozB = false;
                        return;
                    }
                    this.oAe.get().ozp.notifyDataSetChanged();
                    this.oAe.get().ozq.setSelectionMove(i4);
                }
            }
        }

        private void S(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (this.oAe.get().ouC.oyk) {
                    BIMManager.mediaSendChatMsg(this.oAe.get().ouC, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.1
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c XE = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egN().XE(((a) d.this.oAe.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oAe.get()).egp();
                            } else if (616 == i) {
                                ((a) d.this.oAe.get()).egq();
                            }
                            XE.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oAe.get().ouC).a(chatMsg, this.oAe.get().mKey);
                }
            }
        }

        private void T(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                this.oAe.get().mMsgList.add(chatMsg);
                this.oAe.get().ozp.notifyDataSetChanged();
                this.oAe.get().egr();
                if (this.oAe.get().ouC.oyk) {
                    BIMManager.mediaSendChatMsg(this.oAe.get().ouC, ChatInfo.mUid, chatMsg, new IMediaSendChatMsgListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.2
                        @Override // com.baidu.android.imsdk.chatmessage.IMediaSendChatMsgListener
                        public void onMediaSendChatMsgResult(int i, ChatMsg chatMsg2) {
                            Log.d("ChatFragment", "BC> code=" + i + ", sendChatMsg=" + chatMsg2);
                            c XE = com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.d.egN().XE(((a) d.this.oAe.get()).mKey);
                            if (i == 0) {
                                chatMsg2.setStatus(0);
                            } else {
                                chatMsg2.setStatus(2);
                            }
                            if (615 == i) {
                                ((a) d.this.oAe.get()).egp();
                            } else if (616 == i) {
                                ((a) d.this.oAe.get()).egq();
                            }
                            XE.k(chatMsg2);
                        }
                    });
                } else {
                    com.baidu.yuyinala.privatemessage.implugin.b.a.gx(this.oAe.get().ouC).a(chatMsg, this.oAe.get().mKey);
                }
            }
        }

        private void U(Message message) {
            if (message.obj != null) {
                ChatMsg chatMsg = (ChatMsg) message.obj;
                if (chatMsg instanceof ImageMsg) {
                    ((ImageMsg) chatMsg).setProgress(message.arg1);
                }
                int j = this.oAe.get().j(chatMsg);
                if (j != -1) {
                    if (!this.oAe.get().ozA.contains(Long.valueOf(chatMsg.getRowId()))) {
                        int j2 = this.oAe.get().j(chatMsg);
                        this.oAe.get().mMsgList.set(j2, chatMsg);
                        int firstVisiblePosition = this.oAe.get().ozq.getFirstVisiblePosition() - 1;
                        int i = firstVisiblePosition < 0 ? 0 : firstVisiblePosition;
                        int lastVisiblePosition = this.oAe.get().ozq.getLastVisiblePosition() - 2;
                        if (j2 >= i && j2 <= lastVisiblePosition) {
                            int i2 = j2 - i;
                            if (this.oAe.get().ozq.getChildCount() - this.oAe.get().mMsgList.size() == 2) {
                                i2++;
                            }
                            this.oAe.get().ozp.D(this.oAe.get().ozq.getChildAt(i2), j2);
                            return;
                        }
                        return;
                    }
                    if (chatMsg.getStatus() == 0) {
                        int j3 = this.oAe.get().j(chatMsg);
                        ArrayList arrayList = this.oAe.get().mMsgList;
                        arrayList.remove(j3);
                        if (arrayList.size() > 0 && ((ChatMsg) arrayList.get(arrayList.size() - 1)).getMsgId() != chatMsg.getMsgId()) {
                            this.oAe.get().mMsgList.add(chatMsg);
                        }
                        this.oAe.get().ozA.remove(Long.valueOf(chatMsg.getRowId()));
                    } else if (chatMsg.getStatus() == 2) {
                        this.oAe.get().mMsgList.set(j, chatMsg);
                        this.oAe.get().ozA.remove(Long.valueOf(chatMsg.getRowId()));
                    } else {
                        this.oAe.get().mMsgList.set(this.oAe.get().j(chatMsg), chatMsg);
                    }
                    this.oAe.get().ozp.notifyDataSetChanged();
                }
            }
        }

        private void V(Message message) {
            boolean ehg = this.oAe.get().ozq.ehg();
            if (message.obj != null) {
                ArrayList arrayList = (ArrayList) message.obj;
                for (int i = 0; i < arrayList.size(); i++) {
                    ChatMsg chatMsg = (ChatMsg) arrayList.get(i);
                    Iterator it = this.oAe.get().mMsgList.iterator();
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
                    this.oAe.get().a(i2, chatMsg, 4);
                    this.oAe.get().ozp.notifyDataSetChanged();
                    if (ehg) {
                        this.oAe.get().egr();
                    } else if (ChatInfo.owN == ChatInfo.ChatCategory.DUZHAN && this.oAe.get().ozK != null && this.oAe.get().ozF) {
                        this.oAe.get().ozK.efX();
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class RunnableC0947a implements Runnable {
        private final SoftReference<a> oAe;

        private RunnableC0947a(a aVar) {
            this.oAe = new SoftReference<>(aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.oAe.get() != null) {
                try {
                    this.oAe.get().egA();
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
        public int oAf;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c implements MediaPlayer.OnCompletionListener, com.baidu.yuyinala.privatemessage.implugin.c.a.b {
        private String mFilePath;
        private ChatMsg mMsg;
        private View mView;
        private boolean oAg;

        c(ChatMsg chatMsg, View view, boolean z) {
            this.mMsg = chatMsg;
            this.mView = view;
            this.oAg = z;
        }

        public void execute() {
            String str = null;
            if (this.mMsg.getMsgType() == 2) {
                String localUrl = this.mMsg.getLocalUrl();
                if (!TextUtils.isEmpty(localUrl) && new File(localUrl).exists()) {
                    Xu(localUrl);
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
                    Xu(this.mFilePath);
                    return;
                }
                b bVar = new b();
                bVar.mState = 0;
                bVar.oAf = 1;
                a.this.ozz.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
                new com.baidu.yuyinala.privatemessage.implugin.c.a.a(a.this.ouC.getApplicationContext(), str, this.mFilePath, this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                return;
            }
            onFailed(-1);
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onFailed(int i) {
            if (this.mFilePath == null) {
                a.this.ouC.showToast(a.this.ouC.getString(a.h.bd_im_can_not_pick_this_file));
                return;
            }
            a.this.ouC.showToast(a.this.ouC.getString(a.h.bd_im_download_failure));
            File file = new File(this.mFilePath);
            if (file.exists()) {
                file.delete();
            }
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(0);
            }
            if (a.this.ozz.containsKey(Long.valueOf(this.mMsg.getMsgId()))) {
                ((b) a.this.ozz.get(Long.valueOf(this.mMsg.getMsgId()))).mState = 2;
            } else {
                b bVar = new b();
                bVar.mState = 2;
                bVar.oAf = 1;
                a.this.ozz.put(Long.valueOf(this.mMsg.getMsgId()), bVar);
            }
            if (this.mMsg.getFromUser() != ChatInfo.owP) {
                this.mMsg.setStatus(2);
            }
            a.this.egs();
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void onProgress(int i) {
            if (this.mMsg instanceof ImageMsg) {
                ((ImageMsg) this.mMsg).setProgress(i);
                a.this.egs();
            }
        }

        @Override // com.baidu.yuyinala.privatemessage.implugin.c.a.b
        public void Xu(String str) {
            a.this.ozz.remove(Long.valueOf(this.mMsg.getMsgId()));
            if (this.mMsg.getMsgType() != 1 && this.mMsg.getMsgType() == 2) {
                if (a.this.ozu != null) {
                    boolean z = a.this.ozu.mFilePath.equals(this.mFilePath) ? false : true;
                    a.this.ozu.egC();
                    if (z) {
                        XD(str);
                        return;
                    }
                    return;
                }
                XD(str);
            }
        }

        public void XD(String str) {
            a.this.ozu = this;
            try {
                a.this.cvp = new MediaPlayer();
                a.this.cvp.setOnCompletionListener(this);
                a.this.cvp.setDataSource(str);
                if (a.this.ozv) {
                    a.this.cvp.setAudioStreamType(3);
                } else {
                    a.this.cvp.setAudioStreamType(0);
                }
                a.this.cvp.prepare();
                a.this.cvp.start();
                Message obtainMessage = a.this.ozt.obtainMessage(8);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            } catch (IOException e) {
                Log.e("ChatFragment", "startAudioPlay", e);
            }
        }

        public void egC() {
            if (a.this.cvp != null) {
                a.this.cvp.stop();
                a.this.cvp.release();
                a.this.cvp = null;
                a.this.ozu = null;
                Message obtainMessage = a.this.ozt.obtainMessage(9);
                obtainMessage.obj = this.mView;
                obtainMessage.sendToTarget();
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            egC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final boolean z, long j) {
        Log.d("ChatFragment", "BC> pullHistoryMsg=" + z + ", time=" + j);
        if (z) {
            BIMManager.mediaFetchChatMsgs(this.ouC.getApplicationContext(), ChatInfo.mUid, 0L, j, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.17.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ozq.setRefreshTime();
                            a.this.ozq.ehh();
                        }
                    });
                    if (i == 0 && list != null && !list.isEmpty()) {
                        a.this.i(z, list);
                    }
                }
            });
        } else {
            BIMManager.mediaFetchChatMsgs(this.ouC.getApplicationContext(), ChatInfo.mUid, j, 0L, 20, new IMediaFetchChatMsgsListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18
                @Override // com.baidu.android.imsdk.chatmessage.IMediaFetchChatMsgsListener
                public void onMediaFetchChatMsgsResult(int i, String str, boolean z2, List<ChatMsg> list) {
                    Log.d("ChatFragment", "BC> responseCode=" + i + ", strMsg=" + str + ", hasMore=" + z2 + ", msgs=" + list);
                    a.this.ouC.runOnUiThread(new Runnable() { // from class: com.baidu.yuyinala.privatemessage.implugin.ui.fragment.a.18.1
                        @Override // java.lang.Runnable
                        public void run() {
                            a.this.ozq.setRefreshTime();
                            a.this.ozq.ehh();
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
            Message obtainMessage = this.ozt.obtainMessage(14);
            obtainMessage.obj = list;
            if (!z) {
                obtainMessage.arg1 = 1;
            }
            obtainMessage.sendToTarget();
        }
    }
}
