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
import c.a.e.e.p.l;
import c.a.q0.s.s.a;
import c.a.q0.x.n;
import c.a.r0.c4.m.a;
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
import com.baidu.tieba.R;
import com.baidu.tieba.write.view.CustomPrivacyDialogView;
import com.baidu.tieba.write.write.TransmitPostEditActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class EditorInfoContainer extends RelativeLayout implements n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public LocationInfoView f58766e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f58767f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f58768g;

    /* renamed from: h  reason: collision with root package name */
    public EditorTools f58769h;

    /* renamed from: i  reason: collision with root package name */
    public int f58770i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f58771j;
    public String k;
    public String l;
    public String m;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f58772e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58773f;

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
            this.f58773f = editorInfoContainer;
            this.f58772e = animatorSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ((c.a.q0.s.f0.n.b) this.f58773f.f58768g.getStyleConfig()).q(R.color.CAM_X0302);
                this.f58773f.f58768g.getStyleConfig().h(R.color.CAM_X0302);
                ((c.a.q0.s.f0.n.b) this.f58773f.f58766e.getLocationBtn().getStyleConfig()).q(R.color.CAM_X0302);
                this.f58773f.f58766e.getLocationBtn().getStyleConfig().h(R.color.CAM_X0302);
                this.f58772e.start();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f58774e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AnimatorSet f58775f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58776g;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f58777e;

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
                this.f58777e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ((c.a.q0.s.f0.n.b) this.f58777e.f58776g.f58768g.getStyleConfig()).r(R.color.CAM_X0105);
                    this.f58777e.f58776g.f58768g.getStyleConfig().h(R.color.CAM_X0110);
                    ((c.a.q0.s.f0.n.b) this.f58777e.f58776g.f58766e.getLocationBtn().getStyleConfig()).r(R.color.CAM_X0105);
                    this.f58777e.f58776g.f58766e.getLocationBtn().getStyleConfig().h(R.color.CAM_X0110);
                }
            }
        }

        /* renamed from: com.baidu.tieba.write.editor.EditorInfoContainer$b$b  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1805b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f58778e;

            public RunnableC1805b(b bVar) {
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
                this.f58778e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f58778e.f58775f.start();
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
            this.f58776g = editorInfoContainer;
            this.f58775f = animatorSet;
            this.f58774e = 0;
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
                int i2 = this.f58774e + 1;
                this.f58774e = i2;
                if (i2 > 1) {
                    this.f58776g.postDelayed(new a(this), 0L);
                } else {
                    this.f58776g.postDelayed(new RunnableC1805b(this), 1500L);
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

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f58779e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f58780f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58781g;

        public c(EditorInfoContainer editorInfoContainer, i iVar, c.a.q0.s.s.a aVar) {
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
            this.f58781g = editorInfoContainer;
            this.f58779e = iVar;
            this.f58780f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f58779e != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 2));
                    this.f58779e.a(true);
                }
                this.f58780f.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f58782e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c.a.q0.s.s.a f58783f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58784g;

        public d(EditorInfoContainer editorInfoContainer, i iVar, c.a.q0.s.s.a aVar) {
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
            this.f58784g = editorInfoContainer;
            this.f58782e = iVar;
            this.f58783f = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (this.f58782e != null) {
                    TiebaStatic.log(new StatisticItem("c13805").param("obj_locate", 1));
                    this.f58782e.a(false);
                }
                this.f58783f.dismiss();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements LocationInfoView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58785a;

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
            this.f58785a = editorInfoContainer;
        }

        @Override // com.baidu.tbadk.editortools.editorinfotool.LocationInfoView.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", 3));
                this.f58785a.sendAction(new c.a.q0.x.a(18, -1, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58786e;

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
            this.f58786e = editorInfoContainer;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58786e.sendAction(new c.a.q0.x.a(43, -1, null));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f58787e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58788f;

        /* loaded from: classes7.dex */
        public class a implements i {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ g f58789a;

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
                this.f58789a = gVar;
            }

            @Override // com.baidu.tieba.write.editor.EditorInfoContainer.i
            public void a(boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                    if (TransmitPostEditActivity.FROM_SHARE_WRITE.equals(this.f58789a.f58788f.l)) {
                        if (!"1".equals(this.f58789a.f58788f.k)) {
                            if ("2".equals(this.f58789a.f58788f.k)) {
                                TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 5));
                            }
                        } else {
                            TiebaStatic.log(new StatisticItem("c12608").param("obj_locate", 6));
                        }
                    }
                    if (z) {
                        int i2 = ((Integer) this.f58789a.f58788f.f58767f.btnState).intValue() == 0 ? 1 : 0;
                        this.f58789a.f58788f.m(i2);
                        if ("2".equals(this.f58789a.f58788f.k)) {
                            c.a.r0.c4.m.a.b(this.f58789a.f58788f.m, i2);
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
            this.f58788f = editorInfoContainer;
            this.f58787e = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FUNCTION_PANEL_CLIKED).param("obj_locate", ((Integer) this.f58788f.f58767f.btnState).intValue() == 0 ? 11 : 12));
                EditorInfoContainer editorInfoContainer = this.f58788f;
                editorInfoContainer.l(this.f58787e, ((Integer) editorInfoContainer.f58767f.btnState).intValue(), new a(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ EditorInfoContainer f58790a;

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
            this.f58790a = editorInfoContainer;
        }

        @Override // c.a.r0.c4.m.a.c
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f58790a.m(i2);
            }
        }
    }

    /* loaded from: classes7.dex */
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

    @Override // c.a.q0.x.n
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f58771j) {
                this.f58771j = false;
                sendAction(new c.a.q0.x.a(18, -1, "first"));
            }
            setVisibility(0);
        }
    }

    @Override // c.a.q0.x.n
    public int getToolId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f58770i : invokeV.intValue;
    }

    @Override // c.a.q0.x.n
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
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
            layoutParams.addRule(1, R.id.editor_id_location);
            c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
            bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.h(R.color.CAM_X0110);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
            bVar.m(l.g(getContext(), R.dimen.M_H_X002));
            bVar.i(R.drawable.ic_icon_pure_post_topic12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f58768g = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f58768g.setTextSize(R.dimen.T_X09);
            this.f58768g.setText(getContext().getString(R.string.add_topic));
            this.f58768g.setOnClickListener(new f(this));
            addView(this.f58768g, layoutParams);
        }
    }

    @Override // c.a.q0.x.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public void initPrivacyState(String str, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048583, this, str, i2) == null) && "2".equals(this.k)) {
            this.m = str;
            c.a.r0.c4.m.a.a(str, i2, new h(this));
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
            TBSpecificationBtn tBSpecificationBtn2 = this.f58767f;
            return (tBSpecificationBtn2 == null || ((Integer) tBSpecificationBtn2.btnState).intValue() != 0) && (tBSpecificationBtn = this.f58767f) != null && ((Integer) tBSpecificationBtn.btnState).intValue() == 1;
        }
        return invokeV.booleanValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, context) == null) {
            LocationInfoView locationInfoView = new LocationInfoView(context);
            this.f58766e = locationInfoView;
            locationInfoView.setId(R.id.editor_id_location);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.M_W_X006);
            this.f58766e.setLocationClickListener(new e(this));
            addView(this.f58766e, layoutParams);
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, context) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.g(getContext(), R.dimen.tbds62));
            layoutParams.addRule(11);
            c.a.q0.s.f0.n.b bVar = new c.a.q0.s.f0.n.b();
            bVar.o(R.color.CAM_X0209, R.color.CAM_X0105);
            bVar.h(R.color.CAM_X0302);
            bVar.f(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
            bVar.l(l.g(getContext(), R.dimen.M_W_X004), l.g(getContext(), R.dimen.M_W_X004));
            bVar.m(l.g(getContext(), R.dimen.M_H_X002));
            bVar.g(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
            TBSpecificationBtn tBSpecificationBtn = new TBSpecificationBtn(context);
            this.f58767f = tBSpecificationBtn;
            tBSpecificationBtn.setConfig(bVar);
            this.f58767f.setTextSize(R.dimen.T_X09);
            m(0);
            this.f58767f.setLayoutParams(layoutParams);
            this.f58767f.setOnClickListener(new g(this, context));
            addView(this.f58767f);
        }
    }

    public final void l(Context context, int i2, i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048589, this, context, i2, iVar) == null) {
            boolean g2 = c.a.q0.s.d0.b.j().g("show_privacy_dialog", false);
            if (i2 == 1 || g2) {
                if (iVar != null) {
                    iVar.a(true);
                    return;
                }
                return;
            }
            c.a.q0.s.d0.b.j().t("show_privacy_dialog", true);
            BaseActivity baseActivity = (BaseActivity) context;
            c.a.q0.s.s.a aVar = new c.a.q0.s.s.a(baseActivity);
            aVar.setCancelable(false);
            aVar.setPositiveButton((String) null, (a.e) null);
            aVar.setNegativeButton((String) null, (a.e) null);
            aVar.setContentViewSize(6);
            CustomPrivacyDialogView customPrivacyDialogView = new CustomPrivacyDialogView(context);
            customPrivacyDialogView.setMessageTextViewMessage(context.getString(R.string.write_privacy_dialog_title));
            customPrivacyDialogView.setMessageTextViewColor(SkinManager.getColor(R.color.CAM_X0107));
            customPrivacyDialogView.setPrivacyDialogCancelButtonText(context.getString(R.string.write_privacy_dialog_close));
            customPrivacyDialogView.setPrivacyDialogConfirmButtonText(context.getString(R.string.write_privacy_dialog_open));
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
            this.f58767f.setText(getResources().getString(R.string.public_to_all));
            this.f58767f.getStyleConfig().i(i2 == 0 ? R.drawable.icon_pure_post_chosen12 : R.drawable.icon_pure_post_chose12, 0, TBSpecificationButtonConfig.IconType.WEBP);
            this.f58767f.getStyleConfig().h(i2 == 0 ? R.color.CAM_X0302 : R.color.CAM_X0110);
            this.f58767f.btnState = Integer.valueOf(i2);
        }
    }

    @Override // c.a.q0.x.b
    public void onAction(c.a.q0.x.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, aVar) == null) || aVar == null) {
            return;
        }
        int i2 = aVar.f15079a;
        if (i2 == 19) {
            LocationInfoView locationInfoView = this.f58766e;
            if (locationInfoView == null) {
                return;
            }
            Object obj = aVar.f15081c;
            if (obj instanceof c.a.q0.x.u.a) {
                c.a.q0.x.u.a aVar2 = (c.a.q0.x.u.a) obj;
                locationInfoView.setState(aVar2.f15106a, aVar2.f15107b);
                return;
            }
            locationInfoView.setState(0, null);
        } else if (i2 == 20) {
            LocationInfoView locationInfoView2 = this.f58766e;
            if (locationInfoView2 == null) {
                return;
            }
            locationInfoView2.setState(0, null);
        } else if (i2 == 54) {
            sendAction(new c.a.q0.x.a(55, -1, Boolean.valueOf(isPrivacy())));
        } else if (i2 != 57) {
        } else {
            sendAction(new c.a.q0.x.a(58, -1, Boolean.FALSE));
        }
    }

    @Override // c.a.q0.x.n
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            LocationInfoView locationInfoView = this.f58766e;
            if (locationInfoView != null) {
                locationInfoView.onChangeSkinType(i2);
            }
            TBSpecificationBtn tBSpecificationBtn = this.f58767f;
            if (tBSpecificationBtn != null) {
                tBSpecificationBtn.changeSkinType();
            }
            TBSpecificationBtn tBSpecificationBtn2 = this.f58768g;
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

    @Override // c.a.q0.x.n
    public void sendAction(c.a.q0.x.a aVar) {
        EditorTools editorTools;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) || (editorTools = this.f58769h) == null) {
            return;
        }
        editorTools.sendAction(aVar);
    }

    @Override // c.a.q0.x.n
    public void setEditorTools(EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, editorTools) == null) {
            this.f58769h = editorTools;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            this.l = str;
        }
    }

    @Override // c.a.q0.x.n
    public void setToolId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.f58770i = i2;
        }
    }

    public void showGuideAnimate(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j2) == null) {
            int left = this.f58766e.getLeft() + 10;
            float f2 = left + 10;
            float f3 = left - 10;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f58766e, "translationX", f2, f3, f2, f3);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f58768g, "translationX", f2, f3, f2, f3);
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
        if (!(interceptable == null || interceptable.invokeZ(1048599, this, z) == null) || (tBSpecificationBtn = this.f58768g) == null) {
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
        this.f58771j = true;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setPadding(0, (int) context.getResources().getDimension(R.dimen.M_H_X004), 0, (int) context.getResources().getDimension(R.dimen.M_H_X003));
        setGravity(16);
        this.k = str;
        j(context);
        i(context);
        k(context);
    }
}
