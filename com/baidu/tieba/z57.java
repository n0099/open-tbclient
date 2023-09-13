package com.baidu.tieba;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.face.view.EmotionPreview;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.faceshop.EmotionPackageDetailActivity;
import com.baidu.tieba.faceshop.packagedetail.PackageDetailListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes9.dex */
public class z57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmotionPackageDetailActivity a;
    public final float b;
    public final int c;
    public final int d;
    public final Rect e;
    public int f;
    public int g;
    public int h;
    public int i;
    public Handler j;
    public EmotionPreview k;
    public PackageDetailListView l;
    public boolean m;
    public boolean n;
    public FrameLayout o;
    public int p;
    public e q;
    public final Runnable r;
    public final PackageDetailListView.a s;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z57 a;

        public a(z57 z57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z57Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements PackageDetailListView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z57 a;

        public b(z57 z57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z57Var;
        }

        @Override // com.baidu.tieba.faceshop.packagedetail.PackageDetailListView.a
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            InterceptResult invokeL;
            e v;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, motionEvent)) == null) {
                if (motionEvent == null) {
                    return false;
                }
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                                return false;
                            }
                        } else {
                            if (this.a.f > -1 && this.a.g > -1) {
                                this.a.h = (int) motionEvent.getX();
                                this.a.i = (int) motionEvent.getY();
                                if (!this.a.m && this.a.q == null) {
                                    float f = this.a.h - this.a.f;
                                    float f2 = this.a.i - this.a.g;
                                    if ((f * f) + (f2 * f2) > this.a.b * this.a.b) {
                                        this.a.m = true;
                                    }
                                } else if (this.a.q != null && (v = this.a.v()) != null && (this.a.q == null || !this.a.q.equals(v))) {
                                    this.a.z(v);
                                }
                            }
                            if (this.a.q == null) {
                                return false;
                            }
                            return true;
                        }
                    }
                    this.a.u();
                    return false;
                }
                this.a.f = (int) motionEvent.getX();
                this.a.g = (int) motionEvent.getY();
                this.a.m = false;
                this.a.A();
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class c implements AbsListView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z57 a;

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(1048576, this, absListView, i, i2, i3) == null) {
            }
        }

        public c(z57 z57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z57Var;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, absListView, i) == null) {
                this.a.u();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements SwipeBackLayout.OnSlidingStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z57 a;

        public d(z57 z57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z57Var;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.OnSlidingStateChangeListener
        public void onSlidingEnd(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeZ(1048576, this, z) != null) {
                return;
            }
            this.a.n = false;
        }

        @Override // com.baidu.adp.widget.SwipeBackLayout.OnSlidingStateChangeListener
        public void onSlidingStart() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.n = true;
            this.a.u();
        }
    }

    /* loaded from: classes9.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public int b;
        public int c;

        public e(View view2, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = i;
            this.c = i2;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == null || !(obj instanceof e)) {
                    return false;
                }
                e eVar = (e) obj;
                if (eVar.b != this.b || eVar.c != this.c || eVar.a != this.a) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public z57(EmotionPackageDetailActivity emotionPackageDetailActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emotionPackageDetailActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Rect();
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.m = false;
        this.n = false;
        this.p = 3;
        this.r = new a(this);
        this.s = new b(this);
        this.a = emotionPackageDetailActivity;
        PackageDetailListView i22 = emotionPackageDetailActivity.i2();
        this.l = i22;
        i22.setTouchEventInterceptHandler(this.s);
        this.j = emotionPackageDetailActivity.getSafeHandler();
        this.l = emotionPackageDetailActivity.i2();
        this.b = ViewConfiguration.get(emotionPackageDetailActivity).getScaledTouchSlop() * 2;
        this.c = BdUtilHelper.getDimens(emotionPackageDetailActivity, R.dimen.obfuscated_res_0x7f0703a5);
        this.d = BdUtilHelper.getDimens(emotionPackageDetailActivity, R.dimen.obfuscated_res_0x7f0703ac);
        this.l.setOnScrollListener(new c(this));
        SwipeBackLayout j2 = emotionPackageDetailActivity.j2();
        if (j2 != null) {
            j2.setOnSlidingStateChangeListener(new d(this));
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.p = i;
            EmotionPreview emotionPreview = this.k;
            if (emotionPreview != null) {
                SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, i);
            }
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.removeCallbacks(this.r);
            this.j.postDelayed(this.r, 500L);
        }
    }

    public final void B() {
        e v;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.m && !this.n && this.q == null && (v = v()) != null) {
            z(v);
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.j.removeCallbacks(this.r);
            u();
        }
    }

    public final void x() {
        EmotionPreview emotionPreview;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (emotionPreview = this.k) != null && this.o != null) {
            if (emotionPreview.getParent() != null) {
                ViewParent parent = this.k.getParent();
                FrameLayout frameLayout = this.o;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.k);
                }
            }
            this.k = null;
        }
    }

    public final boolean t(View view2, EmotionPackageData.SingleEmotionData singleEmotionData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, singleEmotionData)) == null) {
            if (singleEmotionData == null || TextUtils.isEmpty(singleEmotionData.url) || view2 == null) {
                return false;
            }
            Log.d("PackageDetailPreview", "show preview, url: " + singleEmotionData.url);
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            EmotionPreview emotionPreview = new EmotionPreview(this.a);
            this.k = emotionPreview;
            SkinManager.setBackgroundResource(emotionPreview, R.drawable.bg_expression_bubble, this.p);
            this.k.e(singleEmotionData.url, singleEmotionData.thumbnail, false, 10);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.c, this.d);
            int i = iArr[0] - 60;
            layoutParams.leftMargin = i;
            layoutParams.topMargin = iArr[1] - this.d;
            if (i < 0) {
                layoutParams.leftMargin = 0;
            }
            if (layoutParams.leftMargin + this.c > BdUtilHelper.getEquipmentWidth(this.a)) {
                layoutParams.leftMargin = BdUtilHelper.getEquipmentWidth(this.a) - this.c;
            }
            if (this.o == null) {
                this.o = (FrameLayout) this.a.getWindow().getDecorView();
            }
            if (this.k.getParent() != null) {
                ViewParent parent = this.k.getParent();
                FrameLayout frameLayout = this.o;
                if (parent == frameLayout) {
                    frameLayout.removeView(this.k);
                }
            }
            this.o.addView(this.k, layoutParams);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = -1;
            this.h = -1;
            this.g = -1;
            this.f = -1;
            this.m = false;
            this.a.setSwipeBackEnabled(true);
            EmotionPreview emotionPreview = this.k;
            if (emotionPreview != null && this.q != null) {
                if (emotionPreview.getParent() != null) {
                    ViewParent parent = this.k.getParent();
                    FrameLayout frameLayout = this.o;
                    if (parent == frameLayout) {
                        frameLayout.removeView(this.k);
                    }
                }
                this.q = null;
                this.l.setDisableListViewTouchIntercept(false);
            }
        }
    }

    public final e v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.h;
            int i2 = this.i;
            if (i < 0) {
                i = this.f;
            }
            if (i2 < 0) {
                i2 = this.g;
            }
            int pointToPosition = this.l.pointToPosition(i, i2);
            if (pointToPosition >= 0) {
                this.e.set(i, i2, i + 1, i2 + 1);
                View childAt = this.l.getChildAt(pointToPosition);
                if (childAt != null && (childAt instanceof ViewGroup)) {
                    ViewGroup viewGroup = (ViewGroup) childAt;
                    this.l.offsetRectIntoDescendantCoords(childAt, this.e);
                    int childCount = viewGroup.getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        View childAt2 = viewGroup.getChildAt(i3);
                        if (childAt2.getLeft() < this.e.left && childAt2.getRight() > this.e.right && childAt2.getTop() < this.e.left && childAt2.getBottom() > this.e.bottom) {
                            int headerViewsCount = pointToPosition - this.l.getHeaderViewsCount();
                            e eVar = new e(childAt2, headerViewsCount, i3);
                            Log.d("PackageDetailPreview", "touch cell: (" + headerViewsCount + StringUtil.ARRAY_ELEMENT_SEPARATOR + i3 + SmallTailInfo.EMOTION_SUFFIX);
                            return eVar;
                        }
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (e) invokeV.objValue;
    }

    public final EmotionPackageData.SingleEmotionData w(int i, int i2) {
        InterceptResult invokeII;
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            tm adapter2 = this.l.getAdapter2();
            int i3 = (i * 4) + i2;
            int headerViewsCount = i + this.l.getHeaderViewsCount();
            if (adapter2 != null && headerViewsCount > -1 && headerViewsCount < adapter2.getCount() && (list = (List) adapter2.getItem(headerViewsCount)) != null && i3 > -1 && i3 < list.size()) {
                return (EmotionPackageData.SingleEmotionData) list.get(i3);
            }
            return null;
        }
        return (EmotionPackageData.SingleEmotionData) invokeII.objValue;
    }

    public final void z(e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, eVar) != null) || eVar == null) {
            return;
        }
        x();
        if (t(eVar.a, w(eVar.b, eVar.c))) {
            this.q = eVar;
            this.l.setDisableListViewTouchIntercept(true);
            this.a.setSwipeBackEnabled(false);
        }
    }
}
