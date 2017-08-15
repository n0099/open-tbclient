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
    private String WK;
    private TextView faZ;
    private ImageView fba;
    private FrameLayout fbb;
    private TextView fbc;
    private ImageView fbd;
    private ImageView fbe;
    private View fbf;
    private Animation fbg;
    private com.baidu.tbadk.core.dialog.a fbh;
    private CountDownTimer fbi;
    private CountDownTimer fbj;
    private CountDownTimer fbk;
    private boolean fbl;
    private boolean fbm;
    private a fbn;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void p(boolean z);
    }

    public void setCallback(a aVar) {
        this.fbn = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.fbh = null;
        this.fbi = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = true;
        this.fbm = false;
        this.WK = null;
        this.fbn = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.fbh = null;
        this.fbi = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = true;
        this.fbm = false;
        this.WK = null;
        this.fbn = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.fbh = null;
        this.fbi = null;
        this.fbj = null;
        this.fbk = null;
        this.fbl = true;
        this.fbm = false;
        this.WK = null;
        this.fbn = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.j.pb_interview_status, (ViewGroup) this, true);
        this.faZ = (TextView) this.mRootView.findViewById(d.h.interview_live_status_btn);
        this.fbb = (FrameLayout) this.mRootView.findViewById(d.h.count_container);
        this.fba = (ImageView) this.mRootView.findViewById(d.h.interview_mic);
        this.fbe = (ImageView) this.mRootView.findViewById(d.h.interview_arrow);
        this.fbc = (TextView) this.mRootView.findViewById(d.h.count_text);
        this.fbd = (ImageView) this.mRootView.findViewById(d.h.count_bg);
        this.fbf = this.mRootView.findViewById(d.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ai.k(this.mRootView, d.e.cp_link_tip_a);
        ai.i(this.faZ, d.e.cp_cont_g);
        ai.j(this.fbd, d.g.icon_interview_loding);
        ai.i(this.fbc, d.e.cp_cont_g);
        ai.j(this.fba, d.g.icon_interview_mic);
        ai.j(this.fbe, d.g.icon_arrow_tip_white);
        ai.k(this.fbf, d.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.WK = fVar.aPQ().rn().pH();
        if (StringUtils.isNull(this.WK)) {
            this.WK = fVar.aPQ().rn().getTaskId();
        }
        this.fbl = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aRy());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int sh = fVar.aPQ().sh();
        switch (sh) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aPQ().rn().rg()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.fbi = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.fbn != null) {
                        this.fbn.p(false);
                    }
                } else {
                    TiebaStatic.log(new aj("c11105").aa("obj_id", this.WK));
                    this.mRootView.setVisibility(0);
                    if (this.fbn != null) {
                        this.fbn.p(true);
                    }
                    this.faZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_before_start));
                    this.faZ.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                    this.fba.setVisibility(8);
                    this.fbe.setVisibility(8);
                    this.fbf.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.fbd, as(pbActivity), (Animation.AnimationListener) null);
                    if (this.fbj != null) {
                        this.fbj.cancel();
                    }
                    this.fbj = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.fbc.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new aj("c11106").aa("obj_id", PbInterviewStatusView.this.WK));
                            PbInterviewStatusView.this.fbl = false;
                            PbInterviewStatusView.this.faZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_start));
                            PbInterviewStatusView.this.faZ.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize24));
                            PbInterviewStatusView.this.fba.setVisibility(0);
                            PbInterviewStatusView.this.fbf.setVisibility(8);
                            PbInterviewStatusView.this.fbe.setVisibility(0);
                            PbInterviewStatusView.this.fbb.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.fbm = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.fbn != null) {
                    this.fbn.p(true);
                }
                this.fba.setVisibility(8);
                this.fbe.setVisibility(8);
                this.fbb.setVisibility(8);
                this.fbf.setVisibility(0);
                this.faZ.setTextSize(0, k.g(pbActivity.getPageContext().getPageActivity(), d.f.fontsize28));
                ai.k(this.mRootView, d.e.cp_bg_line_e);
                ai.i(this.faZ, d.e.cp_cont_f);
                ai.k(this.fbf, d.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (sh == 2) {
                    this.faZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_in_process));
                    if (this.fbl) {
                        ar(pbActivity);
                        return;
                    }
                    return;
                }
                this.faZ.setText(pbActivity.getPageContext().getPageActivity().getString(d.l.interview_live_finished));
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
            this.fbh = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.fbh.v(inflate);
            this.fbh.a((String) null, (a.b) null);
            this.fbh.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.fbk != null) {
                        PbInterviewStatusView.this.fbk.cancel();
                    }
                    if (PbInterviewStatusView.this.fbh != null) {
                        PbInterviewStatusView.this.fbh.dismiss();
                    }
                }
            });
            this.fbh.ar(false);
            this.fbh.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.ga().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.fbh != null) {
                        PbInterviewStatusView.this.fbh.tr();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.fbk = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.fbh != null) {
                        PbInterviewStatusView.this.fbh.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.aRw();
                    }
                }
            }.start();
        }
    }

    private Animation as(PbActivity pbActivity) {
        if (this.fbg == null) {
            this.fbg = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.fbg.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.fbg.setInterpolator(new LinearInterpolator());
            this.fbg.setFillAfter(true);
        }
        return this.fbg;
    }

    public boolean getIndicateStatus() {
        return this.fbm;
    }

    public void clearStatus() {
        if (this.fbi != null) {
            this.fbi.cancel();
            this.fbi = null;
        }
        if (this.fbj != null) {
            this.fbj.cancel();
            this.fbj = null;
        }
        if (this.fbk != null) {
            this.fbk.cancel();
            this.fbk = null;
        }
        if (this.fbh != null) {
            this.fbh.dismiss();
            this.fbh = null;
        }
    }
}
