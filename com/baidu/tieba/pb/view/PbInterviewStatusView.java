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
import c.a.o0.r.t.a;
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
/* loaded from: classes5.dex */
public class PbInterviewStatusView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f35277b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f35278c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f35279d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f35280e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f35281f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f35282g;

    /* renamed from: h  reason: collision with root package name */
    public View f35283h;
    public Animation i;
    public c.a.o0.r.t.a j;
    public CountDownTimer k;
    public CountDownTimer l;
    public CountDownTimer m;
    public boolean n;
    public boolean o;
    public String p;
    public f q;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.w2.i.f f35284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f35285c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbFragment pbFragment, c.a.p0.w2.i.f fVar) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), pbFragment, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35285c = pbInterviewStatusView;
            this.a = pbFragment;
            this.f35284b = fVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35285c.q(this.a, this.f35284b);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f35286b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbFragment pbFragment) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35286b = pbInterviewStatusView;
            this.a = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c11106").param("obj_id", this.f35286b.p));
                this.f35286b.n = false;
                this.f35286b.f35277b.setText(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f092a));
                this.f35286b.f35277b.setTextSize(0, n.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b3));
                this.f35286b.f35278c.setVisibility(0);
                this.f35286b.f35283h.setVisibility(8);
                this.f35286b.f35282g.setVisibility(0);
                this.f35286b.f35279d.setVisibility(8);
                this.f35286b.setClickable(true);
                this.f35286b.o = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f35286b.f35280e.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbInterviewStatusView a;

        public c(PbInterviewStatusView pbInterviewStatusView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbInterviewStatusView;
        }

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.a.m != null) {
                    this.a.m.cancel();
                }
                if (this.a.j != null) {
                    this.a.j.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbInterviewStatusView a;

        public d(PbInterviewStatusView pbInterviewStatusView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbInterviewStatusView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.j == null) {
                return;
            }
            this.a.j.show();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f35287b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f35288c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbFragment pbFragment) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), textView, pbFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35288c = pbInterviewStatusView;
            this.a = textView;
            this.f35287b = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f35288c.j != null) {
                    this.f35288c.j.dismiss();
                }
                PbFragment pbFragment = this.f35287b;
                if (pbFragment != null) {
                    pbFragment.Y4();
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
            }
        }
    }

    /* loaded from: classes5.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = true;
        this.o = false;
        this.p = null;
        this.q = null;
        o(context);
    }

    public boolean getIndicateStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            CountDownTimer countDownTimer = this.k;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.k = null;
            }
            CountDownTimer countDownTimer2 = this.l;
            if (countDownTimer2 != null) {
                countDownTimer2.cancel();
                this.l = null;
            }
            CountDownTimer countDownTimer3 = this.m;
            if (countDownTimer3 != null) {
                countDownTimer3.cancel();
                this.m = null;
            }
            c.a.o0.r.t.a aVar = this.j;
            if (aVar != null) {
                aVar.dismiss();
                this.j = null;
            }
        }
    }

    public final Animation n(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFragment)) == null) {
            if (this.i == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f0100f9);
                this.i = loadAnimation;
                loadAnimation.setDuration(TimeUnit.SECONDS.toMillis(3L));
                this.i.setInterpolator(new LinearInterpolator());
                this.i.setFillAfter(true);
            }
            return this.i;
        }
        return (Animation) invokeL.objValue;
    }

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0689, (ViewGroup) this, true);
            this.a = inflate;
            this.f35277b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f3f);
            this.f35279d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906f7);
            this.f35278c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f45);
            this.f35282g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f3d);
            this.f35280e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0906fb);
            this.f35281f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0906f6);
            this.f35283h = this.a.findViewById(R.id.obfuscated_res_0x7f090f41);
            this.a.setAlpha(0.8f);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f35277b, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.f35281f, R.drawable.icon_interview_loding);
            SkinManager.setViewTextColor(this.f35280e, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.f35278c, R.drawable.icon_interview_mic);
            SkinManager.setBackgroundResource(this.f35282g, R.drawable.icon_arrow_tip_white);
            SkinManager.setBackgroundColor(this.f35283h, R.color.CAM_X0204);
        }
    }

    public final void p(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pbFragment) == null) || MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null) {
            return;
        }
        View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03f5, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09213c);
        View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091261);
        View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f091264);
        SkinManager.setBackgroundResource((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09189f), R.drawable.pic_pop_live_n);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09213d), (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f09213e), (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
        c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(pbFragment.getPageContext().getPageActivity());
        this.j = aVar;
        aVar.setContentView(inflate);
        this.j.setPositiveButton((String) null, (a.e) null);
        this.j.setNegativeButton(R.string.obfuscated_res_0x7f0f036c, new c(this));
        this.j.setCancelable(false);
        this.j.create(pbFragment.getPageContext());
        c.a.d.f.m.e.a().postDelayed(new d(this), TimeUnit.MICROSECONDS.toMillis(200L));
        this.m = new e(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbFragment).start();
    }

    public final void q(PbFragment pbFragment, c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pbFragment, fVar) == null) {
            int taskInfoStatus = fVar.O().getTaskInfoStatus();
            if (taskInfoStatus == 1) {
                long millis = TimeUnit.SECONDS.toMillis(fVar.O().getTaskInfoData().e()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.k = new a(this, millis2, millis2, pbFragment, fVar).start();
                    this.a.setVisibility(8);
                    f fVar2 = this.q;
                    if (fVar2 != null) {
                        fVar2.a(false);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c11105").param("obj_id", this.p));
                    this.a.setVisibility(0);
                    f fVar3 = this.q;
                    if (fVar3 != null) {
                        fVar3.a(true);
                    }
                    this.f35277b.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0926));
                    this.f35277b.setTextSize(0, n.f(pbFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b3));
                    this.f35278c.setVisibility(8);
                    this.f35282g.setVisibility(8);
                    this.f35283h.setVisibility(8);
                    c.a.p0.a4.a.c(pbFragment, this.f35281f, n(pbFragment), null);
                    CountDownTimer countDownTimer = this.l;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    this.l = new b(this, millis, TimeUnit.SECONDS.toMillis(1L), pbFragment).start();
                }
                setClickable(false);
            } else if (taskInfoStatus != 2 && taskInfoStatus != 3) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
                f fVar4 = this.q;
                if (fVar4 != null) {
                    fVar4.a(true);
                }
                this.f35278c.setVisibility(8);
                this.f35282g.setVisibility(8);
                this.f35279d.setVisibility(8);
                this.f35283h.setVisibility(0);
                this.f35277b.setTextSize(0, n.f(pbFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b5));
                SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f35277b, (int) R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.f35283h, R.color.CAM_X0204);
                this.a.setAlpha(0.95f);
                setClickable(true);
                if (taskInfoStatus == 2) {
                    this.f35277b.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0928));
                    if (this.n) {
                        p(pbFragment);
                        return;
                    }
                    return;
                }
                this.f35277b.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0927));
            }
        }
    }

    public void setCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.q = fVar;
        }
    }

    public void setData(PbFragment pbFragment, c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbFragment, fVar) == null) {
            String d2 = fVar.O().getTaskInfoData().d();
            this.p = d2;
            if (StringUtils.isNull(d2)) {
                this.p = fVar.O().getTaskInfoData().f();
            }
            this.n = !"from_interview_live".equals(pbFragment.z4());
            q(pbFragment, fVar);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = true;
        this.o = false;
        this.p = null;
        this.q = null;
        o(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbInterviewStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = true;
        this.o = false;
        this.p = null;
        this.q = null;
        o(context);
    }
}
