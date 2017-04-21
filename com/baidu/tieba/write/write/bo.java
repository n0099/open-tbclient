package com.baidu.tieba.write.write;

import android.content.Intent;
import android.view.View;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import java.util.Date;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo implements View.OnClickListener {
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
        boolean rr;
        boolean z3;
        boolean rr2;
        z = this.this$0.enL;
        if (!z) {
            i = this.this$0.requestCode;
            if (i == 12003) {
                Intent intent = new Intent();
                intent.putExtra(WriteImageActivityConfig.DELET_FLAG, true);
                this.this$0.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                z2 = this.this$0.eEm;
                if (z2) {
                    if (this.this$0.eEf != null && !this.this$0.eEf.isRecycled()) {
                        String str = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
                        rr = this.this$0.rr(str);
                        if (rr) {
                            intent2.putExtra("change", true);
                            intent2.putExtra("file_name", str);
                        } else {
                            intent2.putExtra("change", false);
                        }
                    } else {
                        intent2.putExtra("change", false);
                    }
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
        z3 = this.this$0.eEm;
        if (z3 && this.this$0.eEf != null && !this.this$0.eEf.isRecycled()) {
            String str2 = "tieba" + String.valueOf(new Date().getTime()) + ".jpg";
            rr2 = this.this$0.rr(str2);
            if (rr2) {
                intent3.putExtra("filename", str2);
            }
        }
        this.this$0.setResult(-1, intent3);
        this.this$0.finish();
    }
}
