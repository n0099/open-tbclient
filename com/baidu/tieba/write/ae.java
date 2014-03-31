package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tbadk.core.util.ak a;
    com.baidu.tbadk.coreExtra.data.f b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(String... strArr) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.a = new com.baidu.tbadk.core.util.ak(String.valueOf(com.baidu.tbadk.core.data.n.a) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.ak akVar = this.a;
            writeData = this.c.b;
            akVar.a("fid", writeData.getForumId());
            com.baidu.tbadk.core.util.ak akVar2 = this.a;
            writeData2 = this.c.b;
            akVar2.a("kw", writeData2.getForumName());
            this.a.a("new_vcode", "1");
            com.baidu.tbadk.core.util.ak akVar3 = this.a;
            writeData3 = this.c.b;
            akVar3.a("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.ak akVar4 = this.a;
            writeData4 = this.c.b;
            akVar4.a("content", writeData4.getContent());
            writeData5 = this.c.b;
            if (writeData5.getType() == 0) {
                this.a.a("pub_type", "1");
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tbadk.core.util.ak akVar5 = this.a;
                writeData6 = this.c.b;
                akVar5.a("tid", writeData6.getThreadId());
            }
            String i = this.a.i();
            if (!this.a.a().b().b()) {
                return null;
            }
            this.b = new com.baidu.tbadk.coreExtra.data.f();
            this.b.a(i);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.a = new com.baidu.tbadk.core.util.ak(str);
        return com.baidu.tbadk.core.util.g.a(this.a.h());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        Bitmap bitmap2 = bitmap;
        this.c.h = null;
        if (bitmap2 != null) {
            imageView = this.c.d;
            imageView.setImageBitmap(bitmap2);
        }
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            writeData = this.c.b;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.b;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.a((ae) bitmap2);
    }

    private ae(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(VcodeActivity vcodeActivity, byte b) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.c.h = null;
        if (this.a != null) {
            this.a.g();
        }
        this.d = true;
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
