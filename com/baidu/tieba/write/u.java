package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.data.WriteData;
import com.baidu.tieba.data.bh;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<String, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    volatile com.baidu.tieba.util.ag f2672a;
    bh b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private u(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.f2672a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ u(VcodeActivity vcodeActivity, q qVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.c.j = null;
        if (this.f2672a != null) {
            this.f2672a.h();
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
            this.f2672a = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/f/anti/vcode");
            com.baidu.tieba.util.ag agVar = this.f2672a;
            writeData = this.c.f2618a;
            agVar.a("fid", writeData.getForumId());
            com.baidu.tieba.util.ag agVar2 = this.f2672a;
            writeData2 = this.c.f2618a;
            agVar2.a("kw", writeData2.getForumName());
            this.f2672a.a("new_vcode", SocialConstants.TRUE);
            com.baidu.tieba.util.ag agVar3 = this.f2672a;
            writeData3 = this.c.f2618a;
            agVar3.a("title", writeData3.getTitle());
            com.baidu.tieba.util.ag agVar4 = this.f2672a;
            writeData4 = this.c.f2618a;
            agVar4.a("content", writeData4.getContent());
            writeData5 = this.c.f2618a;
            if (writeData5.getType() == 0) {
                this.f2672a.a("pub_type", SocialConstants.TRUE);
            } else {
                this.f2672a.a("pub_type", "2");
                com.baidu.tieba.util.ag agVar5 = this.f2672a;
                writeData6 = this.c.f2618a;
                agVar5.a("tid", writeData6.getThreadId());
            }
            String j = this.f2672a.j();
            if (!this.f2672a.c()) {
                return null;
            }
            this.b = new bh();
            this.b.a(j);
            str = this.b.b();
        }
        if (this.d) {
            return null;
        }
        this.f2672a = new com.baidu.tieba.util.ag(str);
        return com.baidu.tieba.util.e.a(this.f2672a.i());
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
            writeData = this.c.f2618a;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.f2618a;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.a((u) bitmap);
    }
}
