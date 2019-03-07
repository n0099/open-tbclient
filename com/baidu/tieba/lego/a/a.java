package com.baidu.tieba.lego.a;

import com.baidu.tbadk.b.g;
import com.baidu.tbadk.b.h;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a implements com.baidu.tbadk.b.d {
    private final HashMap<String, g> gFo;

    private a() {
        this.gFo = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0266a {
        private static final a gFp = new a();
    }

    public static a bzx() {
        return C0266a.gFp;
    }

    private void a(String str, g gVar) {
        this.gFo.put(str, gVar);
    }

    public void a(g gVar) {
        a(gVar.key(), gVar);
    }

    public void a(String str, HashMap<String, String> hashMap, h hVar) {
        g gVar;
        if (str != null && hashMap != null && !hashMap.isEmpty() && hVar != null && (gVar = this.gFo.get(str)) != null) {
            gVar.a(hashMap, hVar);
        }
    }
}
