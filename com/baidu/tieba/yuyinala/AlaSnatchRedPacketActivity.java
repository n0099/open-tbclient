package com.baidu.tieba.yuyinala;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.ag;
import com.baidu.live.message.FollowRoom;
import com.baidu.live.message.YuyinFollowRoomMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.utils.i;
import com.baidu.live.utils.l;
import com.baidu.tieba.yuyinala.c.c;
import com.baidu.tieba.yuyinala.c.e;
import com.baidu.tieba.yuyinala.data.a;
import com.baidu.tieba.yuyinala.data.f;
import com.baidu.tieba.yuyinala.view.RoundProgressBar;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView bhl;
    private FrameLayout cqc;
    private TextView eqE;
    private View fSe;
    private View fTT;
    private View fTU;
    private FrameLayout fTV;
    private FrameLayout fTW;
    private FrameLayout fTX;
    private TextView fTZ;
    private TextView fUa;
    private ImageView fUb;
    private FrameLayout fUc;
    private ImageView fUd;
    private String fUf;
    private ValueAnimator fUg;
    private ValueAnimator fUh;
    private FrameLayout.LayoutParams fUi;
    private boolean fUm;
    private long fUn;
    private int fUp;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private String mRoomId;
    private f nLA;
    private int nLB;
    private RoundProgressBar nLv;
    private c nLw;
    private String nLx;
    private e nLy;
    private a nLz;
    private int fUo = 2;
    private CustomMessageListener aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fUq = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fUf)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fTV.setVisibility(8);
                            return;
                        }
                        AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_unfollow_success_toast));
                        return;
                    }
                    AlaSnatchRedPacketActivity.this.showToast(a.i.follow_failed_tip);
                }
            }
        }
    };
    private c.a nLC = new c.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.10
        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(com.baidu.tieba.yuyinala.data.a aVar) {
            AlaSnatchRedPacketActivity.this.a(aVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aM(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(f fVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fUt);
            AlaSnatchRedPacketActivity.this.fUd.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(fVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aN(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fUt);
            AlaSnatchRedPacketActivity.this.fUd.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fUs = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fUn = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dY(AlaSnatchRedPacketActivity.this.fUn);
                if (AlaSnatchRedPacketActivity.this.fUn < 1) {
                    AlaSnatchRedPacketActivity.this.bJL();
                }
            }
        }
    };
    private Runnable fUt = new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.fUd != null) {
                AlaSnatchRedPacketActivity.this.fUd.setEnabled(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            setContentView(a.h.ala_snatch_red_packet_view);
            initView();
            this.nLw = new c(getPageContext(), this.nLC);
            this.nLw.at(this.mRedPacketId, this.mLiveId, this.nLx);
            MessageManager.getInstance().registerListener(this.aAi);
            MessageManager.getInstance().registerListener(this.fUq);
            MessageManager.getInstance().registerListener(this.fUs);
            this.fUi = new FrameLayout.LayoutParams(-1, -1);
            lg(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.nLx = getIntent().getStringExtra("anchor_uk");
        this.mRoomId = getIntent().getStringExtra("room_id");
    }

    private void initView() {
        this.fSe = findViewById(a.g.rp_root_bg);
        this.fSe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cqc = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bhl = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.bhl.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.bhl.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.bhl.setIsRound(true);
        this.bhl.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bhl.setAutoChangeStyle(true);
        this.bhl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eqE = (TextView) findViewById(a.g.rp_user_name);
        this.fTV = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.fTV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bJN();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.fTU = findViewById(a.g.rp_normal_bg);
        this.fTT = findViewById(a.g.rp_condition_guide_bg);
        this.fTW = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.nLA = fVar;
        if (fVar.bPi()) {
            this.fUp = 101;
        } else {
            this.fUp = 100;
        }
        bJJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.data.a aVar) {
        if (aVar.nNu != null) {
            this.mContentView.setVisibility(0);
            this.nLz = aVar;
            this.fUf = this.nLz.nNv.gud;
            if (!StringUtils.isNullObject(aVar.nNu.portrait)) {
                l.a(this.bhl, aVar.nNu.portrait, true, false);
            }
            this.eqE.setText(aVar.nNu.userName);
            boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fUf) : true;
            if (this.nLz.nNv.gue || equals) {
                this.fTV.setVisibility(8);
            } else {
                this.fTV.setVisibility(0);
            }
            if (this.nLz.bPi()) {
                this.fUo = 3;
            } else if (this.nLz.isValid()) {
                if (aVar.bPk()) {
                    this.fUo = 1;
                    this.fTV.setVisibility(8);
                } else {
                    this.fUo = 2;
                }
            } else if (this.nLz.bPf()) {
                this.fUo = 5;
            } else if (this.nLz.bPg()) {
                this.fUo = 4;
            }
            bJI();
        }
    }

    private void bJI() {
        switch (this.fUo) {
            case 1:
                bJM();
                return;
            case 2:
                bJK();
                return;
            case 3:
                this.fUp = 102;
                bJJ();
                return;
            case 4:
                this.fUp = 103;
                bJJ();
                return;
            case 5:
                this.fUp = 104;
                bJJ();
                return;
            default:
                return;
        }
    }

    private void bJJ() {
        String str;
        this.fTU.setVisibility(8);
        this.fTT.setVisibility(0);
        this.fTV.setVisibility(8);
        this.fTW.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.fTW.addView(inflate, this.fUi);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.nLx)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bJG();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fUp) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fUp == 103) {
                    String string = getResources().getString(a.i.snatch_red_packet_failed_4);
                    textView.setVisibility(8);
                    str = string;
                } else {
                    String string2 = getResources().getString(a.i.snatch_red_packet_failed_2);
                    textView.setVisibility(0);
                    str = string2;
                }
                textView3.setText(str);
                return;
            case 101:
                textView2.setVisibility(0);
                ((LinearLayout) inflate.findViewById(a.g.rp_snatch_succ_layout)).setVisibility(0);
                TextView textView4 = (TextView) inflate.findViewById(a.g.rp_snatch_amount);
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.nLA.bPj())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.nLz.bPj())));
                return;
            default:
                return;
        }
    }

    private void bJK() {
        this.fTU.setVisibility(0);
        this.fTT.setVisibility(8);
        this.fTW.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.yuyin_ala_red_packet_snatch, (ViewGroup) null);
        this.fTW.addView(inflate, this.fUi);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.nLz.nNu.guA)));
        this.fUc = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fUc.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.fUc.setLayoutParams(layoutParams);
        }
        this.fUd = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.fUd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fUd.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.fUt, 1000L);
                AlaSnatchRedPacketActivity.this.nLw.au(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.nLx);
            }
        });
        this.fTX = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.nLv = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.fTZ = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.fUb = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.fUb.setVisibility(8);
        this.fUa = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.nLz.bPh()) {
            this.fUd.setVisibility(0);
            this.fTX.setVisibility(8);
            dUJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        bJO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dY(long j) {
        if (this.nLz != null) {
            String[] ef = this.nLz.ef(j);
            if (j <= 60) {
                if (!this.fUm) {
                    this.fUm = true;
                    if (this.fUb != null) {
                        this.fUb.setVisibility(8);
                    }
                    if (this.fUa != null) {
                        this.fUa.setVisibility(8);
                    }
                    if (this.fTZ != null) {
                        this.fTZ.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.fTZ != null && !TextUtils.equals(ef[1], "00")) {
                    this.fTZ.setText(ef[1]);
                }
            } else {
                if (this.fUb != null && this.fUb.getVisibility() != 0) {
                    this.fUb.setVisibility(0);
                }
                if (this.fTZ != null) {
                    this.fTZ.setText(ef[0]);
                }
                if (this.fUa != null) {
                    this.fUa.setText(ef[1]);
                }
            }
            if (this.nLv != null) {
                this.nLv.setProgress(this.nLz.ee(j));
            }
        }
    }

    private void bJM() {
        this.fTU.setVisibility(8);
        this.fTT.setVisibility(0);
        this.fTW.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.fTW.addView(inflate, this.fUi);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.nLz.bPm()) {
            this.nLB = 1;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.nLz.bPn()) {
            this.nLB = 2;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        } else if (this.nLz.dUP()) {
            this.nLB = 3;
            textView.setText(a.i.snatch_red_packet_cond_collect_desc);
            textView2.setText(a.i.snatch_red_packet_collect_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (AlaSnatchRedPacketActivity.this.nLB) {
                    case 1:
                        AlaSnatchRedPacketActivity.this.bJG();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 2:
                        AlaSnatchRedPacketActivity.this.boD();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 3:
                        AlaSnatchRedPacketActivity.this.dUI();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boD() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJN() {
        String str = this.nLz.nNv.gud;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.nLz.nNu.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.TX().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUI() {
        this.nLy = new e(getApplicationContext());
        this.nLy.a(new e.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.5
            @Override // com.baidu.tieba.yuyinala.c.e.a
            public void a(JsonHttpResponsedMessage jsonHttpResponsedMessage) {
                AlaSnatchRedPacketActivity.this.showToast("收藏成功");
                MessageManager.getInstance().dispatchResponsedMessage(new YuyinFollowRoomMessage(new FollowRoom(true, AlaSnatchRedPacketActivity.this.mLiveId)));
                AlaSnatchRedPacketActivity.this.finish();
            }

            @Override // com.baidu.tieba.yuyinala.c.e.a
            public void onFail(int i, String str) {
                AlaSnatchRedPacketActivity.this.showToast("收藏失败");
            }
        });
        this.nLy.v(this.mRoomId, this.mLiveId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        com.baidu.live.data.ag agVar = new com.baidu.live.data.ag();
        agVar.aJs = -1;
        agVar.aJt = -1;
        agVar.aJv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dUJ() {
        this.fUh = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fUh.setDuration(250L);
        this.fUh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fUd.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fUd.setScaleY(floatValue);
            }
        });
        this.fUh.setRepeatCount(-1);
        this.fUh.setRepeatMode(2);
        this.fUh.start();
    }

    private void bJO() {
        this.fTX.setVisibility(0);
        this.fUd.setVisibility(0);
        this.fUg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fUg.setDuration(500L);
        this.fUg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fTX.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fUd.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fTX.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fTX.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fUd.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fUd.setScaleY((float) (f + 0.5d));
            }
        });
        this.fUg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.dUJ();
                AlaSnatchRedPacketActivity.this.fTX.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUg.start();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        lg(configuration.orientation == 2);
    }

    private void lg(boolean z) {
        if (z) {
            i.aa(this.cqc);
            this.cqc.setScaleX(0.7f);
            this.cqc.setScaleY(0.7f);
            if (this.fUc != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fUc.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.fUc.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.ab(this.cqc);
        this.cqc.setScaleX(1.0f);
        this.cqc.setScaleY(1.0f);
        if (this.fUc != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fUc.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.fUc.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nLw != null) {
            this.nLw.onDestroy();
        }
        if (this.fUh != null) {
            this.fUh.removeAllListeners();
            this.fUh.cancel();
            this.fUh = null;
        }
        if (this.fUg != null) {
            this.fUg.removeAllListeners();
            this.fUg.cancel();
            this.fUg = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fUs);
        MessageManager.getInstance().unRegisterListener(this.fUq);
        MessageManager.getInstance().unRegisterListener(this.aAi);
        super.onDestroy();
    }
}
