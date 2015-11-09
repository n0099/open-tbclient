package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ek;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ek ekVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (ekVar != null) {
            postCategoryView = this.dsa.drF;
            postCategoryView.setText(ekVar.name);
            writeData = this.dsa.ddI;
            writeData.setCategoryTo(ekVar.aYG);
            this.dsa.drE = ekVar.aYG;
            postCategoryView2 = this.dsa.drF;
            postCategoryView2.aDm();
        }
    }
}
