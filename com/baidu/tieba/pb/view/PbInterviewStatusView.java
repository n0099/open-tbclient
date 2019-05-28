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
    private TextView hXJ;
    private ImageView hXK;
    private FrameLayout hXL;
    private TextView hXM;
    private ImageView hXN;
    private ImageView hXO;
    private View hXP;
    private Animation hXQ;
    private com.baidu.tbadk.core.dialog.a hXR;
    private CountDownTimer hXS;
    private CountDownTimer hXT;
    private CountDownTimer hXU;
    private boolean hXV;
    private boolean hXW;
    private a hXX;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void G(boolean z);
    }

    public void setCallback(a aVar) {
        this.hXX = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hXR = null;
        this.hXS = null;
        this.hXT = null;
        this.hXU = null;
        this.hXV = true;
        this.hXW = false;
        this.bFP = null;
        this.hXX = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hXR = null;
        this.hXS = null;
        this.hXT = null;
        this.hXU = null;
        this.hXV = true;
        this.hXW = false;
        this.bFP = null;
        this.hXX = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hXR = null;
        this.hXS = null;
        this.hXT = null;
        this.hXU = null;
        this.hXV = true;
        this.hXW = false;
        this.bFP = null;
        this.hXX = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.hXJ = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.hXL = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.hXK = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.hXO = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.hXM = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.hXN = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.hXP = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, R.color.cp_link_tip_a);
        al.j(this.hXJ, R.color.cp_cont_g);
        al.k(this.hXN, R.drawable.icon_interview_loding);
        al.j(this.hXM, R.color.cp_cont_g);
        al.k(this.hXK, R.drawable.icon_interview_mic);
        al.k(this.hXO, R.drawable.icon_arrow_tip_white);
        al.l(this.hXP, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bFP = dVar.bPL().adb().acS();
        if (StringUtils.isNull(this.bFP)) {
            this.bFP = dVar.bPL().adb().getTaskId();
        }
        this.hXV = !"from_interview_live".equals(pbActivity.bRN());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int aed = dVar.bPL().aed();
        switch (aed) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bPL().adb().acO()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.hXS = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hXX != null) {
                        this.hXX.G(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bT(VideoPlayActivityConfig.OBJ_ID, this.bFP));
                    this.mRootView.setVisibility(0);
                    if (this.hXX != null) {
                        this.hXX.G(true);
                    }
                    this.hXJ.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.hXJ.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.hXK.setVisibility(8);
                    this.hXO.setVisibility(8);
                    this.hXP.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hXN, aw(pbActivity), null);
                    if (this.hXT != null) {
                        this.hXT.cancel();
                    }
                    this.hXT = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hXM.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bT(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.bFP));
                            PbInterviewStatusView.this.hXV = false;
                            PbInterviewStatusView.this.hXJ.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.hXJ.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.hXK.setVisibility(0);
                            PbInterviewStatusView.this.hXP.setVisibility(8);
                            PbInterviewStatusView.this.hXO.setVisibility(0);
                            PbInterviewStatusView.this.hXL.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hXW = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hXX != null) {
                    this.hXX.G(true);
                }
                this.hXK.setVisibility(8);
                this.hXO.setVisibility(8);
                this.hXL.setVisibility(8);
                this.hXP.setVisibility(0);
                this.hXJ.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                al.l(this.mRootView, R.color.cp_bg_line_e);
                al.j(this.hXJ, R.color.cp_cont_f);
                al.l(this.hXP, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aed == 2) {
                    this.hXJ.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.hXV) {
                        av(pbActivity);
                        return;
                    }
                    return;
                }
                this.hXJ.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.hXR = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hXR.aF(inflate);
            this.hXR.a((String) null, (a.b) null);
            this.hXR.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hXU != null) {
                        PbInterviewStatusView.this.hXU.cancel();
                    }
                    if (PbInterviewStatusView.this.hXR != null) {
                        PbInterviewStatusView.this.hXR.dismiss();
                    }
                }
            });
            this.hXR.dM(false);
            this.hXR.b(pbActivity.getPageContext());
            e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hXR != null) {
                        PbInterviewStatusView.this.hXR.afG();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hXU = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hXR != null) {
                        PbInterviewStatusView.this.hXR.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bRM();
                    }
                }
            }.start();
        }
    }

    private Animation aw(PbActivity pbActivity) {
        if (this.hXQ == null) {
            this.hXQ = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.hXQ.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hXQ.setInterpolator(new LinearInterpolator());
            this.hXQ.setFillAfter(true);
        }
        return this.hXQ;
    }

    public boolean getIndicateStatus() {
        return this.hXW;
    }

    public void clearStatus() {
        if (this.hXS != null) {
            this.hXS.cancel();
            this.hXS = null;
        }
        if (this.hXT != null) {
            this.hXT.cancel();
            this.hXT = null;
        }
        if (this.hXU != null) {
            this.hXU.cancel();
            this.hXU = null;
        }
        if (this.hXR != null) {
            this.hXR.dismiss();
            this.hXR = null;
        }
    }
}
