package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.location.Address;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bj;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1914a;
    private WriteData b;
    private com.baidu.tieba.util.v c = null;
    private String d = null;
    private com.baidu.tieba.data.e e = null;
    private com.baidu.tieba.util.f f = null;
    private volatile boolean g = false;

    public ao(WriteActivity writeActivity, WriteData writeData) {
        this.f1914a = writeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
        if (r11.c.c() == false) goto L20;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(Integer... numArr) {
        Bitmap bitmap;
        Address aK;
        File c;
        WriteData writeData;
        String b;
        com.baidu.tieba.data.d dVar;
        WriteData writeData2;
        bitmap = this.f1914a.y;
        if (bitmap != null && this.b.getBitmapId() == null) {
            com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.util.p.c("tieba_resized_image");
                this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() <= 102400 || (com.baidu.tieba.data.g.n() == 0 && this.c.f() != null && !this.c.f().equals("2"))) {
                com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.util.v vVar = this.c;
                writeData = this.f1914a.f1897a;
                vVar.a("pic_type", String.valueOf(writeData.getPicType()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a2 = com.baidu.tieba.util.ap.a(com.baidu.tieba.util.p.a(c));
                com.baidu.tieba.data.d o = DatabaseService.o(a2);
                if (o == null) {
                    com.baidu.tieba.util.aq.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                    dVar2.a(a2);
                    dVar2.a(0);
                    dVar2.a(c.length());
                    dVar = dVar2;
                } else {
                    dVar = o;
                }
                this.f = new com.baidu.tieba.util.f("tieba_resized_image", dVar, String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.a()) {
                    this.c = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/img/finupload");
                    this.c.a("md5", dVar.a());
                    com.baidu.tieba.util.v vVar2 = this.c;
                    writeData2 = this.f1914a.f1897a;
                    vVar2.a("pic_type", String.valueOf(writeData2.getPicType()));
                    b = this.c.j();
                    if (b == null || !this.c.c()) {
                        long b2 = dVar.b();
                        dVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        DatabaseService.a(dVar);
                    } else {
                        DatabaseService.n(a2);
                        JSONObject jSONObject = new JSONObject(b);
                        InfoData infoData = new InfoData();
                        infoData.parserJson(jSONObject.optJSONObject("info"));
                        this.b.setBitmapId(infoData);
                    }
                }
                return null;
            }
        }
        if (!this.g) {
            this.c = new com.baidu.tieba.util.v();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.getForumId());
            this.c.a("kw", this.b.getForumName());
            String str = "";
            if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
            }
            if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
                this.c.a("vcode", this.b.getVcode());
            }
            if (TiebaApplication.g().aq() < 3) {
                this.c.a("vcode_tag", "11");
            }
            this.c.a("new_vcode", "1");
            this.c.a("content", String.valueOf(this.b.getContent()) + str);
            this.c.e(true);
            if (this.b.getType() == 0) {
                this.c.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/thread/add");
                this.c.a("title", this.b.getTitle());
                if (!com.baidu.tieba.data.g.h().equals(this.f1914a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().v() && (aK = TiebaApplication.g().aK()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
                }
            } else {
                this.c.a(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", this.f1914a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                if (this.b.getType() == 2) {
                    this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                    this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                }
            }
            this.d = this.c.j();
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1914a.v = null;
        this.f1914a.h();
        this.g = true;
        if (this.c != null) {
            this.c.h();
        }
        if (this.f != null) {
            this.f.a();
        }
        super.cancel(true);
    }

    private void a(int i, String str) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        if (i == 5 || i == 6) {
            bj bjVar = new bj();
            bjVar.a(this.d);
            if (bjVar.b() != null) {
                writeData = this.f1914a.f1897a;
                writeData.setVcodeMD5(bjVar.a());
                writeData2 = this.f1914a.f1897a;
                writeData2.setVcodeUrl(bjVar.b());
                if (bjVar.c().equals("4")) {
                    WriteActivity writeActivity = this.f1914a;
                    writeData4 = this.f1914a.f1897a;
                    NewVcodeActivity.a(writeActivity, writeData4, this.f1914a.getIntent().getBooleanExtra("is_ad", false), 12006);
                    return;
                }
                WriteActivity writeActivity2 = this.f1914a;
                writeData3 = this.f1914a.f1897a;
                VcodeActivity.a(writeActivity2, writeData3, this.f1914a.getIntent().getBooleanExtra("is_ad", false), 12006);
                return;
            }
            this.f1914a.a(str);
            return;
        }
        this.f1914a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        WriteData writeData;
        this.f1914a.h();
        this.f1914a.v = null;
        if (this.e != null && !this.e.a()) {
            a(this.e.b(), this.e.c());
        } else if (this.c != null) {
            if (this.c.c()) {
                writeData = this.f1914a.f1897a;
                DatabaseService.a(writeData);
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.d);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    this.f1914a.a(TiebaApplication.g().getString(R.string.send_success));
                } else {
                    this.f1914a.a(rVar.b());
                }
                this.f1914a.setResult(-1);
                this.f1914a.finish();
            } else {
                a(this.c.e(), this.c.g());
            }
        }
        super.a((Object) str);
    }
}
