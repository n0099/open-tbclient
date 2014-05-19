package com.baidu.tieba.write;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.plugins.MotuPlugin;
import com.baidu.tbadk.tbplugin.PluginsConfig;
import com.baidu.tieba.plugins.PluginDownloadActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bq extends BdAsyncTask<String, Void, Bitmap> {
    final /* synthetic */ WriteImageActivity a;
    private String b;
    private Bitmap c;
    private Boolean d;
    private Boolean e;

    private bq(WriteImageActivity writeImageActivity) {
        this.a = writeImageActivity;
        this.d = false;
        this.e = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bq(WriteImageActivity writeImageActivity, bq bqVar) {
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
        z = this.a.v;
        if (!z || ((MotuPlugin) com.baidu.tbadk.tbplugin.m.a().b(MotuPlugin.class)) != null) {
            progressBar = this.a.g;
            progressBar.setVisibility(0);
            textView = this.a.d;
            textView.setEnabled(false);
            return;
        }
        PluginsConfig.PluginConfig d = com.baidu.tbadk.tbplugin.m.a().d("motusdk");
        if (d == null) {
            handler2 = this.a.C;
            handler2.postDelayed(new br(this), 500L);
            this.a.showToast(com.baidu.tieba.u.plugin_config_not_found);
            return;
        }
        PluginDownloadActivity.a(this.a, d);
        handler = this.a.C;
        handler.postDelayed(new bs(this), 500L);
        cancel();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
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
        Bitmap bitmap10;
        Bitmap bitmap11;
        Bitmap bitmap12;
        this.b = strArr[0];
        bitmap = this.a.c;
        if (bitmap == null) {
            bitmap12 = this.a.q;
            if (bitmap12 == null) {
                return null;
            }
        }
        if (this.b.equals("0") || this.b.equals(TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK)) {
            this.d = true;
        } else if (this.b.equals(TbConfig.ST_PARAM_TAB_MSG_CREATE_CHAT) || this.b.equals(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            this.e = true;
        }
        if (!this.d.booleanValue() && !this.e.booleanValue()) {
            bitmap9 = this.a.c;
            if (!bitmap9.isRecycled()) {
                bitmap10 = this.a.c;
                bitmap11 = this.a.c;
                this.c = bitmap10.copy(bitmap11.getConfig(), true);
            }
        } else {
            bitmap2 = this.a.q;
            if (bitmap2 != null) {
                bitmap6 = this.a.q;
                if (!bitmap6.isRecycled()) {
                    bitmap7 = this.a.q;
                    bitmap8 = this.a.q;
                    this.c = bitmap7.copy(bitmap8.getConfig(), true);
                }
            }
            bitmap3 = this.a.c;
            if (!bitmap3.isRecycled()) {
                bitmap4 = this.a.c;
                bitmap5 = this.a.c;
                this.c = bitmap4.copy(bitmap5.getConfig(), true);
            }
        }
        if (this.c != null) {
            if (this.c.getWidth() > 900 || this.c.getHeight() > 900) {
                this.c = com.baidu.tbadk.core.util.g.a(this.c, (int) TbConfig.POST_IMAGE_BIG);
            }
            if (this.d.booleanValue()) {
                this.c = com.baidu.tbadk.core.util.g.d(this.c, Integer.parseInt(this.b));
            } else if (this.e.booleanValue()) {
                this.c = com.baidu.tbadk.core.util.g.f(this.c, Integer.parseInt(this.b));
            } else {
                MotuPlugin motuPlugin = (MotuPlugin) com.baidu.tbadk.tbplugin.m.a().b(MotuPlugin.class);
                if (motuPlugin != null) {
                    this.c = motuPlugin.createOneKeyFilterAndApply(this.a, this.b, this.c);
                }
            }
            return this.c;
        }
        return null;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        Bitmap bitmap;
        if (this.c != null && !this.c.isRecycled()) {
            bitmap = this.a.q;
            if (bitmap != this.c) {
                this.c.recycle();
            }
        }
        this.c = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        textView = this.a.d;
        textView.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005b, code lost:
        if (r0.getHeight() > 900) goto L21;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
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
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        textView = this.a.d;
        textView.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.y = true;
            imageView = this.a.b;
            imageView.setImageBitmap(bitmap);
            bitmap2 = this.a.c;
            if (bitmap2 != null && (this.d.booleanValue() || this.e.booleanValue())) {
                bitmap6 = this.a.c;
                if (bitmap6.getWidth() <= 900) {
                    bitmap10 = this.a.c;
                }
                WriteImageActivity writeImageActivity = this.a;
                bitmap7 = this.a.c;
                writeImageActivity.c = com.baidu.tbadk.core.util.g.a(bitmap7, (int) TbConfig.POST_IMAGE_BIG);
                if (this.d.booleanValue()) {
                    WriteImageActivity writeImageActivity2 = this.a;
                    bitmap9 = this.a.c;
                    writeImageActivity2.c = com.baidu.tbadk.core.util.g.d(bitmap9, Integer.parseInt(this.b));
                } else if (this.e.booleanValue()) {
                    WriteImageActivity writeImageActivity3 = this.a;
                    bitmap8 = this.a.c;
                    writeImageActivity3.c = com.baidu.tbadk.core.util.g.f(bitmap8, Integer.parseInt(this.b));
                }
            }
            bitmap3 = this.a.q;
            if (bitmap3 != null) {
                bitmap4 = this.a.q;
                if (!bitmap4.isRecycled()) {
                    bitmap5 = this.a.q;
                    bitmap5.recycle();
                }
            }
            this.a.q = bitmap;
        }
    }
}
