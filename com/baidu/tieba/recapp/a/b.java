package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements e {
    private final HashMap<String, f> lcz;

    private b() {
        this.lcz = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static class C0862b {
        private static b mTX = new b();
    }

    public static b dDD() {
        return C0862b.mTX;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a RE = a.RE(str);
            f fVar = this.lcz.get(RE.getKey());
            if (fVar != null && RE.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    RE.getParams().putAll(hashMap);
                }
                fVar.a(obj, RE.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.lcz.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes7.dex */
    public static class a {
        HashMap<String, String> fbf;
        private boolean isValid;
        String key;

        public boolean isValid() {
            return this.isValid;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.fbf;
        }

        private a(String str) {
            this.isValid = false;
            Uri parse = Uri.parse(str);
            this.isValid = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.isValid) {
                this.key = parse.getAuthority() + parse.getPath();
                this.fbf = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.fbf.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.fbf = new HashMap<>();
        }

        public static a RE(String str) {
            return new a(str);
        }
    }
}
