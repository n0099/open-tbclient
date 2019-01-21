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
/* loaded from: classes6.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String arK;
    private TextView gpN;
    private ImageView gpO;
    private FrameLayout gpP;
    private TextView gpQ;
    private ImageView gpR;
    private ImageView gpS;
    private View gpT;
    private Animation gpU;
    private com.baidu.tbadk.core.dialog.a gpV;
    private CountDownTimer gpW;
    private CountDownTimer gpX;
    private CountDownTimer gpY;
    private boolean gpZ;
    private boolean gqa;
    private a gqb;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.gqb = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gpV = null;
        this.gpW = null;
        this.gpX = null;
        this.gpY = null;
        this.gpZ = true;
        this.gqa = false;
        this.arK = null;
        this.gqb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gpV = null;
        this.gpW = null;
        this.gpX = null;
        this.gpY = null;
        this.gpZ = true;
        this.gqa = false;
        this.arK = null;
        this.gqb = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gpV = null;
        this.gpW = null;
        this.gpX = null;
        this.gpY = null;
        this.gpZ = true;
        this.gqa = false;
        this.arK = null;
        this.gqb = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.gpN = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.gpP = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.gpO = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.gpS = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.gpQ = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.gpR = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.gpT = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.gpN, e.d.cp_cont_g);
        al.i(this.gpR, e.f.icon_interview_loding);
        al.h(this.gpQ, e.d.cp_cont_g);
        al.i(this.gpO, e.f.icon_interview_mic);
        al.i(this.gpS, e.f.icon_arrow_tip_white);
        al.j(this.gpT, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.arK = dVar.bhz().zA().yt();
        if (StringUtils.isNull(this.arK)) {
            this.arK = dVar.bhz().zA().getTaskId();
        }
        this.gpZ = !"from_interview_live".equals(pbActivity.bjA());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Av = dVar.bhz().Av();
        switch (Av) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bhz().zA().zv()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gpW = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gqb != null) {
                        this.gqb.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").aB(VideoPlayActivityConfig.OBJ_ID, this.arK));
                    this.mRootView.setVisibility(0);
                    if (this.gqb != null) {
                        this.gqb.O(true);
                    }
                    this.gpN.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.gpN.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize24));
                    this.gpO.setVisibility(8);
                    this.gpS.setVisibility(8);
                    this.gpT.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gpR, as(pbActivity), null);
                    if (this.gpX != null) {
                        this.gpX.cancel();
                    }
                    this.gpX = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gpQ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").aB(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.arK));
                            PbInterviewStatusView.this.gpZ = false;
                            PbInterviewStatusView.this.gpN.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.gpN.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize24));
                            PbInterviewStatusView.this.gpO.setVisibility(0);
                            PbInterviewStatusView.this.gpT.setVisibility(8);
                            PbInterviewStatusView.this.gpS.setVisibility(0);
                            PbInterviewStatusView.this.gpP.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gqa = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gqb != null) {
                    this.gqb.O(true);
                }
                this.gpO.setVisibility(8);
                this.gpS.setVisibility(8);
                this.gpP.setVisibility(8);
                this.gpT.setVisibility(0);
                this.gpN.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.gpN, e.d.cp_cont_f);
                al.j(this.gpT, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Av == 2) {
                    this.gpN.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.gpZ) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.gpN.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ar(final PbActivity pbActivity) {
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
            this.gpV = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gpV.G(inflate);
            this.gpV.a((String) null, (a.b) null);
            this.gpV.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gpY != null) {
                        PbInterviewStatusView.this.gpY.cancel();
                    }
                    if (PbInterviewStatusView.this.gpV != null) {
                        PbInterviewStatusView.this.gpV.dismiss();
                    }
                }
            });
            this.gpV.bg(false);
            this.gpV.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gpV != null) {
                        PbInterviewStatusView.this.gpV.BS();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gpY = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gpV != null) {
                        PbInterviewStatusView.this.gpV.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bjz();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.gpU == null) {
            this.gpU = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.gpU.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gpU.setInterpolator(new LinearInterpolator());
            this.gpU.setFillAfter(true);
        }
        return this.gpU;
    }

    public boolean getIndicateStatus() {
        return this.gqa;
    }

    public void clearStatus() {
        if (this.gpW != null) {
            this.gpW.cancel();
            this.gpW = null;
        }
        if (this.gpX != null) {
            this.gpX.cancel();
            this.gpX = null;
        }
        if (this.gpY != null) {
            this.gpY.cancel();
            this.gpY = null;
        }
        if (this.gpV != null) {
            this.gpV.dismiss();
            this.gpV = null;
        }
    }
}
