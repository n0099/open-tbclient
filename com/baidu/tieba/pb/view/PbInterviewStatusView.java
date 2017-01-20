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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.r;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String Ql;
    private TextView eue;
    private ImageView euf;
    private FrameLayout eug;
    private TextView euh;
    private ImageView eui;
    private ImageView euj;
    private View euk;
    private Animation eul;
    private com.baidu.tbadk.core.dialog.a eum;
    private CountDownTimer eun;
    private CountDownTimer euo;
    private CountDownTimer eup;
    private boolean euq;
    private boolean eur;
    private a eus;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void o(boolean z);
    }

    public void setCallback(a aVar) {
        this.eus = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.eum = null;
        this.eun = null;
        this.euo = null;
        this.eup = null;
        this.euq = true;
        this.eur = false;
        this.Ql = null;
        this.eus = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.eum = null;
        this.eun = null;
        this.euo = null;
        this.eup = null;
        this.euq = true;
        this.eur = false;
        this.Ql = null;
        this.eus = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.eum = null;
        this.eun = null;
        this.euo = null;
        this.eup = null;
        this.euq = true;
        this.eur = false;
        this.Ql = null;
        this.eus = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(r.j.pb_interview_status, (ViewGroup) this, true);
        this.eue = (TextView) this.mRootView.findViewById(r.h.interview_live_status_btn);
        this.eug = (FrameLayout) this.mRootView.findViewById(r.h.count_container);
        this.euf = (ImageView) this.mRootView.findViewById(r.h.interview_mic);
        this.euj = (ImageView) this.mRootView.findViewById(r.h.interview_arrow);
        this.euh = (TextView) this.mRootView.findViewById(r.h.count_text);
        this.eui = (ImageView) this.mRootView.findViewById(r.h.count_bg);
        this.euk = this.mRootView.findViewById(r.h.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        ap.k(this.mRootView, r.e.cp_link_tip_a);
        ap.i((View) this.eue, r.e.cp_cont_g);
        ap.j(this.eui, r.g.icon_interview_loding);
        ap.i((View) this.euh, r.e.cp_cont_g);
        ap.j(this.euf, r.g.icon_interview_mic);
        ap.j(this.euj, r.g.icon_arrow_tip_white);
        ap.k(this.euk, r.e.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.Ql = fVar.aJZ().rg().pp();
        if (StringUtils.isNull(this.Ql)) {
            this.Ql = fVar.aJZ().rg().getTaskId();
        }
        this.euq = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aLp());
        b(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        int rX = fVar.aJZ().rX();
        switch (rX) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aJZ().rg().qZ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.eun = new e(this, millis2, millis2, pbActivity, fVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.eus != null) {
                        this.eus.o(false);
                    }
                } else {
                    TiebaStatic.log(new ar("c11105").ab("obj_id", this.Ql));
                    this.mRootView.setVisibility(0);
                    if (this.eus != null) {
                        this.eus.o(true);
                    }
                    this.eue.setText(pbActivity.getPageContext().getPageActivity().getString(r.l.interview_live_before_start));
                    this.eue.setTextSize(0, com.baidu.adp.lib.util.k.e(pbActivity.getPageContext().getPageActivity(), r.f.fontsize24));
                    this.euf.setVisibility(8);
                    this.euj.setVisibility(8);
                    this.euk.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.eui, ad(pbActivity), (Animation.AnimationListener) null);
                    if (this.euo != null) {
                        this.euo.cancel();
                    }
                    this.euo = new f(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.eus != null) {
                    this.eus.o(true);
                }
                this.euf.setVisibility(8);
                this.euj.setVisibility(8);
                this.eug.setVisibility(8);
                this.euk.setVisibility(0);
                this.eue.setTextSize(0, com.baidu.adp.lib.util.k.e(pbActivity.getPageContext().getPageActivity(), r.f.fontsize28));
                ap.k(this.mRootView, r.e.cp_bg_line_e);
                ap.i((View) this.eue, r.e.cp_cont_f);
                ap.k(this.euk, r.e.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rX == 2) {
                    this.eue.setText(pbActivity.getPageContext().getPageActivity().getString(r.l.interview_live_in_process));
                    if (this.euq) {
                        ac(pbActivity);
                        return;
                    }
                    return;
                }
                this.eue.setText(pbActivity.getPageContext().getPageActivity().getString(r.l.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ac(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(r.j.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(r.h.transfer_count_down);
            View findViewById = inflate.findViewById(r.h.line_left);
            View findViewById2 = inflate.findViewById(r.h.line_right);
            ap.j((ImageView) inflate.findViewById(r.h.pop_live), r.g.pic_pop_live_n);
            ap.i((View) ((TextView) inflate.findViewById(r.h.transfer_tip_txt)), r.e.cp_cont_b);
            ap.i((View) ((TextView) inflate.findViewById(r.h.transfer_tip_txt_1)), r.e.cp_cont_b);
            ap.k(findViewById, r.e.cp_bg_line_a);
            ap.k(findViewById2, r.e.cp_bg_line_a);
            ap.i((View) textView, r.e.cp_cont_f);
            this.eum = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.eum.x(inflate);
            this.eum.a((String) null, (a.b) null);
            this.eum.b(r.l.cancel, new g(this));
            this.eum.au(false);
            this.eum.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.h.eE().postDelayed(new h(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.eup = new i(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ad(PbActivity pbActivity) {
        if (this.eul == null) {
            this.eul = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), r.a.rotate_anim);
            this.eul.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.eul.setInterpolator(new LinearInterpolator());
            this.eul.setFillAfter(true);
        }
        return this.eul;
    }

    public boolean getIndicateStatus() {
        return this.eur;
    }

    public void clearStatus() {
        if (this.eun != null) {
            this.eun.cancel();
            this.eun = null;
        }
        if (this.euo != null) {
            this.euo.cancel();
            this.euo = null;
        }
        if (this.eup != null) {
            this.eup.cancel();
            this.eup = null;
        }
        if (this.eum != null) {
            this.eum.dismiss();
            this.eum = null;
        }
    }
}
