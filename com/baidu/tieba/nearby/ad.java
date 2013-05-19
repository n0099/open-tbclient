package com.baidu.tieba.nearby;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.c.bp;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.lib.a.a {
    final /* synthetic */ NearbyPbActivity a;
    private com.baidu.tieba.d.t b = null;
    private boolean c = false;

    public ad(NearbyPbActivity nearbyPbActivity, bp bpVar) {
        this.a = nearbyPbActivity;
        nearbyPbActivity.A = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(Integer... numArr) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        bp bpVar4;
        bp bpVar5;
        bp bpVar6;
        bp bpVar7;
        bp bpVar8;
        bp bpVar9;
        if (this.c) {
            return null;
        }
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/add");
        this.b.a("anonymous", "0");
        com.baidu.tieba.d.t tVar = this.b;
        bpVar = this.a.A;
        tVar.a("fid", bpVar.g());
        com.baidu.tieba.d.t tVar2 = this.b;
        bpVar2 = this.a.A;
        tVar2.a("kw", bpVar2.h());
        com.baidu.tieba.d.t tVar3 = this.b;
        bpVar3 = this.a.A;
        tVar3.a(PushConstants.EXTRA_CONTENT, bpVar3.d());
        com.baidu.tieba.d.t tVar4 = this.b;
        bpVar4 = this.a.A;
        tVar4.a("tid", bpVar4.e());
        bpVar5 = this.a.A;
        if (bpVar5.j() != null) {
            bpVar8 = this.a.A;
            if (bpVar8.j().length() > 0) {
                com.baidu.tieba.d.t tVar5 = this.b;
                bpVar9 = this.a.A;
                tVar5.a("vcode", bpVar9.j());
            }
        }
        com.baidu.tieba.d.t tVar6 = this.b;
        bpVar6 = this.a.A;
        tVar6.a("quote_id", bpVar6.f());
        com.baidu.tieba.d.t tVar7 = this.b;
        bpVar7 = this.a.A;
        tVar7.a("floor_num", String.valueOf(bpVar7.i()));
        this.b.d(true);
        return this.b.i();
    }

    private void a(int i, String str, String str2) {
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.be beVar = new com.baidu.tieba.a.be();
            beVar.a(str2);
            if (beVar.b() != null) {
                bpVar = this.a.A;
                bpVar.h(beVar.a());
                bpVar2 = this.a.A;
                bpVar2.i(beVar.b());
                NearbyPbActivity nearbyPbActivity = this.a;
                bpVar3 = this.a.A;
                VcodeActivity.a(nearbyPbActivity, bpVar3, 1200006);
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
