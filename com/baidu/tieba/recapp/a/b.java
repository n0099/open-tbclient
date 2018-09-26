package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eVG;

    private b() {
        this.eVG = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0231b {
        private static b gvJ = new b();
    }

    public static b bpW() {
        return C0231b.gvJ;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a tq = a.tq(str);
            f fVar = this.eVG.get(tq.getKey());
            if (fVar != null && tq.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    tq.getParams().putAll(hashMap);
                }
                fVar.a(obj, tq.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eVG.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.sw(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean aiD;
        HashMap<String, String> eVH;
        String key;

        public boolean isValid() {
            return this.aiD;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eVH;
        }

        private a(String str) {
            this.aiD = false;
            Uri parse = Uri.parse(str);
            this.aiD = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.aiD) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eVH = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eVH.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eVH = new HashMap<>();
        }

        public static a tq(String str) {
            return new a(str);
        }
    }
}
