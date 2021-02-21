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
import com.baidu.live.data.ao;
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
/* loaded from: classes11.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView blt;
    private FrameLayout cDI;
    private TextView eIO;
    private View gog;
    private FrameLayout gqA;
    private ImageView gqB;
    private String gqD;
    private ValueAnimator gqE;
    private ValueAnimator gqF;
    private FrameLayout.LayoutParams gqG;
    private boolean gqK;
    private long gqL;
    private int gqN;
    private View gqr;
    private View gqs;
    private FrameLayout gqt;
    private FrameLayout gqu;
    private FrameLayout gqv;
    private TextView gqx;
    private TextView gqy;
    private ImageView gqz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private String mRoomId;
    private FrameLayout opm;
    private RoundProgressBar opn;
    private c opo;
    private String opp;
    private e opq;
    private a opr;
    private f ops;
    private int opu;
    private int gqM = 2;
    private CustomMessageListener awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gqO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.gqD)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.gqt.setVisibility(8);
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
    private c.a opv = new c.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.10
        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(com.baidu.tieba.yuyinala.data.a aVar) {
            AlaSnatchRedPacketActivity.this.a(aVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aW(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void b(f fVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gqR);
            AlaSnatchRedPacketActivity.this.gqB.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(fVar);
        }

        @Override // com.baidu.tieba.yuyinala.c.c.a
        public void aX(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gqR);
            AlaSnatchRedPacketActivity.this.gqB.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gqQ = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gqL = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.fd(AlaSnatchRedPacketActivity.this.gqL);
                if (AlaSnatchRedPacketActivity.this.gqL < 1) {
                    AlaSnatchRedPacketActivity.this.bOH();
                }
            }
        }
    };
    private Runnable gqR = new Runnable() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.gqB != null) {
                AlaSnatchRedPacketActivity.this.gqB.setEnabled(true);
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
            this.opo = new c(getPageContext(), this.opv);
            this.opo.az(this.mRedPacketId, this.mLiveId, this.opp);
            MessageManager.getInstance().registerListener(this.awl);
            MessageManager.getInstance().registerListener(this.gqO);
            MessageManager.getInstance().registerListener(this.gqQ);
            this.gqG = new FrameLayout.LayoutParams(-1, -1);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.opp = getIntent().getStringExtra("anchor_uk");
        this.mRoomId = getIntent().getStringExtra("room_id");
        this.gqL = getIntent().getLongExtra("time", 0L);
    }

    private void initView() {
        this.gog = findViewById(a.f.rp_root_bg);
        this.gog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cDI = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.blt = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.blt.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.blt.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.blt.setIsRound(true);
        this.blt.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.blt.setAutoChangeStyle(true);
        this.blt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eIO = (TextView) findViewById(a.f.rp_user_name);
        this.gqt = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.gqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOJ();
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
        this.gqs = findViewById(a.f.rp_normal_bg);
        this.gqr = findViewById(a.f.rp_condition_guide_bg);
        this.gqu = (FrameLayout) findViewById(a.f.rp_sub_content_container);
        this.gqu.setVisibility(8);
        this.opm = (FrameLayout) findViewById(a.f.rp_normal_layout_def);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar) {
        this.ops = fVar;
        if (fVar.bUl()) {
            this.gqN = 101;
        } else {
            this.gqN = 100;
        }
        bOF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.yuyinala.data.a aVar) {
        if (aVar.oru != null) {
            this.mContentView.setVisibility(0);
            this.opr = aVar;
            this.gqD = this.opr.orv.gSz;
            if (!StringUtils.isNullObject(aVar.oru.portrait)) {
                m.a(this.blt, aVar.oru.portrait, true, false);
            }
            this.eIO.setText(aVar.oru.userName);
            boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.gqD) : true;
            if (this.opr.orv.gSA || equals) {
                this.gqt.setVisibility(8);
            } else {
                this.gqt.setVisibility(0);
            }
            if (this.opr.bUl()) {
                this.gqM = 3;
            } else if (this.opr.isValid()) {
                if (aVar.bUn()) {
                    this.gqM = 1;
                    this.gqt.setVisibility(8);
                } else {
                    this.gqM = 2;
                }
            } else if (this.opr.bUi()) {
                this.gqM = 5;
            } else if (this.opr.bUj()) {
                this.gqM = 4;
            }
            bOE();
        }
    }

    private void bOE() {
        switch (this.gqM) {
            case 1:
                bOI();
                return;
            case 2:
                bOG();
                return;
            case 3:
                this.gqN = 102;
                bOF();
                return;
            case 4:
                this.gqN = 103;
                bOF();
                return;
            case 5:
                this.gqN = 104;
                bOF();
                return;
            default:
                return;
        }
    }

    private void bOF() {
        String str;
        this.gqs.setVisibility(8);
        this.gqr.setVisibility(0);
        this.gqt.setVisibility(8);
        this.opm.setVisibility(8);
        this.gqu.setVisibility(0);
        this.gqu.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.gqu.addView(inflate, this.gqG);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ah(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.opp)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOC();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gqN) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gqN == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix_2), Long.valueOf(this.ops.bUm())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.opr.bUm())));
                return;
            default:
                return;
        }
    }

    private void bOG() {
        this.gqs.setVisibility(0);
        this.gqr.setVisibility(8);
        this.opm.setVisibility(8);
        this.gqu.setVisibility(0);
        this.gqu.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.yuyin_ala_red_packet_snatch, (ViewGroup) null);
        this.gqu.addView(inflate, this.gqG);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.opr.oru.gSY)));
        this.gqA = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqA.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.gqA.setLayoutParams(layoutParams);
        }
        this.gqB = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.gqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.gqB.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gqR, 1000L);
                AlaSnatchRedPacketActivity.this.opo.aA(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.opp);
            }
        });
        this.gqv = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.opn = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.gqx = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.gqz = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.gqz.setVisibility(8);
        this.gqy = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.opr.bUk()) {
            this.gqB.setVisibility(0);
            this.gqv.setVisibility(8);
            eal();
        }
        fd(this.gqL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        bOK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(long j) {
        if (this.opr != null) {
            String[] fl = this.opr.fl(j);
            if (j <= 60) {
                if (!this.gqK) {
                    this.gqK = true;
                    if (this.gqz != null) {
                        this.gqz.setVisibility(8);
                    }
                    if (this.gqy != null) {
                        this.gqy.setVisibility(8);
                    }
                    if (this.gqx != null) {
                        this.gqx.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.gqx != null && !TextUtils.equals(fl[1], "00")) {
                    this.gqx.setText(fl[1]);
                }
            } else {
                if (this.gqz != null && this.gqz.getVisibility() != 0) {
                    this.gqz.setVisibility(0);
                }
                if (this.gqx != null) {
                    this.gqx.setText(fl[0]);
                }
                if (this.gqy != null) {
                    this.gqy.setText(fl[1]);
                }
            }
            if (this.opn != null) {
                this.opn.setProgress(this.opr.fk(j));
            }
        }
    }

    private void bOI() {
        this.gqs.setVisibility(8);
        this.gqr.setVisibility(0);
        this.opm.setVisibility(8);
        this.gqu.setVisibility(0);
        this.gqu.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.gqu.addView(inflate, this.gqG);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.opr.bUp()) {
            this.opu = 1;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.opr.bUq()) {
            this.opu = 2;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        } else if (this.opr.ear()) {
            this.opu = 3;
            textView.setText(a.h.snatch_red_packet_cond_collect_desc);
            textView2.setText(a.h.snatch_red_packet_collect_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                switch (AlaSnatchRedPacketActivity.this.opu) {
                    case 1:
                        AlaSnatchRedPacketActivity.this.bOC();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 2:
                        AlaSnatchRedPacketActivity.this.bsG();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    case 3:
                        AlaSnatchRedPacketActivity.this.eak();
                        AlaSnatchRedPacketActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOJ() {
        String str = this.opr.orv.gSz;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.opr.oru.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Xo().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eak() {
        this.opq = new e(getApplicationContext());
        this.opq.a(new e.a() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.5
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
        this.opq.y(this.mRoomId, this.mLiveId, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOC() {
        ao aoVar = new ao();
        aoVar.aJW = -1;
        aoVar.aJX = -1;
        aoVar.aJZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eal() {
        this.gqF = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.gqF.setDuration(250L);
        this.gqF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.gqB.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.gqB.setScaleY(floatValue);
            }
        });
        this.gqF.setRepeatCount(-1);
        this.gqF.setRepeatMode(2);
        this.gqF.start();
    }

    private void bOK() {
        this.gqv.setVisibility(0);
        this.gqB.setVisibility(0);
        this.gqE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gqE.setDuration(500L);
        this.gqE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.gqv.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.gqB.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.gqv.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.gqv.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.gqB.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.gqB.setScaleY((float) (f + 0.5d));
            }
        });
        this.gqE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.yuyinala.AlaSnatchRedPacketActivity.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.eal();
                AlaSnatchRedPacketActivity.this.gqv.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gqE.start();
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
        mi(configuration.orientation == 2);
    }

    private void mi(boolean z) {
        if (z) {
            i.ae(this.cDI);
            this.cDI.setScaleX(0.7f);
            this.cDI.setScaleY(0.7f);
            if (this.gqA != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqA.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.gqA.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cDI);
        this.cDI.setScaleX(1.0f);
        this.cDI.setScaleY(1.0f);
        if (this.gqA != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gqA.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.gqA.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.opo != null) {
            this.opo.onDestroy();
        }
        if (this.gqF != null) {
            this.gqF.removeAllListeners();
            this.gqF.cancel();
            this.gqF = null;
        }
        if (this.gqE != null) {
            this.gqE.removeAllListeners();
            this.gqE.cancel();
            this.gqE = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gqQ);
        MessageManager.getInstance().unRegisterListener(this.gqO);
        MessageManager.getInstance().unRegisterListener(this.awl);
        super.onDestroy();
    }
}
