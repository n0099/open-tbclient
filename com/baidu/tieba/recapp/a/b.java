package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> hcO;

    private b() {
        this.hcO = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0394b {
        private static b iFR = new b();
    }

    public static b chE() {
        return C0394b.iFR;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a DE = a.DE(str);
            f fVar = this.hcO.get(DE.getKey());
            if (fVar != null && DE.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    DE.getParams().putAll(hashMap);
                }
                fVar.a(obj, DE.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hcO.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bHv;
        HashMap<String, String> hcP;
        String key;

        public boolean isValid() {
            return this.bHv;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hcP;
        }

        private a(String str) {
            this.bHv = false;
            Uri parse = Uri.parse(str);
            this.bHv = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bHv) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hcP = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hcP.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hcP = new HashMap<>();
        }

        public static a DE(String str) {
            return new a(str);
        }
    }
}
