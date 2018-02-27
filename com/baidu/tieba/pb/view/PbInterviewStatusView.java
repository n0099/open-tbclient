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
    private String aMq;
    private TextView gdc;
    private ImageView gdd;
    private FrameLayout gde;
    private TextView gdf;
    private ImageView gdg;
    private ImageView gdh;
    private View gdi;
    private Animation gdj;
    private com.baidu.tbadk.core.dialog.a gdk;
    private CountDownTimer gdl;
    private CountDownTimer gdm;
    private CountDownTimer gdn;
    private boolean gdo;
    private boolean gdp;
    private a gdq;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void Y(boolean z);
    }

    public void setCallback(a aVar) {
        this.gdq = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gdk = null;
        this.gdl = null;
        this.gdm = null;
        this.gdn = null;
        this.gdo = true;
        this.gdp = false;
        this.aMq = null;
        this.gdq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gdk = null;
        this.gdl = null;
        this.gdm = null;
        this.gdn = null;
        this.gdo = true;
        this.gdp = false;
        this.aMq = null;
        this.gdq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gdk = null;
        this.gdl = null;
        this.gdm = null;
        this.gdn = null;
        this.gdo = true;
        this.gdp = false;
        this.aMq = null;
        this.gdq = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.gdc = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.gde = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.gdd = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.gdh = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.gdf = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.gdg = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.gdi = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.t(this.mRootView, d.C0141d.cp_link_tip_a);
        aj.r(this.gdc, d.C0141d.cp_cont_g);
        aj.s(this.gdg, d.f.icon_interview_loding);
        aj.r(this.gdf, d.C0141d.cp_cont_g);
        aj.s(this.gdd, d.f.icon_interview_mic);
        aj.s(this.gdh, d.f.icon_arrow_tip_white);
        aj.t(this.gdi, d.C0141d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.aMq = dVar.bat().yV().xP();
        if (StringUtils.isNull(this.aMq)) {
            this.aMq = dVar.bat().yV().getTaskId();
        }
        this.gdo = !"from_interview_live".equals(pbActivity.bct());
        d(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int zP = dVar.bat().zP();
        switch (zP) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bat().yV().yQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gdl = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gdq != null) {
                        this.gdq.Y(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ab("obj_id", this.aMq));
                    this.mRootView.setVisibility(0);
                    if (this.gdq != null) {
                        this.gdq.Y(true);
                    }
                    this.gdc.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.gdc.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.gdd.setVisibility(8);
                    this.gdh.setVisibility(8);
                    this.gdi.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gdg, aq(pbActivity), null);
                    if (this.gdm != null) {
                        this.gdm.cancel();
                    }
                    this.gdm = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gdf.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ab("obj_id", PbInterviewStatusView.this.aMq));
                            PbInterviewStatusView.this.gdo = false;
                            PbInterviewStatusView.this.gdc.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.gdc.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.gdd.setVisibility(0);
                            PbInterviewStatusView.this.gdi.setVisibility(8);
                            PbInterviewStatusView.this.gdh.setVisibility(0);
                            PbInterviewStatusView.this.gde.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gdp = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gdq != null) {
                    this.gdq.Y(true);
                }
                this.gdd.setVisibility(8);
                this.gdh.setVisibility(8);
                this.gde.setVisibility(8);
                this.gdi.setVisibility(0);
                this.gdc.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.t(this.mRootView, d.C0141d.cp_bg_line_e);
                aj.r(this.gdc, d.C0141d.cp_cont_f);
                aj.t(this.gdi, d.C0141d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (zP == 2) {
                    this.gdc.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.gdo) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.gdc.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0141d.cp_cont_b);
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0141d.cp_cont_b);
            aj.t(findViewById, d.C0141d.cp_bg_line_a);
            aj.t(findViewById2, d.C0141d.cp_bg_line_a);
            aj.r(textView, d.C0141d.cp_cont_f);
            this.gdk = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gdk.aO(inflate);
            this.gdk.a((String) null, (a.b) null);
            this.gdk.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gdn != null) {
                        PbInterviewStatusView.this.gdn.cancel();
                    }
                    if (PbInterviewStatusView.this.gdk != null) {
                        PbInterviewStatusView.this.gdk.dismiss();
                    }
                }
            });
            this.gdk.aZ(false);
            this.gdk.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gdk != null) {
                        PbInterviewStatusView.this.gdk.AU();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gdn = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gdk != null) {
                        PbInterviewStatusView.this.gdk.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bcs();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.gdj == null) {
            this.gdj = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.gdj.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gdj.setInterpolator(new LinearInterpolator());
            this.gdj.setFillAfter(true);
        }
        return this.gdj;
    }

    public boolean getIndicateStatus() {
        return this.gdp;
    }

    public void clearStatus() {
        if (this.gdl != null) {
            this.gdl.cancel();
            this.gdl = null;
        }
        if (this.gdm != null) {
            this.gdm.cancel();
            this.gdm = null;
        }
        if (this.gdn != null) {
            this.gdn.cancel();
            this.gdn = null;
        }
        if (this.gdk != null) {
            this.gdk.dismiss();
            this.gdk = null;
        }
    }
}
