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
    private String bGS;
    private TextView ifc;
    private ImageView ifd;
    private FrameLayout ife;
    private TextView iff;
    private ImageView ifg;
    private ImageView ifh;
    private View ifi;
    private Animation ifj;
    private com.baidu.tbadk.core.dialog.a ifk;
    private CountDownTimer ifl;
    private CountDownTimer ifm;
    private CountDownTimer ifn;
    private boolean ifo;
    private boolean ifp;
    private a ifq;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void G(boolean z);
    }

    public void setCallback(a aVar) {
        this.ifq = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.ifk = null;
        this.ifl = null;
        this.ifm = null;
        this.ifn = null;
        this.ifo = true;
        this.ifp = false;
        this.bGS = null;
        this.ifq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.ifk = null;
        this.ifl = null;
        this.ifm = null;
        this.ifn = null;
        this.ifo = true;
        this.ifp = false;
        this.bGS = null;
        this.ifq = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.ifk = null;
        this.ifl = null;
        this.ifm = null;
        this.ifn = null;
        this.ifo = true;
        this.ifp = false;
        this.bGS = null;
        this.ifq = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.ifc = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.ife = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.ifd = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.ifh = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.iff = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.ifg = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.ifi = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.l(this.mRootView, R.color.cp_link_tip_a);
        am.j(this.ifc, R.color.cp_cont_g);
        am.k(this.ifg, R.drawable.icon_interview_loding);
        am.j(this.iff, R.color.cp_cont_g);
        am.k(this.ifd, R.drawable.icon_interview_mic);
        am.k(this.ifh, R.drawable.icon_arrow_tip_white);
        am.l(this.ifi, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bGS = dVar.bSL().aee().adV();
        if (StringUtils.isNull(this.bGS)) {
            this.bGS = dVar.bSL().aee().getTaskId();
        }
        this.ifo = !"from_interview_live".equals(pbActivity.bUP());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int afg = dVar.bSL().afg();
        switch (afg) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bSL().aee().adR()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.ifl = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.ifq != null) {
                        this.ifq.G(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").bT(VideoPlayActivityConfig.OBJ_ID, this.bGS));
                    this.mRootView.setVisibility(0);
                    if (this.ifq != null) {
                        this.ifq.G(true);
                    }
                    this.ifc.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.ifc.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.ifd.setVisibility(8);
                    this.ifh.setVisibility(8);
                    this.ifi.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ifg, ax(pbActivity), null);
                    if (this.ifm != null) {
                        this.ifm.cancel();
                    }
                    this.ifm = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.iff.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").bT(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.bGS));
                            PbInterviewStatusView.this.ifo = false;
                            PbInterviewStatusView.this.ifc.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.ifc.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.ifd.setVisibility(0);
                            PbInterviewStatusView.this.ifi.setVisibility(8);
                            PbInterviewStatusView.this.ifh.setVisibility(0);
                            PbInterviewStatusView.this.ife.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.ifp = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ifq != null) {
                    this.ifq.G(true);
                }
                this.ifd.setVisibility(8);
                this.ifh.setVisibility(8);
                this.ife.setVisibility(8);
                this.ifi.setVisibility(0);
                this.ifc.setTextSize(0, l.g(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.l(this.mRootView, R.color.cp_bg_line_e);
                am.j(this.ifc, R.color.cp_cont_f);
                am.l(this.ifi, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (afg == 2) {
                    this.ifc.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.ifo) {
                        aw(pbActivity);
                        return;
                    }
                    return;
                }
                this.ifc.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aw(final PbActivity pbActivity) {
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
            this.ifk = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.ifk.aH(inflate);
            this.ifk.a((String) null, (a.b) null);
            this.ifk.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.ifn != null) {
                        PbInterviewStatusView.this.ifn.cancel();
                    }
                    if (PbInterviewStatusView.this.ifk != null) {
                        PbInterviewStatusView.this.ifk.dismiss();
                    }
                }
            });
            this.ifk.dQ(false);
            this.ifk.b(pbActivity.getPageContext());
            e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.ifk != null) {
                        PbInterviewStatusView.this.ifk.agK();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.ifn = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.ifk != null) {
                        PbInterviewStatusView.this.ifk.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bUO();
                    }
                }
            }.start();
        }
    }

    private Animation ax(PbActivity pbActivity) {
        if (this.ifj == null) {
            this.ifj = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.ifj.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ifj.setInterpolator(new LinearInterpolator());
            this.ifj.setFillAfter(true);
        }
        return this.ifj;
    }

    public boolean getIndicateStatus() {
        return this.ifp;
    }

    public void clearStatus() {
        if (this.ifl != null) {
            this.ifl.cancel();
            this.ifl = null;
        }
        if (this.ifm != null) {
            this.ifm.cancel();
            this.ifm = null;
        }
        if (this.ifn != null) {
            this.ifn.cancel();
            this.ifn = null;
        }
        if (this.ifk != null) {
            this.ifk.dismiss();
            this.ifk = null;
        }
    }
}
