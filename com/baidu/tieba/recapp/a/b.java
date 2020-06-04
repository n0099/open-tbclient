package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> iXU;

    private b() {
        this.iXU = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0712b {
        private static b kKF = new b();
    }

    public static b cUD() {
        return C0712b.kKF;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Lf = a.Lf(str);
            f fVar = this.iXU.get(Lf.getKey());
            if (fVar != null && Lf.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Lf.getParams().putAll(hashMap);
                }
                fVar.a(obj, Lf.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.iXU.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean dCL;
        HashMap<String, String> iXV;
        String key;

        public boolean isValid() {
            return this.dCL;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.iXV;
        }

        private a(String str) {
            this.dCL = false;
            Uri parse = Uri.parse(str);
            this.dCL = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.dCL) {
                this.key = parse.getAuthority() + parse.getPath();
                this.iXV = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.iXV.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.iXV = new HashMap<>();
        }

        public static a Lf(String str) {
            return new a(str);
        }
    }
}
