package com.baidu.tieba.voice.a;

import com.baidu.tieba.data.h;
import com.baidu.tieba.util.an;
import com.baidu.tieba.util.y;
import com.baidu.tieba.voice.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.e.g {
    private an a = null;
    private com.baidu.adp.lib.e.f b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.g
    /* renamed from: b */
    public d a(String str, com.baidu.adp.lib.e.f fVar) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.g
    /* renamed from: c */
    public d a(String str, com.baidu.adp.lib.e.e eVar) {
        String a = y.a(str, 1);
        if (a == null) {
            return null;
        }
        d dVar = new d();
        dVar.a = str;
        dVar.b = a;
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.g
    /* renamed from: d */
    public d b(String str, com.baidu.adp.lib.e.e eVar) {
        this.b = eVar.d();
        String str2 = null;
        if (this.b != null) {
            str2 = (String) this.b.a("from");
        }
        d dVar = new d();
        this.a = new an(h.a + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.a);
        }
        byte[] k = this.a.k();
        if (!this.a.d()) {
            dVar.c = 3;
            dVar.d = ak.a(R.string.sync_mark_fail_con);
            return dVar;
        } else if (k == null || k.length == 0) {
            dVar.c = 4;
            dVar.d = ak.a(R.string.voice_cache_error_no_file);
            return dVar;
        } else {
            int a = e.a(str, k);
            if (a == 0) {
                dVar.b = y.a(str, 1);
                dVar.a = str;
            } else {
                dVar.c = a;
                dVar.d = d.a(a);
            }
            return dVar;
        }
    }
}
