package com.baidu.tieba.write.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tbadk.core.util.aa Oi;
    final /* synthetic */ VcodeActivity cxw;
    com.baidu.tbadk.coreExtra.data.k cxx;
    private volatile boolean wb;

    private af(VcodeActivity vcodeActivity) {
        this.cxw = vcodeActivity;
        this.Oi = null;
        this.cxx = null;
        this.wb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(VcodeActivity vcodeActivity, af afVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cxw.cxv = null;
        if (this.Oi != null) {
            this.Oi.hh();
        }
        this.wb = true;
        progressBar = this.cxw.mProgressBar;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public Bitmap doInBackground(String... strArr) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.Oi = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.aa aaVar = this.Oi;
            writeData = this.cxw.cxg;
            aaVar.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.aa aaVar2 = this.Oi;
            writeData2 = this.cxw.cxg;
            aaVar2.o("kw", writeData2.getForumName());
            this.Oi.o("new_vcode", "1");
            com.baidu.tbadk.core.util.aa aaVar3 = this.Oi;
            writeData3 = this.cxw.cxg;
            aaVar3.o("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.aa aaVar4 = this.Oi;
            writeData4 = this.cxw.cxg;
            aaVar4.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData4.getContent());
            writeData5 = this.cxw.cxg;
            if (writeData5.getType() == 0) {
                this.Oi.o("pub_type", "1");
            } else {
                this.Oi.o("pub_type", "2");
                com.baidu.tbadk.core.util.aa aaVar5 = this.Oi;
                writeData6 = this.cxw.cxg;
                aaVar5.o("tid", writeData6.getThreadId());
            }
            String rO = this.Oi.rO();
            if (!this.Oi.sp().tq().pv()) {
                return null;
            }
            this.cxx = new com.baidu.tbadk.coreExtra.data.k();
            this.cxx.parserJson(rO);
            str = this.cxx.getVcode_pic_url();
        }
        if (this.wb) {
            return null;
        }
        this.Oi = new com.baidu.tbadk.core.util.aa(str);
        return com.baidu.tbadk.core.util.c.w(this.Oi.rP());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.cxw.cxv = null;
        if (bitmap != null) {
            imageView = this.cxw.atv;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.cxw.mProgressBar;
        progressBar.setVisibility(8);
        if (this.cxx != null) {
            writeData = this.cxw.cxg;
            writeData.setVcodeMD5(this.cxx.getVcode_md5());
            writeData2 = this.cxw.cxg;
            writeData2.setVcodeUrl(this.cxx.getVcode_pic_url());
        }
        super.onPostExecute((af) bitmap);
    }
}
