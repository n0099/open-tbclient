package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes25.dex */
public class b implements e {
    private final HashMap<String, f> jVO;

    private b() {
        this.jVO = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0787b {
        private static b lLv = new b();
    }

    public static b dqV() {
        return C0787b.lLv;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a PN = a.PN(str);
            f fVar = this.jVO.get(PN.getKey());
            if (fVar != null && PN.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    PN.getParams().putAll(hashMap);
                }
                fVar.a(obj, PN.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.jVO.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes25.dex */
    public static class a {
        private boolean eaY;
        HashMap<String, String> elw;
        String key;

        public boolean isValid() {
            return this.eaY;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.elw;
        }

        private a(String str) {
            this.eaY = false;
            Uri parse = Uri.parse(str);
            this.eaY = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.eaY) {
                this.key = parse.getAuthority() + parse.getPath();
                this.elw = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.elw.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.elw = new HashMap<>();
        }

        public static a PN(String str) {
            return new a(str);
        }
    }
}
