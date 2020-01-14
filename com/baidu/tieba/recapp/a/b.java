package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b implements e {
    private final HashMap<String, f> hUA;

    private b() {
        this.hUA = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0588b {
        private static b jFk = new b();
    }

    public static b cAY() {
        return C0588b.jFk;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Hw = a.Hw(str);
            f fVar = this.hUA.get(Hw.getKey());
            if (fVar != null && Hw.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Hw.getParams().putAll(hashMap);
                }
                fVar.a(obj, Hw.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.hUA.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes11.dex */
    public static class a {
        private boolean cLk;
        HashMap<String, String> hUB;
        String key;

        public boolean isValid() {
            return this.cLk;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.hUB;
        }

        private a(String str) {
            this.cLk = false;
            Uri parse = Uri.parse(str);
            this.cLk = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.cLk) {
                this.key = parse.getAuthority() + parse.getPath();
                this.hUB = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.hUB.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.hUB = new HashMap<>();
        }

        public static a Hw(String str) {
            return new a(str);
        }
    }
}
