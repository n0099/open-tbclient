package com.baidu.tieba.write;

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
public class aa extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tbadk.core.util.ad AR;
    final /* synthetic */ VcodeActivity ceN;
    com.baidu.tbadk.coreExtra.data.j ceO;
    private volatile boolean kK;

    private aa(VcodeActivity vcodeActivity) {
        this.ceN = vcodeActivity;
        this.AR = null;
        this.ceO = null;
        this.kK = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(VcodeActivity vcodeActivity, aa aaVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.ceN.ceM = null;
        if (this.AR != null) {
            this.AR.dL();
        }
        this.kK = true;
        progressBar = this.ceN.mProgressBar;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.AR = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.ad adVar = this.AR;
            writeData = this.ceN.cex;
            adVar.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.ad adVar2 = this.AR;
            writeData2 = this.ceN.cex;
            adVar2.o("kw", writeData2.getForumName());
            this.AR.o("new_vcode", "1");
            com.baidu.tbadk.core.util.ad adVar3 = this.AR;
            writeData3 = this.ceN.cex;
            adVar3.o("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.ad adVar4 = this.AR;
            writeData4 = this.ceN.cex;
            adVar4.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData4.getContent());
            writeData5 = this.ceN.cex;
            if (writeData5.getType() == 0) {
                this.AR.o("pub_type", "1");
            } else {
                this.AR.o("pub_type", "2");
                com.baidu.tbadk.core.util.ad adVar5 = this.AR;
                writeData6 = this.ceN.cex;
                adVar5.o("tid", writeData6.getThreadId());
            }
            String ov = this.AR.ov();
            if (!this.AR.oW().pW().ma()) {
                return null;
            }
            this.ceO = new com.baidu.tbadk.coreExtra.data.j();
            this.ceO.parserJson(ov);
            str = this.ceO.getVcode_pic_url();
        }
        if (this.kK) {
            return null;
        }
        this.AR = new com.baidu.tbadk.core.util.ad(str);
        return com.baidu.tbadk.core.util.d.v(this.AR.ow());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.ceN.ceM = null;
        if (bitmap != null) {
            imageView = this.ceN.akv;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.ceN.mProgressBar;
        progressBar.setVisibility(8);
        if (this.ceO != null) {
            writeData = this.ceN.cex;
            writeData.setVcodeMD5(this.ceO.getVcode_md5());
            writeData2 = this.ceN.cex;
            writeData2.setVcodeUrl(this.ceO.getVcode_pic_url());
        }
        super.onPostExecute((aa) bitmap);
    }
}
