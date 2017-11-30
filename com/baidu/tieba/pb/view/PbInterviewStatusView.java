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
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String WL;
    private TextView fkl;
    private ImageView fkm;
    private FrameLayout fkn;
    private TextView fko;
    private ImageView fkp;
    private ImageView fkq;
    private View fkr;
    private Animation fks;
    private com.baidu.tbadk.core.dialog.a fkt;
    private CountDownTimer fku;
    private CountDownTimer fkv;
    private CountDownTimer fkw;
    private boolean fkx;
    private boolean fky;
    private a fkz;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.fkz = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fkt = null;
        this.fku = null;
        this.fkv = null;
        this.fkw = null;
        this.fkx = true;
        this.fky = false;
        this.WL = null;
        this.fkz = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fkt = null;
        this.fku = null;
        this.fkv = null;
        this.fkw = null;
        this.fkx = true;
        this.fky = false;
        this.WL = null;
        this.fkz = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fkt = null;
        this.fku = null;
        this.fkv = null;
        this.fkw = null;
        this.fkx = true;
        this.fky = false;
        this.WL = null;
        this.fkz = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.fkl = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.fkn = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.fkm = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.fkq = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.fko = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.fkp = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.fkr = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.k(this.mRootView, d.C0082d.cp_link_tip_a);
        aj.i(this.fkl, d.C0082d.cp_cont_g);
        aj.j(this.fkp, d.f.icon_interview_loding);
        aj.i(this.fko, d.C0082d.cp_cont_g);
        aj.j(this.fkm, d.f.icon_interview_mic);
        aj.j(this.fkq, d.f.icon_arrow_tip_white);
        aj.k(this.fkr, d.C0082d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.WL = fVar.aRh().rd().pI();
        if (StringUtils.isNull(this.WL)) {
            this.WL = fVar.aRh().rd().getTaskId();
        }
        this.fkx = !"from_interview_live".equals(pbActivity.aTo());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int rZ = fVar.aRh().rZ();
        switch (rZ) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aRh().rd().qX()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fku = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fkz != null) {
                        this.fkz.p(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ac("obj_id", this.WL));
                    this.mRootView.setVisibility(0);
                    if (this.fkz != null) {
                        this.fkz.p(true);
                    }
                    this.fkl.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.fkl.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.fkm.setVisibility(8);
                    this.fkq.setVisibility(8);
                    this.fkr.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fkp, aq(pbActivity), null);
                    if (this.fkv != null) {
                        this.fkv.cancel();
                    }
                    this.fkv = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fko.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ac("obj_id", PbInterviewStatusView.this.WL));
                            PbInterviewStatusView.this.fkx = false;
                            PbInterviewStatusView.this.fkl.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.fkl.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.fkm.setVisibility(0);
                            PbInterviewStatusView.this.fkr.setVisibility(8);
                            PbInterviewStatusView.this.fkq.setVisibility(0);
                            PbInterviewStatusView.this.fkn.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fky = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fkz != null) {
                    this.fkz.p(true);
                }
                this.fkm.setVisibility(8);
                this.fkq.setVisibility(8);
                this.fkn.setVisibility(8);
                this.fkr.setVisibility(0);
                this.fkl.setTextSize(0, l.f(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.k(this.mRootView, d.C0082d.cp_bg_line_e);
                aj.i(this.fkl, d.C0082d.cp_cont_f);
                aj.k(this.fkr, d.C0082d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rZ == 2) {
                    this.fkl.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.fkx) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.fkl.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            aj.j((ImageView) inflate.findViewById(d.g.pop_live), d.f.pic_pop_live_n);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0082d.cp_cont_b);
            aj.i((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0082d.cp_cont_b);
            aj.k(findViewById, d.C0082d.cp_bg_line_a);
            aj.k(findViewById2, d.C0082d.cp_bg_line_a);
            aj.i(textView, d.C0082d.cp_cont_f);
            this.fkt = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fkt.v(inflate);
            this.fkt.a((String) null, (a.b) null);
            this.fkt.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fkw != null) {
                        PbInterviewStatusView.this.fkw.cancel();
                    }
                    if (PbInterviewStatusView.this.fkt != null) {
                        PbInterviewStatusView.this.fkt.dismiss();
                    }
                }
            });
            this.fkt.ao(false);
            this.fkt.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fkt != null) {
                        PbInterviewStatusView.this.fkt.tk();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fkw = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fkt != null) {
                        PbInterviewStatusView.this.fkt.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aTm();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.fks == null) {
            this.fks = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fks.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fks.setInterpolator(new LinearInterpolator());
            this.fks.setFillAfter(true);
        }
        return this.fks;
    }

    public boolean getIndicateStatus() {
        return this.fky;
    }

    public void clearStatus() {
        if (this.fku != null) {
            this.fku.cancel();
            this.fku = null;
        }
        if (this.fkv != null) {
            this.fkv.cancel();
            this.fkv = null;
        }
        if (this.fkw != null) {
            this.fkw.cancel();
            this.fkw = null;
        }
        if (this.fkt != null) {
            this.fkt.dismiss();
            this.fkt = null;
        }
    }
}
