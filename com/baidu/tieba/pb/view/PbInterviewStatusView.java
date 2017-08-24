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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String WL;
    private TextView fbb;
    private ImageView fbc;
    private FrameLayout fbd;
    private TextView fbe;
    private ImageView fbf;
    private ImageView fbg;
    private View fbh;
    private Animation fbi;
    private com.baidu.tbadk.core.dialog.a fbj;
    private CountDownTimer fbk;
    private CountDownTimer fbl;
    private CountDownTimer fbm;
    private boolean fbn;
    private boolean fbo;
    private a fbp;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.fbp = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = null;
        this.fbm = null;
        this.fbn = true;
        this.fbo = false;
        this.WL = null;
        this.fbp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = null;
        this.fbm = null;
        this.fbn = true;
        this.fbo = false;
        this.WL = null;
        this.fbp = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = null;
        this.fbm = null;
        this.fbn = true;
        this.fbo = false;
        this.WL = null;
        this.fbp = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.fbb = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.fbd = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.fbc = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.fbg = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.fbe = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.fbf = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.fbh = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ai.k(this.mRootView, d.e.cp_link_tip_a);
        ai.i(this.fbb, d.e.cp_cont_g);
        ai.j(this.fbf, d.g.icon_interview_loding);
        ai.i(this.fbe, d.e.cp_cont_g);
        ai.j(this.fbc, d.g.icon_interview_mic);
        ai.j(this.fbg, d.g.icon_arrow_tip_white);
        ai.k(this.fbh, d.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.WL = fVar.aPL().ro().pI();
        if (StringUtils.isNull(this.WL)) {
            this.WL = fVar.aPL().ro().getTaskId();
        }
        this.fbn = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aRt());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int si = fVar.aPL().si();
        switch (si) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aPL().ro().rh()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fbk = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fbp != null) {
                        this.fbp.p(false);
                    }
                } else {
                    TiebaStatic.log(new aj("c11105").aa("obj_id", this.WL));
                    this.mRootView.setVisibility(0);
                    if (this.fbp != null) {
                        this.fbp.p(true);
                    }
                    this.fbb.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.fbb.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.fbc.setVisibility(8);
                    this.fbg.setVisibility(8);
                    this.fbh.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fbf, as(pbActivity), (Animation.AnimationListener) null);
                    if (this.fbl != null) {
                        this.fbl.cancel();
                    }
                    this.fbl = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fbe.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aj("c11106").aa("obj_id", PbInterviewStatusView.this.WL));
                            PbInterviewStatusView.this.fbn = false;
                            PbInterviewStatusView.this.fbb.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.fbb.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.fbc.setVisibility(0);
                            PbInterviewStatusView.this.fbh.setVisibility(8);
                            PbInterviewStatusView.this.fbg.setVisibility(0);
                            PbInterviewStatusView.this.fbd.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fbo = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fbp != null) {
                    this.fbp.p(true);
                }
                this.fbc.setVisibility(8);
                this.fbg.setVisibility(8);
                this.fbd.setVisibility(8);
                this.fbh.setVisibility(0);
                this.fbb.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                ai.k(this.mRootView, d.e.cp_bg_line_e);
                ai.i(this.fbb, d.e.cp_cont_f);
                ai.k(this.fbh, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (si == 2) {
                    this.fbb.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.fbn) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.fbb.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void ar(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(d.j.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(d.h.transfer_count_down);
            View findViewById = inflate.findViewById(d.h.line_left);
            View findViewById2 = inflate.findViewById(d.h.line_right);
            ai.j((ImageView) inflate.findViewById(d.h.pop_live), d.g.pic_pop_live_n);
            ai.i((TextView) inflate.findViewById(d.h.transfer_tip_txt), d.e.cp_cont_b);
            ai.i((TextView) inflate.findViewById(d.h.transfer_tip_txt_1), d.e.cp_cont_b);
            ai.k(findViewById, d.e.cp_bg_line_a);
            ai.k(findViewById2, d.e.cp_bg_line_a);
            ai.i(textView, d.e.cp_cont_f);
            this.fbj = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fbj.v(inflate);
            this.fbj.a((String) null, (a.b) null);
            this.fbj.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fbm != null) {
                        PbInterviewStatusView.this.fbm.cancel();
                    }
                    if (PbInterviewStatusView.this.fbj != null) {
                        PbInterviewStatusView.this.fbj.dismiss();
                    }
                }
            });
            this.fbj.ar(false);
            this.fbj.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fbj != null) {
                        PbInterviewStatusView.this.fbj.ts();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fbm = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fbj != null) {
                        PbInterviewStatusView.this.fbj.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aRr();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.fbi == null) {
            this.fbi = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fbi.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fbi.setInterpolator(new LinearInterpolator());
            this.fbi.setFillAfter(true);
        }
        return this.fbi;
    }

    public boolean getIndicateStatus() {
        return this.fbo;
    }

    public void clearStatus() {
        if (this.fbk != null) {
            this.fbk.cancel();
            this.fbk = null;
        }
        if (this.fbl != null) {
            this.fbl.cancel();
            this.fbl = null;
        }
        if (this.fbm != null) {
            this.fbm.cancel();
            this.fbm = null;
        }
        if (this.fbj != null) {
            this.fbj.dismiss();
            this.fbj = null;
        }
    }
}
