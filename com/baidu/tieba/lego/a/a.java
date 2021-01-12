package com.baidu.tieba.lego.a;

import com.baidu.tbadk.b.g;
import com.baidu.tbadk.b.h;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a implements com.baidu.tbadk.b.d {
    private final HashMap<String, g> kSd;

    private a() {
        this.kSd = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static class C0771a {
        private static final a kSe = new a();
    }

    public static a cZk() {
        return C0771a.kSe;
    }

    private void a(String str, g gVar) {
        this.kSd.put(str, gVar);
    }

    public void a(g gVar) {
        a(gVar.key(), gVar);
    }

    public void a(String str, HashMap<String, String> hashMap, h hVar) {
        g gVar;
        if (str != null && hashMap != null && !hashMap.isEmpty() && hVar != null && (gVar = this.kSd.get(str)) != null) {
            gVar.a(hashMap, hVar);
        }
    }
}
