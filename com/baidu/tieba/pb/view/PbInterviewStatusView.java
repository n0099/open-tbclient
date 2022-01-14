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
import c.a.d.f.p.n;
import c.a.s0.s.s.a;
import c.a.t0.s2.g;
import c.a.t0.s2.h;
import c.a.t0.s2.i;
import c.a.t0.s2.j;
import c.a.t0.s2.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes12.dex */
public class PbInterviewStatusView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f46990e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f46991f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f46992g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f46993h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f46994i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f46995j;
    public ImageView k;
    public View l;
    public Animation m;
    public c.a.s0.s.s.a n;
    public CountDownTimer o;
    public CountDownTimer p;
    public CountDownTimer q;
    public boolean r;
    public boolean s;
    public String t;
    public f u;

    /* loaded from: classes12.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s2.r.f f46996b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f46997c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbInterviewStatusView pbInterviewStatusView, long j2, long j3, PbFragment pbFragment, c.a.t0.s2.r.f fVar) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j2), Long.valueOf(j3), pbFragment, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46997c = pbInterviewStatusView;
            this.a = pbFragment;
            this.f46996b = fVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46997c.p(this.a, this.f46996b);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f46998b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbInterviewStatusView pbInterviewStatusView, long j2, long j3, PbFragment pbFragment) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j2), Long.valueOf(j3), pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46998b = pbInterviewStatusView;
            this.a = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c11106").param("obj_id", this.f46998b.t));
                this.f46998b.r = false;
                this.f46998b.f46991f.setText(this.a.getPageContext().getPageActivity().getString(l.interview_live_start));
                this.f46998b.f46991f.setTextSize(0, n.f(this.a.getPageContext().getPageActivity(), g.fontsize24));
                this.f46998b.f46992g.setVisibility(0);
                this.f46998b.l.setVisibility(8);
                this.f46998b.k.setVisibility(0);
                this.f46998b.f46993h.setVisibility(8);
                this.f46998b.setClickable(true);
                this.f46998b.s = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f46998b.f46994i.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2))));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f46999e;

        public c(PbInterviewStatusView pbInterviewStatusView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46999e = pbInterviewStatusView;
        }

        @Override // c.a.s0.s.s.a.e
        public void onClick(c.a.s0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f46999e.q != null) {
                    this.f46999e.q.cancel();
                }
                if (this.f46999e.n != null) {
                    this.f46999e.n.dismiss();
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f47000e;

        public d(PbInterviewStatusView pbInterviewStatusView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47000e = pbInterviewStatusView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f47000e.n == null) {
                return;
            }
            this.f47000e.n.show();
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f47001b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f47002c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbInterviewStatusView pbInterviewStatusView, long j2, long j3, TextView textView, PbFragment pbFragment) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j2), Long.valueOf(j3), textView, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47002c = pbInterviewStatusView;
            this.a = textView;
            this.f47001b = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f47002c.n != null) {
                    this.f47002c.n.dismiss();
                }
                PbFragment pbFragment = this.f47001b;
                if (pbFragment != null) {
                    pbFragment.goInterviewLivePage();
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.a.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2))));
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface f {
        void a(boolean z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewStatusView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46990e = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = null;
        this.u = null;
        n(context);
    }

    public void clearStatus() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            c.a.s0.s.s.a aVar = this.n;
            if (aVar != null) {
                aVar.dismiss();
                this.n = null;
            }
        }
    }

    public boolean getIndicateStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public final Animation m(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFragment)) == null) {
            if (this.m == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), c.a.t0.s2.e.rotate_anim);
                this.m = loadAnimation;
                loadAnimation.setDuration(TimeUnit.SECONDS.toMillis(3L));
                this.m.setInterpolator(new LinearInterpolator());
                this.m.setFillAfter(true);
            }
            return this.m;
        }
        return (Animation) invokeL.objValue;
    }

    public final void n(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(j.pb_interview_status, (ViewGroup) this, true);
            this.f46990e = inflate;
            this.f46991f = (TextView) inflate.findViewById(i.interview_live_status_btn);
            this.f46993h = (FrameLayout) this.f46990e.findViewById(i.count_container);
            this.f46992g = (ImageView) this.f46990e.findViewById(i.interview_mic);
            this.k = (ImageView) this.f46990e.findViewById(i.interview_arrow);
            this.f46994i = (TextView) this.f46990e.findViewById(i.count_text);
            this.f46995j = (ImageView) this.f46990e.findViewById(i.count_bg);
            this.l = this.f46990e.findViewById(i.interview_live_status_divider);
            this.f46990e.setAlpha(0.8f);
            SkinManager.setBackgroundColor(this.f46990e, c.a.t0.s2.f.CAM_X0302);
            SkinManager.setViewTextColor(this.f46991f, c.a.t0.s2.f.CAM_X0111);
            SkinManager.setBackgroundResource(this.f46995j, h.icon_interview_loding);
            SkinManager.setViewTextColor(this.f46994i, c.a.t0.s2.f.CAM_X0111);
            SkinManager.setBackgroundResource(this.f46992g, h.icon_interview_mic);
            SkinManager.setBackgroundResource(this.k, h.icon_arrow_tip_white);
            SkinManager.setBackgroundColor(this.l, c.a.t0.s2.f.CAM_X0204);
        }
    }

    public final void o(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pbFragment) == null) || MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null) {
            return;
        }
        View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(j.interview_transfer_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(i.transfer_count_down);
        View findViewById = inflate.findViewById(i.line_left);
        View findViewById2 = inflate.findViewById(i.line_right);
        SkinManager.setBackgroundResource((ImageView) inflate.findViewById(i.pop_live), h.pic_pop_live_n);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(i.transfer_tip_txt), c.a.t0.s2.f.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(i.transfer_tip_txt_1), c.a.t0.s2.f.CAM_X0105);
        SkinManager.setBackgroundColor(findViewById, c.a.t0.s2.f.CAM_X0204);
        SkinManager.setBackgroundColor(findViewById2, c.a.t0.s2.f.CAM_X0204);
        SkinManager.setViewTextColor(textView, c.a.t0.s2.f.CAM_X0106);
        c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(pbFragment.getPageContext().getPageActivity());
        this.n = aVar;
        aVar.setContentView(inflate);
        this.n.setPositiveButton((String) null, (a.e) null);
        this.n.setNegativeButton(l.cancel, new c(this));
        this.n.setCancelable(false);
        this.n.create(pbFragment.getPageContext());
        c.a.d.f.m.e.a().postDelayed(new d(this), TimeUnit.MICROSECONDS.toMillis(200L));
        this.q = new e(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbFragment).start();
    }

    public final void p(PbFragment pbFragment, c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pbFragment, fVar) == null) {
            int n1 = fVar.O().n1();
            if (n1 == 1) {
                long millis = TimeUnit.SECONDS.toMillis(fVar.O().m1().e()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.o = new a(this, millis2, millis2, pbFragment, fVar).start();
                    this.f46990e.setVisibility(8);
                    f fVar2 = this.u;
                    if (fVar2 != null) {
                        fVar2.a(false);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c11105").param("obj_id", this.t));
                    this.f46990e.setVisibility(0);
                    f fVar3 = this.u;
                    if (fVar3 != null) {
                        fVar3.a(true);
                    }
                    this.f46991f.setText(pbFragment.getPageContext().getPageActivity().getString(l.interview_live_before_start));
                    this.f46991f.setTextSize(0, n.f(pbFragment.getPageContext().getPageActivity(), g.fontsize24));
                    this.f46992g.setVisibility(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    c.a.t0.w3.a.c(pbFragment, this.f46995j, m(pbFragment), null);
                    CountDownTimer countDownTimer = this.p;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    this.p = new b(this, millis, TimeUnit.SECONDS.toMillis(1L), pbFragment).start();
                }
                setClickable(false);
            } else if (n1 != 2 && n1 != 3) {
                this.f46990e.setVisibility(8);
            } else {
                this.f46990e.setVisibility(0);
                f fVar4 = this.u;
                if (fVar4 != null) {
                    fVar4.a(true);
                }
                this.f46992g.setVisibility(8);
                this.k.setVisibility(8);
                this.f46993h.setVisibility(8);
                this.l.setVisibility(0);
                this.f46991f.setTextSize(0, n.f(pbFragment.getPageContext().getPageActivity(), g.fontsize28));
                SkinManager.setBackgroundColor(this.f46990e, c.a.t0.s2.f.CAM_X0205);
                SkinManager.setViewTextColor(this.f46991f, c.a.t0.s2.f.CAM_X0106);
                SkinManager.setBackgroundColor(this.l, c.a.t0.s2.f.CAM_X0204);
                this.f46990e.setAlpha(0.95f);
                setClickable(true);
                if (n1 == 2) {
                    this.f46991f.setText(pbFragment.getPageContext().getPageActivity().getString(l.interview_live_in_process));
                    if (this.r) {
                        o(pbFragment);
                        return;
                    }
                    return;
                }
                this.f46991f.setText(pbFragment.getPageContext().getPageActivity().getString(l.interview_live_finished));
            }
        }
    }

    public void setCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public void setData(PbFragment pbFragment, c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbFragment, fVar) == null) {
            String d2 = fVar.O().m1().d();
            this.t = d2;
            if (StringUtils.isNull(d2)) {
                this.t = fVar.O().m1().f();
            }
            this.r = !"from_interview_live".equals(pbFragment.getFromWhere());
            p(pbFragment, fVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46990e = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = null;
        this.u = null;
        n(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f46990e = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = true;
        this.s = false;
        this.t = null;
        this.u = null;
        n(context);
    }
}
