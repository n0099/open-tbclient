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
import com.baidu.live.d.ah;
import com.baidu.live.data.ai;
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
    private HeadImageView bli;
    private FrameLayout cBi;
    private TextView eBQ;
    private View gfM;
    private View ghB;
    private View ghC;
    private FrameLayout ghD;
    private FrameLayout ghE;
    private FrameLayout ghF;
    private TextView ghH;
    private TextView ghI;
    private ImageView ghJ;
    private FrameLayout ghK;
    private ImageView ghL;
    private String ghN;
    private ValueAnimator ghO;
    private ValueAnimator ghP;
    private FrameLayout.LayoutParams ghQ;
    private boolean ghU;
    private long ghV;
    private int ghX;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private String mRoomId;
    private RoundProgressBar ohQ;
    private c ohR;
    private String ohS;
    private e ohT;
    private a ohU;
    private f ohV;
    private int ohW;
    private int ghW = 2;
    private CustomMessageListener aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener ghY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.ghN)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.ghD.setVisibility(8);
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
    private c.a ohX = new c.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.10
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
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gib);
            AlaSnatchRedPacketActivity.this.ghL.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(fVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aP(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gib);
            AlaSnatchRedPacketActivity.this.ghL.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gia = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.ghV = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eX(AlaSnatchRedPacketActivity.this.ghV);
                if (AlaSnatchRedPacketActivity.this.ghV < 1) {
                    AlaSnatchRedPacketActivity.this.bPm();
                }
            }
        }
    };
    private Runnable gib = new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.ghL != null) {
                AlaSnatchRedPacketActivity.this.ghL.setEnabled(true);
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
            this.ohR = new c(getPageContext(), this.ohX);
            this.ohR.aw(this.mRedPacketId, this.mLiveId, this.ohS);
            MessageManager.getInstance().registerListener(this.aAS);
            MessageManager.getInstance().registerListener(this.ghY);
            MessageManager.getInstance().registerListener(this.gia);
            this.ghQ = new FrameLayout.LayoutParams(-1, -1);
            lL(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.ohS = getIntent().getStringExtra("anchor_uk");
        this.mRoomId = getIntent().getStringExtra("room_id");
    }

    private void initView() {
        this.gfM = findViewById(a.f.rp_root_bg);
        this.gfM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cBi = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bli = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.bli.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bli.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bli.setIsRound(true);
        this.bli.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bli.setAutoChangeStyle(true);
        this.bli.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eBQ = (TextView) findViewById(a.f.rp_user_name);
        this.ghD = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.ghD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bPo();
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
        this.ghC = findViewById(a.f.rp_normal_bg);
        this.ghB = findViewById(a.f.rp_condition_guide_bg);
        this.ghE = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.ohV = fVar;
        if (fVar.bUL()) {
            this.ghX = 101;
        } else {
            this.ghX = 100;
        }
        bPk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.data.a aVar) {
        if (aVar.ojP != null) {
            this.mContentView.setVisibility(0);
            this.ohU = aVar;
            this.ghN = this.ohU.ojQ.gIu;
            if (!StringUtils.isNullObject(aVar.ojP.portrait)) {
                l.a(this.bli, aVar.ojP.portrait, true, false);
            }
            this.eBQ.setText(aVar.ojP.userName);
            boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.ghN) : true;
            if (this.ohU.ojQ.gIv || equals) {
                this.ghD.setVisibility(8);
            } else {
                this.ghD.setVisibility(0);
            }
            if (this.ohU.bUL()) {
                this.ghW = 3;
            } else if (this.ohU.isValid()) {
                if (aVar.bUN()) {
                    this.ghW = 1;
                    this.ghD.setVisibility(8);
                } else {
                    this.ghW = 2;
                }
            } else if (this.ohU.bUI()) {
                this.ghW = 5;
            } else if (this.ohU.bUJ()) {
                this.ghW = 4;
            }
            bPj();
        }
    }

    private void bPj() {
        switch (this.ghW) {
            case 1:
                bPn();
                return;
            case 2:
                bPl();
                return;
            case 3:
                this.ghX = 102;
                bPk();
                return;
            case 4:
                this.ghX = 103;
                bPk();
                return;
            case 5:
                this.ghX = 104;
                bPk();
                return;
            default:
                return;
        }
    }

    private void bPk() {
        String str;
        this.ghC.setVisibility(8);
        this.ghB.setVisibility(0);
        this.ghD.setVisibility(8);
        this.ghE.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.ghE.addView(inflate, this.ghQ);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ah(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.ohS)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bPh();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.ghX) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.ghX == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ohV.bUM())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ohU.bUM())));
                return;
            default:
                return;
        }
    }

    private void bPl() {
        this.ghC.setVisibility(0);
        this.ghB.setVisibility(8);
        this.ghE.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_red_packet_snatch, (ViewGroup) null);
        this.ghE.addView(inflate, this.ghQ);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.ohU.ojP.gIS)));
        this.ghK = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghK.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.ghK.setLayoutParams(layoutParams);
        }
        this.ghL = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.ghL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.ghL.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gib, 1000L);
                AlaSnatchRedPacketActivity.this.ohR.ax(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.ohS);
            }
        });
        this.ghF = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.ohQ = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.ghH = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.ghJ = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.ghJ.setVisibility(8);
        this.ghI = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.ohU.bUK()) {
            this.ghL.setVisibility(0);
            this.ghF.setVisibility(8);
            ecM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPm() {
        bPp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(long j) {
        if (this.ohU != null) {
            String[] ff = this.ohU.ff(j);
            if (j <= 60) {
                if (!this.ghU) {
                    this.ghU = true;
                    if (this.ghJ != null) {
                        this.ghJ.setVisibility(8);
                    }
                    if (this.ghI != null) {
                        this.ghI.setVisibility(8);
                    }
                    if (this.ghH != null) {
                        this.ghH.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.ghH != null && !TextUtils.equals(ff[1], "00")) {
                    this.ghH.setText(ff[1]);
                }
            } else {
                if (this.ghJ != null && this.ghJ.getVisibility() != 0) {
                    this.ghJ.setVisibility(0);
                }
                if (this.ghH != null) {
                    this.ghH.setText(ff[0]);
                }
                if (this.ghI != null) {
                    this.ghI.setText(ff[1]);
                }
            }
            if (this.ohQ != null) {
                this.ohQ.setProgress(this.ohU.fe(j));
            }
        }
    }

    private void bPn() {
        this.ghC.setVisibility(8);
        this.ghB.setVisibility(0);
        this.ghE.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.ghE.addView(inflate, this.ghQ);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.ohU.bUP()) {
            this.ohW = 1;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.ohU.bUQ()) {
            this.ohW = 2;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        } else if (this.ohU.ecS()) {
            this.ohW = 3;
            textView.setText(a.h.snatch_red_packet_cond_collect_desc);
            textView2.setText(a.h.snatch_red_packet_collect_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (AlaSnatchRedPacketActivity.this.ohW) {
                    case 1:
                        AlaSnatchRedPacketActivity.this.bPh();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 2:
                        AlaSnatchRedPacketActivity.this.btL();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 3:
                        AlaSnatchRedPacketActivity.this.ecL();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPo() {
        String str = this.ohU.ojQ.gIu;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.ohU.ojP.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Yo().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecL() {
        this.ohT = new e(getApplicationContext());
        this.ohT.a(new e.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.5
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
        this.ohT.w(this.mRoomId, this.mLiveId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPh() {
        ai aiVar = new ai();
        aiVar.aLA = -1;
        aiVar.aLB = -1;
        aiVar.aLD = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecM() {
        this.ghP = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.ghP.setDuration(250L);
        this.ghP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.ghL.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.ghL.setScaleY(floatValue);
            }
        });
        this.ghP.setRepeatCount(-1);
        this.ghP.setRepeatMode(2);
        this.ghP.start();
    }

    private void bPp() {
        this.ghF.setVisibility(0);
        this.ghL.setVisibility(0);
        this.ghO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ghO.setDuration(500L);
        this.ghO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.ghF.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.ghL.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.ghF.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.ghF.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.ghL.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.ghL.setScaleY((float) (f + 0.5d));
            }
        });
        this.ghO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.ecM();
                AlaSnatchRedPacketActivity.this.ghF.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ghO.start();
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
        lL(configuration.orientation == 2);
    }

    private void lL(boolean z) {
        if (z) {
            i.ae(this.cBi);
            this.cBi.setScaleX(0.7f);
            this.cBi.setScaleY(0.7f);
            if (this.ghK != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghK.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.ghK.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cBi);
        this.cBi.setScaleX(1.0f);
        this.cBi.setScaleY(1.0f);
        if (this.ghK != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ghK.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.ghK.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ohR != null) {
            this.ohR.onDestroy();
        }
        if (this.ghP != null) {
            this.ghP.removeAllListeners();
            this.ghP.cancel();
            this.ghP = null;
        }
        if (this.ghO != null) {
            this.ghO.removeAllListeners();
            this.ghO.cancel();
            this.ghO = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gia);
        MessageManager.getInstance().unRegisterListener(this.ghY);
        MessageManager.getInstance().unRegisterListener(this.aAS);
        super.onDestroy();
    }
}
