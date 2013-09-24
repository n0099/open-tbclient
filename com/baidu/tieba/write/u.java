package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bj;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Integer, Integer, bj> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f2128a;
    private WriteData b;
    private com.baidu.tieba.util.z c = null;
    private String d = null;

    public u(VcodeActivity vcodeActivity, WriteData writeData) {
        this.f2128a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bj a(Integer... numArr) {
        EditText editText;
        Address aK;
        this.c = new com.baidu.tieba.util.z();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String str = "";
        if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
        }
        this.c.a("new_vcode", "1");
        this.c.a("content", String.valueOf(this.b.getContent()) + str);
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.f2128a.e;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.e(true);
        if (this.b.getVoice() != null) {
            this.c.a("voice_md5", this.b.getVoice());
            this.c.a("during_time", String.valueOf(this.b.getVoiceDuringTime()));
        }
        if (this.b.getType() == 0) {
            this.c.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/thread/add");
            this.c.a("title", this.b.getTitle());
            if (!com.baidu.tieba.data.g.h().equals(this.f2128a.getIntent().getStringExtra("forum_id")) && TiebaApplication.g().t() && (aK = TiebaApplication.g().aK()) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(aK.getLatitude())) + "," + String.valueOf(aK.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.f2128a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
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
        this.f2128a.g = null;
        this.f2128a.i();
        if (this.c != null) {
            this.c.h();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bj bjVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        this.f2128a.i();
        this.f2128a.g = null;
        if (this.c != null) {
            if (this.c.c()) {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.d);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    this.f2128a.a(TiebaApplication.g().getString(R.string.send_success));
                } else {
                    this.f2128a.a(rVar.b());
                }
                this.f2128a.setResult(-1, this.f2128a.getIntent());
                this.f2128a.finish();
            } else {
                if (this.c.e() == 5 || this.c.e() == 6) {
                    bj bjVar2 = new bj();
                    bjVar2.a(this.d);
                    if (bjVar2.b() != null) {
                        writeData = this.f2128a.f2074a;
                        writeData.setVcodeMD5(bjVar2.a());
                        writeData2 = this.f2128a.f2074a;
                        writeData2.setVcodeUrl(bjVar2.b());
                        VcodeActivity vcodeActivity = this.f2128a;
                        writeData3 = this.f2128a.f2074a;
                        vcodeActivity.c(writeData3.getVcodeUrl());
                    }
                    editText = this.f2128a.e;
                    editText.setText((CharSequence) null);
                }
                this.f2128a.a(this.c.g());
            }
        }
        super.a((u) bjVar);
    }
}
