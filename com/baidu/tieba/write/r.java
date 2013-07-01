package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.be;
import com.baidu.tieba.model.WriteModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    volatile com.baidu.tieba.util.r f1596a;
    be b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f1596a = null;
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
        if (this.f1596a != null) {
            this.f1596a.h();
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
        WriteModel writeModel;
        WriteModel writeModel2;
        WriteModel writeModel3;
        WriteModel writeModel4;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.f1596a = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/f/anti/vcode");
            com.baidu.tieba.util.r rVar = this.f1596a;
            writeModel = this.c.f1549a;
            rVar.a("fid", writeModel.getForumId());
            com.baidu.tieba.util.r rVar2 = this.f1596a;
            writeModel2 = this.c.f1549a;
            rVar2.a("kw", writeModel2.getForumName());
            writeModel3 = this.c.f1549a;
            if (writeModel3.getType() == 0) {
                this.f1596a.a("pub_type", "1");
            } else {
                this.f1596a.a("pub_type", "2");
                com.baidu.tieba.util.r rVar3 = this.f1596a;
                writeModel4 = this.c.f1549a;
                rVar3.a("tid", writeModel4.getThreadId());
            }
            String j = this.f1596a.j();
            if (!this.f1596a.c()) {
                return null;
            }
            this.b = new be();
            this.b.a(j);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f1596a = new com.baidu.tieba.util.r(str);
        return com.baidu.tieba.util.d.a(this.f1596a.i());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteModel writeModel;
        WriteModel writeModel2;
        ImageView imageView;
        this.c.j = null;
        if (bitmap != null) {
            imageView = this.c.d;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            writeModel = this.c.f1549a;
            writeModel.setVcodeMD5(this.b.a());
            writeModel2 = this.c.f1549a;
            writeModel2.setVcodeUrl(this.b.b());
        }
        super.a((Object) bitmap);
    }
}
