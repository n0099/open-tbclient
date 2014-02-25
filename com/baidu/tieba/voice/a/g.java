package com.baidu.tieba.voice.a;

import com.baidu.adp.lib.e.h;
import com.baidu.adp.lib.e.i;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ba;
import com.baidu.tieba.voice.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g implements i {
    private ba a = null;
    private h b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.i
    /* renamed from: b */
    public d a(String str, h hVar) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.i
    /* renamed from: c */
    public d a(String str, com.baidu.adp.lib.e.e eVar) {
        String a = af.a(str, 1);
        if (a == null) {
            return null;
        }
        d dVar = new d();
        dVar.a = str;
        dVar.b = a;
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.i
    /* renamed from: d */
    public d b(String str, com.baidu.adp.lib.e.e eVar) {
        this.b = eVar.e();
        String str2 = null;
        if (this.b != null) {
            str2 = (String) this.b.a("from");
        }
        d dVar = new d();
        this.a = new ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.a);
        }
        byte[] l = this.a.l();
        if (!this.a.e()) {
            dVar.c = 3;
            dVar.d = ak.a(R.string.sync_mark_fail_con);
            return dVar;
        } else if (l == null || l.length == 0) {
            dVar.c = 4;
            dVar.d = ak.a(R.string.voice_cache_error_no_file);
            return dVar;
        } else {
            int a = e.a(str, l);
            if (a == 0) {
                dVar.b = af.a(str, 1);
                dVar.a = str;
            } else {
                dVar.c = a;
                dVar.d = d.a(a);
            }
            return dVar;
        }
    }
}
