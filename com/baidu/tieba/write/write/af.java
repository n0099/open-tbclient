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
    volatile com.baidu.tbadk.core.util.aa Ok;
    final /* synthetic */ VcodeActivity cxP;
    com.baidu.tbadk.coreExtra.data.l cxQ;
    private volatile boolean wb;

    private af(VcodeActivity vcodeActivity) {
        this.cxP = vcodeActivity;
        this.Ok = null;
        this.cxQ = null;
        this.wb = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ af(VcodeActivity vcodeActivity, af afVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cxP.cxO = null;
        if (this.Ok != null) {
            this.Ok.hh();
        }
        this.wb = true;
        progressBar = this.cxP.mProgressBar;
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
            this.Ok = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.aa aaVar = this.Ok;
            writeData = this.cxP.cxz;
            aaVar.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.aa aaVar2 = this.Ok;
            writeData2 = this.cxP.cxz;
            aaVar2.o("kw", writeData2.getForumName());
            this.Ok.o("new_vcode", "1");
            com.baidu.tbadk.core.util.aa aaVar3 = this.Ok;
            writeData3 = this.cxP.cxz;
            aaVar3.o("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.aa aaVar4 = this.Ok;
            writeData4 = this.cxP.cxz;
            aaVar4.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData4.getContent());
            writeData5 = this.cxP.cxz;
            if (writeData5.getType() == 0) {
                this.Ok.o("pub_type", "1");
            } else {
                this.Ok.o("pub_type", "2");
                com.baidu.tbadk.core.util.aa aaVar5 = this.Ok;
                writeData6 = this.cxP.cxz;
                aaVar5.o("tid", writeData6.getThreadId());
            }
            String rO = this.Ok.rO();
            if (!this.Ok.sp().tq().pv()) {
                return null;
            }
            this.cxQ = new com.baidu.tbadk.coreExtra.data.l();
            this.cxQ.parserJson(rO);
            str = this.cxQ.getVcode_pic_url();
        }
        if (this.wb) {
            return null;
        }
        this.Ok = new com.baidu.tbadk.core.util.aa(str);
        return com.baidu.tbadk.core.util.c.w(this.Ok.rP());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.cxP.cxO = null;
        if (bitmap != null) {
            imageView = this.cxP.atD;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.cxP.mProgressBar;
        progressBar.setVisibility(8);
        if (this.cxQ != null) {
            writeData = this.cxP.cxz;
            writeData.setVcodeMD5(this.cxQ.getVcode_md5());
            writeData2 = this.cxP.cxz;
            writeData2.setVcodeUrl(this.cxQ.getVcode_pic_url());
        }
        super.onPostExecute((af) bitmap);
    }
}
