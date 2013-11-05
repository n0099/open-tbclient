package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bh;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Integer, Integer, bh> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2673a;
    private WriteData b;
    private com.baidu.tieba.util.ag c = null;
    private String d = null;

    public v(VcodeActivity vcodeActivity, WriteData writeData) {
        this.f2673a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bh a(Integer... numArr) {
        EditText editText;
        Address aP;
        this.c = new com.baidu.tieba.util.ag();
        this.c.a("anonymous", SocialConstants.FALSE);
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String str = "";
        if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
        }
        this.c.a("new_vcode", SocialConstants.TRUE);
        this.c.a("content", this.b.getContent() + str);
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.f2673a.e;
        String obj = editText.getText().toString();
        if (obj.length() > 0) {
            this.c.a("vcode", obj);
        }
        this.c.e(true);
        if (this.b.getVoice() != null) {
            this.c.a("voice_md5", this.b.getVoice());
            this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
        }
        if (this.b.getType() == 0) {
            this.c.a(com.baidu.tieba.data.h.f1165a + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            if (!com.baidu.tieba.data.h.h().equals(this.f2673a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (aP = TiebaApplication.g().aP()) != null) {
                this.c.a("lbs", String.valueOf(aP.getLatitude()) + "," + String.valueOf(aP.getLongitude()));
            }
        } else {
            this.c.a(com.baidu.tieba.data.h.f1165a + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.f2673a.getIntent().getBooleanExtra("is_ad", false) ? SocialConstants.TRUE : SocialConstants.FALSE);
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
            }
        }
        this.d = this.c.j();
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f2673a.g = null;
        this.f2673a.j();
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bh bhVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        this.f2673a.j();
        this.f2673a.g = null;
        if (this.c != null) {
            if (this.c.c()) {
                com.baidu.tieba.data.s sVar = new com.baidu.tieba.data.s();
                sVar.b(this.d);
                if (sVar.b() == null || sVar.b().length() <= 0) {
                    this.f2673a.a(TiebaApplication.g().getString(R.string.send_success));
                } else {
                    this.f2673a.a(sVar.b());
                }
                this.f2673a.setResult(-1, this.f2673a.getIntent());
                this.f2673a.finish();
            } else {
                if (this.c.e() == 5 || this.c.e() == 6) {
                    bh bhVar2 = new bh();
                    bhVar2.a(this.d);
                    if (bhVar2.b() != null) {
                        writeData = this.f2673a.f2618a;
                        writeData.setVcodeMD5(bhVar2.a());
                        writeData2 = this.f2673a.f2618a;
                        writeData2.setVcodeUrl(bhVar2.b());
                        VcodeActivity vcodeActivity = this.f2673a;
                        writeData3 = this.f2673a.f2618a;
                        vcodeActivity.c(writeData3.getVcodeUrl());
                    }
                    editText = this.f2673a.e;
                    editText.setText((CharSequence) null);
                }
                this.f2673a.a(this.c.g());
            }
        }
        super.a((v) bhVar);
    }
}
