package com.baidu.tieba.recapp.a;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.base.d;
import com.baidu.tbadk.b.e;
import com.baidu.tbadk.b.f;
import java.util.HashMap;
/* loaded from: classes13.dex */
public class b implements e {
    private final HashMap<String, f> iId;

    private b() {
        this.iId = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.recapp.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static class C0637b {
        private static b krz = new b();
    }

    public static b cNp() {
        return C0637b.krz;
    }

    public void a(Object obj, String str, HashMap<String, String> hashMap, d dVar) {
        if (str != null) {
            a Jp = a.Jp(str);
            f fVar = this.iId.get(Jp.getKey());
            if (fVar != null && Jp.isValid()) {
                if (hashMap != null && !hashMap.isEmpty()) {
                    Jp.getParams().putAll(hashMap);
                }
                fVar.a(obj, Jp.getParams(), str, dVar);
            }
        }
    }

    public void a(String str, f fVar) {
        this.iId.put(str, fVar);
    }

    public void a(com.baidu.tbadk.b.a aVar) {
        a(aVar.key(), aVar);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private boolean doI;
        HashMap<String, String> iIe;
        String key;

        public boolean isValid() {
            return this.doI;
        }

        public String getKey() {
            return this.key;
        }

        public HashMap<String, String> getParams() {
            return this.iIe;
        }

        private a(String str) {
            this.doI = false;
            Uri parse = Uri.parse(str);
            this.doI = TextUtils.isEmpty(parse.getScheme()) ? false : true;
            if (this.doI) {
                this.key = parse.getAuthority() + parse.getPath();
                this.iIe = new HashMap<>();
                for (String str2 : parse.getQueryParameterNames()) {
                    this.iIe.put(str2, parse.getQueryParameter(str2));
                }
                return;
            }
            this.key = "";
            this.iIe = new HashMap<>();
        }

        public static a Jp(String str) {
            return new a(str);
        }
    }
}
