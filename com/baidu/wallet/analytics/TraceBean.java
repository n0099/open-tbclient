package com.baidu.wallet.analytics;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BaseBean;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class TraceBean extends BaseBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SALT = "0B4rMozbYb^R2pN04QwGa*JkTxA9EmQ5";
    public static String sBaiduCUIDHash = "";
    public static String sCUIDHash = "";
    public static String sUnionIdHash = "";
    public transient /* synthetic */ FieldHolder $fh;
    public String mHttpMethod;
    public List<RestNameValuePair> mParams;

    /* loaded from: classes6.dex */
    public class CustomInterceptors implements RestHttpRequestInterceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TraceBean this$0;

        public CustomInterceptors(TraceBean traceBean) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {traceBean};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = traceBean;
        }

        @Override // com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor
        public void intercept(Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, dVar) == null) {
                if (!TextUtils.isEmpty(TraceBean.sUnionIdHash)) {
                    dVar.a().b("Cookie", "unionIdHash=" + TraceBean.sUnionIdHash);
                }
                dVar.a().b("Cookie", "cuidHash=" + TraceBean.sCUIDHash);
                dVar.a().b("Cookie", "baiducuidHash=" + TraceBean.sBaiduCUIDHash);
                List<String> list = dVar.a().get("Cookie");
                String str = "";
                for (int i2 = 0; i2 < list.size(); i2++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(list.get(i2).endsWith(";") ? "" : ";" + list.get(i2));
                    str = sb.toString();
                }
                dVar.a().a("Cookie", str.substring(1));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-313528553, "Lcom/baidu/wallet/analytics/TraceBean;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-313528553, "Lcom/baidu/wallet/analytics/TraceBean;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraceBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mHttpMethod = "GET";
        if (TextUtils.isEmpty(sCUIDHash)) {
            sCUIDHash = Md5Utils.toMD5(PhoneUtils.getCUID(context) + SALT, "UTF-8");
        }
        if (TextUtils.isEmpty(sBaiduCUIDHash)) {
            sBaiduCUIDHash = Md5Utils.toMD5(PhoneUtils.getCUID2(context) + SALT, "UTF-8");
        }
        if (WalletLoginHelper.getInstance().isLogin()) {
            sUnionIdHash = Md5Utils.toMD5(WalletLoginHelper.getInstance().getUnionId() + SALT, "UTF-8");
        }
    }

    public TraceBean buildParams(List<RestNameValuePair> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, list, str)) == null) {
            if (this.mParams == null) {
                this.mParams = new ArrayList();
            }
            this.mParams.addAll(list);
            this.mHttpMethod = str;
            return this;
        }
        return (TraceBean) invokeLL.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.execBean(null);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if ("GET".equalsIgnoreCase(this.mHttpMethod)) {
                return null;
            }
            return this.mParams;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? !"GET".equalsIgnoreCase(this.mHttpMethod) ? 1 : 0 : invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if ("GET".equalsIgnoreCase(this.mHttpMethod)) {
                Uri.Builder buildUpon = Uri.parse("https://qianbao.baidu.com/tongji/performance/stat.jpg").buildUpon();
                for (int i2 = 0; i2 < this.mParams.size(); i2++) {
                    buildUpon.appendQueryParameter(this.mParams.get(i2).getName(), this.mParams.get(i2).getValue());
                }
                return buildUpon.build().toString();
            }
            return "https://qianbao.baidu.com/tongji/performance/stat.jpg";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.prepareRestTemplate();
            this.mRestTemplate.a().add(new CustomInterceptors(this));
            this.mRestTemplate.setMessageConverter(new b());
        }
    }
}
