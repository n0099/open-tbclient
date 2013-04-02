package com.baidu.tieba.nearby;

import android.os.AsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends AsyncTask {
    final /* synthetic */ NearbyPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private boolean c = false;

    public ae(NearbyPbActivity nearbyPbActivity, com.baidu.tieba.b.z zVar) {
        this.a = nearbyPbActivity;
        nearbyPbActivity.B = zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        com.baidu.tieba.b.z zVar;
        com.baidu.tieba.b.z zVar2;
        com.baidu.tieba.b.z zVar3;
        com.baidu.tieba.b.z zVar4;
        com.baidu.tieba.b.z zVar5;
        com.baidu.tieba.b.z zVar6;
        com.baidu.tieba.b.z zVar7;
        com.baidu.tieba.b.z zVar8;
        com.baidu.tieba.b.z zVar9;
        if (this.c) {
            return null;
        }
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/add");
        this.b.a("anonymous", "0");
        com.baidu.tieba.c.t tVar = this.b;
        zVar = this.a.B;
        tVar.a("fid", zVar.f());
        com.baidu.tieba.c.t tVar2 = this.b;
        zVar2 = this.a.B;
        tVar2.a("kw", zVar2.g());
        com.baidu.tieba.c.t tVar3 = this.b;
        zVar3 = this.a.B;
        tVar3.a(PushConstants.EXTRA_CONTENT, zVar3.c());
        com.baidu.tieba.c.t tVar4 = this.b;
        zVar4 = this.a.B;
        tVar4.a("tid", zVar4.d());
        zVar5 = this.a.B;
        if (zVar5.i() != null) {
            zVar8 = this.a.B;
            if (zVar8.i().length() > 0) {
                com.baidu.tieba.c.t tVar5 = this.b;
                zVar9 = this.a.B;
                tVar5.a("vcode", zVar9.i());
            }
        }
        com.baidu.tieba.c.t tVar6 = this.b;
        zVar6 = this.a.B;
        tVar6.a("quote_id", zVar6.e());
        com.baidu.tieba.c.t tVar7 = this.b;
        zVar7 = this.a.B;
        tVar7.a("floor_num", String.valueOf(zVar7.h()));
        this.b.d(true);
        return this.b.i();
    }

    private void a(int i, String str, String str2) {
        com.baidu.tieba.b.z zVar;
        com.baidu.tieba.b.z zVar2;
        com.baidu.tieba.b.z zVar3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.ba baVar = new com.baidu.tieba.a.ba();
            baVar.a(str2);
            if (baVar.b() != null) {
                zVar = this.a.B;
                zVar.h(baVar.a());
                zVar2 = this.a.B;
                zVar2.i(baVar.b());
                NearbyPbActivity nearbyPbActivity = this.a;
                zVar3 = this.a.B;
                VcodeActivity.a(nearbyPbActivity, zVar3, 1200005);
                return;
            }
            this.a.b(str);
            return;
        }
        this.a.b(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        super.onPostExecute(str);
        this.a.d();
        this.a.l = null;
        if (this.b != null) {
            if (this.b.b()) {
                this.a.t();
            } else {
                a(this.b.d(), this.b.f(), str);
            }
        }
    }

    public void a() {
        this.a.l = null;
        this.a.d();
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }
}
