package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dy dyVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (dyVar != null) {
            postCategoryView = this.fJw.fIQ;
            postCategoryView.setText(dyVar.name);
            writeData = this.fJw.fau;
            writeData.setCategoryTo(dyVar.bGN);
            this.fJw.fIP = dyVar.bGN;
            postCategoryView2 = this.fJw.fIQ;
            postCategoryView2.blp();
        }
    }
}
