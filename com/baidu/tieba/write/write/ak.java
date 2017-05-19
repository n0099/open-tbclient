package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cm cmVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (cmVar != null) {
            postCategoryView = this.fSV.fSd;
            postCategoryView.setText(cmVar.name);
            writeData = this.fSV.mData;
            writeData.setCategoryTo(cmVar.bQR);
            this.fSV.fSc = cmVar.bQR;
            postCategoryView2 = this.fSV.fSd;
            postCategoryView2.bnw();
        }
    }
}
