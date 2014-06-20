package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tbadk.core.util.an a;
    com.baidu.tbadk.coreExtra.data.f b;
    final /* synthetic */ VcodeActivity c;
    private volatile boolean d;

    private ae(VcodeActivity vcodeActivity) {
        this.c = vcodeActivity;
        this.a = null;
        this.b = null;
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ae(VcodeActivity vcodeActivity, ae aeVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.a = new com.baidu.tbadk.core.util.an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.an anVar = this.a;
            writeData = this.c.b;
            anVar.a("fid", writeData.getForumId());
            com.baidu.tbadk.core.util.an anVar2 = this.a;
            writeData2 = this.c.b;
            anVar2.a("kw", writeData2.getForumName());
            this.a.a("new_vcode", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            com.baidu.tbadk.core.util.an anVar3 = this.a;
            writeData3 = this.c.b;
            anVar3.a("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.an anVar4 = this.a;
            writeData4 = this.c.b;
            anVar4.a("content", writeData4.getContent());
            writeData5 = this.c.b;
            if (writeData5.getType() == 0) {
                this.a.a("pub_type", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            } else {
                this.a.a("pub_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                com.baidu.tbadk.core.util.an anVar5 = this.a;
                writeData6 = this.c.b;
                anVar5.a("tid", writeData6.getThreadId());
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
        this.a = new com.baidu.tbadk.core.util.an(str);
        return com.baidu.tbadk.core.util.g.a(this.a.h());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.c.h = null;
        if (bitmap != null) {
            imageView = this.c.d;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.c.f;
        progressBar.setVisibility(8);
        if (this.b != null) {
            writeData = this.c.b;
            writeData.setVcodeMD5(this.b.a());
            writeData2 = this.c.b;
            writeData2.setVcodeUrl(this.b.b());
        }
        super.onPostExecute(bitmap);
    }
}
