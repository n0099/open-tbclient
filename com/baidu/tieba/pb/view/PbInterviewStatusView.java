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
    private String bZb;
    private TextView ifL;
    private ImageView ifM;
    private FrameLayout ifN;
    private TextView ifO;
    private ImageView ifP;
    private ImageView ifQ;
    private View ifR;
    private Animation ifS;
    private com.baidu.tbadk.core.dialog.a ifT;
    private CountDownTimer ifU;
    private CountDownTimer ifV;
    private CountDownTimer ifW;
    private boolean ifX;
    private boolean ifY;
    private a ifZ;
    private View mRootView;

    /* loaded from: classes4.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.ifZ = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.ifT = null;
        this.ifU = null;
        this.ifV = null;
        this.ifW = null;
        this.ifX = true;
        this.ifY = false;
        this.bZb = null;
        this.ifZ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.ifT = null;
        this.ifU = null;
        this.ifV = null;
        this.ifW = null;
        this.ifX = true;
        this.ifY = false;
        this.bZb = null;
        this.ifZ = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.ifT = null;
        this.ifU = null;
        this.ifV = null;
        this.ifW = null;
        this.ifX = true;
        this.ifY = false;
        this.bZb = null;
        this.ifZ = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.ifL = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.ifN = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.ifM = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.ifQ = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.ifO = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.ifP = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.ifR = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.ifL, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.ifP, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.ifO, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.ifM, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.ifQ, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.ifR, R.color.cp_bg_line_c);
    }

    public void setData(PbActivity pbActivity, d dVar) {
        this.bZb = dVar.bQz().aim().aid();
        if (StringUtils.isNull(this.bZb)) {
            this.bZb = dVar.bQz().aim().getTaskId();
        }
        this.ifX = !"from_interview_live".equals(pbActivity.bSD());
        c(pbActivity, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void c(final PbActivity pbActivity, final d dVar) {
        int ajo = dVar.bQz().ajo();
        switch (ajo) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(dVar.bQz().aim().ahZ()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.ifU = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.c(pbActivity, dVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.ifZ != null) {
                        this.ifZ.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").bS("obj_id", this.bZb));
                    this.mRootView.setVisibility(0);
                    if (this.ifZ != null) {
                        this.ifZ.callback(true);
                    }
                    this.ifL.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.ifL.setTextSize(0, l.getDimens(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.ifM.setVisibility(8);
                    this.ifQ.setVisibility(8);
                    this.ifR.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbActivity, this.ifP, ax(pbActivity), null);
                    if (this.ifV != null) {
                        this.ifV.cancel();
                    }
                    this.ifV = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.ifO.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").bS("obj_id", PbInterviewStatusView.this.bZb));
                            PbInterviewStatusView.this.ifX = false;
                            PbInterviewStatusView.this.ifL.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.ifL.setTextSize(0, l.getDimens(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.ifM.setVisibility(0);
                            PbInterviewStatusView.this.ifR.setVisibility(8);
                            PbInterviewStatusView.this.ifQ.setVisibility(0);
                            PbInterviewStatusView.this.ifN.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.ifY = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.ifZ != null) {
                    this.ifZ.callback(true);
                }
                this.ifM.setVisibility(8);
                this.ifQ.setVisibility(8);
                this.ifN.setVisibility(8);
                this.ifR.setVisibility(0);
                this.ifL.setTextSize(0, l.getDimens(pbActivity.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.ifL, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.ifR, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (ajo == 2) {
                    this.ifL.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.ifX) {
                        aw(pbActivity);
                        return;
                    }
                    return;
                }
                this.ifL.setText(pbActivity.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
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
            this.ifT = new com.baidu.tbadk.core.dialog.a(pbActivity.getPageContext().getPageActivity());
            this.ifT.aM(inflate);
            this.ifT.a((String) null, (a.b) null);
            this.ifT.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.ifW != null) {
                        PbInterviewStatusView.this.ifW.cancel();
                    }
                    if (PbInterviewStatusView.this.ifT != null) {
                        PbInterviewStatusView.this.ifT.dismiss();
                    }
                }
            });
            this.ifT.eg(false);
            this.ifT.b(pbActivity.getPageContext());
            e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.ifT != null) {
                        PbInterviewStatusView.this.ifT.akO();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.ifW = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.ifT != null) {
                        PbInterviewStatusView.this.ifT.dismiss();
                    }
                    if (pbActivity != null) {
                        pbActivity.bSC();
                    }
                }
            }.start();
        }
    }

    private Animation ax(PbActivity pbActivity) {
        if (this.ifS == null) {
            this.ifS = AnimationUtils.loadAnimation(pbActivity.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.ifS.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.ifS.setInterpolator(new LinearInterpolator());
            this.ifS.setFillAfter(true);
        }
        return this.ifS;
    }

    public boolean getIndicateStatus() {
        return this.ifY;
    }

    public void clearStatus() {
        if (this.ifU != null) {
            this.ifU.cancel();
            this.ifU = null;
        }
        if (this.ifV != null) {
            this.ifV.cancel();
            this.ifV = null;
        }
        if (this.ifW != null) {
            this.ifW.cancel();
            this.ifW = null;
        }
        if (this.ifT != null) {
            this.ifT.dismiss();
            this.ifT = null;
        }
    }
}
