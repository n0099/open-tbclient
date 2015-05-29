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
public class ag extends BdAsyncTask<String, Integer, Bitmap> {
    volatile com.baidu.tbadk.core.util.aa OE;
    private volatile boolean ayP;
    final /* synthetic */ VcodeActivity cCh;
    com.baidu.tbadk.coreExtra.data.l cCi;

    private ag(VcodeActivity vcodeActivity) {
        this.cCh = vcodeActivity;
        this.OE = null;
        this.cCi = null;
        this.ayP = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(VcodeActivity vcodeActivity, ag agVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cCh.cCg = null;
        if (this.OE != null) {
            this.OE.gS();
        }
        this.ayP = true;
        progressBar = this.cCh.mProgressBar;
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
            this.OE = new com.baidu.tbadk.core.util.aa(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.aa aaVar = this.OE;
            writeData = this.cCh.cBR;
            aaVar.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.aa aaVar2 = this.OE;
            writeData2 = this.cCh.cBR;
            aaVar2.o("kw", writeData2.getForumName());
            this.OE.o("new_vcode", "1");
            com.baidu.tbadk.core.util.aa aaVar3 = this.OE;
            writeData3 = this.cCh.cBR;
            aaVar3.o("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.aa aaVar4 = this.OE;
            writeData4 = this.cCh.cBR;
            aaVar4.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData4.getContent());
            writeData5 = this.cCh.cBR;
            if (writeData5.getType() == 0) {
                this.OE.o("pub_type", "1");
            } else {
                this.OE.o("pub_type", "2");
                com.baidu.tbadk.core.util.aa aaVar5 = this.OE;
                writeData6 = this.cCh.cBR;
                aaVar5.o("tid", writeData6.getThreadId());
            }
            String sw = this.OE.sw();
            if (!this.OE.sX().tT().qa()) {
                return null;
            }
            this.cCi = new com.baidu.tbadk.coreExtra.data.l();
            this.cCi.parserJson(sw);
            str = this.cCi.getVcode_pic_url();
        }
        if (this.ayP) {
            return null;
        }
        this.OE = new com.baidu.tbadk.core.util.aa(str);
        return com.baidu.tbadk.core.util.c.w(this.OE.sx());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.cCh.cCg = null;
        if (bitmap != null) {
            imageView = this.cCh.avb;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.cCh.mProgressBar;
        progressBar.setVisibility(8);
        if (this.cCi != null) {
            writeData = this.cCh.cBR;
            writeData.setVcodeMD5(this.cCi.getVcode_md5());
            writeData2 = this.cCh.cBR;
            writeData2.setVcodeUrl(this.cCi.getVcode_pic_url());
        }
        super.onPostExecute((ag) bitmap);
    }
}
