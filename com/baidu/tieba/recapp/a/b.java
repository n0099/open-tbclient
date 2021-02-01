package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements e {
    private final HashMap<String, f> lah;

    private b() {
        this.lah = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0855b {
        private static b mRz = new b();
    }

    public static b dDo() {
        return C0855b.mRz;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, com.baidu.adp.base.e eVar) {
        if (str != null) {
            a Ro = a.Ro(str);
            f fVar = this.lah.get(Ro.getKey());
            if (fVar != null && Ro.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Ro.getParams().putAll(hashMap);
                }
                fVar.a(obj, Ro.getParams(), str, eVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.lah.put(str, fVar);
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

        public static a Ro(String str) {
            return new a(str);
        }
    }
}
