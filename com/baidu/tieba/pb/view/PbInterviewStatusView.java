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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String afO;
    private TextView fKc;
    private ImageView fKd;
    private FrameLayout fKe;
    private TextView fKf;
    private ImageView fKg;
    private ImageView fKh;
    private View fKi;
    private Animation fKj;
    private com.baidu.tbadk.core.dialog.a fKk;
    private CountDownTimer fKl;
    private CountDownTimer fKm;
    private CountDownTimer fKn;
    private boolean fKo;
    private boolean fKp;
    private a fKq;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void t(boolean z);
    }

    public void setCallback(a aVar) {
        this.fKq = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fKk = null;
        this.fKl = null;
        this.fKm = null;
        this.fKn = null;
        this.fKo = true;
        this.fKp = false;
        this.afO = null;
        this.fKq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fKk = null;
        this.fKl = null;
        this.fKm = null;
        this.fKn = null;
        this.fKo = true;
        this.fKp = false;
        this.afO = null;
        this.fKq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fKk = null;
        this.fKl = null;
        this.fKm = null;
        this.fKn = null;
        this.fKo = true;
        this.fKp = false;
        this.afO = null;
        this.fKq = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.i.pb_interview_status, (ViewGroup) this, true);
        this.fKc = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fKe = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fKd = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fKh = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fKf = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fKg = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fKi = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, d.C0141d.cp_link_tip_a);
        al.h(this.fKc, d.C0141d.cp_cont_g);
        al.i(this.fKg, d.f.icon_interview_loding);
        al.h(this.fKf, d.C0141d.cp_cont_g);
        al.i(this.fKd, d.f.icon_interview_mic);
        al.i(this.fKh, d.f.icon_arrow_tip_white);
        al.j(this.fKi, d.C0141d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.afO = dVar.bao().uV().tR();
        if (StringUtils.isNull(this.afO)) {
            this.afO = dVar.bao().uV().getTaskId();
        }
        this.fKo = !"from_interview_live".equals(pbActivity.bco());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int vM = dVar.bao().vM();
        switch (vM) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bao().uV().uQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fKl = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fKq != null) {
                        this.fKq.t(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").ah(VideoPlayActivityConfig.OBJ_ID, this.afO));
                    this.mRootView.setVisibility(0);
                    if (this.fKq != null) {
                        this.fKq.t(true);
                    }
                    this.fKc.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_before_start));
                    this.fKc.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fKd.setVisibility(8);
                    this.fKh.setVisibility(8);
                    this.fKi.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fKg, ar(pbActivity), null);
                    if (this.fKm != null) {
                        this.fKm.cancel();
                    }
                    this.fKm = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fKf.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").ah(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.afO));
                            PbInterviewStatusView.this.fKo = false;
                            PbInterviewStatusView.this.fKc.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_start));
                            PbInterviewStatusView.this.fKc.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fKd.setVisibility(0);
                            PbInterviewStatusView.this.fKi.setVisibility(8);
                            PbInterviewStatusView.this.fKh.setVisibility(0);
                            PbInterviewStatusView.this.fKe.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fKp = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fKq != null) {
                    this.fKq.t(true);
                }
                this.fKd.setVisibility(8);
                this.fKh.setVisibility(8);
                this.fKe.setVisibility(8);
                this.fKi.setVisibility(0);
                this.fKc.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                al.j(this.mRootView, d.C0141d.cp_bg_line_e);
                al.h(this.fKc, d.C0141d.cp_cont_f);
                al.j(this.fKi, d.C0141d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (vM == 2) {
                    this.fKc.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_in_process));
                    if (this.fKo) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fKc.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_finished));
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
            al.i((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            al.h((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0141d.cp_cont_b);
            al.h((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0141d.cp_cont_b);
            al.j(findViewById, d.C0141d.cp_bg_line_a);
            al.j(findViewById2, d.C0141d.cp_bg_line_a);
            al.h(textView, d.C0141d.cp_cont_f);
            this.fKk = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fKk.w(inflate);
            this.fKk.a((String) null, (a.b) null);
            this.fKk.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fKn != null) {
                        PbInterviewStatusView.this.fKn.cancel();
                    }
                    if (PbInterviewStatusView.this.fKk != null) {
                        PbInterviewStatusView.this.fKk.dismiss();
                    }
                }
            });
            this.fKk.au(false);
            this.fKk.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fKk != null) {
                        PbInterviewStatusView.this.fKk.xa();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fKn = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fKk != null) {
                        PbInterviewStatusView.this.fKk.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bcn();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fKj == null) {
            this.fKj = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fKj.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fKj.setInterpolator(new LinearInterpolator());
            this.fKj.setFillAfter(true);
        }
        return this.fKj;
    }

    public boolean getIndicateStatus() {
        return this.fKp;
    }

    public void clearStatus() {
        if (this.fKl != null) {
            this.fKl.cancel();
            this.fKl = null;
        }
        if (this.fKm != null) {
            this.fKm.cancel();
            this.fKm = null;
        }
        if (this.fKn != null) {
            this.fKn.cancel();
            this.fKn = null;
        }
        if (this.fKk != null) {
            this.fKk.dismiss();
            this.fKk = null;
        }
    }
}
