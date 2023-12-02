package com.baidu.tieba.passaccount.app;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.account.certification.CertificationCheckParams;
import com.baidu.tbadk.core.account.certification.CertificationRequestParams;
import com.baidu.tbadk.core.account.certification.CheckCertificationResult;
import com.baidu.tbadk.core.account.certification.ICertificationCallback;
import com.baidu.tbadk.core.account.certification.ICheckCertificationCallback;
import com.baidu.tbadk.core.account.certification.TbAccountRealNameResult;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.oma;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AccountAuthDispatcher implements oma {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Integer> STATUS;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements ICheckCertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ AccountAuthDispatcher d;

        public a(AccountAuthDispatcher accountAuthDispatcher, int i, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountAuthDispatcher, Integer.valueOf(i), context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = accountAuthDispatcher;
            this.a = i;
            this.b = context;
            this.c = str;
        }

        @Override // com.baidu.tbadk.core.account.certification.ICheckCertificationCallback
        public void onResult(@Nullable CheckCertificationResult checkCertificationResult) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, checkCertificationResult) != null) || checkCertificationResult == null) {
                return;
            }
            if (!AccountAuthDispatcher.STATUS.containsKey(checkCertificationResult.action) || ((Integer) AccountAuthDispatcher.STATUS.get(checkCertificationResult.action)).intValue() < this.a) {
                this.d.launchRealName(this.b, this.c);
            } else {
                this.d.dealOneLink(this.b, this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ICertificationCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ AccountAuthDispatcher c;

        public b(AccountAuthDispatcher accountAuthDispatcher, Context context, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {accountAuthDispatcher, context, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = accountAuthDispatcher;
            this.a = context;
            this.b = str;
        }

        @Override // com.baidu.tbadk.core.account.certification.ICertificationCallback
        public void onResult(TbAccountRealNameResult tbAccountRealNameResult) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, tbAccountRealNameResult) != null) || tbAccountRealNameResult == null) {
                return;
            }
            if (tbAccountRealNameResult.resultCode == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || !tbAccountRealNameResult.seniorRealNameSuc) {
                return;
            }
            this.c.dealOneLink(this.a, this.b);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(473626062, "Lcom/baidu/tieba/passaccount/app/AccountAuthDispatcher;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(473626062, "Lcom/baidu/tieba/passaccount/app/AccountAuthDispatcher;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        STATUS = hashMap;
        hashMap.put("cert_face_match", 1);
        STATUS.put("advanced_cert_face_match", 2);
    }

    public AccountAuthDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealOneLink(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, context, str) == null) && !TextUtils.isEmpty(str) && (context instanceof TbPageContextSupport)) {
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) context).getPageContext(), new String[]{str});
        }
    }

    public void launchRealName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str) == null) {
            MessageManager.getInstance().runTask(2921710, String.class, new CertificationRequestParams(new b(this, context, str)));
        }
    }

    @Override // com.baidu.tieba.oma
    public void dispatch(JSONObject jSONObject, Context context) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, jSONObject, context) == null) {
            if (jSONObject != null) {
                str = jSONObject.optString("success_jump_url");
            } else {
                str = null;
            }
            if (jSONObject != null) {
                i = jSONObject.optInt("level");
            } else {
                i = 2;
            }
            MessageManager.getInstance().runTask(2921709, String.class, new CertificationCheckParams(null, new a(this, i, context, str)));
        }
    }
}
