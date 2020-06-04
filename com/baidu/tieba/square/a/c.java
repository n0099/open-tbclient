package com.baidu.tieba.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.square.ForumSquareActivity;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c>> {
    private aa<com.baidu.tieba.square.data.b> fGl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.fGl = new aa<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (c.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) c.this.mPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        an anVar = new an("c13652");
                        anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.s("fid", bVar.forumId);
                        anVar.dh("resource_id", className);
                        TiebaStatic.log(anVar);
                        return;
                    }
                    an anVar2 = new an("c13643");
                    anVar2.s("uid", TbadkApplication.getCurrentAccountId());
                    anVar2.s("fid", bVar.forumId);
                    anVar2.ag("obj_locate", 3);
                    TiebaStatic.log(anVar2);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aG */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.square.view.c cVar = new com.baidu.tieba.square.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.square.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> aVar) {
        if (bVar == null || aVar == null || aVar.bLW() == null) {
            return null;
        }
        aVar.bLW().a(bVar);
        aVar.bLW().c(this.fGl);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).getClassName();
            if (!"推荐".equals(className)) {
                an anVar = new an("c13651");
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.s("fid", bVar.forumId);
                anVar.dh("resource_id", className);
                TiebaStatic.log(anVar);
            } else {
                an anVar2 = new an("c13642");
                anVar2.s("uid", TbadkApplication.getCurrentAccountId());
                anVar2.s("fid", bVar.getForumId());
                anVar2.ag("obj_locate", 3);
                TiebaStatic.log(anVar2);
            }
        }
        return aVar.getView();
    }
}
