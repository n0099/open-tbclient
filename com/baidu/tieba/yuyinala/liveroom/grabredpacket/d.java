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
    private TextView abj;
    private Context context;
    private int fdv;
    private boolean gBq;
    private ImageView lff;
    private String mLiveId;
    private String mRoomId;
    private ViewGroup mRootView;
    private TextView mTvTitle;
    private h nTv;
    private ViewGroup nVY;
    private TextView nVZ;
    private TextView nVj;
    private TbImageView nWa;
    private CheckBox nWb;
    private RelativeLayout nWc;
    private RedPacketView nWd;
    private String nWe;
    private String nWf;
    private String nWg;
    private String nWh;
    private String nWi;
    private String nWj;
    private boolean nWk;
    private b nWl;
    private Handler nWm;

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
        this.nVZ = (TextView) findViewById(a.f.tv_time);
        this.nVY = (ViewGroup) findViewById(a.f.background_view);
        this.lff = (ImageView) findViewById(a.f.iv_close);
        this.nVj = (TextView) findViewById(a.f.tv_confirm);
        this.nWa = (TbImageView) findViewById(a.f.tiv_result);
        this.mTvTitle = (TextView) findViewById(a.f.tv_title);
        this.abj = (TextView) findViewById(a.f.tv_tip);
        this.nWb = (CheckBox) findViewById(a.f.cb_collect);
        this.nWc = (RelativeLayout) findViewById(a.f.rl_redpacket_lootgift_root);
        this.nWd = (RedPacketView) findViewById(a.f.red_packets_view1);
        Pe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXT() {
        if (this.nWb.isChecked()) {
            this.nTv.w(this.mRoomId, this.mLiveId, 1);
            this.nWb.setVisibility(8);
        }
    }

    private void Pe() {
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
        this.fdv = i;
        this.nWe = str;
        this.nWf = str2;
        this.mRoomId = str3;
        this.mLiveId = str4;
        this.nWi = str5;
        this.nWg = str6;
        this.nWh = str7;
        this.nWj = str8;
        this.nWk = z;
        this.gBq = z2;
        this.nWl = new b();
        this.nTv = new h(this.context);
        this.nTv.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, d.this.mLiveId)));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void onFail(int i2, String str9) {
            }
        });
        this.nWm = new Handler();
        this.nVY.removeAllViews();
        if (!isShowing()) {
            show();
            if (z) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().a(this.nVY, this.nWe, this.nWf);
            } else {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.dZW().b(this.nVY, this.nWe, this.nWf);
            }
            if (this.gBq) {
                this.nWb.setVisibility(8);
            } else {
                this.nWb.setVisibility(0);
            }
            this.nWm.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.dXU();
                }
            }, (((int) (this.fdv - (System.currentTimeMillis() / 1000))) - 15) * 1000);
            this.lff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.Hv();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.nWi);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("room_id", d.this.mRoomId);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_esc").setContentExt(jSONObject));
                }
            });
            this.nVj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.nWc.setVisibility(8);
                }
            });
            this.nWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.nWc.setVisibility(8);
                }
            });
        }
    }

    public void Hv() {
        dismiss();
        this.nVY.removeAllViews();
        dXV();
        this.nWm.removeCallbacksAndMessages(null);
        this.nWc.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXU() {
        cSE();
        this.nWd.dXX();
        this.nWd.setOnRedPacketClickListener(new RedPacketView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.6
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.a
            public void a(c cVar) {
                d.this.dXT();
                d.this.nWl.i(d.this.mLiveId, d.this.mRoomId, d.this.nWi, d.this.nWg, d.this.nWh, d.this.nWj);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.nWi);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("room_id", d.this.mRoomId);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_clk").setContentExt(jSONObject));
            }
        });
        this.nWl.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.7
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.a
            public void a(LootGiftHttpResponseMessage lootGiftHttpResponseMessage) {
                if (!TextUtils.isEmpty(lootGiftHttpResponseMessage.image)) {
                    d.this.nWc.setVisibility(0);
                    d.this.nWa.startLoad(lootGiftHttpResponseMessage.image, 10, false);
                    d.this.mTvTitle.setText(lootGiftHttpResponseMessage.text);
                    d.this.abj.setText(lootGiftHttpResponseMessage.tip);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.nWi);
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.nWi);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("room_id", this.mRoomId);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftrain_shw").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSE() {
        this.nWm.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.8
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (d.this.fdv - (System.currentTimeMillis() / 1000));
                if (currentTimeMillis <= 0) {
                    d.this.Hv();
                    d.this.nVZ.setVisibility(8);
                } else if (currentTimeMillis > 15) {
                    d.this.nVZ.setVisibility(8);
                } else {
                    d.this.nVZ.setVisibility(0);
                    d.this.nVZ.setText(currentTimeMillis + " S");
                }
                d.this.cSE();
            }
        }, 1000L);
    }

    private void dXV() {
        this.nWd.dXW();
    }
}
