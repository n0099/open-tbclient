package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eGG;

    private b() {
        this.eGG = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0223b {
        private static b gjm = new b();
    }

    public static b bok() {
        return C0223b.gjm;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a sL = a.sL(str);
            f fVar = this.eGG.get(sL.getKey());
            if (fVar != null && sL.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    sL.getParams().putAll(hashMap);
                }
                fVar.a(obj, sL.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eGG.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean agu;
        HashMap<String, String> eGH;
        String key;

        public boolean isValid() {
            return this.agu;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eGH;
        }

        private a(String str) {
            this.agu = false;
            Uri parse = Uri.parse(str);
            this.agu = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.agu) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eGH = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eGH.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eGH = new HashMap<>();
        }

        public static a sL(String str) {
            return new a(str);
        }
    }
}
