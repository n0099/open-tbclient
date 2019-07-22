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
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String bGR;
    private TextView iea;
    private ImageView ieb;
    private FrameLayout iec;
    private TextView ied;
    private ImageView iee;
    private ImageView ief;
    private View ieg;
    private Animation ieh;
    private com.baidu.tbadk.core.dialog.a iei;
    private CountDownTimer iej;
    private CountDownTimer iek;
    private CountDownTimer iel;
    private boolean iem;
    private boolean ien;
    private a ieo;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void G(boolean z);
    }

    public void setCallback(a aVar) {
        this.ieo = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.iei = null;
        this.iej = null;
        this.iek = null;
        this.iel = null;
        this.iem = true;
        this.ien = false;
        this.bGR = null;
        this.ieo = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.iei = null;
        this.iej = null;
        this.iek = null;
        this.iel = null;
        this.iem = true;
        this.ien = false;
        this.bGR = null;
        this.ieo = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.iei = null;
        this.iej = null;
        this.iek = null;
        this.iel = null;
        this.iem = true;
        this.ien = false;
        this.bGR = null;
        this.ieo = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.iea = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.iec = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.ieb = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.ief = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.ied = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.iee = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.ieg = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.l(this.mRootView, R.color.cp_link_tip_a);
        am.j(this.iea, R.color.cp_cont_g);
        am.k(this.iee, R.drawable.icon_interview_loding);
        am.j(this.ied, R.color.cp_cont_g);
        am.k(this.ieb, R.drawable.icon_interview_mic);
        am.k(this.ief, R.drawable.icon_arrow_tip_white);
        am.l(this.ieg, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bGR = dVar.bSx().aed().adU();
        if (StringUtils.isNull(this.bGR)) {
            this.bGR = dVar.bSx().aed().getTaskId();
        }
        this.iem = !"from_interview_live".equals(pbActivity.bUA());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int aff = dVar.bSx().aff();
        switch (aff) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bSx().aed().adQ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.iej = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.ieo != null) {
                        this.ieo.G(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").bT(VideoPlayActivityConfig.OBJ_ID, this.bGR));
                    this.mRootView.setVisibility(0);
                    if (this.ieo != null) {
                        this.ieo.G(true);
                    }
                    this.iea.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.iea.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.ieb.setVisibility(8);
                    this.ief.setVisibility(8);
                    this.ieg.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.iee, aw(pbActivity), null);
                    if (this.iek != null) {
                        this.iek.cancel();
                    }
                    this.iek = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.ied.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").bT(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.bGR));
                            PbInterviewStatusView.this.iem = false;
                            PbInterviewStatusView.this.iea.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.iea.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.ieb.setVisibility(0);
                            PbInterviewStatusView.this.ieg.setVisibility(8);
                            PbInterviewStatusView.this.ief.setVisibility(0);
                            PbInterviewStatusView.this.iec.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.ien = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ieo != null) {
                    this.ieo.G(true);
                }
                this.ieb.setVisibility(8);
                this.ief.setVisibility(8);
                this.iec.setVisibility(8);
                this.ieg.setVisibility(0);
                this.iea.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.l(this.mRootView, R.color.cp_bg_line_e);
                am.j(this.iea, R.color.cp_cont_f);
                am.l(this.ieg, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aff == 2) {
                    this.iea.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.iem) {
                        av(pbActivity);
                        return;
                    }
                    return;
                }
                this.iea.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void av(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            am.k((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            am.j((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.cp_cont_b);
            am.j((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.cp_cont_b);
            am.l(findViewById, R.color.cp_bg_line_a);
            am.l(findViewById2, R.color.cp_bg_line_a);
            am.j(textView, R.color.cp_cont_f);
            this.iei = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.iei.aH(inflate);
            this.iei.a((String) null, (a.b) null);
            this.iei.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.iel != null) {
                        PbInterviewStatusView.this.iel.cancel();
                    }
                    if (PbInterviewStatusView.this.iei != null) {
                        PbInterviewStatusView.this.iei.dismiss();
                    }
                }
            });
            this.iei.dQ(false);
            this.iei.b(pbActivity.getPageContext());
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.iei != null) {
                        PbInterviewStatusView.this.iei.agI();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.iel = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.iei != null) {
                        PbInterviewStatusView.this.iei.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bUz();
                    }
                }
            }.start();
        }
    }

    private Animation aw(PbActivity pbActivity) {
        if (this.ieh == null) {
            this.ieh = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.ieh.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ieh.setInterpolator(new LinearInterpolator());
            this.ieh.setFillAfter(true);
        }
        return this.ieh;
    }

    public boolean getIndicateStatus() {
        return this.ien;
    }

    public void clearStatus() {
        if (this.iej != null) {
            this.iej.cancel();
            this.iej = null;
        }
        if (this.iek != null) {
            this.iek.cancel();
            this.iek = null;
        }
        if (this.iel != null) {
            this.iel.cancel();
            this.iel = null;
        }
        if (this.iei != null) {
            this.iei.dismiss();
            this.iei = null;
        }
    }
}
