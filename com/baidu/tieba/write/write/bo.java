package com.baidu.tieba.write.write;

import android.content.Intent;
import android.view.View;
import java.util.Date;
/* loaded from: classes.dex */
class bo implements View.OnClickListener {
    final /* synthetic */ WriteImageActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(WriteImageActivity writeImageActivity) {
        this.this$0 = writeImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        int i;
        boolean z2;
        boolean tj;
        z = this.this$0.exj;
        if (!z) {
            i = this.this$0.requestCode;
            if (i == 12003) {
                Intent intent = new Intent();
                if (this.this$0.cub.getVisibility() != 0) {
                    z2 = this.this$0.eNh;
                    if (z2 && this.this$0.eNa != null && !this.this$0.eNa.isRecycled()) {
                        String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                        tj = this.this$0.tj(str);
                        if (tj) {
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
