package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.a.bf;
import com.baidu.tieba.c.bs;
import com.slidingmenu.lib.R;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends com.baidu.adp.lib.a.a {
    final /* synthetic */ WriteActivity a;
    private bs b;
    private com.baidu.tieba.d.t c = null;
    private String d = null;
    private com.baidu.tieba.a.g e = null;
    private com.baidu.tieba.d.e f = null;
    private volatile boolean g = false;

    public ap(WriteActivity writeActivity, bs bsVar) {
        this.a = writeActivity;
        this.b = null;
        this.b = bsVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (r11.c.b() == false) goto L20;
     */
    @Override // com.baidu.adp.lib.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(Integer... numArr) {
        Bitmap bitmap;
        Address aL;
        File c;
        bs bsVar;
        String b;
        com.baidu.tieba.a.f fVar;
        bs bsVar2;
        bitmap = this.a.y;
        if (bitmap != null && this.b.k() == null) {
            com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.d.o.c("tieba_resized_image");
                this.c = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() <= 102400 || (com.baidu.tieba.a.i.m() == 0 && this.c.e() != null && !this.c.e().equals("2"))) {
                com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.d.t tVar = this.c;
                bsVar = this.a.c;
                tVar.a("pic_type", String.valueOf(bsVar.o()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a = com.baidu.tieba.d.ad.a(com.baidu.tieba.d.o.a(c));
                com.baidu.tieba.a.f n = com.baidu.tieba.d.k.n(a);
                if (n == null) {
                    com.baidu.tieba.d.ae.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.a.f fVar2 = new com.baidu.tieba.a.f();
                    fVar2.a(a);
                    fVar2.a(0);
                    fVar2.a(c.length());
                    fVar = fVar2;
                } else {
                    fVar = n;
                }
                this.f = new com.baidu.tieba.d.e("tieba_resized_image", fVar, String.valueOf(com.baidu.tieba.a.i.e) + "c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.a()) {
                    this.c = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/c/img/finupload");
                    this.c.a("md5", fVar.a());
                    com.baidu.tieba.d.t tVar2 = this.c;
                    bsVar2 = this.a.c;
                    tVar2.a("pic_type", String.valueOf(bsVar2.o()));
                    b = this.c.i();
                    if (b == null || !this.c.b()) {
                        long b2 = fVar.b();
                        fVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        com.baidu.tieba.d.k.a(fVar);
                    } else {
                        com.baidu.tieba.d.k.m(a);
                        JSONObject jSONObject = new JSONObject(b);
                        com.baidu.tieba.a.z zVar = new com.baidu.tieba.a.z();
                        zVar.a(jSONObject.optJSONObject("info"));
                        this.b.a(zVar);
                    }
                }
                return null;
            }
        }
        if (!this.g) {
            this.c = new com.baidu.tieba.d.t();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.g());
            if (this.b.b() != 3) {
                this.c.a("kw", this.b.h());
            }
            String str = "";
            if (this.b.k() != null && this.b.k().a() != null && this.b.k().a().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.k().a(), Integer.valueOf(this.b.k().b()), Integer.valueOf(this.b.k().c()));
            }
            this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.d()) + str);
            if (this.b.j() != null && this.b.j().length() > 0) {
                this.c.a("vcode", this.b.j());
            }
            if (TiebaApplication.d().au() < 3) {
                this.c.a("vcode_tag", "11");
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
                if (!com.baidu.tieba.a.i.g().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.d().p() && (aL = TiebaApplication.d().aL()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aL.getLatitude())) + "," + String.valueOf(aL.getLongitude()));
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
        }
        return null;
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        this.a.v = null;
        this.a.h();
        this.g = true;
        if (this.c != null) {
            this.c.g();
        }
        if (this.f != null) {
            this.f.a();
        }
        super.cancel(true);
    }

    private void a(int i, String str) {
        bs bsVar;
        bs bsVar2;
        bs bsVar3;
        bs bsVar4;
        if (i == 5 || i == 6) {
            bf bfVar = new bf();
            bfVar.a(this.d);
            if (bfVar.b() != null) {
                bsVar = this.a.c;
                bsVar.h(bfVar.a());
                bsVar2 = this.a.c;
                bsVar2.i(bfVar.b());
                if (bfVar.c().equals("4")) {
                    WriteActivity writeActivity = this.a;
                    bsVar4 = this.a.c;
                    NewVcodeActivity.a(writeActivity, bsVar4, this.a.getIntent().getBooleanExtra("is_ad", false), 1200006);
                    return;
                }
                WriteActivity writeActivity2 = this.a;
                bsVar3 = this.a.c;
                VcodeActivity.a(writeActivity2, bsVar3, this.a.getIntent().getBooleanExtra("is_ad", false), 1200006);
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
        bs bsVar;
        this.a.h();
        this.a.v = null;
        if (this.e != null && !this.e.a()) {
            a(this.e.b(), this.e.c());
        } else if (this.c != null) {
            if (this.c.b()) {
                bsVar = this.a.c;
                com.baidu.tieba.d.k.a(bsVar);
                com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                oVar.b(this.d);
                if (oVar.b() == null || oVar.b().length() <= 0) {
                    this.a.a(TiebaApplication.d().getString(R.string.send_success));
                } else {
                    this.a.a(oVar.b());
                }
                if (this.b.b() == 4) {
                    Intent intent = new Intent();
                    intent.putExtra("reply_content", this.b.d());
                    intent.putExtra("reply_tid", this.b.e());
                    this.a.setResult(-1, intent);
                } else {
                    this.a.setResult(-1);
                }
                this.a.finish();
            } else {
                a(this.c.d(), this.c.f());
            }
        }
        super.a((Object) str);
    }
}
