package com.baidu.wallet.personal.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.base.widget.BdActionBar;
import com.baidu.wallet.core.utils.CommonUtils;
import com.baidu.wallet.core.utils.PassUtil;
import com.baidu.wallet.personal.b.b;
import com.baidu.wallet.personal.datamodel.CouponListResponse;
import com.baidu.wallet.personal.ui.view.CouponTabHostView;
/* loaded from: classes12.dex */
public class MyCouponListActivity extends CouponBaseActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EXTRA_DATA = "extra_data";
    public static final String TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView actionBarLine;
    public BdActionBar bdActionBar;
    public CouponTabHostView mCouponTabHostView;
    public FragmentManager mFragmentManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1186090056, "Lcom/baidu/wallet/personal/ui/MyCouponListActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1186090056, "Lcom/baidu/wallet/personal/ui/MyCouponListActivity;");
                return;
            }
        }
        TAG = MyCouponListActivity.class.getSimpleName();
    }

    public MyCouponListActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private void init(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bundle) == null) {
            this.mCouponTabHostView = (CouponTabHostView) findViewById(ResUtils.id(this, "coupon_list_tab_host"));
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            this.mFragmentManager = supportFragmentManager;
            this.mCouponTabHostView.a(supportFragmentManager);
        }
    }

    @Override // com.baidu.wallet.personal.ui.CouponBaseActivity, com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, str) == null) {
        }
    }

    public void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ImageView imageView = (ImageView) findViewById(ResUtils.id(this.mAct, "title_bottom_seperator"));
            this.actionBarLine = imageView;
            imageView.setVisibility(8);
            initHomeActionBar("bd_wallet_tab_coupon");
            this.bdActionBar = getBdActionBar();
            PassUtil.onCreate();
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, com.baidu.wallet.core.SDKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(ResUtils.layout(this.mAct, "wallet_personal_coupon_list"));
            initView();
            init(bundle);
            EventBus.getInstance().register(this, "showTitleBarRightZone", 0, EventBus.ThreadMode.MainThread);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDestroy();
            b.a = null;
            EventBus.getInstance().unregister(this);
        }
    }

    public void onModuleEvent(EventBus.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, event) == null) && event != null && "showTitleBarRightZone".equals(event.mEventKey)) {
            updateBdActionBarRight((CouponListResponse.CodeCoupon) event.mEventObj);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onResume();
            Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(this.mCouponTabHostView.getCurrentTabTag());
            if (findFragmentByTag != null) {
                findFragmentByTag.onHiddenChanged(false);
            }
        }
    }

    public void updateBdActionBarRight(CouponListResponse.CodeCoupon codeCoupon) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, codeCoupon) == null) {
            if (this.bdActionBar != null) {
                if (codeCoupon == null || TextUtils.isEmpty(codeCoupon.desc) || TextUtils.isEmpty(codeCoupon.url)) {
                    this.bdActionBar.setRightNotifyZone1Visibility(8);
                } else {
                    this.bdActionBar.setRightNotifyText(codeCoupon.desc);
                    this.bdActionBar.setRightNotifyZone1Visibility(0);
                    this.bdActionBar.setRightNotifyTextColor(-16777216);
                    this.bdActionBar.setRightNotifyTextSize(12);
                    this.bdActionBar.setRightNotifyImg(ResUtils.getDrawable(getActivity(), "wallet_personal_code_coupon_triangle"));
                    CommonUtils.setPressedAlpha(this.bdActionBar.getRightNotifyZone1());
                    this.bdActionBar.setRightNotifyZone1ClickListener(new View.OnClickListener(this, codeCoupon) { // from class: com.baidu.wallet.personal.ui.MyCouponListActivity.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ CouponListResponse.CodeCoupon a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ MyCouponListActivity f54080b;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, codeCoupon};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f54080b = this;
                            this.a = codeCoupon;
                        }

                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                                BaiduWalletDelegate.getInstance().openH5Module(this.f54080b.getActivity(), this.a.url);
                            }
                        }
                    });
                }
            }
            BdActionBar bdActionBar = this.bdActionBar;
            if (bdActionBar != null) {
                bdActionBar.setRightImgZone2Visibility(0);
            }
        }
    }
}
