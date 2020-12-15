package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.message.FollowRoom;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView;
import com.baidu.tieba.yuyinala.liveroom.grabredpacket.b;
import com.baidu.tieba.yuyinala.liveroom.roomcard.AlaGetCollectRoomHttpResponseMessage;
import com.baidu.tieba.yuyinala.liveroom.roomcard.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends Dialog {
    private TextView acm;
    private Context context;
    private int fkc;
    private boolean gJW;
    private ImageView lsX;
    private String mLiveId;
    private String mRoomId;
    private ViewGroup mRootView;
    private TextView mTvTitle;
    private h ojY;
    private TextView olM;
    private ViewGroup omC;
    private TextView omD;
    private TbImageView omE;
    private CheckBox omF;
    private RelativeLayout omG;
    private RedPacketView omH;
    private String omI;
    private String omJ;
    private String omK;
    private String omL;
    private String omM;
    private String omN;
    private boolean omO;
    private b omP;
    private Handler omQ;

    public d(@NonNull Context context) {
        super(context);
        this.context = context;
        init();
    }

    protected void init() {
        getWindow().requestFeature(1);
        setContentView(a.g.dialog_redpacket_yuyin);
        setCanceledOnTouchOutside(false);
        this.mRootView = (ViewGroup) findViewById(a.f.red_packget_root);
        this.omD = (TextView) findViewById(a.f.tv_time);
        this.omC = (ViewGroup) findViewById(a.f.background_view);
        this.lsX = (ImageView) findViewById(a.f.iv_close);
        this.olM = (TextView) findViewById(a.f.tv_confirm);
        this.omE = (TbImageView) findViewById(a.f.tiv_result);
        this.mTvTitle = (TextView) findViewById(a.f.tv_title);
        this.acm = (TextView) findViewById(a.f.tv_tip);
        this.omF = (CheckBox) findViewById(a.f.cb_collect);
        this.omG = (RelativeLayout) findViewById(a.f.rl_redpacket_lootgift_root);
        this.omH = (RedPacketView) findViewById(a.f.red_packets_view1);
        Ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edx() {
        if (this.omF.isChecked()) {
            this.ojY.w(this.mRoomId, this.mLiveId, 1);
            this.omF.setVisibility(8);
        }
    }

    private void Ki() {
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.getDecorView().setPadding(0, 0, 0, 0);
            if (((WindowManager) getContext().getSystemService("window")) != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (UtilHelper.getRealScreenOrientation(this.context) == 2) {
                    attributes.width = ScreenHelper.getRealScreenHeight(this.context);
                    attributes.height = -1;
                } else {
                    attributes.width = -1;
                    attributes.height = ScreenHelper.getRealScreenHeight(this.context) - UtilHelper.getStatusBarHeight();
                }
                window.setAttributes(attributes);
            }
        }
    }

    public void a(boolean z, int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z2) {
        this.fkc = i;
        this.omI = str;
        this.omJ = str2;
        this.mRoomId = str3;
        this.mLiveId = str4;
        this.omM = str5;
        this.omK = str6;
        this.omL = str7;
        this.omN = str8;
        this.omO = z;
        this.gJW = z2;
        this.omP = new b();
        this.ojY = new h(this.context);
        this.ojY.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, d.this.mLiveId)));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void onFail(int i2, String str9) {
            }
        });
        this.omQ = new Handler();
        this.omC.removeAllViews();
        if (!isShowing()) {
            show();
            if (z) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efB().a(this.omC, this.omI, this.omJ);
            } else {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efB().b(this.omC, this.omI, this.omJ);
            }
            if (this.gJW) {
                this.omF.setVisibility(8);
            } else {
                this.omF.setVisibility(0);
            }
            this.omQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.edy();
                }
            }, (((int) (this.fkc - (System.currentTimeMillis() / 1000))) - 15) * 1000);
            this.lsX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.isShowing()) {
                        d.this.ID();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.omM);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("room_id", d.this.mRoomId);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_esc").setContentExt(jSONObject));
                }
            });
            this.olM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.omG.setVisibility(8);
                }
            });
            this.omG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.omG.setVisibility(8);
                }
            });
        }
    }

    public void ID() {
        dismiss();
        this.omC.removeAllViews();
        edz();
        this.omQ.removeCallbacksAndMessages(null);
        this.omG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edy() {
        cXx();
        this.omH.edB();
        this.omH.setOnRedPacketClickListener(new RedPacketView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.6
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.a
            public void a(c cVar) {
                d.this.edx();
                d.this.omP.i(d.this.mLiveId, d.this.mRoomId, d.this.omM, d.this.omK, d.this.omL, d.this.omN);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.omM);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("room_id", d.this.mRoomId);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_clk").setContentExt(jSONObject));
            }
        });
        this.omP.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.7
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.a
            public void a(LootGiftHttpResponseMessage lootGiftHttpResponseMessage) {
                if (!TextUtils.isEmpty(lootGiftHttpResponseMessage.image)) {
                    d.this.omG.setVisibility(0);
                    d.this.omE.startLoad(lootGiftHttpResponseMessage.image, 10, false);
                    d.this.mTvTitle.setText(lootGiftHttpResponseMessage.text);
                    d.this.acm.setText(lootGiftHttpResponseMessage.tip);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.omM);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("room_id", d.this.mRoomId);
                        jSONObject.put("present_id", lootGiftHttpResponseMessage.id);
                        jSONObject.put("present_name", lootGiftHttpResponseMessage.name);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_suc").setContentExt(jSONObject));
                }
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.a
            public void onFail(int i, String str) {
            }
        });
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.omM);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("room_id", this.mRoomId);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftrain_shw").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXx() {
        this.omQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.8
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (d.this.fkc - (System.currentTimeMillis() / 1000));
                if (currentTimeMillis <= 0) {
                    if (d.this.isShowing()) {
                        d.this.ID();
                    }
                    d.this.omD.setVisibility(8);
                } else if (currentTimeMillis > 15) {
                    d.this.omD.setVisibility(8);
                } else {
                    d.this.omD.setVisibility(0);
                    d.this.omD.setText(currentTimeMillis + " S");
                }
                d.this.cXx();
            }
        }, 1000L);
    }

    private void edz() {
        this.omH.edA();
    }
}
