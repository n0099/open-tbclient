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
    private String dCp;
    private TextView kfZ;
    private ImageView kga;
    private FrameLayout kgb;
    private TextView kgc;
    private ImageView kgd;
    private ImageView kge;
    private View kgf;
    private Animation kgg;
    private com.baidu.tbadk.core.dialog.a kgh;
    private CountDownTimer kgi;
    private CountDownTimer kgj;
    private CountDownTimer kgk;
    private boolean kgl;
    private boolean kgm;
    private a kgn;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.kgn = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.kgh = null;
        this.kgi = null;
        this.kgj = null;
        this.kgk = null;
        this.kgl = true;
        this.kgm = false;
        this.dCp = null;
        this.kgn = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.kgh = null;
        this.kgi = null;
        this.kgj = null;
        this.kgk = null;
        this.kgl = true;
        this.kgm = false;
        this.dCp = null;
        this.kgn = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.kgh = null;
        this.kgi = null;
        this.kgj = null;
        this.kgk = null;
        this.kgl = true;
        this.kgm = false;
        this.dCp = null;
        this.kgn = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.kfZ = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.kgb = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.kga = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.kge = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.kgc = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.kgd = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.kgf = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.kfZ, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.kgd, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.kgc, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.kga, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.kge, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.kgf, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.dCp = eVar.cCi().aQd().aPU();
        if (StringUtils.isNull(this.dCp)) {
            this.dCp = eVar.cCi().aQd().getTaskId();
        }
        this.kgl = !"from_interview_live".equals(pbFragment.cET());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aRj = eVar.cCi().aRj();
        switch (aRj) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cCi().aQd().aPQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.kgi = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.kgn != null) {
                        this.kgn.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").dh("obj_id", this.dCp));
                    this.mRootView.setVisibility(0);
                    if (this.kgn != null) {
                        this.kgn.callback(true);
                    }
                    this.kfZ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.kfZ.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.kga.setVisibility(8);
                    this.kge.setVisibility(8);
                    this.kgf.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.kgd, aC(pbFragment), null);
                    if (this.kgj != null) {
                        this.kgj.cancel();
                    }
                    this.kgj = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.kgc.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").dh("obj_id", PbInterviewStatusView.this.dCp));
                            PbInterviewStatusView.this.kgl = false;
                            PbInterviewStatusView.this.kfZ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.kfZ.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.kga.setVisibility(0);
                            PbInterviewStatusView.this.kgf.setVisibility(8);
                            PbInterviewStatusView.this.kge.setVisibility(0);
                            PbInterviewStatusView.this.kgb.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.kgm = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.kgn != null) {
                    this.kgn.callback(true);
                }
                this.kga.setVisibility(8);
                this.kge.setVisibility(8);
                this.kgb.setVisibility(8);
                this.kgf.setVisibility(0);
                this.kfZ.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.kfZ, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.kgf, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aRj == 2) {
                    this.kfZ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.kgl) {
                        aB(pbFragment);
                        return;
                    }
                    return;
                }
                this.kfZ.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aB(final PbFragment pbFragment) {
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
            this.kgh = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.kgh.aP(inflate);
            this.kgh.a((String) null, (a.b) null);
            this.kgh.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.kgk != null) {
                        PbInterviewStatusView.this.kgk.cancel();
                    }
                    if (PbInterviewStatusView.this.kgh != null) {
                        PbInterviewStatusView.this.kgh.dismiss();
                    }
                }
            });
            this.kgh.gW(false);
            this.kgh.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.kgh != null) {
                        PbInterviewStatusView.this.kgh.aST();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.kgk = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.kgh != null) {
                        PbInterviewStatusView.this.kgh.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cES();
                    }
                }
            }.start();
        }
    }

    private Animation aC(PbFragment pbFragment) {
        if (this.kgg == null) {
            this.kgg = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.kgg.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.kgg.setInterpolator(new LinearInterpolator());
            this.kgg.setFillAfter(true);
        }
        return this.kgg;
    }

    public boolean getIndicateStatus() {
        return this.kgm;
    }

    public void clearStatus() {
        if (this.kgi != null) {
            this.kgi.cancel();
            this.kgi = null;
        }
        if (this.kgj != null) {
            this.kgj.cancel();
            this.kgj = null;
        }
        if (this.kgk != null) {
            this.kgk.cancel();
            this.kgk = null;
        }
        if (this.kgh != null) {
            this.kgh.dismiss();
            this.kgh = null;
        }
    }
}
