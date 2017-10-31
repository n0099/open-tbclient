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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String Wo;
    private TextView fcQ;
    private ImageView fcR;
    private FrameLayout fcS;
    private TextView fcT;
    private ImageView fcU;
    private ImageView fcV;
    private View fcW;
    private Animation fcX;
    private com.baidu.tbadk.core.dialog.a fcY;
    private CountDownTimer fcZ;
    private CountDownTimer fda;
    private CountDownTimer fdb;
    private boolean fdc;
    private boolean fdd;
    private a fde;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.fde = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fcY = null;
        this.fcZ = null;
        this.fda = null;
        this.fdb = null;
        this.fdc = true;
        this.fdd = false;
        this.Wo = null;
        this.fde = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fcY = null;
        this.fcZ = null;
        this.fda = null;
        this.fdb = null;
        this.fdc = true;
        this.fdd = false;
        this.Wo = null;
        this.fde = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fcY = null;
        this.fcZ = null;
        this.fda = null;
        this.fdb = null;
        this.fdc = true;
        this.fdd = false;
        this.Wo = null;
        this.fde = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.fcQ = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fcS = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fcR = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fcV = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fcT = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fcU = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fcW = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.C0080d.cp_link_tip_a);
        aj.i(this.fcQ, d.C0080d.cp_cont_g);
        aj.j(this.fcU, d.f.icon_interview_loding);
        aj.i(this.fcT, d.C0080d.cp_cont_g);
        aj.j(this.fcR, d.f.icon_interview_mic);
        aj.j(this.fcV, d.f.icon_arrow_tip_white);
        aj.k(this.fcW, d.C0080d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Wo = fVar.aPO().qZ().pB();
        if (StringUtils.isNull(this.Wo)) {
            this.Wo = fVar.aPO().qZ().getTaskId();
        }
        this.fdc = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aRP());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rW = fVar.aPO().rW();
        switch (rW) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aPO().qZ().qT()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fcZ = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fde != null) {
                        this.fde.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ac("obj_id", this.Wo));
                    this.mRootView.setVisibility(0);
                    if (this.fde != null) {
                        this.fde.p(true);
                    }
                    this.fcQ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.fcQ.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fcR.setVisibility(8);
                    this.fcV.setVisibility(8);
                    this.fcW.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fcU, ar(pbActivity), null);
                    if (this.fda != null) {
                        this.fda.cancel();
                    }
                    this.fda = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fcT.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ac("obj_id", PbInterviewStatusView.this.Wo));
                            PbInterviewStatusView.this.fdc = false;
                            PbInterviewStatusView.this.fcQ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.fcQ.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fcR.setVisibility(0);
                            PbInterviewStatusView.this.fcW.setVisibility(8);
                            PbInterviewStatusView.this.fcV.setVisibility(0);
                            PbInterviewStatusView.this.fcS.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fdd = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fde != null) {
                    this.fde.p(true);
                }
                this.fcR.setVisibility(8);
                this.fcV.setVisibility(8);
                this.fcS.setVisibility(8);
                this.fcW.setVisibility(0);
                this.fcQ.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.k(this.mRootView, d.C0080d.cp_bg_line_e);
                aj.i(this.fcQ, d.C0080d.cp_cont_f);
                aj.k(this.fcW, d.C0080d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rW == 2) {
                    this.fcQ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.fdc) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.fcQ.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            aj.j((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0080d.cp_cont_b);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0080d.cp_cont_b);
            aj.k(findViewById, d.C0080d.cp_bg_line_a);
            aj.k(findViewById2, d.C0080d.cp_bg_line_a);
            aj.i(textView, d.C0080d.cp_cont_f);
            this.fcY = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fcY.v(inflate);
            this.fcY.a((String) null, (a.b) null);
            this.fcY.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fdb != null) {
                        PbInterviewStatusView.this.fdb.cancel();
                    }
                    if (PbInterviewStatusView.this.fcY != null) {
                        PbInterviewStatusView.this.fcY.dismiss();
                    }
                }
            });
            this.fcY.ao(false);
            this.fcY.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fcY != null) {
                        PbInterviewStatusView.this.fcY.th();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fdb = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fcY != null) {
                        PbInterviewStatusView.this.fcY.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aRN();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.fcX == null) {
            this.fcX = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fcX.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fcX.setInterpolator(new LinearInterpolator());
            this.fcX.setFillAfter(true);
        }
        return this.fcX;
    }

    public boolean getIndicateStatus() {
        return this.fdd;
    }

    public void clearStatus() {
        if (this.fcZ != null) {
            this.fcZ.cancel();
            this.fcZ = null;
        }
        if (this.fda != null) {
            this.fda.cancel();
            this.fda = null;
        }
        if (this.fdb != null) {
            this.fdb.cancel();
            this.fdb = null;
        }
        if (this.fcY != null) {
            this.fcY.dismiss();
            this.fcY = null;
        }
    }
}
