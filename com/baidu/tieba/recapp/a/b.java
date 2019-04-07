package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements e {
    private final HashMap<String, f> gFe;

    private b() {
        this.gFe = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0376b {
        private static b igJ = new b();
    }

    public static b bWG() {
        return C0376b.igJ;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Bt = a.Bt(str);
            f fVar = this.gFe.get(Bt.getKey());
            if (fVar != null && Bt.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Bt.getParams().putAll(hashMap);
                }
                fVar.a(obj, Bt.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.gFe.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes3.dex */
    public static class a {
        private boolean bzi;
        HashMap<String, String> gFf;
        String key;

        public boolean isValid() {
            return this.bzi;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.gFf;
        }

        private a(String str) {
            this.bzi = false;
            Uri parse = Uri.parse(str);
            this.bzi = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.bzi) {
                this.key = parse.getAuthority() + parse.getPath();
                this.gFf = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.gFf.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.gFf = new HashMap<>();
        }

        public static a Bt(String str) {
            return new a(str);
        }
    }
}
