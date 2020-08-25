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
    private String dYo;
    private TextView kZK;
    private ImageView kZL;
    private FrameLayout kZM;
    private TextView kZN;
    private ImageView kZO;
    private ImageView kZP;
    private View kZQ;
    private Animation kZR;
    private com.baidu.tbadk.core.dialog.a kZS;
    private CountDownTimer kZT;
    private CountDownTimer kZU;
    private CountDownTimer kZV;
    private boolean kZW;
    private boolean kZX;
    private a kZY;
    private View mRootView;

    /* loaded from: classes16.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.kZY = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.kZS = null;
        this.kZT = null;
        this.kZU = null;
        this.kZV = null;
        this.kZW = true;
        this.kZX = false;
        this.dYo = null;
        this.kZY = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.kZS = null;
        this.kZT = null;
        this.kZU = null;
        this.kZV = null;
        this.kZW = true;
        this.kZX = false;
        this.dYo = null;
        this.kZY = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.kZS = null;
        this.kZT = null;
        this.kZU = null;
        this.kZV = null;
        this.kZW = true;
        this.kZX = false;
        this.dYo = null;
        this.kZY = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.kZK = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.kZM = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.kZL = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.kZP = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.kZN = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.kZO = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.kZQ = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.kZK, R.color.cp_cont_g);
        ap.setBackgroundResource(this.kZO, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.kZN, R.color.cp_cont_g);
        ap.setBackgroundResource(this.kZL, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.kZP, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.kZQ, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.dYo = fVar.cVl().bek().bea();
        if (StringUtils.isNull(this.dYo)) {
            this.dYo = fVar.cVl().bek().getTaskId();
        }
        this.kZW = !"from_interview_live".equals(pbFragment.cXY());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bfp = fVar.cVl().bfp();
        switch (bfp) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.cVl().bek().bdW()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.kZT = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.kZY != null) {
                        this.kZY.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dD("obj_id", this.dYo));
                    this.mRootView.setVisibility(0);
                    if (this.kZY != null) {
                        this.kZY.callback(true);
                    }
                    this.kZK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.kZK.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.kZL.setVisibility(8);
                    this.kZP.setVisibility(8);
                    this.kZQ.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.kZO, aF(pbFragment), null);
                    if (this.kZU != null) {
                        this.kZU.cancel();
                    }
                    this.kZU = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.kZN.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dD("obj_id", PbInterviewStatusView.this.dYo));
                            PbInterviewStatusView.this.kZW = false;
                            PbInterviewStatusView.this.kZK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.kZK.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.kZL.setVisibility(0);
                            PbInterviewStatusView.this.kZQ.setVisibility(8);
                            PbInterviewStatusView.this.kZP.setVisibility(0);
                            PbInterviewStatusView.this.kZM.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.kZX = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.kZY != null) {
                    this.kZY.callback(true);
                }
                this.kZL.setVisibility(8);
                this.kZP.setVisibility(8);
                this.kZM.setVisibility(8);
                this.kZQ.setVisibility(0);
                this.kZK.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ap.setViewTextColor(this.kZK, R.color.cp_cont_f);
                ap.setBackgroundColor(this.kZQ, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bfp == 2) {
                    this.kZK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.kZW) {
                        aE(pbFragment);
                        return;
                    }
                    return;
                }
                this.kZK.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.kZS = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.kZS.aX(inflate);
            this.kZS.a((String) null, (a.b) null);
            this.kZS.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.kZV != null) {
                        PbInterviewStatusView.this.kZV.cancel();
                    }
                    if (PbInterviewStatusView.this.kZS != null) {
                        PbInterviewStatusView.this.kZS.dismiss();
                    }
                }
            });
            this.kZS.m39if(false);
            this.kZS.b(pbFragment.getPageContext());
            e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.kZS != null) {
                        PbInterviewStatusView.this.kZS.bhg();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.kZV = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.kZS != null) {
                        PbInterviewStatusView.this.kZS.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cXX();
                    }
                }
            }.start();
        }
    }

    private Animation aF(PbFragment pbFragment) {
        if (this.kZR == null) {
            this.kZR = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.kZR.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.kZR.setInterpolator(new LinearInterpolator());
            this.kZR.setFillAfter(true);
        }
        return this.kZR;
    }

    public boolean getIndicateStatus() {
        return this.kZX;
    }

    public void clearStatus() {
        if (this.kZT != null) {
            this.kZT.cancel();
            this.kZT = null;
        }
        if (this.kZU != null) {
            this.kZU.cancel();
            this.kZU = null;
        }
        if (this.kZV != null) {
            this.kZV.cancel();
            this.kZV = null;
        }
        if (this.kZS != null) {
            this.kZS.dismiss();
            this.kZS = null;
        }
    }
}
