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
    private TextView acY;
    private Context context;
    private int ftN;
    private boolean gVJ;
    private ImageView lyf;
    private String mLiveId;
    private String mRoomId;
    private ViewGroup mRootView;
    private TextView mTvTitle;
    private h olM;
    private TextView ooG;
    public CustomMessageListener ooJ;
    private ViewGroup opE;
    private TextView opF;
    private TbImageView opG;
    private CheckBox opH;
    private RelativeLayout opI;
    private RedPacketView opJ;
    private String opK;
    private String opL;
    private String opM;
    private String opN;
    private String opO;
    private String opP;
    private boolean opQ;
    private b opR;
    private Handler opS;

    public d(@NonNull Context context) {
        super(context);
        this.ooJ = new CustomMessageListener(2501014) { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2501014 && (customResponsedMessage.getData() instanceof g) && ((g) customResponsedMessage.getData()).Ex() != 1) {
                    d.this.If();
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
        this.opF = (TextView) findViewById(a.f.tv_time);
        this.opE = (ViewGroup) findViewById(a.f.background_view);
        this.lyf = (ImageView) findViewById(a.f.iv_close);
        this.ooG = (TextView) findViewById(a.f.tv_confirm);
        this.opG = (TbImageView) findViewById(a.f.tiv_result);
        this.mTvTitle = (TextView) findViewById(a.f.tv_title);
        this.acY = (TextView) findViewById(a.f.tv_tip);
        this.opH = (CheckBox) findViewById(a.f.cb_collect);
        this.opI = (RelativeLayout) findViewById(a.f.rl_redpacket_lootgift_root);
        this.opJ = (RedPacketView) findViewById(a.f.red_packets_view1);
        JK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecI() {
        if (this.opH.isChecked()) {
            this.olM.y(this.mRoomId, this.mLiveId, 1);
            this.opH.setVisibility(8);
        }
    }

    private void JK() {
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
        this.ftN = i;
        this.opK = str;
        this.opL = str2;
        this.mRoomId = str3;
        this.mLiveId = str4;
        this.opO = str5;
        this.opM = str6;
        this.opN = str7;
        this.opP = str8;
        this.opQ = z;
        this.gVJ = z2;
        this.opR = new b();
        this.olM = new h(this.context);
        this.olM.a(new h.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.1
            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void a(AlaGetCollectRoomHttpResponseMessage alaGetCollectRoomHttpResponseMessage) {
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, d.this.mLiveId)));
            }

            @Override // com.baidu.tieba.yuyinala.liveroom.roomcard.h.a
            public void onFail(int i2, String str9) {
            }
        });
        this.opS = new Handler();
        this.opE.removeAllViews();
        if (!isShowing()) {
            show();
            if (z) {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().a(this.opE, this.opK, this.opL);
            } else {
                com.baidu.tieba.yuyinala.liveroom.wheat.lottie.a.efJ().b(this.opE, this.opK, this.opL);
            }
            if (this.gVJ) {
                this.opH.setVisibility(8);
            } else {
                this.opH.setVisibility(0);
            }
            this.opS.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ecJ();
                }
            }, (((int) (this.ftN - (System.currentTimeMillis() / 1000))) - 15) * 1000);
            this.lyf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (d.this.isShowing()) {
                        d.this.If();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.opO);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("live_id", d.this.mLiveId);
                        jSONObject.put("room_id", d.this.mRoomId);
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_esc").setContentExt(jSONObject));
                }
            });
            this.ooG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.opI.setVisibility(8);
                }
            });
            this.opI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.opI.setVisibility(8);
                }
            });
        }
    }

    public void If() {
        dismiss();
        this.opE.removeAllViews();
        ecL();
        this.opS.removeCallbacksAndMessages(null);
        this.opI.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecJ() {
        ecK();
        this.opJ.ecN();
        this.opJ.setOnRedPacketClickListener(new RedPacketView.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.6
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.RedPacketView.a
            public void a(c cVar) {
                d.this.ecI();
                d.this.opR.j(d.this.mLiveId, d.this.mRoomId, d.this.opO, d.this.opM, d.this.opN, d.this.opP);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                    jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.opO);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("live_id", d.this.mLiveId);
                    jSONObject.put("room_id", d.this.mRoomId);
                } catch (Exception e) {
                    BdLog.e(e);
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.VOICE_ROOM, "giftrain_clk").setContentExt(jSONObject));
            }
        });
        this.opR.a(new b.a() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.7
            @Override // com.baidu.tieba.yuyinala.liveroom.grabredpacket.b.a
            public void a(LootGiftHttpResponseMessage lootGiftHttpResponseMessage) {
                if (!TextUtils.isEmpty(lootGiftHttpResponseMessage.image)) {
                    d.this.opI.setVisibility(0);
                    d.this.opG.startLoad(lootGiftHttpResponseMessage.image, 10, false);
                    d.this.mTvTitle.setText(lootGiftHttpResponseMessage.text);
                    d.this.acY.setText(lootGiftHttpResponseMessage.tip);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
                        jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, d.this.opO);
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
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.opO);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("live_id", this.mLiveId);
            jSONObject.put("room_id", this.mRoomId);
        } catch (Exception e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.VOICE_ROOM, "giftrain_shw").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecK() {
        this.opS.postDelayed(new Runnable() { // from class: com.baidu.tieba.yuyinala.liveroom.grabredpacket.d.8
            @Override // java.lang.Runnable
            public void run() {
                int currentTimeMillis = (int) (d.this.ftN - (System.currentTimeMillis() / 1000));
                if (currentTimeMillis <= 0) {
                    if (d.this.isShowing()) {
                        d.this.If();
                    }
                    d.this.opF.setVisibility(8);
                } else if (currentTimeMillis > 15) {
                    d.this.opF.setVisibility(8);
                } else {
                    d.this.opF.setVisibility(0);
                    d.this.opF.setText(currentTimeMillis + " S");
                }
                d.this.ecK();
            }
        }, 1000L);
    }

    private void ecL() {
        this.opJ.ecM();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        MessageManager.getInstance().registerListener(this.ooJ);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        MessageManager.getInstance().unRegisterListener(this.ooJ);
    }
}
