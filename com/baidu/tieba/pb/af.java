package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f1197a;
    private WriteModel b;
    private com.baidu.tieba.util.r c = null;
    private boolean d = false;

    public af(ImagePbActivity imagePbActivity, WriteModel writeModel) {
        this.f1197a = imagePbActivity;
        this.b = null;
        this.b = writeModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a(PushConstants.EXTRA_CONTENT, this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.f().aw() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.d(true);
        return this.c.j();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.data.be beVar = new com.baidu.tieba.data.be();
            beVar.a(str2);
            if (beVar.b() != null) {
                this.b.setVcodeMD5(beVar.a());
                this.b.setVcodeUrl(beVar.b());
                if (beVar.c().equals("4")) {
                    NewVcodeActivity.a(this.f1197a, this.b, 1200006);
                    return;
                } else {
                    VcodeActivity.a(this.f1197a, this.b, 1200006);
                    return;
                }
            }
            this.f1197a.a(str);
            return;
        }
        this.f1197a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((Object) str);
        this.f1197a.h();
        this.f1197a.v = null;
        if (this.c != null) {
            if (!this.c.c()) {
                a(this.c.e(), this.c.g(), str);
            } else {
                this.f1197a.q();
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1197a.v = null;
        this.f1197a.h();
        this.d = true;
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
