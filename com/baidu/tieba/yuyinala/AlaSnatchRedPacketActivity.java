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
import com.baidu.live.data.ak;
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
import com.baidu.live.utils.m;
import com.baidu.tieba.yuyinala.c.c;
import com.baidu.tieba.yuyinala.c.e;
import com.baidu.tieba.yuyinala.data.a;
import com.baidu.tieba.yuyinala.data.f;
import com.baidu.tieba.yuyinala.view.RoundProgressBar;
/* loaded from: classes10.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView bhZ;
    private FrameLayout cBm;
    private TextView eGI;
    private View glm;
    private TextView gnA;
    private TextView gnB;
    private ImageView gnC;
    private FrameLayout gnD;
    private ImageView gnE;
    private String gnG;
    private ValueAnimator gnH;
    private ValueAnimator gnI;
    private FrameLayout.LayoutParams gnJ;
    private boolean gnN;
    private long gnO;
    private int gnQ;
    private View gnu;
    private View gnv;
    private FrameLayout gnw;
    private FrameLayout gnx;
    private FrameLayout gny;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private String mRoomId;
    private FrameLayout oeS;
    private RoundProgressBar oeT;
    private c oeU;
    private String oeV;
    private e oeW;
    private a oeX;
    private f oeY;
    private int oeZ;
    private int gnP = 2;
    private CustomMessageListener aww = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gnR = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.gnG)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.gnw.setVisibility(8);
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
    private c.a ofa = new c.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.10
        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(com.baidu.tieba.yuyinala.data.a aVar) {
            AlaSnatchRedPacketActivity.this.a(aVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aR(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(f fVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gnU);
            AlaSnatchRedPacketActivity.this.gnE.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(fVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aS(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gnU);
            AlaSnatchRedPacketActivity.this.gnE.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gnT = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gnO = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eX(AlaSnatchRedPacketActivity.this.gnO);
                if (AlaSnatchRedPacketActivity.this.gnO < 1) {
                    AlaSnatchRedPacketActivity.this.bNW();
                }
            }
        }
    };
    private Runnable gnU = new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.gnE != null) {
                AlaSnatchRedPacketActivity.this.gnE.setEnabled(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
            setContentView(a.g.yuyin_ala_snatch_red_packet_view);
            initView();
            this.oeU = new c(getPageContext(), this.ofa);
            this.oeU.ay(this.mRedPacketId, this.mLiveId, this.oeV);
            MessageManager.getInstance().registerListener(this.aww);
            MessageManager.getInstance().registerListener(this.gnR);
            MessageManager.getInstance().registerListener(this.gnT);
            this.gnJ = new FrameLayout.LayoutParams(-1, -1);
            me(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.oeV = getIntent().getStringExtra("anchor_uk");
        this.mRoomId = getIntent().getStringExtra("room_id");
        this.gnO = getIntent().getLongExtra("time", 0L);
    }

    private void initView() {
        this.glm = findViewById(a.f.rp_root_bg);
        this.glm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cBm = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bhZ = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.bhZ.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bhZ.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bhZ.setIsRound(true);
        this.bhZ.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bhZ.setAutoChangeStyle(true);
        this.bhZ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eGI = (TextView) findViewById(a.f.rp_user_name);
        this.gnw = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.gnw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bNY();
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
        this.gnv = findViewById(a.f.rp_normal_bg);
        this.gnu = findViewById(a.f.rp_condition_guide_bg);
        this.gnx = (FrameLayout) findViewById(a.f.rp_sub_content_container);
        this.gnx.setVisibility(8);
        this.oeS = (FrameLayout) findViewById(a.f.rp_normal_layout_def);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.oeY = fVar;
        if (fVar.bTz()) {
            this.gnQ = 101;
        } else {
            this.gnQ = 100;
        }
        bNU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.data.a aVar) {
        if (aVar.ogZ != null) {
            this.mContentView.setVisibility(0);
            this.oeX = aVar;
            this.gnG = this.oeX.oha.gPC;
            if (!StringUtils.isNullObject(aVar.ogZ.portrait)) {
                m.a(this.bhZ, aVar.ogZ.portrait, true, false);
            }
            this.eGI.setText(aVar.ogZ.userName);
            boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.gnG) : true;
            if (this.oeX.oha.gPD || equals) {
                this.gnw.setVisibility(8);
            } else {
                this.gnw.setVisibility(0);
            }
            if (this.oeX.bTz()) {
                this.gnP = 3;
            } else if (this.oeX.isValid()) {
                if (aVar.bTB()) {
                    this.gnP = 1;
                    this.gnw.setVisibility(8);
                } else {
                    this.gnP = 2;
                }
            } else if (this.oeX.bTw()) {
                this.gnP = 5;
            } else if (this.oeX.bTx()) {
                this.gnP = 4;
            }
            bNT();
        }
    }

    private void bNT() {
        switch (this.gnP) {
            case 1:
                bNX();
                return;
            case 2:
                bNV();
                return;
            case 3:
                this.gnQ = 102;
                bNU();
                return;
            case 4:
                this.gnQ = 103;
                bNU();
                return;
            case 5:
                this.gnQ = 104;
                bNU();
                return;
            default:
                return;
        }
    }

    private void bNU() {
        String str;
        this.gnv.setVisibility(8);
        this.gnu.setVisibility(0);
        this.gnw.setVisibility(8);
        this.oeS.setVisibility(8);
        this.gnx.setVisibility(0);
        this.gnx.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.gnx.addView(inflate, this.gnJ);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ah(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.oeV)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bNR();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gnQ) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gnQ == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix_2), Long.valueOf(this.oeY.bTA())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.oeX.bTA())));
                return;
            default:
                return;
        }
    }

    private void bNV() {
        this.gnv.setVisibility(0);
        this.gnu.setVisibility(8);
        this.oeS.setVisibility(8);
        this.gnx.setVisibility(0);
        this.gnx.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_red_packet_snatch, (ViewGroup) null);
        this.gnx.addView(inflate, this.gnJ);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.oeX.ogZ.gQa)));
        this.gnD = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gnD.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.gnD.setLayoutParams(layoutParams);
        }
        this.gnE = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.gnE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.gnE.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gnU, 1000L);
                AlaSnatchRedPacketActivity.this.oeU.az(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.oeV);
            }
        });
        this.gny = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.oeT = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.gnA = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.gnC = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.gnC.setVisibility(8);
        this.gnB = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.oeX.bTy()) {
            this.gnE.setVisibility(0);
            this.gny.setVisibility(8);
            dXS();
        }
        eX(this.gnO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNW() {
        bNZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(long j) {
        if (this.oeX != null) {
            String[] ff = this.oeX.ff(j);
            if (j <= 60) {
                if (!this.gnN) {
                    this.gnN = true;
                    if (this.gnC != null) {
                        this.gnC.setVisibility(8);
                    }
                    if (this.gnB != null) {
                        this.gnB.setVisibility(8);
                    }
                    if (this.gnA != null) {
                        this.gnA.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.gnA != null && !TextUtils.equals(ff[1], "00")) {
                    this.gnA.setText(ff[1]);
                }
            } else {
                if (this.gnC != null && this.gnC.getVisibility() != 0) {
                    this.gnC.setVisibility(0);
                }
                if (this.gnA != null) {
                    this.gnA.setText(ff[0]);
                }
                if (this.gnB != null) {
                    this.gnB.setText(ff[1]);
                }
            }
            if (this.oeT != null) {
                this.oeT.setProgress(this.oeX.fe(j));
            }
        }
    }

    private void bNX() {
        this.gnv.setVisibility(8);
        this.gnu.setVisibility(0);
        this.oeS.setVisibility(8);
        this.gnx.setVisibility(0);
        this.gnx.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.gnx.addView(inflate, this.gnJ);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.oeX.bTD()) {
            this.oeZ = 1;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.oeX.bTE()) {
            this.oeZ = 2;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        } else if (this.oeX.dXY()) {
            this.oeZ = 3;
            textView.setText(a.h.snatch_red_packet_cond_collect_desc);
            textView2.setText(a.h.snatch_red_packet_collect_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (AlaSnatchRedPacketActivity.this.oeZ) {
                    case 1:
                        AlaSnatchRedPacketActivity.this.bNR();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 2:
                        AlaSnatchRedPacketActivity.this.bsm();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 3:
                        AlaSnatchRedPacketActivity.this.dXR();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNY() {
        String str = this.oeX.oha.gPC;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.oeX.ogZ.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.VF().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXR() {
        this.oeW = new e(getApplicationContext());
        this.oeW.a(new e.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.5
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
        this.oeW.y(this.mRoomId, this.mLiveId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNR() {
        ak akVar = new ak();
        akVar.aHr = -1;
        akVar.aHs = -1;
        akVar.aHu = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dXS() {
        this.gnI = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.gnI.setDuration(250L);
        this.gnI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.gnE.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.gnE.setScaleY(floatValue);
            }
        });
        this.gnI.setRepeatCount(-1);
        this.gnI.setRepeatMode(2);
        this.gnI.start();
    }

    private void bNZ() {
        this.gny.setVisibility(0);
        this.gnE.setVisibility(0);
        this.gnH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gnH.setDuration(500L);
        this.gnH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.gny.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.gnE.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.gny.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.gny.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.gnE.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.gnE.setScaleY((float) (f + 0.5d));
            }
        });
        this.gnH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.dXS();
                AlaSnatchRedPacketActivity.this.gny.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gnH.start();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        me(configuration.orientation == 2);
    }

    private void me(boolean z) {
        if (z) {
            i.ae(this.cBm);
            this.cBm.setScaleX(0.7f);
            this.cBm.setScaleY(0.7f);
            if (this.gnD != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gnD.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.gnD.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cBm);
        this.cBm.setScaleX(1.0f);
        this.cBm.setScaleY(1.0f);
        if (this.gnD != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gnD.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.gnD.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.oeU != null) {
            this.oeU.onDestroy();
        }
        if (this.gnI != null) {
            this.gnI.removeAllListeners();
            this.gnI.cancel();
            this.gnI = null;
        }
        if (this.gnH != null) {
            this.gnH.removeAllListeners();
            this.gnH.cancel();
            this.gnH = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gnT);
        MessageManager.getInstance().unRegisterListener(this.gnR);
        MessageManager.getInstance().unRegisterListener(this.aww);
        super.onDestroy();
    }
}
