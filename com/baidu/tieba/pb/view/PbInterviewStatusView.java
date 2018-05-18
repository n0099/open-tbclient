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
    private String XN;
    private TextView fyH;
    private ImageView fyI;
    private FrameLayout fyJ;
    private TextView fyK;
    private ImageView fyL;
    private ImageView fyM;
    private View fyN;
    private Animation fyO;
    private com.baidu.tbadk.core.dialog.a fyP;
    private CountDownTimer fyQ;
    private CountDownTimer fyR;
    private CountDownTimer fyS;
    private boolean fyT;
    private boolean fyU;
    private a fyV;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void q(boolean z);
    }

    public void setCallback(a aVar) {
        this.fyV = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fyP = null;
        this.fyQ = null;
        this.fyR = null;
        this.fyS = null;
        this.fyT = true;
        this.fyU = false;
        this.XN = null;
        this.fyV = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fyP = null;
        this.fyQ = null;
        this.fyR = null;
        this.fyS = null;
        this.fyT = true;
        this.fyU = false;
        this.XN = null;
        this.fyV = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fyP = null;
        this.fyQ = null;
        this.fyR = null;
        this.fyS = null;
        this.fyT = true;
        this.fyU = false;
        this.XN = null;
        this.fyV = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.i.pb_interview_status, (ViewGroup) this, true);
        this.fyH = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fyJ = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fyI = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fyM = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fyK = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fyL = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fyN = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ak.j(this.mRootView, d.C0126d.cp_link_tip_a);
        ak.h(this.fyH, d.C0126d.cp_cont_g);
        ak.i(this.fyL, d.f.icon_interview_loding);
        ak.h(this.fyK, d.C0126d.cp_cont_g);
        ak.i(this.fyI, d.f.icon_interview_mic);
        ak.i(this.fyM, d.f.icon_arrow_tip_white);
        ak.j(this.fyN, d.C0126d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.XN = dVar.aVs().rz().qv();
        if (StringUtils.isNull(this.XN)) {
            this.XN = dVar.aVs().rz().getTaskId();
        }
        this.fyT = !"from_interview_live".equals(pbActivity.aXs());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int sp = dVar.aVs().sp();
        switch (sp) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.aVs().rz().ru()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fyQ = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fyV != null) {
                        this.fyV.q(false);
                    }
                } else {
                    TiebaStatic.log(new al("c11105").ac(VideoPlayActivityConfig.OBJ_ID, this.XN));
                    this.mRootView.setVisibility(0);
                    if (this.fyV != null) {
                        this.fyV.q(true);
                    }
                    this.fyH.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_before_start));
                    this.fyH.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fyI.setVisibility(8);
                    this.fyM.setVisibility(8);
                    this.fyN.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fyL, as(pbActivity), null);
                    if (this.fyR != null) {
                        this.fyR.cancel();
                    }
                    this.fyR = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fyK.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new al("c11106").ac(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.XN));
                            PbInterviewStatusView.this.fyT = false;
                            PbInterviewStatusView.this.fyH.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_start));
                            PbInterviewStatusView.this.fyH.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fyI.setVisibility(0);
                            PbInterviewStatusView.this.fyN.setVisibility(8);
                            PbInterviewStatusView.this.fyM.setVisibility(0);
                            PbInterviewStatusView.this.fyJ.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fyU = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fyV != null) {
                    this.fyV.q(true);
                }
                this.fyI.setVisibility(8);
                this.fyM.setVisibility(8);
                this.fyJ.setVisibility(8);
                this.fyN.setVisibility(0);
                this.fyH.setTextSize(0, l.e(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                ak.j(this.mRootView, d.C0126d.cp_bg_line_e);
                ak.h(this.fyH, d.C0126d.cp_cont_f);
                ak.j(this.fyN, d.C0126d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sp == 2) {
                    this.fyH.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_in_process));
                    if (this.fyT) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.fyH.setText(pbActivity.getPageContext().getPageActivity().getString(d.k.interview_live_finished));
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
            this.fyP = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fyP.w(inflate);
            this.fyP.a((String) null, (a.b) null);
            this.fyP.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fyS != null) {
                        PbInterviewStatusView.this.fyS.cancel();
                    }
                    if (PbInterviewStatusView.this.fyP != null) {
                        PbInterviewStatusView.this.fyP.dismiss();
                    }
                }
            });
            this.fyP.ar(false);
            this.fyP.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fyP != null) {
                        PbInterviewStatusView.this.fyP.tC();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fyS = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fyP != null) {
                        PbInterviewStatusView.this.fyP.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aXr();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.fyO == null) {
            this.fyO = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fyO.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fyO.setInterpolator(new LinearInterpolator());
            this.fyO.setFillAfter(true);
        }
        return this.fyO;
    }

    public boolean getIndicateStatus() {
        return this.fyU;
    }

    public void clearStatus() {
        if (this.fyQ != null) {
            this.fyQ.cancel();
            this.fyQ = null;
        }
        if (this.fyR != null) {
            this.fyR.cancel();
            this.fyR = null;
        }
        if (this.fyS != null) {
            this.fyS.cancel();
            this.fyS = null;
        }
        if (this.fyP != null) {
            this.fyP.dismiss();
            this.fyP = null;
        }
    }
}
