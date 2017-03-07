package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ct;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ct ctVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (ctVar != null) {
            postCategoryView = this.fQG.fPS;
            postCategoryView.setText(ctVar.name);
            writeData = this.fQG.mData;
            writeData.setCategoryTo(ctVar.bPZ);
            this.fQG.fPR = ctVar.bPZ;
            postCategoryView2 = this.fQG.fPS;
            postCategoryView2.bnJ();
        }
    }
}
