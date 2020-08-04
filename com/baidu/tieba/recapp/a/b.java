package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes20.dex */
public class b implements e {
    private final HashMap<String, f> jxK;

    private b() {
        this.jxK = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static class C0738b {
        private static b llP = new b();
    }

    public static b dcb() {
        return C0738b.llP;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Mo = a.Mo(str);
            f fVar = this.jxK.get(Mo.getKey());
            if (fVar != null && Mo.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Mo.getParams().putAll(hashMap);
                }
                fVar.a(obj, Mo.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.jxK.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes20.dex */
    public static class a {
        private boolean dPr;
        HashMap<String, String> dZx;
        String key;

        public boolean isValid() {
            return this.dPr;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.dZx;
        }

        private a(String str) {
            this.dPr = false;
            Uri parse = Uri.parse(str);
            this.dPr = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.dPr) {
                this.key = parse.getAuthority() + parse.getPath();
                this.dZx = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.dZx.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.dZx = new HashMap<>();
        }

        public static a Mo(String str) {
            return new a(str);
        }
    }
}
