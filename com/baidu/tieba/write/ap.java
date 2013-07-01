package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.be;
import com.baidu.tieba.model.WriteModel;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f1568a;
    private WriteModel b;
    private com.baidu.tieba.util.r c = null;
    private String d = null;
    private com.baidu.tieba.data.e e = null;
    private com.baidu.tieba.util.e f = null;
    private volatile boolean g = false;

    public ap(WriteActivity writeActivity, WriteModel writeModel) {
        this.f1568a = writeActivity;
        this.b = null;
        this.b = writeModel;
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
        Address aP;
        File c;
        WriteModel writeModel;
        String b;
        com.baidu.tieba.data.d dVar;
        WriteModel writeModel2;
        bitmap = this.f1568a.y;
        if (bitmap != null && this.b.getBitmapId() == null) {
            com.baidu.tieba.util.z.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.util.m.c("tieba_resized_image");
                this.c = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() <= 102400 || (com.baidu.tieba.data.g.m() == 0 && this.c.f() != null && !this.c.f().equals("2"))) {
                com.baidu.tieba.util.z.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.util.r rVar = this.c;
                writeModel = this.f1568a.f1550a;
                rVar.a("pic_type", String.valueOf(writeModel.getPicType()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.util.z.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a2 = com.baidu.tieba.util.y.a(com.baidu.tieba.util.m.a(c));
                com.baidu.tieba.data.d q = DatabaseService.q(a2);
                if (q == null) {
                    com.baidu.tieba.util.z.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                    dVar2.a(a2);
                    dVar2.a(0);
                    dVar2.a(c.length());
                    dVar = dVar2;
                } else {
                    dVar = q;
                }
                this.f = new com.baidu.tieba.util.e("tieba_resized_image", dVar, String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.a()) {
                    this.c = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/img/finupload");
                    this.c.a("md5", dVar.a());
                    com.baidu.tieba.util.r rVar2 = this.c;
                    writeModel2 = this.f1568a.f1550a;
                    rVar2.a("pic_type", String.valueOf(writeModel2.getPicType()));
                    b = this.c.j();
                    if (b == null || !this.c.c()) {
                        long b2 = dVar.b();
                        dVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        DatabaseService.a(dVar);
                    } else {
                        DatabaseService.p(a2);
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
            this.c = new com.baidu.tieba.util.r();
            this.c.a("anonymous", "0");
            this.c.a("fid", this.b.getForumId());
            if (this.b.getType() != 3) {
                this.c.a("kw", this.b.getForumName());
            }
            String str = "";
            if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
                str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
            }
            this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.getContent()) + str);
            if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
                this.c.a("vcode", this.b.getVcode());
            }
            if (TiebaApplication.f().aw() < 3) {
                this.c.a("vcode_tag", "11");
            }
            this.c.d(true);
            if (this.b.getType() == 0 || this.b.getType() == 3) {
                this.c.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/thread/add");
                if (this.b.getType() == 0) {
                    this.c.a("title", this.b.getTitle());
                } else {
                    this.c.a("thread_type", WriteModel.THREAD_TYPE_LBS);
                    this.c.a("st_type", "tb_suishoufa");
                }
                if (!com.baidu.tieba.data.g.g().equals(this.f1568a.getIntent().getStringExtra("forum_id")) && TiebaApplication.f().u() && (aP = TiebaApplication.f().aP()) != null) {
                    this.c.a("lbs", String.valueOf(String.valueOf(aP.getLatitude())) + "," + String.valueOf(aP.getLongitude()));
                }
            } else {
                this.c.a(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/c/post/add");
                this.c.a("tid", this.b.getThreadId());
                this.c.a("is_ad", this.f1568a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
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
        this.f1568a.v = null;
        this.f1568a.h();
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
        WriteModel writeModel;
        WriteModel writeModel2;
        WriteModel writeModel3;
        WriteModel writeModel4;
        if (i == 5 || i == 6) {
            be beVar = new be();
            beVar.a(this.d);
            if (beVar.b() != null) {
                writeModel = this.f1568a.f1550a;
                writeModel.setVcodeMD5(beVar.a());
                writeModel2 = this.f1568a.f1550a;
                writeModel2.setVcodeUrl(beVar.b());
                if (beVar.c().equals("4")) {
                    WriteActivity writeActivity = this.f1568a;
                    writeModel4 = this.f1568a.f1550a;
                    NewVcodeActivity.a(writeActivity, writeModel4, this.f1568a.getIntent().getBooleanExtra("is_ad", false), 1200006);
                    return;
                }
                WriteActivity writeActivity2 = this.f1568a;
                writeModel3 = this.f1568a.f1550a;
                VcodeActivity.a(writeActivity2, writeModel3, this.f1568a.getIntent().getBooleanExtra("is_ad", false), 1200006);
                return;
            }
            this.f1568a.a(str);
            return;
        }
        this.f1568a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        WriteModel writeModel;
        this.f1568a.h();
        this.f1568a.v = null;
        if (this.e != null && !this.e.a()) {
            a(this.e.b(), this.e.c());
        } else if (this.c != null) {
            if (this.c.c()) {
                writeModel = this.f1568a.f1550a;
                DatabaseService.a(writeModel);
                com.baidu.tieba.data.n nVar = new com.baidu.tieba.data.n();
                nVar.b(this.d);
                if (nVar.b() == null || nVar.b().length() <= 0) {
                    this.f1568a.a(TiebaApplication.f().getString(R.string.send_success));
                } else {
                    this.f1568a.a(nVar.b());
                }
                if (this.b.getType() == 4) {
                    Intent intent = new Intent();
                    intent.putExtra("reply_content", this.b.getContent());
                    intent.putExtra("reply_tid", this.b.getThreadId());
                    this.f1568a.setResult(-1, intent);
                } else {
                    this.f1568a.setResult(-1);
                }
                this.f1568a.finish();
            } else {
                a(this.c.e(), this.c.g());
            }
        }
        super.a((Object) str);
    }
}
