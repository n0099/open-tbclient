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
    volatile com.baidu.tbadk.core.util.ad AO;
    final /* synthetic */ VcodeActivity cgl;
    com.baidu.tbadk.coreExtra.data.j cgm;
    private volatile boolean kN;

    private aa(VcodeActivity vcodeActivity) {
        this.cgl = vcodeActivity;
        this.AO = null;
        this.cgm = null;
        this.kN = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(VcodeActivity vcodeActivity, aa aaVar) {
        this(vcodeActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.cgl.cgk = null;
        if (this.AO != null) {
            this.AO.dJ();
        }
        this.kN = true;
        progressBar = this.cgl.mProgressBar;
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
            this.AO = new com.baidu.tbadk.core.util.ad(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            com.baidu.tbadk.core.util.ad adVar = this.AO;
            writeData = this.cgl.cfV;
            adVar.o(ImageViewerConfig.FORUM_ID, writeData.getForumId());
            com.baidu.tbadk.core.util.ad adVar2 = this.AO;
            writeData2 = this.cgl.cfV;
            adVar2.o("kw", writeData2.getForumName());
            this.AO.o("new_vcode", "1");
            com.baidu.tbadk.core.util.ad adVar3 = this.AO;
            writeData3 = this.cgl.cfV;
            adVar3.o("title", writeData3.getTitle());
            com.baidu.tbadk.core.util.ad adVar4 = this.AO;
            writeData4 = this.cgl.cfV;
            adVar4.o(CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, writeData4.getContent());
            writeData5 = this.cgl.cfV;
            if (writeData5.getType() == 0) {
                this.AO.o("pub_type", "1");
            } else {
                this.AO.o("pub_type", "2");
                com.baidu.tbadk.core.util.ad adVar5 = this.AO;
                writeData6 = this.cgl.cfV;
                adVar5.o("tid", writeData6.getThreadId());
            }
            String or = this.AO.or();
            if (!this.AO.oS().qa().lT()) {
                return null;
            }
            this.cgm = new com.baidu.tbadk.coreExtra.data.j();
            this.cgm.parserJson(or);
            str = this.cgm.getVcode_pic_url();
        }
        if (this.kN) {
            return null;
        }
        this.AO = new com.baidu.tbadk.core.util.ad(str);
        return com.baidu.tbadk.core.util.d.v(this.AO.os());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        WriteData writeData;
        WriteData writeData2;
        ImageView imageView;
        this.cgl.cgk = null;
        if (bitmap != null) {
            imageView = this.cgl.ano;
            imageView.setImageBitmap(bitmap);
        }
        progressBar = this.cgl.mProgressBar;
        progressBar.setVisibility(8);
        if (this.cgm != null) {
            writeData = this.cgl.cfV;
            writeData.setVcodeMD5(this.cgm.getVcode_md5());
            writeData2 = this.cgl.cfV;
            writeData2.setVcodeUrl(this.cgm.getVcode_pic_url());
        }
        super.onPostExecute((aa) bitmap);
    }
}
