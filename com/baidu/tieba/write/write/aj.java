package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dt dtVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (dtVar != null) {
            postCategoryView = this.ghD.ggV;
            postCategoryView.setText(dtVar.name);
            writeData = this.ghD.flk;
            writeData.setCategoryTo(dtVar.bTi);
            this.ghD.ggU = dtVar.bTi;
            postCategoryView2 = this.ghD.ggV;
            postCategoryView2.btf();
        }
    }
}
