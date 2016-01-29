package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.fm;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, fm fmVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (fmVar != null) {
            postCategoryView = this.ets.esW;
            postCategoryView.setText(fmVar.name);
            writeData = this.ets.dZC;
            writeData.setCategoryTo(fmVar.blu);
            this.ets.esV = fmVar.blu;
            postCategoryView2 = this.ets.esW;
            postCategoryView2.aTZ();
        }
    }
}
