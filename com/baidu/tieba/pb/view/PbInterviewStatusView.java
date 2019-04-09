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
    private String byE;
    private TextView hFG;
    private ImageView hFH;
    private FrameLayout hFI;
    private TextView hFJ;
    private ImageView hFK;
    private ImageView hFL;
    private View hFM;
    private Animation hFN;
    private com.baidu.tbadk.core.dialog.a hFO;
    private CountDownTimer hFP;
    private CountDownTimer hFQ;
    private CountDownTimer hFR;
    private boolean hFS;
    private boolean hFT;
    private a hFU;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.hFU = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hFO = null;
        this.hFP = null;
        this.hFQ = null;
        this.hFR = null;
        this.hFS = true;
        this.hFT = false;
        this.byE = null;
        this.hFU = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hFO = null;
        this.hFP = null;
        this.hFQ = null;
        this.hFR = null;
        this.hFS = true;
        this.hFT = false;
        this.byE = null;
        this.hFU = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hFO = null;
        this.hFP = null;
        this.hFQ = null;
        this.hFR = null;
        this.hFS = true;
        this.hFT = false;
        this.byE = null;
        this.hFU = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.hFG = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.hFI = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.hFH = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.hFL = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.hFJ = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.hFK = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.hFM = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, d.C0277d.cp_link_tip_a);
        al.j(this.hFG, d.C0277d.cp_cont_g);
        al.k(this.hFK, d.f.icon_interview_loding);
        al.j(this.hFJ, d.C0277d.cp_cont_g);
        al.k(this.hFH, d.f.icon_interview_mic);
        al.k(this.hFL, d.f.icon_arrow_tip_white);
        al.l(this.hFM, d.C0277d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.byE = dVar.bHW().Yu().Yl();
        if (StringUtils.isNull(this.byE)) {
            this.byE = dVar.bHW().Yu().getTaskId();
        }
        this.hFS = !"from_interview_live".equals(pbActivity.bJT());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Zw = dVar.bHW().Zw();
        switch (Zw) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bHW().Yu().Yh()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.hFP = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hFU != null) {
                        this.hFU.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bJ(VideoPlayActivityConfig.OBJ_ID, this.byE));
                    this.mRootView.setVisibility(0);
                    if (this.hFU != null) {
                        this.hFU.O(true);
                    }
                    this.hFG.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.hFG.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.hFH.setVisibility(8);
                    this.hFL.setVisibility(8);
                    this.hFM.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hFK, au(pbActivity), null);
                    if (this.hFQ != null) {
                        this.hFQ.cancel();
                    }
                    this.hFQ = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hFJ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bJ(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.byE));
                            PbInterviewStatusView.this.hFS = false;
                            PbInterviewStatusView.this.hFG.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.hFG.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.hFH.setVisibility(0);
                            PbInterviewStatusView.this.hFM.setVisibility(8);
                            PbInterviewStatusView.this.hFL.setVisibility(0);
                            PbInterviewStatusView.this.hFI.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hFT = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hFU != null) {
                    this.hFU.O(true);
                }
                this.hFH.setVisibility(8);
                this.hFL.setVisibility(8);
                this.hFI.setVisibility(8);
                this.hFM.setVisibility(0);
                this.hFG.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                al.l(this.mRootView, d.C0277d.cp_bg_line_e);
                al.j(this.hFG, d.C0277d.cp_cont_f);
                al.l(this.hFM, d.C0277d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Zw == 2) {
                    this.hFG.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.hFS) {
                        at(pbActivity);
                        return;
                    }
                    return;
                }
                this.hFG.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void at(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.g.transfer_count_down);
            View findViewById = inflate.findViewById(d.g.line_left);
            View findViewById2 = inflate.findViewById(d.g.line_right);
            al.k((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            al.j((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0277d.cp_cont_b);
            al.j((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0277d.cp_cont_b);
            al.l(findViewById, d.C0277d.cp_bg_line_a);
            al.l(findViewById2, d.C0277d.cp_bg_line_a);
            al.j(textView, d.C0277d.cp_cont_f);
            this.hFO = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hFO.az(inflate);
            this.hFO.a((String) null, (a.b) null);
            this.hFO.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hFR != null) {
                        PbInterviewStatusView.this.hFR.cancel();
                    }
                    if (PbInterviewStatusView.this.hFO != null) {
                        PbInterviewStatusView.this.hFO.dismiss();
                    }
                }
            });
            this.hFO.dq(false);
            this.hFO.b(pbActivity.getPageContext());
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hFO != null) {
                        PbInterviewStatusView.this.hFO.aaW();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hFR = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hFO != null) {
                        PbInterviewStatusView.this.hFO.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bJS();
                    }
                }
            }.start();
        }
    }

    private Animation au(PbActivity pbActivity) {
        if (this.hFN == null) {
            this.hFN = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.hFN.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hFN.setInterpolator(new LinearInterpolator());
            this.hFN.setFillAfter(true);
        }
        return this.hFN;
    }

    public boolean getIndicateStatus() {
        return this.hFT;
    }

    public void clearStatus() {
        if (this.hFP != null) {
            this.hFP.cancel();
            this.hFP = null;
        }
        if (this.hFQ != null) {
            this.hFQ.cancel();
            this.hFQ = null;
        }
        if (this.hFR != null) {
            this.hFR.cancel();
            this.hFR = null;
        }
        if (this.hFO != null) {
            this.hFO.dismiss();
            this.hFO = null;
        }
    }
}
