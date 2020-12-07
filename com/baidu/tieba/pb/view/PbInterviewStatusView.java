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
    private TextView meN;
    private ImageView meO;
    private FrameLayout meP;
    private TextView meQ;
    private ImageView meR;
    private ImageView meS;
    private View meT;
    private Animation meU;
    private com.baidu.tbadk.core.dialog.a meV;
    private CountDownTimer meW;
    private CountDownTimer meX;
    private CountDownTimer meY;
    private boolean meZ;
    private boolean mfa;
    private a mfb;

    /* loaded from: classes22.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mfb = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.meV = null;
        this.meW = null;
        this.meX = null;
        this.meY = null;
        this.meZ = true;
        this.mfa = false;
        this.eGn = null;
        this.mfb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.meV = null;
        this.meW = null;
        this.meX = null;
        this.meY = null;
        this.meZ = true;
        this.mfa = false;
        this.eGn = null;
        this.mfb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.meV = null;
        this.meW = null;
        this.meX = null;
        this.meY = null;
        this.meZ = true;
        this.mfa = false;
        this.eGn = null;
        this.mfb = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.meN = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.meP = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.meO = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.meS = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.meQ = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.meR = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.meT = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ap.setViewTextColor(this.meN, R.color.CAM_X0111);
        ap.setBackgroundResource(this.meR, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.meQ, R.color.CAM_X0111);
        ap.setBackgroundResource(this.meO, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.meS, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.meT, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eGn = fVar.dmT().bov().bol();
        if (StringUtils.isNull(this.eGn)) {
            this.eGn = fVar.dmT().bov().getTaskId();
        }
        this.meZ = !"from_interview_live".equals(pbFragment.dpG());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bpA = fVar.dmT().bpA();
        switch (bpA) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dmT().bov().boh()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.meW = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mfb != null) {
                        this.mfb.callback(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").dY("obj_id", this.eGn));
                    this.mRootView.setVisibility(0);
                    if (this.mfb != null) {
                        this.mfb.callback(true);
                    }
                    this.meN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.meN.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.meO.setVisibility(8);
                    this.meS.setVisibility(8);
                    this.meT.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.meR, aD(pbFragment), null);
                    if (this.meX != null) {
                        this.meX.cancel();
                    }
                    this.meX = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.meQ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ar("c11106").dY("obj_id", PbInterviewStatusView.this.eGn));
                            PbInterviewStatusView.this.meZ = false;
                            PbInterviewStatusView.this.meN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.meN.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.meO.setVisibility(0);
                            PbInterviewStatusView.this.meT.setVisibility(8);
                            PbInterviewStatusView.this.meS.setVisibility(0);
                            PbInterviewStatusView.this.meP.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mfa = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mfb != null) {
                    this.mfb.callback(true);
                }
                this.meO.setVisibility(8);
                this.meS.setVisibility(8);
                this.meP.setVisibility(8);
                this.meT.setVisibility(0);
                this.meN.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ap.setViewTextColor(this.meN, R.color.CAM_X0106);
                ap.setBackgroundColor(this.meT, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bpA == 2) {
                    this.meN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.meZ) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.meN.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.meV = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.meV.bi(inflate);
            this.meV.a((String) null, (a.b) null);
            this.meV.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.meY != null) {
                        PbInterviewStatusView.this.meY.cancel();
                    }
                    if (PbInterviewStatusView.this.meV != null) {
                        PbInterviewStatusView.this.meV.dismiss();
                    }
                }
            });
            this.meV.jl(false);
            this.meV.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.meV != null) {
                        PbInterviewStatusView.this.meV.brv();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.meY = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.meV != null) {
                        PbInterviewStatusView.this.meV.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dpF();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.meU == null) {
            this.meU = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.meU.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.meU.setInterpolator(new LinearInterpolator());
            this.meU.setFillAfter(true);
        }
        return this.meU;
    }

    public boolean getIndicateStatus() {
        return this.mfa;
    }

    public void clearStatus() {
        if (this.meW != null) {
            this.meW.cancel();
            this.meW = null;
        }
        if (this.meX != null) {
            this.meX.cancel();
            this.meX = null;
        }
        if (this.meY != null) {
            this.meY.cancel();
            this.meY = null;
        }
        if (this.meV != null) {
            this.meV.dismiss();
            this.meV = null;
        }
    }
}
