package com.baidu.wallet.paysdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes6.dex */
public final class PayUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";

    /* renamed from: a  reason: collision with root package name */
    public static String f25730a = "PayUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f25731b = "";

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f25732c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
        f25732c = arrayList;
        arrayList.add("card_no");
        f25732c.add("valid_date");
        f25732c.add("cvv2");
        f25732c.add("identity_code");
        f25732c.add("phone_number");
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) {
            LogUtil.d(str + "加密=" + str2);
            if (f25732c.contains(str)) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (RestNameValuePair restNameValuePair : list) {
                arrayList.add(restNameValuePair.getName() + "=" + restNameValuePair.getValue());
            }
            return a(arrayList);
        }
        return (String) invokeL.objValue;
    }

    public static String getCookie(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (AccountManager.getInstance(context).getLoginType() == 0) {
                stringBuffer.append("BDUSS=" + AccountManager.getInstance(context).getBduss());
            } else if (AccountManager.getInstance(context).getLoginType() == 1) {
                stringBuffer.append("access_token=" + AccountManager.getInstance(context).getBduss());
            }
            String loginStoken = WalletLoginHelper.getInstance().getLoginStoken();
            if (!TextUtils.isEmpty(loginStoken)) {
                stringBuffer.append(";stoken=" + loginStoken);
                if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getTpl())) {
                    stringBuffer.append(";tpl=" + WalletLoginHelper.getInstance().getTpl());
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String getNewCookie(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            StringBuilder sb = new StringBuilder();
            Map<String, String> loginData = AccountManager.getInstance(context).getLoginData();
            String str = loginData.get("pass_open_bduss");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (AccountManager.getInstance(context).getLoginType() == 0) {
                sb.append("OPENBDUSS=");
                sb.append(str);
            } else if (AccountManager.getInstance(context).getLoginType() == 1) {
                sb.append("access_token=");
                sb.append(str);
            }
            String str2 = loginData.get("pass_stoken");
            if (!TextUtils.isEmpty(str2)) {
                sb.append(";stoken=");
                sb.append(str2);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, map, str)) == null) ? (map == null || map.size() == 0) ? "" : a(mapToList(map), str) : (String) invokeLL.objValue;
    }

    public static String list2String(List<RestNameValuePair> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, list)) == null) {
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
                    sb.append(com.alipay.sdk.encrypt.a.f1889h);
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, map)) == null) {
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
