package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.tbadkCore.data.PostData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fp implements View.OnClickListener {
    final /* synthetic */ ey erv;
    private final /* synthetic */ boolean ery;
    private final /* synthetic */ PostData erz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(ey eyVar, PostData postData, boolean z) {
        this.erv = eyVar;
        this.erz = postData;
        this.ery = z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        PbActivity pbActivity2;
        TiebaStatic.log(new com.baidu.tbadk.core.util.as("c10630").aa("obj_id", this.erz.getAuthor().getUserId()));
        if (this.ery) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11923").s("obj_id", 3));
        }
        pbActivity = this.erv.eig;
        if (pbActivity.eiT.erI != null) {
            pbActivity2 = this.erv.eig;
            pbActivity2.eiT.erI.onClick(view);
        }
    }
}
