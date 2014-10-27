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
    private String Kb;
    private Bitmap Kc;
    private Boolean Kd;
    private Boolean Ke;
    final /* synthetic */ WriteImageActivity this$0;

    private bw(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
        this.Kd = false;
        this.Ke = false;
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
        z = this.this$0.JR;
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
        textView = this.this$0.bSs;
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
        this.Kb = strArr[0];
        bitmap = this.this$0.mBitmap;
        if (bitmap == null) {
            bitmap12 = this.this$0.JN;
            if (bitmap12 == null) {
                return null;
            }
        }
        if (this.Kb.equals("0") || this.Kb.equals("1")) {
            this.Kd = true;
        } else if (this.Kb.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) || this.Kb.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.Ke = true;
        }
        if (!this.Kd.booleanValue() && !this.Ke.booleanValue()) {
            bitmap9 = this.this$0.mBitmap;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.this$0.mBitmap;
                bitmap11 = this.this$0.mBitmap;
                this.Kc = bitmap10.copy(bitmap11.getConfig(), true);
            }
        } else {
            bitmap2 = this.this$0.JN;
            if (bitmap2 != null) {
                bitmap6 = this.this$0.JN;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.this$0.JN;
                    bitmap8 = this.this$0.JN;
                    this.Kc = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.this$0.mBitmap;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.this$0.mBitmap;
                bitmap5 = this.this$0.mBitmap;
                this.Kc = bitmap4.copy(bitmap5.getConfig(), true);
            }
        }
        if (this.Kc != null) {
            if (this.Kc.getWidth() > 900 || this.Kc.getHeight() > 900) {
                this.Kc = com.baidu.tbadk.core.util.d.a(this.Kc, (int) TbConfig.POST_IMAGE_BIG);
            }
            if (this.Kd.booleanValue()) {
                this.Kc = com.baidu.tbadk.core.util.d.d(this.Kc, Integer.parseInt(this.Kb));
            } else if (this.Ke.booleanValue()) {
                this.Kc = com.baidu.tbadk.core.util.d.f(this.Kc, Integer.parseInt(this.Kb));
            } else {
                Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_MOTUSDK);
                if (pluginByName != null && pluginByName.checkEnable() && (motuPlugin = (MotuPlugin) pluginByName.getClassInstance(MotuPlugin.class)) != null) {
                    this.Kc = motuPlugin.createOneKeyFilterAndApply(this.this$0, this.Kb, this.Kc);
                }
            }
            return this.Kc;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.Kc != null && !this.Kc.isRecycled()) {
            bitmap = this.this$0.JN;
            if (bitmap != this.Kc) {
                this.Kc.recycle();
            }
        }
        this.Kc = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        textView = this.this$0.bSs;
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
        textView = this.this$0.bSs;
        textView.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.this$0.JU = true;
            imageView = this.this$0.acF;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.this$0.mBitmap;
            if (bitmap2 != null && (this.Kd.booleanValue() || this.Ke.booleanValue())) {
                bitmap6 = this.this$0.mBitmap;
                if (bitmap6.getWidth() <= 900) {
                    bitmap10 = this.this$0.mBitmap;
                }
                WriteImageActivity writeImageActivity = this.this$0;
                bitmap7 = this.this$0.mBitmap;
                writeImageActivity.mBitmap = com.baidu.tbadk.core.util.d.a(bitmap7, (int) TbConfig.POST_IMAGE_BIG);
                if (this.Kd.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.this$0;
                    bitmap9 = this.this$0.mBitmap;
                    writeImageActivity2.mBitmap = com.baidu.tbadk.core.util.d.d(bitmap9, Integer.parseInt(this.Kb));
                } else if (this.Ke.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.this$0;
                    bitmap8 = this.this$0.mBitmap;
                    writeImageActivity3.mBitmap = com.baidu.tbadk.core.util.d.f(bitmap8, Integer.parseInt(this.Kb));
                }
            }
            bitmap3 = this.this$0.JN;
            if (bitmap3 != null) {
                bitmap4 = this.this$0.JN;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.this$0.JN;
                    bitmap5.recycle();
                }
            }
            this.this$0.JN = bitmap;
        }
    }
}
