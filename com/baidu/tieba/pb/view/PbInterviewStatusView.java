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
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String anG;
    private TextView gfa;
    private ImageView gfb;
    private FrameLayout gfc;
    private TextView gfd;
    private ImageView gfe;
    private ImageView gff;
    private View gfg;
    private Animation gfh;
    private com.baidu.tbadk.core.dialog.a gfi;
    private CountDownTimer gfj;
    private CountDownTimer gfk;
    private CountDownTimer gfl;
    private boolean gfm;
    private boolean gfn;
    private a gfo;
    private View mRootView;

    /* loaded from: classes6.dex */
    public interface a {
        void O(boolean z);
    }

    public void setCallback(a aVar) {
        this.gfo = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.gfi = null;
        this.gfj = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = true;
        this.gfn = false;
        this.anG = null;
        this.gfo = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.gfi = null;
        this.gfj = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = true;
        this.gfn = false;
        this.anG = null;
        this.gfo = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.gfi = null;
        this.gfj = null;
        this.gfk = null;
        this.gfl = null;
        this.gfm = true;
        this.gfn = false;
        this.anG = null;
        this.gfo = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(e.h.pb_interview_status, (ViewGroup) this, true);
        this.gfa = (TextView) this.mRootView.findViewById(e.g.interview_live_status_btn);
        this.gfc = (FrameLayout) this.mRootView.findViewById(e.g.count_container);
        this.gfb = (ImageView) this.mRootView.findViewById(e.g.interview_mic);
        this.gff = (ImageView) this.mRootView.findViewById(e.g.interview_arrow);
        this.gfd = (TextView) this.mRootView.findViewById(e.g.count_text);
        this.gfe = (ImageView) this.mRootView.findViewById(e.g.count_bg);
        this.gfg = this.mRootView.findViewById(e.g.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        al.j(this.mRootView, e.d.cp_link_tip_a);
        al.h(this.gfa, e.d.cp_cont_g);
        al.i(this.gfe, e.f.icon_interview_loding);
        al.h(this.gfd, e.d.cp_cont_g);
        al.i(this.gfb, e.f.icon_interview_mic);
        al.i(this.gff, e.f.icon_arrow_tip_white);
        al.j(this.gfg, e.d.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, com.baidu.tieba.pb.data.d dVar) {
        this.anG = dVar.bet().yj().xc();
        if (StringUtils.isNull(this.anG)) {
            this.anG = dVar.bet().yj().getTaskId();
        }
        this.gfm = !"from_interview_live".equals(pbActivity.bgu());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final com.baidu.tieba.pb.data.d dVar) {
        int ze = dVar.bet().ze();
        switch (ze) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bet().yj().ye()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.gfj = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.gfo != null) {
                        this.gfo.O(false);
                    }
                } else {
                    TiebaStatic.log(new am("c11105").ax(VideoPlayActivityConfig.OBJ_ID, this.anG));
                    this.mRootView.setVisibility(0);
                    if (this.gfo != null) {
                        this.gfo.O(true);
                    }
                    this.gfa.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_before_start));
                    this.gfa.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0200e.fontsize24));
                    this.gfb.setVisibility(8);
                    this.gff.setVisibility(8);
                    this.gfg.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.gfe, ar(pbActivity), null);
                    if (this.gfk != null) {
                        this.gfk.cancel();
                    }
                    this.gfk = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.gfd.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new am("c11106").ax(VideoPlayActivityConfig.OBJ_ID, PbInterviewStatusView.this.anG));
                            PbInterviewStatusView.this.gfm = false;
                            PbInterviewStatusView.this.gfa.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_start));
                            PbInterviewStatusView.this.gfa.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0200e.fontsize24));
                            PbInterviewStatusView.this.gfb.setVisibility(0);
                            PbInterviewStatusView.this.gfg.setVisibility(8);
                            PbInterviewStatusView.this.gff.setVisibility(0);
                            PbInterviewStatusView.this.gfc.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.gfn = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.gfo != null) {
                    this.gfo.O(true);
                }
                this.gfb.setVisibility(8);
                this.gff.setVisibility(8);
                this.gfc.setVisibility(8);
                this.gfg.setVisibility(0);
                this.gfa.setTextSize(0, l.h(pbActivity.getPageContext().getPageActivity(), e.C0200e.fontsize28));
                al.j(this.mRootView, e.d.cp_bg_line_e);
                al.h(this.gfa, e.d.cp_cont_f);
                al.j(this.gfg, e.d.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (ze == 2) {
                    this.gfa.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_in_process));
                    if (this.gfm) {
                        aq(pbActivity);
                        return;
                    }
                    return;
                }
                this.gfa.setText(pbActivity.getPageContext().getPageActivity().getString(e.j.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aq(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(e.h.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(e.g.transfer_count_down);
            View findViewById = inflate.findViewById(e.g.line_left);
            View findViewById2 = inflate.findViewById(e.g.line_right);
            al.i((ImageView) inflate.findViewById(e.g.pop_live), e.f.pic_pop_live_n);
            al.h((TextView) inflate.findViewById(e.g.transfer_tip_txt), e.d.cp_cont_b);
            al.h((TextView) inflate.findViewById(e.g.transfer_tip_txt_1), e.d.cp_cont_b);
            al.j(findViewById, e.d.cp_bg_line_a);
            al.j(findViewById2, e.d.cp_bg_line_a);
            al.h(textView, e.d.cp_cont_f);
            this.gfi = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.gfi.G(inflate);
            this.gfi.a((String) null, (a.b) null);
            this.gfi.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.gfl != null) {
                        PbInterviewStatusView.this.gfl.cancel();
                    }
                    if (PbInterviewStatusView.this.gfi != null) {
                        PbInterviewStatusView.this.gfi.dismiss();
                    }
                }
            });
            this.gfi.be(false);
            this.gfi.b(pbActivity.getPageContext());
            com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.gfi != null) {
                        PbInterviewStatusView.this.gfi.AB();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.gfl = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.gfi != null) {
                        PbInterviewStatusView.this.gfi.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bgt();
                    }
                }
            }.start();
        }
    }

    private Animation ar(PbActivity pbActivity) {
        if (this.gfh == null) {
            this.gfh = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), e.a.rotate_anim);
            this.gfh.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.gfh.setInterpolator(new LinearInterpolator());
            this.gfh.setFillAfter(true);
        }
        return this.gfh;
    }

    public boolean getIndicateStatus() {
        return this.gfn;
    }

    public void clearStatus() {
        if (this.gfj != null) {
            this.gfj.cancel();
            this.gfj = null;
        }
        if (this.gfk != null) {
            this.gfk.cancel();
            this.gfk = null;
        }
        if (this.gfl != null) {
            this.gfl.cancel();
            this.gfl = null;
        }
        if (this.gfi != null) {
            this.gfi.dismiss();
            this.gfi = null;
        }
    }
}
