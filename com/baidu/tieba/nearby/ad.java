package com.baidu.tieba.nearby;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.c.bs;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.a.a {
    final /* synthetic */ NearbyPbActivity a;
    private com.baidu.tieba.d.t b = null;
    private boolean c = false;

    public ad(NearbyPbActivity nearbyPbActivity, bs bsVar) {
        this.a = nearbyPbActivity;
        nearbyPbActivity.A = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(Integer... numArr) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        bs bsVar5;
        bs bsVar6;
        bs bsVar7;
        bs bsVar8;
        bs bsVar9;
        if (this.c) {
            return null;
        }
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/add");
        this.b.a("anonymous", "0");
        com.baidu.tieba.d.t tVar = this.b;
        bsVar = this.a.A;
        tVar.a("fid", bsVar.g());
        com.baidu.tieba.d.t tVar2 = this.b;
        bsVar2 = this.a.A;
        tVar2.a("kw", bsVar2.h());
        com.baidu.tieba.d.t tVar3 = this.b;
        bsVar3 = this.a.A;
        tVar3.a(PushConstants.EXTRA_CONTENT, bsVar3.d());
        com.baidu.tieba.d.t tVar4 = this.b;
        bsVar4 = this.a.A;
        tVar4.a("tid", bsVar4.e());
        bsVar5 = this.a.A;
        if (bsVar5.j() != null) {
            bsVar8 = this.a.A;
            if (bsVar8.j().length() > 0) {
                com.baidu.tieba.d.t tVar5 = this.b;
                bsVar9 = this.a.A;
                tVar5.a("vcode", bsVar9.j());
            }
        }
        com.baidu.tieba.d.t tVar6 = this.b;
        bsVar6 = this.a.A;
        tVar6.a("quote_id", bsVar6.f());
        com.baidu.tieba.d.t tVar7 = this.b;
        bsVar7 = this.a.A;
        tVar7.a("floor_num", String.valueOf(bsVar7.i()));
        this.b.d(true);
        return this.b.i();
    }

    private void a(int i, String str, String str2) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.bf bfVar = new com.baidu.tieba.a.bf();
            bfVar.a(str2);
            if (bfVar.b() != null) {
                bsVar = this.a.A;
                bsVar.h(bfVar.a());
                bsVar2 = this.a.A;
                bsVar2.i(bfVar.b());
                NearbyPbActivity nearbyPbActivity = this.a;
                bsVar3 = this.a.A;
                VcodeActivity.a(nearbyPbActivity, bsVar3, 1200006);
                return;
            }
            this.a.a(str);
            return;
        }
        this.a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(String str) {
        super.a((Object) str);
        this.a.h();
        this.a.k = null;
        if (this.b != null) {
            if (this.b.b()) {
                this.a.u();
            } else {
                a(this.b.d(), this.b.f(), str);
            }
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.k = null;
        this.a.h();
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }
}
