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
    private View gfO;
    private View ghD;
    private View ghE;
    private FrameLayout ghF;
    private FrameLayout ghG;
    private FrameLayout ghH;
    private TextView ghJ;
    private TextView ghK;
    private ImageView ghL;
    private FrameLayout ghM;
    private ImageView ghN;
    private String ghP;
    private ValueAnimator ghQ;
    private ValueAnimator ghR;
    private FrameLayout.LayoutParams ghS;
    private boolean ghW;
    private long ghX;
    private int ghZ;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private String mRoomId;
    private RoundProgressBar ohS;
    private c ohT;
    private String ohU;
    private e ohV;
    private a ohW;
    private f ohX;
    private int ohY;
    private int ghY = 2;
    private CustomMessageListener aAS = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gia = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.ghP)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.ghF.setVisibility(8);
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
    private c.a ohZ = new c.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.10
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
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gie);
            AlaSnatchRedPacketActivity.this.ghN.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(fVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aP(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gie);
            AlaSnatchRedPacketActivity.this.ghN.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gic = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.ghX = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eX(AlaSnatchRedPacketActivity.this.ghX);
                if (AlaSnatchRedPacketActivity.this.ghX < 1) {
                    AlaSnatchRedPacketActivity.this.bPn();
                }
            }
        }
    };
    private Runnable gie = new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.ghN != null) {
                AlaSnatchRedPacketActivity.this.ghN.setEnabled(true);
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
            this.ohT = new c(getPageContext(), this.ohZ);
            this.ohT.aw(this.mRedPacketId, this.mLiveId, this.ohU);
            MessageManager.getInstance().registerListener(this.aAS);
            MessageManager.getInstance().registerListener(this.gia);
            MessageManager.getInstance().registerListener(this.gic);
            this.ghS = new FrameLayout.LayoutParams(-1, -1);
            lL(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.ohU = getIntent().getStringExtra("anchor_uk");
        this.mRoomId = getIntent().getStringExtra("room_id");
    }

    private void initView() {
        this.gfO = findViewById(a.f.rp_root_bg);
        this.gfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.12
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
        this.ghF = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.ghF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bPp();
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
        this.ghE = findViewById(a.f.rp_normal_bg);
        this.ghD = findViewById(a.f.rp_condition_guide_bg);
        this.ghG = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.ohX = fVar;
        if (fVar.bUM()) {
            this.ghZ = 101;
        } else {
            this.ghZ = 100;
        }
        bPl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.data.a aVar) {
        if (aVar.ojR != null) {
            this.mContentView.setVisibility(0);
            this.ohW = aVar;
            this.ghP = this.ohW.ojS.gIw;
            if (!StringUtils.isNullObject(aVar.ojR.portrait)) {
                l.a(this.bli, aVar.ojR.portrait, true, false);
            }
            this.eBQ.setText(aVar.ojR.userName);
            boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.ghP) : true;
            if (this.ohW.ojS.gIx || equals) {
                this.ghF.setVisibility(8);
            } else {
                this.ghF.setVisibility(0);
            }
            if (this.ohW.bUM()) {
                this.ghY = 3;
            } else if (this.ohW.isValid()) {
                if (aVar.bUO()) {
                    this.ghY = 1;
                    this.ghF.setVisibility(8);
                } else {
                    this.ghY = 2;
                }
            } else if (this.ohW.bUJ()) {
                this.ghY = 5;
            } else if (this.ohW.bUK()) {
                this.ghY = 4;
            }
            bPk();
        }
    }

    private void bPk() {
        switch (this.ghY) {
            case 1:
                bPo();
                return;
            case 2:
                bPm();
                return;
            case 3:
                this.ghZ = 102;
                bPl();
                return;
            case 4:
                this.ghZ = 103;
                bPl();
                return;
            case 5:
                this.ghZ = 104;
                bPl();
                return;
            default:
                return;
        }
    }

    private void bPl() {
        String str;
        this.ghE.setVisibility(8);
        this.ghD.setVisibility(0);
        this.ghF.setVisibility(8);
        this.ghG.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.ghG.addView(inflate, this.ghS);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ah(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.ohU)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bPi();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.ghZ) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.ghZ == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ohX.bUN())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ohW.bUN())));
                return;
            default:
                return;
        }
    }

    private void bPm() {
        this.ghE.setVisibility(0);
        this.ghD.setVisibility(8);
        this.ghG.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_red_packet_snatch, (ViewGroup) null);
        this.ghG.addView(inflate, this.ghS);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.ohW.ojR.gIU)));
        this.ghM = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghM.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.ghM.setLayoutParams(layoutParams);
        }
        this.ghN = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.ghN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.ghN.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gie, 1000L);
                AlaSnatchRedPacketActivity.this.ohT.ax(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.ohU);
            }
        });
        this.ghH = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.ohS = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.ghJ = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.ghL = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.ghL.setVisibility(8);
        this.ghK = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.ohW.bUL()) {
            this.ghN.setVisibility(0);
            this.ghH.setVisibility(8);
            ecN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPn() {
        bPq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(long j) {
        if (this.ohW != null) {
            String[] ff = this.ohW.ff(j);
            if (j <= 60) {
                if (!this.ghW) {
                    this.ghW = true;
                    if (this.ghL != null) {
                        this.ghL.setVisibility(8);
                    }
                    if (this.ghK != null) {
                        this.ghK.setVisibility(8);
                    }
                    if (this.ghJ != null) {
                        this.ghJ.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.ghJ != null && !TextUtils.equals(ff[1], "00")) {
                    this.ghJ.setText(ff[1]);
                }
            } else {
                if (this.ghL != null && this.ghL.getVisibility() != 0) {
                    this.ghL.setVisibility(0);
                }
                if (this.ghJ != null) {
                    this.ghJ.setText(ff[0]);
                }
                if (this.ghK != null) {
                    this.ghK.setText(ff[1]);
                }
            }
            if (this.ohS != null) {
                this.ohS.setProgress(this.ohW.fe(j));
            }
        }
    }

    private void bPo() {
        this.ghE.setVisibility(8);
        this.ghD.setVisibility(0);
        this.ghG.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.ghG.addView(inflate, this.ghS);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.ohW.bUQ()) {
            this.ohY = 1;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.ohW.bUR()) {
            this.ohY = 2;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        } else if (this.ohW.ecT()) {
            this.ohY = 3;
            textView.setText(a.h.snatch_red_packet_cond_collect_desc);
            textView2.setText(a.h.snatch_red_packet_collect_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (AlaSnatchRedPacketActivity.this.ohY) {
                    case 1:
                        AlaSnatchRedPacketActivity.this.bPi();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 2:
                        AlaSnatchRedPacketActivity.this.btL();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 3:
                        AlaSnatchRedPacketActivity.this.ecM();
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
    public void bPp() {
        String str = this.ohW.ojS.gIw;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.ohW.ojR.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Yo().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecM() {
        this.ohV = new e(getApplicationContext());
        this.ohV.a(new e.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.5
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
        this.ohV.w(this.mRoomId, this.mLiveId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPi() {
        ai aiVar = new ai();
        aiVar.aLA = -1;
        aiVar.aLB = -1;
        aiVar.aLD = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ecN() {
        this.ghR = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.ghR.setDuration(250L);
        this.ghR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.ghN.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.ghN.setScaleY(floatValue);
            }
        });
        this.ghR.setRepeatCount(-1);
        this.ghR.setRepeatMode(2);
        this.ghR.start();
    }

    private void bPq() {
        this.ghH.setVisibility(0);
        this.ghN.setVisibility(0);
        this.ghQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ghQ.setDuration(500L);
        this.ghQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.ghH.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.ghN.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.ghH.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.ghH.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.ghN.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.ghN.setScaleY((float) (f + 0.5d));
            }
        });
        this.ghQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.ecN();
                AlaSnatchRedPacketActivity.this.ghH.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ghQ.start();
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
            if (this.ghM != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ghM.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.ghM.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cBi);
        this.cBi.setScaleX(1.0f);
        this.cBi.setScaleY(1.0f);
        if (this.ghM != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ghM.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.ghM.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ohT != null) {
            this.ohT.onDestroy();
        }
        if (this.ghR != null) {
            this.ghR.removeAllListeners();
            this.ghR.cancel();
            this.ghR = null;
        }
        if (this.ghQ != null) {
            this.ghQ.removeAllListeners();
            this.ghQ.cancel();
            this.ghQ = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gic);
        MessageManager.getInstance().unRegisterListener(this.gia);
        MessageManager.getInstance().unRegisterListener(this.aAS);
        super.onDestroy();
    }
}
