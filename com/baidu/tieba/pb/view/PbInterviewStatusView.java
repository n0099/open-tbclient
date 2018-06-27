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
    private String agd;
    private TextView fOd;
    private ImageView fOe;
    private FrameLayout fOf;
    private TextView fOg;
    private ImageView fOh;
    private ImageView fOi;
    private View fOj;
    private Animation fOk;
    private com.baidu.tbadk.core.dialog.a fOl;
    private CountDownTimer fOm;
    private CountDownTimer fOn;
    private CountDownTimer fOo;
    private boolean fOp;
    private boolean fOq;
    private a fOr;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void t(boolean z);
    }

    public void setCallback(a aVar) {
        this.fOr = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fOl = null;
        this.fOm = null;
        this.fOn = null;
        this.fOo = null;
        this.fOp = true;
        this.fOq = false;
        this.agd = null;
        this.fOr = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fOl = null;
        this.fOm = null;
        this.fOn = null;
        this.fOo = null;
        this.fOp = true;
        this.fOq = false;
        this.agd = null;
        this.fOr = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fOl = null;
        this.fOm = null;
        this.fOn = null;
        this.fOo = null;
        this.fOp = true;
        this.fOq = false;
        this.agd = null;
        this.fOr = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.i.pb_interview_status, (ViewGroup) this, true);
        this.fOd = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fOf = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fOe = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fOi = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fOg = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fOh = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fOj = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.j(this.mRootView, d.C0142d.cp_link_tip_a);
        am.h(this.fOd, d.C0142d.cp_cont_g);
        am.i(this.fOh, d.f.icon_interview_loding);
        am.h(this.fOg, d.C0142d.cp_cont_g);
        am.i(this.fOe, d.f.icon_interview_mic);
        am.i(this.fOi, d.f.icon_arrow_tip_white);
        am.j(this.fOj, d.C0142d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.agd = dVar.baV().vd().tX();
        if (StringUtils.isNull(this.agd)) {
            this.agd = dVar.baV().vd().getTaskId();
        }
        this.fOp = !"from_interview_live".equals(pbActivity.bcV());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int vW = dVar.baV().vW();
        switch (vW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.baV().vd().uY()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fOm = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fOr != null) {
                        this.fOr.t(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").ah(VideoPlayActivityConfig.OBJ_ID, this.agd));
                    this.mRootView.setVisibility(0);
                    if (this.fOr != null) {
                        this.fOr.t(true);
                    }
                    this.fOd.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_before_start));
                    this.fOd.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fOe.setVisibility(8);
                    this.fOi.setVisibility(8);
                    this.fOj.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fOh, ar(pbActivity), null);
                    if (this.fOn != null) {
                        this.fOn.cancel();
                    }
                    this.fOn = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fOg.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").ah(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.agd));
                            PbInterviewStatusView.this.fOp = false;
                            PbInterviewStatusView.this.fOd.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_start));
                            PbInterviewStatusView.this.fOd.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fOe.setVisibility(0);
                            PbInterviewStatusView.this.fOj.setVisibility(8);
                            PbInterviewStatusView.this.fOi.setVisibility(0);
                            PbInterviewStatusView.this.fOf.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fOq = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fOr != null) {
                    this.fOr.t(true);
                }
                this.fOe.setVisibility(8);
                this.fOi.setVisibility(8);
                this.fOf.setVisibility(8);
                this.fOj.setVisibility(0);
                this.fOd.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                am.j(this.mRootView, d.C0142d.cp_bg_line_e);
                am.h(this.fOd, d.C0142d.cp_cont_f);
                am.j(this.fOj, d.C0142d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (vW == 2) {
                    this.fOd.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_in_process));
                    if (this.fOp) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fOd.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.i.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            am.i((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            am.h((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0142d.cp_cont_b);
            am.h((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0142d.cp_cont_b);
            am.j(findViewById, d.C0142d.cp_bg_line_a);
            am.j(findViewById2, d.C0142d.cp_bg_line_a);
            am.h(textView, d.C0142d.cp_cont_f);
            this.fOl = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fOl.w(inflate);
            this.fOl.a((String) null, (a.b) null);
            this.fOl.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fOo != null) {
                        PbInterviewStatusView.this.fOo.cancel();
                    }
                    if (PbInterviewStatusView.this.fOl != null) {
                        PbInterviewStatusView.this.fOl.dismiss();
                    }
                }
            });
            this.fOl.aw(false);
            this.fOl.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fOl != null) {
                        PbInterviewStatusView.this.fOl.xn();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fOo = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fOl != null) {
                        PbInterviewStatusView.this.fOl.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bcU();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fOk == null) {
            this.fOk = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fOk.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fOk.setInterpolator(new LinearInterpolator());
            this.fOk.setFillAfter(true);
        }
        return this.fOk;
    }

    public boolean getIndicateStatus() {
        return this.fOq;
    }

    public void clearStatus() {
        if (this.fOm != null) {
            this.fOm.cancel();
            this.fOm = null;
        }
        if (this.fOn != null) {
            this.fOn.cancel();
            this.fOn = null;
        }
        if (this.fOo != null) {
            this.fOo.cancel();
            this.fOo = null;
        }
        if (this.fOl != null) {
            this.fOl.dismiss();
            this.fOl = null;
        }
    }
}
