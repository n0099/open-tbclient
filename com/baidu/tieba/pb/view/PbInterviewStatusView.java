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
    private String aLh;
    private TextView gag;
    private ImageView gah;
    private FrameLayout gai;
    private TextView gaj;
    private ImageView gak;
    private ImageView gal;
    private View gam;
    private Animation gan;
    private com.baidu.tbadk.core.dialog.a gao;
    private CountDownTimer gap;
    private CountDownTimer gaq;
    private CountDownTimer gar;
    private boolean gas;
    private boolean gat;
    private a gau;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void W(boolean z);
    }

    public void setCallback(a aVar) {
        this.gau = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gao = null;
        this.gap = null;
        this.gaq = null;
        this.gar = null;
        this.gas = true;
        this.gat = false;
        this.aLh = null;
        this.gau = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gao = null;
        this.gap = null;
        this.gaq = null;
        this.gar = null;
        this.gas = true;
        this.gat = false;
        this.aLh = null;
        this.gau = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gao = null;
        this.gap = null;
        this.gaq = null;
        this.gar = null;
        this.gas = true;
        this.gat = false;
        this.aLh = null;
        this.gau = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.gag = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.gai = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.gah = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.gal = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.gaj = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.gak = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.gam = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.t(this.mRootView, d.C0108d.cp_link_tip_a);
        aj.r(this.gag, d.C0108d.cp_cont_g);
        aj.s(this.gak, d.f.icon_interview_loding);
        aj.r(this.gaj, d.C0108d.cp_cont_g);
        aj.s(this.gah, d.f.icon_interview_mic);
        aj.s(this.gal, d.f.icon_arrow_tip_white);
        aj.t(this.gam, d.C0108d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.f fVar) {
        this.aLh = fVar.aYL().yB().xj();
        if (StringUtils.isNull(this.aLh)) {
            this.aLh = fVar.aYL().yB().getTaskId();
        }
        this.gas = !"from_interview_live".equals(pbActivity.baS());
        d(pbActivity, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.f fVar) {
        int zv = fVar.aYL().zv();
        switch (zv) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(fVar.aYL().yB().yv()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gap = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, fVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gau != null) {
                        this.gau.W(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").aa("obj_id", this.aLh));
                    this.mRootView.setVisibility(0);
                    if (this.gau != null) {
                        this.gau.W(true);
                    }
                    this.gag.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.gag.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.gah.setVisibility(8);
                    this.gal.setVisibility(8);
                    this.gam.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gak, ar(pbActivity), null);
                    if (this.gaq != null) {
                        this.gaq.cancel();
                    }
                    this.gaq = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gaj.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").aa("obj_id", PbInterviewStatusView.this.aLh));
                            PbInterviewStatusView.this.gas = false;
                            PbInterviewStatusView.this.gag.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.gag.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.gah.setVisibility(0);
                            PbInterviewStatusView.this.gam.setVisibility(8);
                            PbInterviewStatusView.this.gal.setVisibility(0);
                            PbInterviewStatusView.this.gai.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gat = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gau != null) {
                    this.gau.W(true);
                }
                this.gah.setVisibility(8);
                this.gal.setVisibility(8);
                this.gai.setVisibility(8);
                this.gam.setVisibility(0);
                this.gag.setTextSize(0, l.s(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.t(this.mRootView, d.C0108d.cp_bg_line_e);
                aj.r(this.gag, d.C0108d.cp_cont_f);
                aj.t(this.gam, d.C0108d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (zv == 2) {
                    this.gag.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.gas) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.gag.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
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
            this.gao = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gao.aO(inflate);
            this.gao.a((String) null, (a.b) null);
            this.gao.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gar != null) {
                        PbInterviewStatusView.this.gar.cancel();
                    }
                    if (PbInterviewStatusView.this.gao != null) {
                        PbInterviewStatusView.this.gao.dismiss();
                    }
                }
            });
            this.gao.aW(false);
            this.gao.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gao != null) {
                        PbInterviewStatusView.this.gao.AB();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gar = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gao != null) {
                        PbInterviewStatusView.this.gao.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.baQ();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.gan == null) {
            this.gan = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.gan.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gan.setInterpolator(new LinearInterpolator());
            this.gan.setFillAfter(true);
        }
        return this.gan;
    }

    public boolean getIndicateStatus() {
        return this.gat;
    }

    public void clearStatus() {
        if (this.gap != null) {
            this.gap.cancel();
            this.gap = null;
        }
        if (this.gaq != null) {
            this.gaq.cancel();
            this.gaq = null;
        }
        if (this.gar != null) {
            this.gar.cancel();
            this.gar = null;
        }
        if (this.gao != null) {
            this.gao.dismiss();
            this.gao = null;
        }
    }
}
