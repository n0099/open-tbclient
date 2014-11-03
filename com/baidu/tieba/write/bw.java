package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.PluginDownloadActivityConfig;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.pluginArch.bean.ConfigInfos;
import com.baidu.tbadk.plugins.MotuPlugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw extends BdAsyncTask<String, Void, Bitmap> {
    private String Kc;
    private Bitmap Kd;
    private Boolean Ke;
    private Boolean Kf;
    final /* synthetic */ WriteImageActivity this$0;

    private bw(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
        this.Ke = false;
        this.Kf = false;
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
        TextView textView;
        Handler handler;
        Handler handler2;
        Handler handler3;
        z = this.this$0.JS;
        if (z) {
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
            if (pluginByName == null) {
                ConfigInfos.PluginConfig netConfigInfo = PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK);
                if (netConfigInfo == null) {
                    handler3 = this.this$0.mHandler;
                    handler3.postDelayed(new bx(this), 500L);
                    this.this$0.showToast(com.baidu.tieba.y.plugin_config_not_found);
                    return;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PluginDownloadActivityConfig(this.this$0, netConfigInfo)));
                handler2 = this.this$0.mHandler;
                handler2.postDelayed(new by(this), 500L);
                cancel();
                return;
            } else if (!pluginByName.checkEnable()) {
                com.baidu.tbadk.coreExtra.util.a.a(this.this$0, com.baidu.tieba.y.plugin_muto_not_install, new bz(this), new ca(this));
                handler = this.this$0.mHandler;
                handler.postDelayed(new cb(this), 500L);
                cancel();
                return;
            }
        }
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        textView = this.this$0.bSH;
        textView.setEnabled(false);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: j */
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
        this.Kc = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap12 = this.this$0.JO;
            if (bitmap12 == null) {
                return null;
            }
        }
        if (this.Kc.equals("0") || this.Kc.equals("1")) {
            this.Ke = true;
        } else if (this.Kc.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) || this.Kc.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.Kf = true;
        }
        if (!this.Ke.booleanValue() && !this.Kf.booleanValue()) {
            bitmap9 = this.this$0.mBitmap;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.this$0.mBitmap;
                bitmap11 = this.this$0.mBitmap;
                this.Kd = bitmap10.copy(bitmap11.getConfig(), true);
            }
        } else {
            bitmap2 = this.this$0.JO;
            if (bitmap2 != null) {
                bitmap6 = this.this$0.JO;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.this$0.JO;
                    bitmap8 = this.this$0.JO;
                    this.Kd = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.this$0.mBitmap;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.this$0.mBitmap;
                bitmap5 = this.this$0.mBitmap;
                this.Kd = bitmap4.copy(bitmap5.getConfig(), true);
            }
        }
        if (this.Kd != null) {
            if (this.Kd.getWidth() > 900 || this.Kd.getHeight() > 900) {
                this.Kd = com.baidu.tbadk.core.util.d.a(this.Kd, (int) TbConfig.POST_IMAGE_BIG);
            }
            if (this.Ke.booleanValue()) {
                this.Kd = com.baidu.tbadk.core.util.d.d(this.Kd, Integer.parseInt(this.Kc));
            } else if (this.Kf.booleanValue()) {
                this.Kd = com.baidu.tbadk.core.util.d.f(this.Kd, Integer.parseInt(this.Kc));
            } else {
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
                if (pluginByName != null && pluginByName.checkEnable() && (motuPlugin = (MotuPlugin) pluginByName.getClassInstance(MotuPlugin.class)) != null) {
                    this.Kd = motuPlugin.createOneKeyFilterAndApply(this.this$0, this.Kc, this.Kd);
                }
            }
            return this.Kd;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.Kd != null && !this.Kd.isRecycled()) {
            bitmap = this.this$0.JO;
            if (bitmap != this.Kd) {
                this.Kd.recycle();
            }
        }
        this.Kd = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        textView = this.this$0.bSH;
        textView.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r0.getHeight() > 900) goto L21;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        TextView textView;
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
        textView = this.this$0.bSH;
        textView.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.JV = true;
            imageView = this.this$0.acK;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.this$0.mBitmap;
            if (bitmap2 != null && (this.Ke.booleanValue() || this.Kf.booleanValue())) {
                bitmap6 = this.this$0.mBitmap;
                if (bitmap6.getWidth() <= 900) {
                    bitmap10 = this.this$0.mBitmap;
                }
                WriteImageActivity writeImageActivity = this.this$0;
                bitmap7 = this.this$0.mBitmap;
                writeImageActivity.mBitmap = com.baidu.tbadk.core.util.d.a(bitmap7, (int) TbConfig.POST_IMAGE_BIG);
                if (this.Ke.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.this$0;
                    bitmap9 = this.this$0.mBitmap;
                    writeImageActivity2.mBitmap = com.baidu.tbadk.core.util.d.d(bitmap9, Integer.parseInt(this.Kc));
                } else if (this.Kf.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.this$0;
                    bitmap8 = this.this$0.mBitmap;
                    writeImageActivity3.mBitmap = com.baidu.tbadk.core.util.d.f(bitmap8, Integer.parseInt(this.Kc));
                }
            }
            bitmap3 = this.this$0.JO;
            if (bitmap3 != null) {
                bitmap4 = this.this$0.JO;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.this$0.JO;
                    bitmap5.recycle();
                }
            }
            this.this$0.JO = bitmap;
        }
    }
}
