package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* loaded from: classes22.dex */
public class e extends com.baidu.tbadk.core.view.userLike.c {
    public e(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.eUL != null) {
            TiebaStatic.log(new aq("c11924").dR("obj_id", this.eUL.getUserId()));
        }
    }
}
