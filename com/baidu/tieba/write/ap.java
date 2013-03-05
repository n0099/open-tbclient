package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.os.AsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends AsyncTask {
    final /* synthetic */ WriteActivity a;
    private com.baidu.tieba.b.y b;
    private com.baidu.tieba.c.t c = null;
    private String d = null;
    private com.baidu.tieba.a.g e = null;
    private com.baidu.tieba.c.f f = null;
    private volatile boolean g = false;

    public ap(WriteActivity writeActivity, com.baidu.tieba.b.y yVar) {
        this.a = writeActivity;
        this.b = null;
        this.b = yVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007f, code lost:
        if (r11.c.b() == false) goto L20;
     */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doInBackground(Integer... numArr) {
        Bitmap bitmap;
        Address ax;
        File c;
        com.baidu.tieba.b.y yVar;
        String b;
        com.baidu.tieba.a.f fVar;
        com.baidu.tieba.b.y yVar2;
        bitmap = this.a.y;
        if (bitmap != null && this.b.j() == null) {
            com.baidu.tieba.c.ag.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.c.o.c("tieba_resized_image");
                this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() <= 102400 || (com.baidu.tieba.a.i.j() == 0 && this.c.e() != null && !this.c.e().equals("2"))) {
                com.baidu.tieba.c.ag.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.c.t tVar = this.c;
                yVar = this.a.c;
                tVar.a("pic_type", String.valueOf(yVar.n()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.c.ag.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a = com.baidu.tieba.c.af.a(com.baidu.tieba.c.o.a(c));
                com.baidu.tieba.a.f o = com.baidu.tieba.c.k.o(a);
                if (o == null) {
                    com.baidu.tieba.c.ag.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.a.f fVar2 = new com.baidu.tieba.a.f();
                    fVar2.a(a);
                    fVar2.a(0);
                    fVar2.a(c.length());
                    fVar = fVar2;
                } else {
                    fVar = o;
                }
                this.f = new com.baidu.tieba.c.f("tieba_resized_image", fVar, "http://c.tieba.baidu.com/c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.a()) {
                    this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/finupload");
                    this.c.a("md5", fVar.a());
                    com.baidu.tieba.c.t tVar2 = this.c;
                    yVar2 = this.a.c;
                    tVar2.a("pic_type", String.valueOf(yVar2.n()));
                    b = this.c.i();
                    if (b == null || !this.c.b()) {
                        long b2 = fVar.b();
                        fVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        com.baidu.tieba.c.k.a(fVar);
                    } else {
                        com.baidu.tieba.c.k.n(a);
                        JSONObject jSONObject = new JSONObject(b);
                        com.baidu.tieba.a.x xVar = new com.baidu.tieba.a.x();
                        xVar.a(jSONObject.optJSONObject("info"));
                        this.b.a(xVar);
                    }
                }
                return null;
            }
        }
        if (!this.g) {
            this.c = new com.baidu.tieba.c.t();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.f());
            if (this.b.a() != 3) {
                this.c.a("kw", this.b.g());
            }
            String str = "";
            if (this.b.j() != null && this.b.j().a() != null && this.b.j().a().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.j().a(), Integer.valueOf(this.b.j().b()), Integer.valueOf(this.b.j().c()));
            }
            this.c.a("content", String.valueOf(this.b.c()) + str);
            if (this.b.i() != null && this.b.i().length() > 0) {
                this.c.a("vcode", this.b.i());
            }
            this.c.d(true);
            if (this.b.a() == 0 || this.b.a() == 3) {
                this.c.a("http://c.tieba.baidu.com/c/c/thread/add");
                if (this.b.a() == 0) {
                    this.c.a("title", this.b.b());
                } else {
                    this.c.a("thread_type", "7");
                    this.c.a("st_type", "tb_suishoufa");
                }
                if (!com.baidu.tieba.a.i.f().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.b().l() && (ax = TiebaApplication.b().ax()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(ax.getLatitude())) + "," + String.valueOf(ax.getLongitude()));
                }
            } else {
                this.c.a("http://c.tieba.baidu.com/c/c/post/add");
                this.c.a("tid", this.b.d());
                this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                if (this.b.a() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.e()));
                    this.c.a("floor_num", String.valueOf(this.b.h()));
                }
            }
            this.d = this.c.i();
        }
        return null;
    }

    public void a() {
        this.a.v = null;
        this.a.d();
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
        com.baidu.tieba.b.y yVar;
        com.baidu.tieba.b.y yVar2;
        com.baidu.tieba.b.y yVar3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
            awVar.a(this.d);
            if (awVar.b() != null) {
                yVar = this.a.c;
                yVar.h(awVar.a());
                yVar2 = this.a.c;
                yVar2.i(awVar.b());
                WriteActivity writeActivity = this.a;
                yVar3 = this.a.c;
                VcodeActivity.a(writeActivity, yVar3, this.a.getIntent().getBooleanExtra("is_ad", false), 1200005);
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
        com.baidu.tieba.b.y yVar;
        this.a.d();
        this.a.v = null;
        if (this.e != null && !this.e.a()) {
            a(this.e.b(), this.e.c());
        } else if (this.c != null) {
            if (this.c.b()) {
                yVar = this.a.c;
                com.baidu.tieba.c.k.a(yVar);
                com.baidu.tieba.a.o oVar = new com.baidu.tieba.a.o();
                oVar.a(this.d);
                if (oVar.b() == null || oVar.b().length() <= 0) {
                    this.a.b(TiebaApplication.b().getString(R.string.send_success));
                } else {
                    this.a.b(oVar.b());
                }
                if (this.b.a() == 4) {
                    Intent intent = new Intent();
                    intent.putExtra("reply_content", this.b.c());
                    intent.putExtra("reply_tid", this.b.d());
                    this.a.setResult(-1, intent);
                } else {
                    this.a.setResult(-1);
                }
                this.a.finish();
            } else {
                a(this.c.d(), this.c.f());
            }
        }
        super.onPostExecute(str);
    }
}
