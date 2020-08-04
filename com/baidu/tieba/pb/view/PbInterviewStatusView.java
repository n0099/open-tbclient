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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes16.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String dOV;
    private TextView kJW;
    private ImageView kJX;
    private FrameLayout kJY;
    private TextView kJZ;
    private ImageView kKa;
    private ImageView kKb;
    private View kKc;
    private Animation kKd;
    private com.baidu.tbadk.core.dialog.a kKe;
    private CountDownTimer kKf;
    private CountDownTimer kKg;
    private CountDownTimer kKh;
    private boolean kKi;
    private boolean kKj;
    private a kKk;
    private View mRootView;

    /* loaded from: classes16.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.kKk = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.kKe = null;
        this.kKf = null;
        this.kKg = null;
        this.kKh = null;
        this.kKi = true;
        this.kKj = false;
        this.dOV = null;
        this.kKk = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.kKe = null;
        this.kKf = null;
        this.kKg = null;
        this.kKh = null;
        this.kKi = true;
        this.kKj = false;
        this.dOV = null;
        this.kKk = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.kKe = null;
        this.kKf = null;
        this.kKg = null;
        this.kKh = null;
        this.kKi = true;
        this.kKj = false;
        this.dOV = null;
        this.kKk = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.kJW = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.kJY = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.kJX = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.kKb = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.kJZ = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.kKa = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.kKc = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ao.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.kJW, R.color.cp_cont_g);
        ao.setBackgroundResource(this.kKa, R.drawable.icon_interview_loding);
        ao.setViewTextColor(this.kJZ, R.color.cp_cont_g);
        ao.setBackgroundResource(this.kJX, R.drawable.icon_interview_mic);
        ao.setBackgroundResource(this.kKb, R.drawable.icon_arrow_tip_white);
        ao.setBackgroundColor(this.kKc, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.dOV = fVar.cKx().aVR().aVH();
        if (StringUtils.isNull(this.dOV)) {
            this.dOV = fVar.cKx().aVR().getTaskId();
        }
        this.kKi = !"from_interview_live".equals(pbFragment.cNk());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int aWW = fVar.cKx().aWW();
        switch (aWW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.cKx().aVR().aVD()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.kKf = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.kKk != null) {
                        this.kKk.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ap("c11105").dn("obj_id", this.dOV));
                    this.mRootView.setVisibility(0);
                    if (this.kKk != null) {
                        this.kKk.callback(true);
                    }
                    this.kJW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.kJW.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.kJX.setVisibility(8);
                    this.kKb.setVisibility(8);
                    this.kKc.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.kKa, aF(pbFragment), null);
                    if (this.kKg != null) {
                        this.kKg.cancel();
                    }
                    this.kKg = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.kJZ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ap("c11106").dn("obj_id", PbInterviewStatusView.this.dOV));
                            PbInterviewStatusView.this.kKi = false;
                            PbInterviewStatusView.this.kJW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.kJW.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.kJX.setVisibility(0);
                            PbInterviewStatusView.this.kKc.setVisibility(8);
                            PbInterviewStatusView.this.kKb.setVisibility(0);
                            PbInterviewStatusView.this.kJY.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.kKj = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.kKk != null) {
                    this.kKk.callback(true);
                }
                this.kJX.setVisibility(8);
                this.kKb.setVisibility(8);
                this.kJY.setVisibility(8);
                this.kKc.setVisibility(0);
                this.kJW.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ao.setViewTextColor(this.kJW, R.color.cp_cont_f);
                ao.setBackgroundColor(this.kKc, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aWW == 2) {
                    this.kJW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.kKi) {
                        aE(pbFragment);
                        return;
                    }
                    return;
                }
                this.kJW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            ao.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.cp_cont_b);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.cp_cont_b);
            ao.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            ao.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            ao.setViewTextColor(textView, R.color.cp_cont_f);
            this.kKe = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.kKe.aV(inflate);
            this.kKe.a((String) null, (a.b) null);
            this.kKe.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.kKh != null) {
                        PbInterviewStatusView.this.kKh.cancel();
                    }
                    if (PbInterviewStatusView.this.kKe != null) {
                        PbInterviewStatusView.this.kKe.dismiss();
                    }
                }
            });
            this.kKe.hJ(false);
            this.kKe.b(pbFragment.getPageContext());
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.kKe != null) {
                        PbInterviewStatusView.this.kKe.aYL();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.kKh = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.kKe != null) {
                        PbInterviewStatusView.this.kKe.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cNj();
                    }
                }
            }.start();
        }
    }

    private Animation aF(PbFragment pbFragment) {
        if (this.kKd == null) {
            this.kKd = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.kKd.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.kKd.setInterpolator(new LinearInterpolator());
            this.kKd.setFillAfter(true);
        }
        return this.kKd;
    }

    public boolean getIndicateStatus() {
        return this.kKj;
    }

    public void clearStatus() {
        if (this.kKf != null) {
            this.kKf.cancel();
            this.kKf = null;
        }
        if (this.kKg != null) {
            this.kKg.cancel();
            this.kKg = null;
        }
        if (this.kKh != null) {
            this.kKh.cancel();
            this.kKh = null;
        }
        if (this.kKe != null) {
            this.kKe.dismiss();
            this.kKe = null;
        }
    }
}
