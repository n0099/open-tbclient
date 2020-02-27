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
    private String cOQ;
    private TextView jcj;
    private ImageView jck;
    private FrameLayout jcl;
    private TextView jcm;
    private ImageView jcn;
    private ImageView jco;
    private View jcp;
    private Animation jcq;
    private com.baidu.tbadk.core.dialog.a jcr;
    private CountDownTimer jcs;
    private CountDownTimer jct;
    private CountDownTimer jcu;
    private boolean jcv;
    private boolean jcw;
    private a jcx;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jcx = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jcr = null;
        this.jcs = null;
        this.jct = null;
        this.jcu = null;
        this.jcv = true;
        this.jcw = false;
        this.cOQ = null;
        this.jcx = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jcr = null;
        this.jcs = null;
        this.jct = null;
        this.jcu = null;
        this.jcv = true;
        this.jcw = false;
        this.cOQ = null;
        this.jcx = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jcr = null;
        this.jcs = null;
        this.jct = null;
        this.jcu = null;
        this.jcv = true;
        this.jcw = false;
        this.cOQ = null;
        this.jcx = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jcj = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jcl = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jck = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jco = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jcm = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jcn = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jcp = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jcj, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jcn, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jcm, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jck, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jco, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jcp, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.cOQ = eVar.cks().aBS().aBJ();
        if (StringUtils.isNull(this.cOQ)) {
            this.cOQ = eVar.cks().aBS().getTaskId();
        }
        this.jcv = !"from_interview_live".equals(pbFragment.cmX());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aCU = eVar.cks().aCU();
        switch (aCU) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cks().aBS().aBF()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jcs = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jcx != null) {
                        this.jcx.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cy("obj_id", this.cOQ));
                    this.mRootView.setVisibility(0);
                    if (this.jcx != null) {
                        this.jcx.callback(true);
                    }
                    this.jcj.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jcj.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jck.setVisibility(8);
                    this.jco.setVisibility(8);
                    this.jcp.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jcn, aD(pbFragment), null);
                    if (this.jct != null) {
                        this.jct.cancel();
                    }
                    this.jct = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jcm.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cy("obj_id", PbInterviewStatusView.this.cOQ));
                            PbInterviewStatusView.this.jcv = false;
                            PbInterviewStatusView.this.jcj.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jcj.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jck.setVisibility(0);
                            PbInterviewStatusView.this.jcp.setVisibility(8);
                            PbInterviewStatusView.this.jco.setVisibility(0);
                            PbInterviewStatusView.this.jcl.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jcw = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jcx != null) {
                    this.jcx.callback(true);
                }
                this.jck.setVisibility(8);
                this.jco.setVisibility(8);
                this.jcl.setVisibility(8);
                this.jcp.setVisibility(0);
                this.jcj.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jcj, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jcp, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aCU == 2) {
                    this.jcj.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jcv) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jcj.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.jcr = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jcr.aO(inflate);
            this.jcr.a((String) null, (a.b) null);
            this.jcr.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jcu != null) {
                        PbInterviewStatusView.this.jcu.cancel();
                    }
                    if (PbInterviewStatusView.this.jcr != null) {
                        PbInterviewStatusView.this.jcr.dismiss();
                    }
                }
            });
            this.jcr.fG(false);
            this.jcr.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jcr != null) {
                        PbInterviewStatusView.this.jcr.aEA();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jcu = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jcr != null) {
                        PbInterviewStatusView.this.jcr.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cmW();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jcq == null) {
            this.jcq = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jcq.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jcq.setInterpolator(new LinearInterpolator());
            this.jcq.setFillAfter(true);
        }
        return this.jcq;
    }

    public boolean getIndicateStatus() {
        return this.jcw;
    }

    public void clearStatus() {
        if (this.jcs != null) {
            this.jcs.cancel();
            this.jcs = null;
        }
        if (this.jct != null) {
            this.jct.cancel();
            this.jct = null;
        }
        if (this.jcu != null) {
            this.jcu.cancel();
            this.jcu = null;
        }
        if (this.jcr != null) {
            this.jcr.dismiss();
            this.jcr = null;
        }
    }
}
