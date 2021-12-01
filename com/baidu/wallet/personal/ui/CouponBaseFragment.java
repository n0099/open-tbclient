package com.baidu.wallet.personal.ui;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.DialogFragment;
import com.baidu.wallet.base.widget.WalletBaseEmptyView;
import com.baidu.wallet.base.widget.pulltorefresh.FooterLoadingLayout;
import com.baidu.wallet.base.widget.pulltorefresh.PullToRefreshListView;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.BaseFragment;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.WalletGlobalUtils;
import com.baidu.wallet.personal.beans.QueryCouponListBean;
import com.baidu.wallet.personal.beans.a;
/* loaded from: classes12.dex */
public abstract class CouponBaseFragment extends DialogFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View footer;
    public ImageView footerImage;
    public boolean isInvaild;
    public PullToRefreshListView mContainer;
    public View mEmptyView;
    public ListView mListView;
    public WalletBaseEmptyView mReloadView;
    public ViewGroup mRootView;
    public ImageView noCouponImage;
    public TextView noCouponLint;
    public TextView noCouponText;

    public CouponBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRootView = null;
        this.isInvaild = false;
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mEmptyView = this.mRootView.findViewById(ResUtils.id(getContext(), "bd_wallet_empty_coupon"));
            this.mReloadView = (WalletBaseEmptyView) this.mRootView.findViewById(ResUtils.id(getContext(), "wallet_coupon_reload_view"));
            this.noCouponImage = (ImageView) this.mEmptyView.findViewById(ResUtils.id(getContext(), "wallet_no_coupon"));
            this.noCouponText = (TextView) this.mEmptyView.findViewById(ResUtils.id(getContext(), "bd_wallet_coupon_nocoupon"));
            this.noCouponLint = (TextView) this.mEmptyView.findViewById(ResUtils.id(getContext(), "bd_wallet_coupon_gowalk"));
            PullToRefreshListView pullToRefreshListView = (PullToRefreshListView) this.mRootView.findViewById(ResUtils.id(((BaseFragment) this).mAct, "pull_refresh_listview"));
            this.mContainer = pullToRefreshListView;
            pullToRefreshListView.setPullLoadEnabled(false);
            this.mContainer.setPullRefreshEnabled(true);
            this.mContainer.setScrollLoadEnabled(true);
            this.mContainer.setBackgroundColor(ResUtils.getColor(((BaseFragment) this).mAct, "coupon_base_white_f7f8fa"));
            this.mContainer.getHeaderLoadingLayout().setRefreshingLabel(ResUtils.getString(((BaseFragment) this).mAct, "wallet_personal_coupon_list_pull_refreshing"));
            this.mContainer.findViewById(ResUtils.id(((BaseFragment) this).mAct, "top_divider")).setVisibility(8);
            ListView refreshableView = this.mContainer.getRefreshableView();
            this.mListView = refreshableView;
            refreshableView.setBackgroundColor(ResUtils.getColor(((BaseFragment) this).mAct, "coupon_base_white_f7f8fa"));
            this.mListView.setAlwaysDrawnWithCacheEnabled(true);
            this.mListView.setCacheColorHint(ResUtils.getColor(((BaseFragment) this).mAct, "coupon_base_white_f7f8fa"));
            this.mListView.setDividerHeight(0);
            this.mListView.setDivider(new ColorDrawable(ResUtils.getColor(((BaseFragment) this).mAct, "wallet_base_transparent")));
            ((FooterLoadingLayout) this.mContainer.getFooterLoadingLayout()).showTopDivider(false);
            this.mListView.setFadingEdgeLength(0);
            if (Build.VERSION.SDK_INT >= 3) {
                this.mListView.setFooterDividersEnabled(false);
                this.mListView.setHeaderDividersEnabled(false);
            }
            this.mListView.setSelector(new ColorDrawable(ResUtils.getColor(((BaseFragment) this).mAct, "coupon_base_white_f7f8fa")));
            BaseActivity baseActivity = ((BaseFragment) this).mAct;
            View inflate = View.inflate(baseActivity, ResUtils.layout(baseActivity, "wallet_personal_coupon_list_footer"), null);
            this.footer = inflate;
            this.footerImage = (ImageView) inflate.findViewById(ResUtils.id(((BaseFragment) this).mAct, "footer_image"));
            this.mListView.addFooterView(this.footer);
        }
    }

    public abstract View addCusterview();

    public void configDxmLogo() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.footer.post(new Runnable(this) { // from class: com.baidu.wallet.personal.ui.CouponBaseFragment.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CouponBaseFragment a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    StringBuilder sb;
                    String str;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || ((BaseFragment) this.a).mAct == null) {
                        return;
                    }
                    int bottom = this.a.mListView.getBottom();
                    LogUtil.d("coupon", "footer listSize = " + this.a.mListView.getChildCount() + " ; listAdapter.count = " + this.a.mListView.getAdapter().getCount() + " ; listAdapter.footerViewCount = " + this.a.mListView.getFooterViewsCount());
                    int dip2px = DisplayUtils.dip2px(((BaseFragment) this.a).mAct, 120.0f) + DisplayUtils.dip2px(((BaseFragment) this.a).mAct, 25.0f) + this.a.footerImage.getHeight();
                    ListView listView = this.a.mListView;
                    View childAt = listView.getChildAt(listView.getChildCount() - 1);
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.a.footer.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(-1, -2);
                    }
                    if (childAt == null || !childAt.equals(this.a.footer)) {
                        layoutParams.height = dip2px;
                    } else {
                        LogUtil.d("coupon", "footer getChild.height = " + childAt.getHeight() + " ; currentBottomView.top = " + childAt.getTop() + " ; currentBottomView.bottom = " + childAt.getBottom());
                        int height = this.a.mListView.getHeight();
                        int top = this.a.footer.getTop();
                        int height2 = this.a.footer.getHeight();
                        int i2 = (height - height2) - top;
                        LogUtil.d("coupon", "footer.height = " + this.a.footer.getHeight() + " ; footer whole height = " + height2 + " ; footer.Top = " + this.a.footer.getTop() + " ; listViewBottom = " + bottom + " ; listViewHeight = " + height + " ; footer.paddingTOp = " + this.a.footer.getPaddingTop() + " ; footer.paddingBottom = " + this.a.footer.getPaddingBottom() + " ; margin = " + i2);
                        if (height - this.a.footer.getTop() > dip2px) {
                            layoutParams.height = height - this.a.footer.getTop();
                            sb = new StringBuilder();
                            str = "footer change Height = ";
                        } else {
                            layoutParams.height = dip2px;
                            sb = new StringBuilder();
                            str = "footer rechange Height = ";
                        }
                        sb.append(str);
                        sb.append(layoutParams.height);
                        LogUtil.d("coupon", sb.toString());
                    }
                    this.a.footer.setLayoutParams(layoutParams);
                    this.a.footer.setVisibility(0);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("footer GetFooter.visible = ");
                    sb2.append(this.a.footer.getVisibility() == 0);
                    sb2.append(" ; footer.visible = ");
                    sb2.append(this.a.footer.getVisibility() == 0);
                    sb2.append(" ； footer == ");
                    sb2.append(this.a.footer.equals(this.a.footer));
                    LogUtil.d("coupon", sb2.toString());
                    LogUtil.d("coupon", "footer height = " + this.a.footer.getHeight() + " ; listViewHeight = " + this.a.mListView.getHeight() + " ; paddingTOp = " + this.a.footer.getPaddingTop() + " ; paddingBottom = " + this.a.footer.getPaddingBottom() + " ; footer.top = " + this.a.footer.getTop() + " ; footer.bottom = " + this.a.footer.getBottom() + " ; listView.bottom = " + this.a.mListView.getBottom());
                }
            });
        }
    }

    public void configHasMore(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) {
            this.mContainer.setHasMoreData(z);
            PullToRefreshListView pullToRefreshListView = this.mContainer;
            if (z) {
                pullToRefreshListView.setScrollLoadEnabled(true);
            } else {
                pullToRefreshListView.setScrollLoadEnabled(false);
            }
            TextView textView = (TextView) this.mContainer.findViewById(ResUtils.id(((BaseFragment) this).mAct, "bd_wallet_loadmore_text"));
            textView.setTextSize(0, DisplayUtils.dip2px(((BaseFragment) this).mAct, 13.0f));
            textView.setTextColor(ResUtils.getColor(((BaseFragment) this).mAct, "coupon_base_blue_cc5d667a"));
            if (TextUtils.isEmpty(str) || z) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
            textView.setVisibility(0);
            this.mContainer.showOrHideFootView(0);
            LogUtil.d("pull", "Base Fragment config desc = " + str);
        }
    }

    public void handleEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.noCouponImage.setImageDrawable(ResUtils.getDrawable(getContext(), "wallet_personal_coupon_empty"));
            this.noCouponText.setText(ResUtils.getString(getContext(), "wallet_couponlist_empty_tip"));
            this.noCouponLint.setText(ResUtils.getString(getContext(), "ebpay_bd_wallet_base_coupon_info"));
        }
    }

    public void hideEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mEmptyView.setVisibility(8);
            this.mReloadView.setVisibility(8);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, layoutInflater, viewGroup, bundle)) == null) {
            super.onCreateView(layoutInflater, viewGroup, bundle);
            if (this.mRootView == null) {
                this.mRootView = (ViewGroup) layoutInflater.inflate(ResUtils.layout(getContext(), "wallet_personal_coupon_fragment_base"), (ViewGroup) null);
                initView();
                if (addCusterview() != null) {
                    this.mRootView.addView(addCusterview());
                }
            }
            return this.mRootView;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.wallet.base.widget.DialogFragment, com.baidu.wallet.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LogUtil.d("coupon", "couponBaseFragment onResume");
            super.onResume();
            showEmptyView(-1);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public void queryCoupon(BaseActivity baseActivity, String str, boolean z, int i2, QueryCouponListBean.CouponStatus couponStatus, CouponBaseFragment couponBaseFragment) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{baseActivity, str, Boolean.valueOf(z), Integer.valueOf(i2), couponStatus, couponBaseFragment}) == null) || getActivity() == null) {
            return;
        }
        if (z) {
            WalletGlobalUtils.safeShowDialog(baseActivity, -1, "");
        }
        a a = a.a();
        QueryCouponListBean queryCouponListBean = (QueryCouponListBean) a.getBean(baseActivity, 515, str + hashCode());
        queryCouponListBean.a(String.valueOf(i2));
        queryCouponListBean.a(couponStatus);
        queryCouponListBean.setResponseCallback(couponBaseFragment);
        queryCouponListBean.execBean();
    }

    public abstract void reQueryCoupon();

    public void showEmptyView(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || this.mEmptyView == null || getActivity() == null) {
            return;
        }
        View view = this.footer;
        if (view != null && view.getVisibility() == 0) {
            this.footer.setVisibility(8);
        }
        if (i2 == -1) {
            this.mEmptyView.setVisibility(0);
            this.mReloadView.setVisibility(8);
            handleEmptyView();
            return;
        }
        this.mReloadView.showTip1_Tip2_NextBtn(ResUtils.drawable(getActivity(), "wallet_base_no_net"), ResUtils.getString(getActivity(), "wallet_base_no_network"), ResUtils.getString(getActivity(), "wallet_base_no_network_reason"), ResUtils.getString(getActivity(), "bd_wallet_reload"), new WalletBaseEmptyView.EmptyBtnClickListener(this) { // from class: com.baidu.wallet.personal.ui.CouponBaseFragment.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ CouponBaseFragment a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // com.baidu.wallet.base.widget.WalletBaseEmptyView.EmptyBtnClickListener
            public void onBtnClick() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.a.reQueryCoupon();
                }
            }
        });
        this.mReloadView.setVisibility(0);
        this.mEmptyView.setVisibility(8);
    }
}
