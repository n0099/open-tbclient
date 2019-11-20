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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String bYk;
    private TextView ieU;
    private ImageView ieV;
    private FrameLayout ieW;
    private TextView ieX;
    private ImageView ieY;
    private ImageView ieZ;
    private View ifa;
    private Animation ifb;
    private com.baidu.tbadk.core.dialog.a ifc;
    private CountDownTimer ifd;
    private CountDownTimer ife;
    private CountDownTimer iff;
    private boolean ifg;
    private boolean ifh;
    private a ifi;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.ifi = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.ifc = null;
        this.ifd = null;
        this.ife = null;
        this.iff = null;
        this.ifg = true;
        this.ifh = false;
        this.bYk = null;
        this.ifi = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.ifc = null;
        this.ifd = null;
        this.ife = null;
        this.iff = null;
        this.ifg = true;
        this.ifh = false;
        this.bYk = null;
        this.ifi = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.ifc = null;
        this.ifd = null;
        this.ife = null;
        this.iff = null;
        this.ifg = true;
        this.ifh = false;
        this.bYk = null;
        this.ifi = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.ieU = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.ieW = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.ieV = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.ieZ = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.ieX = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.ieY = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.ifa = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.ieU, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.ieY, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.ieX, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.ieV, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.ieZ, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.ifa, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bYk = dVar.bQx().aik().aib();
        if (StringUtils.isNull(this.bYk)) {
            this.bYk = dVar.bQx().aik().getTaskId();
        }
        this.ifg = !"from_interview_live".equals(pbActivity.bSB());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int ajm = dVar.bQx().ajm();
        switch (ajm) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bQx().aik().ahX()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.ifd = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.ifi != null) {
                        this.ifi.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").bS("obj_id", this.bYk));
                    this.mRootView.setVisibility(0);
                    if (this.ifi != null) {
                        this.ifi.callback(true);
                    }
                    this.ieU.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.ieU.setTextSize(0, l.getDimens(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.ieV.setVisibility(8);
                    this.ieZ.setVisibility(8);
                    this.ifa.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ieY, ax(pbActivity), null);
                    if (this.ife != null) {
                        this.ife.cancel();
                    }
                    this.ife = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.ieX.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").bS("obj_id", PbInterviewStatusView.this.bYk));
                            PbInterviewStatusView.this.ifg = false;
                            PbInterviewStatusView.this.ieU.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.ieU.setTextSize(0, l.getDimens(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.ieV.setVisibility(0);
                            PbInterviewStatusView.this.ifa.setVisibility(8);
                            PbInterviewStatusView.this.ieZ.setVisibility(0);
                            PbInterviewStatusView.this.ieW.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.ifh = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ifi != null) {
                    this.ifi.callback(true);
                }
                this.ieV.setVisibility(8);
                this.ieZ.setVisibility(8);
                this.ieW.setVisibility(8);
                this.ifa.setVisibility(0);
                this.ieU.setTextSize(0, l.getDimens(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.ieU, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.ifa, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (ajm == 2) {
                    this.ieU.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.ifg) {
                        aw(pbActivity);
                        return;
                    }
                    return;
                }
                this.ieU.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aw(final PbActivity pbActivity) {
        if (MessageManager.getInstance().findTask(1003200) != null) {
            View inflate = LayoutInflater.from(pbActivity.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            am.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), (int) R.color.cp_cont_b);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), (int) R.color.cp_cont_b);
            am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            am.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            this.ifc = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.ifc.aM(inflate);
            this.ifc.a((String) null, (a.b) null);
            this.ifc.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.iff != null) {
                        PbInterviewStatusView.this.iff.cancel();
                    }
                    if (PbInterviewStatusView.this.ifc != null) {
                        PbInterviewStatusView.this.ifc.dismiss();
                    }
                }
            });
            this.ifc.eg(false);
            this.ifc.b(pbActivity.getPageContext());
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.ifc != null) {
                        PbInterviewStatusView.this.ifc.akM();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.iff = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.ifc != null) {
                        PbInterviewStatusView.this.ifc.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bSA();
                    }
                }
            }.start();
        }
    }

    private Animation ax(PbActivity pbActivity) {
        if (this.ifb == null) {
            this.ifb = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.ifb.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ifb.setInterpolator(new LinearInterpolator());
            this.ifb.setFillAfter(true);
        }
        return this.ifb;
    }

    public boolean getIndicateStatus() {
        return this.ifh;
    }

    public void clearStatus() {
        if (this.ifd != null) {
            this.ifd.cancel();
            this.ifd = null;
        }
        if (this.ife != null) {
            this.ife.cancel();
            this.ife = null;
        }
        if (this.iff != null) {
            this.iff.cancel();
            this.iff = null;
        }
        if (this.ifc != null) {
            this.ifc.dismiss();
            this.ifc = null;
        }
    }
}
