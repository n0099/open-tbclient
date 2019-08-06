package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> hdG;

    private b() {
        this.hdG = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0400b {
        private static b iGV = new b();
    }

    public static b chW() {
        return C0400b.iGV;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a DF = a.DF(str);
            f fVar = this.hdG.get(DF.getKey());
            if (fVar != null && DF.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    DF.getParams().putAll(hashMap);
                }
                fVar.a(obj, DF.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hdG.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bHw;
        HashMap<String, String> hdH;
        String key;

        public boolean isValid() {
            return this.bHw;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hdH;
        }

        private a(String str) {
            this.bHw = false;
            Uri parse = Uri.parse(str);
            this.bHw = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bHw) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hdH = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hdH.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hdH = new HashMap<>();
        }

        public static a DF(String str) {
            return new a(str);
        }
    }
}
