package com.baidu.tieba.voice.a;

import com.baidu.tieba.data.h;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.x;
import com.baidu.tieba.voice.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.e.g {

    /* renamed from: a  reason: collision with root package name */
    private am f2715a = null;
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
        String a2 = x.a(str, 1);
        if (a2 == null) {
            return null;
        }
        d dVar = new d();
        dVar.f2713a = str;
        dVar.b = a2;
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
        this.f2715a = new am(h.f1248a + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.f2715a);
        }
        byte[] k = this.f2715a.k();
        if (!this.f2715a.d()) {
            dVar.c = 3;
            dVar.d = ak.a(R.string.sync_mark_fail_con);
            return dVar;
        } else if (k == null || k.length == 0) {
            dVar.c = 4;
            dVar.d = ak.a(R.string.voice_cache_error_no_file);
            return dVar;
        } else {
            int a2 = e.a(str, k);
            if (a2 == 0) {
                dVar.b = x.a(str, 1);
                dVar.f2713a = str;
            } else {
                dVar.c = a2;
                dVar.d = d.a(a2);
            }
            return dVar;
        }
    }
}
