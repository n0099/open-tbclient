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
    final /* synthetic */ ImagePbActivity f1482a;
    private WriteData b;
    private com.baidu.tieba.util.v c = null;
    private boolean d = false;

    public af(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.f1482a = imagePbActivity;
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
        this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", "1");
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.g().aq() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.e(true);
        return this.c.j();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.data.bj bjVar = new com.baidu.tieba.data.bj();
            bjVar.a(str2);
            if (bjVar.b() != null) {
                this.b.setVcodeMD5(bjVar.a());
                this.b.setVcodeUrl(bjVar.b());
                if (bjVar.c().equals("4")) {
                    NewVcodeActivity.a(this.f1482a, this.b, 12006);
                    return;
                } else {
                    VcodeActivity.a(this.f1482a, this.b, 12006);
                    return;
                }
            }
            this.f1482a.a(str);
            return;
        }
        this.f1482a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        this.f1482a.h();
        this.f1482a.v = null;
        if (this.c != null) {
            if (!this.c.c()) {
                a(this.c.e(), this.c.g(), str);
            } else {
                this.f1482a.o();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1482a.v = null;
        this.f1482a.h();
        this.d = true;
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
