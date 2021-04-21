package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.GridLayout;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FinancingManageLayout extends BaseItemLayout implements ViewPager.OnPageChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f24260a;

    /* renamed from: b  reason: collision with root package name */
    public List<BaseItemView> f24261b;

    /* renamed from: c  reason: collision with root package name */
    public List<GridLayout> f24262c;

    /* renamed from: e  reason: collision with root package name */
    public HomeLayoutOneTipView f24263e;

    /* renamed from: f  reason: collision with root package name */
    public ViewPager f24264f;

    /* renamed from: g  reason: collision with root package name */
    public PagerAdapter f24265g;

    /* loaded from: classes5.dex */
    public class MyPagerAdapter extends PagerAdapter implements NoProguard {
        public MyPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(View view, int i, Object obj) {
            ((ViewPager) view).removeView((View) FinancingManageLayout.this.f24262c.get(i % FinancingManageLayout.this.f24262c.size()));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return FinancingManageLayout.this.f24262c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(View view, int i) {
            ((ViewPager) view).addView((View) FinancingManageLayout.this.f24262c.get(i % FinancingManageLayout.this.f24262c.size()), 0);
            return FinancingManageLayout.this.f24262c.get(i % FinancingManageLayout.this.f24262c.size());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public FinancingManageLayout(Context context) {
        super(context);
        this.f24261b = new ArrayList();
        this.f24262c = new ArrayList();
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public List<BaseItemView> getChildren() {
        return this.f24261b;
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void initView() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_home_finance_manager_layout"), this);
        this.f24264f = (ViewPager) findViewById(ResUtils.id(getContext(), "view_pager"));
        this.f24263e = (HomeLayoutOneTipView) findViewById(ResUtils.id(getContext(), "tip_view"));
        this.f24260a = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_home_banner_indicators"));
        this.f24265g = new MyPagerAdapter();
        this.f24264f.setPageMargin(DisplayUtils.dip2px(getContext(), 9.0f));
        this.f24264f.setAdapter(this.f24265g);
        this.f24264f.setOnPageChangeListener(this);
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public boolean isDataValid() {
        HomeCfgResponse.DataItem[] dataItemArr;
        HomeCfgResponse.ConfigData configData = this.mConfigData;
        return (configData == null || (dataItemArr = configData.list) == null || dataItemArr.length == 0) ? false : true;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        int i2 = 0;
        while (i2 < this.f24262c.size()) {
            if (this.f24260a.getChildAt(i2) != null) {
                this.f24260a.getChildAt(i2).setSelected(i2 == i);
            }
            i2++;
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.BaseItemLayout
    public void refreshData() {
        this.f24263e.setData(this.mConfigData, getWalletInterface());
        HomeCfgResponse.DataItem[] dataItemArr = this.mConfigData.list;
        int length = (dataItemArr.length / 3) + (dataItemArr.length % 3 == 0 ? 0 : 1);
        GridLayout gridLayout = null;
        boolean z = false;
        for (int i = 0; i < dataItemArr.length; i++) {
            FinanceItemView financeItemView = new FinanceItemView(getContext());
            financeItemView.setData(dataItemArr[i], getWalletInterface());
            if (!z) {
                z = financeItemView.showValue1();
            }
            this.f24261b.add(financeItemView);
            if (i % 3 == 0) {
                gridLayout = new GridLayout(getContext());
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(DisplayUtils.dip2px(getContext(), 10.0f), 0, DisplayUtils.dip2px(getContext(), 10.0f), 0);
                gridLayout.setLayoutParams(layoutParams);
                gridLayout.requestLayout();
                gridLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_whiteColor"));
                gridLayout.setHorizontalSpacing(DisplayUtils.dip2px(getContext(), 9.0f));
                gridLayout.setColumnCount(length == 1 ? dataItemArr.length : 3);
                this.f24262c.add(gridLayout);
            }
            if (gridLayout != null) {
                gridLayout.addView(financeItemView);
            }
        }
        if (z) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24264f.getLayoutParams();
            layoutParams2.height += DisplayUtils.dip2px(getContext(), 21.0f);
            this.f24264f.setLayoutParams(layoutParams2);
            this.f24264f.requestLayout();
        }
        int drawable = ResUtils.drawable(getContext(), "wallet_base_indicator_selector");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(DisplayUtils.dip2px(getContext(), 7.0f), DisplayUtils.dip2px(getContext(), 2.0f));
        if (this.f24262c.size() > 1) {
            int i2 = 0;
            while (i2 < this.f24262c.size()) {
                View view = new View(getContext());
                view.setBackgroundResource(drawable);
                view.setSelected(i2 == 0);
                this.f24260a.addView(view, layoutParams3);
                layoutParams3.leftMargin = DisplayUtils.dip2px(getContext(), 6.0f);
                i2++;
            }
            this.f24260a.setVisibility(0);
        } else {
            this.f24260a.setVisibility(8);
        }
        this.f24265g.notifyDataSetChanged();
    }

    public FinancingManageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24261b = new ArrayList();
        this.f24262c = new ArrayList();
    }
}
