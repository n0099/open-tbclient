package com.baidu.tieba.write;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.GridLayout;
import com.baidu.tieba.frs.ForumWriteData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ e gdS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.gdS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GridLayout gridLayout;
        TbImageView tbImageView;
        ForumWriteData forumWriteData;
        TbPageContext tbPageContext;
        ForumWriteData forumWriteData2;
        ForumWriteData forumWriteData3;
        e eVar = this.gdS;
        gridLayout = this.gdS.gdK;
        tbImageView = this.gdS.gdJ;
        eVar.d(gridLayout, tbImageView);
        String str = "0";
        String str2 = null;
        forumWriteData = this.gdS.gdN;
        if (forumWriteData != null) {
            forumWriteData2 = this.gdS.gdN;
            str = forumWriteData2.forumId;
            forumWriteData3 = this.gdS.gdN;
            str2 = forumWriteData3.forumName;
        }
        tbPageContext = this.gdS.aat;
        q.c(tbPageContext, str, str2);
    }
}
