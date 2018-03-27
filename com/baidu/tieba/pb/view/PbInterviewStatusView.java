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
    private String aMr;
    private com.baidu.tbadk.core.dialog.a gdA;
    private CountDownTimer gdB;
    private CountDownTimer gdC;
    private CountDownTimer gdD;
    private boolean gdE;
    private boolean gdF;
    private a gdG;
    private TextView gds;
    private ImageView gdt;
    private FrameLayout gdu;
    private TextView gdv;
    private ImageView gdw;
    private ImageView gdx;
    private View gdy;
    private Animation gdz;
    private View mRootView;

    /* loaded from: classes2.dex */
    public interface a {
        void Y(boolean z);
    }

    public void setCallback(a aVar) {
        this.gdG = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gdA = null;
        this.gdB = null;
        this.gdC = null;
        this.gdD = null;
        this.gdE = true;
        this.gdF = false;
        this.aMr = null;
        this.gdG = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gdA = null;
        this.gdB = null;
        this.gdC = null;
        this.gdD = null;
        this.gdE = true;
        this.gdF = false;
        this.aMr = null;
        this.gdG = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gdA = null;
        this.gdB = null;
        this.gdC = null;
        this.gdD = null;
        this.gdE = true;
        this.gdF = false;
        this.aMr = null;
        this.gdG = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(d.h.pb_interview_status, (ViewGroup) this, true);
        this.gds = (TextView) this.mRootView.findViewById(d.g.interview_live_status_btn);
        this.gdu = (FrameLayout) this.mRootView.findViewById(d.g.count_container);
        this.gdt = (ImageView) this.mRootView.findViewById(d.g.interview_mic);
        this.gdx = (ImageView) this.mRootView.findViewById(d.g.interview_arrow);
        this.gdv = (TextView) this.mRootView.findViewById(d.g.count_text);
        this.gdw = (ImageView) this.mRootView.findViewById(d.g.count_bg);
        this.gdy = this.mRootView.findViewById(d.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        aj.t(this.mRootView, d.C0141d.cp_link_tip_a);
        aj.r(this.gds, d.C0141d.cp_cont_g);
        aj.s(this.gdw, d.f.icon_interview_loding);
        aj.r(this.gdv, d.C0141d.cp_cont_g);
        aj.s(this.gdt, d.f.icon_interview_mic);
        aj.s(this.gdx, d.f.icon_arrow_tip_white);
        aj.t(this.gdy, d.C0141d.cp_bg_line_c);
    }

    public void c(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.aMr = dVar.bau().yV().xP();
        if (StringUtils.isNull(this.aMr)) {
            this.aMr = dVar.bau().yV().getTaskId();
        }
        this.gdE = !"from_interview_live".equals(pbActivity.bcu());
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
                    this.gdB = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.d(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gdG != null) {
                        this.gdG.Y(false);
                    }
                } else {
                    TiebaStatic.log(new ak("c11105").ab("obj_id", this.aMr));
                    this.mRootView.setVisibility(0);
                    if (this.gdG != null) {
                        this.gdG.Y(true);
                    }
                    this.gds.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_before_start));
                    this.gds.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                    this.gdt.setVisibility(8);
                    this.gdx.setVisibility(8);
                    this.gdy.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gdw, aq(pbActivity), null);
                    if (this.gdC != null) {
                        this.gdC.cancel();
                    }
                    this.gdC = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gdv.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new ak("c11106").ab("obj_id", PbInterviewStatusView.this.aMr));
                            PbInterviewStatusView.this.gdE = false;
                            PbInterviewStatusView.this.gds.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_start));
                            PbInterviewStatusView.this.gds.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize24));
                            PbInterviewStatusView.this.gdt.setVisibility(0);
                            PbInterviewStatusView.this.gdy.setVisibility(8);
                            PbInterviewStatusView.this.gdx.setVisibility(0);
                            PbInterviewStatusView.this.gdu.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gdF = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gdG != null) {
                    this.gdG.Y(true);
                }
                this.gdt.setVisibility(8);
                this.gdx.setVisibility(8);
                this.gdu.setVisibility(8);
                this.gdy.setVisibility(0);
                this.gds.setTextSize(0, l.t(pbActivity.getPageContext().getPageActivity(), d.e.fontsize28));
                aj.t(this.mRootView, d.C0141d.cp_bg_line_e);
                aj.r(this.gds, d.C0141d.cp_cont_f);
                aj.t(this.gdy, d.C0141d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (zP == 2) {
                    this.gds.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_in_process));
                    if (this.gdE) {
                        ap(pbActivity);
                        return;
                    }
                    return;
                }
                this.gds.setText(pbActivity.getPageContext().getPageActivity().getString(d.j.interview_live_finished));
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
            this.gdA = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gdA.aO(inflate);
            this.gdA.a((String) null, (a.b) null);
            this.gdA.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gdD != null) {
                        PbInterviewStatusView.this.gdD.cancel();
                    }
                    if (PbInterviewStatusView.this.gdA != null) {
                        PbInterviewStatusView.this.gdA.dismiss();
                    }
                }
            });
            this.gdA.aZ(false);
            this.gdA.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gdA != null) {
                        PbInterviewStatusView.this.gdA.AV();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gdD = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gdA != null) {
                        PbInterviewStatusView.this.gdA.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bct();
                    }
                }
            }.start();
        }
    }

    private Animation aq(PbActivity pbActivity) {
        if (this.gdz == null) {
            this.gdz = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), d.a.rotate_anim);
            this.gdz.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gdz.setInterpolator(new LinearInterpolator());
            this.gdz.setFillAfter(true);
        }
        return this.gdz;
    }

    public boolean getIndicateStatus() {
        return this.gdF;
    }

    public void clearStatus() {
        if (this.gdB != null) {
            this.gdB.cancel();
            this.gdB = null;
        }
        if (this.gdC != null) {
            this.gdC.cancel();
            this.gdC = null;
        }
        if (this.gdD != null) {
            this.gdD.cancel();
            this.gdD = null;
        }
        if (this.gdA != null) {
            this.gdA.dismiss();
            this.gdA = null;
        }
    }
}
