package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ge extends com.baidu.tbadk.core.view.userLike.c {
    public boolean eBF;
    private int eBG;
    public boolean isBigV;

    public ge(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eBF = false;
        this.isBigV = false;
        this.eBG = 0;
        this.eBG = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 1;
        super.onClick(view);
        if (this.eBF && this.anP != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c11924").Z("obj_id", this.anP.getUserId()));
        }
        if (this.isBigV && this.anP != null) {
            if (this.eBG != 1) {
                i = this.eBG == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12150").r("obj_locate", i).Z("obj_id", this.anP.getUserId()));
        }
    }
}
