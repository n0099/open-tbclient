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
/* loaded from: classes22.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String emE;
    private TextView lya;
    private ImageView lyb;
    private FrameLayout lyc;
    private TextView lyd;
    private ImageView lye;
    private ImageView lyf;
    private View lyg;
    private Animation lyh;
    private com.baidu.tbadk.core.dialog.a lyi;
    private CountDownTimer lyj;
    private CountDownTimer lyk;
    private CountDownTimer lyl;
    private boolean lym;
    private boolean lyn;
    private a lyp;
    private View mRootView;

    /* loaded from: classes22.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.lyp = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.lyi = null;
        this.lyj = null;
        this.lyk = null;
        this.lyl = null;
        this.lym = true;
        this.lyn = false;
        this.emE = null;
        this.lyp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.lyi = null;
        this.lyj = null;
        this.lyk = null;
        this.lyl = null;
        this.lym = true;
        this.lyn = false;
        this.emE = null;
        this.lyp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.lyi = null;
        this.lyj = null;
        this.lyk = null;
        this.lyl = null;
        this.lym = true;
        this.lyn = false;
        this.emE = null;
        this.lyp = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.lya = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.lyc = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.lyb = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.lyf = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.lyd = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.lye = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.lyg = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        ap.setViewTextColor(this.lya, R.color.cp_cont_g);
        ap.setBackgroundResource(this.lye, R.drawable.icon_interview_loding);
        ap.setViewTextColor(this.lyd, R.color.cp_cont_g);
        ap.setBackgroundResource(this.lyb, R.drawable.icon_interview_mic);
        ap.setBackgroundResource(this.lyf, R.drawable.icon_arrow_tip_white);
        ap.setBackgroundColor(this.lyg, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, f fVar) {
        this.emE = fVar.dcA().bhN().bhD();
        if (StringUtils.isNull(this.emE)) {
            this.emE = fVar.dcA().bhN().getTaskId();
        }
        this.lym = !"from_interview_live".equals(pbFragment.dfl());
        b(pbFragment, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final f fVar) {
        int biS = fVar.dcA().biS();
        switch (biS) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.dcA().bhN().bhz()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.lyj = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.lyp != null) {
                        this.lyp.callback(false);
                    }
                } else {
                    TiebaStatic.log(new aq("c11105").dK("obj_id", this.emE));
                    this.mRootView.setVisibility(0);
                    if (this.lyp != null) {
                        this.lyp.callback(true);
                    }
                    this.lya.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.lya.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.lyb.setVisibility(8);
                    this.lyf.setVisibility(8);
                    this.lyg.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.lye, aG(pbFragment), null);
                    if (this.lyk != null) {
                        this.lyk.cancel();
                    }
                    this.lyk = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.lyd.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aq("c11106").dK("obj_id", PbInterviewStatusView.this.emE));
                            PbInterviewStatusView.this.lym = false;
                            PbInterviewStatusView.this.lya.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.lya.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.lyb.setVisibility(0);
                            PbInterviewStatusView.this.lyg.setVisibility(8);
                            PbInterviewStatusView.this.lyf.setVisibility(0);
                            PbInterviewStatusView.this.lyc.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.lyn = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.lyp != null) {
                    this.lyp.callback(true);
                }
                this.lyb.setVisibility(8);
                this.lyf.setVisibility(8);
                this.lyc.setVisibility(8);
                this.lyg.setVisibility(0);
                this.lya.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                ap.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                ap.setViewTextColor(this.lya, R.color.cp_cont_f);
                ap.setBackgroundColor(this.lyg, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (biS == 2) {
                    this.lya.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.lym) {
                        aF(pbFragment);
                        return;
                    }
                    return;
                }
                this.lya.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.cp_cont_b);
            ap.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.cp_cont_b);
            ap.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            ap.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            this.lyi = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.lyi.ba(inflate);
            this.lyi.a((String) null, (a.b) null);
            this.lyi.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.lyl != null) {
                        PbInterviewStatusView.this.lyl.cancel();
                    }
                    if (PbInterviewStatusView.this.lyi != null) {
                        PbInterviewStatusView.this.lyi.dismiss();
                    }
                }
            });
            this.lyi.iz(false);
            this.lyi.b(pbFragment.getPageContext());
            e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.lyi != null) {
                        PbInterviewStatusView.this.lyi.bkJ();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.lyl = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.lyi != null) {
                        PbInterviewStatusView.this.lyi.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.dfk();
                    }
                }
            }.start();
        }
    }

    private Animation aG(PbFragment pbFragment) {
        if (this.lyh == null) {
            this.lyh = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.lyh.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.lyh.setInterpolator(new LinearInterpolator());
            this.lyh.setFillAfter(true);
        }
        return this.lyh;
    }

    public boolean getIndicateStatus() {
        return this.lyn;
    }

    public void clearStatus() {
        if (this.lyj != null) {
            this.lyj.cancel();
            this.lyj = null;
        }
        if (this.lyk != null) {
            this.lyk.cancel();
            this.lyk = null;
        }
        if (this.lyl != null) {
            this.lyl.cancel();
            this.lyl = null;
        }
        if (this.lyi != null) {
            this.lyi.dismiss();
            this.lyi = null;
        }
    }
}
