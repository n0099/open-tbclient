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
    private String aMB;
    private boolean gdA;
    private a gdB;
    private TextView gdn;
    private ImageView gdo;
    private FrameLayout gdp;
    private TextView gdq;
    private ImageView gdr;
    private ImageView gds;
    private View gdt;
    private Animation gdu;
    private com.baidu.tbadk.core.dialog.a gdv;
    private CountDownTimer gdw;
    private CountDownTimer gdx;
    private CountDownTimer gdy;
    private boolean gdz;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void Y(boolean z);
    }

    public void setCallback(a aVar) {
        this.gdB = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gdv = null;
        this.gdw = null;
        this.gdx = null;
        this.gdy = null;
        this.gdz = true;
        this.gdA = false;
        this.aMB = null;
        this.gdB = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gdv = null;
        this.gdw = null;
        this.gdx = null;
        this.gdy = null;
        this.gdz = true;
        this.gdA = false;
        this.aMB = null;
        this.gdB = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gdv = null;
        this.gdw = null;
        this.gdx = null;
        this.gdy = null;
        this.gdz = true;
        this.gdA = false;
        this.aMB = null;
        this.gdB = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.gdn = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.gdp = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.gdo = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.gds = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.gdq = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.gdr = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.gdt = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.t(this.mRootView, d.C0140d.cp_link_tip_a);
        aj.r(this.gdn, d.C0140d.cp_cont_g);
        aj.s(this.gdr, d.f.icon_interview_loding);
        aj.r(this.gdq, d.C0140d.cp_cont_g);
        aj.s(this.gdo, d.f.icon_interview_mic);
        aj.s(this.gds, d.f.icon_arrow_tip_white);
        aj.t(this.gdt, d.C0140d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.aMB = dVar.bau().yV().xP();
        if (StringUtils.isNull(this.aMB)) {
            this.aMB = dVar.bau().yV().getTaskId();
        }
        this.gdz = !"from_interview_live".equals(pbActivity.bcu());
        d(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void d(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int zP = dVar.bau().zP();
        switch (zP) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bau().yV().yQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gdw = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gdB != null) {
                        this.gdB.Y(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ab("obj_id", this.aMB));
                    this.mRootView.setVisibility(0);
                    if (this.gdB != null) {
                        this.gdB.Y(true);
                    }
                    this.gdn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.gdn.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.gdo.setVisibility(8);
                    this.gds.setVisibility(8);
                    this.gdt.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gdr, aq(pbActivity), null);
                    if (this.gdx != null) {
                        this.gdx.cancel();
                    }
                    this.gdx = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gdq.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ab("obj_id", PbInterviewStatusView.this.aMB));
                            PbInterviewStatusView.this.gdz = false;
                            PbInterviewStatusView.this.gdn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.gdn.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.gdo.setVisibility(0);
                            PbInterviewStatusView.this.gdt.setVisibility(8);
                            PbInterviewStatusView.this.gds.setVisibility(0);
                            PbInterviewStatusView.this.gdp.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gdA = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gdB != null) {
                    this.gdB.Y(true);
                }
                this.gdo.setVisibility(8);
                this.gds.setVisibility(8);
                this.gdp.setVisibility(8);
                this.gdt.setVisibility(0);
                this.gdn.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.t(this.mRootView, d.C0140d.cp_bg_line_e);
                aj.r(this.gdn, d.C0140d.cp_cont_f);
                aj.t(this.gdt, d.C0140d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (zP == 2) {
                    this.gdn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.gdz) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.gdn.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt), d.C0140d.cp_cont_b);
            aj.r((TextView) inflate.findViewById(d.g.transfer_tip_txt_1), d.C0140d.cp_cont_b);
            aj.t(findViewById, d.C0140d.cp_bg_line_a);
            aj.t(findViewById2, d.C0140d.cp_bg_line_a);
            aj.r(textView, d.C0140d.cp_cont_f);
            this.gdv = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gdv.aO(inflate);
            this.gdv.a((String) null, (a.b) null);
            this.gdv.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gdy != null) {
                        PbInterviewStatusView.this.gdy.cancel();
                    }
                    if (PbInterviewStatusView.this.gdv != null) {
                        PbInterviewStatusView.this.gdv.dismiss();
                    }
                }
            });
            this.gdv.aZ(false);
            this.gdv.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gdv != null) {
                        PbInterviewStatusView.this.gdv.AU();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gdy = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gdv != null) {
                        PbInterviewStatusView.this.gdv.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bct();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.gdu == null) {
            this.gdu = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.gdu.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gdu.setInterpolator(new LinearInterpolator());
            this.gdu.setFillAfter(true);
        }
        return this.gdu;
    }

    public boolean getIndicateStatus() {
        return this.gdA;
    }

    public void clearStatus() {
        if (this.gdw != null) {
            this.gdw.cancel();
            this.gdw = null;
        }
        if (this.gdx != null) {
            this.gdx.cancel();
            this.gdx = null;
        }
        if (this.gdy != null) {
            this.gdy.cancel();
            this.gdy = null;
        }
        if (this.gdv != null) {
            this.gdv.dismiss();
            this.gdv = null;
        }
    }
}
