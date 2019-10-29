package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
/* loaded from: classes4.dex */
public class f extends com.baidu.tbadk.core.view.userLike.c {
    public f(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.csN != null) {
            TiebaStatic.log(new an("c11924").bS("obj_id", this.csN.getUserId()));
        }
    }
}
