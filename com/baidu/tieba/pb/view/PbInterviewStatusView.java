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
/* loaded from: classes16.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String dYs;
    private TextView kZR;
    private ImageView kZS;
    private FrameLayout kZT;
    private TextView kZU;
    private ImageView kZV;
    private ImageView kZW;
    private View kZX;
    private Animation kZY;
    private com.baidu.tbadk.core.dialog.a kZZ;
    private CountDownTimer laa;
    private CountDownTimer lab;
    private CountDownTimer lac;
    private boolean lad;
    private boolean lae;
    private a laf;
    private View mRootView;

    /* loaded from: classes16.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.laf = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.kZZ = null;
        this.laa = null;
        this.lab = null;
        this.lac = null;
        this.lad = true;
        this.lae = false;
        this.dYs = null;
        this.laf = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.kZZ = null;
        this.laa = null;
        this.lab = null;
        this.lac = null;
        this.lad = true;
        this.lae = false;
        this.dYs = null;
        this.laf = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.kZZ = null;
        this.laa = null;
        this.lab = null;
        this.lac = null;
        this.lad = true;
        this.lae = false;
        this.dYs = null;
        this.laf = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.kZR = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.kZT = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.kZS = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.kZW = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.kZU = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.kZV = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.kZX = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.kZR, R.color.cp_cont_g);
        ap.setBackgroundResource(this.kZV, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.kZU, R.color.cp_cont_g);
        ap.setBackgroundResource(this.kZS, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.kZW, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.kZX, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.dYs = fVar.cVm().bek().bea();
        if (StringUtils.isNull(this.dYs)) {
            this.dYs = fVar.cVm().bek().getTaskId();
        }
        this.lad = !"from_interview_live".equals(pbFragment.cXZ());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bfp = fVar.cVm().bfp();
        switch (bfp) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.cVm().bek().bdW()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.laa = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.laf != null) {
                        this.laf.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dD("obj_id", this.dYs));
                    this.mRootView.setVisibility(0);
                    if (this.laf != null) {
                        this.laf.callback(true);
                    }
                    this.kZR.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.kZR.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.kZS.setVisibility(8);
                    this.kZW.setVisibility(8);
                    this.kZX.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.kZV, aF(pbFragment), null);
                    if (this.lab != null) {
                        this.lab.cancel();
                    }
                    this.lab = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.kZU.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dD("obj_id", PbInterviewStatusView.this.dYs));
                            PbInterviewStatusView.this.lad = false;
                            PbInterviewStatusView.this.kZR.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.kZR.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.kZS.setVisibility(0);
                            PbInterviewStatusView.this.kZX.setVisibility(8);
                            PbInterviewStatusView.this.kZW.setVisibility(0);
                            PbInterviewStatusView.this.kZT.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.lae = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.laf != null) {
                    this.laf.callback(true);
                }
                this.kZS.setVisibility(8);
                this.kZW.setVisibility(8);
                this.kZT.setVisibility(8);
                this.kZX.setVisibility(0);
                this.kZR.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ap.setViewTextColor(this.kZR, R.color.cp_cont_f);
                ap.setBackgroundColor(this.kZX, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bfp == 2) {
                    this.kZR.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.lad) {
                        aE(pbFragment);
                        return;
                    }
                    return;
                }
                this.kZR.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aE(final PbFragment pbFragment) {
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
            this.kZZ = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.kZZ.aX(inflate);
            this.kZZ.a((String) null, (a.b) null);
            this.kZZ.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.lac != null) {
                        PbInterviewStatusView.this.lac.cancel();
                    }
                    if (PbInterviewStatusView.this.kZZ != null) {
                        PbInterviewStatusView.this.kZZ.dismiss();
                    }
                }
            });
            this.kZZ.ig(false);
            this.kZZ.b(pbFragment.getPageContext());
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.kZZ != null) {
                        PbInterviewStatusView.this.kZZ.bhg();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.lac = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.kZZ != null) {
                        PbInterviewStatusView.this.kZZ.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cXY();
                    }
                }
            }.start();
        }
    }

    private Animation aF(PbFragment pbFragment) {
        if (this.kZY == null) {
            this.kZY = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.kZY.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.kZY.setInterpolator(new LinearInterpolator());
            this.kZY.setFillAfter(true);
        }
        return this.kZY;
    }

    public boolean getIndicateStatus() {
        return this.lae;
    }

    public void clearStatus() {
        if (this.laa != null) {
            this.laa.cancel();
            this.laa = null;
        }
        if (this.lab != null) {
            this.lab.cancel();
            this.lab = null;
        }
        if (this.lac != null) {
            this.lac.cancel();
            this.lac = null;
        }
        if (this.kZZ != null) {
            this.kZZ.dismiss();
            this.kZZ = null;
        }
    }
}
