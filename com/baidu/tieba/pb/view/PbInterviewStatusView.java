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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String bFP;
    private TextView hXG;
    private ImageView hXH;
    private FrameLayout hXI;
    private TextView hXJ;
    private ImageView hXK;
    private ImageView hXL;
    private View hXM;
    private Animation hXN;
    private com.baidu.tbadk.core.dialog.a hXO;
    private CountDownTimer hXP;
    private CountDownTimer hXQ;
    private CountDownTimer hXR;
    private boolean hXS;
    private boolean hXT;
    private a hXU;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void G(boolean z);
    }

    public void setCallback(a aVar) {
        this.hXU = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hXO = null;
        this.hXP = null;
        this.hXQ = null;
        this.hXR = null;
        this.hXS = true;
        this.hXT = false;
        this.bFP = null;
        this.hXU = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hXO = null;
        this.hXP = null;
        this.hXQ = null;
        this.hXR = null;
        this.hXS = true;
        this.hXT = false;
        this.bFP = null;
        this.hXU = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hXO = null;
        this.hXP = null;
        this.hXQ = null;
        this.hXR = null;
        this.hXS = true;
        this.hXT = false;
        this.bFP = null;
        this.hXU = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.hXG = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.hXI = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.hXH = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.hXL = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.hXJ = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.hXK = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.hXM = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, R.color.cp_link_tip_a);
        al.j(this.hXG, R.color.cp_cont_g);
        al.k(this.hXK, R.drawable.icon_interview_loding);
        al.j(this.hXJ, R.color.cp_cont_g);
        al.k(this.hXH, R.drawable.icon_interview_mic);
        al.k(this.hXL, R.drawable.icon_arrow_tip_white);
        al.l(this.hXM, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bFP = dVar.bPI().adb().acS();
        if (StringUtils.isNull(this.bFP)) {
            this.bFP = dVar.bPI().adb().getTaskId();
        }
        this.hXS = !"from_interview_live".equals(pbActivity.bRK());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int aed = dVar.bPI().aed();
        switch (aed) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bPI().adb().acO()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.hXP = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hXU != null) {
                        this.hXU.G(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bT(VideoPlayActivityConfig.OBJ_ID, this.bFP));
                    this.mRootView.setVisibility(0);
                    if (this.hXU != null) {
                        this.hXU.G(true);
                    }
                    this.hXG.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.hXG.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.hXH.setVisibility(8);
                    this.hXL.setVisibility(8);
                    this.hXM.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hXK, aw(pbActivity), null);
                    if (this.hXQ != null) {
                        this.hXQ.cancel();
                    }
                    this.hXQ = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hXJ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bT(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.bFP));
                            PbInterviewStatusView.this.hXS = false;
                            PbInterviewStatusView.this.hXG.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.hXG.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.hXH.setVisibility(0);
                            PbInterviewStatusView.this.hXM.setVisibility(8);
                            PbInterviewStatusView.this.hXL.setVisibility(0);
                            PbInterviewStatusView.this.hXI.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hXT = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hXU != null) {
                    this.hXU.G(true);
                }
                this.hXH.setVisibility(8);
                this.hXL.setVisibility(8);
                this.hXI.setVisibility(8);
                this.hXM.setVisibility(0);
                this.hXG.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                al.l(this.mRootView, R.color.cp_bg_line_e);
                al.j(this.hXG, R.color.cp_cont_f);
                al.l(this.hXM, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aed == 2) {
                    this.hXG.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.hXS) {
                        av(pbActivity);
                        return;
                    }
                    return;
                }
                this.hXG.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void av(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            al.k((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            al.j((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.cp_cont_b);
            al.j((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.cp_cont_b);
            al.l(findViewById, R.color.cp_bg_line_a);
            al.l(findViewById2, R.color.cp_bg_line_a);
            al.j(textView, R.color.cp_cont_f);
            this.hXO = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hXO.aF(inflate);
            this.hXO.a((String) null, (a.b) null);
            this.hXO.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hXR != null) {
                        PbInterviewStatusView.this.hXR.cancel();
                    }
                    if (PbInterviewStatusView.this.hXO != null) {
                        PbInterviewStatusView.this.hXO.dismiss();
                    }
                }
            });
            this.hXO.dM(false);
            this.hXO.b(pbActivity.getPageContext());
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hXO != null) {
                        PbInterviewStatusView.this.hXO.afG();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hXR = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hXO != null) {
                        PbInterviewStatusView.this.hXO.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bRJ();
                    }
                }
            }.start();
        }
    }

    private Animation aw(PbActivity pbActivity) {
        if (this.hXN == null) {
            this.hXN = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.hXN.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hXN.setInterpolator(new LinearInterpolator());
            this.hXN.setFillAfter(true);
        }
        return this.hXN;
    }

    public boolean getIndicateStatus() {
        return this.hXT;
    }

    public void clearStatus() {
        if (this.hXP != null) {
            this.hXP.cancel();
            this.hXP = null;
        }
        if (this.hXQ != null) {
            this.hXQ.cancel();
            this.hXQ = null;
        }
        if (this.hXR != null) {
            this.hXR.cancel();
            this.hXR = null;
        }
        if (this.hXO != null) {
            this.hXO.dismiss();
            this.hXO = null;
        }
    }
}
