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
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class PbInterviewStatusView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f55701e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55702f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f55703g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f55704h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f55705i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f55706j;
    public ImageView k;
    public View l;
    public Animation m;
    public c.a.q0.s.s.a n;
    public CountDownTimer o;
    public CountDownTimer p;
    public CountDownTimer q;
    public boolean r;
    public boolean s;
    public String t;
    public f u;

    /* loaded from: classes7.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55707a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j2.h.e f55708b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f55709c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbInterviewStatusView pbInterviewStatusView, long j2, long j3, PbFragment pbFragment, c.a.r0.j2.h.e eVar) {
            super(j2, j3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j2), Long.valueOf(j3), pbFragment, eVar};
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
            this.f55709c = pbInterviewStatusView;
            this.f55707a = pbFragment;
            this.f55708b = eVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55709c.p(this.f55707a, this.f55708b);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55710a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f55711b;

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
            this.f55711b = pbInterviewStatusView;
            this.f55710a = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c11106").param("obj_id", this.f55711b.t));
                this.f55711b.r = false;
                this.f55711b.f55702f.setText(this.f55710a.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                this.f55711b.f55702f.setTextSize(0, l.g(this.f55710a.getPageContext().getPageActivity(), R.dimen.fontsize24));
                this.f55711b.f55703g.setVisibility(0);
                this.f55711b.l.setVisibility(8);
                this.f55711b.k.setVisibility(0);
                this.f55711b.f55704h.setVisibility(8);
                this.f55711b.setClickable(true);
                this.f55711b.s = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f55711b.f55705i.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2))));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f55712e;

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
            this.f55712e = pbInterviewStatusView;
        }

        @Override // c.a.q0.s.s.a.e
        public void onClick(c.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f55712e.q != null) {
                    this.f55712e.q.cancel();
                }
                if (this.f55712e.n != null) {
                    this.f55712e.n.dismiss();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f55713e;

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
            this.f55713e = pbInterviewStatusView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f55713e.n == null) {
                return;
            }
            this.f55713e.n.show();
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f55714a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f55715b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f55716c;

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
            this.f55716c = pbInterviewStatusView;
            this.f55714a = textView;
            this.f55715b = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f55716c.n != null) {
                    this.f55716c.n.dismiss();
                }
                PbFragment pbFragment = this.f55715b;
                if (pbFragment != null) {
                    pbFragment.goInterviewLivePage();
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
                this.f55714a.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j2))));
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f55701e = null;
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
            c.a.q0.s.s.a aVar = this.n;
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
                Animation loadAnimation = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.rotate_anim);
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
            this.f55701e = inflate;
            this.f55702f = (TextView) inflate.findViewById(R.id.interview_live_status_btn);
            this.f55704h = (FrameLayout) this.f55701e.findViewById(R.id.count_container);
            this.f55703g = (ImageView) this.f55701e.findViewById(R.id.interview_mic);
            this.k = (ImageView) this.f55701e.findViewById(R.id.interview_arrow);
            this.f55705i = (TextView) this.f55701e.findViewById(R.id.count_text);
            this.f55706j = (ImageView) this.f55701e.findViewById(R.id.count_bg);
            this.l = this.f55701e.findViewById(R.id.interview_live_status_divider);
            this.f55701e.setAlpha(0.8f);
            SkinManager.setBackgroundColor(this.f55701e, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f55702f, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.f55706j, R.drawable.icon_interview_loding);
            SkinManager.setViewTextColor(this.f55705i, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.f55703g, R.drawable.icon_interview_mic);
            SkinManager.setBackgroundResource(this.k, R.drawable.icon_arrow_tip_white);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        }
    }

    public final void o(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pbFragment) == null) || MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null) {
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
        c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(pbFragment.getPageContext().getPageActivity());
        this.n = aVar;
        aVar.setContentView(inflate);
        this.n.setPositiveButton((String) null, (a.e) null);
        this.n.setNegativeButton(R.string.cancel, new c(this));
        this.n.setCancelable(false);
        this.n.create(pbFragment.getPageContext());
        c.a.e.e.m.e.a().postDelayed(new d(this), TimeUnit.MICROSECONDS.toMillis(200L));
        this.q = new e(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbFragment).start();
    }

    public final void p(PbFragment pbFragment, c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pbFragment, eVar) == null) {
            int k1 = eVar.O().k1();
            if (k1 == 1) {
                long millis = TimeUnit.SECONDS.toMillis(eVar.O().j1().e()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.o = new a(this, millis2, millis2, pbFragment, eVar).start();
                    this.f55701e.setVisibility(8);
                    f fVar = this.u;
                    if (fVar != null) {
                        fVar.a(false);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c11105").param("obj_id", this.t));
                    this.f55701e.setVisibility(0);
                    f fVar2 = this.u;
                    if (fVar2 != null) {
                        fVar2.a(true);
                    }
                    this.f55702f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.f55702f.setTextSize(0, l.g(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.f55703g.setVisibility(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    c.a.r0.j3.a.b(pbFragment, this.f55706j, m(pbFragment), null);
                    CountDownTimer countDownTimer = this.p;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    this.p = new b(this, millis, TimeUnit.SECONDS.toMillis(1L), pbFragment).start();
                }
                setClickable(false);
            } else if (k1 != 2 && k1 != 3) {
                this.f55701e.setVisibility(8);
            } else {
                this.f55701e.setVisibility(0);
                f fVar3 = this.u;
                if (fVar3 != null) {
                    fVar3.a(true);
                }
                this.f55703g.setVisibility(8);
                this.k.setVisibility(8);
                this.f55704h.setVisibility(8);
                this.l.setVisibility(0);
                this.f55702f.setTextSize(0, l.g(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                SkinManager.setBackgroundColor(this.f55701e, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f55702f, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
                this.f55701e.setAlpha(0.95f);
                setClickable(true);
                if (k1 == 2) {
                    this.f55702f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.r) {
                        o(pbFragment);
                        return;
                    }
                    return;
                }
                this.f55702f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
            }
        }
    }

    public void setCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public void setData(PbFragment pbFragment, c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbFragment, eVar) == null) {
            String d2 = eVar.O().j1().d();
            this.t = d2;
            if (StringUtils.isNull(d2)) {
                this.t = eVar.O().j1().f();
            }
            this.r = !"from_interview_live".equals(pbFragment.getFromWhere());
            p(pbFragment, eVar);
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
        this.f55701e = null;
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
        this.f55701e = null;
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
