package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eZB;

    private b() {
        this.eZB = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0224b {
        private static b gCe = new b();
    }

    public static b bog() {
        return C0224b.gCe;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a rK = a.rK(str);
            f fVar = this.eZB.get(rK.getKey());
            if (fVar != null && rK.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    rK.aPr().putAll(hashMap);
                }
                fVar.a(obj, rK.aPr(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eZB.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.vG(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean aMQ;
        HashMap<String, String> eZC;
        String key;

        public boolean isValid() {
            return this.aMQ;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> aPr() {
            return this.eZC;
        }

        private a(String str) {
            this.aMQ = false;
            Uri parse = Uri.parse(str);
            this.aMQ = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.aMQ) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eZC = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eZC.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eZC = new HashMap<>();
        }

        public static a rK(String str) {
            return new a(str);
        }
    }
}
