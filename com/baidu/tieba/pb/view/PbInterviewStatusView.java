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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.e;
import com.baidu.tieba.pb.pb.main.PbFragment;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public class PbInterviewStatusView extends FrameLayout {
    private String cPf;
    private TextView jdW;
    private ImageView jdX;
    private FrameLayout jdY;
    private TextView jdZ;
    private ImageView jea;
    private ImageView jeb;
    private View jec;
    private Animation jed;
    private com.baidu.tbadk.core.dialog.a jee;
    private CountDownTimer jef;
    private CountDownTimer jeg;
    private CountDownTimer jeh;
    private boolean jei;
    private boolean jej;
    private a jek;
    private View mRootView;

    /* loaded from: classes9.dex */
    public interface a {
        void callback(boolean z);
    }

    public void setCallback(a aVar) {
        this.jek = aVar;
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.mRootView = null;
        this.jee = null;
        this.jef = null;
        this.jeg = null;
        this.jeh = null;
        this.jei = true;
        this.jej = false;
        this.cPf = null;
        this.jek = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRootView = null;
        this.jee = null;
        this.jef = null;
        this.jeg = null;
        this.jeh = null;
        this.jei = true;
        this.jej = false;
        this.cPf = null;
        this.jek = null;
        init(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRootView = null;
        this.jee = null;
        this.jef = null;
        this.jeg = null;
        this.jeh = null;
        this.jei = true;
        this.jej = false;
        this.cPf = null;
        this.jek = null;
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.jdW = (TextView) this.mRootView.findViewById(R.id.interview_live_status_btn);
        this.jdY = (FrameLayout) this.mRootView.findViewById(R.id.count_container);
        this.jdX = (ImageView) this.mRootView.findViewById(R.id.interview_mic);
        this.jeb = (ImageView) this.mRootView.findViewById(R.id.interview_arrow);
        this.jdZ = (TextView) this.mRootView.findViewById(R.id.count_text);
        this.jea = (ImageView) this.mRootView.findViewById(R.id.count_bg);
        this.jec = this.mRootView.findViewById(R.id.interview_live_status_divider);
        this.mRootView.setAlpha(0.8f);
        am.setBackgroundColor(this.mRootView, R.color.cp_link_tip_a);
        am.setViewTextColor(this.jdW, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jea, R.drawable.icon_interview_loding);
        am.setViewTextColor(this.jdZ, (int) R.color.cp_cont_g);
        am.setBackgroundResource(this.jdX, R.drawable.icon_interview_mic);
        am.setBackgroundResource(this.jeb, R.drawable.icon_arrow_tip_white);
        am.setBackgroundColor(this.jec, R.color.cp_bg_line_c);
    }

    public void setData(PbFragment pbFragment, e eVar) {
        this.cPf = eVar.ckP().aBX().aBO();
        if (StringUtils.isNull(this.cPf)) {
            this.cPf = eVar.ckP().aBX().getTaskId();
        }
        this.jei = !"from_interview_live".equals(pbFragment.cnv());
        b(pbFragment, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v21, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$2] */
    /* JADX WARN: Type inference failed for: r0v27, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$1] */
    public void b(final PbFragment pbFragment, final e eVar) {
        int aCZ = eVar.ckP().aCZ();
        switch (aCZ) {
            case 1:
                long millis = TimeUnit.SECONDS.toMillis(eVar.ckP().aBX().aBK()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.jef = new CountDownTimer(millis2, millis2) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.1
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            PbInterviewStatusView.this.b(pbFragment, eVar);
                        }
                    }.start();
                    this.mRootView.setVisibility(8);
                    if (this.jek != null) {
                        this.jek.callback(false);
                    }
                } else {
                    TiebaStatic.log(new an("c11105").cx("obj_id", this.cPf));
                    this.mRootView.setVisibility(0);
                    if (this.jek != null) {
                        this.jek.callback(true);
                    }
                    this.jdW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.jdW.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.jdX.setVisibility(8);
                    this.jeb.setVisibility(8);
                    this.jec.setVisibility(8);
                    com.baidu.tieba.tbadkCore.a.a(pbFragment, this.jea, aD(pbFragment), null);
                    if (this.jeg != null) {
                        this.jeg.cancel();
                    }
                    this.jeg = new CountDownTimer(millis, TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.2
                        @Override // android.os.CountDownTimer
                        public void onTick(long j) {
                            PbInterviewStatusView.this.jdZ.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                        }

                        @Override // android.os.CountDownTimer
                        public void onFinish() {
                            TiebaStatic.log(new an("c11106").cx("obj_id", PbInterviewStatusView.this.cPf));
                            PbInterviewStatusView.this.jei = false;
                            PbInterviewStatusView.this.jdW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                            PbInterviewStatusView.this.jdW.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                            PbInterviewStatusView.this.jdX.setVisibility(0);
                            PbInterviewStatusView.this.jec.setVisibility(8);
                            PbInterviewStatusView.this.jeb.setVisibility(0);
                            PbInterviewStatusView.this.jdY.setVisibility(8);
                            PbInterviewStatusView.this.setClickable(true);
                            PbInterviewStatusView.this.jej = true;
                        }
                    }.start();
                }
                setClickable(false);
                return;
            case 2:
            case 3:
                this.mRootView.setVisibility(0);
                if (this.jek != null) {
                    this.jek.callback(true);
                }
                this.jdX.setVisibility(8);
                this.jeb.setVisibility(8);
                this.jdY.setVisibility(8);
                this.jec.setVisibility(0);
                this.jdW.setTextSize(0, l.getDimens(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                am.setBackgroundColor(this.mRootView, R.color.cp_bg_line_e);
                am.setViewTextColor(this.jdW, (int) R.color.cp_cont_f);
                am.setBackgroundColor(this.jec, R.color.cp_bg_line_c);
                this.mRootView.setAlpha(0.95f);
                setClickable(true);
                if (aCZ == 2) {
                    this.jdW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.jei) {
                        aC(pbFragment);
                        return;
                    }
                    return;
                }
                this.jdW.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
                return;
            default:
                this.mRootView.setVisibility(8);
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.baidu.tieba.pb.view.PbInterviewStatusView$5] */
    private void aC(final PbFragment pbFragment) {
        if (MessageManager.getInstance().findTask(1003200) != null) {
            View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
            final TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
            View findViewById = inflate.findViewById(R.id.line_left);
            View findViewById2 = inflate.findViewById(R.id.line_right);
            am.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), (int) R.color.cp_cont_b);
            am.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), (int) R.color.cp_cont_b);
            am.setBackgroundColor(findViewById, R.color.cp_bg_line_c);
            am.setBackgroundColor(findViewById2, R.color.cp_bg_line_c);
            am.setViewTextColor(textView, (int) R.color.cp_cont_f);
            this.jee = new com.baidu.tbadk.core.dialog.a(pbFragment.getPageContext().getPageActivity());
            this.jee.aO(inflate);
            this.jee.a((String) null, (a.b) null);
            this.jee.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    if (PbInterviewStatusView.this.jeh != null) {
                        PbInterviewStatusView.this.jeh.cancel();
                    }
                    if (PbInterviewStatusView.this.jee != null) {
                        PbInterviewStatusView.this.jee.dismiss();
                    }
                }
            });
            this.jee.fH(false);
            this.jee.b(pbFragment.getPageContext());
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (PbInterviewStatusView.this.jee != null) {
                        PbInterviewStatusView.this.jee.aEG();
                    }
                }
            }, TimeUnit.MICROSECONDS.toMillis(200L));
            this.jeh = new CountDownTimer(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L)) { // from class: com.baidu.tieba.pb.view.PbInterviewStatusView.5
                @Override // android.os.CountDownTimer
                public void onTick(long j) {
                    textView.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    if (PbInterviewStatusView.this.jee != null) {
                        PbInterviewStatusView.this.jee.dismiss();
                    }
                    if (pbFragment != null) {
                        pbFragment.cnu();
                    }
                }
            }.start();
        }
    }

    private Animation aD(PbFragment pbFragment) {
        if (this.jed == null) {
            this.jed = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.jed.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.jed.setInterpolator(new LinearInterpolator());
            this.jed.setFillAfter(true);
        }
        return this.jed;
    }

    public boolean getIndicateStatus() {
        return this.jej;
    }

    public void clearStatus() {
        if (this.jef != null) {
            this.jef.cancel();
            this.jef = null;
        }
        if (this.jeg != null) {
            this.jeg.cancel();
            this.jeg = null;
        }
        if (this.jeh != null) {
            this.jeh.cancel();
            this.jeh = null;
        }
        if (this.jee != null) {
            this.jee.dismiss();
            this.jee = null;
        }
    }
}
