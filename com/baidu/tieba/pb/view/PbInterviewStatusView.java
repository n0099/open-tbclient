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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes21.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String ezo;
    private TextView lQK;
    private ImageView lQL;
    private FrameLayout lQM;
    private TextView lQN;
    private ImageView lQO;
    private ImageView lQP;
    private View lQQ;
    private Animation lQR;
    private com.baidu.tbadk.core.dialog.a lQS;
    private CountDownTimer lQT;
    private CountDownTimer lQU;
    private CountDownTimer lQV;
    private boolean lQW;
    private boolean lQX;
    private a lQY;
    private View mRootView;

    /* loaded from: classes21.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.lQY = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.lQS = null;
        this.lQT = null;
        this.lQU = null;
        this.lQV = null;
        this.lQW = true;
        this.lQX = false;
        this.ezo = null;
        this.lQY = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.lQS = null;
        this.lQT = null;
        this.lQU = null;
        this.lQV = null;
        this.lQW = true;
        this.lQX = false;
        this.ezo = null;
        this.lQY = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.lQS = null;
        this.lQT = null;
        this.lQU = null;
        this.lQV = null;
        this.lQW = true;
        this.lQX = false;
        this.ezo = null;
        this.lQY = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.lQK = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.lQM = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.lQL = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.lQP = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.lQN = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.lQO = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.lQQ = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ap.setViewTextColor(this.lQK, R.color.CAM_X0111);
        ap.setBackgroundResource(this.lQO, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.lQN, R.color.CAM_X0111);
        ap.setBackgroundResource(this.lQL, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.lQP, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.lQQ, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.ezo = fVar.dhH().bli().bkY();
        if (StringUtils.isNull(this.ezo)) {
            this.ezo = fVar.dhH().bli().getTaskId();
        }
        this.lQW = !"from_interview_live".equals(pbFragment.dkr());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bmn = fVar.dhH().bmn();
        switch (bmn) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dhH().bli().bkU()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.lQT = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.lQY != null) {
                        this.lQY.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").dR("obj_id", this.ezo));
                    this.mRootView.setVisibility(0);
                    if (this.lQY != null) {
                        this.lQY.callback(true);
                    }
                    this.lQK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.lQK.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.lQL.setVisibility(8);
                    this.lQP.setVisibility(8);
                    this.lQQ.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.lQO, aG(pbFragment), null);
                    if (this.lQU != null) {
                        this.lQU.cancel();
                    }
                    this.lQU = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.lQN.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ar("c11106").dR("obj_id", PbInterviewStatusView.this.ezo));
                            PbInterviewStatusView.this.lQW = false;
                            PbInterviewStatusView.this.lQK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.lQK.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.lQL.setVisibility(0);
                            PbInterviewStatusView.this.lQQ.setVisibility(8);
                            PbInterviewStatusView.this.lQP.setVisibility(0);
                            PbInterviewStatusView.this.lQM.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.lQX = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.lQY != null) {
                    this.lQY.callback(true);
                }
                this.lQL.setVisibility(8);
                this.lQP.setVisibility(8);
                this.lQM.setVisibility(8);
                this.lQQ.setVisibility(0);
                this.lQK.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ap.setViewTextColor(this.lQK, R.color.CAM_X0106);
                ap.setBackgroundColor(this.lQQ, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bmn == 2) {
                    this.lQK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.lQW) {
                        aF(pbFragment);
                        return;
                    }
                    return;
                }
                this.lQK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aF(final PbFragment pbFragment) {
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
            this.lQS = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.lQS.bg(inflate);
            this.lQS.a((String) null, (a.b) null);
            this.lQS.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.lQV != null) {
                        PbInterviewStatusView.this.lQV.cancel();
                    }
                    if (PbInterviewStatusView.this.lQS != null) {
                        PbInterviewStatusView.this.lQS.dismiss();
                    }
                }
            });
            this.lQS.iW(false);
            this.lQS.b(pbFragment.getPageContext());
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.lQS != null) {
                        PbInterviewStatusView.this.lQS.bog();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.lQV = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.lQS != null) {
                        PbInterviewStatusView.this.lQS.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dkq();
                    }
                }
            }.start();
        }
    }

    private Animation aG(PbFragment pbFragment) {
        if (this.lQR == null) {
            this.lQR = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.lQR.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.lQR.setInterpolator(new LinearInterpolator());
            this.lQR.setFillAfter(true);
        }
        return this.lQR;
    }

    public boolean getIndicateStatus() {
        return this.lQX;
    }

    public void clearStatus() {
        if (this.lQT != null) {
            this.lQT.cancel();
            this.lQT = null;
        }
        if (this.lQU != null) {
            this.lQU.cancel();
            this.lQU = null;
        }
        if (this.lQV != null) {
            this.lQV.cancel();
            this.lQV = null;
        }
        if (this.lQS != null) {
            this.lQS.dismiss();
            this.lQS = null;
        }
    }
}
