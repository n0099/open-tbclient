package com.baidu.wallet.remotepay;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.android.pay.PayCallBack;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.BaiduPayDelegate;
import com.baidu.wallet.api.Constants;
import com.baidu.wallet.base.a.a;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes6.dex */
public class RemotePayEnterActivity extends PayBaseBeanActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RemotePayEnterActivity";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public IRemoteServiceCallback f27190a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f27191b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f27192c;

    /* renamed from: d  reason: collision with root package name */
    public String f27193d;

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
        this.f27193d = bundle.getString("order_info");
        String str = "";
        if (Build.VERSION.SDK_INT < 18) {
            try {
                iBinder = (IBinder) bundle.getClass().getDeclaredMethod("getIBinder", String.class).invoke(bundle, "callback");
            } catch (Exception e2) {
                String str2 = this.f27193d;
                String[] strArr = new String[2];
                Map<String, String> map = this.f27192c;
                strArr[0] = (map == null || map.isEmpty()) ? "" : this.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
                strArr[1] = e2.getMessage();
                PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_BINDER_CATCH, a.a(str2, strArr));
                e2.printStackTrace();
                finish();
            }
        } else {
            iBinder = bundle.getBinder("callback");
        }
        try {
            this.f27190a = IRemoteServiceCallback.Stub.asInterface(iBinder);
        } catch (Exception e3) {
            String str3 = this.f27193d;
            String[] strArr2 = new String[2];
            Map<String, String> map2 = this.f27192c;
            if (map2 != null && !map2.isEmpty()) {
                str = this.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
            }
            strArr2[0] = str;
            strArr2[1] = e3.getMessage();
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_INITCALLBACK_CATCH, a.a(str3, strArr2));
            e3.printStackTrace();
            finish();
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("map_params");
        if (parcelableArrayList == null || parcelableArrayList.size() <= 0 || (arrayList = (ArrayList) parcelableArrayList.get(0)) == null || arrayList.size() <= 0) {
            return;
        }
        this.f27191b = (Map) arrayList.get(0);
        this.f27192c = (Map) arrayList.get(1);
    }

    @Override // com.baidu.wallet.core.beans.BeanActivity
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            getBundleData(getIntent());
            String str = this.f27193d;
            String[] strArr = new String[2];
            Map<String, String> map = this.f27192c;
            strArr[0] = (map == null || map.isEmpty()) ? "" : this.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
            strArr[1] = "activity";
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY, a.a(str, strArr));
            BaiduPayDelegate.getInstance().doRemotePay(this, this.f27193d, new PayCallBack(this) { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RemotePayEnterActivity f27194a;

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
                    this.f27194a = this;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.f27194a.f27190a != null) {
                            try {
                                try {
                                    this.f27194a.f27190a.isHideLoadingDialog();
                                } catch (RemoteException e2) {
                                    String str2 = this.f27194a.f27193d;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = (this.f27194a.f27192c == null || this.f27194a.f27192c.isEmpty()) ? "" : (String) this.f27194a.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
                                    strArr2[1] = e2.getMessage();
                                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str2, strArr2));
                                    e2.printStackTrace();
                                }
                            } finally {
                                this.f27194a.finish();
                            }
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        if (1000 == i2) {
                        }
                        try {
                            if (this.f27194a.f27190a != null) {
                                try {
                                    this.f27194a.f27190a.onPayEnd(i2, str2);
                                } catch (RemoteException e2) {
                                    String str3 = this.f27194a.f27193d;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = (this.f27194a.f27192c == null || this.f27194a.f27192c.isEmpty()) ? "" : (String) this.f27194a.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
                                    strArr2[1] = e2.getMessage();
                                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str3, strArr2));
                                    PayCallBackManager.isClientDead = true;
                                    e2.printStackTrace();
                                }
                            }
                        } finally {
                            this.f27194a.finish();
                        }
                    }
                }
            }, this.f27192c);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            super.onNewIntent(intent);
            getBundleData(intent);
            String str = this.f27193d;
            String[] strArr = new String[2];
            Map<String, String> map = this.f27192c;
            strArr[0] = (map == null || map.isEmpty()) ? "" : this.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
            strArr[1] = "activity";
            PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY, a.a(str, strArr));
            BaiduPayDelegate.getInstance().doRemotePay(this, this.f27193d, new PayCallBack(this) { // from class: com.baidu.wallet.remotepay.RemotePayEnterActivity.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ RemotePayEnterActivity f27195a;

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
                    this.f27195a = this;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public boolean isHideLoadingDialog() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        if (this.f27195a.f27190a != null) {
                            try {
                                try {
                                    this.f27195a.f27190a.isHideLoadingDialog();
                                } catch (RemoteException e2) {
                                    String str2 = this.f27195a.f27193d;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = (this.f27195a.f27192c == null || this.f27195a.f27192c.isEmpty()) ? "" : (String) this.f27195a.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
                                    strArr2[1] = e2.getMessage();
                                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str2, strArr2));
                                    e2.printStackTrace();
                                }
                            } finally {
                                this.f27195a.finish();
                            }
                        }
                        return false;
                    }
                    return invokeV.booleanValue;
                }

                @Override // com.baidu.android.pay.PayCallBack
                public void onPayResult(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        if (1000 == i2) {
                        }
                        try {
                            if (this.f27195a.f27190a != null) {
                                try {
                                    this.f27195a.f27190a.onPayEnd(i2, str2);
                                } catch (Exception e2) {
                                    String str3 = this.f27195a.f27193d;
                                    String[] strArr2 = new String[2];
                                    strArr2[0] = (this.f27195a.f27192c == null || this.f27195a.f27192c.isEmpty()) ? "" : (String) this.f27195a.f27192c.get(Constants.KEY_REMOTE_PKG_NAME);
                                    strArr2[1] = e2.getMessage();
                                    PayStatisticsUtil.onEventWithValues(StatServiceEvent.REMOTE_ENTER_ACTIVITY_CATCH, a.a(str3, strArr2));
                                    PayCallBackManager.isClientDead = true;
                                }
                            }
                        } finally {
                            this.f27195a.finish();
                        }
                    }
                }
            }, this.f27192c);
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.PayBaseBeanActivity, com.baidu.wallet.core.beans.BeanActivity, com.baidu.wallet.core.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onResume();
        }
    }
}
