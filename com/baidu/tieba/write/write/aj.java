package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.tieba.frs.dt;
import com.baidu.tieba.write.view.PostCategoryView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements TabMenuPopView.a {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // com.baidu.tieba.frs.TabMenuPopView.a
    public void a(View view, dt dtVar) {
        PostCategoryView postCategoryView;
        WriteData writeData;
        PostCategoryView postCategoryView2;
        if (dtVar != null) {
            postCategoryView = this.gfs.geM;
            postCategoryView.setText(dtVar.name);
            writeData = this.gfs.fiE;
            writeData.setCategoryTo(dtVar.bTp);
            this.gfs.geL = dtVar.bTp;
            postCategoryView2 = this.gfs.geM;
            postCategoryView2.bsz();
        }
    }
}
