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
/* loaded from: classes22.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String eGn;
    private View mRootView;
    private TextView meP;
    private ImageView meQ;
    private FrameLayout meR;
    private TextView meS;
    private ImageView meT;
    private ImageView meU;
    private View meV;
    private Animation meW;
    private com.baidu.tbadk.core.dialog.a meX;
    private CountDownTimer meY;
    private CountDownTimer meZ;
    private CountDownTimer mfa;
    private boolean mfb;
    private boolean mfc;
    private a mfd;

    /* loaded from: classes22.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mfd = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.meX = null;
        this.meY = null;
        this.meZ = null;
        this.mfa = null;
        this.mfb = true;
        this.mfc = false;
        this.eGn = null;
        this.mfd = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.meX = null;
        this.meY = null;
        this.meZ = null;
        this.mfa = null;
        this.mfb = true;
        this.mfc = false;
        this.eGn = null;
        this.mfd = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.meX = null;
        this.meY = null;
        this.meZ = null;
        this.mfa = null;
        this.mfb = true;
        this.mfc = false;
        this.eGn = null;
        this.mfd = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.meP = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.meR = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.meQ = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.meU = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.meS = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.meT = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.meV = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ap.setViewTextColor(this.meP, R.color.CAM_X0111);
        ap.setBackgroundResource(this.meT, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.meS, R.color.CAM_X0111);
        ap.setBackgroundResource(this.meQ, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.meU, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.meV, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eGn = fVar.dmU().bov().bol();
        if (StringUtils.isNull(this.eGn)) {
            this.eGn = fVar.dmU().bov().getTaskId();
        }
        this.mfb = !"from_interview_live".equals(pbFragment.dpH());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bpA = fVar.dmU().bpA();
        switch (bpA) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dmU().bov().boh()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.meY = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mfd != null) {
                        this.mfd.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").dY("obj_id", this.eGn));
                    this.mRootView.setVisibility(0);
                    if (this.mfd != null) {
                        this.mfd.callback(true);
                    }
                    this.meP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.meP.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.meQ.setVisibility(8);
                    this.meU.setVisibility(8);
                    this.meV.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.meT, aD(pbFragment), null);
                    if (this.meZ != null) {
                        this.meZ.cancel();
                    }
                    this.meZ = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.meS.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ar("c11106").dY("obj_id", PbInterviewStatusView.this.eGn));
                            PbInterviewStatusView.this.mfb = false;
                            PbInterviewStatusView.this.meP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.meP.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.meQ.setVisibility(0);
                            PbInterviewStatusView.this.meV.setVisibility(8);
                            PbInterviewStatusView.this.meU.setVisibility(0);
                            PbInterviewStatusView.this.meR.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mfc = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mfd != null) {
                    this.mfd.callback(true);
                }
                this.meQ.setVisibility(8);
                this.meU.setVisibility(8);
                this.meR.setVisibility(8);
                this.meV.setVisibility(0);
                this.meP.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ap.setViewTextColor(this.meP, R.color.CAM_X0106);
                ap.setBackgroundColor(this.meV, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bpA == 2) {
                    this.meP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.mfb) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.meP.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.meX = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.meX.bi(inflate);
            this.meX.a((String) null, (a.b) null);
            this.meX.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.mfa != null) {
                        PbInterviewStatusView.this.mfa.cancel();
                    }
                    if (PbInterviewStatusView.this.meX != null) {
                        PbInterviewStatusView.this.meX.dismiss();
                    }
                }
            });
            this.meX.jl(false);
            this.meX.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.meX != null) {
                        PbInterviewStatusView.this.meX.brv();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.mfa = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.meX != null) {
                        PbInterviewStatusView.this.meX.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dpG();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.meW == null) {
            this.meW = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.meW.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.meW.setInterpolator(new LinearInterpolator());
            this.meW.setFillAfter(true);
        }
        return this.meW;
    }

    public boolean getIndicateStatus() {
        return this.mfc;
    }

    public void clearStatus() {
        if (this.meY != null) {
            this.meY.cancel();
            this.meY = null;
        }
        if (this.meZ != null) {
            this.meZ.cancel();
            this.meZ = null;
        }
        if (this.mfa != null) {
            this.mfa.cancel();
            this.mfa = null;
        }
        if (this.meX != null) {
            this.meX.dismiss();
            this.meX = null;
        }
    }
}
