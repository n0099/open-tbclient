package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> gWC;

    private b() {
        this.gWC = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0395b {
        private static b izy = new b();
    }

    public static b ceM() {
        return C0395b.izy;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a CP = a.CP(str);
            f fVar = this.gWC.get(CP.getKey());
            if (fVar != null && CP.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    CP.getParams().putAll(hashMap);
                }
                fVar.a(obj, CP.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gWC.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bGu;
        HashMap<String, String> gWD;
        String key;

        public boolean isValid() {
            return this.bGu;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gWD;
        }

        private a(String str) {
            this.bGu = false;
            Uri parse = Uri.parse(str);
            this.bGu = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bGu) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gWD = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gWD.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gWD = new HashMap<>();
        }

        public static a CP(String str) {
            return new a(str);
        }
    }
}
