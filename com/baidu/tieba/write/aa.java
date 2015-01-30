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
    final /* synthetic */ VcodeActivity cgm;
    com.baidu.tbadk.coreExtra.data.j cgn;
    private volatile boolean kN;

    private aa(VcodeActivity vcodeActivity) {
        this.cgm = vcodeActivity;
        this.AR = null;
        this.cgn = null;
        this.kN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(VcodeActivity vcodeActivity, aa aaVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cgm.cgl = null;
        if (this.AR != null) {
            this.AR.dJ();
        }
        this.kN = true;
        progressBar = this.cgm.mProgressBar;
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
            writeData = this.cgm.cfW;
            adVar.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.ad adVar2 = this.AR;
            writeData2 = this.cgm.cfW;
            adVar2.o("kw", writeData2.getForumName());
            this.AR.o("new_vcode", "1");
            com.baidu.tbadk.core.util.ad adVar3 = this.AR;
            writeData3 = this.cgm.cfW;
            adVar3.o("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.ad adVar4 = this.AR;
            writeData4 = this.cgm.cfW;
            adVar4.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData4.getContent());
            writeData5 = this.cgm.cfW;
            if (writeData5.getType() == 0) {
                this.AR.o("pub_type", "1");
            } else {
                this.AR.o("pub_type", "2");
                com.baidu.tbadk.core.util.ad adVar5 = this.AR;
                writeData6 = this.cgm.cfW;
                adVar5.o("tid", writeData6.getThreadId());
            }
            String oy = this.AR.oy();
            if (!this.AR.oZ().qh().ma()) {
                return null;
            }
            this.cgn = new com.baidu.tbadk.coreExtra.data.j();
            this.cgn.parserJson(oy);
            str = this.cgn.getVcode_pic_url();
        }
        if (this.kN) {
            return null;
        }
        this.AR = new com.baidu.tbadk.core.util.ad(str);
        return com.baidu.tbadk.core.util.d.v(this.AR.oz());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.cgm.cgl = null;
        if (bitmap != null) {
            imageView = this.cgm.anr;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.cgm.mProgressBar;
        progressBar.setVisibility(8);
        if (this.cgn != null) {
            writeData = this.cgm.cfW;
            writeData.setVcodeMD5(this.cgn.getVcode_md5());
            writeData2 = this.cgm.cfW;
            writeData2.setVcodeUrl(this.cgn.getVcode_pic_url());
        }
        super.onPostExecute((aa) bitmap);
    }
}
