package com.baidu.tieba.pb;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.write.NewVcodeActivity;
import com.baidu.tieba.write.VcodeActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ImagePbActivity a;
    private com.baidu.tieba.c.bp b;
    private com.baidu.tieba.d.t c = null;
    private boolean d = false;

    public af(ImagePbActivity imagePbActivity, com.baidu.tieba.c.bp bpVar) {
        this.a = imagePbActivity;
        this.b = null;
        this.b = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public String a(Integer... numArr) {
        if (this.d) {
            return null;
        }
        this.c = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/add");
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.g());
        this.c.a("kw", this.b.h());
        this.c.a(PushConstants.EXTRA_CONTENT, this.b.d());
        this.c.a("tid", this.b.e());
        if (this.b.j() != null && this.b.j().length() > 0) {
            this.c.a("vcode", this.b.j());
        }
        if (TiebaApplication.d().al() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("quote_id", this.b.f());
        this.c.a("floor_num", String.valueOf(this.b.i()));
        this.c.d(true);
        return this.c.i();
    }

    private void a(int i, String str, String str2) {
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.be beVar = new com.baidu.tieba.a.be();
            beVar.a(str2);
            if (beVar.b() != null) {
                this.b.h(beVar.a());
                this.b.i(beVar.b());
                if (beVar.c().equals("4")) {
                    NewVcodeActivity.a(this.a, this.b, 1200006);
                    return;
                } else {
                    VcodeActivity.a(this.a, this.b, 1200006);
                    return;
                }
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
        this.a.v = null;
        if (this.c != null) {
            if (!this.c.b()) {
                a(this.c.d(), this.c.f(), str);
            } else {
                this.a.q();
            }
        }
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.v = null;
        this.a.h();
        this.d = true;
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }
}
