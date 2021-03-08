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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String ePf;
    private View mRootView;
    private TextView mqP;
    private ImageView mqQ;
    private FrameLayout mqR;
    private TextView mqS;
    private ImageView mqT;
    private ImageView mqU;
    private View mqV;
    private Animation mqW;
    private com.baidu.tbadk.core.dialog.a mqX;
    private CountDownTimer mqY;
    private CountDownTimer mqZ;
    private CountDownTimer mra;
    private boolean mrb;
    private boolean mrc;
    private a mrd;

    /* loaded from: classes2.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mrd = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.mqX = null;
        this.mqY = null;
        this.mqZ = null;
        this.mra = null;
        this.mrb = true;
        this.mrc = false;
        this.ePf = null;
        this.mrd = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.mqX = null;
        this.mqY = null;
        this.mqZ = null;
        this.mra = null;
        this.mrb = true;
        this.mrc = false;
        this.ePf = null;
        this.mrd = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.mqX = null;
        this.mqY = null;
        this.mqZ = null;
        this.mra = null;
        this.mrb = true;
        this.mrc = false;
        this.ePf = null;
        this.mrd = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.mqP = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.mqR = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.mqQ = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.mqU = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.mqS = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.mqT = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.mqV = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ap.setViewTextColor(this.mqP, R.color.CAM_X0111);
        ap.setBackgroundResource(this.mqT, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.mqS, R.color.CAM_X0111);
        ap.setBackgroundResource(this.mqQ, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.mqU, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.mqV, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.ePf = fVar.dlp().bny().bno();
        if (StringUtils.isNull(this.ePf)) {
            this.ePf = fVar.dlp().bny().getTaskId();
        }
        this.mrb = !"from_interview_live".equals(pbFragment.dog());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int boC = fVar.dlp().boC();
        switch (boC) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dlp().bny().bnk()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.mqY = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mrd != null) {
                        this.mrd.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").dR("obj_id", this.ePf));
                    this.mRootView.setVisibility(0);
                    if (this.mrd != null) {
                        this.mrd.callback(true);
                    }
                    this.mqP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.mqP.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.mqQ.setVisibility(8);
                    this.mqU.setVisibility(8);
                    this.mqV.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.mqT, aD(pbFragment), null);
                    if (this.mqZ != null) {
                        this.mqZ.cancel();
                    }
                    this.mqZ = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.mqS.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ar("c11106").dR("obj_id", PbInterviewStatusView.this.ePf));
                            PbInterviewStatusView.this.mrb = false;
                            PbInterviewStatusView.this.mqP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.mqP.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.mqQ.setVisibility(0);
                            PbInterviewStatusView.this.mqV.setVisibility(8);
                            PbInterviewStatusView.this.mqU.setVisibility(0);
                            PbInterviewStatusView.this.mqR.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mrc = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mrd != null) {
                    this.mrd.callback(true);
                }
                this.mqQ.setVisibility(8);
                this.mqU.setVisibility(8);
                this.mqR.setVisibility(8);
                this.mqV.setVisibility(0);
                this.mqP.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ap.setViewTextColor(this.mqP, R.color.CAM_X0106);
                ap.setBackgroundColor(this.mqV, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (boC == 2) {
                    this.mqP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.mrb) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.mqP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aC(final PbFragment pbFragment) {
        if (MessageManager.getInstance().findTask(1003200) != null) {
            View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            ap.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.CAM_X0105);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.CAM_X0105);
            ap.setBackgroundColor(findViewById, R.color.CAM_X0204);
            ap.setBackgroundColor(findViewById2, R.color.CAM_X0204);
            ap.setViewTextColor(textView, R.color.CAM_X0106);
            this.mqX = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.mqX.bn(inflate);
            this.mqX.a((String) null, (a.b) null);
            this.mqX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.mra != null) {
                        PbInterviewStatusView.this.mra.cancel();
                    }
                    if (PbInterviewStatusView.this.mqX != null) {
                        PbInterviewStatusView.this.mqX.dismiss();
                    }
                }
            });
            this.mqX.jF(false);
            this.mqX.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.mqX != null) {
                        PbInterviewStatusView.this.mqX.bqz();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.mra = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.mqX != null) {
                        PbInterviewStatusView.this.mqX.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dof();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.mqW == null) {
            this.mqW = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.mqW.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.mqW.setInterpolator(new LinearInterpolator());
            this.mqW.setFillAfter(true);
        }
        return this.mqW;
    }

    public boolean getIndicateStatus() {
        return this.mrc;
    }

    public void clearStatus() {
        if (this.mqY != null) {
            this.mqY.cancel();
            this.mqY = null;
        }
        if (this.mqZ != null) {
            this.mqZ.cancel();
            this.mqZ = null;
        }
        if (this.mra != null) {
            this.mra.cancel();
            this.mra = null;
        }
        if (this.mqX != null) {
            this.mqX.dismiss();
            this.mqX = null;
        }
    }
}
