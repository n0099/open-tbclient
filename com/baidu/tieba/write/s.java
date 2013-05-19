package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.be;
import com.baidu.tieba.c.bp;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends com.baidu.adp.lib.a.a {
    final /* synthetic */ VcodeActivity a;
    private bp b;
    private com.baidu.tieba.d.t c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, bp bpVar) {
        this.a = vcodeActivity;
        this.b = null;
        this.b = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public be a(Integer... numArr) {
        EditText editText;
        Address aC;
        this.c = new com.baidu.tieba.d.t();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.g());
        this.c.a("kw", this.b.h());
        String str = "";
        if (this.b.k() != null && this.b.k().a() != null && this.b.k().a().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.k().a(), Integer.valueOf(this.b.k().b()), Integer.valueOf(this.b.k().c()));
        }
        this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.d()) + str);
        this.c.a("vcode_md5", this.b.l());
        editText = this.a.g;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.d(true);
        if (this.b.b() == 0 || this.b.b() == 3) {
            this.c.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/thread/add");
            if (this.b.b() == 0) {
                this.c.a("title", this.b.c());
            } else {
                this.c.a("thread_type", "7");
                this.c.a("st_type", "tb_suishoufa");
            }
            if (!com.baidu.tieba.a.i.f().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.d().o() && (aC = TiebaApplication.d().aC()) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(aC.getLatitude())) + "," + String.valueOf(aC.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/post/add");
            this.c.a("tid", this.b.e());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
            if (this.b.b() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.f()));
                this.c.a("floor_num", String.valueOf(this.b.i()));
            }
        }
        this.d = this.c.i();
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.i = null;
        this.a.h();
        if (this.c != null) {
            this.c.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(be beVar) {
        EditText editText;
        bp bpVar;
        bp bpVar2;
        bp bpVar3;
        this.a.h();
        this.a.i = null;
        if (this.c != null) {
            if (this.c.b()) {
                com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                oVar.b(this.d);
                if (oVar.b() == null || oVar.b().length() <= 0) {
                    this.a.a(TiebaApplication.d().getString(R.string.send_success));
                } else {
                    this.a.a(oVar.b());
                }
                this.a.setResult(-1, this.a.getIntent());
                this.a.finish();
            } else {
                if (this.c.d() == 5 || this.c.d() == 6) {
                    be beVar2 = new be();
                    beVar2.a(this.d);
                    if (beVar2.b() != null) {
                        bpVar = this.a.c;
                        bpVar.h(beVar2.a());
                        bpVar2 = this.a.c;
                        bpVar2.i(beVar2.b());
                        VcodeActivity vcodeActivity = this.a;
                        bpVar3 = this.a.c;
                        vcodeActivity.c(bpVar3.m());
                    }
                    editText = this.a.g;
                    editText.setText((CharSequence) null);
                }
                this.a.a(this.c.f());
            }
        }
        super.a((Object) beVar);
    }
}
