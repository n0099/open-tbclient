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
    private TextView gdC;
    private ImageView gdD;
    private FrameLayout gdE;
    private TextView gdF;
    private ImageView gdG;
    private ImageView gdH;
    private View gdI;
    private Animation gdJ;
    private com.baidu.tbadk.core.dialog.a gdK;
    private CountDownTimer gdL;
    private CountDownTimer gdM;
    private CountDownTimer gdN;
    private boolean gdO;
    private boolean gdP;
    private a gdQ;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void A(boolean z);
    }

    public void setCallback(a aVar) {
        this.gdQ = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gdK = null;
        this.gdL = null;
        this.gdM = null;
        this.gdN = null;
        this.gdO = true;
        this.gdP = false;
        this.amT = null;
        this.gdQ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gdK = null;
        this.gdL = null;
        this.gdM = null;
        this.gdN = null;
        this.gdO = true;
        this.gdP = false;
        this.amT = null;
        this.gdQ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gdK = null;
        this.gdL = null;
        this.gdM = null;
        this.gdN = null;
        this.gdO = true;
        this.gdP = false;
        this.amT = null;
        this.gdQ = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.gdC = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.gdE = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.gdD = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.gdH = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.gdF = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.gdG = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.gdI = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.gdC, e.d.cp_cont_g);
        al.i(this.gdG, e.f.icon_interview_loding);
        al.h(this.gdF, e.d.cp_cont_g);
        al.i(this.gdD, e.f.icon_interview_mic);
        al.i(this.gdH, e.f.icon_arrow_tip_white);
        al.j(this.gdI, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.amT = dVar.beV().yc().wU();
        if (StringUtils.isNull(this.amT)) {
            this.amT = dVar.beV().yc().getTaskId();
        }
        this.gdO = !"from_interview_live".equals(pbActivity.bgX());
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
                    this.gdL = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gdQ != null) {
                        this.gdQ.A(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").ax(VideoPlayActivityConfig.OBJ_ID, this.amT));
                    this.mRootView.setVisibility(0);
                    if (this.gdQ != null) {
                        this.gdQ.A(true);
                    }
                    this.gdC.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.gdC.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0175e.fontsize24));
                    this.gdD.setVisibility(8);
                    this.gdH.setVisibility(8);
                    this.gdI.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gdG, ar(pbActivity), null);
                    if (this.gdM != null) {
                        this.gdM.cancel();
                    }
                    this.gdM = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gdF.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").ax(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.amT));
                            PbInterviewStatusView.this.gdO = false;
                            PbInterviewStatusView.this.gdC.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.gdC.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0175e.fontsize24));
                            PbInterviewStatusView.this.gdD.setVisibility(0);
                            PbInterviewStatusView.this.gdI.setVisibility(8);
                            PbInterviewStatusView.this.gdH.setVisibility(0);
                            PbInterviewStatusView.this.gdE.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gdP = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gdQ != null) {
                    this.gdQ.A(true);
                }
                this.gdD.setVisibility(8);
                this.gdH.setVisibility(8);
                this.gdE.setVisibility(8);
                this.gdI.setVisibility(0);
                this.gdC.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0175e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.gdC, e.d.cp_cont_f);
                al.j(this.gdI, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (yX == 2) {
                    this.gdC.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.gdO) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.gdC.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
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
            this.gdK = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gdK.G(inflate);
            this.gdK.a((String) null, (a.b) null);
            this.gdK.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gdN != null) {
                        PbInterviewStatusView.this.gdN.cancel();
                    }
                    if (PbInterviewStatusView.this.gdK != null) {
                        PbInterviewStatusView.this.gdK.dismiss();
                    }
                }
            });
            this.gdK.aO(false);
            this.gdK.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gdK != null) {
                        PbInterviewStatusView.this.gdK.Au();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gdN = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gdK != null) {
                        PbInterviewStatusView.this.gdK.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bgW();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.gdJ == null) {
            this.gdJ = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.gdJ.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gdJ.setInterpolator(new LinearInterpolator());
            this.gdJ.setFillAfter(true);
        }
        return this.gdJ;
    }

    public boolean getIndicateStatus() {
        return this.gdP;
    }

    public void clearStatus() {
        if (this.gdL != null) {
            this.gdL.cancel();
            this.gdL = null;
        }
        if (this.gdM != null) {
            this.gdM.cancel();
            this.gdM = null;
        }
        if (this.gdN != null) {
            this.gdN.cancel();
            this.gdN = null;
        }
        if (this.gdK != null) {
            this.gdK.dismiss();
            this.gdK = null;
        }
    }
}
