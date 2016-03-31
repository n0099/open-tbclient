package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fu;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fu fuVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (fuVar != null) {
            postCategoryView = this.eNd.eMH;
            postCategoryView.setText(fuVar.name);
            writeData = this.eNd.esv;
            writeData.setCategoryTo(fuVar.bqM);
            this.eNd.eMG = fuVar.bqM;
            postCategoryView2 = this.eNd.eMH;
            postCategoryView2.baz();
        }
    }
}
