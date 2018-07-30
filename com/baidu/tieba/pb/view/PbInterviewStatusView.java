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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String afx;
    private boolean fOA;
    private a fOB;
    private TextView fOn;
    private ImageView fOo;
    private FrameLayout fOp;
    private TextView fOq;
    private ImageView fOr;
    private ImageView fOs;
    private View fOt;
    private Animation fOu;
    private com.baidu.tbadk.core.dialog.a fOv;
    private CountDownTimer fOw;
    private CountDownTimer fOx;
    private CountDownTimer fOy;
    private boolean fOz;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void q(boolean z);
    }

    public void setCallback(a aVar) {
        this.fOB = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fOv = null;
        this.fOw = null;
        this.fOx = null;
        this.fOy = null;
        this.fOz = true;
        this.fOA = false;
        this.afx = null;
        this.fOB = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fOv = null;
        this.fOw = null;
        this.fOx = null;
        this.fOy = null;
        this.fOz = true;
        this.fOA = false;
        this.afx = null;
        this.fOB = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fOv = null;
        this.fOw = null;
        this.fOx = null;
        this.fOy = null;
        this.fOz = true;
        this.fOA = false;
        this.afx = null;
        this.fOB = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.fOn = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fOp = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fOo = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fOs = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fOq = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fOr = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fOt = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.j(this.mRootView, d.C0140d.cp_link_tip_a);
        am.h(this.fOn, d.C0140d.cp_cont_g);
        am.i(this.fOr, d.f.icon_interview_loding);
        am.h(this.fOq, d.C0140d.cp_cont_g);
        am.i(this.fOo, d.f.icon_interview_mic);
        am.i(this.fOs, d.f.icon_arrow_tip_white);
        am.j(this.fOt, d.C0140d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.afx = dVar.aZn().uR().tJ();
        if (StringUtils.isNull(this.afx)) {
            this.afx = dVar.aZn().uR().getTaskId();
        }
        this.fOz = !"from_interview_live".equals(pbActivity.bbo());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int vL = dVar.aZn().vL();
        switch (vL) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.aZn().uR().uM()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fOw = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fOB != null) {
                        this.fOB.q(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").af(VideoPlayActivityConfig.OBJ_ID, this.afx));
                    this.mRootView.setVisibility(0);
                    if (this.fOB != null) {
                        this.fOB.q(true);
                    }
                    this.fOn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.fOn.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fOo.setVisibility(8);
                    this.fOs.setVisibility(8);
                    this.fOt.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fOr, ar(pbActivity), null);
                    if (this.fOx != null) {
                        this.fOx.cancel();
                    }
                    this.fOx = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fOq.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").af(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.afx));
                            PbInterviewStatusView.this.fOz = false;
                            PbInterviewStatusView.this.fOn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.fOn.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fOo.setVisibility(0);
                            PbInterviewStatusView.this.fOt.setVisibility(8);
                            PbInterviewStatusView.this.fOs.setVisibility(0);
                            PbInterviewStatusView.this.fOp.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fOA = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fOB != null) {
                    this.fOB.q(true);
                }
                this.fOo.setVisibility(8);
                this.fOs.setVisibility(8);
                this.fOp.setVisibility(8);
                this.fOt.setVisibility(0);
                this.fOn.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                am.j(this.mRootView, d.C0140d.cp_bg_line_e);
                am.h(this.fOn, d.C0140d.cp_cont_f);
                am.j(this.fOt, d.C0140d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (vL == 2) {
                    this.fOn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.fOz) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fOn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            am.i((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            am.h((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0140d.cp_cont_b);
            am.h((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0140d.cp_cont_b);
            am.j(findViewById, d.C0140d.cp_bg_line_a);
            am.j(findViewById2, d.C0140d.cp_bg_line_a);
            am.h(textView, d.C0140d.cp_cont_f);
            this.fOv = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fOv.w(inflate);
            this.fOv.a((String) null, (a.b) null);
            this.fOv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fOy != null) {
                        PbInterviewStatusView.this.fOy.cancel();
                    }
                    if (PbInterviewStatusView.this.fOv != null) {
                        PbInterviewStatusView.this.fOv.dismiss();
                    }
                }
            });
            this.fOv.au(false);
            this.fOv.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fOv != null) {
                        PbInterviewStatusView.this.fOv.xf();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fOy = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fOv != null) {
                        PbInterviewStatusView.this.fOv.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bbn();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fOu == null) {
            this.fOu = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fOu.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fOu.setInterpolator(new LinearInterpolator());
            this.fOu.setFillAfter(true);
        }
        return this.fOu;
    }

    public boolean getIndicateStatus() {
        return this.fOA;
    }

    public void clearStatus() {
        if (this.fOw != null) {
            this.fOw.cancel();
            this.fOw = null;
        }
        if (this.fOx != null) {
            this.fOx.cancel();
            this.fOx = null;
        }
        if (this.fOy != null) {
            this.fOy.cancel();
            this.fOy = null;
        }
        if (this.fOv != null) {
            this.fOv.dismiss();
            this.fOv = null;
        }
    }
}
