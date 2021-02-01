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
    private String eNE;
    private View mRootView;
    private FrameLayout moA;
    private TextView moB;
    private ImageView moC;
    private ImageView moD;
    private View moE;
    private Animation moF;
    private com.baidu.tbadk.core.dialog.a moG;
    private CountDownTimer moH;
    private CountDownTimer moI;
    private CountDownTimer moJ;
    private boolean moK;
    private boolean moL;
    private a moM;
    private TextView moy;
    private ImageView moz;

    /* loaded from: classes2.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.moM = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.moG = null;
        this.moH = null;
        this.moI = null;
        this.moJ = null;
        this.moK = true;
        this.moL = false;
        this.eNE = null;
        this.moM = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.moG = null;
        this.moH = null;
        this.moI = null;
        this.moJ = null;
        this.moK = true;
        this.moL = false;
        this.eNE = null;
        this.moM = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.moG = null;
        this.moH = null;
        this.moI = null;
        this.moJ = null;
        this.moK = true;
        this.moL = false;
        this.eNE = null;
        this.moM = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.moy = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.moA = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.moz = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.moD = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.moB = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.moC = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.moE = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ap.setViewTextColor(this.moy, R.color.CAM_X0111);
        ap.setBackgroundResource(this.moC, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.moB, R.color.CAM_X0111);
        ap.setBackgroundResource(this.moz, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.moD, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.moE, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eNE = fVar.dkZ().bnw().bnm();
        if (StringUtils.isNull(this.eNE)) {
            this.eNE = fVar.dkZ().bnw().getTaskId();
        }
        this.moK = !"from_interview_live".equals(pbFragment.dnQ());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int boA = fVar.dkZ().boA();
        switch (boA) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dkZ().bnw().bni()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.moH = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.moM != null) {
                        this.moM.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").dR("obj_id", this.eNE));
                    this.mRootView.setVisibility(0);
                    if (this.moM != null) {
                        this.moM.callback(true);
                    }
                    this.moy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.moy.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.moz.setVisibility(8);
                    this.moD.setVisibility(8);
                    this.moE.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.moC, aD(pbFragment), null);
                    if (this.moI != null) {
                        this.moI.cancel();
                    }
                    this.moI = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.moB.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ar("c11106").dR("obj_id", PbInterviewStatusView.this.eNE));
                            PbInterviewStatusView.this.moK = false;
                            PbInterviewStatusView.this.moy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.moy.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.moz.setVisibility(0);
                            PbInterviewStatusView.this.moE.setVisibility(8);
                            PbInterviewStatusView.this.moD.setVisibility(0);
                            PbInterviewStatusView.this.moA.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.moL = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.moM != null) {
                    this.moM.callback(true);
                }
                this.moz.setVisibility(8);
                this.moD.setVisibility(8);
                this.moA.setVisibility(8);
                this.moE.setVisibility(0);
                this.moy.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ap.setViewTextColor(this.moy, R.color.CAM_X0106);
                ap.setBackgroundColor(this.moE, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (boA == 2) {
                    this.moy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.moK) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.moy.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.moG = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.moG.bn(inflate);
            this.moG.a((String) null, (a.b) null);
            this.moG.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.moJ != null) {
                        PbInterviewStatusView.this.moJ.cancel();
                    }
                    if (PbInterviewStatusView.this.moG != null) {
                        PbInterviewStatusView.this.moG.dismiss();
                    }
                }
            });
            this.moG.jF(false);
            this.moG.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.moG != null) {
                        PbInterviewStatusView.this.moG.bqx();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.moJ = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.moG != null) {
                        PbInterviewStatusView.this.moG.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dnP();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.moF == null) {
            this.moF = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.moF.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.moF.setInterpolator(new LinearInterpolator());
            this.moF.setFillAfter(true);
        }
        return this.moF;
    }

    public boolean getIndicateStatus() {
        return this.moL;
    }

    public void clearStatus() {
        if (this.moH != null) {
            this.moH.cancel();
            this.moH = null;
        }
        if (this.moI != null) {
            this.moI.cancel();
            this.moI = null;
        }
        if (this.moJ != null) {
            this.moJ.cancel();
            this.moJ = null;
        }
        if (this.moG != null) {
            this.moG.dismiss();
            this.moG = null;
        }
    }
}
