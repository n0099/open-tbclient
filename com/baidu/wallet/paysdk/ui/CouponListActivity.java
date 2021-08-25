package com.baidu.wallet.paysdk.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.contract.CouponListContract;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.presenter.CouponListPresenter;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.ViewHelper;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class CouponListActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ViewGroup f62781a;

    /* renamed from: b  reason: collision with root package name */
    public View f62782b;
    public CouponListContract.Presenter mPresenter;

    public CouponListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity
    public void addContentView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ViewGroup viewGroup = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_cashdesk_coupon_list"), null);
            this.mContentView = viewGroup;
            this.mHalfScreenContainer.addView(viewGroup);
        }
    }

    public void dismissLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            WalletGlobalUtils.safeDismissDialog(this, i2);
        }
    }

    public void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WalletGlobalUtils.safeShowDialog(this, 0, "");
            this.mPresenter.calcPayamount(null);
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mActionBar.setVisibility(0);
            this.mLeftImg.setOnClickListener(this);
            this.mRightTxt.setVisibility(8);
            TextView textView = (TextView) findViewById(ResUtils.id(this.mAct, "couponlist_title"));
            this.mTitle = textView;
            textView.setBackgroundColor(ResUtils.getColor(this.mAct, "dxm_ebpay_white"));
            this.mTitle.setText(ResUtils.getString(getActivity(), "ebpay_select_coupon"));
            this.f62781a = (ViewGroup) findViewById(ResUtils.id(this.mAct, "bd_wallet_coupon_container"));
        }
    }

    @Override // com.dxmpay.wallet.core.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && this.mHalfScreenContainer.isClickable()) {
            EventBus eventBus = EventBus.getInstance();
            EventBus eventBus2 = EventBus.getInstance();
            eventBus.getClass();
            eventBus2.postStickyEvent(new EventBus.Event(eventBus, "order_confirm_event_bus_key", null));
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view) == null) && view == this.mLeftImg) {
            onBackPressed();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            super.onCreate(bundle);
            CouponListPresenter couponListPresenter = new CouponListPresenter(this);
            this.mPresenter = couponListPresenter;
            couponListPresenter.onCreate(bundle);
            initView();
            initData();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            CouponListContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onDestroy();
                this.mPresenter = null;
            }
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity, com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            CouponListContract.Presenter presenter = this.mPresenter;
            if (presenter != null) {
                presenter.onSaveInstanceState(bundle);
            }
            super.onSaveInstanceState(bundle);
        }
    }

    public void returnToPreviousPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            finishWithoutAnim();
        }
    }

    public void revertItemView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View view = this.f62782b;
            if (view != null) {
                a((ProgressBar) view.findViewById(ResUtils.id(this, "ebpay_mini_progress_bar")), (ImageView) this.f62782b.findViewById(ResUtils.id(this, "coupon_select")), false);
            }
            this.f62782b = null;
        }
    }

    public void setPageClickable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mHalfScreenContainer.setClickable(z);
        }
    }

    public void showLoading(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i2) == null) {
            WalletGlobalUtils.safeShowDialog(this, i2, "");
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseActivity
    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{Boolean.valueOf(z), payResultContent, Integer.valueOf(i2)}) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void reFreshUI(ArrayList<CouponListPresenter.a> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, arrayList) == null) || arrayList == null) {
            return;
        }
        this.f62782b = null;
        setPageClickable(true);
        this.f62781a.removeAllViews();
        int dimension = (int) ResUtils.getDimension(this.mAct, "bd_wallet_coupon_height");
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            View a2 = a(arrayList.get(i2));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dimension);
            if (i2 == arrayList.size() - 1) {
                layoutParams.bottomMargin = DisplayUtils.dip2px(this, 5.0f);
            }
            a2.setLayoutParams(layoutParams);
            this.f62781a.addView(a2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void setPresenter(CouponListContract.Presenter presenter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, presenter) == null) {
            this.mPresenter = presenter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ProgressBar progressBar, ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(InputDeviceCompat.SOURCE_TRACKBALL, this, progressBar, imageView, z) == null) {
            if (z) {
                progressBar.setVisibility(0);
                imageView.setVisibility(8);
                return;
            }
            progressBar.setVisibility(8);
            imageView.setVisibility(0);
        }
    }

    private View a(CouponListPresenter.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, aVar)) == null) {
            View inflate = LayoutInflater.from(this).inflate(ResUtils.layout(this, "wallet_cashdesk_coupon_item_view"), (ViewGroup) null);
            ProgressBar progressBar = (ProgressBar) inflate.findViewById(ResUtils.id(this, "ebpay_mini_progress_bar"));
            ImageView imageView = (ImageView) inflate.findViewById(ResUtils.id(this, "coupon_select"));
            inflate.setOnClickListener(new View.OnClickListener(this, inflate, progressBar, imageView) { // from class: com.baidu.wallet.paysdk.ui.CouponListActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ View f62783a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ProgressBar f62784b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ ImageView f62785c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ CouponListActivity f62786d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, inflate, progressBar, imageView};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f62786d = this;
                    this.f62783a = inflate;
                    this.f62784b = progressBar;
                    this.f62785c = imageView;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f62786d.f62782b = this.f62783a;
                        CouponListPresenter.a aVar2 = (CouponListPresenter.a) view.getTag();
                        if (aVar2.f62466g) {
                            StatisticManager.onEvent("switchCoupon");
                            this.f62786d.a(this.f62784b, this.f62785c, true);
                            this.f62786d.mPresenter.calcPayamount(aVar2);
                            return;
                        }
                        GlobalUtils.toast(this.f62786d, aVar2.f62465f);
                    }
                }
            });
            a(progressBar, imageView, false);
            ((NetImageView) inflate.findViewById(ResUtils.id(this, "ebpay_coupon_logo"))).setImageUrl(aVar.f62460a);
            ((TextView) inflate.findViewById(ResUtils.id(this, "coupon_dicount_name"))).setText(aVar.f62463d);
            ((TextView) inflate.findViewById(ResUtils.id(this, "coupon_dicount_tip"))).setText(aVar.f62464e);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(this, "coupon_disable_reason"));
            if (!TextUtils.isEmpty(aVar.f62465f)) {
                textView.setVisibility(0);
                textView.setText(aVar.f62465f);
            } else {
                textView.setVisibility(8);
            }
            if (aVar.f62466g) {
                imageView.setSelected(aVar.f62467h);
                inflate.setTag(aVar);
                a(inflate, true);
            } else {
                imageView.setSelected(false);
                inflate.setTag(aVar);
                a(inflate, false);
            }
            return inflate;
        }
        return (View) invokeL.objValue;
    }

    private void a(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65539, this, view, z) == null) {
            if (z) {
                ViewHelper.setAlpha(view, 1.0f);
            } else {
                ViewHelper.setAlpha(view, 0.4f);
            }
        }
    }
}
