package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.AsyncTask;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends AsyncTask {
    final /* synthetic */ WriteActivity a;
    private com.baidu.tieba.b.u b;
    private com.baidu.tieba.c.t c = null;
    private String d = null;
    private com.baidu.tieba.a.f e = null;
    private com.baidu.tieba.c.f f = null;
    private volatile boolean g = false;

    public ao(WriteActivity writeActivity, com.baidu.tieba.b.u uVar) {
        this.a = writeActivity;
        this.b = null;
        this.b = uVar;
    }

    private void a(int i, String str) {
        com.baidu.tieba.b.u uVar;
        com.baidu.tieba.b.u uVar2;
        com.baidu.tieba.b.u uVar3;
        if (i != 5 && i != 6) {
            this.a.b(str);
            return;
        }
        com.baidu.tieba.a.av avVar = new com.baidu.tieba.a.av();
        avVar.a(this.d);
        if (avVar.b() == null) {
            this.a.b(str);
            return;
        }
        uVar = this.a.b;
        uVar.h(avVar.a());
        uVar2 = this.a.b;
        uVar2.i(avVar.b());
        WriteActivity writeActivity = this.a;
        uVar3 = this.a.b;
        VcodeActivity.a(writeActivity, uVar3, 1200005);
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
        Location at;
        File c;
        com.baidu.tieba.b.u uVar;
        String b;
        com.baidu.tieba.a.e eVar;
        com.baidu.tieba.b.u uVar2;
        bitmap = this.a.w;
        if (bitmap != null && this.b.j() == null) {
            com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.c.o.c("tieba_resized_image");
                this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() > 102400 && (com.baidu.tieba.a.h.j() != 0 || this.c.e() == null || this.c.e().equals("2"))) {
                com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a = com.baidu.tieba.c.ad.a(com.baidu.tieba.c.o.a(c));
                com.baidu.tieba.a.e n = com.baidu.tieba.c.k.n(a);
                if (n == null) {
                    com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.a.e eVar2 = new com.baidu.tieba.a.e();
                    eVar2.a(a);
                    eVar2.a(0);
                    eVar2.a(c.length());
                    eVar = eVar2;
                } else {
                    eVar = n;
                }
                this.f = new com.baidu.tieba.c.f("tieba_resized_image", eVar, "http://c.tieba.baidu.com/c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.a()) {
                    this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/finupload");
                    this.c.a("md5", eVar.a());
                    com.baidu.tieba.c.t tVar = this.c;
                    uVar2 = this.a.b;
                    tVar.a("pic_type", String.valueOf(uVar2.n()));
                    b = this.c.i();
                    if (b == null || !this.c.b()) {
                        long b2 = eVar.b();
                        eVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        com.baidu.tieba.c.k.a(eVar);
                    } else {
                        com.baidu.tieba.c.k.m(a);
                        JSONObject jSONObject = new JSONObject(b);
                        com.baidu.tieba.a.w wVar = new com.baidu.tieba.a.w();
                        wVar.a(jSONObject.optJSONObject("info"));
                        this.b.a(wVar);
                    }
                }
                return null;
            }
            com.baidu.tieba.c.ae.c("PostThreadTask", "doInBackground", "image size is less than 100K");
            com.baidu.tieba.c.t tVar2 = this.c;
            uVar = this.a.b;
            tVar2.a("pic_type", String.valueOf(uVar.n()));
            b = this.c.b("tieba_resized_image");
        }
        if (!this.g) {
            this.c = new com.baidu.tieba.c.t();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.f());
            this.c.a("kw", this.b.g());
            String str = "";
            if (this.b.j() != null && this.b.j().a() != null && this.b.j().a().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.j().a(), Integer.valueOf(this.b.j().b()), Integer.valueOf(this.b.j().c()));
            }
            this.c.a("content", String.valueOf(this.b.c()) + str);
            if (this.b.i() != null && this.b.i().length() > 0) {
                this.c.a("vcode", this.b.i());
            }
            this.c.d(true);
            if (this.b.a() == 0) {
                this.c.a("http://c.tieba.baidu.com/c/c/thread/add");
                this.c.a("title", this.b.b());
                if (!com.baidu.tieba.a.h.f().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.a().j() && (at = TiebaApplication.a().at()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(at.getLatitude())) + "," + String.valueOf(at.getLongitude()));
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
        this.a.t = null;
        this.a.c();
        this.g = true;
        if (this.c != null) {
            this.c.g();
        }
        if (this.f != null) {
            this.f.a();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        com.baidu.tieba.b.u uVar;
        this.a.c();
        this.a.t = null;
        if (this.e != null && !this.e.a()) {
            a(this.e.b(), this.e.c());
        } else if (this.c != null) {
            if (this.c.b()) {
                uVar = this.a.b;
                com.baidu.tieba.c.k.a(uVar);
                this.a.b(TiebaApplication.a().getString(R.string.send_success));
                this.a.setResult(-1);
                this.a.finish();
            } else {
                a(this.c.d(), this.c.f());
            }
        }
        super.onPostExecute(str);
    }
}
