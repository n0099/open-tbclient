package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tieba.util.ax a;
    bf b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.a = null;
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
        if (this.a != null) {
            this.a.k();
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
            this.a = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/f/anti/vcode");
            com.baidu.tieba.util.ax axVar = this.a;
            writeData = this.c.b;
            axVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.ax axVar2 = this.a;
            writeData2 = this.c.b;
            axVar2.a("kw", writeData2.getForumName());
            this.a.a("new_vcode", SocialConstants.TRUE);
            com.baidu.tieba.util.ax axVar3 = this.a;
            writeData3 = this.c.b;
            axVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.ax axVar4 = this.a;
            writeData4 = this.c.b;
            axVar4.a(PushConstants.EXTRA_CONTENT, writeData4.getContent());
            writeData5 = this.c.b;
            if (writeData5.getType() == 0) {
                this.a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.a.a("pub_type", "2");
                com.baidu.tieba.util.ax axVar5 = this.a;
                writeData6 = this.c.b;
                axVar5.a("tid", writeData6.getThreadId());
            }
            String m = this.a.m();
            if (!this.a.d()) {
                return null;
            }
            this.b = new bf();
            this.b.a(m);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.a = new com.baidu.tieba.util.ax(str);
        return com.baidu.tieba.util.n.a(this.a.l());
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
