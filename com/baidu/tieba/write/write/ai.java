package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, com.baidu.tieba.frs.co coVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (coVar != null) {
            postCategoryView = this.glP.gkX;
            postCategoryView.setText(coVar.name);
            writeData = this.glP.mData;
            writeData.setCategoryTo(coVar.ceQ);
            this.glP.gkW = coVar.ceQ;
            postCategoryView2 = this.glP.gkX;
            postCategoryView2.btt();
        }
    }
}
