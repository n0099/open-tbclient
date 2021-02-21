package com.baidu.tieba.lego.a;

import com.baidu.tbadk.b.g;
import com.baidu.tbadk.b.h;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class a implements com.baidu.tbadk.b.d {
    private final HashMap<String, g> lau;

    private a() {
        this.lau = new HashMap<>();
    }

    /* renamed from: com.baidu.tieba.lego.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    private static class C0774a {
        private static final a lav = new a();
    }

    public static a dbp() {
        return C0774a.lav;
    }

    private void a(String str, g gVar) {
        this.lau.put(str, gVar);
    }

    public void a(g gVar) {
        a(gVar.key(), gVar);
    }

    public void a(String str, HashMap<String, String> hashMap, h hVar) {
        g gVar;
        if (str != null && hashMap != null && !hashMap.isEmpty() && hVar != null && (gVar = this.lau.get(str)) != null) {
            gVar.a(hashMap, hVar);
        }
    }
}
