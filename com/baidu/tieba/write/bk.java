package com.baidu.tieba.write;

import android.location.Address;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AntiData;
import com.baidu.tieba.data.ErrorData;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.editortool.EditorToolComponetContainer;
import com.baidu.tieba.util.AntiHelper;
import com.baidu.tieba.voice.VoiceManager;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk extends BdAsyncTask<Integer, Integer, ai> {
    final /* synthetic */ WriteActivity a;
    private WriteData b;
    private com.baidu.tieba.util.ba c = null;
    private String d = null;
    private com.baidu.tieba.data.g e = null;
    private volatile boolean f = false;
    private com.baidu.tieba.img.h g;

    public bk(WriteActivity writeActivity, WriteData writeData) {
        this.a = writeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ai a(Integer... numArr) {
        EditorToolComponetContainer editorToolComponetContainer;
        EditorToolComponetContainer editorToolComponetContainer2;
        WriteData writeData;
        String error_msg;
        EditorToolComponetContainer editorToolComponetContainer3;
        Address b;
        editorToolComponetContainer = this.a.B;
        if (editorToolComponetContainer.q() && this.b.isHasImages()) {
            if (this.g == null) {
                this.g = new com.baidu.tieba.img.h("WriteActivity.doInBackground");
            }
            this.g.a(this.b.getWriteImagesInfo());
        }
        if (this.f) {
            return null;
        }
        editorToolComponetContainer2 = this.a.B;
        VoiceManager.VoiceModel audioData = editorToolComponetContainer2.getAudioData();
        if (audioData != null && audioData.voiceId != null) {
            this.e = new com.baidu.tieba.b.a("c/c/voice/chunkupload", "c/c/voice/voice_fin_chunk_upload").a(com.baidu.tieba.util.af.a(audioData.voiceId, 1));
            if (this.e == null) {
                return null;
            }
            if (this.e.b() && this.e.a() != null) {
                com.baidu.tieba.data.f a = this.e.a();
                this.b.setVoice(a.a());
                this.b.setVoiceDuringTime(audioData.duration);
                com.baidu.tieba.voice.a.e.a(audioData.voiceId, a.a());
            } else {
                return new ai(this.e.c(), this.e.d(), null);
            }
        }
        if (this.f) {
            return null;
        }
        this.c = new com.baidu.tieba.util.ba();
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        if (this.b.getVoice() != null) {
            this.c.a("voice_md5", this.b.getVoice());
            this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
        }
        String imagesCodeForPost = this.b.getImagesCodeForPost();
        if (this.b.getVcode() != null && this.b.getVcode().length() > 0) {
            this.c.a("vcode", this.b.getVcode());
        }
        if (TiebaApplication.g().ao() < 3) {
            this.c.a("vcode_tag", "11");
        }
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a(PushConstants.EXTRA_CONTENT, String.valueOf(this.b.getContent()) + imagesCodeForPost);
        this.c.e(true);
        if (this.b.getType() == 0) {
            this.c.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            if (!com.baidu.tieba.data.i.s().equals(this.a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (b = com.baidu.adp.lib.c.a.a().b(false)) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(b.getLatitude())) + "," + String.valueOf(b.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tieba.data.i.a) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.a.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
            }
        }
        this.d = this.c.m();
        AntiData antiData = new AntiData();
        if (this.c.d()) {
            writeData = this.a.b;
            af.a(writeData.getForumId(), (WriteData) null);
            ErrorData errorData = new ErrorData();
            errorData.parserJson(this.d);
            if (com.baidu.adp.lib.util.h.b(errorData.getError_msg())) {
                error_msg = TiebaApplication.g().b().getString(R.string.send_success);
            } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
                error_msg = TiebaApplication.g().b().getString(R.string.img_upload_error);
            } else {
                error_msg = errorData.getError_msg();
            }
            editorToolComponetContainer3 = this.a.B;
            if (editorToolComponetContainer3.q() && this.b.isHasImages()) {
                this.b.deleteUploadedTempImages();
            }
            return new ai(errorData.getError_code(), error_msg, antiData);
        } else if (this.b.isHasImages() && com.baidu.adp.lib.util.h.b(String.valueOf(this.b.getContent()) + imagesCodeForPost)) {
            return new ai(this.c.f(), TiebaApplication.g().b().getString(R.string.img_upload_error), antiData);
        } else {
            return new ai(this.c.e() ? this.c.f() : this.c.g(), this.c.j(), antiData);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(ai aiVar) {
        super.a((bk) aiVar);
        this.a.closeLoadingDialog();
        this.a.r = null;
        if (aiVar != null) {
            if (aiVar.c() != 0) {
                a(aiVar.c(), aiVar.d(), aiVar.c);
                return;
            }
            this.a.showToast(aiVar.d());
            this.a.setResult(-1);
            this.a.finish();
        }
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.a.r = null;
        this.a.closeLoadingDialog();
        this.f = true;
        if (this.c != null) {
            this.c.k();
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
            com.baidu.tieba.data.bd bdVar = new com.baidu.tieba.data.bd();
            bdVar.a(this.d);
            if (AntiHelper.c(antiData)) {
                a(antiData, str);
                return;
            } else if (bdVar.b() != null) {
                writeData = this.a.b;
                writeData.setVcodeMD5(bdVar.a());
                writeData2 = this.a.b;
                writeData2.setVcodeUrl(bdVar.b());
                if (bdVar.c().equals("4")) {
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
}
