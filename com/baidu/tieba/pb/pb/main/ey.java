package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ey extends com.baidu.tbadk.core.view.userLike.c {
    public boolean eqx;

    public ey(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
        this.eqx = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.eqx && this.amA != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11924").Z("obj_id", this.amA.getUserId()));
        }
    }
}
