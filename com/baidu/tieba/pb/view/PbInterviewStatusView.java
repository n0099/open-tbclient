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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String cOS;
    private TextView jcA;
    private ImageView jcB;
    private ImageView jcC;
    private View jcD;
    private Animation jcE;
    private com.baidu.tbadk.core.dialog.a jcF;
    private CountDownTimer jcG;
    private CountDownTimer jcH;
    private CountDownTimer jcI;
    private boolean jcJ;
    private boolean jcK;
    private a jcL;
    private TextView jcx;
    private ImageView jcy;
    private FrameLayout jcz;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jcL = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jcF = null;
        this.jcG = null;
        this.jcH = null;
        this.jcI = null;
        this.jcJ = true;
        this.jcK = false;
        this.cOS = null;
        this.jcL = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jcF = null;
        this.jcG = null;
        this.jcH = null;
        this.jcI = null;
        this.jcJ = true;
        this.jcK = false;
        this.cOS = null;
        this.jcL = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jcF = null;
        this.jcG = null;
        this.jcH = null;
        this.jcI = null;
        this.jcJ = true;
        this.jcK = false;
        this.cOS = null;
        this.jcL = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jcx = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jcz = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jcy = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jcC = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jcA = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jcB = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jcD = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jcx, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jcB, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jcA, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jcy, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jcC, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jcD, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.cOS = eVar.ckv().aBU().aBL();
        if (StringUtils.isNull(this.cOS)) {
            this.cOS = eVar.ckv().aBU().getTaskId();
        }
        this.jcJ = !"from_interview_live".equals(pbFragment.cna());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aCW = eVar.ckv().aCW();
        switch (aCW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.ckv().aBU().aBH()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jcG = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jcL != null) {
                        this.jcL.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cy("obj_id", this.cOS));
                    this.mRootView.setVisibility(0);
                    if (this.jcL != null) {
                        this.jcL.callback(true);
                    }
                    this.jcx.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jcx.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jcy.setVisibility(8);
                    this.jcC.setVisibility(8);
                    this.jcD.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jcB, aD(pbFragment), null);
                    if (this.jcH != null) {
                        this.jcH.cancel();
                    }
                    this.jcH = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jcA.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cy("obj_id", PbInterviewStatusView.this.cOS));
                            PbInterviewStatusView.this.jcJ = false;
                            PbInterviewStatusView.this.jcx.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jcx.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jcy.setVisibility(0);
                            PbInterviewStatusView.this.jcD.setVisibility(8);
                            PbInterviewStatusView.this.jcC.setVisibility(0);
                            PbInterviewStatusView.this.jcz.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jcK = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jcL != null) {
                    this.jcL.callback(true);
                }
                this.jcy.setVisibility(8);
                this.jcC.setVisibility(8);
                this.jcz.setVisibility(8);
                this.jcD.setVisibility(0);
                this.jcx.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jcx, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jcD, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aCW == 2) {
                    this.jcx.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jcJ) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jcx.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aC(final PbFragment pbFragment) {
        if (MessageManager.getInstance().findTask(1003200) != null) {
            View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            am.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), (int) R.color.cp_cont_b);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), (int) R.color.cp_cont_b);
            am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            am.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            this.jcF = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jcF.aO(inflate);
            this.jcF.a((String) null, (a.b) null);
            this.jcF.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jcI != null) {
                        PbInterviewStatusView.this.jcI.cancel();
                    }
                    if (PbInterviewStatusView.this.jcF != null) {
                        PbInterviewStatusView.this.jcF.dismiss();
                    }
                }
            });
            this.jcF.fG(false);
            this.jcF.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jcF != null) {
                        PbInterviewStatusView.this.jcF.aEC();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jcI = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jcF != null) {
                        PbInterviewStatusView.this.jcF.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cmZ();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jcE == null) {
            this.jcE = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jcE.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jcE.setInterpolator(new LinearInterpolator());
            this.jcE.setFillAfter(true);
        }
        return this.jcE;
    }

    public boolean getIndicateStatus() {
        return this.jcK;
    }

    public void clearStatus() {
        if (this.jcG != null) {
            this.jcG.cancel();
            this.jcG = null;
        }
        if (this.jcH != null) {
            this.jcH.cancel();
            this.jcH = null;
        }
        if (this.jcI != null) {
            this.jcI.cancel();
            this.jcI = null;
        }
        if (this.jcF != null) {
            this.jcF.dismiss();
            this.jcF = null;
        }
    }
}
