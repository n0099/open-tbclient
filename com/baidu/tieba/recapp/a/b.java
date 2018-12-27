package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {

    /* renamed from: for  reason: not valid java name */
    private final HashMap<String, f> f0for;

    private b() {
        this.f0for = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0305b {
        private static b gOt = new b();
    }

    public static b bvl() {
        return C0305b.gOt;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a uA = a.uA(str);
            f fVar = this.f0for.get(uA.getKey());
            if (fVar != null && uA.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    uA.getParams().putAll(hashMap);
                }
                fVar.a(obj, uA.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.f0for.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean arM;
        String key;
        HashMap<String, String> params;

        public boolean isValid() {
            return this.arM;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.params;
        }

        private a(String str) {
            this.arM = false;
            Uri parse = Uri.parse(str);
            this.arM = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.arM) {
                this.key = parse.getAuthority() + parse.getPath();
                this.params = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.params.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.params = new HashMap<>();
        }

        public static a uA(String str) {
            return new a(str);
        }
    }
}
