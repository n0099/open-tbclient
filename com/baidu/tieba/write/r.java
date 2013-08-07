package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    volatile com.baidu.tieba.util.u f1911a;
    bq b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f1911a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(VcodeActivity vcodeActivity, r rVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.c.j = null;
        if (this.f1911a != null) {
            this.f1911a.i();
        }
        this.d = true;
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap a(String... strArr) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.f1911a = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1011a) + "c/f/anti/vcode");
            com.baidu.tieba.util.u uVar = this.f1911a;
            writeData = this.c.f1865a;
            uVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.u uVar2 = this.f1911a;
            writeData2 = this.c.f1865a;
            uVar2.a("kw", writeData2.getForumName());
            writeData3 = this.c.f1865a;
            if (writeData3.getType() == 0) {
                this.f1911a.a("pub_type", "1");
            } else {
                this.f1911a.a("pub_type", "2");
                com.baidu.tieba.util.u uVar3 = this.f1911a;
                writeData4 = this.c.f1865a;
                uVar3.a("tid", writeData4.getThreadId());
            }
            String k = this.f1911a.k();
            if (!this.f1911a.d()) {
                return null;
            }
            this.b = new bq();
            this.b.a(k);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f1911a = new com.baidu.tieba.util.u(str);
        return com.baidu.tieba.util.e.a(this.f1911a.j());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.c.j = null;
        if (bitmap != null) {
            imageView = this.c.d;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            writeData = this.c.f1865a;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.f1865a;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.a((Object) bitmap);
    }
}
