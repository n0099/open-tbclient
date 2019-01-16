package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> fpl;

    private b() {
        this.fpl = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0305b {
        private static b gPx = new b();
    }

    public static b bvU() {
        return C0305b.gPx;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a uQ = a.uQ(str);
            f fVar = this.fpl.get(uQ.getKey());
            if (fVar != null && uQ.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    uQ.getParams().putAll(hashMap);
                }
                fVar.a(obj, uQ.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.fpl.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean aso;
        String key;
        HashMap<String, String> params;

        public boolean isValid() {
            return this.aso;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.params;
        }

        private a(String str) {
            this.aso = false;
            Uri parse = Uri.parse(str);
            this.aso = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.aso) {
                this.key = parse.getAuthority() + parse.getPath();
                this.params = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.params.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.params = new HashMap<>();
        }

        public static a uQ(String str) {
            return new a(str);
        }
    }
}
