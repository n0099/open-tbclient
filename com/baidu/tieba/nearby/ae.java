package com.baidu.tieba.nearby;

import android.os.AsyncTask;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends AsyncTask {
    final /* synthetic */ NearbyPbActivity a;
    private com.baidu.tieba.c.t b = null;
    private boolean c = false;

    public ae(NearbyPbActivity nearbyPbActivity, com.baidu.tieba.b.y yVar) {
        this.a = nearbyPbActivity;
        nearbyPbActivity.B = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(Integer... numArr) {
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        com.baidu.tieba.b.y yVar3;
        com.baidu.tieba.b.y yVar4;
        com.baidu.tieba.b.y yVar5;
        com.baidu.tieba.b.y yVar6;
        com.baidu.tieba.b.y yVar7;
        com.baidu.tieba.b.y yVar8;
        com.baidu.tieba.b.y yVar9;
        if (this.c) {
            return null;
        }
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/post/add");
        this.b.a("anonymous", "0");
        com.baidu.tieba.c.t tVar = this.b;
        yVar = this.a.B;
        tVar.a("fid", yVar.f());
        com.baidu.tieba.c.t tVar2 = this.b;
        yVar2 = this.a.B;
        tVar2.a("kw", yVar2.g());
        com.baidu.tieba.c.t tVar3 = this.b;
        yVar3 = this.a.B;
        tVar3.a("content", yVar3.c());
        com.baidu.tieba.c.t tVar4 = this.b;
        yVar4 = this.a.B;
        tVar4.a("tid", yVar4.d());
        yVar5 = this.a.B;
        if (yVar5.i() != null) {
            yVar8 = this.a.B;
            if (yVar8.i().length() > 0) {
                com.baidu.tieba.c.t tVar5 = this.b;
                yVar9 = this.a.B;
                tVar5.a("vcode", yVar9.i());
            }
        }
        com.baidu.tieba.c.t tVar6 = this.b;
        yVar6 = this.a.B;
        tVar6.a("quote_id", yVar6.e());
        com.baidu.tieba.c.t tVar7 = this.b;
        yVar7 = this.a.B;
        tVar7.a("floor_num", String.valueOf(yVar7.h()));
        this.b.d(true);
        return this.b.i();
    }

    private void a(int i, String str, String str2) {
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        com.baidu.tieba.b.y yVar3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
            awVar.a(str2);
            if (awVar.b() != null) {
                yVar = this.a.B;
                yVar.h(awVar.a());
                yVar2 = this.a.B;
                yVar2.i(awVar.b());
                NearbyPbActivity nearbyPbActivity = this.a;
                yVar3 = this.a.B;
                VcodeActivity.a(nearbyPbActivity, yVar3, 1200005);
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
