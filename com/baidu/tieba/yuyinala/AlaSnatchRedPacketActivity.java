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
import com.baidu.live.data.ah;
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
    private HeadImageView bgT;
    private FrameLayout cuo;
    private TextView euO;
    private View fXB;
    private ImageView fZA;
    private String fZC;
    private ValueAnimator fZD;
    private ValueAnimator fZE;
    private FrameLayout.LayoutParams fZF;
    private boolean fZJ;
    private long fZK;
    private int fZM;
    private View fZq;
    private View fZr;
    private FrameLayout fZs;
    private FrameLayout fZt;
    private FrameLayout fZu;
    private TextView fZw;
    private TextView fZx;
    private ImageView fZy;
    private FrameLayout fZz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private String mRoomId;
    private RoundProgressBar nSS;
    private c nST;
    private String nSU;
    private e nSV;
    private a nSW;
    private f nSX;
    private int nSY;
    private int fZL = 2;
    private CustomMessageListener ayx = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fZN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fZC)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fZs.setVisibility(8);
                            return;
                        }
                        AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_unfollow_success_toast));
                        return;
                    }
                    AlaSnatchRedPacketActivity.this.showToast(a.h.follow_failed_tip);
                }
            }
        }
    };
    private c.a nSZ = new c.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.10
        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(com.baidu.tieba.yuyinala.data.a aVar) {
            AlaSnatchRedPacketActivity.this.a(aVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aO(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(f fVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fZQ);
            AlaSnatchRedPacketActivity.this.fZA.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(fVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aP(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fZQ);
            AlaSnatchRedPacketActivity.this.fZA.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fZP = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fZK = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eu(AlaSnatchRedPacketActivity.this.fZK);
                if (AlaSnatchRedPacketActivity.this.fZK < 1) {
                    AlaSnatchRedPacketActivity.this.bLD();
                }
            }
        }
    };
    private Runnable fZQ = new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.fZA != null) {
                AlaSnatchRedPacketActivity.this.fZA.setEnabled(true);
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_snatch_red_packet_view);
            initView();
            this.nST = new c(getPageContext(), this.nSZ);
            this.nST.au(this.mRedPacketId, this.mLiveId, this.nSU);
            MessageManager.getInstance().registerListener(this.ayx);
            MessageManager.getInstance().registerListener(this.fZN);
            MessageManager.getInstance().registerListener(this.fZP);
            this.fZF = new FrameLayout.LayoutParams(-1, -1);
            lq(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.nSU = getIntent().getStringExtra("anchor_uk");
        this.mRoomId = getIntent().getStringExtra("room_id");
    }

    private void initView() {
        this.fXB = findViewById(a.f.rp_root_bg);
        this.fXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cuo = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bgT = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.bgT.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bgT.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bgT.setIsRound(true);
        this.bgT.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bgT.setAutoChangeStyle(true);
        this.bgT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.euO = (TextView) findViewById(a.f.rp_user_name);
        this.fZs = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.fZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bLF();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.f.rp_close_btn);
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
        this.fZr = findViewById(a.f.rp_normal_bg);
        this.fZq = findViewById(a.f.rp_condition_guide_bg);
        this.fZt = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.nSX = fVar;
        if (fVar.bRb()) {
            this.fZM = 101;
        } else {
            this.fZM = 100;
        }
        bLB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.data.a aVar) {
        if (aVar.nUR != null) {
            this.mContentView.setVisibility(0);
            this.nSW = aVar;
            this.fZC = this.nSW.nUS.gzy;
            if (!StringUtils.isNullObject(aVar.nUR.portrait)) {
                l.a(this.bgT, aVar.nUR.portrait, true, false);
            }
            this.euO.setText(aVar.nUR.userName);
            boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fZC) : true;
            if (this.nSW.nUS.gzz || equals) {
                this.fZs.setVisibility(8);
            } else {
                this.fZs.setVisibility(0);
            }
            if (this.nSW.bRb()) {
                this.fZL = 3;
            } else if (this.nSW.isValid()) {
                if (aVar.bRd()) {
                    this.fZL = 1;
                    this.fZs.setVisibility(8);
                } else {
                    this.fZL = 2;
                }
            } else if (this.nSW.bQY()) {
                this.fZL = 5;
            } else if (this.nSW.bQZ()) {
                this.fZL = 4;
            }
            bLA();
        }
    }

    private void bLA() {
        switch (this.fZL) {
            case 1:
                bLE();
                return;
            case 2:
                bLC();
                return;
            case 3:
                this.fZM = 102;
                bLB();
                return;
            case 4:
                this.fZM = 103;
                bLB();
                return;
            case 5:
                this.fZM = 104;
                bLB();
                return;
            default:
                return;
        }
    }

    private void bLB() {
        String str;
        this.fZr.setVisibility(8);
        this.fZq.setVisibility(0);
        this.fZs.setVisibility(8);
        this.fZt.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.fZt.addView(inflate, this.fZF);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ag(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.nSU)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bLy();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fZM) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fZM == 103) {
                    String string = getResources().getString(a.h.snatch_red_packet_failed_4);
                    textView.setVisibility(8);
                    str = string;
                } else {
                    String string2 = getResources().getString(a.h.snatch_red_packet_failed_2);
                    textView.setVisibility(0);
                    str = string2;
                }
                textView3.setText(str);
                return;
            case 101:
                textView2.setVisibility(0);
                ((LinearLayout) inflate.findViewById(a.f.rp_snatch_succ_layout)).setVisibility(0);
                TextView textView4 = (TextView) inflate.findViewById(a.f.rp_snatch_amount);
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.nSX.bRc())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.nSW.bRc())));
                return;
            default:
                return;
        }
    }

    private void bLC() {
        this.fZr.setVisibility(0);
        this.fZq.setVisibility(8);
        this.fZt.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_red_packet_snatch, (ViewGroup) null);
        this.fZt.addView(inflate, this.fZF);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.nSW.nUR.gzV)));
        this.fZz = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZz.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.fZz.setLayoutParams(layoutParams);
        }
        this.fZA = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.fZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fZA.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.fZQ, 1000L);
                AlaSnatchRedPacketActivity.this.nST.av(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.nSU);
            }
        });
        this.fZu = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.nSS = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.fZw = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.fZy = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.fZy.setVisibility(8);
        this.fZx = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.nSW.bRa()) {
            this.fZA.setVisibility(0);
            this.fZu.setVisibility(8);
            dXi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLD() {
        bLG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(long j) {
        if (this.nSW != null) {
            String[] eB = this.nSW.eB(j);
            if (j <= 60) {
                if (!this.fZJ) {
                    this.fZJ = true;
                    if (this.fZy != null) {
                        this.fZy.setVisibility(8);
                    }
                    if (this.fZx != null) {
                        this.fZx.setVisibility(8);
                    }
                    if (this.fZw != null) {
                        this.fZw.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.fZw != null && !TextUtils.equals(eB[1], "00")) {
                    this.fZw.setText(eB[1]);
                }
            } else {
                if (this.fZy != null && this.fZy.getVisibility() != 0) {
                    this.fZy.setVisibility(0);
                }
                if (this.fZw != null) {
                    this.fZw.setText(eB[0]);
                }
                if (this.fZx != null) {
                    this.fZx.setText(eB[1]);
                }
            }
            if (this.nSS != null) {
                this.nSS.setProgress(this.nSW.eA(j));
            }
        }
    }

    private void bLE() {
        this.fZr.setVisibility(8);
        this.fZq.setVisibility(0);
        this.fZt.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.fZt.addView(inflate, this.fZF);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.nSW.bRf()) {
            this.nSY = 1;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.nSW.bRg()) {
            this.nSY = 2;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        } else if (this.nSW.dXo()) {
            this.nSY = 3;
            textView.setText(a.h.snatch_red_packet_cond_collect_desc);
            textView2.setText(a.h.snatch_red_packet_collect_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (AlaSnatchRedPacketActivity.this.nSY) {
                    case 1:
                        AlaSnatchRedPacketActivity.this.bLy();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 2:
                        AlaSnatchRedPacketActivity.this.bqq();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 3:
                        AlaSnatchRedPacketActivity.this.dXh();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLF() {
        String str = this.nSW.nUS.gzy;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.nSW.nUR.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.VO().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXh() {
        this.nSV = new e(getApplicationContext());
        this.nSV.a(new e.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.5
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
        this.nSV.w(this.mRoomId, this.mLiveId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        ah ahVar = new ah();
        ahVar.aIH = -1;
        ahVar.aII = -1;
        ahVar.aIK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXi() {
        this.fZE = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fZE.setDuration(250L);
        this.fZE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fZA.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fZA.setScaleY(floatValue);
            }
        });
        this.fZE.setRepeatCount(-1);
        this.fZE.setRepeatMode(2);
        this.fZE.start();
    }

    private void bLG() {
        this.fZu.setVisibility(0);
        this.fZA.setVisibility(0);
        this.fZD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fZD.setDuration(500L);
        this.fZD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fZu.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fZA.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fZu.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fZu.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fZA.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fZA.setScaleY((float) (f + 0.5d));
            }
        });
        this.fZD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.dXi();
                AlaSnatchRedPacketActivity.this.fZu.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fZD.start();
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
        lq(configuration.orientation == 2);
    }

    private void lq(boolean z) {
        if (z) {
            i.ae(this.cuo);
            this.cuo.setScaleX(0.7f);
            this.cuo.setScaleY(0.7f);
            if (this.fZz != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZz.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.fZz.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cuo);
        this.cuo.setScaleX(1.0f);
        this.cuo.setScaleY(1.0f);
        if (this.fZz != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fZz.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.fZz.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.nST != null) {
            this.nST.onDestroy();
        }
        if (this.fZE != null) {
            this.fZE.removeAllListeners();
            this.fZE.cancel();
            this.fZE = null;
        }
        if (this.fZD != null) {
            this.fZD.removeAllListeners();
            this.fZD.cancel();
            this.fZD = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fZP);
        MessageManager.getInstance().unRegisterListener(this.fZN);
        MessageManager.getInstance().unRegisterListener(this.ayx);
        super.onDestroy();
    }
}
