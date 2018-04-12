package com.baidu.tieba.pb.video;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
/* loaded from: classes2.dex */
public class f extends com.baidu.tbadk.core.view.userLike.c {
    public f(TbPageContext tbPageContext, com.baidu.tbadk.core.view.userLike.b bVar) {
        super(tbPageContext, bVar);
    }

    @Override // com.baidu.tbadk.core.view.userLike.c, android.view.View.OnClickListener
    public void onClick(View view2) {
        super.onClick(view2);
        if (this.aqG != null) {
            TiebaStatic.log(new al("c11924").ac(VideoPlayActivityConfig.OBJ_ID, this.aqG.getUserId()));
        }
    }
}
