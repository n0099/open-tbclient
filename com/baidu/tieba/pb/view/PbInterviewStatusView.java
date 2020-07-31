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
    private TextView kJU;
    private ImageView kJV;
    private FrameLayout kJW;
    private TextView kJX;
    private ImageView kJY;
    private ImageView kJZ;
    private View kKa;
    private Animation kKb;
    private com.baidu.tbadk.core.dialog.a kKc;
    private CountDownTimer kKd;
    private CountDownTimer kKe;
    private CountDownTimer kKf;
    private boolean kKg;
    private boolean kKh;
    private a kKi;
    private View mRootView;

    /* loaded from: classes16.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.kKi = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.kKc = null;
        this.kKd = null;
        this.kKe = null;
        this.kKf = null;
        this.kKg = true;
        this.kKh = false;
        this.dOV = null;
        this.kKi = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.kKc = null;
        this.kKd = null;
        this.kKe = null;
        this.kKf = null;
        this.kKg = true;
        this.kKh = false;
        this.dOV = null;
        this.kKi = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.kKc = null;
        this.kKd = null;
        this.kKe = null;
        this.kKf = null;
        this.kKg = true;
        this.kKh = false;
        this.dOV = null;
        this.kKi = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.kJU = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.kJW = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.kJV = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.kJZ = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.kJX = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.kJY = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.kKa = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ao.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.kJU, R.color.cp_cont_g);
        ao.setBackgroundResource(this.kJY, R.drawable.icon_interview_loding);
        ao.setViewTextColor(this.kJX, R.color.cp_cont_g);
        ao.setBackgroundResource(this.kJV, R.drawable.icon_interview_mic);
        ao.setBackgroundResource(this.kJZ, R.drawable.icon_arrow_tip_white);
        ao.setBackgroundColor(this.kKa, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.dOV = fVar.cKx().aVR().aVH();
        if (StringUtils.isNull(this.dOV)) {
            this.dOV = fVar.cKx().aVR().getTaskId();
        }
        this.kKg = !"from_interview_live".equals(pbFragment.cNk());
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
                    this.kKd = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.kKi != null) {
                        this.kKi.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ap("c11105").dn("obj_id", this.dOV));
                    this.mRootView.setVisibility(0);
                    if (this.kKi != null) {
                        this.kKi.callback(true);
                    }
                    this.kJU.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.kJU.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.kJV.setVisibility(8);
                    this.kJZ.setVisibility(8);
                    this.kKa.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.kJY, aF(pbFragment), null);
                    if (this.kKe != null) {
                        this.kKe.cancel();
                    }
                    this.kKe = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.kJX.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ap("c11106").dn("obj_id", PbInterviewStatusView.this.dOV));
                            PbInterviewStatusView.this.kKg = false;
                            PbInterviewStatusView.this.kJU.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.kJU.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.kJV.setVisibility(0);
                            PbInterviewStatusView.this.kKa.setVisibility(8);
                            PbInterviewStatusView.this.kJZ.setVisibility(0);
                            PbInterviewStatusView.this.kJW.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.kKh = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.kKi != null) {
                    this.kKi.callback(true);
                }
                this.kJV.setVisibility(8);
                this.kJZ.setVisibility(8);
                this.kJW.setVisibility(8);
                this.kKa.setVisibility(0);
                this.kJU.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ao.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ao.setViewTextColor(this.kJU, R.color.cp_cont_f);
                ao.setBackgroundColor(this.kKa, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aWW == 2) {
                    this.kJU.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.kKg) {
                        aE(pbFragment);
                        return;
                    }
                    return;
                }
                this.kJU.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.kKc = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.kKc.aV(inflate);
            this.kKc.a((String) null, (a.b) null);
            this.kKc.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.kKf != null) {
                        PbInterviewStatusView.this.kKf.cancel();
                    }
                    if (PbInterviewStatusView.this.kKc != null) {
                        PbInterviewStatusView.this.kKc.dismiss();
                    }
                }
            });
            this.kKc.hJ(false);
            this.kKc.b(pbFragment.getPageContext());
            e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.kKc != null) {
                        PbInterviewStatusView.this.kKc.aYL();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.kKf = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.kKc != null) {
                        PbInterviewStatusView.this.kKc.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cNj();
                    }
                }
            }.start();
        }
    }

    private Animation aF(PbFragment pbFragment) {
        if (this.kKb == null) {
            this.kKb = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.kKb.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.kKb.setInterpolator(new LinearInterpolator());
            this.kKb.setFillAfter(true);
        }
        return this.kKb;
    }

    public boolean getIndicateStatus() {
        return this.kKh;
    }

    public void clearStatus() {
        if (this.kKd != null) {
            this.kKd.cancel();
            this.kKd = null;
        }
        if (this.kKe != null) {
            this.kKe.cancel();
            this.kKe = null;
        }
        if (this.kKf != null) {
            this.kKf.cancel();
            this.kKf = null;
        }
        if (this.kKc != null) {
            this.kKc.dismiss();
            this.kKc = null;
        }
    }
}
