package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements e {
    private final HashMap<String, f> law;

    private b() {
        this.law = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0856b {
        private static b mRR = new b();
    }

    public static b dDv() {
        return C0856b.mRR;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a Ry = a.Ry(str);
            f fVar = this.law.get(Ry.getKey());
            if (fVar != null && Ry.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Ry.getParams().putAll(hashMap);
                }
                fVar.a(obj, Ry.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.law.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes8.dex */
    public static class a {
        HashMap<String, String> eZG;
        private boolean isValid;
        String key;

        public boolean isValid() {
            return this.isValid;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.eZG;
        }

        private a(String str) {
            this.isValid = false;
            Uri parse = Uri.parse(str);
            this.isValid = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.isValid) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eZG = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eZG.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eZG = new HashMap<>();
        }

        public static a Ry(String str) {
            return new a(str);
        }
    }
}
