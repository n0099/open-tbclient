package com.baidu.tieba.wallet;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import c.a.d.f.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wallet.pay.ShareUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.ILightAppListener;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LightAppListenerImpl implements ILightAppListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;

    public LightAppListenerImpl() {
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
        this.TAG = getClass().getSimpleName();
    }

    @Override // com.baidu.wallet.api.ILightAppListener
    public boolean callShare(Activity activity, Map<String, String> map, ILightappInvokerCallback iLightappInvokerCallback) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, activity, map, iLightappInvokerCallback)) == null) {
            if (activity == null || map == null) {
                return false;
            }
            String str = map.get(ILightAppListener.KEY_SHARE_TITLE);
            String str2 = map.get(ILightAppListener.KEY_SHARE_CONTENT);
            String str3 = map.get(ILightAppListener.KEY_SHARE_LINK);
            String str4 = map.get(ILightAppListener.KEY_SHARE_IMAGE);
            String str5 = map.get(ILightAppListener.KEY_SHARE_MEDIATYPE);
            if (TextUtils.isEmpty(str3)) {
                return false;
            }
            ShareUtils.share(activity, str5, str, str2, str3, str4);
            return true;
        }
        return invokeLLL.booleanValue;
    }

    @Override // com.baidu.wallet.api.ILightAppListener
    public boolean getCurrentLocation(ILocationCallback iLocationCallback) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iLocationCallback)) == null) {
            if (iLocationCallback == null) {
                return false;
            }
            a.n().k(false, new a.c(this, iLocationCallback) { // from class: com.baidu.tieba.wallet.LightAppListenerImpl.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ LightAppListenerImpl this$0;
                public final /* synthetic */ ILocationCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iLocationCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = iLocationCallback;
                }

                @Override // c.a.d.f.i.a.c
                public void onLocationGeted(int i2, String str, Address address) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, address) == null) {
                        if (i2 != 0) {
                            if (i2 == 1 || i2 == 2 || i2 == 3) {
                                this.val$callback.onReceiveLocation(null);
                            } else if (i2 != 4 && i2 != 5) {
                                this.val$callback.onReceiveLocation(null);
                            } else {
                                this.val$callback.onReceiveLocation(null);
                            }
                        } else if (address != null) {
                            LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
                            lightAppLocationModel.result = 0;
                            LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
                            lightAppLocationModel.coords = coords;
                            coords.latitude = address.getLatitude();
                            lightAppLocationModel.coords.longitude = address.getLongitude();
                            if (address.getExtras() != null) {
                                lightAppLocationModel.coords.accuracy = address.getExtras().getFloat("radius");
                            }
                            this.val$callback.onReceiveLocation(lightAppLocationModel);
                        }
                    }
                }
            });
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.wallet.api.ILightAppListener, com.baidu.wallet.api.ILightappInvoker
    public Set<String> getMethodList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            HashSet hashSet = new HashSet();
            hashSet.add("toast");
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.baidu.wallet.api.ILightAppListener, com.baidu.wallet.api.ILightappInvoker
    public void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, context, str, iLightappInvokerCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method_name");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                jSONObject.getString(LightappConstants.LIGHT_APP_NATIVE_INVOKER_FROM_URL);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if ("toast".equals(string)) {
                iLightappInvokerCallback.onResult(0, "1");
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
