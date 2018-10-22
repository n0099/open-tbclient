package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> fdo;

    private b() {
        this.fdo = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0266b {
        private static b gDl = new b();
    }

    public static b btl() {
        return C0266b.gDl;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a tS = a.tS(str);
            f fVar = this.fdo.get(tS.getKey());
            if (fVar != null && tS.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    tS.getParams().putAll(hashMap);
                }
                fVar.a(obj, tS.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.fdo.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean any;
        HashMap<String, String> fdp;
        String key;

        public boolean isValid() {
            return this.any;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.fdp;
        }

        private a(String str) {
            this.any = false;
            Uri parse = Uri.parse(str);
            this.any = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.any) {
                this.key = parse.getAuthority() + parse.getPath();
                this.fdp = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.fdp.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.fdp = new HashMap<>();
        }

        public static a tS(String str) {
            return new a(str);
        }
    }
}
