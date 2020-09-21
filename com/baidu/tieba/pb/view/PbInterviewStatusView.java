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
/* loaded from: classes21.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String eaC;
    private TextView liJ;
    private ImageView liK;
    private FrameLayout liL;
    private TextView liM;
    private ImageView liN;
    private ImageView liO;
    private View liP;
    private Animation liQ;
    private com.baidu.tbadk.core.dialog.a liR;
    private CountDownTimer liS;
    private CountDownTimer liT;
    private CountDownTimer liU;
    private boolean liV;
    private boolean liW;
    private a liX;
    private View mRootView;

    /* loaded from: classes21.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.liX = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.liR = null;
        this.liS = null;
        this.liT = null;
        this.liU = null;
        this.liV = true;
        this.liW = false;
        this.eaC = null;
        this.liX = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.liR = null;
        this.liS = null;
        this.liT = null;
        this.liU = null;
        this.liV = true;
        this.liW = false;
        this.eaC = null;
        this.liX = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.liR = null;
        this.liS = null;
        this.liT = null;
        this.liU = null;
        this.liV = true;
        this.liW = false;
        this.eaC = null;
        this.liX = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.liJ = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.liL = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.liK = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.liO = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.liM = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.liN = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.liP = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.liJ, R.color.cp_cont_g);
        ap.setBackgroundResource(this.liN, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.liM, R.color.cp_cont_g);
        ap.setBackgroundResource(this.liK, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.liO, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.liP, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eaC = fVar.cYR().bfe().beU();
        if (StringUtils.isNull(this.eaC)) {
            this.eaC = fVar.cYR().bfe().getTaskId();
        }
        this.liV = !"from_interview_live".equals(pbFragment.dbC());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bgj = fVar.cYR().bgj();
        switch (bgj) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.cYR().bfe().beQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.liS = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.liX != null) {
                        this.liX.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dF("obj_id", this.eaC));
                    this.mRootView.setVisibility(0);
                    if (this.liX != null) {
                        this.liX.callback(true);
                    }
                    this.liJ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.liJ.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.liK.setVisibility(8);
                    this.liO.setVisibility(8);
                    this.liP.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.liN, aG(pbFragment), null);
                    if (this.liT != null) {
                        this.liT.cancel();
                    }
                    this.liT = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.liM.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dF("obj_id", PbInterviewStatusView.this.eaC));
                            PbInterviewStatusView.this.liV = false;
                            PbInterviewStatusView.this.liJ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.liJ.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.liK.setVisibility(0);
                            PbInterviewStatusView.this.liP.setVisibility(8);
                            PbInterviewStatusView.this.liO.setVisibility(0);
                            PbInterviewStatusView.this.liL.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.liW = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.liX != null) {
                    this.liX.callback(true);
                }
                this.liK.setVisibility(8);
                this.liO.setVisibility(8);
                this.liL.setVisibility(8);
                this.liP.setVisibility(0);
                this.liJ.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ap.setViewTextColor(this.liJ, R.color.cp_cont_f);
                ap.setBackgroundColor(this.liP, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bgj == 2) {
                    this.liJ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.liV) {
                        aF(pbFragment);
                        return;
                    }
                    return;
                }
                this.liJ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.liR = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.liR.aZ(inflate);
            this.liR.a((String) null, (a.b) null);
            this.liR.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.liU != null) {
                        PbInterviewStatusView.this.liU.cancel();
                    }
                    if (PbInterviewStatusView.this.liR != null) {
                        PbInterviewStatusView.this.liR.dismiss();
                    }
                }
            });
            this.liR.id(false);
            this.liR.b(pbFragment.getPageContext());
            e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.liR != null) {
                        PbInterviewStatusView.this.liR.bia();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.liU = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.liR != null) {
                        PbInterviewStatusView.this.liR.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dbB();
                    }
                }
            }.start();
        }
    }

    private Animation aG(PbFragment pbFragment) {
        if (this.liQ == null) {
            this.liQ = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.liQ.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.liQ.setInterpolator(new LinearInterpolator());
            this.liQ.setFillAfter(true);
        }
        return this.liQ;
    }

    public boolean getIndicateStatus() {
        return this.liW;
    }

    public void clearStatus() {
        if (this.liS != null) {
            this.liS.cancel();
            this.liS = null;
        }
        if (this.liT != null) {
            this.liT.cancel();
            this.liT = null;
        }
        if (this.liU != null) {
            this.liU.cancel();
            this.liU = null;
        }
        if (this.liR != null) {
            this.liR.dismiss();
            this.liR = null;
        }
    }
}
