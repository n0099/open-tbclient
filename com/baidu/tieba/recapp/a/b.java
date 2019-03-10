package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> gFr;

    private b() {
        this.gFr = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0300b {
        private static b ihd = new b();
    }

    public static b bWI() {
        return C0300b.ihd;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Bw = a.Bw(str);
            f fVar = this.gFr.get(Bw.getKey());
            if (fVar != null && Bw.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Bw.getParams().putAll(hashMap);
                }
                fVar.a(obj, Bw.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gFr.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bzd;
        HashMap<String, String> gFs;
        String key;

        public boolean isValid() {
            return this.bzd;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gFs;
        }

        private a(String str) {
            this.bzd = false;
            Uri parse = Uri.parse(str);
            this.bzd = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bzd) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gFs = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gFs.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gFs = new HashMap<>();
        }

        public static a Bw(String str) {
            return new a(str);
        }
    }
}
