package com.baidu.wallet.lightapp.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.NoProguard;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightAppListener;
import com.baidu.wallet.api.ILightappInvoker;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.lightapp.base.datamodel.LightAppShareModel;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.util.Arrays;
import java.util.Set;
/* loaded from: classes5.dex */
public class LightAppWrapper implements NoProguard, ILightappInvoker {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String LIGHT_APP_METHOD_IMPL_BY_APP = "method_implemented_by_app";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ILightAppListener f25271a;

    /* renamed from: com.baidu.wallet.lightapp.base.LightAppWrapper$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static LightAppWrapper f25272a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1681565976, "Lcom/baidu/wallet/lightapp/base/LightAppWrapper$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1681565976, "Lcom/baidu/wallet/lightapp/base/LightAppWrapper$a;");
                    return;
                }
            }
            f25272a = new LightAppWrapper(null);
        }
    }

    public /* synthetic */ LightAppWrapper(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static LightAppWrapper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f25272a : (LightAppWrapper) invokeV.objValue;
    }

    public boolean callShare(Activity activity, LightAppShareModel lightAppShareModel, ILightappInvokerCallback iLightappInvokerCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, lightAppShareModel, iLightappInvokerCallback)) == null) {
            if (activity == null) {
                return false;
            }
            ILightAppListener iLightAppListener = this.f25271a;
            if (iLightAppListener != null) {
                boolean callShare = iLightAppListener.callShare(activity, lightAppShareModel.toMap(), iLightappInvokerCallback);
                if (callShare) {
                    DXMSdkSAUtils.onEventWithValues(LIGHT_APP_METHOD_IMPL_BY_APP, Arrays.asList("#callShare"));
                    PayStatisticsUtil.onEventWithValue("#callShare", LIGHT_APP_METHOD_IMPL_BY_APP);
                    return callShare;
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", lightAppShareModel.content + " - " + lightAppShareModel.linkUrl);
                intent.putExtra("android.intent.extra.SUBJECT", lightAppShareModel.title);
                intent.setType("text/*");
                activity.startActivity(Intent.createChooser(intent, ResUtils.getString(activity, "wallet_lightapp_share")));
            } else {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.putExtra("android.intent.extra.TEXT", lightAppShareModel.content + " - " + lightAppShareModel.linkUrl);
                intent2.putExtra("android.intent.extra.SUBJECT", lightAppShareModel.title);
                intent2.setType("text/*");
                activity.startActivity(Intent.createChooser(intent2, ResUtils.getString(activity, "wallet_lightapp_share")));
            }
            if (iLightappInvokerCallback != null) {
                iLightappInvokerCallback.onResult(0, "");
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public boolean getCurrentLocation(ILocationCallback iLocationCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iLocationCallback)) == null) {
            ILightAppListener iLightAppListener = this.f25271a;
            if (iLightAppListener == null || !iLightAppListener.getCurrentLocation(iLocationCallback)) {
                return false;
            }
            DXMSdkSAUtils.onEventWithValues(LIGHT_APP_METHOD_IMPL_BY_APP, Arrays.asList(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS));
            PayStatisticsUtil.onEventWithValue(LightAppStatEvent.LIGHT_APP_EVENTID_GET_CURRENT_POS, LIGHT_APP_METHOD_IMPL_BY_APP);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ILightAppListener iLightAppListener = this.f25271a;
            if (iLightAppListener != null) {
                return iLightAppListener.getMethodList();
            }
            return null;
        }
        return (Set) invokeV.objValue;
    }

    public void initLightApp(ILightAppListener iLightAppListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iLightAppListener) == null) {
            this.f25271a = iLightAppListener;
        }
    }

    @Override // com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        ILightAppListener iLightAppListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, context, str, iLightappInvokerCallback) == null) || (iLightAppListener = this.f25271a) == null) {
            return;
        }
        iLightAppListener.lightappInvoke(context, str, iLightappInvokerCallback);
    }

    public LightAppWrapper() {
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
}
