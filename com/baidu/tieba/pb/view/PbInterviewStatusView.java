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
    private String byD;
    private TextView hFF;
    private ImageView hFG;
    private FrameLayout hFH;
    private TextView hFI;
    private ImageView hFJ;
    private ImageView hFK;
    private View hFL;
    private Animation hFM;
    private com.baidu.tbadk.core.dialog.a hFN;
    private CountDownTimer hFO;
    private CountDownTimer hFP;
    private CountDownTimer hFQ;
    private boolean hFR;
    private boolean hFS;
    private a hFT;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.hFT = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hFN = null;
        this.hFO = null;
        this.hFP = null;
        this.hFQ = null;
        this.hFR = true;
        this.hFS = false;
        this.byD = null;
        this.hFT = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hFN = null;
        this.hFO = null;
        this.hFP = null;
        this.hFQ = null;
        this.hFR = true;
        this.hFS = false;
        this.byD = null;
        this.hFT = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hFN = null;
        this.hFO = null;
        this.hFP = null;
        this.hFQ = null;
        this.hFR = true;
        this.hFS = false;
        this.byD = null;
        this.hFT = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.hFF = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.hFH = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.hFG = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.hFK = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.hFI = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.hFJ = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.hFL = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, d.C0277d.cp_link_tip_a);
        al.j(this.hFF, d.C0277d.cp_cont_g);
        al.k(this.hFJ, d.f.icon_interview_loding);
        al.j(this.hFI, d.C0277d.cp_cont_g);
        al.k(this.hFG, d.f.icon_interview_mic);
        al.k(this.hFK, d.f.icon_arrow_tip_white);
        al.l(this.hFL, d.C0277d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.byD = dVar.bHW().Yu().Yl();
        if (StringUtils.isNull(this.byD)) {
            this.byD = dVar.bHW().Yu().getTaskId();
        }
        this.hFR = !"from_interview_live".equals(pbActivity.bJT());
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
                    this.hFO = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hFT != null) {
                        this.hFT.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bJ(VideoPlayActivityConfig.OBJ_ID, this.byD));
                    this.mRootView.setVisibility(0);
                    if (this.hFT != null) {
                        this.hFT.O(true);
                    }
                    this.hFF.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.hFF.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.hFG.setVisibility(8);
                    this.hFK.setVisibility(8);
                    this.hFL.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hFJ, au(pbActivity), null);
                    if (this.hFP != null) {
                        this.hFP.cancel();
                    }
                    this.hFP = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hFI.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bJ(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.byD));
                            PbInterviewStatusView.this.hFR = false;
                            PbInterviewStatusView.this.hFF.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.hFF.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.hFG.setVisibility(0);
                            PbInterviewStatusView.this.hFL.setVisibility(8);
                            PbInterviewStatusView.this.hFK.setVisibility(0);
                            PbInterviewStatusView.this.hFH.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hFS = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hFT != null) {
                    this.hFT.O(true);
                }
                this.hFG.setVisibility(8);
                this.hFK.setVisibility(8);
                this.hFH.setVisibility(8);
                this.hFL.setVisibility(0);
                this.hFF.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                al.l(this.mRootView, d.C0277d.cp_bg_line_e);
                al.j(this.hFF, d.C0277d.cp_cont_f);
                al.l(this.hFL, d.C0277d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Zw == 2) {
                    this.hFF.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.hFR) {
                        at(pbActivity);
                        return;
                    }
                    return;
                }
                this.hFF.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            this.hFN = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hFN.az(inflate);
            this.hFN.a((String) null, (a.b) null);
            this.hFN.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hFQ != null) {
                        PbInterviewStatusView.this.hFQ.cancel();
                    }
                    if (PbInterviewStatusView.this.hFN != null) {
                        PbInterviewStatusView.this.hFN.dismiss();
                    }
                }
            });
            this.hFN.dq(false);
            this.hFN.b(pbActivity.getPageContext());
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hFN != null) {
                        PbInterviewStatusView.this.hFN.aaW();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hFQ = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hFN != null) {
                        PbInterviewStatusView.this.hFN.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bJS();
                    }
                }
            }.start();
        }
    }

    private Animation au(PbActivity pbActivity) {
        if (this.hFM == null) {
            this.hFM = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.hFM.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hFM.setInterpolator(new LinearInterpolator());
            this.hFM.setFillAfter(true);
        }
        return this.hFM;
    }

    public boolean getIndicateStatus() {
        return this.hFS;
    }

    public void clearStatus() {
        if (this.hFO != null) {
            this.hFO.cancel();
            this.hFO = null;
        }
        if (this.hFP != null) {
            this.hFP.cancel();
            this.hFP = null;
        }
        if (this.hFQ != null) {
            this.hFQ.cancel();
            this.hFQ = null;
        }
        if (this.hFN != null) {
            this.hFN.dismiss();
            this.hFN = null;
        }
    }
}
