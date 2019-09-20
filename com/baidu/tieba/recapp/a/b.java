package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> hfA;

    private b() {
        this.hfA = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0411b {
        private static b iJm = new b();
    }

    public static b ciK() {
        return C0411b.iJm;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Ee = a.Ee(str);
            f fVar = this.hfA.get(Ee.getKey());
            if (fVar != null && Ee.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Ee.getParams().putAll(hashMap);
                }
                fVar.a(obj, Ee.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hfA.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bHU;
        HashMap<String, String> hfB;
        String key;

        public boolean isValid() {
            return this.bHU;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hfB;
        }

        private a(String str) {
            this.bHU = false;
            Uri parse = Uri.parse(str);
            this.bHU = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bHU) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hfB = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hfB.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hfB = new HashMap<>();
        }

        public static a Ee(String str) {
            return new a(str);
        }
    }
}
