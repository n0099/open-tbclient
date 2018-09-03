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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String afx;
    private TextView fOg;
    private ImageView fOh;
    private FrameLayout fOi;
    private TextView fOj;
    private ImageView fOk;
    private ImageView fOl;
    private View fOm;
    private Animation fOn;
    private com.baidu.tbadk.core.dialog.a fOo;
    private CountDownTimer fOp;
    private CountDownTimer fOq;
    private CountDownTimer fOr;
    private boolean fOs;
    private boolean fOt;
    private a fOu;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void q(boolean z);
    }

    public void setCallback(a aVar) {
        this.fOu = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fOo = null;
        this.fOp = null;
        this.fOq = null;
        this.fOr = null;
        this.fOs = true;
        this.fOt = false;
        this.afx = null;
        this.fOu = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fOo = null;
        this.fOp = null;
        this.fOq = null;
        this.fOr = null;
        this.fOs = true;
        this.fOt = false;
        this.afx = null;
        this.fOu = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fOo = null;
        this.fOp = null;
        this.fOq = null;
        this.fOr = null;
        this.fOs = true;
        this.fOt = false;
        this.afx = null;
        this.fOu = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(f.h.pb_interview_status, (ViewGroup) this, true);
        this.fOg = (TextView) this.mRootView.findViewById(f.g.interview_live_status_btn);
        this.fOi = (FrameLayout) this.mRootView.findViewById(f.g.count_container);
        this.fOh = (ImageView) this.mRootView.findViewById(f.g.interview_mic);
        this.fOl = (ImageView) this.mRootView.findViewById(f.g.interview_arrow);
        this.fOj = (TextView) this.mRootView.findViewById(f.g.count_text);
        this.fOk = (ImageView) this.mRootView.findViewById(f.g.count_bg);
        this.fOm = this.mRootView.findViewById(f.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.j(this.mRootView, f.d.cp_link_tip_a);
        am.h(this.fOg, f.d.cp_cont_g);
        am.i(this.fOk, f.C0146f.icon_interview_loding);
        am.h(this.fOj, f.d.cp_cont_g);
        am.i(this.fOh, f.C0146f.icon_interview_mic);
        am.i(this.fOl, f.C0146f.icon_arrow_tip_white);
        am.j(this.fOm, f.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.afx = dVar.aZi().uQ().tI();
        if (StringUtils.isNull(this.afx)) {
            this.afx = dVar.aZi().uQ().getTaskId();
        }
        this.fOs = !"from_interview_live".equals(pbActivity.bbj());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int vK = dVar.aZi().vK();
        switch (vK) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.aZi().uQ().uL()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fOp = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fOu != null) {
                        this.fOu.q(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").ae(VideoPlayActivityConfig.OBJ_ID, this.afx));
                    this.mRootView.setVisibility(0);
                    if (this.fOu != null) {
                        this.fOu.q(true);
                    }
                    this.fOg.setText(pbActivity.getPageContext().getPageActivity().getString(f.j.interview_live_before_start));
                    this.fOg.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), f.e.fontsize24));
                    this.fOh.setVisibility(8);
                    this.fOl.setVisibility(8);
                    this.fOm.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fOk, ar(pbActivity), null);
                    if (this.fOq != null) {
                        this.fOq.cancel();
                    }
                    this.fOq = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fOj.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").ae(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.afx));
                            PbInterviewStatusView.this.fOs = false;
                            PbInterviewStatusView.this.fOg.setText(pbActivity.getPageContext().getPageActivity().getString(f.j.interview_live_start));
                            PbInterviewStatusView.this.fOg.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), f.e.fontsize24));
                            PbInterviewStatusView.this.fOh.setVisibility(0);
                            PbInterviewStatusView.this.fOm.setVisibility(8);
                            PbInterviewStatusView.this.fOl.setVisibility(0);
                            PbInterviewStatusView.this.fOi.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fOt = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fOu != null) {
                    this.fOu.q(true);
                }
                this.fOh.setVisibility(8);
                this.fOl.setVisibility(8);
                this.fOi.setVisibility(8);
                this.fOm.setVisibility(0);
                this.fOg.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), f.e.fontsize28));
                am.j(this.mRootView, f.d.cp_bg_line_e);
                am.h(this.fOg, f.d.cp_cont_f);
                am.j(this.fOm, f.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (vK == 2) {
                    this.fOg.setText(pbActivity.getPageContext().getPageActivity().getString(f.j.interview_live_in_process));
                    if (this.fOs) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fOg.setText(pbActivity.getPageContext().getPageActivity().getString(f.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(f.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(f.g.transfer_count_down);
            View findViewById = inflate.findViewById(f.g.line_left);
            View findViewById2 = inflate.findViewById(f.g.line_right);
            am.i((ImageView) inflate.findViewById(f.g.pop_live), f.C0146f.pic_pop_live_n);
            am.h((TextView) inflate.findViewById(f.g.transfer_tip_txt), f.d.cp_cont_b);
            am.h((TextView) inflate.findViewById(f.g.transfer_tip_txt_1), f.d.cp_cont_b);
            am.j(findViewById, f.d.cp_bg_line_a);
            am.j(findViewById2, f.d.cp_bg_line_a);
            am.h(textView, f.d.cp_cont_f);
            this.fOo = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fOo.w(inflate);
            this.fOo.a((String) null, (a.b) null);
            this.fOo.b(f.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fOr != null) {
                        PbInterviewStatusView.this.fOr.cancel();
                    }
                    if (PbInterviewStatusView.this.fOo != null) {
                        PbInterviewStatusView.this.fOo.dismiss();
                    }
                }
            });
            this.fOo.av(false);
            this.fOo.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fOo != null) {
                        PbInterviewStatusView.this.fOo.xe();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fOr = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fOo != null) {
                        PbInterviewStatusView.this.fOo.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bbi();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fOn == null) {
            this.fOn = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), f.a.rotate_anim);
            this.fOn.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fOn.setInterpolator(new LinearInterpolator());
            this.fOn.setFillAfter(true);
        }
        return this.fOn;
    }

    public boolean getIndicateStatus() {
        return this.fOt;
    }

    public void clearStatus() {
        if (this.fOp != null) {
            this.fOp.cancel();
            this.fOp = null;
        }
        if (this.fOq != null) {
            this.fOq.cancel();
            this.fOq = null;
        }
        if (this.fOr != null) {
            this.fOr.cancel();
            this.fOr = null;
        }
        if (this.fOo != null) {
            this.fOo.dismiss();
            this.fOo = null;
        }
    }
}
