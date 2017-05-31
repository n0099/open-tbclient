package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class fv extends com.baidu.tbadk.core.view.userLike.c {
    public boolean esu;
    private int esv;
    public boolean isBigV;

    public fv(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.esu = false;
        this.isBigV = false;
        this.esv = 0;
        this.esv = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 1;
        super.onClick(view);
        if (this.esu && this.amP != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c11924").Z("obj_id", this.amP.getUserId()));
        }
        if (this.isBigV && this.amP != null) {
            if (this.esv != 1) {
                i = this.esv == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12150").r("obj_locate", i).Z("obj_id", this.amP.getUserId()));
        }
    }
}
