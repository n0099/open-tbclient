package com.baidu.tieba.write.write;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements View.OnClickListener {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PostCategoryView postCategoryView;
        InputMethodManager inputMethodManager;
        EditText bbz;
        InputMethodManager inputMethodManager2;
        EditText bby;
        postCategoryView = this.eNd.eMH;
        postCategoryView.bay();
        WriteActivity writeActivity = this.eNd;
        inputMethodManager = this.eNd.mInputManager;
        bbz = this.eNd.bbz();
        writeActivity.HidenSoftKeyPad(inputMethodManager, bbz);
        WriteActivity writeActivity2 = this.eNd;
        inputMethodManager2 = this.eNd.mInputManager;
        bby = this.eNd.bby();
        writeActivity2.HidenSoftKeyPad(inputMethodManager2, bby);
    }
}
