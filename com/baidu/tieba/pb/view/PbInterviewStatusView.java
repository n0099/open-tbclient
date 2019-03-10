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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String byy;
    private TextView hFZ;
    private ImageView hGa;
    private FrameLayout hGb;
    private TextView hGc;
    private ImageView hGd;
    private ImageView hGe;
    private View hGf;
    private Animation hGg;
    private com.baidu.tbadk.core.dialog.a hGh;
    private CountDownTimer hGi;
    private CountDownTimer hGj;
    private CountDownTimer hGk;
    private boolean hGl;
    private boolean hGm;
    private a hGn;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.hGn = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hGh = null;
        this.hGi = null;
        this.hGj = null;
        this.hGk = null;
        this.hGl = true;
        this.hGm = false;
        this.byy = null;
        this.hGn = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hGh = null;
        this.hGi = null;
        this.hGj = null;
        this.hGk = null;
        this.hGl = true;
        this.hGm = false;
        this.byy = null;
        this.hGn = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hGh = null;
        this.hGi = null;
        this.hGj = null;
        this.hGk = null;
        this.hGl = true;
        this.hGm = false;
        this.byy = null;
        this.hGn = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.hFZ = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.hGb = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.hGa = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.hGe = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.hGc = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.hGd = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.hGf = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, d.C0236d.cp_link_tip_a);
        al.j(this.hFZ, d.C0236d.cp_cont_g);
        al.k(this.hGd, d.f.icon_interview_loding);
        al.j(this.hGc, d.C0236d.cp_cont_g);
        al.k(this.hGa, d.f.icon_interview_mic);
        al.k(this.hGe, d.f.icon_arrow_tip_white);
        al.l(this.hGf, d.C0236d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.byy = dVar.bIa().Yx().Yo();
        if (StringUtils.isNull(this.byy)) {
            this.byy = dVar.bIa().Yx().getTaskId();
        }
        this.hGl = !"from_interview_live".equals(pbActivity.bJX());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Zz = dVar.bIa().Zz();
        switch (Zz) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bIa().Yx().Yk()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.hGi = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hGn != null) {
                        this.hGn.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bJ(VideoPlayActivityConfig.OBJ_ID, this.byy));
                    this.mRootView.setVisibility(0);
                    if (this.hGn != null) {
                        this.hGn.O(true);
                    }
                    this.hFZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.hFZ.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.hGa.setVisibility(8);
                    this.hGe.setVisibility(8);
                    this.hGf.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hGd, aw(pbActivity), null);
                    if (this.hGj != null) {
                        this.hGj.cancel();
                    }
                    this.hGj = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hGc.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bJ(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.byy));
                            PbInterviewStatusView.this.hGl = false;
                            PbInterviewStatusView.this.hFZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.hFZ.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.hGa.setVisibility(0);
                            PbInterviewStatusView.this.hGf.setVisibility(8);
                            PbInterviewStatusView.this.hGe.setVisibility(0);
                            PbInterviewStatusView.this.hGb.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hGm = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hGn != null) {
                    this.hGn.O(true);
                }
                this.hGa.setVisibility(8);
                this.hGe.setVisibility(8);
                this.hGb.setVisibility(8);
                this.hGf.setVisibility(0);
                this.hFZ.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                al.l(this.mRootView, d.C0236d.cp_bg_line_e);
                al.j(this.hFZ, d.C0236d.cp_cont_f);
                al.l(this.hGf, d.C0236d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Zz == 2) {
                    this.hFZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.hGl) {
                        av(pbActivity);
                        return;
                    }
                    return;
                }
                this.hFZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void av(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            al.k((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            al.j((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0236d.cp_cont_b);
            al.j((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0236d.cp_cont_b);
            al.l(findViewById, d.C0236d.cp_bg_line_a);
            al.l(findViewById2, d.C0236d.cp_bg_line_a);
            al.j(textView, d.C0236d.cp_cont_f);
            this.hGh = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hGh.az(inflate);
            this.hGh.a((String) null, (a.b) null);
            this.hGh.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hGk != null) {
                        PbInterviewStatusView.this.hGk.cancel();
                    }
                    if (PbInterviewStatusView.this.hGh != null) {
                        PbInterviewStatusView.this.hGh.dismiss();
                    }
                }
            });
            this.hGh.dq(false);
            this.hGh.b(pbActivity.getPageContext());
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hGh != null) {
                        PbInterviewStatusView.this.hGh.aaZ();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hGk = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hGh != null) {
                        PbInterviewStatusView.this.hGh.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bJW();
                    }
                }
            }.start();
        }
    }

    private Animation aw(PbActivity pbActivity) {
        if (this.hGg == null) {
            this.hGg = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.hGg.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hGg.setInterpolator(new LinearInterpolator());
            this.hGg.setFillAfter(true);
        }
        return this.hGg;
    }

    public boolean getIndicateStatus() {
        return this.hGm;
    }

    public void clearStatus() {
        if (this.hGi != null) {
            this.hGi.cancel();
            this.hGi = null;
        }
        if (this.hGj != null) {
            this.hGj.cancel();
            this.hGj = null;
        }
        if (this.hGk != null) {
            this.hGk.cancel();
            this.hGk = null;
        }
        if (this.hGh != null) {
            this.hGh.dismiss();
            this.hGh = null;
        }
    }
}
