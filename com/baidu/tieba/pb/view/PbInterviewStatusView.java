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
    private TextView fxE;
    private ImageView fxF;
    private FrameLayout fxG;
    private TextView fxH;
    private ImageView fxI;
    private ImageView fxJ;
    private View fxK;
    private Animation fxL;
    private com.baidu.tbadk.core.dialog.a fxM;
    private CountDownTimer fxN;
    private CountDownTimer fxO;
    private CountDownTimer fxP;
    private boolean fxQ;
    private boolean fxR;
    private a fxS;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void q(boolean z);
    }

    public void setCallback(a aVar) {
        this.fxS = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fxM = null;
        this.fxN = null;
        this.fxO = null;
        this.fxP = null;
        this.fxQ = true;
        this.fxR = false;
        this.XM = null;
        this.fxS = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fxM = null;
        this.fxN = null;
        this.fxO = null;
        this.fxP = null;
        this.fxQ = true;
        this.fxR = false;
        this.XM = null;
        this.fxS = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fxM = null;
        this.fxN = null;
        this.fxO = null;
        this.fxP = null;
        this.fxQ = true;
        this.fxR = false;
        this.XM = null;
        this.fxS = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.i.pb_interview_status, (ViewGroup) this, true);
        this.fxE = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fxG = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fxF = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fxJ = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fxH = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fxI = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fxK = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ak.j(this.mRootView, d.C0126d.cp_link_tip_a);
        ak.h(this.fxE, d.C0126d.cp_cont_g);
        ak.i(this.fxI, d.f.icon_interview_loding);
        ak.h(this.fxH, d.C0126d.cp_cont_g);
        ak.i(this.fxF, d.f.icon_interview_mic);
        ak.i(this.fxJ, d.f.icon_arrow_tip_white);
        ak.j(this.fxK, d.C0126d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.XM = dVar.aVs().rA().qw();
        if (StringUtils.isNull(this.XM)) {
            this.XM = dVar.aVs().rA().getTaskId();
        }
        this.fxQ = !"from_interview_live".equals(pbActivity.aXs());
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
                    this.fxN = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fxS != null) {
                        this.fxS.q(false);
                    }
                } else {
                    TiebaStatic.log(new al("c11105").ac(VideoPlayActivityConfig.OBJ_ID, this.XM));
                    this.mRootView.setVisibility(0);
                    if (this.fxS != null) {
                        this.fxS.q(true);
                    }
                    this.fxE.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_before_start));
                    this.fxE.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fxF.setVisibility(8);
                    this.fxJ.setVisibility(8);
                    this.fxK.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fxI, as(pbActivity), null);
                    if (this.fxO != null) {
                        this.fxO.cancel();
                    }
                    this.fxO = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fxH.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new al("c11106").ac(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.XM));
                            PbInterviewStatusView.this.fxQ = false;
                            PbInterviewStatusView.this.fxE.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_start));
                            PbInterviewStatusView.this.fxE.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fxF.setVisibility(0);
                            PbInterviewStatusView.this.fxK.setVisibility(8);
                            PbInterviewStatusView.this.fxJ.setVisibility(0);
                            PbInterviewStatusView.this.fxG.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fxR = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fxS != null) {
                    this.fxS.q(true);
                }
                this.fxF.setVisibility(8);
                this.fxJ.setVisibility(8);
                this.fxG.setVisibility(8);
                this.fxK.setVisibility(0);
                this.fxE.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                ak.j(this.mRootView, d.C0126d.cp_bg_line_e);
                ak.h(this.fxE, d.C0126d.cp_cont_f);
                ak.j(this.fxK, d.C0126d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sq == 2) {
                    this.fxE.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_in_process));
                    if (this.fxQ) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.fxE.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_finished));
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
            this.fxM = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fxM.w(inflate);
            this.fxM.a((String) null, (a.b) null);
            this.fxM.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fxP != null) {
                        PbInterviewStatusView.this.fxP.cancel();
                    }
                    if (PbInterviewStatusView.this.fxM != null) {
                        PbInterviewStatusView.this.fxM.dismiss();
                    }
                }
            });
            this.fxM.ar(false);
            this.fxM.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fxM != null) {
                        PbInterviewStatusView.this.fxM.tD();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fxP = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fxM != null) {
                        PbInterviewStatusView.this.fxM.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aXr();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.fxL == null) {
            this.fxL = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fxL.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fxL.setInterpolator(new LinearInterpolator());
            this.fxL.setFillAfter(true);
        }
        return this.fxL;
    }

    public boolean getIndicateStatus() {
        return this.fxR;
    }

    public void clearStatus() {
        if (this.fxN != null) {
            this.fxN.cancel();
            this.fxN = null;
        }
        if (this.fxO != null) {
            this.fxO.cancel();
            this.fxO = null;
        }
        if (this.fxP != null) {
            this.fxP.cancel();
            this.fxP = null;
        }
        if (this.fxM != null) {
            this.fxM.dismiss();
            this.fxM = null;
        }
    }
}
