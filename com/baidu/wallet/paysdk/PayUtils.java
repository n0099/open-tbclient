package com.baidu.wallet.paysdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
@SuppressLint({"UseSparseArrays"})
/* loaded from: classes2.dex */
public final class PayUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";
    public static String a = "PayUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f52064b = "";

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f52065c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a implements Comparator<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) ? str.compareTo(str2) : invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1680830877, "Lcom/baidu/wallet/paysdk/PayUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1680830877, "Lcom/baidu/wallet/paysdk/PayUtils;");
                return;
            }
        }
        ArrayList<String> arrayList = new ArrayList<>();
        f52065c = arrayList;
        arrayList.add("card_no");
        f52065c.add("valid_date");
        f52065c.add("cvv2");
        f52065c.add("identity_code");
        f52065c.add("phone_number");
    }

    public PayUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            Collections.sort(list, new a());
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : list) {
                stringBuffer.append(str);
                stringBuffer.append("&");
            }
            stringBuffer.append("key=");
            stringBuffer.append("");
            return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
        }
        return (String) invokeL.objValue;
    }

    public static String encrypt(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            LogUtil.d(str + "加密=" + str2);
            if (f52065c.contains(str)) {
                if (TextUtils.isEmpty(str2)) {
                    return "";
                }
                String encryptProxy = SafePay.getInstance().encryptProxy(str2);
                LogUtil.d(str + "加密=" + encryptProxy);
                return encryptProxy;
            }
            return str2;
        }
        return (String) invokeLL.objValue;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (RestNameValuePair restNameValuePair : list) {
                arrayList.add(restNameValuePair.getName() + "=" + restNameValuePair.getValue());
            }
            return a(arrayList);
        }
        return (String) invokeL.objValue;
    }

    public static String getNewCookie(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            Map<String, String> loginData = AccountManager.getInstance(context).getLoginData();
            if (loginData == null) {
                return "";
            }
            String str = loginData.get("pass_open_bduss");
            String str2 = TextUtils.isEmpty(str) ? "" : str;
            if (AccountManager.getInstance(context).getLoginType() == 0) {
                sb.append("OPENBDUSS=");
                sb.append(str2);
            } else if (AccountManager.getInstance(context).getLoginType() == 1) {
                sb.append("access_token=");
                sb.append(str2);
            }
            String str3 = loginData.get("pass_stoken");
            if (!TextUtils.isEmpty(str3)) {
                sb.append(";stoken=");
                sb.append(str3);
                if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getTpl())) {
                    sb.append(";tpl=");
                    sb.append(WalletLoginHelper.getInstance().getTpl());
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getNonce(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            ArrayList arrayList = new ArrayList(list);
            Collections.sort(arrayList, new Comparator<RestNameValuePair>() { // from class: com.baidu.wallet.paysdk.PayUtils.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                /* renamed from: a */
                public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, restNameValuePair, restNameValuePair2)) == null) ? restNameValuePair.getName().compareTo(restNameValuePair2.getName()) : invokeLL.intValue;
                }
            });
            String list2String = list2String(arrayList);
            return !TextUtils.isEmpty(list2String) ? encrypt("phone_number", Md5Utils.toMD5(list2String, "UTF-8")) : "";
        }
        return (String) invokeL.objValue;
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, map, str)) == null) ? (map == null || map.size() == 0) ? "" : a(mapToList(map), str) : (String) invokeLL.objValue;
    }

    public static String list2String(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, list)) == null) {
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : list) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    sb.append(name);
                    sb.append(com.alipay.sdk.encrypt.a.f31099h);
                    sb.append(value);
                    sb.append(Typography.amp);
                }
            }
            if (sb.length() > 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static List<String> mapToList(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, map)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                StringBuilder sb = new StringBuilder();
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(TextUtils.isEmpty(entry.getValue()) ? "" : entry.getValue());
                arrayList.add(sb.toString());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static String a(List<String> list, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, str)) == null) {
            Collections.sort(list, new a());
            StringBuffer stringBuffer = new StringBuffer();
            for (String str2 : list) {
                stringBuffer.append(str2);
                stringBuffer.append("&");
            }
            stringBuffer.append("key=");
            stringBuffer.append(str);
            return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
        }
        return (String) invokeLL.objValue;
    }
}
