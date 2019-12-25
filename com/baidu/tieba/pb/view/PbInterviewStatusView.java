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
/* loaded from: classes6.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String cKC;
    private TextView iXa;
    private ImageView iXb;
    private FrameLayout iXc;
    private TextView iXd;
    private ImageView iXe;
    private ImageView iXf;
    private View iXg;
    private Animation iXh;
    private com.baidu.tbadk.core.dialog.a iXi;
    private CountDownTimer iXj;
    private CountDownTimer iXk;
    private CountDownTimer iXl;
    private boolean iXm;
    private boolean iXn;
    private a iXo;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.iXo = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.iXi = null;
        this.iXj = null;
        this.iXk = null;
        this.iXl = null;
        this.iXm = true;
        this.iXn = false;
        this.cKC = null;
        this.iXo = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.iXi = null;
        this.iXj = null;
        this.iXk = null;
        this.iXl = null;
        this.iXm = true;
        this.iXn = false;
        this.cKC = null;
        this.iXo = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.iXi = null;
        this.iXj = null;
        this.iXk = null;
        this.iXl = null;
        this.iXm = true;
        this.iXn = false;
        this.cKC = null;
        this.iXo = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.iXa = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.iXc = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.iXb = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.iXf = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.iXd = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.iXe = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.iXg = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.iXa, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.iXe, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.iXd, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.iXb, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.iXf, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.iXg, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.cKC = fVar.chK().azj().aza();
        if (StringUtils.isNull(this.cKC)) {
            this.cKC = fVar.chK().azj().getTaskId();
        }
        this.iXm = !"from_interview_live".equals(pbFragment.ckv());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int aAm = fVar.chK().aAm();
        switch (aAm) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.chK().azj().ayW()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.iXj = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.iXo != null) {
                        this.iXo.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cp("obj_id", this.cKC));
                    this.mRootView.setVisibility(0);
                    if (this.iXo != null) {
                        this.iXo.callback(true);
                    }
                    this.iXa.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.iXa.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.iXb.setVisibility(8);
                    this.iXf.setVisibility(8);
                    this.iXg.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.iXe, aD(pbFragment), null);
                    if (this.iXk != null) {
                        this.iXk.cancel();
                    }
                    this.iXk = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.iXd.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cp("obj_id", PbInterviewStatusView.this.cKC));
                            PbInterviewStatusView.this.iXm = false;
                            PbInterviewStatusView.this.iXa.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.iXa.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.iXb.setVisibility(0);
                            PbInterviewStatusView.this.iXg.setVisibility(8);
                            PbInterviewStatusView.this.iXf.setVisibility(0);
                            PbInterviewStatusView.this.iXc.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.iXn = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.iXo != null) {
                    this.iXo.callback(true);
                }
                this.iXb.setVisibility(8);
                this.iXf.setVisibility(8);
                this.iXc.setVisibility(8);
                this.iXg.setVisibility(0);
                this.iXa.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.iXa, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.iXg, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aAm == 2) {
                    this.iXa.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.iXm) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.iXa.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.iXi = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.iXi.aK(inflate);
            this.iXi.a((String) null, (a.b) null);
            this.iXi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.iXl != null) {
                        PbInterviewStatusView.this.iXl.cancel();
                    }
                    if (PbInterviewStatusView.this.iXi != null) {
                        PbInterviewStatusView.this.iXi.dismiss();
                    }
                }
            });
            this.iXi.fu(false);
            this.iXi.b(pbFragment.getPageContext());
            e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.iXi != null) {
                        PbInterviewStatusView.this.iXi.aBW();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.iXl = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.iXi != null) {
                        PbInterviewStatusView.this.iXi.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cku();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.iXh == null) {
            this.iXh = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.iXh.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.iXh.setInterpolator(new LinearInterpolator());
            this.iXh.setFillAfter(true);
        }
        return this.iXh;
    }

    public boolean getIndicateStatus() {
        return this.iXn;
    }

    public void clearStatus() {
        if (this.iXj != null) {
            this.iXj.cancel();
            this.iXj = null;
        }
        if (this.iXk != null) {
            this.iXk.cancel();
            this.iXk = null;
        }
        if (this.iXl != null) {
            this.iXl.cancel();
            this.iXl = null;
        }
        if (this.iXi != null) {
            this.iXi.dismiss();
            this.iXi = null;
        }
    }
}
