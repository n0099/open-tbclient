package com.baidu.wallet.home.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.baidu.wallet.passport.LoginBackListenerProxy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class HomeMainView extends LinearLayout implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BaseItemLayout> a;

    /* renamed from: b  reason: collision with root package name */
    public String f51349b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51350c;

    /* renamed from: d  reason: collision with root package name */
    public d f51351d;

    /* renamed from: e  reason: collision with root package name */
    public String f51352e;
    public HomeCfgResponse.AllConfig mAllConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeMainView(Context context) {
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
        this.a = new ArrayList();
        this.f51350c = false;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            removeAllViews();
            this.a.clear();
        }
    }

    private boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            for (BaseItemLayout baseItemLayout : this.a) {
                if (baseItemLayout.hasItemShowPoint()) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void dispatchDot(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            for (BaseItemLayout baseItemLayout : this.a) {
                baseItemLayout.dispatchShowPoint(str);
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public String getAndroidPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.isEmpty(this.f51349b) ? "" : this.f51349b : (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public String getPageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f51352e : (String) invokeV.objValue;
    }

    public boolean isApp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public boolean isLoginData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f51350c : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void jump(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            d dVar = this.f51351d;
            if (dVar == null || !dVar.a(str, str2, str3)) {
                com.baidu.wallet.home.a.a().a(getContext(), str, str2, str3, z, this.f51352e);
            }
        }
    }

    public boolean jumpOuterServices() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void login() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            WalletLoginHelper.getInstance().login(new LoginBackListenerProxy(getContext(), new ILoginBackListener(this) { // from class: com.baidu.wallet.home.ui.widget.HomeMainView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ HomeMainView a;

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

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onFail(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str) == null) {
                    }
                }

                @Override // com.baidu.wallet.api.ILoginBackListener
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                    }
                }
            }));
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void onEyeMaskBtnClick() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            com.baidu.wallet.home.storage.a.a(getContext(), !com.baidu.wallet.home.storage.a.a(getContext()));
            for (BaseItemLayout baseItemLayout : this.a) {
                baseItemLayout.onEyeMaskChanged();
            }
        }
    }

    @Override // com.baidu.wallet.home.ui.widget.b
    public void onPointShowChanged() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (dVar = this.f51351d) == null) {
            return;
        }
        dVar.a(b());
    }

    public void setAdapter(Context context, HomeCfgResponse homeCfgResponse, String str) {
        HomeCfgResponse.TitleItem[] titleItemArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, context, homeCfgResponse, str) == null) {
            this.f51352e = str;
            a();
            this.mAllConfig = homeCfgResponse.layout_content;
            this.f51349b = homeCfgResponse.android_prefix;
            this.f51350c = homeCfgResponse.isLogin();
            HomeCfgResponse.AllConfig allConfig = this.mAllConfig;
            if (allConfig != null && allConfig.data != null) {
                boolean z = true;
                for (int i2 = 0; i2 < this.mAllConfig.data.length; i2++) {
                    BaseItemLayout a = a.a().a(context, this.mAllConfig.data[i2], this.f51349b);
                    if (a != null) {
                        a.setConfigData(this.mAllConfig.data[i2], this);
                        if (a.isDataValid()) {
                            if (this.mAllConfig.data[i2].isLayoutHasGap()) {
                                if (z) {
                                    a(2);
                                } else {
                                    a(3);
                                }
                            }
                            if (z) {
                                z = false;
                            }
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                            layoutParams.weight = 0.0f;
                            addView(a, layoutParams);
                            this.a.add(a);
                        }
                    }
                }
                if (this.a.size() > 0) {
                    a(1);
                }
            }
            HomeCfgResponse.TitleConfig titleConfig = homeCfgResponse.layout_title;
            if (titleConfig != null && (titleItemArr = titleConfig.data) != null && titleItemArr.length > 0) {
                HomeCfgResponse.TitleItem titleItem = titleItemArr[0];
                FeedBackLayout feedBackLayout = new FeedBackLayout(context);
                feedBackLayout.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_background1_color"));
                feedBackLayout.setData(titleItem, this);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.weight = 1.0f;
                addView(feedBackLayout, layoutParams2);
                this.a.add(feedBackLayout);
            }
            onPointShowChanged();
        }
    }

    public void setClickOuterInterface(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, dVar) == null) {
            this.f51351d = dVar;
        }
    }

    private void a(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            boolean z2 = false;
            boolean z3 = true;
            if (i2 != 0) {
                if (i2 == 1) {
                    z = false;
                    z2 = true;
                } else if (i2 == 2) {
                    z = true;
                } else if (i2 != 3) {
                    z = false;
                } else {
                    z = true;
                    z2 = true;
                }
                z3 = false;
            } else {
                z = false;
            }
            if (z2) {
                View view = new View(getContext());
                view.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 0.5f)));
                view.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_separateColor"));
                addView(view);
            }
            if (z3) {
                View view2 = new View(getContext());
                view2.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 10.0f)));
                view2.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_background1_color"));
                addView(view2);
            }
            if (z) {
                View view3 = new View(getContext());
                view3.setLayoutParams(new LinearLayout.LayoutParams(-1, DisplayUtils.dip2px(getContext(), 0.5f)));
                view3.setBackgroundColor(ResUtils.getColor(getContext(), "wallet_base_separateColor"));
                addView(view3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeMainView(Context context, AttributeSet attributeSet) {
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
        this.a = new ArrayList();
        this.f51350c = false;
    }
}
