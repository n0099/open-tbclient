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
import c.a.s0.s.s.a;
import c.a.s0.x.n;
import c.a.t0.p4.j;
import c.a.t0.p4.w.a;
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
/* loaded from: classes13.dex */
public class EditorInfoContainer extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LocationInfoView f49615e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f49616f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f49617g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f49618h;

    /* renamed from: i  reason: collision with root package name */
    public int f49619i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f49620j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes13.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f49621e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f49622f;

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
            this.f49622f = editorInfoContainer;
            this.f49621e = animatorSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((c.a.s0.s.j0.n.b) this.f49622f.f49617g.getStyleConfig()).r(c.a.t0.p4.d.CAM_X0302);
                this.f49622f.f49617g.getStyleConfig().h(c.a.t0.p4.d.CAM_X0302);
                ((c.a.s0.s.j0.n.b) this.f49622f.f49615e.getLocationBtn().getStyleConfig()).r(c.a.t0.p4.d.CAM_X0302);
                this.f49622f.f49615e.getLocationBtn().getStyleConfig().h(c.a.t0.p4.d.CAM_X0302);
                this.f49621e.start();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f49623e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f49624f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f49625g;

        /* loaded from: classes13.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f49626e;

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
                this.f49626e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ((c.a.s0.s.j0.n.b) this.f49626e.f49625g.f49617g.getStyleConfig()).s(c.a.t0.p4.d.CAM_X0105);
                    this.f49626e.f49625g.f49617g.getStyleConfig().h(c.a.t0.p4.d.CAM_X0110);
                    ((c.a.s0.s.j0.n.b) this.f49626e.f49625g.f49615e.getLocationBtn().getStyleConfig()).s(c.a.t0.p4.d.CAM_X0105);
                    this.f49626e.f49625g.f49615e.getLocationBtn().getStyleConfig().h(c.a.t0.p4.d.CAM_X0110);
                }
            }
        }

        /* renamed from: com.baidu.tieba.write.editor.EditorInfoContainer$b$b  reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public class RunnableC1964b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f49627e;

            public RunnableC1964b(b bVar) {
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
                this.f49627e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f49627e.f49624f.start();
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
            this.f49625g = editorInfoContainer;
            this.f49624f = animatorSet;
            this.f49623e = 0;
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
                int i2 = this.f49623e + 1;
                this.f49623e = i2;
                if (i2 > 1) {
                    this.f49625g.postDelayed(new a(this), 0L);
                } else {
                    this.f49625g.postDelayed(new RunnableC1964b(this), 1500L);
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

    /* loaded from: classes13.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f49628e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f49629f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f49630g;

        public c(EditorInfoContainer editorInfoContainer, i iVar, c.a.s0.s.s.a aVar) {
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
            this.f49630g = editorInfoContainer;
            this.f49628e = iVar;
            this.f49629f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49628e != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                    this.f49628e.a(true);
                }
                this.f49629f.dismiss();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f49631e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.s0.s.s.a f49632f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f49633g;

        public d(EditorInfoContainer editorInfoContainer, i iVar, c.a.s0.s.s.a aVar) {
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
            this.f49633g = editorInfoContainer;
            this.f49631e = iVar;
            this.f49632f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f49631e != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                    this.f49631e.a(false);
                }
                this.f49632f.dismiss();
            }
        }
    }

    /* loaded from: classes13.dex */
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
                this.a.sendAction(new c.a.s0.x.a(18, -1, null));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f49634e;

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
            this.f49634e = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f49634e.sendAction(new c.a.s0.x.a(43, -1, null));
            }
        }
    }

    /* loaded from: classes13.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f49635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f49636f;

        /* loaded from: classes13.dex */
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
                    if (TransmitPostEditActivity.FROM_SHARE_WRITE.equals(this.a.f49636f.l)) {
                        if (!"1".equals(this.a.f49636f.k)) {
                            if ("2".equals(this.a.f49636f.k)) {
                                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        }
                    }
                    if (z) {
                        int i2 = ((Integer) this.a.f49636f.f49616f.btnState).intValue() == 0 ? 1 : 0;
                        this.a.f49636f.m(i2);
                        if ("2".equals(this.a.f49636f.k)) {
                            c.a.t0.p4.w.a.b(this.a.f49636f.m, i2);
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
            this.f49636f = editorInfoContainer;
            this.f49635e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) this.f49636f.f49616f.btnState).intValue() == 0 ? 11 : 12));
                EditorInfoContainer editorInfoContainer = this.f49636f;
                editorInfoContainer.l(this.f49635e, ((Integer) editorInfoContainer.f49616f.btnState).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes13.dex */
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

        @Override // c.a.t0.p4.w.a.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.a.m(i2);
            }
        }
    }

    /* loaded from: classes13.dex */
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

    @Override // c.a.s0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f49620j) {
                this.f49620j = false;
                sendAction(new c.a.s0.x.a(18, -1, "first"));
            }
            setVisibility(0);
        }
    }

    @Override // c.a.s0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f49619i : invokeV.intValue;
    }

    @Override // c.a.s0.x.n
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.tbds62));
            layoutParams.addRule(1, c.a.t0.p4.g.editor_id_location);
            c.a.s0.s.j0.n.b bVar = new c.a.s0.s.j0.n.b();
            bVar.p(c.a.t0.p4.d.CAM_X0209, c.a.t0.p4.d.CAM_X0105);
            bVar.h(c.a.t0.p4.d.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.M_W_X002));
            bVar.m(c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.M_W_X004), c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.M_W_X004));
            bVar.n(c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.M_H_X002));
            bVar.i(c.a.t0.p4.f.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.g(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f49617g = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f49617g.setTextSize(c.a.t0.p4.e.T_X09);
            this.f49617g.setText(getContext().getString(j.add_topic));
            this.f49617g.setOnClickListener(new f(this));
            addView(this.f49617g, layoutParams);
        }
    }

    @Override // c.a.s0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void initPrivacyState(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) && "2".equals(this.k)) {
            this.m = str;
            c.a.t0.p4.w.a.a(str, i2, new h(this));
        }
    }

    public void initPrivacyStateInWriteActivity(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) && "2".equals(this.k)) {
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
            TBSpecificationBtn tBSpecificationBtn2 = this.f49616f;
            return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.btnState).intValue() != 0) && (tBSpecificationBtn = this.f49616f) != null && ((Integer) tBSpecificationBtn.btnState).intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LocationInfoView locationInfoView = new LocationInfoView(context);
            this.f49615e = locationInfoView;
            locationInfoView.setId(c.a.t0.p4.g.editor_id_location);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(c.a.t0.p4.e.M_W_X006);
            this.f49615e.setLocationClickListener(new e(this));
            addView(this.f49615e, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.tbds62));
            layoutParams.addRule(11);
            c.a.s0.s.j0.n.b bVar = new c.a.s0.s.j0.n.b();
            bVar.p(c.a.t0.p4.d.CAM_X0209, c.a.t0.p4.d.CAM_X0105);
            bVar.h(c.a.t0.p4.d.CAM_X0302);
            bVar.f(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.M_W_X002));
            bVar.m(c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.M_W_X004), c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.M_W_X004));
            bVar.n(c.a.d.f.p.n.f(getContext(), c.a.t0.p4.e.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(c.a.t0.p4.e.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f49616f = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f49616f.setTextSize(c.a.t0.p4.e.T_X09);
            m(0);
            this.f49616f.setLayoutParams(layoutParams);
            this.f49616f.setOnClickListener(new g(this, context));
            addView(this.f49616f);
        }
    }

    public final void l(Context context, int i2, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, context, i2, iVar) == null) {
            boolean h2 = c.a.s0.s.h0.b.k().h("show_privacy_dialog", false);
            if (i2 == 1 || h2) {
                if (iVar != null) {
                    iVar.a(true);
                    return;
                }
                return;
            }
            c.a.s0.s.h0.b.k().u("show_privacy_dialog", true);
            BaseActivity baseActivity = (BaseActivity) context;
            c.a.s0.s.s.a aVar = new c.a.s0.s.s.a(baseActivity);
            aVar.setCancelable(false);
            aVar.setPositiveButton((String) null, (a.e) null);
            aVar.setNegativeButton((String) null, (a.e) null);
            aVar.setContentViewSize(6);
            CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
            customPrivacyDialogView.setMessageTextViewMessage(context.getString(j.write_privacy_dialog_title));
            customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(c.a.t0.p4.d.CAM_X0107));
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
            this.f49616f.setText(getResources().getString(j.public_to_all));
            this.f49616f.getStyleConfig().i(i2 == 0 ? c.a.t0.p4.f.icon_pure_post_chosen12 : c.a.t0.p4.f.icon_pure_post_chose12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.f49616f.getStyleConfig().h(i2 == 0 ? c.a.t0.p4.d.CAM_X0302 : c.a.t0.p4.d.CAM_X0110);
            this.f49616f.btnState = Integer.valueOf(i2);
        }
    }

    @Override // c.a.s0.x.b
    public void onAction(c.a.s0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.a;
        if (i2 == 19) {
            LocationInfoView locationInfoView = this.f49615e;
            if (locationInfoView == null) {
                return;
            }
            Object obj = aVar.f14180c;
            if (obj instanceof c.a.s0.x.w.a) {
                c.a.s0.x.w.a aVar2 = (c.a.s0.x.w.a) obj;
                locationInfoView.setState(aVar2.a, aVar2.f14216b);
                return;
            }
            locationInfoView.setState(0, null);
        } else if (i2 == 20) {
            LocationInfoView locationInfoView2 = this.f49615e;
            if (locationInfoView2 == null) {
                return;
            }
            locationInfoView2.setState(0, null);
        } else if (i2 == 54) {
            sendAction(new c.a.s0.x.a(55, -1, Boolean.valueOf(isPrivacy())));
        } else if (i2 != 57) {
        } else {
            sendAction(new c.a.s0.x.a(58, -1, Boolean.FALSE));
        }
    }

    @Override // c.a.s0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            LocationInfoView locationInfoView = this.f49615e;
            if (locationInfoView != null) {
                locationInfoView.onChangeSkinType(i2);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f49616f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.f49617g;
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

    @Override // c.a.s0.x.n
    public void sendAction(c.a.s0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) || (editorTools = this.f49618h) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.s0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.f49618h = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.l = str;
        }
    }

    @Override // c.a.s0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f49619i = i2;
        }
    }

    public void showGuideAnimate(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            int left = this.f49615e.getLeft() + 10;
            float f2 = left + 10;
            float f3 = left - 10;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f49615e, AnimationProperty.TRANSLATE_X, f2, f3, f2, f3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f49617g, AnimationProperty.TRANSLATE_X, f2, f3, f2, f3);
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
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (tBSpecificationBtn = this.f49617g) == null) {
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
        this.f49620j = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(c.a.t0.p4.e.M_H_X004), 0, (int) context.getResources().getDimension(c.a.t0.p4.e.M_H_X003));
        setGravity(16);
        this.k = str;
        j(context);
        i(context);
        k(context);
    }
}
