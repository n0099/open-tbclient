package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes7.dex */
public class pta extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public a b;
    public int c;
    public LinearLayout d;
    public Context e;
    public int f;

    /* loaded from: classes7.dex */
    public interface a {
        void P0(int i);
    }

    /* loaded from: classes7.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public a b;

        public b(int i, a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (aVar = this.b) != null) {
                aVar.P0(this.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pta(Context context) {
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
        this.a = -1;
        this.e = context;
        b(context);
    }

    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            view2.setOnClickListener(new b(this.c, this.b));
            this.d.addView(view2);
            this.c++;
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int i2 = this.a;
            if (i2 != -1) {
                this.d.getChildAt(i2).setSelected(false);
            }
            this.a = i;
            this.d.getChildAt(i).setSelected(true);
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.f = i;
        }
    }

    public void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.b = aVar;
        }
    }

    public final void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            ScrollView scrollView = new ScrollView(context);
            scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            LinearLayout linearLayout = new LinearLayout(context);
            this.d = linearLayout;
            linearLayout.setOrientation(1);
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            scrollView.addView(this.d);
            scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            scrollView.setPadding(0, 0, yi.d(context, 1.0f), yi.d(context, 1.0f));
            scrollView.setFadingEdgeLength(0);
            scrollView.setScrollbarFadingEnabled(false);
            try {
                Method declaredMethod = scrollView.getClass().getDeclaredMethod("setOverScrollMode", Integer.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(scrollView, 2);
            } catch (Exception unused) {
            }
            setContentView(scrollView);
            GreyUtil.grey(this);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, view2, i, i2) == null) {
            getContentView().measure(View.MeasureSpec.makeMeasureSpec(this.e.getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.e.getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
            int measuredWidth = getContentView().getMeasuredWidth();
            if (measuredWidth < view2.getWidth()) {
                measuredWidth = view2.getWidth();
            }
            int measuredHeight = getContentView().getMeasuredHeight();
            int i3 = this.f;
            if (measuredHeight > i3) {
                measuredHeight = i3;
            }
            setWidth(measuredWidth);
            setHeight(measuredHeight);
            super.showAsDropDown(view2, i, i2);
        }
    }
}
