package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> hWM;

    private b() {
        this.hWM = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0596b {
        private static b jGp = new b();
    }

    public static b cCx() {
        return C0596b.jGp;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a HL = a.HL(str);
            f fVar = this.hWM.get(HL.getKey());
            if (fVar != null && HL.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    HL.getParams().putAll(hashMap);
                }
                fVar.a(obj, HL.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hWM.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean cPp;
        HashMap<String, String> hWN;
        String key;

        public boolean isValid() {
            return this.cPp;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hWN;
        }

        private a(String str) {
            this.cPp = false;
            Uri parse = Uri.parse(str);
            this.cPp = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.cPp) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hWN = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hWN.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hWN = new HashMap<>();
        }

        public static a HL(String str) {
            return new a(str);
        }
    }
}
