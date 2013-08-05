package com.baidu.tieba.write;

import android.location.Address;
import android.widget.EditText;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bq;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ VcodeActivity f1914a;
    private WriteData b;
    private com.baidu.tieba.util.u c = null;
    private String d = null;

    public s(VcodeActivity vcodeActivity, WriteData writeData) {
        this.f1914a = vcodeActivity;
        this.b = null;
        this.b = writeData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bq a(Integer... numArr) {
        EditText editText;
        Address aT;
        this.c = new com.baidu.tieba.util.u();
        this.c.a("anonymous", "0");
        this.c.a("fid", this.b.getForumId());
        this.c.a("kw", this.b.getForumName());
        String str = "";
        if (this.b.getBitmapId() != null && this.b.getBitmapId().getPic_id() != null && this.b.getBitmapId().getPic_id().length() > 0) {
            str = String.format("#(pic,%s,%d,%d)", this.b.getBitmapId().getPic_id(), Integer.valueOf(this.b.getBitmapId().getWidth()), Integer.valueOf(this.b.getBitmapId().getHeight()));
        }
        this.c.a("content", String.valueOf(this.b.getContent()) + str);
        this.c.a("vcode_md5", this.b.getVcodeMD5());
        editText = this.f1914a.e;
        String editable = editText.getText().toString();
        if (editable.length() > 0) {
            this.c.a("vcode", editable);
        }
        this.c.e(true);
        if (this.b.getType() == 0) {
            this.c.a(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/thread/add");
            if (this.b.getType() == 0) {
                this.c.a("title", this.b.getTitle());
            } else {
                this.c.a("thread_type", WriteData.THREAD_TYPE_LBS);
                this.c.a("st_type", "tb_suishoufa");
            }
            if (!com.baidu.tieba.data.g.g().equals(this.f1914a.getIntent().getStringExtra("forum_id")) && TiebaApplication.f().u() && (aT = TiebaApplication.f().aT()) != null) {
                this.c.a("lbs", String.valueOf(String.valueOf(aT.getLatitude())) + "," + String.valueOf(aT.getLongitude()));
            }
        } else {
            this.c.a(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/c/post/add");
            this.c.a("tid", this.b.getThreadId());
            this.c.a("is_ad", this.f1914a.getIntent().getBooleanExtra("is_ad", false) ? "1" : "0");
            if (this.b.getType() == 2) {
                this.c.a("quote_id", String.valueOf(this.b.getFloor()));
                this.c.a("floor_num", String.valueOf(this.b.getFloorNum()));
            }
        }
        this.d = this.c.k();
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.f1914a.g = null;
        this.f1914a.h();
        if (this.c != null) {
            this.c.i();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bq bqVar) {
        EditText editText;
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        this.f1914a.h();
        this.f1914a.g = null;
        if (this.c != null) {
            if (this.c.d()) {
                com.baidu.tieba.data.r rVar = new com.baidu.tieba.data.r();
                rVar.b(this.d);
                if (rVar.b() == null || rVar.b().length() <= 0) {
                    this.f1914a.a(TiebaApplication.f().getString(R.string.send_success));
                } else {
                    this.f1914a.a(rVar.b());
                }
                this.f1914a.setResult(-1, this.f1914a.getIntent());
                this.f1914a.finish();
            } else {
                if (this.c.f() == 5 || this.c.f() == 6) {
                    bq bqVar2 = new bq();
                    bqVar2.a(this.d);
                    if (bqVar2.b() != null) {
                        writeData = this.f1914a.f1867a;
                        writeData.setVcodeMD5(bqVar2.a());
                        writeData2 = this.f1914a.f1867a;
                        writeData2.setVcodeUrl(bqVar2.b());
                        VcodeActivity vcodeActivity = this.f1914a;
                        writeData3 = this.f1914a.f1867a;
                        vcodeActivity.c(writeData3.getVcodeUrl());
                    }
                    editText = this.f1914a.e;
                    editText.setText((CharSequence) null);
                }
                this.f1914a.a(this.c.h());
            }
        }
        super.a((Object) bqVar);
    }
}
