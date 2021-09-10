package com.baidu.wallet.lightapp.ability.proxy;

import android.app.Activity;
import android.content.Intent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.BaseActivity;
import com.baidu.wallet.core.SDKBaseActivity;
import com.baidu.wallet.lightapp.business.presenter.ContactInfoPresenter;
import com.baidu.wallet.lightapp.business.presenter.b;
/* loaded from: classes8.dex */
public class SelectAddressProxy extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static b f61654a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public ContactInfoPresenter f61655b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61656c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1381023261, "Lcom/baidu/wallet/lightapp/ability/proxy/SelectAddressProxy;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1381023261, "Lcom/baidu/wallet/lightapp/ability/proxy/SelectAddressProxy;");
        }
    }

    public SelectAddressProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61656c = true;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f61655b = new ContactInfoPresenter(getActivity(), f61654a);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/phone_v2");
            getActivity().startActivityForResult(intent, 4);
        }
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            this.f61655b = null;
            f61654a = null;
            finish();
        }
    }

    public static void startSelectAddress(Activity activity, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity, bVar) == null) {
            f61654a = bVar;
            activity.startActivity(new Intent(activity, SelectAddressProxy.class));
        }
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public SDKBaseActivity.BottomBarType getBottomBarType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? SDKBaseActivity.BottomBarType.NONE : (SDKBaseActivity.BottomBarType) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.SDKBaseActivity
    public boolean isSlidingEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        ContactInfoPresenter contactInfoPresenter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_SEND_USER_MSG, this, i2, i3, intent) == null) {
            if (i2 == 4) {
                if (i3 == -1) {
                    if (intent != null && intent.getData() != null && (contactInfoPresenter = this.f61655b) != null) {
                        contactInfoPresenter.a(intent.getData());
                    }
                } else {
                    b bVar = f61654a;
                    if (bVar != null) {
                        bVar.onContactsSelected("", 1, null, "取消", "0");
                    }
                }
                b();
                return;
            }
            super.onActivityResult(i2, i3, intent);
        }
    }

    @Override // com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            if (this.f61656c) {
                a();
                this.f61656c = false;
            }
        }
    }
}
