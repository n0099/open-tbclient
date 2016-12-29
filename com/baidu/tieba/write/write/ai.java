package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.cx;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, cx cxVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (cxVar != null) {
            postCategoryView = this.fDQ.fDc;
            postCategoryView.setText(cxVar.name);
            writeData = this.fDQ.eWm;
            writeData.setCategoryTo(cxVar.bBw);
            this.fDQ.fDb = cxVar.bBw;
            postCategoryView2 = this.fDQ.fDc;
            postCategoryView2.bmy();
        }
    }
}
