package com.baidu.tieba.lego.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SlidingTabLayout extends MyHorizontalScrollView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f18267e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f18268f;

    /* renamed from: g  reason: collision with root package name */
    public ViewPager.OnPageChangeListener f18269g;

    /* renamed from: h  reason: collision with root package name */
    public int f18270h;

    /* renamed from: i  reason: collision with root package name */
    public final SlidingTabStrip f18271i;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f18272e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f18273f;

        public b(SlidingTabLayout slidingTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18273f = slidingTabLayout;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f18272e = i2;
                if (this.f18273f.f18269g != null) {
                    this.f18273f.f18269g.onPageScrollStateChanged(i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            int childCount;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (childCount = this.f18273f.f18271i.getChildCount()) == 0 || i2 < 0 || i2 >= childCount) {
                return;
            }
            View childAt = this.f18273f.f18271i.getChildAt(i2);
            this.f18273f.k(i2, childAt != null ? (int) (childAt.getWidth() * f2) : 0);
            if (this.f18273f.f18269g != null) {
                this.f18273f.f18269g.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                this.f18273f.f18271i.b(i2, this.f18273f.f18270h);
                this.f18273f.f18270h = i2;
                if (this.f18272e == 0) {
                    SlidingTabLayout slidingTabLayout = this.f18273f;
                    slidingTabLayout.k(i2, slidingTabLayout.f18270h);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016449, Integer.valueOf(this.f18273f.f18270h)));
                if (this.f18273f.f18269g != null) {
                    this.f18273f.f18269g.onPageSelected(i2);
                }
            }
        }

        public /* synthetic */ b(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SlidingTabLayout f18274e;

        public c(SlidingTabLayout slidingTabLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {slidingTabLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18274e = slidingTabLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                for (int i2 = 0; i2 < this.f18274e.f18271i.getChildCount(); i2++) {
                    if (view == this.f18274e.f18271i.getChildAt(i2)) {
                        this.f18274e.f18268f.setCurrentItem(i2, false);
                        return;
                    }
                }
            }
        }

        public /* synthetic */ c(SlidingTabLayout slidingTabLayout, a aVar) {
            this(slidingTabLayout);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public TextView i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            float dimension = getResources().getDimension(R.dimen.ds28);
            TextView textView = new TextView(context);
            textView.setGravity(17);
            textView.setSingleLine();
            textView.setTextSize(0, dimension);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
            return textView;
        }
        return (TextView) invokeL.objValue;
    }

    public final void j(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            PagerAdapter adapter = this.f18268f.getAdapter();
            c cVar = new c(this, null);
            for (int i3 = 0; i3 < adapter.getCount(); i3++) {
                TextView i4 = i(getContext());
                i4.setText(StringHelper.cutChineseAndEnglishWithSuffix(((Object) adapter.getPageTitle(i3)) + "", 8, null));
                i4.setOnClickListener(cVar);
                if (adapter.getCount() < 8) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
                    layoutParams.weight = 1.0f;
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds22);
                    i4.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                    this.f18271i.addView(i4, layoutParams);
                } else {
                    int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ds22);
                    int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.dimen.ds16);
                    i4.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize2);
                    this.f18271i.addView(i4);
                }
                if (i3 == i2) {
                    i4.setTextSize(0, getResources().getDimension(R.dimen.ds32));
                    SkinManager.setViewTextColor(i4, R.color.CAM_X0308, 1);
                }
            }
        }
    }

    public final void k(int i2, int i3) {
        int childCount;
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || (childCount = this.f18271i.getChildCount()) == 0 || i2 < 0 || i2 >= childCount || (childAt = this.f18271i.getChildAt(i2)) == null) {
            return;
        }
        int left = childAt.getLeft() + i3;
        if (i2 > 0 || i3 > 0) {
            left -= this.f18267e;
        }
        scrollTo(left, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            ViewPager viewPager = this.f18268f;
            if (viewPager != null) {
                k(viewPager.getCurrentItem(), 0);
            }
        }
    }

    public void onChangeSkinType(int i2) {
        SlidingTabStrip slidingTabStrip;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i2) == null) || (slidingTabStrip = this.f18271i) == null) {
            return;
        }
        slidingTabStrip.a(i2);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onPageChangeListener) == null) {
            this.f18269g = onPageChangeListener;
        }
    }

    public void setViewPager(ViewPager viewPager, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, viewPager, i2) == null) {
            this.f18271i.removeAllViews();
            this.f18268f = viewPager;
            if (viewPager != null) {
                viewPager.setOnPageChangeListener(new b(this, null));
                j(i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
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
        this.f18270h = 0;
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f18267e = (int) (getResources().getDisplayMetrics().density * 24.0f);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.f18271i = slidingTabStrip;
        addView(slidingTabStrip, -1, -2);
    }
}
