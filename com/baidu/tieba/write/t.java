package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    volatile com.baidu.tieba.util.z f2127a;
    bj b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private t(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f2127a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t(VcodeActivity vcodeActivity, t tVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.c.j = null;
        if (this.f2127a != null) {
            this.f2127a.h();
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
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.f2127a = new com.baidu.tieba.util.z(String.valueOf(com.baidu.tieba.data.g.f1032a) + "c/f/anti/vcode");
            com.baidu.tieba.util.z zVar = this.f2127a;
            writeData = this.c.f2074a;
            zVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.z zVar2 = this.f2127a;
            writeData2 = this.c.f2074a;
            zVar2.a("kw", writeData2.getForumName());
            this.f2127a.a("new_vcode", "1");
            com.baidu.tieba.util.z zVar3 = this.f2127a;
            writeData3 = this.c.f2074a;
            zVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.z zVar4 = this.f2127a;
            writeData4 = this.c.f2074a;
            zVar4.a("content", writeData4.getContent());
            writeData5 = this.c.f2074a;
            if (writeData5.getType() == 0) {
                this.f2127a.a("pub_type", "1");
            } else {
                this.f2127a.a("pub_type", "2");
                com.baidu.tieba.util.z zVar5 = this.f2127a;
                writeData6 = this.c.f2074a;
                zVar5.a("tid", writeData6.getThreadId());
            }
            String j = this.f2127a.j();
            if (!this.f2127a.c()) {
                return null;
            }
            this.b = new bj();
            this.b.a(j);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f2127a = new com.baidu.tieba.util.z(str);
        return com.baidu.tieba.util.e.a(this.f2127a.i());
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
            writeData = this.c.f2074a;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.f2074a;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.a((t) bitmap);
    }
}
