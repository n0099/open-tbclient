package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.ft;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fea;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(WriteActivity writeActivity) {
        this.fea = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, ft ftVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (ftVar != null) {
            postCategoryView = this.fea.fdw;
            postCategoryView.setText(ftVar.name);
            writeData = this.fea.evE;
            writeData.setCategoryTo(ftVar.blZ);
            this.fea.fdv = ftVar.blZ;
            postCategoryView2 = this.fea.fdw;
            postCategoryView2.bcT();
        }
    }
}
