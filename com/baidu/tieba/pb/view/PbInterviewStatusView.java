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
    private String dol;
    private TextView jOd;
    private ImageView jOe;
    private FrameLayout jOf;
    private TextView jOg;
    private ImageView jOh;
    private ImageView jOi;
    private View jOj;
    private Animation jOk;
    private com.baidu.tbadk.core.dialog.a jOl;
    private CountDownTimer jOm;
    private CountDownTimer jOn;
    private CountDownTimer jOo;
    private boolean jOp;
    private boolean jOq;
    private a jOr;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jOr = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jOl = null;
        this.jOm = null;
        this.jOn = null;
        this.jOo = null;
        this.jOp = true;
        this.jOq = false;
        this.dol = null;
        this.jOr = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jOl = null;
        this.jOm = null;
        this.jOn = null;
        this.jOo = null;
        this.jOp = true;
        this.jOq = false;
        this.dol = null;
        this.jOr = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jOl = null;
        this.jOm = null;
        this.jOn = null;
        this.jOo = null;
        this.jOp = true;
        this.jOq = false;
        this.dol = null;
        this.jOr = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jOd = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jOf = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jOe = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jOi = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jOg = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jOh = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jOj = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jOd, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jOh, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jOg, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jOe, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jOi, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jOj, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.dol = eVar.cvu().aKk().aKb();
        if (StringUtils.isNull(this.dol)) {
            this.dol = eVar.cvu().aKk().getTaskId();
        }
        this.jOp = !"from_interview_live".equals(pbFragment.cyb());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aLm = eVar.cvu().aLm();
        switch (aLm) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cvu().aKk().aJX()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jOm = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jOr != null) {
                        this.jOr.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cI("obj_id", this.dol));
                    this.mRootView.setVisibility(0);
                    if (this.jOr != null) {
                        this.jOr.callback(true);
                    }
                    this.jOd.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jOd.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jOe.setVisibility(8);
                    this.jOi.setVisibility(8);
                    this.jOj.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jOh, aD(pbFragment), null);
                    if (this.jOn != null) {
                        this.jOn.cancel();
                    }
                    this.jOn = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jOg.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cI("obj_id", PbInterviewStatusView.this.dol));
                            PbInterviewStatusView.this.jOp = false;
                            PbInterviewStatusView.this.jOd.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jOd.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jOe.setVisibility(0);
                            PbInterviewStatusView.this.jOj.setVisibility(8);
                            PbInterviewStatusView.this.jOi.setVisibility(0);
                            PbInterviewStatusView.this.jOf.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jOq = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jOr != null) {
                    this.jOr.callback(true);
                }
                this.jOe.setVisibility(8);
                this.jOi.setVisibility(8);
                this.jOf.setVisibility(8);
                this.jOj.setVisibility(0);
                this.jOd.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jOd, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jOj, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aLm == 2) {
                    this.jOd.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jOp) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jOd.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.jOl = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jOl.aP(inflate);
            this.jOl.a((String) null, (a.b) null);
            this.jOl.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jOo != null) {
                        PbInterviewStatusView.this.jOo.cancel();
                    }
                    if (PbInterviewStatusView.this.jOl != null) {
                        PbInterviewStatusView.this.jOl.dismiss();
                    }
                }
            });
            this.jOl.gE(false);
            this.jOl.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jOl != null) {
                        PbInterviewStatusView.this.jOl.aMU();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jOo = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jOl != null) {
                        PbInterviewStatusView.this.jOl.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cya();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jOk == null) {
            this.jOk = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jOk.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jOk.setInterpolator(new LinearInterpolator());
            this.jOk.setFillAfter(true);
        }
        return this.jOk;
    }

    public boolean getIndicateStatus() {
        return this.jOq;
    }

    public void clearStatus() {
        if (this.jOm != null) {
            this.jOm.cancel();
            this.jOm = null;
        }
        if (this.jOn != null) {
            this.jOn.cancel();
            this.jOn = null;
        }
        if (this.jOo != null) {
            this.jOo.cancel();
            this.jOo = null;
        }
        if (this.jOl != null) {
            this.jOl.dismiss();
            this.jOl = null;
        }
    }
}
