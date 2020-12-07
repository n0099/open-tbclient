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
    private boolean gJU;
    private ImageView lsV;
    private String mLiveId;
    private String mRoomId;
    private ViewGroup mRootView;
    private TextView mTvTitle;
    private h ojW;
    private TextView olK;
    private ViewGroup omA;
    private TextView omB;
    private TbImageView omC;
    private CheckBox omD;
    private RelativeLayout omE;
    private RedPacketView omF;
    private String omG;
    private String omH;
    private String omI;
    private String omJ;
    private String omK;
    private String omL;
    private boolean omM;
    private b omN;
    private Handler omO;

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
        this.omB = (TextView) findViewById(a.f.tv_time);
        this.omA = (ViewGroup) findViewById(a.f.background_view);
        this.lsV = (ImageView) findViewById(a.f.iv_close);
        this.olK = (TextView) findViewById(a.f.tv_confirm);
        this.omC = (TbImageView) findViewById(a.f.tiv_result);
        this.mTvTitle = (TextView) findViewById(a.f.tv_title);
        this.acm = (TextView) findViewById(a.f.tv_tip);
        this.omD = (CheckBox) findViewById(a.f.cb_collect);
        this.omE = (RelativeLayout) findViewById(a.f.rl_redpacket_lootgift_root);
        this.omF = (RedPacketView) findViewById(a.f.red_packets_view1);
        Ki();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edw() {
        if (this.omD.isChecked()) {
            this.ojW.w(this.mRoomId, this.mLiveId, 1);
            this.omD.setVisibility(8);
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
        this.omG = str;
        this.omH = str2;
        this.mRoomId = str3;
        this.mLiveId = str4;
        this.omK = str5;
        this.omI = str6;
        this.omJ = str7;
        this.omL = str8;
        this.omM = z;
        this.gJU = z2;
        this.omN = new b();
        this.ojW = new h(this.context);
        this.ojW.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, d.this.mLiveId)));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void onFail(int i2, String str9) {
            }
        });
        this.omO = new Handler();
        this.omA.removeAllViews();
        if (!isShowing()) {
            show();
            if (z) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().a(this.omA, this.omG, this.omH);
            } else {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efA().b(this.omA, this.omG, this.omH);
            }
            if (this.gJU) {
                this.omD.setVisibility(8);
            } else {
                this.omD.setVisibility(0);
            }
            this.omO.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.edx();
                }
            }, (((int) (this.fkc - (System.currentTimeMillis() / 1000))) - 15) * 1000);
            this.lsV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.isShowing()) {
                        d.this.ID();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.omK);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("room_id", d.this.mRoomId);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_esc").setContentExt(jSONObject));
                }
            });
            this.olK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.omE.setVisibility(8);
                }
            });
            this.omE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.omE.setVisibility(8);
                }
            });
        }
    }

    public void ID() {
        dismiss();
        this.omA.removeAllViews();
        edy();
        this.omO.removeCallbacksAndMessages(null);
        this.omE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void edx() {
        cXw();
        this.omF.edA();
        this.omF.setOnRedPacketClickListener(new RedPacketView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.6
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.a
            public void a(c cVar) {
                d.this.edw();
                d.this.omN.i(d.this.mLiveId, d.this.mRoomId, d.this.omK, d.this.omI, d.this.omJ, d.this.omL);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.omK);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("room_id", d.this.mRoomId);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_clk").setContentExt(jSONObject));
            }
        });
        this.omN.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.7
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.a
            public void a(LootGiftHttpResponseMessage lootGiftHttpResponseMessage) {
                if (!TextUtils.isEmpty(lootGiftHttpResponseMessage.image)) {
                    d.this.omE.setVisibility(0);
                    d.this.omC.startLoad(lootGiftHttpResponseMessage.image, 10, false);
                    d.this.mTvTitle.setText(lootGiftHttpResponseMessage.text);
                    d.this.acm.setText(lootGiftHttpResponseMessage.tip);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.omK);
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.omK);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("room_id", this.mRoomId);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftrain_shw").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXw() {
        this.omO.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.8
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (d.this.fkc - (System.currentTimeMillis() / 1000));
                if (currentTimeMillis <= 0) {
                    if (d.this.isShowing()) {
                        d.this.ID();
                    }
                    d.this.omB.setVisibility(8);
                } else if (currentTimeMillis > 15) {
                    d.this.omB.setVisibility(8);
                } else {
                    d.this.omB.setVisibility(0);
                    d.this.omB.setText(currentTimeMillis + " S");
                }
                d.this.cXw();
            }
        }, 1000L);
    }

    private void edy() {
        this.omF.edz();
    }
}
