package com.baidu.tieba.yuyinala.liveroom.grabredpacket;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.data.g;
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
/* loaded from: classes11.dex */
public class d extends Dialog {
    private TextView acQ;
    private Context context;
    private int frv;
    private boolean gUb;
    private ImageView lBS;
    private String mLiveId;
    private String mRoomId;
    private ViewGroup mRootView;
    private TextView mTvTitle;
    private h orB;
    private TextView ouu;
    public CustomMessageListener oux;
    private String ovA;
    private boolean ovB;
    private b ovC;
    private Handler ovD;
    private ViewGroup ovp;
    private TextView ovq;
    private TbImageView ovr;
    private CheckBox ovs;
    private RelativeLayout ovt;
    private RedPacketView ovu;
    private String ovv;
    private String ovw;
    private String ovx;
    private String ovy;
    private String ovz;

    public d(@NonNull Context context) {
        super(context);
        this.oux = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).Bm() != 1) {
                    d.this.FA();
                }
            }
        };
        this.context = context;
        init();
    }

    protected void init() {
        getWindow().requestFeature(1);
        setContentView(a.g.dialog_redpacket_yuyin);
        setCanceledOnTouchOutside(false);
        this.mRootView = (ViewGroup) findViewById(a.f.red_packget_root);
        this.ovq = (TextView) findViewById(a.f.tv_time);
        this.ovp = (ViewGroup) findViewById(a.f.background_view);
        this.lBS = (ImageView) findViewById(a.f.iv_close);
        this.ouu = (TextView) findViewById(a.f.tv_confirm);
        this.ovr = (TbImageView) findViewById(a.f.tiv_result);
        this.mTvTitle = (TextView) findViewById(a.f.tv_title);
        this.acQ = (TextView) findViewById(a.f.tv_tip);
        this.ovs = (CheckBox) findViewById(a.f.cb_collect);
        this.ovt = (RelativeLayout) findViewById(a.f.rl_redpacket_lootgift_root);
        this.ovu = (RedPacketView) findViewById(a.f.red_packets_view1);
        Hf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebl() {
        if (this.ovs.isChecked()) {
            this.orB.y(this.mRoomId, this.mLiveId, 1);
            this.ovs.setVisibility(8);
        }
    }

    private void Hf() {
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
        this.frv = i;
        this.ovv = str;
        this.ovw = str2;
        this.mRoomId = str3;
        this.mLiveId = str4;
        this.ovz = str5;
        this.ovx = str6;
        this.ovy = str7;
        this.ovA = str8;
        this.ovB = z;
        this.gUb = z2;
        this.ovC = new b();
        this.orB = new h(this.context);
        this.orB.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, d.this.mLiveId)));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void onFail(int i2, String str9) {
            }
        });
        this.ovD = new Handler();
        this.ovp.removeAllViews();
        if (!isShowing()) {
            show();
            if (z) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().a(this.ovp, this.ovv, this.ovw);
            } else {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.eeo().b(this.ovp, this.ovv, this.ovw);
            }
            if (this.gUb) {
                this.ovs.setVisibility(8);
            } else {
                this.ovs.setVisibility(0);
            }
            this.ovD.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ebm();
                }
            }, (((int) (this.frv - (System.currentTimeMillis() / 1000))) - 15) * 1000);
            this.lBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.isShowing()) {
                        d.this.FA();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.ovz);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("room_id", d.this.mRoomId);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_esc").setContentExt(jSONObject));
                }
            });
            this.ouu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ovt.setVisibility(8);
                }
            });
            this.ovt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.ovt.setVisibility(8);
                }
            });
        }
    }

    public void FA() {
        dismiss();
        this.ovp.removeAllViews();
        ebo();
        this.ovD.removeCallbacksAndMessages(null);
        this.ovt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebm() {
        ebn();
        this.ovu.ebq();
        this.ovu.setOnRedPacketClickListener(new RedPacketView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.6
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.a
            public void a(c cVar) {
                d.this.ebl();
                d.this.ovC.j(d.this.mLiveId, d.this.mRoomId, d.this.ovz, d.this.ovx, d.this.ovy, d.this.ovA);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.ovz);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("room_id", d.this.mRoomId);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_clk").setContentExt(jSONObject));
            }
        });
        this.ovC.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.7
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.a
            public void a(LootGiftHttpResponseMessage lootGiftHttpResponseMessage) {
                if (!TextUtils.isEmpty(lootGiftHttpResponseMessage.image)) {
                    d.this.ovt.setVisibility(0);
                    d.this.ovr.startLoad(lootGiftHttpResponseMessage.image, 10, false);
                    d.this.mTvTitle.setText(lootGiftHttpResponseMessage.text);
                    d.this.acQ.setText(lootGiftHttpResponseMessage.tip);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.ovz);
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ovz);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("room_id", this.mRoomId);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftrain_shw").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ebn() {
        this.ovD.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.8
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (d.this.frv - (System.currentTimeMillis() / 1000));
                if (currentTimeMillis <= 0) {
                    if (d.this.isShowing()) {
                        d.this.FA();
                    }
                    d.this.ovq.setVisibility(8);
                } else if (currentTimeMillis > 15) {
                    d.this.ovq.setVisibility(8);
                } else {
                    d.this.ovq.setVisibility(0);
                    d.this.ovq.setText(currentTimeMillis + " S");
                }
                d.this.ebn();
            }
        }, 1000L);
    }

    private void ebo() {
        this.ovu.ebp();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        MessageManager.getInstance().registerListener(this.oux);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        MessageManager.getInstance().unRegisterListener(this.oux);
    }
}
