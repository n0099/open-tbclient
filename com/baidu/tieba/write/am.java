package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tieba.util.ba a;
    com.baidu.tieba.data.bd b;
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
            this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/f/anti/vcode");
            com.baidu.tieba.util.ba baVar = this.a;
            writeData = this.c.b;
            baVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.ba baVar2 = this.a;
            writeData2 = this.c.b;
            baVar2.a("kw", writeData2.getForumName());
            this.a.a("new_vcode", SocialConstants.TRUE);
            com.baidu.tieba.util.ba baVar3 = this.a;
            writeData3 = this.c.b;
            baVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.ba baVar4 = this.a;
            writeData4 = this.c.b;
            baVar4.a(PushConstants.EXTRA_CONTENT, writeData4.getContent());
            writeData5 = this.c.b;
            if (writeData5.getType() == 0) {
                this.a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tieba.util.ba baVar5 = this.a;
                writeData6 = this.c.b;
                baVar5.a("tid", writeData6.getThreadId());
            }
            String l = this.a.l();
            if (!this.a.c()) {
                return null;
            }
            this.b = new com.baidu.tieba.data.bd();
            this.b.a(l);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.a = new com.baidu.tieba.util.ba(str);
        return com.baidu.tieba.util.n.a(this.a.k());
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
        super.a((am) bitmap2);
    }

    private am(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ am(VcodeActivity vcodeActivity, byte b) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.c.h = null;
        if (this.a != null) {
            this.a.j();
        }
        this.d = true;
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
