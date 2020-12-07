package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
/* loaded from: classes22.dex */
public class e extends com.baidu.tbadk.core.view.userLike.c {
    public e(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.fhf != null) {
            TiebaStatic.log(new ar("c11924").dY("obj_id", this.fhf.getUserId()));
        }
    }
}
