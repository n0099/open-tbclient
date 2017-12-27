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
    private String aLg;
    private TextView fYk;
    private ImageView fYl;
    private FrameLayout fYm;
    private TextView fYn;
    private ImageView fYo;
    private ImageView fYp;
    private View fYq;
    private Animation fYr;
    private com.baidu.tbadk.core.dialog.a fYs;
    private CountDownTimer fYt;
    private CountDownTimer fYu;
    private CountDownTimer fYv;
    private boolean fYw;
    private boolean fYx;
    private a fYy;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void W(boolean z);
    }

    public void setCallback(a aVar) {
        this.fYy = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fYs = null;
        this.fYt = null;
        this.fYu = null;
        this.fYv = null;
        this.fYw = true;
        this.fYx = false;
        this.aLg = null;
        this.fYy = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fYs = null;
        this.fYt = null;
        this.fYu = null;
        this.fYv = null;
        this.fYw = true;
        this.fYx = false;
        this.aLg = null;
        this.fYy = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fYs = null;
        this.fYt = null;
        this.fYu = null;
        this.fYv = null;
        this.fYw = true;
        this.fYx = false;
        this.aLg = null;
        this.fYy = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.fYk = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fYm = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fYl = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fYp = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fYn = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fYo = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fYq = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.t(this.mRootView, d.C0108d.cp_link_tip_a);
        aj.r(this.fYk, d.C0108d.cp_cont_g);
        aj.s(this.fYo, d.f.icon_interview_loding);
        aj.r(this.fYn, d.C0108d.cp_cont_g);
        aj.s(this.fYl, d.f.icon_interview_mic);
        aj.s(this.fYp, d.f.icon_arrow_tip_white);
        aj.t(this.fYq, d.C0108d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.aLg = fVar.aYA().yD().xj();
        if (StringUtils.isNull(this.aLg)) {
            this.aLg = fVar.aYA().yD().getTaskId();
        }
        this.fYw = !"from_interview_live".equals(pbActivity.baJ());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int zz = fVar.aYA().zz();
        switch (zz) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aYA().yD().yx()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fYt = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fYy != null) {
                        this.fYy.W(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ab("obj_id", this.aLg));
                    this.mRootView.setVisibility(0);
                    if (this.fYy != null) {
                        this.fYy.W(true);
                    }
                    this.fYk.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.fYk.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fYl.setVisibility(8);
                    this.fYp.setVisibility(8);
                    this.fYq.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fYo, aq(pbActivity), null);
                    if (this.fYu != null) {
                        this.fYu.cancel();
                    }
                    this.fYu = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fYn.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ab("obj_id", PbInterviewStatusView.this.aLg));
                            PbInterviewStatusView.this.fYw = false;
                            PbInterviewStatusView.this.fYk.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.fYk.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fYl.setVisibility(0);
                            PbInterviewStatusView.this.fYq.setVisibility(8);
                            PbInterviewStatusView.this.fYp.setVisibility(0);
                            PbInterviewStatusView.this.fYm.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fYx = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fYy != null) {
                    this.fYy.W(true);
                }
                this.fYl.setVisibility(8);
                this.fYp.setVisibility(8);
                this.fYm.setVisibility(8);
                this.fYq.setVisibility(0);
                this.fYk.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.t(this.mRootView, d.C0108d.cp_bg_line_e);
                aj.r(this.fYk, d.C0108d.cp_cont_f);
                aj.t(this.fYq, d.C0108d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (zz == 2) {
                    this.fYk.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.fYw) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.fYk.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0108d.cp_cont_b);
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0108d.cp_cont_b);
            aj.t(findViewById, d.C0108d.cp_bg_line_a);
            aj.t(findViewById2, d.C0108d.cp_bg_line_a);
            aj.r(textView, d.C0108d.cp_cont_f);
            this.fYs = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fYs.aO(inflate);
            this.fYs.a((String) null, (a.b) null);
            this.fYs.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fYv != null) {
                        PbInterviewStatusView.this.fYv.cancel();
                    }
                    if (PbInterviewStatusView.this.fYs != null) {
                        PbInterviewStatusView.this.fYs.dismiss();
                    }
                }
            });
            this.fYs.aV(false);
            this.fYs.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.nr().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fYs != null) {
                        PbInterviewStatusView.this.fYs.AI();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fYv = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fYs != null) {
                        PbInterviewStatusView.this.fYs.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.baH();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.fYr == null) {
            this.fYr = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fYr.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fYr.setInterpolator(new LinearInterpolator());
            this.fYr.setFillAfter(true);
        }
        return this.fYr;
    }

    public boolean getIndicateStatus() {
        return this.fYx;
    }

    public void clearStatus() {
        if (this.fYt != null) {
            this.fYt.cancel();
            this.fYt = null;
        }
        if (this.fYu != null) {
            this.fYu.cancel();
            this.fYu = null;
        }
        if (this.fYv != null) {
            this.fYv.cancel();
            this.fYv = null;
        }
        if (this.fYs != null) {
            this.fYs.dismiss();
            this.fYs = null;
        }
    }
}
