package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pay.PayCallBack;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes10.dex */
public class RemotePayEnterActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RemotePayEnterActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IRemoteServiceCallback f60878a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f60879b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f60880c;

    /* renamed from: d  reason: collision with root package name */
    public String f60881d;

    public RemotePayEnterActivity() {
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

    public void getBundleData(Intent intent) {
        Bundle bundle;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, intent) == null) || intent == null) {
            return;
        }
        IBinder iBinder = null;
        try {
            bundle = intent.getBundleExtra("caller");
        } catch (Exception unused) {
            bundle = null;
        }
        if (bundle == null) {
            return;
        }
        this.f60881d = bundle.getString("order_info");
        String str = "";
        if (Build.VERSION.SDK_INT < 18) {
            try {
                iBinder = (IBinder) bundle.getClass().getDeclaredMethod("getIBinder", String.class).invoke(bundle, "callback");
            } catch (Exception e2) {
                String str2 = this.f60881d;
                String[] strArr = new String[2];
                Map<String, String> map = this.f60880c;
                strArr[0] = (map == null || map.isEmpty()) ? "" : this.f60880c.get("key_remote_pkg_name");
                strArr[1] = e2.getMessage();
                StatisticManager.onEventWithValues("remoteEnterActivityBinderCatch", RealTimeEventHelper.genEventValue(str2, strArr));
                e2.printStackTrace();
                finish();
            }
        } else {
            iBinder = bundle.getBinder("callback");
        }
        try {
            this.f60878a = IRemoteServiceCallback.Stub.asInterface(iBinder);
        } catch (Exception e3) {
            String str3 = this.f60881d;
            String[] strArr2 = new String[2];
            Map<String, String> map2 = this.f60880c;
            if (map2 != null && !map2.isEmpty()) {
                str = this.f60880c.get("key_remote_pkg_name");
            }
            strArr2[0] = str;
            strArr2[1] = e3.getMessage();
            StatisticManager.onEventWithValues("remoteEnterActivityInitcallbackCatch", RealTimeEventHelper.genEventValue(str3, strArr2));
            e3.printStackTrace();
            finish();
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("map_params");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0 || (arrayList = (ArrayList) parcelableArrayList.get(0)) == null || arrayList.size() <= 0) {
            return;
        }
        this.f60879b = (Map) arrayList.get(0);
        this.f60880c = (Map) arrayList.get(1);
    }

    @Override // com.dxmpay.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            getBundleData(getIntent());
            String str = this.f60881d;
            String[] strArr = new String[2];
            Map<String, String> map = this.f60880c;
            strArr[0] = (map == null || map.isEmpty()) ? "" : this.f60880c.get("key_remote_pkg_name");
            strArr[1] = "activity";
            StatisticManager.onEventWithValues("remoteEnterActivity", RealTimeEventHelper.genEventValue(str, strArr));
            if (BeanConstants.CHANNEL_ID.equals(com.baidu.wallet.paysdk.beans.BeanConstants.CHANNEL_ID_CHE_LIAN_WANG)) {
                WalletLoginHelper.getInstance().verifyPassLogin(false, new LoginBackListenerProxy(getActivity(), new ILoginBackListener(this) { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ RemotePayEnterActivity f60882a;

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
                        this.f60882a = this;
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onFail(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str2) == null) {
                            this.f60882a.a();
                        }
                    }

                    @Override // com.baidu.wallet.api.ILoginBackListener
                    public void onSuccess(int i2, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                            this.f60882a.a();
                        }
                    }
                }));
            } else {
                a();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            getBundleData(intent);
            String str = this.f60881d;
            String[] strArr = new String[2];
            Map<String, String> map = this.f60880c;
            strArr[0] = (map == null || map.isEmpty()) ? "" : this.f60880c.get("key_remote_pkg_name");
            strArr[1] = "activity";
            StatisticManager.onEventWithValues("remoteEnterActivity", RealTimeEventHelper.genEventValue(str, strArr));
            BaiduPayDelegate.getInstance().doRemotePay(this, this.f60881d, new PayCallBack(this) { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RemotePayEnterActivity f60884a;

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
                    this.f60884a = this;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.f60884a.f60878a != null) {
                            try {
                                try {
                                    this.f60884a.f60878a.isHideLoadingDialog();
                                } catch (RemoteException e2) {
                                    String str2 = this.f60884a.f60881d;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = (this.f60884a.f60880c == null || this.f60884a.f60880c.isEmpty()) ? "" : (String) this.f60884a.f60880c.get("key_remote_pkg_name");
                                    strArr2[1] = e2.getMessage();
                                    StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(str2, strArr2));
                                    e2.printStackTrace();
                                }
                            } finally {
                                this.f60884a.finish();
                            }
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        if (1000 == i2) {
                        }
                        try {
                            if (this.f60884a.f60878a != null) {
                                try {
                                    this.f60884a.f60878a.onPayEnd(i2, str2);
                                } catch (Exception e2) {
                                    String str3 = this.f60884a.f60881d;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = (this.f60884a.f60880c == null || this.f60884a.f60880c.isEmpty()) ? "" : (String) this.f60884a.f60880c.get("key_remote_pkg_name");
                                    strArr2[1] = e2.getMessage();
                                    StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(str3, strArr2));
                                    PayCallBackManager.isClientDead = true;
                                }
                            }
                        } finally {
                            this.f60884a.finish();
                        }
                    }
                }
            }, this.f60880c);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.dxmpay.wallet.core.beans.BeanActivity, com.dxmpay.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            BaiduPayDelegate.getInstance().doRemotePay(this, this.f60881d, new PayCallBack(this) { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RemotePayEnterActivity f60883a;

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
                    this.f60883a = this;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.f60883a.f60878a != null) {
                            try {
                                try {
                                    this.f60883a.f60878a.isHideLoadingDialog();
                                } catch (RemoteException e2) {
                                    String str = this.f60883a.f60881d;
                                    String[] strArr = new String[2];
                                    strArr[0] = (this.f60883a.f60880c == null || this.f60883a.f60880c.isEmpty()) ? "" : (String) this.f60883a.f60880c.get("key_remote_pkg_name");
                                    strArr[1] = e2.getMessage();
                                    StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(str, strArr));
                                    e2.printStackTrace();
                                }
                            } finally {
                                this.f60883a.finish();
                            }
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                        if (1000 == i2) {
                        }
                        try {
                            if (this.f60883a.f60878a != null) {
                                try {
                                    this.f60883a.f60878a.onPayEnd(i2, str);
                                } catch (RemoteException e2) {
                                    String str2 = this.f60883a.f60881d;
                                    String[] strArr = new String[2];
                                    strArr[0] = (this.f60883a.f60880c == null || this.f60883a.f60880c.isEmpty()) ? "" : (String) this.f60883a.f60880c.get("key_remote_pkg_name");
                                    strArr[1] = e2.getMessage();
                                    StatisticManager.onEventWithValues("remoteEnterActivityCatch", RealTimeEventHelper.genEventValue(str2, strArr));
                                    PayCallBackManager.isClientDead = true;
                                    e2.printStackTrace();
                                }
                            }
                        } finally {
                            this.f60883a.finish();
                        }
                    }
                }
            }, this.f60880c);
        }
    }
}
