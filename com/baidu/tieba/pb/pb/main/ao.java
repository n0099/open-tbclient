package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    public boolean eOa;
    private int eOb;
    public boolean isBigV;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eOa = false;
        this.isBigV = false;
        this.eOb = 0;
        this.eOb = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 1;
        super.onClick(view);
        if (this.eOa && this.apZ != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11924").aa("obj_id", this.apZ.getUserId()));
        }
        if (this.isBigV && this.apZ != null) {
            if (this.eOb != 1) {
                i = this.eOb == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12150").r("obj_locate", i).aa("obj_id", this.apZ.getUserId()));
        }
    }
}
