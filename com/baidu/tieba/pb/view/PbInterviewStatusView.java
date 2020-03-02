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
    private String cOR;
    private TextView jcl;
    private ImageView jcm;
    private FrameLayout jcn;
    private TextView jco;
    private ImageView jcp;
    private ImageView jcq;
    private View jcr;
    private Animation jcs;
    private com.baidu.tbadk.core.dialog.a jct;
    private CountDownTimer jcu;
    private CountDownTimer jcv;
    private CountDownTimer jcw;
    private boolean jcx;
    private boolean jcy;
    private a jcz;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jcz = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jct = null;
        this.jcu = null;
        this.jcv = null;
        this.jcw = null;
        this.jcx = true;
        this.jcy = false;
        this.cOR = null;
        this.jcz = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jct = null;
        this.jcu = null;
        this.jcv = null;
        this.jcw = null;
        this.jcx = true;
        this.jcy = false;
        this.cOR = null;
        this.jcz = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jct = null;
        this.jcu = null;
        this.jcv = null;
        this.jcw = null;
        this.jcx = true;
        this.jcy = false;
        this.cOR = null;
        this.jcz = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jcl = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jcn = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jcm = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jcq = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jco = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jcp = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jcr = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jcl, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jcp, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jco, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jcm, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jcq, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jcr, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.cOR = eVar.cku().aBU().aBL();
        if (StringUtils.isNull(this.cOR)) {
            this.cOR = eVar.cku().aBU().getTaskId();
        }
        this.jcx = !"from_interview_live".equals(pbFragment.cmZ());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aCW = eVar.cku().aCW();
        switch (aCW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cku().aBU().aBH()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jcu = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jcz != null) {
                        this.jcz.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cy("obj_id", this.cOR));
                    this.mRootView.setVisibility(0);
                    if (this.jcz != null) {
                        this.jcz.callback(true);
                    }
                    this.jcl.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jcl.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jcm.setVisibility(8);
                    this.jcq.setVisibility(8);
                    this.jcr.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jcp, aD(pbFragment), null);
                    if (this.jcv != null) {
                        this.jcv.cancel();
                    }
                    this.jcv = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jco.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cy("obj_id", PbInterviewStatusView.this.cOR));
                            PbInterviewStatusView.this.jcx = false;
                            PbInterviewStatusView.this.jcl.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jcl.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jcm.setVisibility(0);
                            PbInterviewStatusView.this.jcr.setVisibility(8);
                            PbInterviewStatusView.this.jcq.setVisibility(0);
                            PbInterviewStatusView.this.jcn.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jcy = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jcz != null) {
                    this.jcz.callback(true);
                }
                this.jcm.setVisibility(8);
                this.jcq.setVisibility(8);
                this.jcn.setVisibility(8);
                this.jcr.setVisibility(0);
                this.jcl.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jcl, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jcr, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aCW == 2) {
                    this.jcl.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jcx) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jcl.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.jct = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jct.aO(inflate);
            this.jct.a((String) null, (a.b) null);
            this.jct.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jcw != null) {
                        PbInterviewStatusView.this.jcw.cancel();
                    }
                    if (PbInterviewStatusView.this.jct != null) {
                        PbInterviewStatusView.this.jct.dismiss();
                    }
                }
            });
            this.jct.fG(false);
            this.jct.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jct != null) {
                        PbInterviewStatusView.this.jct.aEC();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jcw = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jct != null) {
                        PbInterviewStatusView.this.jct.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cmY();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jcs == null) {
            this.jcs = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jcs.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jcs.setInterpolator(new LinearInterpolator());
            this.jcs.setFillAfter(true);
        }
        return this.jcs;
    }

    public boolean getIndicateStatus() {
        return this.jcy;
    }

    public void clearStatus() {
        if (this.jcu != null) {
            this.jcu.cancel();
            this.jcu = null;
        }
        if (this.jcv != null) {
            this.jcv.cancel();
            this.jcv = null;
        }
        if (this.jcw != null) {
            this.jcw.cancel();
            this.jcw = null;
        }
        if (this.jct != null) {
            this.jct.dismiss();
            this.jct = null;
        }
    }
}
