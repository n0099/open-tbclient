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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String XM;
    private TextView fxB;
    private ImageView fxC;
    private FrameLayout fxD;
    private TextView fxE;
    private ImageView fxF;
    private ImageView fxG;
    private View fxH;
    private Animation fxI;
    private com.baidu.tbadk.core.dialog.a fxJ;
    private CountDownTimer fxK;
    private CountDownTimer fxL;
    private CountDownTimer fxM;
    private boolean fxN;
    private boolean fxO;
    private a fxP;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void q(boolean z);
    }

    public void setCallback(a aVar) {
        this.fxP = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fxJ = null;
        this.fxK = null;
        this.fxL = null;
        this.fxM = null;
        this.fxN = true;
        this.fxO = false;
        this.XM = null;
        this.fxP = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fxJ = null;
        this.fxK = null;
        this.fxL = null;
        this.fxM = null;
        this.fxN = true;
        this.fxO = false;
        this.XM = null;
        this.fxP = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fxJ = null;
        this.fxK = null;
        this.fxL = null;
        this.fxM = null;
        this.fxN = true;
        this.fxO = false;
        this.XM = null;
        this.fxP = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.i.pb_interview_status, (ViewGroup) this, true);
        this.fxB = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fxD = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fxC = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fxG = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fxE = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fxF = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fxH = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ak.j(this.mRootView, d.C0126d.cp_link_tip_a);
        ak.h(this.fxB, d.C0126d.cp_cont_g);
        ak.i(this.fxF, d.f.icon_interview_loding);
        ak.h(this.fxE, d.C0126d.cp_cont_g);
        ak.i(this.fxC, d.f.icon_interview_mic);
        ak.i(this.fxG, d.f.icon_arrow_tip_white);
        ak.j(this.fxH, d.C0126d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.XM = dVar.aVs().rA().qw();
        if (StringUtils.isNull(this.XM)) {
            this.XM = dVar.aVs().rA().getTaskId();
        }
        this.fxN = !"from_interview_live".equals(pbActivity.aXs());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int sq = dVar.aVs().sq();
        switch (sq) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.aVs().rA().rv()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fxK = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fxP != null) {
                        this.fxP.q(false);
                    }
                } else {
                    TiebaStatic.log(new al("c11105").ac(VideoPlayActivityConfig.OBJ_ID, this.XM));
                    this.mRootView.setVisibility(0);
                    if (this.fxP != null) {
                        this.fxP.q(true);
                    }
                    this.fxB.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_before_start));
                    this.fxB.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fxC.setVisibility(8);
                    this.fxG.setVisibility(8);
                    this.fxH.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fxF, as(pbActivity), null);
                    if (this.fxL != null) {
                        this.fxL.cancel();
                    }
                    this.fxL = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fxE.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new al("c11106").ac(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.XM));
                            PbInterviewStatusView.this.fxN = false;
                            PbInterviewStatusView.this.fxB.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_start));
                            PbInterviewStatusView.this.fxB.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fxC.setVisibility(0);
                            PbInterviewStatusView.this.fxH.setVisibility(8);
                            PbInterviewStatusView.this.fxG.setVisibility(0);
                            PbInterviewStatusView.this.fxD.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fxO = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fxP != null) {
                    this.fxP.q(true);
                }
                this.fxC.setVisibility(8);
                this.fxG.setVisibility(8);
                this.fxD.setVisibility(8);
                this.fxH.setVisibility(0);
                this.fxB.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                ak.j(this.mRootView, d.C0126d.cp_bg_line_e);
                ak.h(this.fxB, d.C0126d.cp_cont_f);
                ak.j(this.fxH, d.C0126d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sq == 2) {
                    this.fxB.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_in_process));
                    if (this.fxN) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.fxB.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ar(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.i.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            ak.i((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            ak.h((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0126d.cp_cont_b);
            ak.h((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0126d.cp_cont_b);
            ak.j(findViewById, d.C0126d.cp_bg_line_a);
            ak.j(findViewById2, d.C0126d.cp_bg_line_a);
            ak.h(textView, d.C0126d.cp_cont_f);
            this.fxJ = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fxJ.w(inflate);
            this.fxJ.a((String) null, (a.b) null);
            this.fxJ.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fxM != null) {
                        PbInterviewStatusView.this.fxM.cancel();
                    }
                    if (PbInterviewStatusView.this.fxJ != null) {
                        PbInterviewStatusView.this.fxJ.dismiss();
                    }
                }
            });
            this.fxJ.ar(false);
            this.fxJ.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fxJ != null) {
                        PbInterviewStatusView.this.fxJ.tD();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fxM = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fxJ != null) {
                        PbInterviewStatusView.this.fxJ.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aXr();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.fxI == null) {
            this.fxI = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fxI.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fxI.setInterpolator(new LinearInterpolator());
            this.fxI.setFillAfter(true);
        }
        return this.fxI;
    }

    public boolean getIndicateStatus() {
        return this.fxO;
    }

    public void clearStatus() {
        if (this.fxK != null) {
            this.fxK.cancel();
            this.fxK = null;
        }
        if (this.fxL != null) {
            this.fxL.cancel();
            this.fxL = null;
        }
        if (this.fxM != null) {
            this.fxM.cancel();
            this.fxM = null;
        }
        if (this.fxJ != null) {
            this.fxJ.dismiss();
            this.fxJ = null;
        }
    }
}
