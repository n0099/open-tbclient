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
    volatile com.baidu.tieba.util.ap f2701a;
    com.baidu.tieba.data.bd b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private r(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f2701a = null;
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
        if (this.f2701a != null) {
            this.f2701a.h();
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
            this.f2701a = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/f/anti/vcode");
            com.baidu.tieba.util.ap apVar = this.f2701a;
            writeData = this.c.b;
            apVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.ap apVar2 = this.f2701a;
            writeData2 = this.c.b;
            apVar2.a("kw", writeData2.getForumName());
            this.f2701a.a("new_vcode", SocialConstants.TRUE);
            com.baidu.tieba.util.ap apVar3 = this.f2701a;
            writeData3 = this.c.b;
            apVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.ap apVar4 = this.f2701a;
            writeData4 = this.c.b;
            apVar4.a("content", writeData4.getContent());
            writeData5 = this.c.b;
            if (writeData5.getType() == 0) {
                this.f2701a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.f2701a.a("pub_type", "2");
                com.baidu.tieba.util.ap apVar5 = this.f2701a;
                writeData6 = this.c.b;
                apVar5.a("tid", writeData6.getThreadId());
            }
            String j = this.f2701a.j();
            if (!this.f2701a.c()) {
                return null;
            }
            this.b = new com.baidu.tieba.data.bd();
            this.b.a(j);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f2701a = new com.baidu.tieba.util.ap(str);
        return com.baidu.tieba.util.m.a(this.f2701a.i());
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
