package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements e {
    private final HashMap<String, f> kSf;

    private b() {
        this.kSf = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0852b {
        private static b mIo = new b();
    }

    public static b dBf() {
        return C0852b.mIo;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a Qs = a.Qs(str);
            f fVar = this.kSf.get(Qs.getKey());
            if (fVar != null && Qs.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Qs.getParams().putAll(hashMap);
                }
                fVar.a(obj, Qs.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kSf.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes7.dex */
    public static class a {
        private boolean eLO;
        HashMap<String, String> eXq;
        String key;

        public boolean isValid() {
            return this.eLO;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eXq;
        }

        private a(String str) {
            this.eLO = false;
            Uri parse = Uri.parse(str);
            this.eLO = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.eLO) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eXq = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eXq.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eXq = new HashMap<>();
        }

        public static a Qs(String str) {
            return new a(str);
        }
    }
}
