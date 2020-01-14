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
    private TextView jaI;
    private ImageView jaJ;
    private FrameLayout jaK;
    private TextView jaL;
    private ImageView jaM;
    private ImageView jaN;
    private View jaO;
    private Animation jaP;
    private com.baidu.tbadk.core.dialog.a jaQ;
    private CountDownTimer jaR;
    private CountDownTimer jaS;
    private CountDownTimer jaT;
    private boolean jaU;
    private boolean jaV;
    private a jaW;
    private View mRootView;

    /* loaded from: classes7.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jaW = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jaQ = null;
        this.jaR = null;
        this.jaS = null;
        this.jaT = null;
        this.jaU = true;
        this.jaV = false;
        this.cKN = null;
        this.jaW = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jaQ = null;
        this.jaR = null;
        this.jaS = null;
        this.jaT = null;
        this.jaU = true;
        this.jaV = false;
        this.cKN = null;
        this.jaW = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jaQ = null;
        this.jaR = null;
        this.jaS = null;
        this.jaT = null;
        this.jaU = true;
        this.jaV = false;
        this.cKN = null;
        this.jaW = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jaI = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jaK = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jaJ = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jaN = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jaL = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jaM = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jaO = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jaI, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jaM, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jaL, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jaJ, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jaN, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jaO, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.cKN = fVar.ciS().azC().azt();
        if (StringUtils.isNull(this.cKN)) {
            this.cKN = fVar.ciS().azC().getTaskId();
        }
        this.jaU = !"from_interview_live".equals(pbFragment.clD());
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
                    this.jaR = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jaW != null) {
                        this.jaW.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cp("obj_id", this.cKN));
                    this.mRootView.setVisibility(0);
                    if (this.jaW != null) {
                        this.jaW.callback(true);
                    }
                    this.jaI.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jaI.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jaJ.setVisibility(8);
                    this.jaN.setVisibility(8);
                    this.jaO.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jaM, aD(pbFragment), null);
                    if (this.jaS != null) {
                        this.jaS.cancel();
                    }
                    this.jaS = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jaL.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cp("obj_id", PbInterviewStatusView.this.cKN));
                            PbInterviewStatusView.this.jaU = false;
                            PbInterviewStatusView.this.jaI.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jaI.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jaJ.setVisibility(0);
                            PbInterviewStatusView.this.jaO.setVisibility(8);
                            PbInterviewStatusView.this.jaN.setVisibility(0);
                            PbInterviewStatusView.this.jaK.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jaV = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jaW != null) {
                    this.jaW.callback(true);
                }
                this.jaJ.setVisibility(8);
                this.jaN.setVisibility(8);
                this.jaK.setVisibility(8);
                this.jaO.setVisibility(0);
                this.jaI.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jaI, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jaO, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aAF == 2) {
                    this.jaI.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jaU) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jaI.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.jaQ = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jaQ.aO(inflate);
            this.jaQ.a((String) null, (a.b) null);
            this.jaQ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jaT != null) {
                        PbInterviewStatusView.this.jaT.cancel();
                    }
                    if (PbInterviewStatusView.this.jaQ != null) {
                        PbInterviewStatusView.this.jaQ.dismiss();
                    }
                }
            });
            this.jaQ.fz(false);
            this.jaQ.b(pbFragment.getPageContext());
            e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jaQ != null) {
                        PbInterviewStatusView.this.jaQ.aCp();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jaT = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jaQ != null) {
                        PbInterviewStatusView.this.jaQ.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.clC();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jaP == null) {
            this.jaP = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jaP.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jaP.setInterpolator(new LinearInterpolator());
            this.jaP.setFillAfter(true);
        }
        return this.jaP;
    }

    public boolean getIndicateStatus() {
        return this.jaV;
    }

    public void clearStatus() {
        if (this.jaR != null) {
            this.jaR.cancel();
            this.jaR = null;
        }
        if (this.jaS != null) {
            this.jaS.cancel();
            this.jaS = null;
        }
        if (this.jaT != null) {
            this.jaT.cancel();
            this.jaT = null;
        }
        if (this.jaQ != null) {
            this.jaQ.dismiss();
            this.jaQ = null;
        }
    }
}
