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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.pb.data.h;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.u;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String NQ;
    private TextView dYS;
    private ImageView dYT;
    private FrameLayout dYU;
    private TextView dYV;
    private ImageView dYW;
    private ImageView dYX;
    private View dYY;
    private Animation dYZ;
    private com.baidu.tbadk.core.dialog.a dZa;
    private CountDownTimer dZb;
    private CountDownTimer dZc;
    private CountDownTimer dZd;
    private boolean dZe;
    private boolean dZf;
    private a dZg;
    private View mRootView;

    /* loaded from: classes.dex */
    public interface a {
        void k(boolean z);
    }

    public void setCallback(a aVar) {
        this.dZg = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.dZa = null;
        this.dZb = null;
        this.dZc = null;
        this.dZd = null;
        this.dZe = true;
        this.dZf = false;
        this.NQ = null;
        this.dZg = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.dZa = null;
        this.dZb = null;
        this.dZc = null;
        this.dZd = null;
        this.dZe = true;
        this.dZf = false;
        this.NQ = null;
        this.dZg = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.dZa = null;
        this.dZb = null;
        this.dZc = null;
        this.dZd = null;
        this.dZe = true;
        this.dZf = false;
        this.NQ = null;
        this.dZg = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(u.h.pb_interview_status, (ViewGroup) this, true);
        this.dYS = (TextView) this.mRootView.findViewById(u.g.interview_live_status_btn);
        this.dYU = (FrameLayout) this.mRootView.findViewById(u.g.count_container);
        this.dYT = (ImageView) this.mRootView.findViewById(u.g.interview_mic);
        this.dYX = (ImageView) this.mRootView.findViewById(u.g.interview_arrow);
        this.dYV = (TextView) this.mRootView.findViewById(u.g.count_text);
        this.dYW = (ImageView) this.mRootView.findViewById(u.g.count_bg);
        this.dYY = this.mRootView.findViewById(u.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        av.l(this.mRootView, u.d.cp_link_tip_a);
        av.j((View) this.dYS, u.d.cp_cont_g);
        av.k(this.dYW, u.f.icon_interview_loding);
        av.j((View) this.dYV, u.d.cp_cont_g);
        av.k(this.dYT, u.f.icon_interview_mic);
        av.k(this.dYX, u.f.icon_arrow_tip_white);
        av.l(this.dYY, u.d.cp_bg_line_c);
    }

    public void a(PbActivity pbActivity, h hVar) {
        this.NQ = hVar.aDO().qy().oH();
        if (StringUtils.isNull(this.NQ)) {
            this.NQ = hVar.aDO().qy().getTaskId();
        }
        this.dZe = !PbActivityConfig.FROM_INTERVIEW_LIVE.equals(pbActivity.aFd());
        b(pbActivity, hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(PbActivity pbActivity, h hVar) {
        int rb = hVar.aDO().rb();
        switch (rb) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(hVar.aDO().qy().qs()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.dZb = new n(this, millis2, millis2, pbActivity, hVar).start();
                    this.mRootView.setVisibility(8);
                    if (this.dZg != null) {
                        this.dZg.k(false);
                    }
                } else {
                    TiebaStatic.log(new ay("c11105").ab("obj_id", this.NQ));
                    this.mRootView.setVisibility(0);
                    if (this.dZg != null) {
                        this.dZg.k(true);
                    }
                    this.dYS.setText(pbActivity.getPageContext().getPageActivity().getString(u.j.interview_live_before_start));
                    this.dYS.setTextSize(0, k.c(pbActivity.getPageContext().getPageActivity(), u.e.fontsize24));
                    this.dYT.setVisibility(8);
                    this.dYX.setVisibility(8);
                    this.dYY.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.dYW, ad(pbActivity), (Animation.AnimationListener) null);
                    if (this.dZc != null) {
                        this.dZc.cancel();
                    }
                    this.dZc = new o(this, millis, TimeUnit.SECONDS.toMillis(1L), pbActivity).start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.dZg != null) {
                    this.dZg.k(true);
                }
                this.dYT.setVisibility(8);
                this.dYX.setVisibility(8);
                this.dYU.setVisibility(8);
                this.dYY.setVisibility(0);
                this.dYS.setTextSize(0, k.c(pbActivity.getPageContext().getPageActivity(), u.e.fontsize28));
                av.l(this.mRootView, u.d.cp_bg_line_e);
                av.j((View) this.dYS, u.d.cp_cont_f);
                av.l(this.dYY, u.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (rb == 2) {
                    this.dYS.setText(pbActivity.getPageContext().getPageActivity().getString(u.j.interview_live_in_process));
                    if (this.dZe) {
                        ac(pbActivity);
                        return;
                    }
                    return;
                }
                this.dYS.setText(pbActivity.getPageContext().getPageActivity().getString(u.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    private void ac(PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(u.h.interview_transfer_dialog, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(u.g.transfer_count_down);
            View findViewById = inflate.findViewById(u.g.line_left);
            View findViewById2 = inflate.findViewById(u.g.line_right);
            av.k((ImageView) inflate.findViewById(u.g.pop_live), u.f.pic_pop_live_n);
            av.j((View) ((TextView) inflate.findViewById(u.g.transfer_tip_txt)), u.d.cp_cont_b);
            av.j((View) ((TextView) inflate.findViewById(u.g.transfer_tip_txt_1)), u.d.cp_cont_b);
            av.l(findViewById, u.d.cp_bg_line_a);
            av.l(findViewById2, u.d.cp_bg_line_a);
            av.j((View) textView, u.d.cp_cont_f);
            this.dZa = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.dZa.y(inflate);
            this.dZa.a((String) null, (a.b) null);
            this.dZa.b(u.j.cancel, new p(this));
            this.dZa.an(false);
            this.dZa.b(pbActivity.getPageContext());
            com.baidu.adp.lib.h.h.dM().postDelayed(new q(this), TimeUnit.MICROSECONDS.toMillis(200L));
            this.dZd = new r(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbActivity).start();
        }
    }

    private Animation ad(PbActivity pbActivity) {
        if (this.dYZ == null) {
            this.dYZ = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), u.a.rotate_anim);
            this.dYZ.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.dYZ.setInterpolator(new LinearInterpolator());
            this.dYZ.setFillAfter(true);
        }
        return this.dYZ;
    }

    public boolean getIndicateStatus() {
        return this.dZf;
    }

    public void clearStatus() {
        if (this.dZb != null) {
            this.dZb.cancel();
            this.dZb = null;
        }
        if (this.dZc != null) {
            this.dZc.cancel();
            this.dZc = null;
        }
        if (this.dZd != null) {
            this.dZd.cancel();
            this.dZd = null;
        }
        if (this.dZa != null) {
            this.dZa.dismiss();
            this.dZa = null;
        }
    }
}
