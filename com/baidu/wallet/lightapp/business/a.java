package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.business.c;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static C0255a f25094a = new C0255a();

    /* renamed from: com.baidu.wallet.lightapp.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0255a {

        /* renamed from: a  reason: collision with root package name */
        public String f25101a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap f25102b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f25103c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f25104d;

        public String toString() {
            return "hookUrl=" + this.f25101a + "\n\ttoAddKeyVauleMap=" + this.f25102b.toString() + "\n\ttoAddJsFilesName=" + Arrays.toString(this.f25103c) + "\n\ttoAddJsFilesContent=" + Arrays.toString(this.f25104d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, HashMap hashMap, String[] strArr, String[] strArr2) {
            this.f25101a = str;
            this.f25102b = hashMap;
            this.f25103c = strArr;
            this.f25104d = strArr2;
            LogUtil.d("WebViewCacheManager", "updateImpact\n" + toString());
        }
    }

    public static void a(final Context context, final String str, String[] strArr, final String[] strArr2) {
        LogUtil.d("WebViewCacheManager", "findConfigImpactJsFiles hookUrl=" + str + "; targetConfig=" + Arrays.toString(strArr) + " ; targetKeys=" + Arrays.toString(strArr2));
        if (!TextUtils.isEmpty(str) && !str.equals(f25094a.f25101a)) {
            if (strArr == null || strArr.length <= 0 || strArr2 == null || strArr2.length <= 0) {
                return;
            }
            final HashMap hashMap = new HashMap();
            c.a(str, context, strArr, new c.a() { // from class: com.baidu.wallet.lightapp.business.a.1
                @Override // com.baidu.wallet.lightapp.business.c.a
                public void a(String[] strArr3) {
                    String[] strArr4;
                    LogUtil.d("WebViewCacheManager", "onLoadComplete files.length=" + strArr3.length + "\tconfigFiles:" + Arrays.toString(strArr3));
                    if (strArr3 == null || strArr3.length == 0) {
                        return;
                    }
                    HashSet hashSet = new HashSet();
                    for (String str2 : strArr2) {
                        if (!TextUtils.isEmpty(str2)) {
                            for (String str3 : strArr3) {
                                if (!TextUtils.isEmpty(str3)) {
                                    try {
                                        JSONArray optJSONArray = new JSONObject(str3).optJSONArray(str2);
                                        if (optJSONArray != null && optJSONArray.length() > 0) {
                                            int length = optJSONArray.length();
                                            String[] strArr5 = new String[length];
                                            for (int i = 0; i < optJSONArray.length(); i++) {
                                                strArr5[i] = String.valueOf(optJSONArray.get(i));
                                            }
                                            if (length > 0) {
                                                hashMap.put(str2, strArr5);
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
                        final String[] strArr6 = new String[size];
                        hashSet.toArray(strArr6);
                        if (size > 0) {
                            c.a(SdkInitResponse.getInstance().getJsHookURl(context), context, strArr6, new c.a() { // from class: com.baidu.wallet.lightapp.business.a.1.1
                                @Override // com.baidu.wallet.lightapp.business.c.a
                                public void a(String[] strArr7) {
                                    if (strArr7 == null && strArr7.length == 0) {
                                        LogUtil.d("WebViewCacheManager", "获取到的js文件为空");
                                        return;
                                    }
                                    LogUtil.d("WebViewCacheManager", "成功获取到js文件");
                                    C0255a c0255a = a.f25094a;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c0255a.a(str, hashMap, strArr6, strArr7);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        LogUtil.d("WebViewCacheManager", "findConfigImpactJsFiles 已下载过" + str);
    }

    public static String[] b(String str) {
        if (TextUtils.isEmpty(str) || f25094a.f25102b == null || f25094a.f25102b.size() <= 0) {
            return null;
        }
        return (String[]) f25094a.f25102b.get(str);
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && f25094a.f25103c != null && f25094a.f25104d != null && f25094a.f25103c.length == f25094a.f25104d.length && f25094a.f25103c != null && f25094a.f25103c.length > 0) {
            for (int i = 0; i < f25094a.f25103c.length; i++) {
                if (str.equals(f25094a.f25103c[i])) {
                    return f25094a.f25104d[i];
                }
            }
        }
        return null;
    }
}
