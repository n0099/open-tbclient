package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    public boolean ePT;
    private int ePU;
    public boolean isBigV;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.ePT = false;
        this.isBigV = false;
        this.ePU = 0;
        this.ePU = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 1;
        super.onClick(view);
        if (this.ePT && this.aqa != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11924").aa("obj_id", this.aqa.getUserId()));
        }
        if (this.isBigV && this.aqa != null) {
            if (this.ePU != 1) {
                i = this.ePU == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12150").r("obj_locate", i).aa("obj_id", this.aqa.getUserId()));
        }
    }
}
