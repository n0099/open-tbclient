package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    volatile com.baidu.tieba.util.v f1942a;
    bj b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f1942a = null;
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
        if (this.f1942a != null) {
            this.f1942a.h();
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
            this.f1942a = new com.baidu.tieba.util.v(String.valueOf(com.baidu.tieba.data.g.f1014a) + "c/f/anti/vcode");
            com.baidu.tieba.util.v vVar = this.f1942a;
            writeData = this.c.f1896a;
            vVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.v vVar2 = this.f1942a;
            writeData2 = this.c.f1896a;
            vVar2.a("kw", writeData2.getForumName());
            this.f1942a.a("new_vcode", "1");
            com.baidu.tieba.util.v vVar3 = this.f1942a;
            writeData3 = this.c.f1896a;
            vVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.v vVar4 = this.f1942a;
            writeData4 = this.c.f1896a;
            vVar4.a("content", writeData4.getContent());
            writeData5 = this.c.f1896a;
            if (writeData5.getType() == 0) {
                this.f1942a.a("pub_type", "1");
            } else {
                this.f1942a.a("pub_type", "2");
                com.baidu.tieba.util.v vVar5 = this.f1942a;
                writeData6 = this.c.f1896a;
                vVar5.a("tid", writeData6.getThreadId());
            }
            String j = this.f1942a.j();
            if (!this.f1942a.c()) {
                return null;
            }
            this.b = new bj();
            this.b.a(j);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f1942a = new com.baidu.tieba.util.v(str);
        return com.baidu.tieba.util.e.a(this.f1942a.i());
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
            writeData = this.c.f1896a;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.f1896a;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.a((Object) bitmap);
    }
}
