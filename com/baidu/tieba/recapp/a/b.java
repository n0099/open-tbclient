package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> jpe;

    private b() {
        this.jpe = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0728b {
        private static b leA = new b();
    }

    public static b cYT() {
        return C0728b.leA;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a LG = a.LG(str);
            f fVar = this.jpe.get(LG.getKey());
            if (fVar != null && LG.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    LG.getParams().putAll(hashMap);
                }
                fVar.a(obj, LG.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.jpe.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean dJg;
        HashMap<String, String> jpf;
        String key;

        public boolean isValid() {
            return this.dJg;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.jpf;
        }

        private a(String str) {
            this.dJg = false;
            Uri parse = Uri.parse(str);
            this.dJg = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.dJg) {
                this.key = parse.getAuthority() + parse.getPath();
                this.jpf = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.jpf.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.jpf = new HashMap<>();
        }

        public static a LG(String str) {
            return new a(str);
        }
    }
}
