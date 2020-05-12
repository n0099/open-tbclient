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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String dop;
    private TextView jOh;
    private ImageView jOi;
    private FrameLayout jOj;
    private TextView jOk;
    private ImageView jOl;
    private ImageView jOm;
    private View jOn;
    private Animation jOo;
    private com.baidu.tbadk.core.dialog.a jOp;
    private CountDownTimer jOq;
    private CountDownTimer jOr;
    private CountDownTimer jOs;
    private boolean jOt;
    private boolean jOu;
    private a jOv;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jOv = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jOp = null;
        this.jOq = null;
        this.jOr = null;
        this.jOs = null;
        this.jOt = true;
        this.jOu = false;
        this.dop = null;
        this.jOv = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jOp = null;
        this.jOq = null;
        this.jOr = null;
        this.jOs = null;
        this.jOt = true;
        this.jOu = false;
        this.dop = null;
        this.jOv = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jOp = null;
        this.jOq = null;
        this.jOr = null;
        this.jOs = null;
        this.jOt = true;
        this.jOu = false;
        this.dop = null;
        this.jOv = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jOh = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jOj = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jOi = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jOm = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jOk = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jOl = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jOn = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jOh, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jOl, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jOk, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jOi, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jOm, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jOn, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.dop = eVar.cvs().aKi().aJZ();
        if (StringUtils.isNull(this.dop)) {
            this.dop = eVar.cvs().aKi().getTaskId();
        }
        this.jOt = !"from_interview_live".equals(pbFragment.cxZ());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aLk = eVar.cvs().aLk();
        switch (aLk) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cvs().aKi().aJV()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jOq = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jOv != null) {
                        this.jOv.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cI("obj_id", this.dop));
                    this.mRootView.setVisibility(0);
                    if (this.jOv != null) {
                        this.jOv.callback(true);
                    }
                    this.jOh.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jOh.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jOi.setVisibility(8);
                    this.jOm.setVisibility(8);
                    this.jOn.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jOl, aD(pbFragment), null);
                    if (this.jOr != null) {
                        this.jOr.cancel();
                    }
                    this.jOr = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jOk.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cI("obj_id", PbInterviewStatusView.this.dop));
                            PbInterviewStatusView.this.jOt = false;
                            PbInterviewStatusView.this.jOh.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jOh.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jOi.setVisibility(0);
                            PbInterviewStatusView.this.jOn.setVisibility(8);
                            PbInterviewStatusView.this.jOm.setVisibility(0);
                            PbInterviewStatusView.this.jOj.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jOu = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jOv != null) {
                    this.jOv.callback(true);
                }
                this.jOi.setVisibility(8);
                this.jOm.setVisibility(8);
                this.jOj.setVisibility(8);
                this.jOn.setVisibility(0);
                this.jOh.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jOh, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jOn, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aLk == 2) {
                    this.jOh.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jOt) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jOh.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.jOp = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jOp.aP(inflate);
            this.jOp.a((String) null, (a.b) null);
            this.jOp.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jOs != null) {
                        PbInterviewStatusView.this.jOs.cancel();
                    }
                    if (PbInterviewStatusView.this.jOp != null) {
                        PbInterviewStatusView.this.jOp.dismiss();
                    }
                }
            });
            this.jOp.gE(false);
            this.jOp.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jOp != null) {
                        PbInterviewStatusView.this.jOp.aMS();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jOs = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jOp != null) {
                        PbInterviewStatusView.this.jOp.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cxY();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jOo == null) {
            this.jOo = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jOo.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jOo.setInterpolator(new LinearInterpolator());
            this.jOo.setFillAfter(true);
        }
        return this.jOo;
    }

    public boolean getIndicateStatus() {
        return this.jOu;
    }

    public void clearStatus() {
        if (this.jOq != null) {
            this.jOq.cancel();
            this.jOq = null;
        }
        if (this.jOr != null) {
            this.jOr.cancel();
            this.jOr = null;
        }
        if (this.jOs != null) {
            this.jOs.cancel();
            this.jOs = null;
        }
        if (this.jOp != null) {
            this.jOp.dismiss();
            this.jOp = null;
        }
    }
}
