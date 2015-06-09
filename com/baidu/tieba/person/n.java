package com.baidu.tieba.person;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<String, Void, Bitmap> {
    private Boolean bRy;
    private Boolean bRz;
    private Bitmap bitmap;
    private String mLabel;
    final /* synthetic */ EditHeadActivity this$0;

    private n(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
        this.bRy = false;
        this.bRz = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(EditHeadActivity editHeadActivity, n nVar) {
        this(editHeadActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        Handler handler;
        Intent intent;
        Handler handler2;
        ProgressBar progressBar;
        View view;
        PluginPackageManager.PluginStatus bB = PluginPackageManager.lM().bB(PluginCenter.NAME_MOTUSDK);
        if (bB == PluginPackageManager.PluginStatus.NROMAL) {
            progressBar = this.this$0.mProgress;
            progressBar.setVisibility(0);
            view = this.this$0.bRa;
            view.setEnabled(false);
            return;
        }
        try {
            intent = new Intent(this.this$0.getPageContext().getPageActivity(), Class.forName("com.baidu.tieba.plugins.PluginDownloadActivity"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (bB != PluginPackageManager.PluginStatus.DISABLE) {
            handler2 = this.this$0.mHandler;
            handler2.postDelayed(new o(this), 500L);
            return;
        }
        intent.putExtra(PluginDownloadActivityConfig.PLUGIN_CONFIG, PluginPackageManager.lM().getPluginConfig(PluginCenter.NAME_MOTUSDK));
        this.this$0.startActivity(intent);
        cancel();
        handler = this.this$0.mHandler;
        handler.postDelayed(new p(this), 500L);
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
        Bitmap bitmap9;
        this.mLabel = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap9 = this.this$0.bRl;
            if (bitmap9 == null) {
                return null;
            }
        }
        if (this.mLabel.equals(GameInfoData.NOT_FROM_DETAIL) || this.mLabel.equals("1")) {
            this.bRy = true;
        } else if (this.mLabel.equals("2") || this.mLabel.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.bRz = true;
        }
        if (!this.bRy.booleanValue() && !this.bRz.booleanValue()) {
            bitmap7 = this.this$0.mBitmap;
            bitmap8 = this.this$0.mBitmap;
            this.bitmap = bitmap7.copy(bitmap8.getConfig(), true);
        } else {
            bitmap2 = this.this$0.bRl;
            if (bitmap2 == null) {
                bitmap3 = this.this$0.mBitmap;
                bitmap4 = this.this$0.mBitmap;
                this.bitmap = bitmap3.copy(bitmap4.getConfig(), true);
            } else {
                bitmap5 = this.this$0.bRl;
                bitmap6 = this.this$0.bRl;
                this.bitmap = bitmap5.copy(bitmap6.getConfig(), true);
            }
        }
        if (this.bRy.booleanValue()) {
            this.bitmap = com.baidu.tbadk.core.util.c.g(this.bitmap, Integer.parseInt(this.mLabel));
        } else if (this.bRz.booleanValue()) {
            this.bitmap = com.baidu.tbadk.core.util.c.i(this.bitmap, Integer.parseInt(this.mLabel));
        } else {
            MotuPlugin motuPlugin = (MotuPlugin) PluginCenter.getInstance().getMotuClassInstance();
            if (motuPlugin != null) {
                this.bitmap = motuPlugin.createOneKeyFilterAndApply(this.this$0.getPageContext().getPageActivity(), this.mLabel, this.bitmap);
            }
        }
        return this.bitmap;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        View view;
        Bitmap bitmap;
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            bitmap = this.this$0.bRl;
            if (bitmap != this.bitmap) {
                this.bitmap.recycle();
            }
        }
        this.bitmap = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.bRa;
        view.setClickable(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r0.getHeight() > 750) goto L28;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        View view;
        View view2;
        EditHeadsImageView editHeadsImageView;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        Bitmap bitmap7;
        Bitmap bitmap8;
        Bitmap bitmap9;
        EditHeadsImageView editHeadsImageView2;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.bRa;
        view.setClickable(true);
        view2 = this.this$0.bRa;
        view2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.bRs = true;
            if (this.bRy.booleanValue() || this.bRz.booleanValue()) {
                editHeadsImageView = this.this$0.bQY;
                editHeadsImageView.setImageBitmap(bitmap);
                bitmap2 = this.this$0.mBitmap;
                if (bitmap2.getWidth() <= 750) {
                    bitmap6 = this.this$0.mBitmap;
                }
                EditHeadActivity editHeadActivity = this.this$0;
                bitmap3 = this.this$0.mBitmap;
                editHeadActivity.mBitmap = com.baidu.tbadk.core.util.c.d(bitmap3, TbConfig.POST_IMAGE_MIDDLE);
                if (this.bRy.booleanValue()) {
                    EditHeadActivity editHeadActivity2 = this.this$0;
                    bitmap5 = this.this$0.mBitmap;
                    editHeadActivity2.mBitmap = com.baidu.tbadk.core.util.c.g(bitmap5, Integer.parseInt(this.mLabel));
                } else if (this.bRz.booleanValue()) {
                    EditHeadActivity editHeadActivity3 = this.this$0;
                    bitmap4 = this.this$0.mBitmap;
                    editHeadActivity3.mBitmap = com.baidu.tbadk.core.util.c.i(bitmap4, Integer.parseInt(this.mLabel));
                }
            } else {
                editHeadsImageView2 = this.this$0.bQY;
                editHeadsImageView2.replaceImageBitmap(bitmap);
            }
            bitmap7 = this.this$0.bRl;
            if (bitmap7 != null) {
                bitmap8 = this.this$0.bRl;
                if (!bitmap8.isRecycled()) {
                    bitmap9 = this.this$0.bRl;
                    bitmap9.recycle();
                }
            }
            this.this$0.bRl = bitmap;
        }
    }
}
