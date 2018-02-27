package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.a.e;
import com.baidu.tbadk.a.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> eZn;

    private b() {
        this.eZn = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0224b {
        private static b gBO = new b();
    }

    public static b bof() {
        return C0224b.gBO;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a rK = a.rK(str);
            f fVar = this.eZn.get(rK.getKey());
            if (fVar != null && rK.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    rK.aPq().putAll(hashMap);
                }
                fVar.a(obj, rK.aPq(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.eZn.put(str, fVar);
    }

    public void a(com.baidu.tbadk.a.a aVar) {
        a(aVar.vG(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean aMP;
        HashMap<String, String> eZo;
        String key;

        public boolean isValid() {
            return this.aMP;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> aPq() {
            return this.eZo;
        }

        private a(String str) {
            this.aMP = false;
            Uri parse = Uri.parse(str);
            this.aMP = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.aMP) {
                this.key = parse.getAuthority() + parse.getPath();
                this.eZo = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.eZo.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.eZo = new HashMap<>();
        }

        public static a rK(String str) {
            return new a(str);
        }
    }
}
