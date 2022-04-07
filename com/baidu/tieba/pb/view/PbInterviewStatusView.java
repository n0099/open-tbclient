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
import com.repackage.dr4;
import com.repackage.oi;
import com.repackage.pg;
import com.repackage.xi8;
import com.repackage.yr7;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class PbInterviewStatusView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public TextView b;
    public ImageView c;
    public FrameLayout d;
    public TextView e;
    public ImageView f;
    public ImageView g;
    public View h;
    public Animation i;
    public dr4 j;
    public CountDownTimer k;
    public CountDownTimer l;
    public CountDownTimer m;
    public boolean n;
    public boolean o;
    public String p;
    public f q;

    /* loaded from: classes3.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ yr7 b;
        public final /* synthetic */ PbInterviewStatusView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbFragment pbFragment, yr7 yr7Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), pbFragment, yr7Var};
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
            this.c = pbInterviewStatusView;
            this.a = pbFragment;
            this.b = yr7Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.q(this.a, this.b);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbFragment a;
        public final /* synthetic */ PbInterviewStatusView b;

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
            this.b = pbInterviewStatusView;
            this.a = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c11106").param("obj_id", this.b.p));
                this.b.n = false;
                this.b.b.setText(this.a.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f092a));
                this.b.b.setTextSize(0, oi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b3));
                this.b.c.setVisibility(0);
                this.b.h.setVisibility(8);
                this.b.g.setVisibility(0);
                this.b.d.setVisibility(8);
                this.b.setClickable(true);
                this.b.o = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.b.e.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements dr4.e {
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

        @Override // com.repackage.dr4.e
        public void onClick(dr4 dr4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                if (this.a.m != null) {
                    this.a.m.cancel();
                }
                if (this.a.j != null) {
                    this.a.j.dismiss();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ PbFragment b;
        public final /* synthetic */ PbInterviewStatusView c;

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
            this.c = pbInterviewStatusView;
            this.a = textView;
            this.b = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.j != null) {
                    this.c.j.dismiss();
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    pbFragment.V4();
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

    /* loaded from: classes3.dex */
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
            dr4 dr4Var = this.j;
            if (dr4Var != null) {
                dr4Var.dismiss();
                this.j = null;
            }
        }
    }

    public final Animation n(PbFragment pbFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbFragment)) == null) {
            if (this.i == null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(pbFragment.getPageContext().getPageActivity(), R.anim.obfuscated_res_0x7f0100ff);
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
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d0685, (ViewGroup) this, true);
            this.a = inflate;
            this.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090f39);
            this.d = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090700);
            this.c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f3f);
            this.g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090f37);
            this.e = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090704);
            this.f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0906ff);
            this.h = this.a.findViewById(R.id.obfuscated_res_0x7f090f3b);
            this.a.setAlpha(0.8f);
            SkinManager.setBackgroundColor(this.a, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.f, R.drawable.icon_interview_loding);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.c, R.drawable.icon_interview_mic);
            SkinManager.setBackgroundResource(this.g, R.drawable.icon_arrow_tip_white);
            SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
        }
    }

    public final void p(PbFragment pbFragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, pbFragment) == null) || MessageManager.getInstance().findTask(CmdConfigHttp.SPECIAL_PAGE_HTTP_CMD) == null) {
            return;
        }
        View inflate = LayoutInflater.from(pbFragment.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03f2, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092121);
        View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091256);
        View findViewById2 = inflate.findViewById(R.id.obfuscated_res_0x7f091259);
        SkinManager.setBackgroundResource((ImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091892), R.drawable.pic_pop_live_n);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092122), (int) R.color.CAM_X0105);
        SkinManager.setViewTextColor((TextView) inflate.findViewById(R.id.obfuscated_res_0x7f092123), (int) R.color.CAM_X0105);
        SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(findViewById2, R.color.CAM_X0204);
        SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0106);
        dr4 dr4Var = new dr4(pbFragment.getPageContext().getPageActivity());
        this.j = dr4Var;
        dr4Var.setContentView(inflate);
        this.j.setPositiveButton((String) null, (dr4.e) null);
        this.j.setNegativeButton(R.string.obfuscated_res_0x7f0f036e, new c(this));
        this.j.setCancelable(false);
        this.j.create(pbFragment.getPageContext());
        pg.a().postDelayed(new d(this), TimeUnit.MICROSECONDS.toMillis(200L));
        this.m = new e(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbFragment).start();
    }

    public final void q(PbFragment pbFragment, yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pbFragment, yr7Var) == null) {
            int taskInfoStatus = yr7Var.O().getTaskInfoStatus();
            if (taskInfoStatus == 1) {
                long millis = TimeUnit.SECONDS.toMillis(yr7Var.O().getTaskInfoData().e()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.k = new a(this, millis2, millis2, pbFragment, yr7Var).start();
                    this.a.setVisibility(8);
                    f fVar = this.q;
                    if (fVar != null) {
                        fVar.a(false);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c11105").param("obj_id", this.p));
                    this.a.setVisibility(0);
                    f fVar2 = this.q;
                    if (fVar2 != null) {
                        fVar2.a(true);
                    }
                    this.b.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0926));
                    this.b.setTextSize(0, oi.f(pbFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b3));
                    this.c.setVisibility(8);
                    this.g.setVisibility(8);
                    this.h.setVisibility(8);
                    xi8.c(pbFragment, this.f, n(pbFragment), null);
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
                f fVar3 = this.q;
                if (fVar3 != null) {
                    fVar3.a(true);
                }
                this.c.setVisibility(8);
                this.g.setVisibility(8);
                this.d.setVisibility(8);
                this.h.setVisibility(0);
                this.b.setTextSize(0, oi.f(pbFragment.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f0702b5));
                SkinManager.setBackgroundColor(this.a, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.h, R.color.CAM_X0204);
                this.a.setAlpha(0.95f);
                setClickable(true);
                if (taskInfoStatus == 2) {
                    this.b.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0928));
                    if (this.n) {
                        p(pbFragment);
                        return;
                    }
                    return;
                }
                this.b.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.obfuscated_res_0x7f0f0927));
            }
        }
    }

    public void setCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.q = fVar;
        }
    }

    public void setData(PbFragment pbFragment, yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbFragment, yr7Var) == null) {
            String d2 = yr7Var.O().getTaskInfoData().d();
            this.p = d2;
            if (StringUtils.isNull(d2)) {
                this.p = yr7Var.O().getTaskInfoData().f();
            }
            this.n = !"from_interview_live".equals(pbFragment.w4());
            q(pbFragment, yr7Var);
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
