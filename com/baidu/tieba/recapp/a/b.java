package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class b implements e {
    private final HashMap<String, f> kDw;

    private b() {
        this.kDw = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0835b {
        private static b mti = new b();
    }

    public static b dAp() {
        return C0835b.mti;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Rr = a.Rr(str);
            f fVar = this.kDw.get(Rr.getKey());
            if (fVar != null && Rr.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Rr.getParams().putAll(hashMap);
                }
                fVar.a(obj, Rr.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kDw.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes26.dex */
    public static class a {
        private boolean eBt;
        HashMap<String, String> eLS;
        String key;

        public boolean isValid() {
            return this.eBt;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eLS;
        }

        private a(String str) {
            this.eBt = false;
            Uri parse = Uri.parse(str);
            this.eBt = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.eBt) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eLS = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eLS.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eLS = new HashMap<>();
        }

        public static a Rr(String str) {
            return new a(str);
        }
    }
}
