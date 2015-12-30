package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fc fcVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (fcVar != null) {
            postCategoryView = this.dYD.dYh;
            postCategoryView.setText(fcVar.name);
            writeData = this.dYD.dJy;
            writeData.setCategoryTo(fcVar.biz);
            this.dYD.dYg = fcVar.biz;
            postCategoryView2 = this.dYD.dYh;
            postCategoryView2.aLe();
        }
    }
}
