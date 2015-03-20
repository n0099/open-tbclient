package com.baidu.tieba.write.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import java.util.Date;
/* loaded from: classes.dex */
class bt implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        ProgressBar progressBar;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean ji;
        z = this.this$0.bJj;
        if (!z) {
            i = this.this$0.requestCode;
            if (i == 12003) {
                Intent intent = new Intent();
                progressBar = this.this$0.mProgress;
                if (progressBar.getVisibility() != 0) {
                    z2 = this.this$0.bOY;
                    if (z2) {
                        bitmap = this.this$0.bOR;
                        if (bitmap != null) {
                            bitmap2 = this.this$0.bOR;
                            if (!bitmap2.isRecycled()) {
                                String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                                ji = this.this$0.ji(str);
                                if (ji) {
                                    intent.putExtra("change", true);
                                    intent.putExtra("file_name", str);
                                } else {
                                    intent.putExtra("change", false);
                                }
                                this.this$0.setResult(-1, intent);
                            }
                        }
                    }
                    intent.putExtra("change", false);
                    this.this$0.setResult(-1, intent);
                } else {
                    return;
                }
            } else {
                this.this$0.setResult(0, new Intent());
            }
        } else {
            this.this$0.setResult(0, new Intent());
        }
        this.this$0.finish();
    }
}
