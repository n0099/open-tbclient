package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.location.Address;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.InfoData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bh;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.voice.RecordVoiceBnt;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import java.io.File;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends BdAsyncTask<Integer, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WriteActivity f2642a;
    private WriteData b;
    private com.baidu.tieba.util.ag c = null;
    private String d = null;
    private com.baidu.tieba.data.f e = null;
    private com.baidu.tieba.util.f f = null;
    private volatile boolean g = false;

    public au(WriteActivity writeActivity, WriteData writeData) {
        this.f2642a = writeActivity;
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
        Address aP;
        com.baidu.tieba.data.e a2;
        File d;
        WriteData writeData;
        String b;
        com.baidu.tieba.data.e eVar;
        WriteData writeData2;
        bitmap = this.f2642a.B;
        if (bitmap != null && this.b.getBitmapId() == null) {
            com.baidu.tieba.util.be.e("PostThreadTask", "doInBackground", "start upload image");
            try {
                d = com.baidu.tieba.util.w.d("tieba_resized_image");
                this.c = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/img/upload");
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "doInBackground", e.getMessage());
            }
            if (d.length() <= 102400 || (com.baidu.tieba.data.h.n() == 0 && this.c.f() != null && !this.c.f().equals("2"))) {
                com.baidu.tieba.util.be.e("PostThreadTask", "doInBackground", "image size is less than 100K");
                com.baidu.tieba.util.ag agVar = this.c;
                writeData = this.f2642a.f2619a;
                agVar.a("pic_type", String.valueOf(writeData.getPicType()));
                b = this.c.b("tieba_resized_image");
            } else {
                com.baidu.tieba.util.be.e("PostThreadTask", "doInBackground", "image size is more than 100K");
                String a3 = com.baidu.tieba.util.bc.a(com.baidu.tieba.util.w.a(d));
                com.baidu.tieba.data.e o = DatabaseService.o(a3);
                if (o == null) {
                    com.baidu.tieba.util.be.e("PostThreadTask", "doInBackground", "upload data is null");
                    com.baidu.tieba.data.e eVar2 = new com.baidu.tieba.data.e();
                    eVar2.a(a3);
                    eVar2.a(0);
                    eVar2.a(d.length());
                    eVar = eVar2;
                } else {
                    eVar = o;
                }
                this.f = new com.baidu.tieba.util.f("tieba_resized_image", eVar, com.baidu.tieba.data.h.f1165a + "c/c/img/chunkupload");
                this.e = this.f.b();
                if (this.e.b()) {
                    this.c = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/c/img/finupload");
                    this.c.a("md5", eVar.a());
                    com.baidu.tieba.util.ag agVar2 = this.c;
                    writeData2 = this.f2642a.f2619a;
                    agVar2.a("pic_type", String.valueOf(writeData2.getPicType()));
                    b = this.c.j();
                    if (b == null || !this.c.c()) {
                        long b2 = eVar.b();
                        eVar.a((int) (b2 % 102400 == 0 ? b2 / 102400 : (b2 / 102400) + 1));
                        DatabaseService.a(eVar);
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
            recordVoiceBnt = this.f2642a.N;
            VoiceManager.VoiceModel voiceModel = recordVoiceBnt.getVoiceModel();
            if (voiceModel != null && voiceModel.voiceId != null) {
                this.e = new com.baidu.tieba.a.a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.voice.a.e.a(voiceModel.voiceId));
                if (this.e != null && this.e.b() && (a2 = this.e.a()) != null) {
                    this.b.setVoice(a2.a());
                    this.b.setVoiceDuringTime(voiceModel.duration);
                    com.baidu.tieba.voice.a.e.a(voiceModel.voiceId, a2.a());
                }
            }
            if (!this.g) {
                this.c = new com.baidu.tieba.util.ag();
                this.c.a("anonymous", SocialConstants.FALSE);
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
                if (TiebaApplication.g().av() < 3) {
                    this.c.a("vcode_tag", "11");
                }
                this.c.a("new_vcode", SocialConstants.TRUE);
                this.c.a("content", this.b.getContent() + str);
                this.c.e(true);
                if (this.b.getType() == 0) {
                    this.c.a(com.baidu.tieba.data.h.f1165a + "c/c/thread/add");
                    this.c.a("title", this.b.getTitle());
                    if (!com.baidu.tieba.data.h.h().equals(this.f2642a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (aP = TiebaApplication.g().aP()) != null) {
                        this.c.a("lbs", String.valueOf(aP.getLatitude()) + "," + String.valueOf(aP.getLongitude()));
                    }
                } else {
                    this.c.a(com.baidu.tieba.data.h.f1165a + "c/c/post/add");
                    this.c.a("tid", this.b.getThreadId());
                    this.c.a("is_ad", this.f2642a.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
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
        this.f2642a.y = null;
        this.f2642a.j();
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
            bh bhVar = new bh();
            bhVar.a(this.d);
            if (bhVar.b() != null) {
                writeData = this.f2642a.f2619a;
                writeData.setVcodeMD5(bhVar.a());
                writeData2 = this.f2642a.f2619a;
                writeData2.setVcodeUrl(bhVar.b());
                if (bhVar.c().equals("4")) {
                    WriteActivity writeActivity = this.f2642a;
                    writeData4 = this.f2642a.f2619a;
                    NewVcodeActivity.a(writeActivity, writeData4, this.f2642a.getIntent().getBooleanExtra("is_ad", false), 12006);
                    return;
                }
                WriteActivity writeActivity2 = this.f2642a;
                writeData3 = this.f2642a.f2619a;
                VcodeActivity.a(writeActivity2, writeData3, this.f2642a.getIntent().getBooleanExtra("is_ad", false), 12006);
                return;
            }
            this.f2642a.a(str);
            return;
        }
        this.f2642a.a(str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        WriteData writeData;
        this.f2642a.j();
        this.f2642a.y = null;
        if (this.e != null && !this.e.b()) {
            a(this.e.c(), this.e.d());
        } else if (this.c != null) {
            if (this.c.c()) {
                writeData = this.f2642a.f2619a;
                DatabaseService.a(writeData);
                com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
                sVar.b(this.d);
                if (sVar.b() == null || sVar.b().length() <= 0) {
                    this.f2642a.a(TiebaApplication.g().getString(R.string.send_success));
                } else {
                    this.f2642a.a(sVar.b());
                }
                this.f2642a.setResult(-1);
                this.f2642a.finish();
            } else {
                a(this.c.e(), this.c.g());
            }
        }
        super.a((au) str);
    }
}
