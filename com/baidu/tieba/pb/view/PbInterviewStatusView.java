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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PbInterviewStatusView extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    public View f19836e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19837f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19838g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f19839h;
    public TextView i;
    public ImageView j;
    public ImageView k;
    public View l;
    public Animation m;
    public d.b.h0.r.s.a n;
    public CountDownTimer o;
    public CountDownTimer p;
    public CountDownTimer q;
    public boolean r;
    public boolean s;
    public String t;
    public f u;

    /* loaded from: classes3.dex */
    public class a extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19840a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d2.h.e f19841b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, long j2, PbFragment pbFragment, d.b.i0.d2.h.e eVar) {
            super(j, j2);
            this.f19840a = pbFragment;
            this.f19841b = eVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            PbInterviewStatusView.this.q(this.f19840a, this.f19841b);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19843a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, long j2, PbFragment pbFragment) {
            super(j, j2);
            this.f19843a = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            TiebaStatic.log(new StatisticItem("c11106").param("obj_id", PbInterviewStatusView.this.t));
            PbInterviewStatusView.this.r = false;
            PbInterviewStatusView.this.f19837f.setText(this.f19843a.getPageContext().getPageActivity().getString(R.string.interview_live_start));
            PbInterviewStatusView.this.f19837f.setTextSize(0, l.g(this.f19843a.getPageContext().getPageActivity(), R.dimen.fontsize24));
            PbInterviewStatusView.this.f19838g.setVisibility(0);
            PbInterviewStatusView.this.l.setVisibility(8);
            PbInterviewStatusView.this.k.setVisibility(0);
            PbInterviewStatusView.this.f19839h.setVisibility(8);
            PbInterviewStatusView.this.setClickable(true);
            PbInterviewStatusView.this.s = true;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            PbInterviewStatusView.this.i.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
        }
    }

    /* loaded from: classes3.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (PbInterviewStatusView.this.q != null) {
                PbInterviewStatusView.this.q.cancel();
            }
            if (PbInterviewStatusView.this.n != null) {
                PbInterviewStatusView.this.n.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PbInterviewStatusView.this.n != null) {
                PbInterviewStatusView.this.n.show();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f19847a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19848b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(long j, long j2, TextView textView, PbFragment pbFragment) {
            super(j, j2);
            this.f19847a = textView;
            this.f19848b = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (PbInterviewStatusView.this.n != null) {
                PbInterviewStatusView.this.n.dismiss();
            }
            PbFragment pbFragment = this.f19848b;
            if (pbFragment != null) {
                pbFragment.O4();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            this.f19847a.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(boolean z);
    }

    public PbInterviewStatusView(Context context) {
        super(context);
        this.f19836e = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = null;
        this.u = null;
        o(context);
    }

    public boolean getIndicateStatus() {
        return this.s;
    }

    public void m() {
        CountDownTimer countDownTimer = this.o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.o = null;
        }
        CountDownTimer countDownTimer2 = this.p;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
            this.p = null;
        }
        CountDownTimer countDownTimer3 = this.q;
        if (countDownTimer3 != null) {
            countDownTimer3.cancel();
            this.q = null;
        }
        d.b.h0.r.s.a aVar = this.n;
        if (aVar != null) {
            aVar.dismiss();
            this.n = null;
        }
    }

    public final Animation n(PbFragment pbFragment) {
        if (this.m == null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
            this.m = loadAnimation;
            loadAnimation.setDuration(TimeUnit.SECONDS.toMillis(3L));
            this.m.setInterpolator(new LinearInterpolator());
            this.m.setFillAfter(true);
        }
        return this.m;
    }

    public final void o(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
        this.f19836e = inflate;
        this.f19837f = (TextView) inflate.findViewById(R.id.interview_live_status_btn);
        this.f19839h = (FrameLayout) this.f19836e.findViewById(R.id.count_container);
        this.f19838g = (ImageView) this.f19836e.findViewById(R.id.interview_mic);
        this.k = (ImageView) this.f19836e.findViewById(R.id.interview_arrow);
        this.i = (TextView) this.f19836e.findViewById(R.id.count_text);
        this.j = (ImageView) this.f19836e.findViewById(R.id.count_bg);
        this.l = this.f19836e.findViewById(R.id.interview_live_status_divider);
        this.f19836e.setAlpha(0.8f);
        SkinManager.setBackgroundColor(this.f19836e, R.color.CAM_X0302);
        SkinManager.setViewTextColor(this.f19837f, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.j, R.drawable.icon_interview_loding);
        SkinManager.setViewTextColor(this.i, R.color.CAM_X0111);
        SkinManager.setBackgroundResource(this.f19838g, R.drawable.icon_interview_mic);
        SkinManager.setBackgroundResource(this.k, R.drawable.icon_arrow_tip_white);
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
    }

    public final void p(PbFragment pbFragment) {
        if (MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null) {
            return;
        }
        View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.interview_transfer_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.transfer_count_down);
        View findViewById = inflate.findViewById(R.id.line_left);
        View findViewById2 = inflate.findViewById(R.id.line_right);
        SkinManager.setBackgroundResource((ImageView) inflate.findViewById(R.id.pop_live), R.drawable.pic_pop_live_n);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt), R.color.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.transfer_tip_txt_1), R.color.CAM_X0105);
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(pbFragment.getPageContext().getPageActivity());
        this.n = aVar;
        aVar.setContentView(inflate);
        this.n.setPositiveButton((String) null, (a.e) null);
        this.n.setNegativeButton(R.string.cancel, new c());
        this.n.setCancelable(false);
        this.n.create(pbFragment.getPageContext());
        d.b.c.e.m.e.a().postDelayed(new d(), TimeUnit.MICROSECONDS.toMillis(200L));
        this.q = new e(TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbFragment).start();
    }

    public final void q(PbFragment pbFragment, d.b.i0.d2.h.e eVar) {
        int p1 = eVar.L().p1();
        if (p1 == 1) {
            long millis = TimeUnit.SECONDS.toMillis(eVar.L().o1().e()) - System.currentTimeMillis();
            if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                this.o = new a(millis2, millis2, pbFragment, eVar).start();
                this.f19836e.setVisibility(8);
                f fVar = this.u;
                if (fVar != null) {
                    fVar.a(false);
                }
            } else {
                TiebaStatic.log(new StatisticItem("c11105").param("obj_id", this.t));
                this.f19836e.setVisibility(0);
                f fVar2 = this.u;
                if (fVar2 != null) {
                    fVar2.a(true);
                }
                this.f19837f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                this.f19837f.setTextSize(0, l.g(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                this.f19838g.setVisibility(8);
                this.k.setVisibility(8);
                this.l.setVisibility(8);
                d.b.i0.d3.a.b(pbFragment, this.j, n(pbFragment), null);
                CountDownTimer countDownTimer = this.p;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                this.p = new b(millis, TimeUnit.SECONDS.toMillis(1L), pbFragment).start();
            }
            setClickable(false);
        } else if (p1 != 2 && p1 != 3) {
            this.f19836e.setVisibility(8);
        } else {
            this.f19836e.setVisibility(0);
            f fVar3 = this.u;
            if (fVar3 != null) {
                fVar3.a(true);
            }
            this.f19838g.setVisibility(8);
            this.k.setVisibility(8);
            this.f19839h.setVisibility(8);
            this.l.setVisibility(0);
            this.f19837f.setTextSize(0, l.g(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
            SkinManager.setBackgroundColor(this.f19836e, R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.f19837f, R.color.CAM_X0106);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
            this.f19836e.setAlpha(0.95f);
            setClickable(true);
            if (p1 == 2) {
                this.f19837f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                if (this.r) {
                    p(pbFragment);
                    return;
                }
                return;
            }
            this.f19837f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
        }
    }

    public void setCallback(f fVar) {
        this.u = fVar;
    }

    public void setData(PbFragment pbFragment, d.b.i0.d2.h.e eVar) {
        String d2 = eVar.L().o1().d();
        this.t = d2;
        if (StringUtils.isNull(d2)) {
            this.t = eVar.L().o1().f();
        }
        this.r = !"from_interview_live".equals(pbFragment.q4());
        q(pbFragment, eVar);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19836e = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = null;
        this.u = null;
        o(context);
    }

    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19836e = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = null;
        this.u = null;
        o(context);
    }
}
