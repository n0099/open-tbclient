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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String aLe;
    private TextView fZL;
    private ImageView fZM;
    private FrameLayout fZN;
    private TextView fZO;
    private ImageView fZP;
    private ImageView fZQ;
    private View fZR;
    private Animation fZS;
    private com.baidu.tbadk.core.dialog.a fZT;
    private CountDownTimer fZU;
    private CountDownTimer fZV;
    private CountDownTimer fZW;
    private boolean fZX;
    private boolean fZY;
    private a fZZ;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void W(boolean z);
    }

    public void setCallback(a aVar) {
        this.fZZ = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fZT = null;
        this.fZU = null;
        this.fZV = null;
        this.fZW = null;
        this.fZX = true;
        this.fZY = false;
        this.aLe = null;
        this.fZZ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fZT = null;
        this.fZU = null;
        this.fZV = null;
        this.fZW = null;
        this.fZX = true;
        this.fZY = false;
        this.aLe = null;
        this.fZZ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fZT = null;
        this.fZU = null;
        this.fZV = null;
        this.fZW = null;
        this.fZX = true;
        this.fZY = false;
        this.aLe = null;
        this.fZZ = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.fZL = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fZN = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fZM = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fZQ = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fZO = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fZP = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fZR = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.t(this.mRootView, d.C0107d.cp_link_tip_a);
        aj.r(this.fZL, d.C0107d.cp_cont_g);
        aj.s(this.fZP, d.f.icon_interview_loding);
        aj.r(this.fZO, d.C0107d.cp_cont_g);
        aj.s(this.fZM, d.f.icon_interview_mic);
        aj.s(this.fZQ, d.f.icon_arrow_tip_white);
        aj.t(this.fZR, d.C0107d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.aLe = fVar.aYG().yA().xi();
        if (StringUtils.isNull(this.aLe)) {
            this.aLe = fVar.aYG().yA().getTaskId();
        }
        this.fZX = !"from_interview_live".equals(pbActivity.baN());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int zu = fVar.aYG().zu();
        switch (zu) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aYG().yA().yu()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fZU = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fZZ != null) {
                        this.fZZ.W(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ab("obj_id", this.aLe));
                    this.mRootView.setVisibility(0);
                    if (this.fZZ != null) {
                        this.fZZ.W(true);
                    }
                    this.fZL.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.fZL.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fZM.setVisibility(8);
                    this.fZQ.setVisibility(8);
                    this.fZR.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fZP, aq(pbActivity), null);
                    if (this.fZV != null) {
                        this.fZV.cancel();
                    }
                    this.fZV = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fZO.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ab("obj_id", PbInterviewStatusView.this.aLe));
                            PbInterviewStatusView.this.fZX = false;
                            PbInterviewStatusView.this.fZL.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.fZL.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fZM.setVisibility(0);
                            PbInterviewStatusView.this.fZR.setVisibility(8);
                            PbInterviewStatusView.this.fZQ.setVisibility(0);
                            PbInterviewStatusView.this.fZN.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fZY = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fZZ != null) {
                    this.fZZ.W(true);
                }
                this.fZM.setVisibility(8);
                this.fZQ.setVisibility(8);
                this.fZN.setVisibility(8);
                this.fZR.setVisibility(0);
                this.fZL.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.t(this.mRootView, d.C0107d.cp_bg_line_e);
                aj.r(this.fZL, d.C0107d.cp_cont_f);
                aj.t(this.fZR, d.C0107d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (zu == 2) {
                    this.fZL.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.fZX) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.fZL.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ap(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            aj.s((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0107d.cp_cont_b);
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0107d.cp_cont_b);
            aj.t(findViewById, d.C0107d.cp_bg_line_a);
            aj.t(findViewById2, d.C0107d.cp_bg_line_a);
            aj.r(textView, d.C0107d.cp_cont_f);
            this.fZT = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fZT.aO(inflate);
            this.fZT.a((String) null, (a.b) null);
            this.fZT.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fZW != null) {
                        PbInterviewStatusView.this.fZW.cancel();
                    }
                    if (PbInterviewStatusView.this.fZT != null) {
                        PbInterviewStatusView.this.fZT.dismiss();
                    }
                }
            });
            this.fZT.aV(false);
            this.fZT.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fZT != null) {
                        PbInterviewStatusView.this.fZT.AA();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fZW = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fZT != null) {
                        PbInterviewStatusView.this.fZT.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.baL();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.fZS == null) {
            this.fZS = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fZS.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fZS.setInterpolator(new LinearInterpolator());
            this.fZS.setFillAfter(true);
        }
        return this.fZS;
    }

    public boolean getIndicateStatus() {
        return this.fZY;
    }

    public void clearStatus() {
        if (this.fZU != null) {
            this.fZU.cancel();
            this.fZU = null;
        }
        if (this.fZV != null) {
            this.fZV.cancel();
            this.fZV = null;
        }
        if (this.fZW != null) {
            this.fZW.cancel();
            this.fZW = null;
        }
        if (this.fZT != null) {
            this.fZT.dismiss();
            this.fZT = null;
        }
    }
}
