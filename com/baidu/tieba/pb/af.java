package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1525a;
    private WriteData b;
    private com.baidu.tieba.util.z c = null;
    private boolean d = false;

    public af(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.f1525a = imagePbActivity;
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
        this.c = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", "1");
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.g().as() < 3) {
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
                    NewVcodeActivity.a(this.f1525a, this.b, 12006);
                    return;
                } else {
                    VcodeActivity.a(this.f1525a, this.b, 12006);
                    return;
                }
            }
            this.f1525a.a(str);
            return;
        }
        this.f1525a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((af) str);
        this.f1525a.i();
        this.f1525a.v = null;
        if (this.c != null) {
            if (!this.c.c()) {
                a(this.c.e(), this.c.g(), str);
            } else {
                this.f1525a.p();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1525a.v = null;
        this.f1525a.i();
        this.d = true;
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
