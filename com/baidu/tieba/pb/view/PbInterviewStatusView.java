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
    private String byA;
    private TextView hFT;
    private ImageView hFU;
    private FrameLayout hFV;
    private TextView hFW;
    private ImageView hFX;
    private ImageView hFY;
    private View hFZ;
    private Animation hGa;
    private com.baidu.tbadk.core.dialog.a hGb;
    private CountDownTimer hGc;
    private CountDownTimer hGd;
    private CountDownTimer hGe;
    private boolean hGf;
    private boolean hGg;
    private a hGh;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.hGh = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.hGb = null;
        this.hGc = null;
        this.hGd = null;
        this.hGe = null;
        this.hGf = true;
        this.hGg = false;
        this.byA = null;
        this.hGh = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.hGb = null;
        this.hGc = null;
        this.hGd = null;
        this.hGe = null;
        this.hGf = true;
        this.hGg = false;
        this.byA = null;
        this.hGh = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.hGb = null;
        this.hGc = null;
        this.hGd = null;
        this.hGe = null;
        this.hGf = true;
        this.hGg = false;
        this.byA = null;
        this.hGh = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.hFT = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.hFV = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.hFU = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.hFY = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.hFW = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.hFX = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.hFZ = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.l(this.mRootView, d.C0277d.cp_link_tip_a);
        al.j(this.hFT, d.C0277d.cp_cont_g);
        al.k(this.hFX, d.f.icon_interview_loding);
        al.j(this.hFW, d.C0277d.cp_cont_g);
        al.k(this.hFU, d.f.icon_interview_mic);
        al.k(this.hFY, d.f.icon_arrow_tip_white);
        al.l(this.hFZ, d.C0277d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.byA = dVar.bHZ().Yx().Yo();
        if (StringUtils.isNull(this.byA)) {
            this.byA = dVar.bHZ().Yx().getTaskId();
        }
        this.hGf = !"from_interview_live".equals(pbActivity.bJW());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int Zz = dVar.bHZ().Zz();
        switch (Zz) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bHZ().Yx().Yk()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.hGc = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.hGh != null) {
                        this.hGh.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").bJ(VideoPlayActivityConfig.OBJ_ID, this.byA));
                    this.mRootView.setVisibility(0);
                    if (this.hGh != null) {
                        this.hGh.O(true);
                    }
                    this.hFT.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.hFT.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.hFU.setVisibility(8);
                    this.hFY.setVisibility(8);
                    this.hFZ.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.hFX, au(pbActivity), null);
                    if (this.hGd != null) {
                        this.hGd.cancel();
                    }
                    this.hGd = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.hFW.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").bJ(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.byA));
                            PbInterviewStatusView.this.hGf = false;
                            PbInterviewStatusView.this.hFT.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.hFT.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.hFU.setVisibility(0);
                            PbInterviewStatusView.this.hFZ.setVisibility(8);
                            PbInterviewStatusView.this.hFY.setVisibility(0);
                            PbInterviewStatusView.this.hFV.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.hGg = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.hGh != null) {
                    this.hGh.O(true);
                }
                this.hFU.setVisibility(8);
                this.hFY.setVisibility(8);
                this.hFV.setVisibility(8);
                this.hFZ.setVisibility(0);
                this.hFT.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                al.l(this.mRootView, d.C0277d.cp_bg_line_e);
                al.j(this.hFT, d.C0277d.cp_cont_f);
                al.l(this.hFZ, d.C0277d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (Zz == 2) {
                    this.hFT.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.hGf) {
                        at(pbActivity);
                        return;
                    }
                    return;
                }
                this.hFT.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            this.hGb = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.hGb.az(inflate);
            this.hGb.a((String) null, (a.b) null);
            this.hGb.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.hGe != null) {
                        PbInterviewStatusView.this.hGe.cancel();
                    }
                    if (PbInterviewStatusView.this.hGb != null) {
                        PbInterviewStatusView.this.hGb.dismiss();
                    }
                }
            });
            this.hGb.dq(false);
            this.hGb.b(pbActivity.getPageContext());
            e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.hGb != null) {
                        PbInterviewStatusView.this.hGb.aaZ();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.hGe = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.hGb != null) {
                        PbInterviewStatusView.this.hGb.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bJV();
                    }
                }
            }.start();
        }
    }

    private Animation au(PbActivity pbActivity) {
        if (this.hGa == null) {
            this.hGa = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.hGa.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.hGa.setInterpolator(new LinearInterpolator());
            this.hGa.setFillAfter(true);
        }
        return this.hGa;
    }

    public boolean getIndicateStatus() {
        return this.hGg;
    }

    public void clearStatus() {
        if (this.hGc != null) {
            this.hGc.cancel();
            this.hGc = null;
        }
        if (this.hGd != null) {
            this.hGd.cancel();
            this.hGd = null;
        }
        if (this.hGe != null) {
            this.hGe.cancel();
            this.hGe = null;
        }
        if (this.hGb != null) {
            this.hGb.dismiss();
            this.hGb = null;
        }
    }
}
