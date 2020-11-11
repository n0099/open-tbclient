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
    private String eAX;
    private View lQA;
    private Animation lQB;
    private com.baidu.tbadk.core.dialog.a lQC;
    private CountDownTimer lQD;
    private CountDownTimer lQE;
    private CountDownTimer lQF;
    private boolean lQG;
    private boolean lQH;
    private a lQI;
    private TextView lQu;
    private ImageView lQv;
    private FrameLayout lQw;
    private TextView lQx;
    private ImageView lQy;
    private ImageView lQz;
    private View mRootView;

    /* loaded from: classes22.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.lQI = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.lQC = null;
        this.lQD = null;
        this.lQE = null;
        this.lQF = null;
        this.lQG = true;
        this.lQH = false;
        this.eAX = null;
        this.lQI = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.lQC = null;
        this.lQD = null;
        this.lQE = null;
        this.lQF = null;
        this.lQG = true;
        this.lQH = false;
        this.eAX = null;
        this.lQI = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.lQC = null;
        this.lQD = null;
        this.lQE = null;
        this.lQF = null;
        this.lQG = true;
        this.lQH = false;
        this.eAX = null;
        this.lQI = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.lQu = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.lQw = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.lQv = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.lQz = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.lQx = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.lQy = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.lQA = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.lQu, R.color.cp_cont_g);
        ap.setBackgroundResource(this.lQy, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.lQx, R.color.cp_cont_g);
        ap.setBackgroundResource(this.lQv, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.lQz, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.lQA, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eAX = fVar.dik().bmg().blW();
        if (StringUtils.isNull(this.eAX)) {
            this.eAX = fVar.dik().bmg().getTaskId();
        }
        this.lQG = !"from_interview_live".equals(pbFragment.dkU());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bnl = fVar.dik().bnl();
        switch (bnl) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dik().bmg().blS()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.lQD = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.lQI != null) {
                        this.lQI.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dR("obj_id", this.eAX));
                    this.mRootView.setVisibility(0);
                    if (this.lQI != null) {
                        this.lQI.callback(true);
                    }
                    this.lQu.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.lQu.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.lQv.setVisibility(8);
                    this.lQz.setVisibility(8);
                    this.lQA.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.lQy, aG(pbFragment), null);
                    if (this.lQE != null) {
                        this.lQE.cancel();
                    }
                    this.lQE = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.lQx.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dR("obj_id", PbInterviewStatusView.this.eAX));
                            PbInterviewStatusView.this.lQG = false;
                            PbInterviewStatusView.this.lQu.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.lQu.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.lQv.setVisibility(0);
                            PbInterviewStatusView.this.lQA.setVisibility(8);
                            PbInterviewStatusView.this.lQz.setVisibility(0);
                            PbInterviewStatusView.this.lQw.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.lQH = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.lQI != null) {
                    this.lQI.callback(true);
                }
                this.lQv.setVisibility(8);
                this.lQz.setVisibility(8);
                this.lQw.setVisibility(8);
                this.lQA.setVisibility(0);
                this.lQu.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ap.setViewTextColor(this.lQu, R.color.cp_cont_f);
                ap.setBackgroundColor(this.lQA, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bnl == 2) {
                    this.lQu.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.lQG) {
                        aF(pbFragment);
                        return;
                    }
                    return;
                }
                this.lQu.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.lQC = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.lQC.bf(inflate);
            this.lQC.a((String) null, (a.b) null);
            this.lQC.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.lQF != null) {
                        PbInterviewStatusView.this.lQF.cancel();
                    }
                    if (PbInterviewStatusView.this.lQC != null) {
                        PbInterviewStatusView.this.lQC.dismiss();
                    }
                }
            });
            this.lQC.iV(false);
            this.lQC.b(pbFragment.getPageContext());
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.lQC != null) {
                        PbInterviewStatusView.this.lQC.bpc();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.lQF = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.lQC != null) {
                        PbInterviewStatusView.this.lQC.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dkT();
                    }
                }
            }.start();
        }
    }

    private Animation aG(PbFragment pbFragment) {
        if (this.lQB == null) {
            this.lQB = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.lQB.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.lQB.setInterpolator(new LinearInterpolator());
            this.lQB.setFillAfter(true);
        }
        return this.lQB;
    }

    public boolean getIndicateStatus() {
        return this.lQH;
    }

    public void clearStatus() {
        if (this.lQD != null) {
            this.lQD.cancel();
            this.lQD = null;
        }
        if (this.lQE != null) {
            this.lQE.cancel();
            this.lQE = null;
        }
        if (this.lQF != null) {
            this.lQF.cancel();
            this.lQF = null;
        }
        if (this.lQC != null) {
            this.lQC.dismiss();
            this.lQC = null;
        }
    }
}
