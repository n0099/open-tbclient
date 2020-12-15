package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class b implements e {
    private final HashMap<String, f> kRf;

    private b() {
        this.kRf = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0853b {
        private static b mHH = new b();
    }

    public static b dFh() {
        return C0853b.mHH;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a RV = a.RV(str);
            f fVar = this.kRf.get(RV.getKey());
            if (fVar != null && RV.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    RV.getParams().putAll(hashMap);
                }
                fVar.a(obj, RV.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kRf.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes26.dex */
    public static class a {
        private boolean eGJ;
        HashMap<String, String> eSd;
        String key;

        public boolean isValid() {
            return this.eGJ;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eSd;
        }

        private a(String str) {
            this.eGJ = false;
            Uri parse = Uri.parse(str);
            this.eGJ = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.eGJ) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eSd = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eSd.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eSd = new HashMap<>();
        }

        public static a RV(String str) {
            return new a(str);
        }
    }
}
