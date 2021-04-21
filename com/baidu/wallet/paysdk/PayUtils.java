package com.baidu.wallet.paysdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.Md5Utils;
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
/* loaded from: classes5.dex */
public final class PayUtils {
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";

    /* renamed from: a  reason: collision with root package name */
    public static String f25061a = "PayUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f25062b = "";

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList<String> f25063c;

    /* loaded from: classes5.dex */
    public static class a implements Comparator<String> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        f25063c = arrayList;
        arrayList.add("card_no");
        f25063c.add("valid_date");
        f25063c.add("cvv2");
        f25063c.add("identity_code");
        f25063c.add("phone_number");
    }

    public static String a(List<String> list) {
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

    public static String encrypt(String str, String str2) {
        LogUtil.d(str + "加密=" + str2);
        if (f25063c.contains(str)) {
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            String encryptProxy = SafePay.getInstance().encryptProxy(str2);
            LogUtil.d(str + "加密=" + encryptProxy);
            return encryptProxy;
        }
        return str2;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList();
        for (RestNameValuePair restNameValuePair : list) {
            arrayList.add(restNameValuePair.getName() + "=" + restNameValuePair.getValue());
        }
        return a(arrayList);
    }

    public static String getCookie(Context context) {
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

    public static String getNewCookie(Context context) {
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

    public static String getNonce(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator<RestNameValuePair>() { // from class: com.baidu.wallet.paysdk.PayUtils.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
            }
        });
        String list2String = list2String(arrayList);
        return !TextUtils.isEmpty(list2String) ? encrypt("phone_number", Md5Utils.toMD5(list2String, "UTF-8")) : "";
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        return (map == null || map.size() == 0) ? "" : a(mapToList(map), str);
    }

    public static String list2String(List<RestNameValuePair> list) {
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
                sb.append(com.alipay.sdk.encrypt.a.f1922h);
                sb.append(value);
                sb.append(Typography.amp);
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public static List<String> mapToList(Map<String, String> map) {
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

    public static String a(List<String> list, String str) {
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
}
