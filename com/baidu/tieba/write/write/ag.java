package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cv;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cv cvVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (cvVar != null) {
            postCategoryView = this.fUM.fTY;
            postCategoryView.setText(cvVar.name);
            writeData = this.fUM.mData;
            writeData.setCategoryTo(cvVar.bSf);
            this.fUM.fTX = cvVar.bSf;
            postCategoryView2 = this.fUM.fTY;
            postCategoryView2.bpu();
        }
    }
}
