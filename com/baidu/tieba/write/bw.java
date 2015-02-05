package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.plugins.MotuPlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends BdAsyncTask<String, Void, Bitmap> {
    private Boolean PL;
    private Boolean PM;
    private Bitmap bitmap;
    private String mLabel;
    final /* synthetic */ WriteImageActivity this$0;

    private bw(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
        this.PL = false;
        this.PM = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bw(WriteImageActivity writeImageActivity, bw bwVar) {
        this(writeImageActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        boolean z;
        ProgressBar progressBar;
        View view;
        Handler handler;
        Handler handler2;
        Handler handler3;
        z = this.this$0.PA;
        if (z) {
            PluginPackageManager.PluginStatus bj = PluginPackageManager.hV().bj(PluginCenter.NAME_MOTUSDK);
            if (bj != PluginPackageManager.PluginStatus.NROMAL) {
                if (bj == PluginPackageManager.PluginStatus.DISABLE) {
                    handler3 = this.this$0.mHandler;
                    handler3.postDelayed(new bx(this), 500L);
                    this.this$0.showToast(com.baidu.tieba.z.plugin_config_not_found);
                    return;
                } else if (bj == PluginPackageManager.PluginStatus.UNINSTALLED) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.this$0.getPageContext().getPageActivity(), PluginPackageManager.hV().getPluginConfig(PluginCenter.NAME_MOTUSDK))));
                    handler2 = this.this$0.mHandler;
                    handler2.postDelayed(new by(this), 500L);
                    cancel();
                    return;
                } else if (bj == PluginPackageManager.PluginStatus.FORBIDDEN) {
                    com.baidu.tbadk.coreExtra.util.a.a(this.this$0.getPageContext(), com.baidu.tieba.z.plugin_muto_not_install, new bz(this), new ca(this));
                    handler = this.this$0.mHandler;
                    handler.postDelayed(new cb(this), 500L);
                    cancel();
                    return;
                }
            } else {
                return;
            }
        }
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        view = this.this$0.cgZ;
        view.setEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: n */
    public Bitmap doInBackground(String... strArr) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        MotuPlugin motuPlugin;
        Bitmap bitmap9;
        Bitmap bitmap10;
        Bitmap bitmap11;
        Bitmap bitmap12;
        this.mLabel = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap12 = this.this$0.Pw;
            if (bitmap12 == null) {
                return null;
            }
        }
        if (this.mLabel.equals("0") || this.mLabel.equals("1")) {
            this.PL = true;
        } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.PM = true;
        }
        if (!this.PL.booleanValue() && !this.PM.booleanValue()) {
            bitmap9 = this.this$0.mBitmap;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.this$0.mBitmap;
                bitmap11 = this.this$0.mBitmap;
                this.bitmap = bitmap10.copy(bitmap11.getConfig(), true);
            }
        } else {
            bitmap2 = this.this$0.Pw;
            if (bitmap2 != null) {
                bitmap6 = this.this$0.Pw;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.this$0.Pw;
                    bitmap8 = this.this$0.Pw;
                    this.bitmap = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.this$0.mBitmap;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.this$0.mBitmap;
                bitmap5 = this.this$0.mBitmap;
                this.bitmap = bitmap4.copy(bitmap5.getConfig(), true);
            }
        }
        if (this.bitmap != null) {
            if (this.bitmap.getWidth() > 900 || this.bitmap.getHeight() > 900) {
                this.bitmap = com.baidu.tbadk.core.util.d.d(this.bitmap, TbConfig.POST_IMAGE_BIG);
            }
            if (this.PL.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.d.g(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (this.PM.booleanValue()) {
                this.bitmap = com.baidu.tbadk.core.util.d.i(this.bitmap, Integer.parseInt(this.mLabel));
            } else if (PluginCenter.getInstance().isEnable(PluginCenter.NAME_MOTUSDK) && (motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance()) != null) {
                this.bitmap = motuPlugin.createOneKeyFilterAndApply(this.this$0.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
            }
            return this.bitmap;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        View view;
        Bitmap bitmap;
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            bitmap = this.this$0.Pw;
            if (bitmap != this.bitmap) {
                this.bitmap.recycle();
            }
        }
        this.bitmap = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.cgZ;
        view.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r0.getHeight() > 900) goto L21;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        View view;
        ImageView imageView;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        Bitmap bitmap10;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.cgZ;
        view.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.PE = true;
            imageView = this.this$0.ano;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.this$0.mBitmap;
            if (bitmap2 != null && (this.PL.booleanValue() || this.PM.booleanValue())) {
                bitmap6 = this.this$0.mBitmap;
                if (bitmap6.getWidth() <= 900) {
                    bitmap10 = this.this$0.mBitmap;
                }
                WriteImageActivity writeImageActivity = this.this$0;
                bitmap7 = this.this$0.mBitmap;
                writeImageActivity.mBitmap = com.baidu.tbadk.core.util.d.d(bitmap7, TbConfig.POST_IMAGE_BIG);
                if (this.PL.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.this$0;
                    bitmap9 = this.this$0.mBitmap;
                    writeImageActivity2.mBitmap = com.baidu.tbadk.core.util.d.g(bitmap9, Integer.parseInt(this.mLabel));
                } else if (this.PM.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.this$0;
                    bitmap8 = this.this$0.mBitmap;
                    writeImageActivity3.mBitmap = com.baidu.tbadk.core.util.d.i(bitmap8, Integer.parseInt(this.mLabel));
                }
            }
            bitmap3 = this.this$0.Pw;
            if (bitmap3 != null) {
                bitmap4 = this.this$0.Pw;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.this$0.Pw;
                    bitmap5.recycle();
                }
            }
            this.this$0.Pw = bitmap;
        }
    }
}
