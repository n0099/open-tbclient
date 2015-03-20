package com.baidu.tieba.person;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    private final /* synthetic */ String bPd;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.bPd = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadsImageView editHeadsImageView;
        Bitmap bitmap;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            editHeadsImageView = this.this$0.bOE;
            bitmap = this.this$0.mBitmap;
            editHeadsImageView.replaceImageBitmap(bitmap);
            this.this$0.bOY = false;
            this.this$0.hU(this.bPd);
            this.this$0.bOU = this.val$id;
        }
    }
}
