package com.baidu.tieba.write;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        boolean z2;
        Bitmap bitmap;
        Bitmap bitmap2;
        boolean iw;
        boolean z3;
        Bitmap bitmap3;
        Bitmap bitmap4;
        boolean iw2;
        z = this.this$0.bAO;
        if (!z) {
            i = this.this$0.requestCode;
            if (i == 12003) {
                Intent intent = new Intent();
                intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                this.this$0.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                z2 = this.this$0.Pg;
                if (z2) {
                    bitmap = this.this$0.OZ;
                    if (bitmap != null) {
                        bitmap2 = this.this$0.OZ;
                        if (!bitmap2.isRecycled()) {
                            String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                            iw = this.this$0.iw(str);
                            if (iw) {
                                intent2.putExtra("change", true);
                                intent2.putExtra("file_name", str);
                            } else {
                                intent2.putExtra("change", false);
                            }
                        }
                    }
                    intent2.putExtra("change", false);
                } else {
                    intent2.setData(this.this$0.getIntent().getData());
                    this.this$0.setResult(-1, intent2);
                }
                this.this$0.setResult(-1, intent2);
            }
            this.this$0.finish();
            return;
        }
        Intent intent3 = new Intent();
        z3 = this.this$0.Pg;
        if (z3) {
            bitmap3 = this.this$0.OZ;
            if (bitmap3 != null) {
                bitmap4 = this.this$0.OZ;
                if (!bitmap4.isRecycled()) {
                    String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                    iw2 = this.this$0.iw(str2);
                    if (iw2) {
                        intent3.putExtra("filename", str2);
                    }
                }
            }
        }
        this.this$0.setResult(-1, intent3);
        this.this$0.finish();
    }
}
