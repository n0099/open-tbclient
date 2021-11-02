package com.baidu.wallet.lightapp.ability.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.core.permission.PermissionListener;
import com.baidu.wallet.core.permission.PermissionsUtil;
import com.baidu.wallet.core.utils.BaiduWalletUtils;
import com.baidu.wallet.lightapp.ability.NativeAbilityInvoker;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityErrorModel;
import com.baidu.wallet.lightapp.ability.datamodle.NativeAbilityNewLocationModel;
import com.baidu.wallet.lightapp.base.LightAppWrapper;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.LightappJsNativeClient;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import com.baidu.wallet.lightapp.base.datamodel.LocationProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class g extends com.baidu.wallet.lightapp.ability.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Method f58620a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58621b;

    /* renamed from: c  reason: collision with root package name */
    public LocationProvider f58622c;

    /* loaded from: classes10.dex */
    public static class a implements LocationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final ILightappInvokerCallback f58637a;

        /* renamed from: b  reason: collision with root package name */
        public final String f58638b;

        /* renamed from: c  reason: collision with root package name */
        public final LocationManager f58639c;

        /* renamed from: d  reason: collision with root package name */
        public final ArrayList<String> f58640d;

        /* renamed from: e  reason: collision with root package name */
        public final NativeAbilityNewLocationModel f58641e;

        /* renamed from: f  reason: collision with root package name */
        public Context f58642f;

        public a(Context context, ILightappInvokerCallback iLightappInvokerCallback, String str, LocationManager locationManager, ArrayList<String> arrayList, NativeAbilityNewLocationModel nativeAbilityNewLocationModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, iLightappInvokerCallback, str, locationManager, arrayList, nativeAbilityNewLocationModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58642f = context;
            this.f58637a = iLightappInvokerCallback;
            this.f58638b = str;
            this.f58639c = locationManager;
            this.f58640d = arrayList;
            this.f58641e = nativeAbilityNewLocationModel;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, location) == null) {
                if (location != null) {
                    NativeAbilityNewLocationModel nativeAbilityNewLocationModel = this.f58641e;
                    nativeAbilityNewLocationModel.result = 0;
                    nativeAbilityNewLocationModel.cnt.data.latitude = location.getLatitude();
                    this.f58641e.cnt.data.longitude = location.getLongitude();
                    Bundle a2 = com.baidu.wallet.lightapp.ability.b.a.a().a(this.f58642f, JsonUtils.toJson(this.f58641e.cnt.data));
                    this.f58641e.cnt.aesdata = a2.getString("aesContent");
                    this.f58641e.cnt.aeskey = a2.getString("aesKey");
                    NativeAbilityNewLocationModel nativeAbilityNewLocationModel2 = this.f58641e;
                    nativeAbilityNewLocationModel2.cnt.data = null;
                    this.f58637a.onResult(0, nativeAbilityNewLocationModel2.toJson());
                } else {
                    NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                    NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
                    data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                    data.des = "定位失败";
                    this.f58637a.onResult(1, nativeAbilityErrorModel.toJson());
                }
                this.f58639c.removeUpdates(this);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
                data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                data.des = "定位失败";
                this.f58637a.onResult(1, nativeAbilityErrorModel.toJson());
            }
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048579, this, str, i2, bundle) == null) {
            }
        }
    }

    public g() {
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
        this.f58620a = null;
        this.f58621b = false;
        this.f58622c = LocationProvider.HOST;
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LightappJsNativeClient.METHOD_GET_CURRENT_POSITION : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, String str, NativeAbilityNewLocationModel nativeAbilityNewLocationModel, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(65545, this, context, str, nativeAbilityNewLocationModel, iLightappInvokerCallback) == null) || context == null || iLightappInvokerCallback == null) {
            return;
        }
        if (nativeAbilityNewLocationModel == null) {
            nativeAbilityNewLocationModel = new NativeAbilityNewLocationModel();
        }
        nativeAbilityNewLocationModel.result = 1;
        NativeAbilityNewLocationModel.Data data = nativeAbilityNewLocationModel.cnt;
        data.errCode = LightappConstants.ERRCODE_NO_PERMISSION;
        data.des = PhoneUtils.getApplicationName(context) + "没有获取地理位置的权限";
        iLightappInvokerCallback.onResult(1, nativeAbilityNewLocationModel.toJson());
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(CheckUtils.stripUrlParams(str));
        } catch (Exception unused) {
        }
        arrayList.add(nativeAbilityNewLocationModel.cnt.des);
    }

    @Override // com.baidu.wallet.lightapp.ability.a
    public void a(Activity activity, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, iLightappInvokerCallback, str2) == null) {
            if (PermissionManager.checkCallingPermission(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                a((Context) activity, str, iLightappInvokerCallback, str2);
            } else {
                BaiduWalletUtils.requestPermissionsDialog(null, activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, new BaiduWalletUtils.IRequestPermissionCallBack(this, activity, str, iLightappInvokerCallback, str2) { // from class: com.baidu.wallet.lightapp.ability.a.g.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ Activity f58623a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ String f58624b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ ILightappInvokerCallback f58625c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f58626d;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ g f58627e;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, activity, str, iLightappInvokerCallback, str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f58627e = this;
                        this.f58623a = activity;
                        this.f58624b = str;
                        this.f58625c = iLightappInvokerCallback;
                        this.f58626d = str2;
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isAllAgree(Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, bool) == null) {
                            if (bool.booleanValue()) {
                                PermissionsUtil.requestPermission(this.f58623a, new PermissionListener(this) { // from class: com.baidu.wallet.lightapp.ability.a.g.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass1 f58628a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f58628a = this;
                                    }

                                    @Override // com.baidu.wallet.core.permission.PermissionListener
                                    public void permissionDenied(@NonNull List<String> list) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(1048576, this, list) == null) {
                                            AnonymousClass1 anonymousClass1 = this.f58628a;
                                            anonymousClass1.f58627e.b(anonymousClass1.f58623a, anonymousClass1.f58626d, null, anonymousClass1.f58625c);
                                        }
                                    }

                                    @Override // com.baidu.wallet.core.permission.PermissionListener
                                    public void permissionGranted(@NonNull List<String> list) {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                                            AnonymousClass1 anonymousClass1 = this.f58628a;
                                            anonymousClass1.f58627e.a((Context) anonymousClass1.f58623a, anonymousClass1.f58624b, anonymousClass1.f58625c, anonymousClass1.f58626d);
                                        }
                                    }
                                }, "android.permission.ACCESS_FINE_LOCATION");
                            } else {
                                this.f58627e.b(this.f58623a, this.f58626d, null, this.f58625c);
                            }
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void isShow(String str3, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str3, bool) == null) {
                        }
                    }

                    @Override // com.baidu.wallet.core.utils.BaiduWalletUtils.IRequestPermissionCallBack
                    public void requestResult(String str3, Boolean bool) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str3, bool) == null) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str, iLightappInvokerCallback, str2) == null) {
            iLightappInvokerCallback.onResult(-1, "");
            new Thread(this, str2, iLightappInvokerCallback, context) { // from class: com.baidu.wallet.lightapp.ability.a.g.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ String f58629a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ ILightappInvokerCallback f58630b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ Context f58631c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ g f58632d;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str2, iLightappInvokerCallback, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f58632d = this;
                    this.f58629a = str2;
                    this.f58630b = iLightappInvokerCallback;
                    this.f58631c = context;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            new ArrayList().add(CheckUtils.stripUrlParams(this.f58629a));
                        } catch (Exception unused) {
                        }
                        NativeAbilityNewLocationModel nativeAbilityNewLocationModel = new NativeAbilityNewLocationModel();
                        ILocationCallback iLocationCallback = new ILocationCallback(this, nativeAbilityNewLocationModel) { // from class: com.baidu.wallet.lightapp.ability.a.g.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* renamed from: a  reason: collision with root package name */
                            public final /* synthetic */ NativeAbilityNewLocationModel f58633a;

                            /* renamed from: b  reason: collision with root package name */
                            public final /* synthetic */ AnonymousClass2 f58634b;

                            {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, nativeAbilityNewLocationModel};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i2 = newInitContext.flag;
                                    if ((i2 & 1) != 0) {
                                        int i3 = i2 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.f58634b = this;
                                this.f58633a = nativeAbilityNewLocationModel;
                            }

                            @Override // com.baidu.wallet.api.ILocationCallback
                            public void onReceiveLocation(Object obj) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeL(1048576, this, obj) == null) {
                                    AnonymousClass2 anonymousClass2 = this.f58634b;
                                    ILightappInvokerCallback iLightappInvokerCallback2 = anonymousClass2.f58630b;
                                    if (iLightappInvokerCallback2 instanceof NativeAbilityInvoker.NativeAbilityInvokerCallback) {
                                        ((NativeAbilityInvoker.NativeAbilityInvokerCallback) iLightappInvokerCallback2).addStatics(anonymousClass2.f58632d.f58622c.name());
                                    }
                                    if (obj != null && (obj instanceof LightAppLocationModel)) {
                                        NativeAbilityNewLocationModel nativeAbilityNewLocationModel2 = this.f58633a;
                                        nativeAbilityNewLocationModel2.result = 0;
                                        NativeAbilityNewLocationModel.Loc loc = nativeAbilityNewLocationModel2.cnt.data;
                                        LightAppLocationModel.Coords coords = ((LightAppLocationModel) obj).coords;
                                        loc.latitude = coords.latitude;
                                        loc.longitude = coords.longitude;
                                        Bundle a2 = com.baidu.wallet.lightapp.ability.b.a.a().a(this.f58634b.f58631c, JsonUtils.toJson(this.f58633a.cnt.data));
                                        this.f58633a.cnt.aesdata = a2.getString("aesContent");
                                        this.f58633a.cnt.aeskey = a2.getString("aesKey");
                                        NativeAbilityNewLocationModel nativeAbilityNewLocationModel3 = this.f58633a;
                                        nativeAbilityNewLocationModel3.cnt.data = null;
                                        this.f58634b.f58630b.onResult(0, nativeAbilityNewLocationModel3.toJson());
                                        return;
                                    }
                                    NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
                                    NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
                                    data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
                                    data.des = "定位失败";
                                    this.f58634b.f58630b.onResult(1, nativeAbilityErrorModel.toJson());
                                }
                            }
                        };
                        if (LightAppWrapper.getInstance().getCurrentLocation(iLocationCallback)) {
                            return;
                        }
                        this.f58632d.f58622c = LocationProvider.OWN;
                        if (!this.f58632d.f58621b) {
                            try {
                                try {
                                    this.f58632d.f58620a = Class.forName("com.baidu.wallet.locationsdk.LocationInvoker").getDeclaredMethod("getLocation", Context.class, InvocationHandler.class);
                                } finally {
                                    this.f58632d.f58621b = true;
                                }
                            } catch (Throwable unused2) {
                                LogUtil.d("InvokeLocatonLib", "lib reflect fail");
                            }
                        }
                        if (this.f58632d.f58620a != null) {
                            try {
                                this.f58632d.f58620a.invoke(null, this.f58631c, new InvocationHandler(this, iLocationCallback) { // from class: com.baidu.wallet.lightapp.ability.a.g.2.2
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;

                                    /* renamed from: a  reason: collision with root package name */
                                    public final /* synthetic */ ILocationCallback f58635a;

                                    /* renamed from: b  reason: collision with root package name */
                                    public final /* synthetic */ AnonymousClass2 f58636b;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, iLocationCallback};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.f58636b = this;
                                        this.f58635a = iLocationCallback;
                                    }

                                    @Override // java.lang.reflect.InvocationHandler
                                    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                                        InterceptResult invokeLLL;
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || (invokeLLL = interceptable3.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                                            if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0 && objArr.length >= 3) {
                                                LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                                                lightAppLocationModel.result = 0;
                                                LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                                                lightAppLocationModel.coords = coords;
                                                coords.accuracy = ((Float) objArr[0]).floatValue();
                                                lightAppLocationModel.coords.latitude = ((Double) objArr[1]).doubleValue();
                                                lightAppLocationModel.coords.longitude = ((Double) objArr[2]).doubleValue();
                                                this.f58635a.onReceiveLocation(lightAppLocationModel);
                                            } else {
                                                this.f58635a.onReceiveLocation(null);
                                            }
                                            return null;
                                        }
                                        return invokeLLL.objValue;
                                    }
                                });
                                return;
                            } catch (Throwable unused3) {
                                iLocationCallback.onReceiveLocation(null);
                                LogUtil.d("InvokeLocatonLib", "lib invoke fail");
                                return;
                            }
                        }
                        this.f58632d.f58622c = LocationProvider.SYSTEM;
                        this.f58632d.a(this.f58631c, this.f58629a, nativeAbilityNewLocationModel, this.f58630b);
                        com.baidu.wallet.core.utils.LogUtil.d("InvokeLocatonLib", "systme location lib invoke");
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void a(Context context, String str, NativeAbilityNewLocationModel nativeAbilityNewLocationModel, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(AdIconUtil.AD_TEXT_ID, this, context, str, nativeAbilityNewLocationModel, iLightappInvokerCallback) == null) || context == null || iLightappInvokerCallback == null) {
            return;
        }
        if (nativeAbilityNewLocationModel == null) {
            nativeAbilityNewLocationModel = new NativeAbilityNewLocationModel();
        }
        NativeAbilityNewLocationModel nativeAbilityNewLocationModel2 = nativeAbilityNewLocationModel;
        if (iLightappInvokerCallback instanceof NativeAbilityInvoker.NativeAbilityInvokerCallback) {
            ((NativeAbilityInvoker.NativeAbilityInvokerCallback) iLightappInvokerCallback).addStatics(LocationProvider.SYSTEM.name());
        }
        LocationManager locationManager = (LocationManager) DxmApplicationContextImpl.getApplicationContext(context).getSystemService("location");
        if (locationManager != null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(CheckUtils.stripUrlParams(str));
            } catch (Exception unused) {
            }
            locationManager.requestSingleUpdate("network", new a(context, iLightappInvokerCallback, str, locationManager, arrayList, nativeAbilityNewLocationModel2), (Looper) null);
            return;
        }
        NativeAbilityErrorModel nativeAbilityErrorModel = new NativeAbilityErrorModel(1);
        NativeAbilityErrorModel.Data data = nativeAbilityErrorModel.cnt;
        data.errCode = LightappConstants.ERRCODE_INNER_ERROR;
        data.des = "定位失败";
        iLightappInvokerCallback.onResult(1, nativeAbilityErrorModel.toJson());
    }
}
