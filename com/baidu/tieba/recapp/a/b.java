package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eOq;

    private b() {
        this.eOq = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0225b {
        private static b goo = new b();
    }

    public static b bno() {
        return C0225b.goo;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a sF = a.sF(str);
            f fVar = this.eOq.get(sF.getKey());
            if (fVar != null && sF.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    sF.getParams().putAll(hashMap);
                }
                fVar.a(obj, sF.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eOq.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.rs(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean agc;
        HashMap<String, String> eOr;
        String key;

        public boolean isValid() {
            return this.agc;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eOr;
        }

        private a(String str) {
            this.agc = false;
            Uri parse = Uri.parse(str);
            this.agc = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.agc) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eOr = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eOr.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eOr = new HashMap<>();
        }

        public static a sF(String str) {
            return new a(str);
        }
    }
}
