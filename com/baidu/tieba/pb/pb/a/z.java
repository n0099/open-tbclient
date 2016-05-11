package com.baidu.tieba.pb.pb.a;

import android.view.View;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ r dgC;
    private final /* synthetic */ PraiseData dgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(r rVar, PraiseData praiseData) {
        this.dgC = rVar;
        this.dgJ = praiseData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((this.dgJ == null || this.dgJ.getIsLike() != 1) && this.dgC.dhY != null && bl.ac(this.dgC.dhY.getPageContext().getPageActivity())) {
            this.dgC.dhY.aws();
        }
    }
}
