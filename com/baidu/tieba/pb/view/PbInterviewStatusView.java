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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String cKN;
    private TextView jaD;
    private ImageView jaE;
    private FrameLayout jaF;
    private TextView jaG;
    private ImageView jaH;
    private ImageView jaI;
    private View jaJ;
    private Animation jaK;
    private com.baidu.tbadk.core.dialog.a jaL;
    private CountDownTimer jaM;
    private CountDownTimer jaN;
    private CountDownTimer jaO;
    private boolean jaP;
    private boolean jaQ;
    private a jaR;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jaR = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jaL = null;
        this.jaM = null;
        this.jaN = null;
        this.jaO = null;
        this.jaP = true;
        this.jaQ = false;
        this.cKN = null;
        this.jaR = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jaL = null;
        this.jaM = null;
        this.jaN = null;
        this.jaO = null;
        this.jaP = true;
        this.jaQ = false;
        this.cKN = null;
        this.jaR = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jaL = null;
        this.jaM = null;
        this.jaN = null;
        this.jaO = null;
        this.jaP = true;
        this.jaQ = false;
        this.cKN = null;
        this.jaR = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jaD = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jaF = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jaE = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jaI = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jaG = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jaH = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jaJ = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jaD, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jaH, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jaG, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jaE, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jaI, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jaJ, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.cKN = fVar.ciS().azC().azt();
        if (StringUtils.isNull(this.cKN)) {
            this.cKN = fVar.ciS().azC().getTaskId();
        }
        this.jaP = !"from_interview_live".equals(pbFragment.clD());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int aAF = fVar.ciS().aAF();
        switch (aAF) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.ciS().azC().azp()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jaM = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jaR != null) {
                        this.jaR.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cp("obj_id", this.cKN));
                    this.mRootView.setVisibility(0);
                    if (this.jaR != null) {
                        this.jaR.callback(true);
                    }
                    this.jaD.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jaD.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jaE.setVisibility(8);
                    this.jaI.setVisibility(8);
                    this.jaJ.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jaH, aD(pbFragment), null);
                    if (this.jaN != null) {
                        this.jaN.cancel();
                    }
                    this.jaN = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jaG.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cp("obj_id", PbInterviewStatusView.this.cKN));
                            PbInterviewStatusView.this.jaP = false;
                            PbInterviewStatusView.this.jaD.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jaD.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jaE.setVisibility(0);
                            PbInterviewStatusView.this.jaJ.setVisibility(8);
                            PbInterviewStatusView.this.jaI.setVisibility(0);
                            PbInterviewStatusView.this.jaF.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jaQ = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jaR != null) {
                    this.jaR.callback(true);
                }
                this.jaE.setVisibility(8);
                this.jaI.setVisibility(8);
                this.jaF.setVisibility(8);
                this.jaJ.setVisibility(0);
                this.jaD.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jaD, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jaJ, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aAF == 2) {
                    this.jaD.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jaP) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jaD.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            am.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), (int) R.color.cp_cont_b);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), (int) R.color.cp_cont_b);
            am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            am.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            this.jaL = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jaL.aO(inflate);
            this.jaL.a((String) null, (a.b) null);
            this.jaL.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jaO != null) {
                        PbInterviewStatusView.this.jaO.cancel();
                    }
                    if (PbInterviewStatusView.this.jaL != null) {
                        PbInterviewStatusView.this.jaL.dismiss();
                    }
                }
            });
            this.jaL.fz(false);
            this.jaL.b(pbFragment.getPageContext());
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jaL != null) {
                        PbInterviewStatusView.this.jaL.aCp();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jaO = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jaL != null) {
                        PbInterviewStatusView.this.jaL.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.clC();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jaK == null) {
            this.jaK = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jaK.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jaK.setInterpolator(new LinearInterpolator());
            this.jaK.setFillAfter(true);
        }
        return this.jaK;
    }

    public boolean getIndicateStatus() {
        return this.jaQ;
    }

    public void clearStatus() {
        if (this.jaM != null) {
            this.jaM.cancel();
            this.jaM = null;
        }
        if (this.jaN != null) {
            this.jaN.cancel();
            this.jaN = null;
        }
        if (this.jaO != null) {
            this.jaO.cancel();
            this.jaO = null;
        }
        if (this.jaL != null) {
            this.jaL.dismiss();
            this.jaL = null;
        }
    }
}
