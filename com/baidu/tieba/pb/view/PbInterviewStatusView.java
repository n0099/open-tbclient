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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.t;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String NS;
    private TextView dsa;
    private ImageView dsb;
    private FrameLayout dsc;
    private TextView dsd;
    private ImageView dse;
    private ImageView dsf;
    private View dsg;
    private Animation dsh;
    private com.baidu.tbadk.core.dialog.a dsi;
    private CountDownTimer dsj;
    private CountDownTimer dsk;
    private CountDownTimer dsl;
    private boolean dsm;
    private boolean dsn;
    private a dso;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void k(boolean z);
    }

    public void setCallback(a aVar) {
        this.dso = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.dsi = null;
        this.dsj = null;
        this.dsk = null;
        this.dsl = null;
        this.dsm = true;
        this.dsn = false;
        this.NS = null;
        this.dso = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.dsi = null;
        this.dsj = null;
        this.dsk = null;
        this.dsl = null;
        this.dsm = true;
        this.dsn = false;
        this.NS = null;
        this.dso = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.dsi = null;
        this.dsj = null;
        this.dsk = null;
        this.dsl = null;
        this.dsm = true;
        this.dsn = false;
        this.NS = null;
        this.dso = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(t.h.pb_interview_status, (ViewGroup) this, true);
        this.dsa = (TextView) this.mRootView.findViewById(t.g.interview_live_status_btn);
        this.dsc = (FrameLayout) this.mRootView.findViewById(t.g.count_container);
        this.dsb = (ImageView) this.mRootView.findViewById(t.g.interview_mic);
        this.dsf = (ImageView) this.mRootView.findViewById(t.g.interview_arrow);
        this.dsd = (TextView) this.mRootView.findViewById(t.g.count_text);
        this.dse = (ImageView) this.mRootView.findViewById(t.g.count_bg);
        this.dsg = this.mRootView.findViewById(t.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        at.l(this.mRootView, t.d.cp_link_tip_a);
        at.j((View) this.dsa, t.d.cp_cont_g);
        at.k(this.dse, t.f.icon_interview_loding);
        at.j((View) this.dsd, t.d.cp_cont_g);
        at.k(this.dsb, t.f.icon_interview_mic);
        at.k(this.dsf, t.f.icon_arrow_tip_white);
        at.l(this.dsg, t.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.e eVar) {
        this.NS = eVar.avE().qF().qE();
        if (StringUtils.isNull(this.NS)) {
            this.NS = eVar.avE().qF().getTaskId();
        }
        this.dsm = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.awX());
        b(pbActivity, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.e eVar) {
        int rf = eVar.avE().rf();
        switch (rf) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.avE().qF().qy()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.dsj = new e(this, millis2, millis2, pbActivity, eVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.dso != null) {
                        this.dso.k(false);
                    }
                } else {
                    TiebaStatic.log(new aw("c11105").ac("obj_id", this.NS));
                    this.mRootView.setVisibility(0);
                    if (this.dso != null) {
                        this.dso.k(true);
                    }
                    this.dsa.setText(pbActivity.getPageContext().getPageActivity().getString(t.j.interview_live_before_start));
                    this.dsa.setTextSize(0, com.baidu.adp.lib.util.k.c(pbActivity.getPageContext().getPageActivity(), t.e.fontsize24));
                    this.dsb.setVisibility(8);
                    this.dsf.setVisibility(8);
                    this.dsg.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.dse, X(pbActivity), (Animation.AnimationListener) null);
                    if (this.dsk != null) {
                        this.dsk.cancel();
                    }
                    this.dsk = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.dso != null) {
                    this.dso.k(true);
                }
                this.dsb.setVisibility(8);
                this.dsf.setVisibility(8);
                this.dsc.setVisibility(8);
                this.dsg.setVisibility(0);
                this.dsa.setTextSize(0, com.baidu.adp.lib.util.k.c(pbActivity.getPageContext().getPageActivity(), t.e.fontsize28));
                at.l(this.mRootView, t.d.cp_bg_line_e);
                at.j((View) this.dsa, t.d.cp_cont_f);
                at.l(this.dsg, t.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rf == 2) {
                    this.dsa.setText(pbActivity.getPageContext().getPageActivity().getString(t.j.interview_live_in_process));
                    if (this.dsm) {
                        W(pbActivity);
                        return;
                    }
                    return;
                }
                this.dsa.setText(pbActivity.getPageContext().getPageActivity().getString(t.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void W(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(t.h.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(t.g.transfer_count_down);
            View findViewById = inflate.findViewById(t.g.line_left);
            View findViewById2 = inflate.findViewById(t.g.line_right);
            at.k((ImageView) inflate.findViewById(t.g.pop_live), t.f.pic_pop_live_n);
            at.j((View) ((TextView) inflate.findViewById(t.g.transfer_tip_txt)), t.d.cp_cont_b);
            at.j((View) ((TextView) inflate.findViewById(t.g.transfer_tip_txt_1)), t.d.cp_cont_b);
            at.l(findViewById, t.d.cp_bg_line_a);
            at.l(findViewById2, t.d.cp_bg_line_a);
            at.j((View) textView, t.d.cp_cont_f);
            this.dsi = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.dsi.z(inflate);
            this.dsi.a((String) null, (a.b) null);
            this.dsi.b(t.j.cancel, new g(this));
            this.dsi.ap(false);
            this.dsi.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.dL().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.dsl = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation X(PbActivity pbActivity) {
        if (this.dsh == null) {
            this.dsh = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), t.a.rotate_anim);
            this.dsh.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.dsh.setInterpolator(new LinearInterpolator());
            this.dsh.setFillAfter(true);
        }
        return this.dsh;
    }

    public boolean getIndicateStatus() {
        return this.dsn;
    }

    public void clearStatus() {
        if (this.dsj != null) {
            this.dsj.cancel();
            this.dsj = null;
        }
        if (this.dsk != null) {
            this.dsk.cancel();
            this.dsk = null;
        }
        if (this.dsl != null) {
            this.dsl.cancel();
            this.dsl = null;
        }
        if (this.dsi != null) {
            this.dsi.dismiss();
            this.dsi = null;
        }
    }
}
