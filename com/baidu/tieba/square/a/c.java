package com.baidu.tieba.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.square.ForumSquareActivity;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c>> {
    private aa<com.baidu.tieba.square.data.b> giQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.giQ = new aa<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (c.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) c.this.mPageContext.getPageActivity()).duG().getClassName();
                    if (!"推荐".equals(className)) {
                        aq aqVar = new aq("c13652");
                        aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.u("fid", bVar.forumId);
                        aqVar.dD("resource_id", className);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    aq aqVar2 = new aq("c13643");
                    aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar2.u("fid", bVar.forumId);
                    aqVar2.ai("obj_locate", 3);
                    TiebaStatic.log(aqVar2);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aK */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.square.view.c cVar = new com.baidu.tieba.square.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.square.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> aVar) {
        if (bVar == null || aVar == null || aVar.ccF() == null) {
            return null;
        }
        aVar.ccF().a(bVar);
        aVar.ccF().c(this.giQ);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).duG().getClassName();
            if (!"推荐".equals(className)) {
                aq aqVar = new aq("c13651");
                aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.u("fid", bVar.forumId);
                aqVar.dD("resource_id", className);
                TiebaStatic.log(aqVar);
            } else {
                aq aqVar2 = new aq("c13642");
                aqVar2.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.u("fid", bVar.getForumId());
                aqVar2.ai("obj_locate", 3);
                TiebaStatic.log(aqVar2);
            }
        }
        return aVar.getView();
    }
}
