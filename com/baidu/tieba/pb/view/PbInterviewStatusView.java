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
    private String arh;
    private TextView goI;
    private ImageView goJ;
    private FrameLayout goK;
    private TextView goL;
    private ImageView goM;
    private ImageView goN;
    private View goO;
    private Animation goP;
    private com.baidu.tbadk.core.dialog.a goQ;
    private CountDownTimer goR;
    private CountDownTimer goS;
    private CountDownTimer goT;
    private boolean goU;
    private boolean goV;
    private a goW;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.goW = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.goQ = null;
        this.goR = null;
        this.goS = null;
        this.goT = null;
        this.goU = true;
        this.goV = false;
        this.arh = null;
        this.goW = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.goQ = null;
        this.goR = null;
        this.goS = null;
        this.goT = null;
        this.goU = true;
        this.goV = false;
        this.arh = null;
        this.goW = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.goQ = null;
        this.goR = null;
        this.goS = null;
        this.goT = null;
        this.goU = true;
        this.goV = false;
        this.arh = null;
        this.goW = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.goI = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.goK = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.goJ = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.goN = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.goL = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.goM = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.goO = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.goI, e.d.cp_cont_g);
        al.i(this.goM, e.f.icon_interview_loding);
        al.h(this.goL, e.d.cp_cont_g);
        al.i(this.goJ, e.f.icon_interview_mic);
        al.i(this.goN, e.f.icon_arrow_tip_white);
        al.j(this.goO, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.arh = dVar.bgV().zn().yg();
        if (StringUtils.isNull(this.arh)) {
            this.arh = dVar.bgV().zn().getTaskId();
        }
        this.goU = !"from_interview_live".equals(pbActivity.biW());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Ai = dVar.bgV().Ai();
        switch (Ai) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bgV().zn().zi()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.goR = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.goW != null) {
                        this.goW.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").aA(VideoPlayActivityConfig.OBJ_ID, this.arh));
                    this.mRootView.setVisibility(0);
                    if (this.goW != null) {
                        this.goW.O(true);
                    }
                    this.goI.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.goI.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize24));
                    this.goJ.setVisibility(8);
                    this.goN.setVisibility(8);
                    this.goO.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.goM, as(pbActivity), null);
                    if (this.goS != null) {
                        this.goS.cancel();
                    }
                    this.goS = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.goL.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").aA(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.arh));
                            PbInterviewStatusView.this.goU = false;
                            PbInterviewStatusView.this.goI.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.goI.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize24));
                            PbInterviewStatusView.this.goJ.setVisibility(0);
                            PbInterviewStatusView.this.goO.setVisibility(8);
                            PbInterviewStatusView.this.goN.setVisibility(0);
                            PbInterviewStatusView.this.goK.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.goV = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.goW != null) {
                    this.goW.O(true);
                }
                this.goJ.setVisibility(8);
                this.goN.setVisibility(8);
                this.goK.setVisibility(8);
                this.goO.setVisibility(0);
                this.goI.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0210e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.goI, e.d.cp_cont_f);
                al.j(this.goO, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Ai == 2) {
                    this.goI.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.goU) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.goI.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ar(final PbActivity pbActivity) {
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
            this.goQ = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.goQ.G(inflate);
            this.goQ.a((String) null, (a.b) null);
            this.goQ.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.goT != null) {
                        PbInterviewStatusView.this.goT.cancel();
                    }
                    if (PbInterviewStatusView.this.goQ != null) {
                        PbInterviewStatusView.this.goQ.dismiss();
                    }
                }
            });
            this.goQ.bf(false);
            this.goQ.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.goQ != null) {
                        PbInterviewStatusView.this.goQ.BF();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.goT = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.goQ != null) {
                        PbInterviewStatusView.this.goQ.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.biV();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.goP == null) {
            this.goP = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.goP.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.goP.setInterpolator(new LinearInterpolator());
            this.goP.setFillAfter(true);
        }
        return this.goP;
    }

    public boolean getIndicateStatus() {
        return this.goV;
    }

    public void clearStatus() {
        if (this.goR != null) {
            this.goR.cancel();
            this.goR = null;
        }
        if (this.goS != null) {
            this.goS.cancel();
            this.goS = null;
        }
        if (this.goT != null) {
            this.goT.cancel();
            this.goT = null;
        }
        if (this.goQ != null) {
            this.goQ.dismiss();
            this.goQ = null;
        }
    }
}
