package com.baidu.wallet.analytics;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.restnet.converter.b;
import com.baidu.apollon.restnet.rest.RestHttpRequestInterceptor;
import com.baidu.apollon.restnet.rest.d;
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
import com.baidu.wallet.core.domain.DomainConfig;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class TraceBean extends BaseBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_URL = "/tongji/performance/stat.jpg";
    public static final String TAG = "TraceBean";
    public static String sCUID = "";
    public static String sCUID2 = "";
    public static String sUnionId = "";
    public transient /* synthetic */ FieldHolder $fh;
    public String mBaseUrl;
    public List<RestNameValuePair> mPostParams;
    public List<RestNameValuePair> mQueryParams;

    /* loaded from: classes11.dex */
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
                if (!TextUtils.isEmpty(TraceBean.sUnionId)) {
                    dVar.a().b("Cookie", "unionId=" + TraceBean.sUnionId);
                }
                dVar.a().b("Cookie", "cuid_1=" + TraceBean.sCUID);
                dVar.a().b("Cookie", "cuid_2=" + TraceBean.sCUID2);
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
        if (TextUtils.isEmpty(sCUID)) {
            sCUID = PhoneUtils.getCUID(context);
        }
        if (TextUtils.isEmpty(sCUID2)) {
            sCUID2 = PhoneUtils.getCUID2(context);
        }
        if (WalletLoginHelper.getInstance().isLogin()) {
            sUnionId = WalletLoginHelper.getInstance().getUnionId();
        }
    }

    public TraceBean buildBaseUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            this.mBaseUrl = str;
            if (!TextUtils.isEmpty(str)) {
                this.tag[0] = Boolean.TRUE;
            }
            return this;
        }
        return (TraceBean) invokeL.objValue;
    }

    public TraceBean buildParams(List<RestNameValuePair> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, str)) == null) {
            if ("GET".equalsIgnoreCase(str)) {
                buildQueryParams(list);
            } else {
                buildPostParams(list);
            }
            return this;
        }
        return (TraceBean) invokeLL.objValue;
    }

    public TraceBean buildPostParams(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (this.mPostParams == null) {
                this.mPostParams = new ArrayList();
            }
            this.mPostParams.addAll(list);
            return this;
        }
        return (TraceBean) invokeL.objValue;
    }

    public TraceBean buildQueryParams(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, list)) == null) {
            if (this.mQueryParams == null) {
                this.mQueryParams = new ArrayList();
            }
            this.mQueryParams.addAll(list);
            return this;
        }
        return (TraceBean) invokeL.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public void execBean() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.execBean(null);
        }
    }

    @Override // com.baidu.wallet.core.beans.NetworkBean
    public List<RestNameValuePair> generateRequestParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mPostParams : (List) invokeV.objValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getBeanId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public int getHttpMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            List<RestNameValuePair> list = this.mPostParams;
            return (list == null || list.size() <= 0) ? 0 : 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.apollon.beans.ApollonBean
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = TextUtils.isEmpty(this.mBaseUrl) ? DomainConfig.getInstance().getHawkinghost(this.tag) + DEFAULT_URL : this.mBaseUrl;
            if (this.mQueryParams != null) {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (int i2 = 0; i2 < this.mQueryParams.size(); i2++) {
                    buildUpon.appendQueryParameter(this.mQueryParams.get(i2).getName(), this.mQueryParams.get(i2).getValue());
                }
                String uri = buildUpon.build().toString();
                LogUtil.i(TAG, "TraceBean getUrl：" + uri);
                return uri;
            }
            LogUtil.i(TAG, "TraceBean getUrl：" + str);
            return str;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.wallet.core.beans.BaseBean, com.baidu.apollon.beans.ApollonBean
    public void prepareRestTemplate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.prepareRestTemplate();
            this.mRestTemplate.a().add(new CustomInterceptors(this));
            this.mRestTemplate.setMessageConverter(new b());
        }
    }
}
