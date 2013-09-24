package com.baidu.tieba.voice.a;

import com.baidu.tieba.util.z;
import com.baidu.tieba.voice.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.lib.c.g {

    /* renamed from: a  reason: collision with root package name */
    private z f2022a = null;
    private com.baidu.adp.lib.c.f b;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.g
    /* renamed from: b */
    public d a(String str, com.baidu.adp.lib.c.f fVar) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.g
    /* renamed from: c */
    public d a(String str, com.baidu.adp.lib.c.e eVar) {
        String a2 = e.a(str);
        if (a2 == null) {
            return null;
        }
        d dVar = new d();
        dVar.f2020a = str;
        dVar.b = a2;
        return dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.c.g
    /* renamed from: d */
    public d b(String str, com.baidu.adp.lib.c.e eVar) {
        this.b = eVar.e();
        String str2 = null;
        if (this.b != null) {
            str2 = (String) this.b.a("from");
        }
        d dVar = new d();
        this.f2022a = new z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/p/voice?voice_md5=" + str + "&play_from=" + str2);
        if (this.b != null) {
            this.b.a("network", this.f2022a);
        }
        byte[] i = this.f2022a.i();
        if (!this.f2022a.d()) {
            dVar.c = 3;
            dVar.d = ak.a(R.string.sync_mark_fail_con);
            return dVar;
        } else if (i == null || i.length == 0) {
            dVar.c = 4;
            dVar.d = ak.a(R.string.voice_cache_error_no_file);
            return dVar;
        } else {
            int a2 = e.a(str, i);
            if (a2 == 0) {
                dVar.b = e.a(str);
                dVar.f2020a = str;
            } else {
                dVar.c = a2;
                dVar.d = d.a(a2);
            }
            return dVar;
        }
    }
}
