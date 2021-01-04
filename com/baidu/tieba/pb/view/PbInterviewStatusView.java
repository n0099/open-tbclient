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
    private String eQd;
    private View mRootView;
    private TextView mkc;
    private ImageView mkd;
    private FrameLayout mke;
    private TextView mkf;
    private ImageView mkg;
    private ImageView mkh;
    private View mki;
    private Animation mkj;
    private com.baidu.tbadk.core.dialog.a mkk;
    private CountDownTimer mkl;
    private CountDownTimer mkm;
    private CountDownTimer mkn;
    private boolean mko;
    private boolean mkp;
    private a mkq;

    /* loaded from: classes2.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mkq = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.mkk = null;
        this.mkl = null;
        this.mkm = null;
        this.mkn = null;
        this.mko = true;
        this.mkp = false;
        this.eQd = null;
        this.mkq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.mkk = null;
        this.mkl = null;
        this.mkm = null;
        this.mkn = null;
        this.mko = true;
        this.mkp = false;
        this.eQd = null;
        this.mkq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.mkk = null;
        this.mkl = null;
        this.mkm = null;
        this.mkn = null;
        this.mko = true;
        this.mkp = false;
        this.eQd = null;
        this.mkq = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.mkc = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.mke = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.mkd = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.mkh = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.mkf = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.mkg = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.mki = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ao.setViewTextColor(this.mkc, R.color.CAM_X0111);
        ao.setBackgroundResource(this.mkg, R.drawable.icon_interview_loding);
        ao.setViewTextColor(this.mkf, R.color.CAM_X0111);
        ao.setBackgroundResource(this.mkd, R.drawable.icon_interview_mic);
        ao.setBackgroundResource(this.mkh, R.drawable.icon_arrow_tip_white);
        ao.setBackgroundColor(this.mki, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eQd = fVar.dmE().bqW().bqM();
        if (StringUtils.isNull(this.eQd)) {
            this.eQd = fVar.dmE().bqW().getTaskId();
        }
        this.mko = !"from_interview_live".equals(pbFragment.dpt());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bsb = fVar.dmE().bsb();
        switch (bsb) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dmE().bqW().bqI()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.mkl = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mkq != null) {
                        this.mkq.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dX("obj_id", this.eQd));
                    this.mRootView.setVisibility(0);
                    if (this.mkq != null) {
                        this.mkq.callback(true);
                    }
                    this.mkc.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.mkc.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.mkd.setVisibility(8);
                    this.mkh.setVisibility(8);
                    this.mki.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.mkg, aD(pbFragment), null);
                    if (this.mkm != null) {
                        this.mkm.cancel();
                    }
                    this.mkm = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.mkf.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dX("obj_id", PbInterviewStatusView.this.eQd));
                            PbInterviewStatusView.this.mko = false;
                            PbInterviewStatusView.this.mkc.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.mkc.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.mkd.setVisibility(0);
                            PbInterviewStatusView.this.mki.setVisibility(8);
                            PbInterviewStatusView.this.mkh.setVisibility(0);
                            PbInterviewStatusView.this.mke.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mkp = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mkq != null) {
                    this.mkq.callback(true);
                }
                this.mkd.setVisibility(8);
                this.mkh.setVisibility(8);
                this.mke.setVisibility(8);
                this.mki.setVisibility(0);
                this.mkc.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ao.setViewTextColor(this.mkc, R.color.CAM_X0106);
                ao.setBackgroundColor(this.mki, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bsb == 2) {
                    this.mkc.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.mko) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.mkc.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.mkk = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.mkk.br(inflate);
            this.mkk.a((String) null, (a.b) null);
            this.mkk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.mkn != null) {
                        PbInterviewStatusView.this.mkn.cancel();
                    }
                    if (PbInterviewStatusView.this.mkk != null) {
                        PbInterviewStatusView.this.mkk.dismiss();
                    }
                }
            });
            this.mkk.jH(false);
            this.mkk.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.mkk != null) {
                        PbInterviewStatusView.this.mkk.btX();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.mkn = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.mkk != null) {
                        PbInterviewStatusView.this.mkk.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dps();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.mkj == null) {
            this.mkj = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.mkj.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.mkj.setInterpolator(new LinearInterpolator());
            this.mkj.setFillAfter(true);
        }
        return this.mkj;
    }

    public boolean getIndicateStatus() {
        return this.mkp;
    }

    public void clearStatus() {
        if (this.mkl != null) {
            this.mkl.cancel();
            this.mkl = null;
        }
        if (this.mkm != null) {
            this.mkm.cancel();
            this.mkm = null;
        }
        if (this.mkn != null) {
            this.mkn.cancel();
            this.mkn = null;
        }
        if (this.mkk != null) {
            this.mkk.dismiss();
            this.mkk = null;
        }
    }
}
