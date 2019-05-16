package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> gWz;

    private b() {
        this.gWz = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0395b {
        private static b izw = new b();
    }

    public static b ceK() {
        return C0395b.izw;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a CP = a.CP(str);
            f fVar = this.gWz.get(CP.getKey());
            if (fVar != null && CP.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    CP.getParams().putAll(hashMap);
                }
                fVar.a(obj, CP.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gWz.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bGu;
        HashMap<String, String> gWA;
        String key;

        public boolean isValid() {
            return this.bGu;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gWA;
        }

        private a(String str) {
            this.bGu = false;
            Uri parse = Uri.parse(str);
            this.bGu = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bGu) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gWA = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gWA.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gWA = new HashMap<>();
        }

        public static a CP(String str) {
            return new a(str);
        }
    }
}
