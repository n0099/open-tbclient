package com.baidu.tieba.voice.a;

import com.baidu.adp.lib.e.h;
import com.baidu.adp.lib.e.i;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.voice.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public final class g implements i {
    private ba a = null;
    private h b;

    @Override // com.baidu.adp.lib.e.i
    public final /* synthetic */ Object a(String str, com.baidu.adp.lib.e.e eVar) {
        String a = af.a(str, 1);
        if (a == null) {
            return null;
        }
        d dVar = new d();
        dVar.a = str;
        dVar.b = a;
        return dVar;
    }

    @Override // com.baidu.adp.lib.e.i
    public final /* bridge */ /* synthetic */ Object a(String str, h hVar) {
        return null;
    }

    @Override // com.baidu.adp.lib.e.i
    public final /* synthetic */ Object b(String str, com.baidu.adp.lib.e.e eVar) {
        this.b = eVar.e();
        String str2 = this.b != null ? (String) this.b.a("from") : null;
        d dVar = new d();
        this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.a);
        }
        byte[] k = this.a.k();
        if (!this.a.d()) {
            dVar.c = 3;
            dVar.d = ak.a(R.string.sync_mark_fail_con);
        } else if (k == null || k.length == 0) {
            dVar.c = 4;
            dVar.d = ak.a(R.string.voice_cache_error_no_file);
        } else {
            int i = str == null ? 5 : k == null ? 6 : k.length == 0 ? 6 : af.a(str, k, 1) == null ? af.e() < ((long) k.length) ? 2 : 1 : 0;
            if (i == 0) {
                dVar.b = af.a(str, 1);
                dVar.a = str;
            } else {
                dVar.c = i;
                dVar.d = d.a(i);
            }
        }
        return dVar;
    }
}
