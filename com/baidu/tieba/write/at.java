package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.location.Address;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bj;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.slidingmenu.lib.R;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2097a;
    private WriteData b;
    private com.baidu.tieba.util.z c = null;
    private String d = null;
    private com.baidu.tieba.data.e e = null;
    private com.baidu.tieba.util.f f = null;
    private volatile boolean g = false;

    public at(WriteActivity writeActivity, WriteData writeData) {
        this.f2097a = writeActivity;
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
        RecordVoiceBnt recordVoiceBnt;
        Address aK;
        com.baidu.tieba.data.d a2;
        File c;
        WriteData writeData;
        String b;
        com.baidu.tieba.data.d dVar;
        WriteData writeData2;
        bitmap = this.f2097a.B;
        if (bitmap != null && this.b.getBitmapId() == null) {
            com.baidu.tieba.util.av.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                c = com.baidu.tieba.util.p.c("tieba_resized_image");
                this.c = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (c.length() <= 102400 || (com.baidu.tieba.data.g.n() == 0 && this.c.f() != null && !this.c.f().equals("2"))) {
                com.baidu.tieba.util.av.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.util.z zVar = this.c;
                writeData = this.f2097a.f2075a;
                zVar.a("pic_type", String.valueOf(writeData.getPicType()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.util.av.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a3 = com.baidu.tieba.util.at.a(com.baidu.tieba.util.p.a(c));
                com.baidu.tieba.data.d o = DatabaseService.o(a3);
                if (o == null) {
                    com.baidu.tieba.util.av.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.data.d dVar2 = new com.baidu.tieba.data.d();
                    dVar2.a(a3);
                    dVar2.a(0);
                    dVar2.a(c.length());
                    dVar = dVar2;
                } else {
                    dVar = o;
                }
                this.f = new com.baidu.tieba.util.f("tieba_resized_image", dVar, String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.b()) {
                    this.c = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/img/finupload");
                    this.c.a("md5", dVar.a());
                    com.baidu.tieba.util.z zVar2 = this.c;
                    writeData2 = this.f2097a.f2075a;
                    zVar2.a("pic_type", String.valueOf(writeData2.getPicType()));
                    b = this.c.j();
                    if (b == null || !this.c.c()) {
                        long b2 = dVar.b();
                        dVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        DatabaseService.a(dVar);
                    } else {
                        DatabaseService.n(a3);
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
            recordVoiceBnt = this.f2097a.N;
            com.baidu.tieba.voice.ai voiceModel = recordVoiceBnt.getVoiceModel();
            if (voiceModel != null && voiceModel.b != null) {
                this.e = new com.baidu.tieba.a.a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.voice.a.e.a(voiceModel.b));
                if (this.e != null && this.e.b() && (a2 = this.e.a()) != null) {
                    this.b.setVoice(a2.a());
                    this.b.setVoiceDuringTime(voiceModel.d);
                    com.baidu.tieba.voice.a.e.a(voiceModel.b, a2.a());
                }
            }
            if (!this.g) {
                this.c = new com.baidu.tieba.util.z();
                this.c.a("anonymous", "0");
                this.c.a("fid", this.b.getForumId());
                this.c.a("kw", this.b.getForumName());
                if (this.b.getVoice() != null) {
                    this.c.a("voice_md5", this.b.getVoice());
                    this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
                }
                String str = "";
                if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
                    str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
                }
                if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
                    this.c.a("vcode", this.b.getVcode());
                }
                if (TiebaApplication.g().as() < 3) {
                    this.c.a("vcode_tag", "11");
                }
                this.c.a("new_vcode", "1");
                this.c.a("content", String.valueOf(this.b.getContent()) + str);
                this.c.e(true);
                if (this.b.getType() == 0) {
                    this.c.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/thread/add");
                    this.c.a("title", this.b.getTitle());
                    if (!com.baidu.tieba.data.g.h().equals(this.f2097a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (aK = TiebaApplication.g().aK()) != null) {
                        this.c.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
                    }
                } else {
                    this.c.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/add");
                    this.c.a("tid", this.b.getThreadId());
                    this.c.a("is_ad", this.f2097a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
                    if (this.b.getType() == 2) {
                        this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                    }
                }
                this.d = this.c.j();
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2097a.y = null;
        this.f2097a.i();
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
                writeData = this.f2097a.f2075a;
                writeData.setVcodeMD5(bjVar.a());
                writeData2 = this.f2097a.f2075a;
                writeData2.setVcodeUrl(bjVar.b());
                if (bjVar.c().equals("4")) {
                    WriteActivity writeActivity = this.f2097a;
                    writeData4 = this.f2097a.f2075a;
                    NewVcodeActivity.a(writeActivity, writeData4, this.f2097a.getIntent().getBooleanExtra("is_ad", false), 12006);
                    return;
                }
                WriteActivity writeActivity2 = this.f2097a;
                writeData3 = this.f2097a.f2075a;
                VcodeActivity.a(writeActivity2, writeData3, this.f2097a.getIntent().getBooleanExtra("is_ad", false), 12006);
                return;
            }
            this.f2097a.a(str);
            return;
        }
        this.f2097a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        WriteData writeData;
        this.f2097a.i();
        this.f2097a.y = null;
        if (this.e != null && !this.e.b()) {
            a(this.e.c(), this.e.d());
        } else if (this.c != null) {
            if (this.c.c()) {
                writeData = this.f2097a.f2075a;
                DatabaseService.a(writeData);
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.d);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    this.f2097a.a(TiebaApplication.g().getString(R.string.send_success));
                } else {
                    this.f2097a.a(rVar.b());
                }
                this.f2097a.setResult(-1);
                this.f2097a.finish();
            } else {
                a(this.c.e(), this.c.g());
            }
        }
        super.a((at) str);
    }
}
