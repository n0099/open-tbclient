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
    private String amT;
    private TextView gdD;
    private ImageView gdE;
    private FrameLayout gdF;
    private TextView gdG;
    private ImageView gdH;
    private ImageView gdI;
    private View gdJ;
    private Animation gdK;
    private com.baidu.tbadk.core.dialog.a gdL;
    private CountDownTimer gdM;
    private CountDownTimer gdN;
    private CountDownTimer gdO;
    private boolean gdP;
    private boolean gdQ;
    private a gdR;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void A(boolean z);
    }

    public void setCallback(a aVar) {
        this.gdR = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gdL = null;
        this.gdM = null;
        this.gdN = null;
        this.gdO = null;
        this.gdP = true;
        this.gdQ = false;
        this.amT = null;
        this.gdR = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gdL = null;
        this.gdM = null;
        this.gdN = null;
        this.gdO = null;
        this.gdP = true;
        this.gdQ = false;
        this.amT = null;
        this.gdR = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gdL = null;
        this.gdM = null;
        this.gdN = null;
        this.gdO = null;
        this.gdP = true;
        this.gdQ = false;
        this.amT = null;
        this.gdR = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.gdD = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.gdF = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.gdE = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.gdI = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.gdG = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.gdH = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.gdJ = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.gdD, e.d.cp_cont_g);
        al.i(this.gdH, e.f.icon_interview_loding);
        al.h(this.gdG, e.d.cp_cont_g);
        al.i(this.gdE, e.f.icon_interview_mic);
        al.i(this.gdI, e.f.icon_arrow_tip_white);
        al.j(this.gdJ, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.amT = dVar.beV().yc().wU();
        if (StringUtils.isNull(this.amT)) {
            this.amT = dVar.beV().yc().getTaskId();
        }
        this.gdP = !"from_interview_live".equals(pbActivity.bgX());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int yX = dVar.beV().yX();
        switch (yX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.beV().yc().xX()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gdM = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gdR != null) {
                        this.gdR.A(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").ax(VideoPlayActivityConfig.OBJ_ID, this.amT));
                    this.mRootView.setVisibility(0);
                    if (this.gdR != null) {
                        this.gdR.A(true);
                    }
                    this.gdD.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.gdD.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0175e.fontsize24));
                    this.gdE.setVisibility(8);
                    this.gdI.setVisibility(8);
                    this.gdJ.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gdH, ar(pbActivity), null);
                    if (this.gdN != null) {
                        this.gdN.cancel();
                    }
                    this.gdN = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gdG.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").ax(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.amT));
                            PbInterviewStatusView.this.gdP = false;
                            PbInterviewStatusView.this.gdD.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.gdD.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0175e.fontsize24));
                            PbInterviewStatusView.this.gdE.setVisibility(0);
                            PbInterviewStatusView.this.gdJ.setVisibility(8);
                            PbInterviewStatusView.this.gdI.setVisibility(0);
                            PbInterviewStatusView.this.gdF.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gdQ = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gdR != null) {
                    this.gdR.A(true);
                }
                this.gdE.setVisibility(8);
                this.gdI.setVisibility(8);
                this.gdF.setVisibility(8);
                this.gdJ.setVisibility(0);
                this.gdD.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0175e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.gdD, e.d.cp_cont_f);
                al.j(this.gdJ, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (yX == 2) {
                    this.gdD.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.gdP) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.gdD.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
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
            this.gdL = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gdL.G(inflate);
            this.gdL.a((String) null, (a.b) null);
            this.gdL.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gdO != null) {
                        PbInterviewStatusView.this.gdO.cancel();
                    }
                    if (PbInterviewStatusView.this.gdL != null) {
                        PbInterviewStatusView.this.gdL.dismiss();
                    }
                }
            });
            this.gdL.aO(false);
            this.gdL.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gdL != null) {
                        PbInterviewStatusView.this.gdL.Au();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gdO = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gdL != null) {
                        PbInterviewStatusView.this.gdL.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bgW();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.gdK == null) {
            this.gdK = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.gdK.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gdK.setInterpolator(new LinearInterpolator());
            this.gdK.setFillAfter(true);
        }
        return this.gdK;
    }

    public boolean getIndicateStatus() {
        return this.gdQ;
    }

    public void clearStatus() {
        if (this.gdM != null) {
            this.gdM.cancel();
            this.gdM = null;
        }
        if (this.gdN != null) {
            this.gdN.cancel();
            this.gdN = null;
        }
        if (this.gdO != null) {
            this.gdO.cancel();
            this.gdO = null;
        }
        if (this.gdL != null) {
            this.gdL.dismiss();
            this.gdL = null;
        }
    }
}
