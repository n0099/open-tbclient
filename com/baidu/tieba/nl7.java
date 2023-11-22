package com.baidu.tieba;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
/* loaded from: classes7.dex */
public final class nl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public boolean B;
    public boolean C;
    public ArrayList<String> D;
    public final String E;
    public final Animator.AnimatorListener F;
    public final ValueAnimator.AnimatorUpdateListener G;
    public final Animator.AnimatorListener H;
    public final ValueAnimator.AnimatorUpdateListener I;
    public final View.OnClickListener J;
    public final Runnable K;
    public final Context a;
    public ew4 b;
    public boolean c;
    public TbImageView d;
    public int e;
    public boolean f;
    public boolean g;
    public ViewGroup h;
    public View i;
    public TbImageView j;
    public ImageView k;
    public a l;
    public final int m;
    public final float n;
    public final float o;
    public final float p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public ValueAnimator y;
    public ValueAnimator z;

    /* loaded from: classes7.dex */
    public interface a {
        void a(float f, float f2);
    }

    /* loaded from: classes7.dex */
    public static final class b extends TypeToken<List<? extends String>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl7 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public c(nl7 nl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl7Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ValueAnimator valueAnimator = this.a.z;
                if (valueAnimator != null) {
                    valueAnimator.setStartDelay(this.a.u);
                }
                ValueAnimator valueAnimator2 = this.a.z;
                if (valueAnimator2 != null) {
                    valueAnimator2.start();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nl7 a;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        }

        public d(nl7 nl7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nl7Var;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.a.A++;
                if (this.a.A == this.a.s) {
                    this.a.C = false;
                    this.a.B = false;
                    return;
                }
                ValueAnimator valueAnimator = this.a.y;
                if (valueAnimator != null) {
                    valueAnimator.setStartDelay(this.a.w);
                }
                ValueAnimator valueAnimator2 = this.a.y;
                if (valueAnimator2 != null) {
                    valueAnimator2.start();
                }
            }
        }
    }

    public nl7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.m = 200;
        this.n = 500.0f;
        this.o = 0.5f;
        this.p = 0.8f;
        this.q = 4800;
        this.r = 500;
        this.s = 2;
        this.t = 800;
        this.u = 150;
        this.v = 800;
        this.w = 250;
        this.x = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds260);
        this.E = "999999";
        this.F = new c(this);
        this.G = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.hl7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    nl7.r(nl7.this, valueAnimator);
                }
            }
        };
        this.H = new d(this);
        this.I = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.al7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                    nl7.s(nl7.this, valueAnimator);
                }
            }
        };
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.y = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(this.t);
        }
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.addListener(this.F);
        }
        ValueAnimator valueAnimator2 = this.y;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(this.G);
        }
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.z = ofFloat2;
        if (ofFloat2 != null) {
            ofFloat2.setDuration(this.v);
        }
        ValueAnimator valueAnimator3 = this.z;
        if (valueAnimator3 != null) {
            valueAnimator3.addListener(this.H);
        }
        ValueAnimator valueAnimator4 = this.z;
        if (valueAnimator4 != null) {
            valueAnimator4.addUpdateListener(this.I);
        }
        this.J = new View.OnClickListener() { // from class: com.baidu.tieba.fl7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    nl7.q(nl7.this, view2);
                }
            }
        };
        this.K = new Runnable() { // from class: com.baidu.tieba.jl7
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    nl7.t(nl7.this);
                }
            }
        };
    }

    public static final void A(nl7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.l();
        }
    }

    public final void j(ew4 data, ViewGroup completeAdContainer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, data, completeAdContainer) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(completeAdContainer, "completeAdContainer");
            this.b = data;
            this.h = completeAdContainer;
        }
    }

    public final void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.c = z;
            if (z && this.b != null) {
                TbImageView tbImageView = this.d;
                Intrinsics.checkNotNull(tbImageView);
                ew4 ew4Var = this.b;
                Intrinsics.checkNotNull(ew4Var);
                tbImageView.startLoad(ew4Var.a, 10, false);
            }
        }
    }

    public final void y(a onscrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onscrollListener) == null) {
            Intrinsics.checkNotNullParameter(onscrollListener, "onscrollListener");
            this.l = onscrollListener;
        }
    }

    public static final void q(nl7 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ew4 ew4Var = this$0.b;
            if (ew4Var != null) {
                boolean v = this$0.v();
                this$0.l();
                if (v) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_CLICK_JUMP_H5).param("fid", ew4Var.j).param("obj_id", ew4Var.i));
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5).param("fid", ew4Var.j).param("obj_id", ew4Var.i));
                    ThirdStatisticHelper.sendReq(ew4Var.e);
                }
            }
        }
    }

    public static final void r(nl7 this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                a aVar = this$0.l;
                if (aVar != null) {
                    aVar.a(0.0f, -(floatValue * this$0.x));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void s(nl7 this$0, ValueAnimator valueAnimator) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, this$0, valueAnimator) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue != null) {
                float floatValue = ((Float) animatedValue).floatValue();
                a aVar = this$0.l;
                if (aVar != null) {
                    aVar.a(0.0f, -(floatValue * this$0.x));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final void t(nl7 this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ew4 ew4Var = this$0.b;
            if (ew4Var != null) {
                boolean v = this$0.v();
                this$0.l();
                if (v) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_AUTO_JUMP_H5).param("fid", ew4Var.j).param("obj_id", ew4Var.i));
                    ThirdStatisticHelper.sendReq(ew4Var.e);
                }
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.B = true;
            if (!this.f || this.s <= 0) {
                return;
            }
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null) {
                valueAnimator.setStartDelay(0L);
            }
            ValueAnimator valueAnimator2 = this.z;
            if (valueAnimator2 != null) {
                valueAnimator2.setStartDelay(0L);
            }
            this.A = 0;
            ValueAnimator valueAnimator3 = this.y;
            if (valueAnimator3 != null) {
                valueAnimator3.start();
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && k()) {
            B();
        }
    }

    public final int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final float o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.n * this.p;
        }
        return invokeV.floatValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            l();
        }
    }

    public final boolean k() {
        InterceptResult invokeV;
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean z = false;
            if (this.b != null && p()) {
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null) {
                    currentAccount = this.E;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(currentAccount);
                ew4 ew4Var = this.b;
                Intrinsics.checkNotNull(ew4Var);
                sb.append(ew4Var.i);
                String sb2 = sb.toString();
                Object fromJson = new Gson().fromJson(SharedPrefHelper.getInstance().getString("key_uid_adid", ""), new b().getType());
                Iterator<String> it = null;
                if (fromJson instanceof ArrayList) {
                    arrayList = (ArrayList) fromJson;
                } else {
                    arrayList = null;
                }
                this.D = arrayList;
                if (arrayList == null) {
                    this.D = new ArrayList<>();
                }
                ArrayList<String> arrayList2 = this.D;
                if (arrayList2 != null) {
                    it = arrayList2.iterator();
                }
                if (it != null) {
                    Iterator asMutableIterator = TypeIntrinsics.asMutableIterator(it);
                    while (asMutableIterator.hasNext()) {
                        String str = (String) asMutableIterator.next();
                        if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong(str, 0L))) {
                            SharedPrefHelper.getInstance().remove(str);
                            asMutableIterator.remove();
                        }
                    }
                    if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong(sb2, 0L))) {
                        ArrayList<String> arrayList3 = this.D;
                        if (arrayList3 != null) {
                            arrayList3.add(sb2);
                        }
                        SharedPrefHelper.getInstance().putLong(sb2, System.currentTimeMillis());
                        z = true;
                    }
                    SharedPrefHelper.getInstance().putString("key_uid_adid", String.valueOf(this.D));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableIterator<kotlin.String>");
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public final void l() {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View view2 = this.i;
            if (view2 != null) {
                viewParent = view2.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                ViewGroup viewGroup = this.h;
                if (viewGroup != null) {
                    viewGroup.removeView(this.i);
                }
                Context context = this.a;
                if (context instanceof BaseActivity) {
                    ((BaseActivity) context).setSwipeBackEnabled(this.g);
                } else if (context instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) context).setSwipeBackEnabled(this.g);
                }
                SafeHandler.getInst().removeCallbacks(this.K);
            }
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            TbPageContext<?> currentPageContext = TbadkCoreApplication.getInst().getCurrentPageContext(this.a);
            Intrinsics.checkNotNullExpressionValue(currentPageContext, "getInst().getCurrentPageContext(context)");
            ew4 ew4Var = this.b;
            if (ew4Var == null || UtilHelper.isMatchScheme(currentPageContext.getPageActivity().getBaseContext(), ew4Var.f, ew4Var.g)) {
                return false;
            }
            UrlManager.getInstance().dealOneLink(currentPageContext, new String[]{ew4Var.b}, true);
            return true;
        }
        return invokeV.booleanValue;
    }

    public final String m(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
            if (!this.B && f >= this.o) {
                if (f < this.p) {
                    String string = this.a.getString(R.string.surprise_continue_drop_down);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…prise_continue_drop_down)");
                    return string;
                }
                String string2 = this.a.getString(R.string.surprise_when_release_hand);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…rprise_when_release_hand)");
                return string2;
            }
            String string3 = this.a.getString(R.string.surprise_in_drop_down);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.surprise_in_drop_down)");
            return string3;
        }
        return (String) invokeF.objValue;
    }

    public final void x(TbImageView advancedAdView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048588, this, advancedAdView, i, i2) == null) {
            Intrinsics.checkNotNullParameter(advancedAdView, "advancedAdView");
            this.d = advancedAdView;
            this.e = i;
        }
    }

    public final void z() {
        ViewParent viewParent;
        TbImageView tbImageView;
        float f;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && this.b != null && this.h != null) {
            ImageView imageView = null;
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.cover_advanced_ad_view, (ViewGroup) null);
            this.i = inflate;
            if (inflate != null) {
                viewParent = inflate.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent != null) {
                return;
            }
            View view2 = this.i;
            if (view2 != null) {
                view2.setOnClickListener(this.J);
            }
            ViewGroup viewGroup = this.h;
            if (viewGroup != null) {
                viewGroup.addView(this.i);
            }
            View view3 = this.i;
            if (view3 != null) {
                tbImageView = (TbImageView) view3.findViewById(R.id.advanced_ad_image_view);
            } else {
                tbImageView = null;
            }
            this.j = tbImageView;
            if (tbImageView != null) {
                tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            TbImageView tbImageView2 = this.j;
            if (tbImageView2 != null) {
                ew4 ew4Var = this.b;
                if (ew4Var != null) {
                    str = ew4Var.a;
                } else {
                    str = null;
                }
                tbImageView2.startLoad(str, 10, false);
            }
            View view4 = this.i;
            if (view4 != null) {
                imageView = (ImageView) view4.findViewById(R.id.advanced_ad_close_btn);
            }
            this.k = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.il7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view5) == null) {
                            nl7.A(nl7.this, view5);
                        }
                    }
                });
            }
            WebPManager.setPureDrawable(this.k, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0101, WebPManager.ResourceStateType.NORMAL_PRESS);
            Context context = this.a;
            if (context instanceof BaseActivity) {
                this.g = ((BaseActivity) context).isSwipeBackEnabled();
                ((BaseActivity) this.a).setSwipeBackEnabled(false);
            } else if (context instanceof BaseFragmentActivity) {
                this.g = ((BaseFragmentActivity) context).isSwipeBackEnabled();
                ((BaseFragmentActivity) this.a).setSwipeBackEnabled(false);
            }
            int equipmentHeight = BdUtilHelper.getEquipmentHeight(this.a) - this.e;
            TbImageView tbImageView3 = this.d;
            if (tbImageView3 != null) {
                equipmentHeight = (tbImageView3.getHeight() - ((int) Math.abs(tbImageView3.getTranslationY()))) - this.e;
            }
            if (equipmentHeight < 0) {
                equipmentHeight = 0;
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i, View.Y, -equipmentHeight, 0.0f);
            ofFloat.setDuration((int) (((f * 1.0f) / this.q) * 1000));
            ofFloat.start();
            ew4 ew4Var2 = this.b;
            if (ew4Var2 != null) {
                int i = ew4Var2.c;
                int i2 = this.r;
                if (i < i2) {
                    i = i2;
                }
                SafeHandler.getInst().postDelayed(this.K, i);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_FRS_ADVANCED_AD_COMPLETE_SHOW).param("fid", ew4Var2.j).param("obj_id", ew4Var2.i));
                ThirdStatisticHelper.sendReq(ew4Var2.d);
            }
        }
    }
}
