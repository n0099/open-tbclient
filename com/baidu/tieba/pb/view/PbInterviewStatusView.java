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
    private String dCp;
    private TextView khf;
    private ImageView khg;
    private FrameLayout khh;
    private TextView khi;
    private ImageView khj;
    private ImageView khk;
    private View khl;
    private Animation khm;
    private com.baidu.tbadk.core.dialog.a khn;
    private CountDownTimer kho;
    private CountDownTimer khp;
    private CountDownTimer khq;
    private boolean khr;
    private boolean khs;
    private a kht;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.kht = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.khn = null;
        this.kho = null;
        this.khp = null;
        this.khq = null;
        this.khr = true;
        this.khs = false;
        this.dCp = null;
        this.kht = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.khn = null;
        this.kho = null;
        this.khp = null;
        this.khq = null;
        this.khr = true;
        this.khs = false;
        this.dCp = null;
        this.kht = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.khn = null;
        this.kho = null;
        this.khp = null;
        this.khq = null;
        this.khr = true;
        this.khs = false;
        this.dCp = null;
        this.kht = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.khf = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.khh = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.khg = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.khk = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.khi = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.khj = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.khl = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.khf, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.khj, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.khi, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.khg, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.khk, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.khl, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.dCp = eVar.cCy().aQd().aPU();
        if (StringUtils.isNull(this.dCp)) {
            this.dCp = eVar.cCy().aQd().getTaskId();
        }
        this.khr = !"from_interview_live".equals(pbFragment.cFj());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aRj = eVar.cCy().aRj();
        switch (aRj) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.cCy().aQd().aPQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.kho = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.kht != null) {
                        this.kht.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").dh("obj_id", this.dCp));
                    this.mRootView.setVisibility(0);
                    if (this.kht != null) {
                        this.kht.callback(true);
                    }
                    this.khf.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.khf.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.khg.setVisibility(8);
                    this.khk.setVisibility(8);
                    this.khl.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.khj, aC(pbFragment), null);
                    if (this.khp != null) {
                        this.khp.cancel();
                    }
                    this.khp = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.khi.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").dh("obj_id", PbInterviewStatusView.this.dCp));
                            PbInterviewStatusView.this.khr = false;
                            PbInterviewStatusView.this.khf.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.khf.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.khg.setVisibility(0);
                            PbInterviewStatusView.this.khl.setVisibility(8);
                            PbInterviewStatusView.this.khk.setVisibility(0);
                            PbInterviewStatusView.this.khh.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.khs = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.kht != null) {
                    this.kht.callback(true);
                }
                this.khg.setVisibility(8);
                this.khk.setVisibility(8);
                this.khh.setVisibility(8);
                this.khl.setVisibility(0);
                this.khf.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.khf, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.khl, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aRj == 2) {
                    this.khf.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.khr) {
                        aB(pbFragment);
                        return;
                    }
                    return;
                }
                this.khf.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aB(final PbFragment pbFragment) {
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
            this.khn = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.khn.aP(inflate);
            this.khn.a((String) null, (a.b) null);
            this.khn.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.khq != null) {
                        PbInterviewStatusView.this.khq.cancel();
                    }
                    if (PbInterviewStatusView.this.khn != null) {
                        PbInterviewStatusView.this.khn.dismiss();
                    }
                }
            });
            this.khn.gW(false);
            this.khn.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.khn != null) {
                        PbInterviewStatusView.this.khn.aST();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.khq = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.khn != null) {
                        PbInterviewStatusView.this.khn.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cFi();
                    }
                }
            }.start();
        }
    }

    private Animation aC(PbFragment pbFragment) {
        if (this.khm == null) {
            this.khm = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.khm.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.khm.setInterpolator(new LinearInterpolator());
            this.khm.setFillAfter(true);
        }
        return this.khm;
    }

    public boolean getIndicateStatus() {
        return this.khs;
    }

    public void clearStatus() {
        if (this.kho != null) {
            this.kho.cancel();
            this.kho = null;
        }
        if (this.khp != null) {
            this.khp.cancel();
            this.khp = null;
        }
        if (this.khq != null) {
            this.khq.cancel();
            this.khq = null;
        }
        if (this.khn != null) {
            this.khn.dismiss();
            this.khn = null;
        }
    }
}
