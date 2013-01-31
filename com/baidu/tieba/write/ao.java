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
    private com.baidu.tieba.b.w b;
    private com.baidu.tieba.c.t c = null;
    private String d = null;
    private com.baidu.tieba.a.g e = null;
    private com.baidu.tieba.c.f f = null;
    private volatile boolean g = false;

    public ao(WriteActivity writeActivity, com.baidu.tieba.b.w wVar) {
        this.a = writeActivity;
        this.b = null;
        this.b = wVar;
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
        Location aw;
        File c;
        com.baidu.tieba.b.w wVar;
        String b;
        com.baidu.tieba.a.f fVar;
        com.baidu.tieba.b.w wVar2;
        bitmap = this.a.x;
        if (bitmap != null && this.b.j() == null) {
            com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.c.o.c("tieba_resized_image");
                this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() <= 102400 || (com.baidu.tieba.a.i.j() == 0 && this.c.e() != null && !this.c.e().equals("2"))) {
                com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.c.t tVar = this.c;
                wVar = this.a.c;
                tVar.a("pic_type", String.valueOf(wVar.n()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a = com.baidu.tieba.c.ae.a(com.baidu.tieba.c.o.a(c));
                com.baidu.tieba.a.f o = com.baidu.tieba.c.k.o(a);
                if (o == null) {
                    com.baidu.tieba.c.af.e("PostThreadTask", "doInBackground", "upload data is null");
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
                    wVar2 = this.a.c;
                    tVar2.a("pic_type", String.valueOf(wVar2.n()));
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
                if (!com.baidu.tieba.a.i.f().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.b().l() && (aw = TiebaApplication.b().aw()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aw.getLatitude())) + "," + String.valueOf(aw.getLongitude()));
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
        this.a.u = null;
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
        com.baidu.tieba.b.w wVar;
        com.baidu.tieba.b.w wVar2;
        com.baidu.tieba.b.w wVar3;
        if (i == 5 || i == 6) {
            com.baidu.tieba.a.ay ayVar = new com.baidu.tieba.a.ay();
            ayVar.a(this.d);
            if (ayVar.b() != null) {
                wVar = this.a.c;
                wVar.h(ayVar.a());
                wVar2 = this.a.c;
                wVar2.i(ayVar.b());
                WriteActivity writeActivity = this.a;
                wVar3 = this.a.c;
                VcodeActivity.a(writeActivity, wVar3, 1200005);
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
        com.baidu.tieba.b.w wVar;
        this.a.d();
        this.a.u = null;
        if (this.e != null && !this.e.a()) {
            a(this.e.b(), this.e.c());
        } else if (this.c != null) {
            if (this.c.b()) {
                wVar = this.a.c;
                com.baidu.tieba.c.k.a(wVar);
                this.a.b(TiebaApplication.b().getString(R.string.send_success));
                this.a.setResult(-1);
                this.a.finish();
            } else {
                a(this.c.d(), this.c.f());
            }
        }
        super.onPostExecute(str);
    }
}
