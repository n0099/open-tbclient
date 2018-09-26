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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String ahY;
    private TextView fWc;
    private ImageView fWd;
    private FrameLayout fWe;
    private TextView fWf;
    private ImageView fWg;
    private ImageView fWh;
    private View fWi;
    private Animation fWj;
    private com.baidu.tbadk.core.dialog.a fWk;
    private CountDownTimer fWl;
    private CountDownTimer fWm;
    private CountDownTimer fWn;
    private boolean fWo;
    private boolean fWp;
    private a fWq;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void A(boolean z);
    }

    public void setCallback(a aVar) {
        this.fWq = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fWk = null;
        this.fWl = null;
        this.fWm = null;
        this.fWn = null;
        this.fWo = true;
        this.fWp = false;
        this.ahY = null;
        this.fWq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fWk = null;
        this.fWl = null;
        this.fWm = null;
        this.fWn = null;
        this.fWo = true;
        this.fWp = false;
        this.ahY = null;
        this.fWq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fWk = null;
        this.fWl = null;
        this.fWm = null;
        this.fWn = null;
        this.fWo = true;
        this.fWp = false;
        this.ahY = null;
        this.fWq = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.fWc = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.fWe = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.fWd = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.fWh = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.fWf = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.fWg = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.fWi = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.fWc, e.d.cp_cont_g);
        al.i(this.fWg, e.f.icon_interview_loding);
        al.h(this.fWf, e.d.cp_cont_g);
        al.i(this.fWd, e.f.icon_interview_mic);
        al.i(this.fWh, e.f.icon_arrow_tip_white);
        al.j(this.fWi, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.ahY = dVar.bbJ().vT().uL();
        if (StringUtils.isNull(this.ahY)) {
            this.ahY = dVar.bbJ().vT().getTaskId();
        }
        this.fWo = !"from_interview_live".equals(pbActivity.bdL());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int wO = dVar.bbJ().wO();
        switch (wO) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bbJ().vT().vO()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fWl = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fWq != null) {
                        this.fWq.A(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").al(VideoPlayActivityConfig.OBJ_ID, this.ahY));
                    this.mRootView.setVisibility(0);
                    if (this.fWq != null) {
                        this.fWq.A(true);
                    }
                    this.fWc.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.fWc.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0141e.fontsize24));
                    this.fWd.setVisibility(8);
                    this.fWh.setVisibility(8);
                    this.fWi.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fWg, ar(pbActivity), null);
                    if (this.fWm != null) {
                        this.fWm.cancel();
                    }
                    this.fWm = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fWf.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").al(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.ahY));
                            PbInterviewStatusView.this.fWo = false;
                            PbInterviewStatusView.this.fWc.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.fWc.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0141e.fontsize24));
                            PbInterviewStatusView.this.fWd.setVisibility(0);
                            PbInterviewStatusView.this.fWi.setVisibility(8);
                            PbInterviewStatusView.this.fWh.setVisibility(0);
                            PbInterviewStatusView.this.fWe.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fWp = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fWq != null) {
                    this.fWq.A(true);
                }
                this.fWd.setVisibility(8);
                this.fWh.setVisibility(8);
                this.fWe.setVisibility(8);
                this.fWi.setVisibility(0);
                this.fWc.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0141e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.fWc, e.d.cp_cont_f);
                al.j(this.fWi, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (wO == 2) {
                    this.fWc.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.fWo) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fWc.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(e.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(e.g.transfer_count_down);
            View findViewById = inflate.findViewById(e.g.line_left);
            View findViewById2 = inflate.findViewById(e.g.line_right);
            al.i((ImageView) inflate.findViewById(e.g.pop_live), e.f.pic_pop_live_n);
            al.h((TextView) inflate.findViewById(e.g.transfer_tip_txt), e.d.cp_cont_b);
            al.h((TextView) inflate.findViewById(e.g.transfer_tip_txt_1), e.d.cp_cont_b);
            al.j(findViewById, e.d.cp_bg_line_a);
            al.j(findViewById2, e.d.cp_bg_line_a);
            al.h(textView, e.d.cp_cont_f);
            this.fWk = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fWk.G(inflate);
            this.fWk.a((String) null, (a.b) null);
            this.fWk.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fWn != null) {
                        PbInterviewStatusView.this.fWn.cancel();
                    }
                    if (PbInterviewStatusView.this.fWk != null) {
                        PbInterviewStatusView.this.fWk.dismiss();
                    }
                }
            });
            this.fWk.aE(false);
            this.fWk.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fWk != null) {
                        PbInterviewStatusView.this.fWk.yl();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fWn = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fWk != null) {
                        PbInterviewStatusView.this.fWk.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bdK();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fWj == null) {
            this.fWj = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.fWj.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fWj.setInterpolator(new LinearInterpolator());
            this.fWj.setFillAfter(true);
        }
        return this.fWj;
    }

    public boolean getIndicateStatus() {
        return this.fWp;
    }

    public void clearStatus() {
        if (this.fWl != null) {
            this.fWl.cancel();
            this.fWl = null;
        }
        if (this.fWm != null) {
            this.fWm.cancel();
            this.fWm = null;
        }
        if (this.fWn != null) {
            this.fWn.cancel();
            this.fWn = null;
        }
        if (this.fWk != null) {
            this.fWk.dismiss();
            this.fWk = null;
        }
    }
}
