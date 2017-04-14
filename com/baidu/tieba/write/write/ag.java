package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fSq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.fSq = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cv cvVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (cvVar != null) {
            postCategoryView = this.fSq.fRC;
            postCategoryView.setText(cvVar.name);
            writeData = this.fSq.mData;
            writeData.setCategoryTo(cvVar.bPO);
            this.fSq.fRB = cvVar.bPO;
            postCategoryView2 = this.fSq.fRC;
            postCategoryView2.bot();
        }
    }
}
