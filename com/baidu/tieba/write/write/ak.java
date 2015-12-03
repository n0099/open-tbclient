package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fc;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fc fcVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (fcVar != null) {
            postCategoryView = this.dRf.dQJ;
            postCategoryView.setText(fcVar.name);
            writeData = this.dRf.dBW;
            writeData.setCategoryTo(fcVar.beF);
            this.dRf.dQI = fcVar.beF;
            postCategoryView2 = this.dRf.dQJ;
            postCategoryView2.aIJ();
        }
    }
}
