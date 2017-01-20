package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class ex extends com.baidu.tbadk.core.view.userLike.c {
    public boolean eny;

    public ex(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
        this.eny = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.eny && this.ahe != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11924").ab("obj_id", this.ahe.getUserId()));
        }
    }
}
