package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> evp;

    private b() {
        this.evp = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0206b {
        private static b fXU = new b();
    }

    public static b bjl() {
        return C0206b.fXU;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a rT = a.rT(str);
            f fVar = this.evp.get(rT.getKey());
            if (fVar != null && rT.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    rT.aKr().putAll(hashMap);
                }
                fVar.a(obj, rT.aKr(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.evp.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean Ys;
        HashMap<String, String> evq;
        String key;

        public boolean isValid() {
            return this.Ys;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> aKr() {
            return this.evq;
        }

        private a(String str) {
            this.Ys = false;
            Uri parse = Uri.parse(str);
            this.Ys = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.Ys) {
                this.key = parse.getAuthority() + parse.getPath();
                this.evq = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.evq.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.evq = new HashMap<>();
        }

        public static a rT(String str) {
            return new a(str);
        }
    }
}
