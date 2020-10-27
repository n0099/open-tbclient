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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes22.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String eve;
    private FrameLayout lKA;
    private TextView lKB;
    private ImageView lKC;
    private ImageView lKD;
    private View lKE;
    private Animation lKF;
    private com.baidu.tbadk.core.dialog.a lKG;
    private CountDownTimer lKH;
    private CountDownTimer lKI;
    private CountDownTimer lKJ;
    private boolean lKK;
    private boolean lKL;
    private a lKM;
    private TextView lKy;
    private ImageView lKz;
    private View mRootView;

    /* loaded from: classes22.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.lKM = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.lKG = null;
        this.lKH = null;
        this.lKI = null;
        this.lKJ = null;
        this.lKK = true;
        this.lKL = false;
        this.eve = null;
        this.lKM = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.lKG = null;
        this.lKH = null;
        this.lKI = null;
        this.lKJ = null;
        this.lKK = true;
        this.lKL = false;
        this.eve = null;
        this.lKM = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.lKG = null;
        this.lKH = null;
        this.lKI = null;
        this.lKJ = null;
        this.lKK = true;
        this.lKL = false;
        this.eve = null;
        this.lKM = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.lKy = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.lKA = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.lKz = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.lKD = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.lKB = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.lKC = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.lKE = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.lKy, R.color.cp_cont_g);
        ap.setBackgroundResource(this.lKC, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.lKB, R.color.cp_cont_g);
        ap.setBackgroundResource(this.lKz, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.lKD, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.lKE, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eve = fVar.dfI().bjG().bjw();
        if (StringUtils.isNull(this.eve)) {
            this.eve = fVar.dfI().bjG().getTaskId();
        }
        this.lKK = !"from_interview_live".equals(pbFragment.dis());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bkL = fVar.dfI().bkL();
        switch (bkL) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dfI().bjG().bjs()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.lKH = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.lKM != null) {
                        this.lKM.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dR("obj_id", this.eve));
                    this.mRootView.setVisibility(0);
                    if (this.lKM != null) {
                        this.lKM.callback(true);
                    }
                    this.lKy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.lKy.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.lKz.setVisibility(8);
                    this.lKD.setVisibility(8);
                    this.lKE.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.lKC, aG(pbFragment), null);
                    if (this.lKI != null) {
                        this.lKI.cancel();
                    }
                    this.lKI = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.lKB.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dR("obj_id", PbInterviewStatusView.this.eve));
                            PbInterviewStatusView.this.lKK = false;
                            PbInterviewStatusView.this.lKy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.lKy.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.lKz.setVisibility(0);
                            PbInterviewStatusView.this.lKE.setVisibility(8);
                            PbInterviewStatusView.this.lKD.setVisibility(0);
                            PbInterviewStatusView.this.lKA.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.lKL = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.lKM != null) {
                    this.lKM.callback(true);
                }
                this.lKz.setVisibility(8);
                this.lKD.setVisibility(8);
                this.lKA.setVisibility(8);
                this.lKE.setVisibility(0);
                this.lKy.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ap.setViewTextColor(this.lKy, R.color.cp_cont_f);
                ap.setBackgroundColor(this.lKE, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bkL == 2) {
                    this.lKy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.lKK) {
                        aF(pbFragment);
                        return;
                    }
                    return;
                }
                this.lKy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aF(final PbFragment pbFragment) {
        if (MessageManager.getInstance().findTask(1003200) != null) {
            View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            ap.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.cp_cont_b);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.cp_cont_b);
            ap.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            ap.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            this.lKG = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.lKG.bb(inflate);
            this.lKG.a((String) null, (a.b) null);
            this.lKG.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.lKJ != null) {
                        PbInterviewStatusView.this.lKJ.cancel();
                    }
                    if (PbInterviewStatusView.this.lKG != null) {
                        PbInterviewStatusView.this.lKG.dismiss();
                    }
                }
            });
            this.lKG.iM(false);
            this.lKG.b(pbFragment.getPageContext());
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.lKG != null) {
                        PbInterviewStatusView.this.lKG.bmC();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.lKJ = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.lKG != null) {
                        PbInterviewStatusView.this.lKG.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dir();
                    }
                }
            }.start();
        }
    }

    private Animation aG(PbFragment pbFragment) {
        if (this.lKF == null) {
            this.lKF = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.lKF.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.lKF.setInterpolator(new LinearInterpolator());
            this.lKF.setFillAfter(true);
        }
        return this.lKF;
    }

    public boolean getIndicateStatus() {
        return this.lKL;
    }

    public void clearStatus() {
        if (this.lKH != null) {
            this.lKH.cancel();
            this.lKH = null;
        }
        if (this.lKI != null) {
            this.lKI.cancel();
            this.lKI = null;
        }
        if (this.lKJ != null) {
            this.lKJ.cancel();
            this.lKJ = null;
        }
        if (this.lKG != null) {
            this.lKG.dismiss();
            this.lKG = null;
        }
    }
}
