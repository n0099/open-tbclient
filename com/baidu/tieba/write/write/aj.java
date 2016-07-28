package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dy;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dy dyVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (dyVar != null) {
            postCategoryView = this.fVn.fUH;
            postCategoryView.setText(dyVar.name);
            writeData = this.fVn.faq;
            writeData.setCategoryTo(dyVar.bIj);
            this.fVn.fUG = dyVar.bIj;
            postCategoryView2 = this.fVn.fUH;
            postCategoryView2.bok();
        }
    }
}
