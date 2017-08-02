package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ao extends com.baidu.tbadk.core.view.userLike.c {
    public boolean eMN;
    private int eMO;
    public boolean isBigV;

    public ao(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar, int i) {
        super(tbPageContext, bVar);
        this.eMN = false;
        this.isBigV = false;
        this.eMO = 0;
        this.eMO = i;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 1;
        super.onClick(view);
        if (this.eMN && this.aoF != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c11924").aa("obj_id", this.aoF.getUserId()));
        }
        if (this.isBigV && this.aoF != null) {
            if (this.eMO != 1) {
                i = this.eMO == 2 ? 2 : 0;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.aj("c12150").r("obj_locate", i).aa("obj_id", this.aoF.getUserId()));
        }
    }
}
