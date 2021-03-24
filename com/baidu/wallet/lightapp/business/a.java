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
    public static C0254a f25093a = new C0254a();

    /* renamed from: com.baidu.wallet.lightapp.business.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0254a {

        /* renamed from: a  reason: collision with root package name */
        public String f25100a;

        /* renamed from: b  reason: collision with root package name */
        public HashMap f25101b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f25102c;

        /* renamed from: d  reason: collision with root package name */
        public String[] f25103d;

        public String toString() {
            return "hookUrl=" + this.f25100a + "\n\ttoAddKeyVauleMap=" + this.f25101b.toString() + "\n\ttoAddJsFilesName=" + Arrays.toString(this.f25102c) + "\n\ttoAddJsFilesContent=" + Arrays.toString(this.f25103d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, HashMap hashMap, String[] strArr, String[] strArr2) {
            this.f25100a = str;
            this.f25101b = hashMap;
            this.f25102c = strArr;
            this.f25103d = strArr2;
            LogUtil.d("WebViewCacheManager", "updateImpact\n" + toString());
        }
    }

    public static void a(final Context context, final String str, String[] strArr, final String[] strArr2) {
        LogUtil.d("WebViewCacheManager", "findConfigImpactJsFiles hookUrl=" + str + "; targetConfig=" + Arrays.toString(strArr) + " ; targetKeys=" + Arrays.toString(strArr2));
        if (!TextUtils.isEmpty(str) && !str.equals(f25093a.f25100a)) {
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
                                    C0254a c0254a = a.f25093a;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    c0254a.a(str, hashMap, strArr6, strArr7);
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
        if (TextUtils.isEmpty(str) || f25093a.f25101b == null || f25093a.f25101b.size() <= 0) {
            return null;
        }
        return (String[]) f25093a.f25101b.get(str);
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && f25093a.f25102c != null && f25093a.f25103d != null && f25093a.f25102c.length == f25093a.f25103d.length && f25093a.f25102c != null && f25093a.f25102c.length > 0) {
            for (int i = 0; i < f25093a.f25102c.length; i++) {
                if (str.equals(f25093a.f25102c[i])) {
                    return f25093a.f25103d[i];
                }
            }
        }
        return null;
    }
}
