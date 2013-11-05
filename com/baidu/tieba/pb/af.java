package com.baidu.tieba.pb;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImagePbActivity f2042a;
    private WriteData b;
    private com.baidu.tieba.util.ag c = null;
    private boolean d = false;

    public af(ImagePbActivity imagePbActivity, WriteData writeData) {
        this.f2042a = imagePbActivity;
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
        this.c = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/post/add");
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a("content", this.b.getContent());
        this.c.a("tid", this.b.getThreadId());
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.g().av() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.getFloor());
        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
        this.c.e(true);
        return this.c.j();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.data.bh bhVar = new com.baidu.tieba.data.bh();
            bhVar.a(str2);
            if (bhVar.b() != null) {
                this.b.setVcodeMD5(bhVar.a());
                this.b.setVcodeUrl(bhVar.b());
                if (bhVar.c().equals("4")) {
                    NewVcodeActivity.a(this.f2042a, this.b, 12006);
                    return;
                } else {
                    VcodeActivity.a(this.f2042a, this.b, 12006);
                    return;
                }
            }
            this.f2042a.a(str);
            return;
        }
        this.f2042a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        super.a((af) str);
        this.f2042a.j();
        this.f2042a.v = null;
        if (this.c != null) {
            if (this.c.c()) {
                this.f2042a.p();
            } else {
                a(this.c.e(), this.c.g(), str);
            }
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2042a.v = null;
        this.f2042a.j();
        this.d = true;
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }
}
