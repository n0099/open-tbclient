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
    private TextView mkb;
    private ImageView mkc;
    private FrameLayout mkd;
    private TextView mke;
    private ImageView mkf;
    private ImageView mkg;
    private View mkh;
    private Animation mki;
    private com.baidu.tbadk.core.dialog.a mkj;
    private CountDownTimer mkk;
    private CountDownTimer mkl;
    private CountDownTimer mkm;
    private boolean mkn;
    private boolean mko;
    private a mkp;

    /* loaded from: classes2.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.mkp = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.mkj = null;
        this.mkk = null;
        this.mkl = null;
        this.mkm = null;
        this.mkn = true;
        this.mko = false;
        this.eQd = null;
        this.mkp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.mkj = null;
        this.mkk = null;
        this.mkl = null;
        this.mkm = null;
        this.mkn = true;
        this.mko = false;
        this.eQd = null;
        this.mkp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.mkj = null;
        this.mkk = null;
        this.mkl = null;
        this.mkm = null;
        this.mkn = true;
        this.mko = false;
        this.eQd = null;
        this.mkp = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.mkb = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.mkd = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.mkc = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.mkg = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.mke = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.mkf = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.mkh = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ao.setBackgroundColor(this.mRootView, R.color.CAM_X0302);
        ao.setViewTextColor(this.mkb, R.color.CAM_X0111);
        ao.setBackgroundResource(this.mkf, R.drawable.icon_interview_loding);
        ao.setViewTextColor(this.mke, R.color.CAM_X0111);
        ao.setBackgroundResource(this.mkc, R.drawable.icon_interview_mic);
        ao.setBackgroundResource(this.mkg, R.drawable.icon_arrow_tip_white);
        ao.setBackgroundColor(this.mkh, R.color.CAM_X0204);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.eQd = fVar.dmF().bqX().bqN();
        if (StringUtils.isNull(this.eQd)) {
            this.eQd = fVar.dmF().bqX().getTaskId();
        }
        this.mkn = !"from_interview_live".equals(pbFragment.dpu());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int bsc = fVar.dmF().bsc();
        switch (bsc) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dmF().bqX().bqJ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.mkk = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.mkp != null) {
                        this.mkp.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dX("obj_id", this.eQd));
                    this.mRootView.setVisibility(0);
                    if (this.mkp != null) {
                        this.mkp.callback(true);
                    }
                    this.mkb.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.mkb.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.mkc.setVisibility(8);
                    this.mkg.setVisibility(8);
                    this.mkh.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.mkf, aD(pbFragment), null);
                    if (this.mkl != null) {
                        this.mkl.cancel();
                    }
                    this.mkl = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.mke.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dX("obj_id", PbInterviewStatusView.this.eQd));
                            PbInterviewStatusView.this.mkn = false;
                            PbInterviewStatusView.this.mkb.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.mkb.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.mkc.setVisibility(0);
                            PbInterviewStatusView.this.mkh.setVisibility(8);
                            PbInterviewStatusView.this.mkg.setVisibility(0);
                            PbInterviewStatusView.this.mkd.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.mko = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.mkp != null) {
                    this.mkp.callback(true);
                }
                this.mkc.setVisibility(8);
                this.mkg.setVisibility(8);
                this.mkd.setVisibility(8);
                this.mkh.setVisibility(0);
                this.mkb.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ao.setBackgroundColor(this.mRootView, R.color.CAM_X0205);
                ao.setViewTextColor(this.mkb, R.color.CAM_X0106);
                ao.setBackgroundColor(this.mkh, R.color.CAM_X0204);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (bsc == 2) {
                    this.mkb.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.mkn) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.mkb.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.mkj = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.mkj.br(inflate);
            this.mkj.a((String) null, (a.b) null);
            this.mkj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.mkm != null) {
                        PbInterviewStatusView.this.mkm.cancel();
                    }
                    if (PbInterviewStatusView.this.mkj != null) {
                        PbInterviewStatusView.this.mkj.dismiss();
                    }
                }
            });
            this.mkj.jH(false);
            this.mkj.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.mB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.mkj != null) {
                        PbInterviewStatusView.this.mkj.btY();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.mkm = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.mkj != null) {
                        PbInterviewStatusView.this.mkj.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dpt();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.mki == null) {
            this.mki = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.mki.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.mki.setInterpolator(new LinearInterpolator());
            this.mki.setFillAfter(true);
        }
        return this.mki;
    }

    public boolean getIndicateStatus() {
        return this.mko;
    }

    public void clearStatus() {
        if (this.mkk != null) {
            this.mkk.cancel();
            this.mkk = null;
        }
        if (this.mkl != null) {
            this.mkl.cancel();
            this.mkl = null;
        }
        if (this.mkm != null) {
            this.mkm.cancel();
            this.mkm = null;
        }
        if (this.mkj != null) {
            this.mkj.dismiss();
            this.mkj = null;
        }
    }
}
