package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ VcodeActivity bTG;
    com.baidu.tbadk.coreExtra.data.g bTH;
    private volatile boolean kJ;
    volatile com.baidu.tbadk.core.util.ac mNetWork;

    private aa(VcodeActivity vcodeActivity) {
        this.bTG = vcodeActivity;
        this.mNetWork = null;
        this.bTH = null;
        this.kJ = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(VcodeActivity vcodeActivity, aa aaVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.bTG.bTF = null;
        if (this.mNetWork != null) {
            this.mNetWork.dM();
        }
        this.kJ = true;
        progressBar = this.bTG.mProgressBar;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
    public Bitmap doInBackground(String... strArr) {
        WriteData writeData;
        WriteData writeData2;
        WriteData writeData3;
        WriteData writeData4;
        WriteData writeData5;
        WriteData writeData6;
        String str = strArr[0];
        if (str == null || str.length() <= 0) {
            this.mNetWork = new com.baidu.tbadk.core.util.ac(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.ac acVar = this.mNetWork;
            writeData = this.bTG.bTq;
            acVar.k(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.ac acVar2 = this.mNetWork;
            writeData2 = this.bTG.bTq;
            acVar2.k("kw", writeData2.getForumName());
            this.mNetWork.k("new_vcode", "1");
            com.baidu.tbadk.core.util.ac acVar3 = this.mNetWork;
            writeData3 = this.bTG.bTq;
            acVar3.k("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.ac acVar4 = this.mNetWork;
            writeData4 = this.bTG.bTq;
            acVar4.k("content", writeData4.getContent());
            writeData5 = this.bTG.bTq;
            if (writeData5.getType() == 0) {
                this.mNetWork.k("pub_type", "1");
            } else {
                this.mNetWork.k("pub_type", TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT);
                com.baidu.tbadk.core.util.ac acVar5 = this.mNetWork;
                writeData6 = this.bTG.bTq;
                acVar5.k("tid", writeData6.getThreadId());
            }
            String lA = this.mNetWork.lA();
            if (!this.mNetWork.mc().nb().jq()) {
                return null;
            }
            this.bTH = new com.baidu.tbadk.coreExtra.data.g();
            this.bTH.parserJson(lA);
            str = this.bTH.getVcode_pic_url();
        }
        if (this.kJ) {
            return null;
        }
        this.mNetWork = new com.baidu.tbadk.core.util.ac(str);
        return com.baidu.tbadk.core.util.d.w(this.mNetWork.lB());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.bTG.bTF = null;
        if (bitmap != null) {
            imageView = this.bTG.acK;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.bTG.mProgressBar;
        progressBar.setVisibility(8);
        if (this.bTH != null) {
            writeData = this.bTG.bTq;
            writeData.setVcodeMD5(this.bTH.getVcode_md5());
            writeData2 = this.bTG.bTq;
            writeData2.setVcodeUrl(this.bTH.getVcode_pic_url());
        }
        super.onPostExecute(bitmap);
    }
}
