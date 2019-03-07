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
    private TextView hFY;
    private ImageView hFZ;
    private FrameLayout hGa;
    private TextView hGb;
    private ImageView hGc;
    private ImageView hGd;
    private View hGe;
    private Animation hGf;
    private com.baidu.tbadk.core.dialog.a hGg;
    private CountDownTimer hGh;
    private CountDownTimer hGi;
    private CountDownTimer hGj;
    private boolean hGk;
    private boolean hGl;
    private a hGm;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.hGm = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hGg = null;
        this.hGh = null;
        this.hGi = null;
        this.hGj = null;
        this.hGk = true;
        this.hGl = false;
        this.byy = null;
        this.hGm = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hGg = null;
        this.hGh = null;
        this.hGi = null;
        this.hGj = null;
        this.hGk = true;
        this.hGl = false;
        this.byy = null;
        this.hGm = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hGg = null;
        this.hGh = null;
        this.hGi = null;
        this.hGj = null;
        this.hGk = true;
        this.hGl = false;
        this.byy = null;
        this.hGm = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.hFY = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.hGa = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.hFZ = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.hGd = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.hGb = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.hGc = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.hGe = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, d.C0236d.cp_link_tip_a);
        al.j(this.hFY, d.C0236d.cp_cont_g);
        al.k(this.hGc, d.f.icon_interview_loding);
        al.j(this.hGb, d.C0236d.cp_cont_g);
        al.k(this.hFZ, d.f.icon_interview_mic);
        al.k(this.hGd, d.f.icon_arrow_tip_white);
        al.l(this.hGe, d.C0236d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.byy = dVar.bHZ().Yx().Yo();
        if (StringUtils.isNull(this.byy)) {
            this.byy = dVar.bHZ().Yx().getTaskId();
        }
        this.hGk = !"from_interview_live".equals(pbActivity.bJW());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Zz = dVar.bHZ().Zz();
        switch (Zz) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bHZ().Yx().Yk()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.hGh = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hGm != null) {
                        this.hGm.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bJ(VideoPlayActivityConfig.OBJ_ID, this.byy));
                    this.mRootView.setVisibility(0);
                    if (this.hGm != null) {
                        this.hGm.O(true);
                    }
                    this.hFY.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.hFY.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.hFZ.setVisibility(8);
                    this.hGd.setVisibility(8);
                    this.hGe.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hGc, aw(pbActivity), null);
                    if (this.hGi != null) {
                        this.hGi.cancel();
                    }
                    this.hGi = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hGb.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bJ(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.byy));
                            PbInterviewStatusView.this.hGk = false;
                            PbInterviewStatusView.this.hFY.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.hFY.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.hFZ.setVisibility(0);
                            PbInterviewStatusView.this.hGe.setVisibility(8);
                            PbInterviewStatusView.this.hGd.setVisibility(0);
                            PbInterviewStatusView.this.hGa.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hGl = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hGm != null) {
                    this.hGm.O(true);
                }
                this.hFZ.setVisibility(8);
                this.hGd.setVisibility(8);
                this.hGa.setVisibility(8);
                this.hGe.setVisibility(0);
                this.hFY.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                al.l(this.mRootView, d.C0236d.cp_bg_line_e);
                al.j(this.hFY, d.C0236d.cp_cont_f);
                al.l(this.hGe, d.C0236d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Zz == 2) {
                    this.hFY.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.hGk) {
                        av(pbActivity);
                        return;
                    }
                    return;
                }
                this.hFY.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            this.hGg = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hGg.az(inflate);
            this.hGg.a((String) null, (a.b) null);
            this.hGg.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hGj != null) {
                        PbInterviewStatusView.this.hGj.cancel();
                    }
                    if (PbInterviewStatusView.this.hGg != null) {
                        PbInterviewStatusView.this.hGg.dismiss();
                    }
                }
            });
            this.hGg.dq(false);
            this.hGg.b(pbActivity.getPageContext());
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hGg != null) {
                        PbInterviewStatusView.this.hGg.aaZ();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hGj = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hGg != null) {
                        PbInterviewStatusView.this.hGg.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bJV();
                    }
                }
            }.start();
        }
    }

    private Animation aw(PbActivity pbActivity) {
        if (this.hGf == null) {
            this.hGf = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.hGf.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hGf.setInterpolator(new LinearInterpolator());
            this.hGf.setFillAfter(true);
        }
        return this.hGf;
    }

    public boolean getIndicateStatus() {
        return this.hGl;
    }

    public void clearStatus() {
        if (this.hGh != null) {
            this.hGh.cancel();
            this.hGh = null;
        }
        if (this.hGi != null) {
            this.hGi.cancel();
            this.hGi = null;
        }
        if (this.hGj != null) {
            this.hGj.cancel();
            this.hGj = null;
        }
        if (this.hGg != null) {
            this.hGg.dismiss();
            this.hGg = null;
        }
    }
}
