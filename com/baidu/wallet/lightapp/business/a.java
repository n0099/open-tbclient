package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.business.c;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static C1837a f61605a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.wallet.lightapp.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1837a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f61612a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap f61613b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f61614c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f61615d;

        public C1837a() {
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

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "hookUrl=" + this.f61612a + "\n\ttoAddKeyVauleMap=" + this.f61613b.toString() + "\n\ttoAddJsFilesName=" + Arrays.toString(this.f61614c) + "\n\ttoAddJsFilesContent=" + Arrays.toString(this.f61615d);
            }
            return (String) invokeV.objValue;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, HashMap hashMap, String[] strArr, String[] strArr2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65539, this, str, hashMap, strArr, strArr2) == null) {
                this.f61612a = str;
                this.f61613b = hashMap;
                this.f61614c = strArr;
                this.f61615d = strArr2;
                LogUtil.d("WebViewCacheManager", "updateImpact\n" + toString());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1542752659, "Lcom/baidu/wallet/lightapp/business/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1542752659, "Lcom/baidu/wallet/lightapp/business/a;");
                return;
            }
        }
        f61605a = new C1837a();
    }

    public static void a(Context context, String str, String[] strArr, String[] strArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, context, str, strArr, strArr2) == null) {
            LogUtil.d("WebViewCacheManager", "findConfigImpactJsFiles hookUrl=" + str + "; targetConfig=" + Arrays.toString(strArr) + " ; targetKeys=" + Arrays.toString(strArr2));
            if (!TextUtils.isEmpty(str) && !str.equals(f61605a.f61612a)) {
                if (strArr == null || strArr.length <= 0 || strArr2 == null || strArr2.length <= 0) {
                    return;
                }
                c.a(str, context, strArr, new c.a(strArr2, new HashMap(), context, str) { // from class: com.baidu.wallet.lightapp.business.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ String[] f61606a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ HashMap f61607b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ Context f61608c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ String f61609d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {strArr2, r7, context, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61606a = strArr2;
                        this.f61607b = r7;
                        this.f61608c = context;
                        this.f61609d = str;
                    }

                    @Override // com.baidu.wallet.lightapp.business.c.a
                    public void a(String[] strArr3) {
                        String[] strArr4;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, strArr3) == null) {
                            LogUtil.d("WebViewCacheManager", "onLoadComplete files.length=" + strArr3.length + "\tconfigFiles:" + Arrays.toString(strArr3));
                            if (strArr3 == null || strArr3.length == 0) {
                                return;
                            }
                            HashSet hashSet = new HashSet();
                            for (String str2 : this.f61606a) {
                                if (!TextUtils.isEmpty(str2)) {
                                    for (String str3 : strArr3) {
                                        if (!TextUtils.isEmpty(str3)) {
                                            try {
                                                JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str2);
                                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                                    int length = optJSONArray.length();
                                                    String[] strArr5 = new String[length];
                                                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                                        strArr5[i2] = String.valueOf(optJSONArray.get(i2));
                                                    }
                                                    if (length > 0) {
                                                        this.f61607b.put(str2, strArr5);
                                                        hashSet.addAll(new HashSet(Arrays.asList(strArr5)));
                                                    }
                                                }
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                                return;
                                            }
                                        }
                                    }
                                    continue;
                                }
                            }
                            if (hashSet.size() > 0) {
                                int size = hashSet.size();
                                String[] strArr6 = new String[size];
                                hashSet.toArray(strArr6);
                                if (size > 0) {
                                    c.a(SdkInitResponse.getInstance().getJsHookURl(this.f61608c), this.f61608c, strArr6, new c.a(this, strArr6) { // from class: com.baidu.wallet.lightapp.business.a.1.1
                                        public static /* synthetic */ Interceptable $ic;
                                        public transient /* synthetic */ FieldHolder $fh;

                                        /* renamed from: a  reason: collision with root package name */
                                        public final /* synthetic */ String[] f61610a;

                                        /* renamed from: b  reason: collision with root package name */
                                        public final /* synthetic */ AnonymousClass1 f61611b;

                                        {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 != null) {
                                                InitContext newInitContext = TitanRuntime.newInitContext();
                                                newInitContext.initArgs = r2;
                                                Object[] objArr = {this, strArr6};
                                                interceptable3.invokeUnInit(65536, newInitContext);
                                                int i3 = newInitContext.flag;
                                                if ((i3 & 1) != 0) {
                                                    int i4 = i3 & 2;
                                                    newInitContext.thisArg = this;
                                                    interceptable3.invokeInitBody(65536, newInitContext);
                                                    return;
                                                }
                                            }
                                            this.f61611b = this;
                                            this.f61610a = strArr6;
                                        }

                                        @Override // com.baidu.wallet.lightapp.business.c.a
                                        public void a(String[] strArr7) {
                                            Interceptable interceptable3 = $ic;
                                            if (interceptable3 == null || interceptable3.invokeL(1048576, this, strArr7) == null) {
                                                if (strArr7 == null && strArr7.length == 0) {
                                                    LogUtil.d("WebViewCacheManager", "获取到的js文件为空");
                                                    return;
                                                }
                                                LogUtil.d("WebViewCacheManager", "成功获取到js文件");
                                                C1837a c1837a = a.f61605a;
                                                AnonymousClass1 anonymousClass1 = this.f61611b;
                                                c1837a.a(anonymousClass1.f61609d, anonymousClass1.f61607b, this.f61610a, strArr7);
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    }
                });
                return;
            }
            LogUtil.d("WebViewCacheManager", "findConfigImpactJsFiles 已下载过" + str);
        }
    }

    public static String[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str) || f61605a.f61613b == null || f61605a.f61613b.size() <= 0) {
                return null;
            }
            return (String[]) f61605a.f61613b.get(str);
        }
        return (String[]) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && f61605a.f61614c != null && f61605a.f61615d != null && f61605a.f61614c.length == f61605a.f61615d.length && f61605a.f61614c != null && f61605a.f61614c.length > 0) {
                for (int i2 = 0; i2 < f61605a.f61614c.length; i2++) {
                    if (str.equals(f61605a.f61614c[i2])) {
                        return f61605a.f61615d[i2];
                    }
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }
}
