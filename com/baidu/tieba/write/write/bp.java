package com.baidu.tieba.write.write;

import android.content.Intent;
import android.view.View;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bp implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        boolean z2;
        boolean sx;
        z = this.this$0.eps;
        if (!z) {
            i = this.this$0.requestCode;
            if (i == 12003) {
                Intent intent = new Intent();
                if (this.this$0.coz.getVisibility() != 0) {
                    z2 = this.this$0.eEE;
                    if (z2 && this.this$0.eEx != null && !this.this$0.eEx.isRecycled()) {
                        String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                        sx = this.this$0.sx(str);
                        if (sx) {
                            intent.putExtra("change", true);
                            intent.putExtra("file_name", str);
                        } else {
                            intent.putExtra("change", false);
                        }
                    } else {
                        intent.putExtra("change", false);
                    }
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
