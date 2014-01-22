package com.baidu.tieba.write;

import android.location.Address;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bf;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends BdAsyncTask<Integer, Integer, String> {
    final /* synthetic */ WriteActivity a;
    private WriteData b;
    private com.baidu.tieba.util.ax c = null;
    private String d = null;
    private com.baidu.tieba.data.f e = null;
    private com.baidu.tieba.util.o f = null;
    private volatile boolean g = false;

    public am(WriteActivity writeActivity, WriteData writeData) {
        this.a = writeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(Integer... numArr) {
        WriteImagePreview writeImagePreview;
        EditorToolComponetContainer editorToolComponetContainer;
        Address aO;
        com.baidu.tieba.data.e a;
        writeImagePreview = this.a.A;
        if (writeImagePreview.f() && this.b.getBitmapId() == null) {
            this.b.setBitmapId(new com.baidu.tieba.im.model.ag(com.baidu.tieba.util.ad.c("tieba_resized_image"), 0, 0, 0, 0).a(this.g, "WriteActivity.doInBackground"));
        }
        if (!this.g) {
            editorToolComponetContainer = this.a.z;
            VoiceManager.VoiceModel audioData = editorToolComponetContainer.getAudioData();
            if (audioData != null && audioData.voiceId != null) {
                this.e = new com.baidu.tieba.a.a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.util.ad.a(audioData.voiceId, 1));
                if (this.e != null && this.e.b() && (a = this.e.a()) != null) {
                    this.b.setVoice(a.a());
                    this.b.setVoiceDuringTime(audioData.duration);
                    com.baidu.tieba.voice.a.e.a(audioData.voiceId, a.a());
                }
            }
            if (!this.g) {
                this.c = new com.baidu.tieba.util.ax();
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
                if (TiebaApplication.h().ao() < 3) {
                    this.c.a("vcode_tag", "11");
                }
                this.c.a("new_vcode", SocialConstants.TRUE);
                this.c.a(PushConstants.EXTRA_CONTENT, this.b.getContent() + str);
                this.c.e(true);
                if (this.b.getType() == 0) {
                    this.c.a(com.baidu.tieba.data.h.a + "c/c/thread/add");
                    this.c.a("title", this.b.getTitle());
                    if (!com.baidu.tieba.data.h.h().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.h().t() && (aO = TiebaApplication.h().aO()) != null) {
                        this.c.a("lbs", String.valueOf(aO.getLatitude()) + "," + String.valueOf(aO.getLongitude()));
                    }
                } else {
                    this.c.a(com.baidu.tieba.data.h.a + "c/c/post/add");
                    this.c.a("tid", this.b.getThreadId());
                    this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
                    if (this.b.getType() == 2) {
                        this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                        this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
                    }
                }
                this.d = this.c.m();
            }
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.o = null;
        this.a.closeLoadingDialog();
        this.g = true;
        if (this.c != null) {
            this.c.k();
        }
        if (this.f != null) {
            this.f.a();
        }
        super.cancel(true);
    }

    private void a(AntiData antiData, String str) {
        WriteData writeData;
        if (AntiHelper.a(antiData) || AntiHelper.b(antiData) || AntiHelper.c(antiData) || AntiHelper.d(antiData)) {
            writeData = this.a.b;
            antiData.setBlock_forum_name(writeData.getForumName());
            AntiHelper.a(this.a, antiData, AntiHelper.OperationType.REPLY, AntiHelper.PageType.WRITE);
            return;
        }
        this.a.showToast(str);
    }

    private void a(int i, String str, AntiData antiData) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        if (i == 5 || i == 6) {
            bf bfVar = new bf();
            bfVar.a(this.d);
            if (AntiHelper.c(antiData)) {
                a(antiData, str);
                return;
            } else if (bfVar.b() != null) {
                writeData = this.a.b;
                writeData.setVcodeMD5(bfVar.a());
                writeData2 = this.a.b;
                writeData2.setVcodeUrl(bfVar.b());
                if (bfVar.c().equals("4")) {
                    WriteActivity writeActivity = this.a;
                    writeData4 = this.a.b;
                    NewVcodeActivity.a(writeActivity, writeData4, this.a.getIntent().getBooleanExtra("is_ad", false), 12006);
                    return;
                }
                WriteActivity writeActivity2 = this.a;
                writeData3 = this.a.b;
                VcodeActivity.a(writeActivity2, writeData3, this.a.getIntent().getBooleanExtra("is_ad", false), 12006);
                return;
            } else {
                a(antiData, str);
                return;
            }
        }
        a(antiData, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        AntiData antiData;
        WriteData writeData;
        this.a.closeLoadingDialog();
        this.a.o = null;
        try {
            antiData = new AntiData();
            try {
                antiData.parserJson(new JSONObject(str).optJSONObject("anti_stat"));
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            antiData = null;
        }
        if (this.e != null && !this.e.b()) {
            a(this.e.c(), this.e.d(), antiData);
        } else if (this.c != null) {
            if (this.c.d()) {
                writeData = this.a.b;
                DatabaseService.a(writeData);
                ErrorData errorData = new ErrorData();
                errorData.parserJson(this.d);
                if (errorData.getError_msg() == null || errorData.getError_msg().length() <= 0) {
                    this.a.showToast(TiebaApplication.h().getString(R.string.send_success));
                } else {
                    this.a.showToast(errorData.getError_msg());
                }
                this.a.setResult(-1);
                this.a.finish();
            } else {
                a(this.c.f(), this.c.j(), antiData);
            }
        }
        super.a((am) str);
    }
}
