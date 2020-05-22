package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> iXh;

    private b() {
        this.iXh = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0711b {
        private static b kJx = new b();
    }

    public static b cUn() {
        return C0711b.kJx;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Le = a.Le(str);
            f fVar = this.iXh.get(Le.getKey());
            if (fVar != null && Le.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Le.getParams().putAll(hashMap);
                }
                fVar.a(obj, Le.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.iXh.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean dCL;
        HashMap<String, String> iXi;
        String key;

        public boolean isValid() {
            return this.dCL;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.iXi;
        }

        private a(String str) {
            this.dCL = false;
            Uri parse = Uri.parse(str);
            this.dCL = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.dCL) {
                this.key = parse.getAuthority() + parse.getPath();
                this.iXi = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.iXi.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.iXi = new HashMap<>();
        }

        public static a Le(String str) {
            return new a(str);
        }
    }
}
