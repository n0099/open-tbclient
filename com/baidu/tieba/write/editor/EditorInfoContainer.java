package com.baidu.tieba.write.editor;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.r0.s.t.a;
import c.a.r0.x.n;
import c.a.s0.n4.j;
import c.a.s0.n4.w.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.editorinfotool.LocationInfoView;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.write.write.TransmitPostEditActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.anim.AnimationProperty;
/* loaded from: classes12.dex */
public class EditorInfoContainer extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LocationInfoView f51357e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f51358f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f51359g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f51360h;

    /* renamed from: i  reason: collision with root package name */
    public int f51361i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f51362j;

    /* renamed from: k  reason: collision with root package name */
    public String f51363k;
    public String l;
    public String m;

    /* loaded from: classes12.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f51364e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f51365f;

        public a(EditorInfoContainer editorInfoContainer, AnimatorSet animatorSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, animatorSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51365f = editorInfoContainer;
            this.f51364e = animatorSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((c.a.r0.s.i0.n.b) this.f51365f.f51359g.getStyleConfig()).r(c.a.s0.n4.d.CAM_X0302);
                this.f51365f.f51359g.getStyleConfig().h(c.a.s0.n4.d.CAM_X0302);
                ((c.a.r0.s.i0.n.b) this.f51365f.f51357e.getLocationBtn().getStyleConfig()).r(c.a.s0.n4.d.CAM_X0302);
                this.f51365f.f51357e.getLocationBtn().getStyleConfig().h(c.a.s0.n4.d.CAM_X0302);
                this.f51364e.start();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f51366e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f51367f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f51368g;

        /* loaded from: classes12.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f51369e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51369e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ((c.a.r0.s.i0.n.b) this.f51369e.f51368g.f51359g.getStyleConfig()).s(c.a.s0.n4.d.CAM_X0105);
                    this.f51369e.f51368g.f51359g.getStyleConfig().h(c.a.s0.n4.d.CAM_X0110);
                    ((c.a.r0.s.i0.n.b) this.f51369e.f51368g.f51357e.getLocationBtn().getStyleConfig()).s(c.a.s0.n4.d.CAM_X0105);
                    this.f51369e.f51368g.f51357e.getLocationBtn().getStyleConfig().h(c.a.s0.n4.d.CAM_X0110);
                }
            }
        }

        /* renamed from: com.baidu.tieba.write.editor.EditorInfoContainer$b$b  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public class RunnableC1940b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f51370e;

            public RunnableC1940b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f51370e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f51370e.f51367f.start();
                }
            }
        }

        public b(EditorInfoContainer editorInfoContainer, AnimatorSet animatorSet) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, animatorSet};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51368g = editorInfoContainer;
            this.f51367f = animatorSet;
            this.f51366e = 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                int i2 = this.f51366e + 1;
                this.f51366e = i2;
                if (i2 > 1) {
                    this.f51368g.postDelayed(new a(this), 0L);
                } else {
                    this.f51368g.postDelayed(new RunnableC1940b(this), 1500L);
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f51371e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f51372f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f51373g;

        public c(EditorInfoContainer editorInfoContainer, i iVar, c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51373g = editorInfoContainer;
            this.f51371e = iVar;
            this.f51372f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f51371e != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                    this.f51371e.a(true);
                }
                this.f51372f.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f51374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.s.t.a f51375f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f51376g;

        public d(EditorInfoContainer editorInfoContainer, i iVar, c.a.r0.s.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, iVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51376g = editorInfoContainer;
            this.f51374e = iVar;
            this.f51375f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f51374e != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                    this.f51374e.a(false);
                }
                this.f51375f.dismiss();
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e implements LocationInfoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public e(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 3));
                this.a.sendAction(new c.a.r0.x.a(18, -1, null));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f51377e;

        public f(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51377e = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f51377e.sendAction(new c.a.r0.x.a(43, -1, null));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f51378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f51379f;

        /* loaded from: classes12.dex */
        public class a implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.i
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (TransmitPostEditActivity.FROM_SHARE_WRITE.equals(this.a.f51379f.l)) {
                        if (!"1".equals(this.a.f51379f.f51363k)) {
                            if ("2".equals(this.a.f51379f.f51363k)) {
                                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        }
                    }
                    if (z) {
                        int i2 = ((Integer) this.a.f51379f.f51358f.btnState).intValue() == 0 ? 1 : 0;
                        this.a.f51379f.m(i2);
                        if ("2".equals(this.a.f51379f.f51363k)) {
                            c.a.s0.n4.w.a.b(this.a.f51379f.m, i2);
                        }
                    }
                }
            }
        }

        public g(EditorInfoContainer editorInfoContainer, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51379f = editorInfoContainer;
            this.f51378e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) this.f51379f.f51358f.btnState).intValue() == 0 ? 11 : 12));
                EditorInfoContainer editorInfoContainer = this.f51379f;
                editorInfoContainer.l(this.f51378e, ((Integer) editorInfoContainer.f51358f.btnState).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes12.dex */
    public class h implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EditorInfoContainer a;

        public h(EditorInfoContainer editorInfoContainer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {editorInfoContainer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = editorInfoContainer;
        }

        @Override // c.a.s0.n4.w.a.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.m(i2);
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface i {
        void a(boolean z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EditorInfoContainer(Context context, String str) {
        this(context, str, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (AttributeSet) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.r0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f51362j) {
                this.f51362j = false;
                sendAction(new c.a.r0.x.a(18, -1, "first"));
            }
            setVisibility(0);
        }
    }

    @Override // c.a.r0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f51361i : invokeV.intValue;
    }

    @Override // c.a.r0.x.n
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            hideGuide();
            setVisibility(8);
        }
    }

    public void hideGuide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void hideToDynamic() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
        }
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, m.f(getContext(), c.a.s0.n4.e.tbds62));
            layoutParams.addRule(1, c.a.s0.n4.g.editor_id_location);
            c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
            bVar.p(c.a.s0.n4.d.CAM_X0209, c.a.s0.n4.d.CAM_X0105);
            bVar.h(c.a.s0.n4.d.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(c.a.s0.n4.e.M_W_X002));
            bVar.m(m.f(getContext(), c.a.s0.n4.e.M_W_X004), m.f(getContext(), c.a.s0.n4.e.M_W_X004));
            bVar.n(m.f(getContext(), c.a.s0.n4.e.M_H_X002));
            bVar.i(c.a.s0.n4.f.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.g(UtilHelper.getDimenPixelSize(c.a.s0.n4.e.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f51359g = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f51359g.setTextSize(c.a.s0.n4.e.T_X09);
            this.f51359g.setText(getContext().getString(j.add_topic));
            this.f51359g.setOnClickListener(new f(this));
            addView(this.f51359g, layoutParams);
        }
    }

    @Override // c.a.r0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void initPrivacyState(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) && "2".equals(this.f51363k)) {
            this.m = str;
            c.a.s0.n4.w.a.a(str, i2, new h(this));
        }
    }

    public void initPrivacyStateInWriteActivity(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && "2".equals(this.f51363k)) {
            m(i2);
        }
    }

    public void initToDynamicState(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TBSpecificationBtn tBSpecificationBtn2 = this.f51358f;
            return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.btnState).intValue() != 0) && (tBSpecificationBtn = this.f51358f) != null && ((Integer) tBSpecificationBtn.btnState).intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LocationInfoView locationInfoView = new LocationInfoView(context);
            this.f51357e = locationInfoView;
            locationInfoView.setId(c.a.s0.n4.g.editor_id_location);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(c.a.s0.n4.e.M_W_X006);
            this.f51357e.setLocationClickListener(new e(this));
            addView(this.f51357e, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, m.f(getContext(), c.a.s0.n4.e.tbds62));
            layoutParams.addRule(11);
            c.a.r0.s.i0.n.b bVar = new c.a.r0.s.i0.n.b();
            bVar.p(c.a.s0.n4.d.CAM_X0209, c.a.s0.n4.d.CAM_X0105);
            bVar.h(c.a.s0.n4.d.CAM_X0302);
            bVar.f(UtilHelper.getDimenPixelSize(c.a.s0.n4.e.M_W_X002));
            bVar.m(m.f(getContext(), c.a.s0.n4.e.M_W_X004), m.f(getContext(), c.a.s0.n4.e.M_W_X004));
            bVar.n(m.f(getContext(), c.a.s0.n4.e.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(c.a.s0.n4.e.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f51358f = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f51358f.setTextSize(c.a.s0.n4.e.T_X09);
            m(0);
            this.f51358f.setLayoutParams(layoutParams);
            this.f51358f.setOnClickListener(new g(this, context));
            addView(this.f51358f);
        }
    }

    public final void l(Context context, int i2, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, context, i2, iVar) == null) {
            boolean g2 = c.a.r0.s.g0.b.j().g("show_privacy_dialog", false);
            if (i2 == 1 || g2) {
                if (iVar != null) {
                    iVar.a(true);
                    return;
                }
                return;
            }
            c.a.r0.s.g0.b.j().t("show_privacy_dialog", true);
            BaseActivity baseActivity = (BaseActivity) context;
            c.a.r0.s.t.a aVar = new c.a.r0.s.t.a(baseActivity);
            aVar.setCancelable(false);
            aVar.setPositiveButton((String) null, (a.e) null);
            aVar.setNegativeButton((String) null, (a.e) null);
            aVar.setContentViewSize(6);
            CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
            customPrivacyDialogView.setMessageTextViewMessage(context.getString(j.write_privacy_dialog_title));
            customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(c.a.s0.n4.d.CAM_X0107));
            customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(j.write_privacy_dialog_close));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(j.write_privacy_dialog_open));
            customPrivacyDialogView.setPrivacyDialogCancelButtonListener(new c(this, iVar, aVar));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonListener(new d(this, iVar, aVar));
            aVar.setContentView(customPrivacyDialogView);
            aVar.create(baseActivity.getPageContext()).show();
            TiebaStatic.log(new StatisticItem("c13804"));
        }
    }

    public final void m(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f51358f.setText(getResources().getString(j.public_to_all));
            this.f51358f.getStyleConfig().i(i2 == 0 ? c.a.s0.n4.f.icon_pure_post_chosen12 : c.a.s0.n4.f.icon_pure_post_chose12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.f51358f.getStyleConfig().h(i2 == 0 ? c.a.s0.n4.d.CAM_X0302 : c.a.s0.n4.d.CAM_X0110);
            this.f51358f.btnState = Integer.valueOf(i2);
        }
    }

    @Override // c.a.r0.x.b
    public void onAction(c.a.r0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 19) {
            LocationInfoView locationInfoView = this.f51357e;
            if (locationInfoView == null) {
                return;
            }
            Object obj = aVar.f14019c;
            if (obj instanceof c.a.r0.x.v.a) {
                c.a.r0.x.v.a aVar2 = (c.a.r0.x.v.a) obj;
                locationInfoView.setState(aVar2.a, aVar2.f14047b);
                return;
            }
            locationInfoView.setState(0, null);
        } else if (i2 == 20) {
            LocationInfoView locationInfoView2 = this.f51357e;
            if (locationInfoView2 == null) {
                return;
            }
            locationInfoView2.setState(0, null);
        } else if (i2 == 54) {
            sendAction(new c.a.r0.x.a(55, -1, Boolean.valueOf(isPrivacy())));
        } else if (i2 != 57) {
        } else {
            sendAction(new c.a.r0.x.a(58, -1, Boolean.FALSE));
        }
    }

    @Override // c.a.r0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            LocationInfoView locationInfoView = this.f51357e;
            if (locationInfoView != null) {
                locationInfoView.onChangeSkinType(i2);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f51358f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.f51359g;
            if (tBSpecificationBtn2 != null) {
                tBSpecificationBtn2.changeSkinType();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
        }
    }

    @Override // c.a.r0.x.n
    public void sendAction(c.a.r0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) || (editorTools = this.f51360h) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.r0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.f51360h = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.l = str;
        }
    }

    @Override // c.a.r0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f51361i = i2;
        }
    }

    public void showGuideAnimate(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            int left = this.f51357e.getLeft() + 10;
            float f2 = left + 10;
            float f3 = left - 10;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f51357e, AnimationProperty.TRANSLATE_X, f2, f3, f2, f3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f51359g, AnimationProperty.TRANSLATE_X, f2, f3, f2, f3);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat2, ofFloat);
            animatorSet.setDuration(j2 / 4);
            postDelayed(new a(this, animatorSet), 1000L);
            animatorSet.addListener(new b(this, animatorSet));
        }
    }

    public void showHotTopicView(boolean z) {
        TBSpecificationBtn tBSpecificationBtn;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (tBSpecificationBtn = this.f51359g) == null) {
            return;
        }
        tBSpecificationBtn.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditorInfoContainer(Context context, String str, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, attributeSet};
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
        this.f51362j = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(c.a.s0.n4.e.M_H_X004), 0, (int) context.getResources().getDimension(c.a.s0.n4.e.M_H_X003));
        setGravity(16);
        this.f51363k = str;
        j(context);
        i(context);
        k(context);
    }
}
