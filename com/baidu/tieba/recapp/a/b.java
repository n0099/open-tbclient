package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes26.dex */
public class b implements e {
    private final HashMap<String, f> kle;

    private b() {
        this.kle = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C0805b {
        private static b maM = new b();
    }

    public static b duG() {
        return C0805b.maM;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a QC = a.QC(str);
            f fVar = this.kle.get(QC.getKey());
            if (fVar != null && QC.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    QC.getParams().putAll(hashMap);
                }
                fVar.a(obj, QC.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.kle.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes26.dex */
    public static class a {
        private boolean ena;
        HashMap<String, String> exF;
        String key;

        public boolean isValid() {
            return this.ena;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.exF;
        }

        private a(String str) {
            this.ena = false;
            Uri parse = Uri.parse(str);
            this.ena = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.ena) {
                this.key = parse.getAuthority() + parse.getPath();
                this.exF = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.exF.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.exF = new HashMap<>();
        }

        public static a QC(String str) {
            return new a(str);
        }
    }
}
