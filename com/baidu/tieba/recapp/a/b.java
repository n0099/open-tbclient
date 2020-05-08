package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> iIh;

    private b() {
        this.iIh = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0658b {
        private static b krD = new b();
    }

    public static b cNm() {
        return C0658b.krD;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Js = a.Js(str);
            f fVar = this.iIh.get(Js.getKey());
            if (fVar != null && Js.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Js.getParams().putAll(hashMap);
                }
                fVar.a(obj, Js.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.iIh.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean doM;
        HashMap<String, String> iIi;
        String key;

        public boolean isValid() {
            return this.doM;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.iIi;
        }

        private a(String str) {
            this.doM = false;
            Uri parse = Uri.parse(str);
            this.doM = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.doM) {
                this.key = parse.getAuthority() + parse.getPath();
                this.iIi = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.iIi.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.iIi = new HashMap<>();
        }

        public static a Js(String str) {
            return new a(str);
        }
    }
}
