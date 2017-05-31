package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, com.baidu.tieba.frs.cn cnVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (cnVar != null) {
            postCategoryView = this.gaR.fZZ;
            postCategoryView.setText(cnVar.name);
            writeData = this.gaR.mData;
            writeData.setCategoryTo(cnVar.bWI);
            this.gaR.fZY = cnVar.bWI;
            postCategoryView2 = this.gaR.fZZ;
            postCategoryView2.boV();
        }
    }
}
