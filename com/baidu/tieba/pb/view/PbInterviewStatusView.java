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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String bHq;
    private TextView ihb;
    private ImageView ihc;
    private FrameLayout ihd;
    private TextView ihe;
    private ImageView ihf;
    private ImageView ihg;
    private View ihh;
    private Animation ihi;
    private com.baidu.tbadk.core.dialog.a ihj;
    private CountDownTimer ihk;
    private CountDownTimer ihl;
    private CountDownTimer ihm;
    private boolean ihn;
    private boolean iho;
    private a ihp;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void G(boolean z);
    }

    public void setCallback(a aVar) {
        this.ihp = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.ihj = null;
        this.ihk = null;
        this.ihl = null;
        this.ihm = null;
        this.ihn = true;
        this.iho = false;
        this.bHq = null;
        this.ihp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.ihj = null;
        this.ihk = null;
        this.ihl = null;
        this.ihm = null;
        this.ihn = true;
        this.iho = false;
        this.bHq = null;
        this.ihp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.ihj = null;
        this.ihk = null;
        this.ihl = null;
        this.ihm = null;
        this.ihn = true;
        this.iho = false;
        this.bHq = null;
        this.ihp = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.ihb = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.ihd = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.ihc = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.ihg = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.ihe = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.ihf = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.ihh = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.l(this.mRootView, R.color.cp_link_tip_a);
        am.j(this.ihb, R.color.cp_cont_g);
        am.k(this.ihf, R.drawable.icon_interview_loding);
        am.j(this.ihe, R.color.cp_cont_g);
        am.k(this.ihc, R.drawable.icon_interview_mic);
        am.k(this.ihg, R.drawable.icon_arrow_tip_white);
        am.l(this.ihh, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bHq = dVar.bTy().aei().adZ();
        if (StringUtils.isNull(this.bHq)) {
            this.bHq = dVar.bTy().aei().getTaskId();
        }
        this.ihn = !"from_interview_live".equals(pbActivity.bVC());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int afk = dVar.bTy().afk();
        switch (afk) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bTy().aei().adV()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.ihk = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.ihp != null) {
                        this.ihp.G(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").bT(VideoPlayActivityConfig.OBJ_ID, this.bHq));
                    this.mRootView.setVisibility(0);
                    if (this.ihp != null) {
                        this.ihp.G(true);
                    }
                    this.ihb.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.ihb.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.ihc.setVisibility(8);
                    this.ihg.setVisibility(8);
                    this.ihh.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ihf, ax(pbActivity), null);
                    if (this.ihl != null) {
                        this.ihl.cancel();
                    }
                    this.ihl = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.ihe.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").bT(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.bHq));
                            PbInterviewStatusView.this.ihn = false;
                            PbInterviewStatusView.this.ihb.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.ihb.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.ihc.setVisibility(0);
                            PbInterviewStatusView.this.ihh.setVisibility(8);
                            PbInterviewStatusView.this.ihg.setVisibility(0);
                            PbInterviewStatusView.this.ihd.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.iho = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ihp != null) {
                    this.ihp.G(true);
                }
                this.ihc.setVisibility(8);
                this.ihg.setVisibility(8);
                this.ihd.setVisibility(8);
                this.ihh.setVisibility(0);
                this.ihb.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.l(this.mRootView, R.color.cp_bg_line_e);
                am.j(this.ihb, R.color.cp_cont_f);
                am.l(this.ihh, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (afk == 2) {
                    this.ihb.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.ihn) {
                        aw(pbActivity);
                        return;
                    }
                    return;
                }
                this.ihb.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aw(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            am.k((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            am.j((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.cp_cont_b);
            am.j((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.cp_cont_b);
            am.l(findViewById, R.color.cp_bg_line_c);
            am.l(findViewById2, R.color.cp_bg_line_c);
            am.j(textView, R.color.cp_cont_f);
            this.ihj = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.ihj.aH(inflate);
            this.ihj.a((String) null, (a.b) null);
            this.ihj.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.ihm != null) {
                        PbInterviewStatusView.this.ihm.cancel();
                    }
                    if (PbInterviewStatusView.this.ihj != null) {
                        PbInterviewStatusView.this.ihj.dismiss();
                    }
                }
            });
            this.ihj.dQ(false);
            this.ihj.b(pbActivity.getPageContext());
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.ihj != null) {
                        PbInterviewStatusView.this.ihj.agO();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.ihm = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.ihj != null) {
                        PbInterviewStatusView.this.ihj.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bVB();
                    }
                }
            }.start();
        }
    }

    private Animation ax(PbActivity pbActivity) {
        if (this.ihi == null) {
            this.ihi = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.ihi.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ihi.setInterpolator(new LinearInterpolator());
            this.ihi.setFillAfter(true);
        }
        return this.ihi;
    }

    public boolean getIndicateStatus() {
        return this.iho;
    }

    public void clearStatus() {
        if (this.ihk != null) {
            this.ihk.cancel();
            this.ihk = null;
        }
        if (this.ihl != null) {
            this.ihl.cancel();
            this.ihl = null;
        }
        if (this.ihm != null) {
            this.ihm.cancel();
            this.ihm = null;
        }
        if (this.ihj != null) {
            this.ihj.dismiss();
            this.ihj = null;
        }
    }
}
