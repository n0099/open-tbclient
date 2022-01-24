package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class FinancingManageLayout extends BaseItemLayout implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public List<BaseItemView> f51170b;

    /* renamed from: c  reason: collision with root package name */
    public List<GridLayout> f51171c;

    /* renamed from: e  reason: collision with root package name */
    public HomeLayoutOneTipView f51172e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f51173f;

    /* renamed from: g  reason: collision with root package name */
    public PagerAdapter f51174g;

    /* loaded from: classes13.dex */
    public class MyPagerAdapter extends PagerAdapter implements NoProguard {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FinancingManageLayout a;

        public MyPagerAdapter(FinancingManageLayout financingManageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {financingManageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = financingManageLayout;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, obj) == null) {
                ((ViewPager) view).removeView((View) this.a.f51171c.get(i2 % this.a.f51171c.size()));
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.f51171c.size() : invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view, i2)) == null) {
                ((ViewPager) view).addView((View) this.a.f51171c.get(i2 % this.a.f51171c.size()), 0);
                return this.a.f51171c.get(i2 % this.a.f51171c.size());
            }
            return invokeLI.objValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view, obj)) == null) ? view == obj : invokeLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinancingManageLayout(Context context) {
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
        this.f51170b = new ArrayList();
        this.f51171c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51170b : (List) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_finance_manager_layout"), this);
            this.f51173f = (ViewPager) findViewById(ResUtils.id(getContext(), "view_pager"));
            this.f51172e = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
            this.a = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
            this.f51174g = new MyPagerAdapter(this);
            this.f51173f.setPageMargin(DisplayUtils.dip2px(getContext(), 9.0f));
            this.f51173f.setAdapter(this.f51174g);
            this.f51173f.setOnPageChangeListener(this);
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        InterceptResult invokeV;
        HomeCfgResponse.DataItem[] dataItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HomeCfgResponse.ConfigData configData = this.mConfigData;
            return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            int i3 = 0;
            while (i3 < this.f51171c.size()) {
                if (this.a.getChildAt(i3) != null) {
                    this.a.getChildAt(i3).setSelected(i3 == i2);
                }
                i3++;
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f51172e.setData(this.mConfigData, getWalletInterface());
            HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
            int length = (dataItemArr.length / 3) + (dataItemArr.length % 3 == 0 ? 0 : 1);
            GridLayout gridLayout = null;
            boolean z = false;
            for (int i2 = 0; i2 < dataItemArr.length; i2++) {
                FinanceItemView financeItemView = new FinanceItemView(getContext());
                financeItemView.setData(dataItemArr[i2], getWalletInterface());
                if (!z) {
                    z = financeItemView.showValue1();
                }
                this.f51170b.add(financeItemView);
                if (i2 % 3 == 0) {
                    gridLayout = new GridLayout(getContext());
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(DisplayUtils.dip2px(getContext(), 10.0f), 0, DisplayUtils.dip2px(getContext(), 10.0f), 0);
                    gridLayout.setLayoutParams(layoutParams);
                    gridLayout.requestLayout();
                    gridLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_whiteColor"));
                    gridLayout.setHorizontalSpacing(DisplayUtils.dip2px(getContext(), 9.0f));
                    gridLayout.setColumnCount(length == 1 ? dataItemArr.length : 3);
                    this.f51171c.add(gridLayout);
                }
                if (gridLayout != null) {
                    gridLayout.addView(financeItemView);
                }
            }
            if (z) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f51173f.getLayoutParams();
                layoutParams2.height += DisplayUtils.dip2px(getContext(), 21.0f);
                this.f51173f.setLayoutParams(layoutParams2);
                this.f51173f.requestLayout();
            }
            int drawable = ResUtils.drawable(getContext(), "wallet_base_indicator_selector");
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
            if (this.f51171c.size() > 1) {
                int i3 = 0;
                while (i3 < this.f51171c.size()) {
                    View view = new View(getContext());
                    view.setBackgroundResource(drawable);
                    view.setSelected(i3 == 0);
                    this.a.addView(view, layoutParams3);
                    layoutParams3.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                    i3++;
                }
                this.a.setVisibility(0);
            } else {
                this.a.setVisibility(8);
            }
            this.f51174g.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FinancingManageLayout(Context context, AttributeSet attributeSet) {
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
        this.f51170b = new ArrayList();
        this.f51171c = new ArrayList();
    }
}
