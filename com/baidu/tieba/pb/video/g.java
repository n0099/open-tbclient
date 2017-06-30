package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* loaded from: classes.dex */
public class g extends com.baidu.tbadk.core.view.userLike.c {
    public g(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.anP != null) {
            TiebaStatic.log(new au("c11924").Z("obj_id", this.anP.getUserId()));
        }
    }
}
