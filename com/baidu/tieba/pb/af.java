package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1447a;
    private WriteData b;
    private com.baidu.tieba.util.u c = null;
    private boolean d = false;

    public af(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.f1447a = imagePbActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.f().ax() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.e(true);
        return this.c.k();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.data.bq bqVar = new com.baidu.tieba.data.bq();
            bqVar.a(str2);
            if (bqVar.b() != null) {
                this.b.setVcodeMD5(bqVar.a());
                this.b.setVcodeUrl(bqVar.b());
                if (bqVar.c().equals("4")) {
                    NewVcodeActivity.a(this.f1447a, this.b, 12006);
                    return;
                } else {
                    VcodeActivity.a(this.f1447a, this.b, 12006);
                    return;
                }
            }
            this.f1447a.a(str);
            return;
        }
        this.f1447a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        this.f1447a.h();
        this.f1447a.v = null;
        if (this.c != null) {
            if (!this.c.d()) {
                a(this.c.f(), this.c.h(), str);
            } else {
                this.f1447a.o();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1447a.v = null;
        this.f1447a.h();
        this.d = true;
        if (this.c != null) {
            this.c.i();
        }
        super.cancel(true);
    }
}
