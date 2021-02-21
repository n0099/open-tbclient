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
    private TextView moN;
    private ImageView moO;
    private FrameLayout moP;
    private TextView moQ;
    private ImageView moR;
    private ImageView moS;
    private View moT;
    private Animation moU;
    private com.baidu.tbadk.core.dialog.a moV;
    private CountDownTimer moW;
    private CountDownTimer moX;
    private CountDownTimer moY;
    private boolean moZ;
    private boolean mpa;
    private a mpb;

    /* loaded from: classes2.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mpb = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.moV = null;
        this.moW = null;
        this.moX = null;
        this.moY = null;
        this.moZ = true;
        this.mpa = false;
        this.eNE = null;
        this.mpb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.moV = null;
        this.moW = null;
        this.moX = null;
        this.moY = null;
        this.moZ = true;
        this.mpa = false;
        this.eNE = null;
        this.mpb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.moV = null;
        this.moW = null;
        this.moX = null;
        this.moY = null;
        this.moZ = true;
        this.mpa = false;
        this.eNE = null;
        this.mpb = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.moN = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.moP = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.moO = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.moS = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.moQ = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.moR = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.moT = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ap.setViewTextColor(this.moN, R.color.CAM_X0111);
        ap.setBackgroundResource(this.moR, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.moQ, R.color.CAM_X0111);
        ap.setBackgroundResource(this.moO, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.moS, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.moT, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eNE = fVar.dlg().bnw().bnm();
        if (StringUtils.isNull(this.eNE)) {
            this.eNE = fVar.dlg().bnw().getTaskId();
        }
        this.moZ = !"from_interview_live".equals(pbFragment.dnX());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int boA = fVar.dlg().boA();
        switch (boA) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dlg().bnw().bni()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.moW = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mpb != null) {
                        this.mpb.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").dR("obj_id", this.eNE));
                    this.mRootView.setVisibility(0);
                    if (this.mpb != null) {
                        this.mpb.callback(true);
                    }
                    this.moN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.moN.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.moO.setVisibility(8);
                    this.moS.setVisibility(8);
                    this.moT.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.moR, aD(pbFragment), null);
                    if (this.moX != null) {
                        this.moX.cancel();
                    }
                    this.moX = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.moQ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ar("c11106").dR("obj_id", PbInterviewStatusView.this.eNE));
                            PbInterviewStatusView.this.moZ = false;
                            PbInterviewStatusView.this.moN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.moN.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.moO.setVisibility(0);
                            PbInterviewStatusView.this.moT.setVisibility(8);
                            PbInterviewStatusView.this.moS.setVisibility(0);
                            PbInterviewStatusView.this.moP.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mpa = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mpb != null) {
                    this.mpb.callback(true);
                }
                this.moO.setVisibility(8);
                this.moS.setVisibility(8);
                this.moP.setVisibility(8);
                this.moT.setVisibility(0);
                this.moN.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ap.setViewTextColor(this.moN, R.color.CAM_X0106);
                ap.setBackgroundColor(this.moT, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (boA == 2) {
                    this.moN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.moZ) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.moN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.moV = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.moV.bn(inflate);
            this.moV.a((String) null, (a.b) null);
            this.moV.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.moY != null) {
                        PbInterviewStatusView.this.moY.cancel();
                    }
                    if (PbInterviewStatusView.this.moV != null) {
                        PbInterviewStatusView.this.moV.dismiss();
                    }
                }
            });
            this.moV.jF(false);
            this.moV.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.moV != null) {
                        PbInterviewStatusView.this.moV.bqx();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.moY = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.moV != null) {
                        PbInterviewStatusView.this.moV.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dnW();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.moU == null) {
            this.moU = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.moU.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.moU.setInterpolator(new LinearInterpolator());
            this.moU.setFillAfter(true);
        }
        return this.moU;
    }

    public boolean getIndicateStatus() {
        return this.mpa;
    }

    public void clearStatus() {
        if (this.moW != null) {
            this.moW.cancel();
            this.moW = null;
        }
        if (this.moX != null) {
            this.moX.cancel();
            this.moX = null;
        }
        if (this.moY != null) {
            this.moY.cancel();
            this.moY = null;
        }
        if (this.moV != null) {
            this.moV.dismiss();
            this.moV = null;
        }
    }
}
