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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String eLs;
    private View mRootView;
    private ImageView mfA;
    private View mfB;
    private Animation mfC;
    private com.baidu.tbadk.core.dialog.a mfD;
    private CountDownTimer mfE;
    private CountDownTimer mfF;
    private CountDownTimer mfG;
    private boolean mfH;
    private boolean mfI;
    private a mfJ;
    private TextView mfv;
    private ImageView mfw;
    private FrameLayout mfx;
    private TextView mfy;
    private ImageView mfz;

    /* loaded from: classes2.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mfJ = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.mfD = null;
        this.mfE = null;
        this.mfF = null;
        this.mfG = null;
        this.mfH = true;
        this.mfI = false;
        this.eLs = null;
        this.mfJ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.mfD = null;
        this.mfE = null;
        this.mfF = null;
        this.mfG = null;
        this.mfH = true;
        this.mfI = false;
        this.eLs = null;
        this.mfJ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.mfD = null;
        this.mfE = null;
        this.mfF = null;
        this.mfG = null;
        this.mfH = true;
        this.mfI = false;
        this.eLs = null;
        this.mfJ = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.mfv = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.mfx = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.mfw = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.mfA = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.mfy = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.mfz = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.mfB = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ao.setViewTextColor(this.mfv, R.color.CAM_X0111);
        ao.setBackgroundResource(this.mfz, R.drawable.icon_interview_loding);
        ao.setViewTextColor(this.mfy, R.color.CAM_X0111);
        ao.setBackgroundResource(this.mfw, R.drawable.icon_interview_mic);
        ao.setBackgroundResource(this.mfA, R.drawable.icon_arrow_tip_white);
        ao.setBackgroundColor(this.mfB, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eLs = fVar.diN().bnd().bmT();
        if (StringUtils.isNull(this.eLs)) {
            this.eLs = fVar.diN().bnd().getTaskId();
        }
        this.mfH = !"from_interview_live".equals(pbFragment.dlB());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int boi = fVar.diN().boi();
        switch (boi) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.diN().bnd().bmP()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.mfE = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mfJ != null) {
                        this.mfJ.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dW("obj_id", this.eLs));
                    this.mRootView.setVisibility(0);
                    if (this.mfJ != null) {
                        this.mfJ.callback(true);
                    }
                    this.mfv.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.mfv.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.mfw.setVisibility(8);
                    this.mfA.setVisibility(8);
                    this.mfB.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.mfz, aD(pbFragment), null);
                    if (this.mfF != null) {
                        this.mfF.cancel();
                    }
                    this.mfF = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.mfy.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dW("obj_id", PbInterviewStatusView.this.eLs));
                            PbInterviewStatusView.this.mfH = false;
                            PbInterviewStatusView.this.mfv.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.mfv.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.mfw.setVisibility(0);
                            PbInterviewStatusView.this.mfB.setVisibility(8);
                            PbInterviewStatusView.this.mfA.setVisibility(0);
                            PbInterviewStatusView.this.mfx.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mfI = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mfJ != null) {
                    this.mfJ.callback(true);
                }
                this.mfw.setVisibility(8);
                this.mfA.setVisibility(8);
                this.mfx.setVisibility(8);
                this.mfB.setVisibility(0);
                this.mfv.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ao.setViewTextColor(this.mfv, R.color.CAM_X0106);
                ao.setBackgroundColor(this.mfB, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (boi == 2) {
                    this.mfv.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.mfH) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.mfv.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            ao.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.CAM_X0105);
            ao.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.CAM_X0105);
            ao.setBackgroundColor(findViewById, R.color.CAM_X0204);
            ao.setBackgroundColor(findViewById2, R.color.CAM_X0204);
            ao.setViewTextColor(textView, R.color.CAM_X0106);
            this.mfD = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.mfD.br(inflate);
            this.mfD.a((String) null, (a.b) null);
            this.mfD.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.mfG != null) {
                        PbInterviewStatusView.this.mfG.cancel();
                    }
                    if (PbInterviewStatusView.this.mfD != null) {
                        PbInterviewStatusView.this.mfD.dismiss();
                    }
                }
            });
            this.mfD.jD(false);
            this.mfD.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.mfD != null) {
                        PbInterviewStatusView.this.mfD.bqe();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.mfG = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.mfD != null) {
                        PbInterviewStatusView.this.mfD.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dlA();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.mfC == null) {
            this.mfC = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.mfC.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.mfC.setInterpolator(new LinearInterpolator());
            this.mfC.setFillAfter(true);
        }
        return this.mfC;
    }

    public boolean getIndicateStatus() {
        return this.mfI;
    }

    public void clearStatus() {
        if (this.mfE != null) {
            this.mfE.cancel();
            this.mfE = null;
        }
        if (this.mfF != null) {
            this.mfF.cancel();
            this.mfF = null;
        }
        if (this.mfG != null) {
            this.mfG.cancel();
            this.mfG = null;
        }
        if (this.mfD != null) {
            this.mfD.dismiss();
            this.mfD = null;
        }
    }
}
