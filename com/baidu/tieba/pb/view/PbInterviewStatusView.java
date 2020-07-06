package com.baidu.tieba.pb.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String dIK;
    private TextView kAS;
    private ImageView kAT;
    private FrameLayout kAU;
    private TextView kAV;
    private ImageView kAW;
    private ImageView kAX;
    private View kAY;
    private Animation kAZ;
    private com.baidu.tbadk.core.dialog.a kBa;
    private CountDownTimer kBb;
    private CountDownTimer kBc;
    private CountDownTimer kBd;
    private boolean kBe;
    private boolean kBf;
    private a kBg;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.kBg = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.kBa = null;
        this.kBb = null;
        this.kBc = null;
        this.kBd = null;
        this.kBe = true;
        this.kBf = false;
        this.dIK = null;
        this.kBg = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.kBa = null;
        this.kBb = null;
        this.kBc = null;
        this.kBd = null;
        this.kBe = true;
        this.kBf = false;
        this.dIK = null;
        this.kBg = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.kBa = null;
        this.kBb = null;
        this.kBc = null;
        this.kBd = null;
        this.kBe = true;
        this.kBf = false;
        this.dIK = null;
        this.kBg = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.kAS = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.kAU = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.kAT = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.kAX = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.kAV = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.kAW = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.kAY = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        an.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        an.setViewTextColor(this.kAS, (int) R.color.cp_cont_g);
        an.setBackgroundResource(this.kAW, R.drawable.icon_interview_loding);
        an.setViewTextColor(this.kAV, (int) R.color.cp_cont_g);
        an.setBackgroundResource(this.kAT, R.drawable.icon_interview_mic);
        an.setBackgroundResource(this.kAX, R.drawable.icon_arrow_tip_white);
        an.setBackgroundColor(this.kAY, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.dIK = eVar.cGO().aRV().aRL();
        if (StringUtils.isNull(this.dIK)) {
            this.dIK = eVar.cGO().aRV().getTaskId();
        }
        this.kBe = !"from_interview_live".equals(pbFragment.cJA());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aTa = eVar.cGO().aTa();
        switch (aTa) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cGO().aRV().aRH()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.kBb = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.kBg != null) {
                        this.kBg.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ao("c11105").dk("obj_id", this.dIK));
                    this.mRootView.setVisibility(0);
                    if (this.kBg != null) {
                        this.kBg.callback(true);
                    }
                    this.kAS.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.kAS.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.kAT.setVisibility(8);
                    this.kAX.setVisibility(8);
                    this.kAY.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.kAW, aD(pbFragment), null);
                    if (this.kBc != null) {
                        this.kBc.cancel();
                    }
                    this.kBc = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.kAV.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ao("c11106").dk("obj_id", PbInterviewStatusView.this.dIK));
                            PbInterviewStatusView.this.kBe = false;
                            PbInterviewStatusView.this.kAS.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.kAS.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.kAT.setVisibility(0);
                            PbInterviewStatusView.this.kAY.setVisibility(8);
                            PbInterviewStatusView.this.kAX.setVisibility(0);
                            PbInterviewStatusView.this.kAU.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.kBf = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.kBg != null) {
                    this.kBg.callback(true);
                }
                this.kAT.setVisibility(8);
                this.kAX.setVisibility(8);
                this.kAU.setVisibility(8);
                this.kAY.setVisibility(0);
                this.kAS.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                an.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                an.setViewTextColor(this.kAS, (int) R.color.cp_cont_f);
                an.setBackgroundColor(this.kAY, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aTa == 2) {
                    this.kAS.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.kBe) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.kAS.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aC(final PbFragment pbFragment) {
        if (MessageManager.getInstance().findTask(1003200) != null) {
            View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            an.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            an.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), (int) R.color.cp_cont_b);
            an.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), (int) R.color.cp_cont_b);
            an.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            an.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            an.setViewTextColor(textView, (int) R.color.cp_cont_f);
            this.kBa = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.kBa.aP(inflate);
            this.kBa.a((String) null, (a.b) null);
            this.kBa.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.kBd != null) {
                        PbInterviewStatusView.this.kBd.cancel();
                    }
                    if (PbInterviewStatusView.this.kBa != null) {
                        PbInterviewStatusView.this.kBa.dismiss();
                    }
                }
            });
            this.kBa.hf(false);
            this.kBa.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.kBa != null) {
                        PbInterviewStatusView.this.kBa.aUN();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.kBd = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.kBa != null) {
                        PbInterviewStatusView.this.kBa.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cJz();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.kAZ == null) {
            this.kAZ = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.kAZ.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.kAZ.setInterpolator(new LinearInterpolator());
            this.kAZ.setFillAfter(true);
        }
        return this.kAZ;
    }

    public boolean getIndicateStatus() {
        return this.kBf;
    }

    public void clearStatus() {
        if (this.kBb != null) {
            this.kBb.cancel();
            this.kBb = null;
        }
        if (this.kBc != null) {
            this.kBc.cancel();
            this.kBc = null;
        }
        if (this.kBd != null) {
            this.kBd.cancel();
            this.kBd = null;
        }
        if (this.kBa != null) {
            this.kBa.dismiss();
            this.kBa = null;
        }
    }
}
