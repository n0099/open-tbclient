package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ct ctVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (ctVar != null) {
            postCategoryView = this.fMl.fLx;
            postCategoryView.setText(ctVar.name);
            writeData = this.fMl.mData;
            writeData.setCategoryTo(ctVar.bIQ);
            this.fMl.fLw = ctVar.bIQ;
            postCategoryView2 = this.fMl.fLx;
            postCategoryView2.bnW();
        }
    }
}
