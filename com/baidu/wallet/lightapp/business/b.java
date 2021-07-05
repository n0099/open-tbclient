package com.baidu.wallet.lightapp.business;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.Domains;
import com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f25465a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f25466b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f25467c;

    /* renamed from: d  reason: collision with root package name */
    public long f25468d;

    /* renamed from: e  reason: collision with root package name */
    public String f25469e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f25470f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f25471g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a f25472a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                this.f25472a.destroyBean();
            }
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                this.f25472a.destroyBean();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final b f25473a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-821577425, "Lcom/baidu/wallet/lightapp/business/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-821577425, "Lcom/baidu/wallet/lightapp/business/b$a;");
                    return;
                }
            }
            f25473a = new b(null);
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.f25473a : (b) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            synchronized (this.f25467c) {
                String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
                this.f25470f = strArr;
                this.f25471g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
                this.f25468d = 1800000L;
                this.f25469e = "";
                Arrays.sort(strArr);
                Arrays.sort(this.f25471g);
                JSONObject jSONObject = new JSONObject();
                this.f25466b = jSONObject;
                try {
                    jSONObject.put("domains", this.f25470f);
                    this.f25466b.put("packages", this.f25471g);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private String c() {
        InterceptResult invokeV;
        String[] strArr;
        String[] strArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            StringBuilder sb = new StringBuilder(StringUtil.ARRAY_START);
            sb.append("\"");
            sb.append("domains");
            sb.append("\":[");
            for (String str : this.f25470f) {
                sb.append("\"");
                sb.append(str);
                sb.append("\",");
            }
            if (this.f25470f.length > 0) {
                sb.replace(sb.length() - 1, sb.length(), "],");
            } else {
                sb.append("],");
            }
            sb.append("\"");
            sb.append("packages");
            sb.append("\":[");
            for (String str2 : this.f25471g) {
                sb.append("\"");
                sb.append(str2);
                sb.append("\",");
            }
            if (this.f25471g.length > 0) {
                sb.replace(sb.length() - 1, sb.length(), "],");
            } else {
                sb.append("],");
            }
            sb.append("\"");
            sb.append("fingerprint");
            sb.append("\":");
            sb.append("\"");
            sb.append(this.f25469e);
            sb.append("\",");
            sb.append("\"");
            sb.append("interval");
            sb.append("\":");
            sb.append("\"");
            sb.append(this.f25468d);
            sb.append("\"}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public b() {
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
        this.f25467c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            if (this.f25465a == null && context != null) {
                this.f25465a = context.getApplicationContext();
            }
            return this.f25465a != null;
        }
        return invokeL.booleanValue;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, langBridgeCfg) == null) && a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f25467c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f25469e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f25470f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f25470f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f25471g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f25471g = new String[0];
                }
                this.f25469e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f25468d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.f25465a, "langbridge", "config", c());
                SharedPreferencesUtils.setParam(this.f25465a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
