package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class b implements e {
    private final HashMap<String, f> kDL;

    private b() {
        this.kDL = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0838b {
        private static b mty = new b();
    }

    public static b dzP() {
        return C0838b.mty;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a QM = a.QM(str);
            f fVar = this.kDL.get(QM.getKey());
            if (fVar != null && QM.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    QM.getParams().putAll(hashMap);
                }
                fVar.a(obj, QM.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kDL.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes25.dex */
    public static class a {
        HashMap<String, String> eKR;
        private boolean ezK;
        String key;

        public boolean isValid() {
            return this.ezK;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eKR;
        }

        private a(String str) {
            this.ezK = false;
            Uri parse = Uri.parse(str);
            this.ezK = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.ezK) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eKR = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eKR.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eKR = new HashMap<>();
        }

        public static a QM(String str) {
            return new a(str);
        }
    }
}
