package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    volatile com.baidu.tieba.util.am f2819a;
    com.baidu.tieba.data.bd b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f2819a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(VcodeActivity vcodeActivity, n nVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.c.i = null;
        if (this.f2819a != null) {
            this.f2819a.j();
        }
        this.d = true;
        progressBar = this.c.g;
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
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.f2819a = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/f/anti/vcode");
            com.baidu.tieba.util.am amVar = this.f2819a;
            writeData = this.c.b;
            amVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.am amVar2 = this.f2819a;
            writeData2 = this.c.b;
            amVar2.a("kw", writeData2.getForumName());
            this.f2819a.a("new_vcode", SocialConstants.TRUE);
            com.baidu.tieba.util.am amVar3 = this.f2819a;
            writeData3 = this.c.b;
            amVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.am amVar4 = this.f2819a;
            writeData4 = this.c.b;
            amVar4.a("content", writeData4.getContent());
            writeData5 = this.c.b;
            if (writeData5.getType() == 0) {
                this.f2819a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.f2819a.a("pub_type", "2");
                com.baidu.tieba.util.am amVar5 = this.f2819a;
                writeData6 = this.c.b;
                amVar5.a("tid", writeData6.getThreadId());
            }
            String l = this.f2819a.l();
            if (!this.f2819a.c()) {
                return null;
            }
            this.b = new com.baidu.tieba.data.bd();
            this.b.a(l);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f2819a = new com.baidu.tieba.util.am(str);
        return com.baidu.tieba.util.m.a(this.f2819a.k());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.c.i = null;
        if (bitmap != null) {
            imageView = this.c.e;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.g;
        progressBar.setVisibility(8);
        if (this.b != null) {
            writeData = this.c.b;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.b;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.a((r) bitmap);
    }
}
