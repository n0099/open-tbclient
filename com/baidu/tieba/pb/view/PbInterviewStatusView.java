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
import d.a.c.e.p.l;
import d.a.r0.r.s.a;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class PbInterviewStatusView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f19858e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19859f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f19860g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout f19861h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19862i;
    public ImageView j;
    public ImageView k;
    public View l;
    public Animation m;
    public d.a.r0.r.s.a n;
    public CountDownTimer o;
    public CountDownTimer p;
    public CountDownTimer q;
    public boolean r;
    public boolean s;
    public String t;
    public f u;

    /* loaded from: classes5.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.s0.h2.h.e f19864b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f19865c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbFragment pbFragment, d.a.s0.h2.h.e eVar) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), pbFragment, eVar};
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
            this.f19865c = pbInterviewStatusView;
            this.f19863a = pbFragment;
            this.f19864b = eVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19865c.q(this.f19863a, this.f19864b);
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

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19866a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f19867b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbInterviewStatusView pbInterviewStatusView, long j, long j2, PbFragment pbFragment) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), pbFragment};
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
            this.f19867b = pbInterviewStatusView;
            this.f19866a = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem("c11106").param("obj_id", this.f19867b.t));
                this.f19867b.r = false;
                this.f19867b.f19859f.setText(this.f19866a.getPageContext().getPageActivity().getString(R.string.interview_live_start));
                this.f19867b.f19859f.setTextSize(0, l.g(this.f19866a.getPageContext().getPageActivity(), R.dimen.fontsize24));
                this.f19867b.f19860g.setVisibility(0);
                this.f19867b.l.setVisibility(8);
                this.f19867b.k.setVisibility(0);
                this.f19867b.f19861h.setVisibility(8);
                this.f19867b.setClickable(true);
                this.f19867b.s = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f19867b.f19862i.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f19868e;

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
            this.f19868e = pbInterviewStatusView;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (this.f19868e.q != null) {
                    this.f19868e.q.cancel();
                }
                if (this.f19868e.n != null) {
                    this.f19868e.n.dismiss();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f19869e;

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
            this.f19869e = pbInterviewStatusView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f19869e.n == null) {
                return;
            }
            this.f19869e.n.show();
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f19870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbFragment f19871b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ PbInterviewStatusView f19872c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbInterviewStatusView pbInterviewStatusView, long j, long j2, TextView textView, PbFragment pbFragment) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {pbInterviewStatusView, Long.valueOf(j), Long.valueOf(j2), textView, pbFragment};
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
            this.f19872c = pbInterviewStatusView;
            this.f19870a = textView;
            this.f19871b = pbFragment;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f19872c.n != null) {
                    this.f19872c.n.dismiss();
                }
                PbFragment pbFragment = this.f19871b;
                if (pbFragment != null) {
                    pbFragment.U4();
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.f19870a.setText(StringUtils.string(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j))));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19858e = null;
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
            d.a.r0.r.s.a aVar = this.n;
            if (aVar != null) {
                aVar.dismiss();
                this.n = null;
            }
        }
    }

    public final Animation n(PbFragment pbFragment) {
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

    public final void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.pb_interview_status, (ViewGroup) this, true);
            this.f19858e = inflate;
            this.f19859f = (TextView) inflate.findViewById(R.id.interview_live_status_btn);
            this.f19861h = (FrameLayout) this.f19858e.findViewById(R.id.count_container);
            this.f19860g = (ImageView) this.f19858e.findViewById(R.id.interview_mic);
            this.k = (ImageView) this.f19858e.findViewById(R.id.interview_arrow);
            this.f19862i = (TextView) this.f19858e.findViewById(R.id.count_text);
            this.j = (ImageView) this.f19858e.findViewById(R.id.count_bg);
            this.l = this.f19858e.findViewById(R.id.interview_live_status_divider);
            this.f19858e.setAlpha(0.8f);
            SkinManager.setBackgroundColor(this.f19858e, R.color.CAM_X0302);
            SkinManager.setViewTextColor(this.f19859f, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.j, R.drawable.icon_interview_loding);
            SkinManager.setViewTextColor(this.f19862i, R.color.CAM_X0111);
            SkinManager.setBackgroundResource(this.f19860g, R.drawable.icon_interview_mic);
            SkinManager.setBackgroundResource(this.k, R.drawable.icon_arrow_tip_white);
            SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
        }
    }

    public final void p(PbFragment pbFragment) {
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
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(pbFragment.getPageContext().getPageActivity());
        this.n = aVar;
        aVar.setContentView(inflate);
        this.n.setPositiveButton((String) null, (a.e) null);
        this.n.setNegativeButton(R.string.cancel, new c(this));
        this.n.setCancelable(false);
        this.n.create(pbFragment.getPageContext());
        d.a.c.e.m.e.a().postDelayed(new d(this), TimeUnit.MICROSECONDS.toMillis(200L));
        this.q = new e(this, TimeUnit.MILLISECONDS.toMillis(3300L), TimeUnit.SECONDS.toMillis(1L), textView, pbFragment).start();
    }

    public final void q(PbFragment pbFragment, d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, pbFragment, eVar) == null) {
            int f1 = eVar.N().f1();
            if (f1 == 1) {
                long millis = TimeUnit.SECONDS.toMillis(eVar.N().e1().e()) - System.currentTimeMillis();
                if (millis > TimeUnit.SECONDS.toMillis(61L)) {
                    long millis2 = millis - TimeUnit.SECONDS.toMillis(61L);
                    this.o = new a(this, millis2, millis2, pbFragment, eVar).start();
                    this.f19858e.setVisibility(8);
                    f fVar = this.u;
                    if (fVar != null) {
                        fVar.a(false);
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c11105").param("obj_id", this.t));
                    this.f19858e.setVisibility(0);
                    f fVar2 = this.u;
                    if (fVar2 != null) {
                        fVar2.a(true);
                    }
                    this.f19859f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_before_start));
                    this.f19859f.setTextSize(0, l.g(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize24));
                    this.f19860g.setVisibility(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(8);
                    d.a.s0.h3.a.b(pbFragment, this.j, n(pbFragment), null);
                    CountDownTimer countDownTimer = this.p;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    this.p = new b(this, millis, TimeUnit.SECONDS.toMillis(1L), pbFragment).start();
                }
                setClickable(false);
            } else if (f1 != 2 && f1 != 3) {
                this.f19858e.setVisibility(8);
            } else {
                this.f19858e.setVisibility(0);
                f fVar3 = this.u;
                if (fVar3 != null) {
                    fVar3.a(true);
                }
                this.f19860g.setVisibility(8);
                this.k.setVisibility(8);
                this.f19861h.setVisibility(8);
                this.l.setVisibility(0);
                this.f19859f.setTextSize(0, l.g(pbFragment.getPageContext().getPageActivity(), R.dimen.fontsize28));
                SkinManager.setBackgroundColor(this.f19858e, R.color.CAM_X0205);
                SkinManager.setViewTextColor(this.f19859f, R.color.CAM_X0106);
                SkinManager.setBackgroundColor(this.l, R.color.CAM_X0204);
                this.f19858e.setAlpha(0.95f);
                setClickable(true);
                if (f1 == 2) {
                    this.f19859f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_in_process));
                    if (this.r) {
                        p(pbFragment);
                        return;
                    }
                    return;
                }
                this.f19859f.setText(pbFragment.getPageContext().getPageActivity().getString(R.string.interview_live_finished));
            }
        }
    }

    public void setCallback(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fVar) == null) {
            this.u = fVar;
        }
    }

    public void setData(PbFragment pbFragment, d.a.s0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, pbFragment, eVar) == null) {
            String d2 = eVar.N().e1().d();
            this.t = d2;
            if (StringUtils.isNull(d2)) {
                this.t = eVar.N().e1().f();
            }
            this.r = !"from_interview_live".equals(pbFragment.v4());
            q(pbFragment, eVar);
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
        this.f19858e = null;
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
        this.f19858e = null;
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
