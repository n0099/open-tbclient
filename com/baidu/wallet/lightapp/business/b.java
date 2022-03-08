package com.baidu.wallet.lightapp.business;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.SharedPreferencesUtils;
import com.baidu.bdtask.model.info.TaskInfo;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.datamodel.LangBridgeCfg;
import com.dxmpay.wallet.core.Domains;
import com.yy.hiidostatis.inner.FlushManager;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50220b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f50221c;

    /* renamed from: d  reason: collision with root package name */
    public long f50222d;

    /* renamed from: e  reason: collision with root package name */
    public String f50223e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f50224f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f50225g;

    /* renamed from: com.baidu.wallet.lightapp.business.b$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass1 implements IBeanResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ com.baidu.wallet.lightapp.business.a.a a;

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecFailure(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, str) == null) {
                this.a.destroyBean();
            }
        }

        @Override // com.baidu.apollon.beans.IBeanResponseCallback
        public void onBeanExecSuccess(int i2, Object obj, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, obj, str) == null) {
                this.a.destroyBean();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final b a;
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
            a = new b(null);
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (b) invokeV.objValue;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            synchronized (this.f50221c) {
                String[] strArr = {Domains.BAIDU, Domains.BAIFUBAO, Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT};
                this.f50224f = strArr;
                this.f50225g = new String[]{"com.android.fileexplorer", "com.android.browser", "com.android.chrome", "com.android.mms", "com.android.server.telecom", "com.android.camera", "com.miui.gallery", "com.android.fileexplorer", "com.android.contacts"};
                this.f50222d = FlushManager.ReportTimer.DEFAULT_INTERVAL;
                this.f50223e = "";
                Arrays.sort(strArr);
                Arrays.sort(this.f50225g);
                JSONObject jSONObject = new JSONObject();
                this.f50220b = jSONObject;
                try {
                    jSONObject.put("domains", this.f50224f);
                    this.f50220b.put("packages", this.f50225g);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            StringBuilder sb = new StringBuilder("{");
            sb.append("\"");
            sb.append("domains");
            sb.append("\":[");
            for (String str : this.f50224f) {
                sb.append("\"");
                sb.append(str);
                sb.append("\",");
            }
            if (this.f50224f.length > 0) {
                sb.replace(sb.length() - 1, sb.length(), "],");
            } else {
                sb.append("],");
            }
            sb.append("\"");
            sb.append("packages");
            sb.append("\":[");
            for (String str2 : this.f50225g) {
                sb.append("\"");
                sb.append(str2);
                sb.append("\",");
            }
            if (this.f50225g.length > 0) {
                sb.replace(sb.length() - 1, sb.length(), "],");
            } else {
                sb.append("],");
            }
            sb.append("\"");
            sb.append(TaskInfo.keyFingerprint);
            sb.append("\":");
            sb.append("\"");
            sb.append(this.f50223e);
            sb.append("\",");
            sb.append("\"");
            sb.append("interval");
            sb.append("\":");
            sb.append("\"");
            sb.append(this.f50222d);
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
        this.f50221c = new byte[0];
        b();
    }

    private boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, context)) == null) {
            if (this.a == null && context != null) {
                this.a = DxmApplicationContextImpl.getApplicationContext(context);
            }
            return this.a != null;
        }
        return invokeL.booleanValue;
    }

    public void a(Context context, LangBridgeCfg langBridgeCfg) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, context, langBridgeCfg) == null) && a(context) && langBridgeCfg.checkResponseValidity()) {
            synchronized (this.f50221c) {
                LangBridgeCfg.LbConfig lbConfig = langBridgeCfg.lbconfig;
                if (this.f50223e.equals(lbConfig.fingerprint)) {
                    return;
                }
                if (lbConfig.domains != null) {
                    String[] strArr = (String[]) Arrays.copyOf(lbConfig.domains, lbConfig.domains.length);
                    this.f50224f = strArr;
                    Arrays.sort(strArr);
                } else {
                    this.f50224f = new String[0];
                }
                if (lbConfig.packages != null) {
                    String[] strArr2 = (String[]) Arrays.copyOf(lbConfig.packages, lbConfig.packages.length);
                    this.f50225g = strArr2;
                    Arrays.sort(strArr2);
                } else {
                    this.f50225g = new String[0];
                }
                this.f50223e = lbConfig.fingerprint;
                if (0 <= lbConfig.interval) {
                    this.f50222d = lbConfig.interval * 60000;
                }
                SharedPreferencesUtils.setParam(this.a, "langbridge", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, c());
                SharedPreferencesUtils.setParam(this.a, "langbridge", "lbc_update_timestamp", Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
