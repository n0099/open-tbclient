package com.baidu.tieba.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.square.ForumSquareActivity;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c>> {
    private ab<com.baidu.tieba.square.data.b> hbz;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.hbz = new ab<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (c.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) c.this.mPageContext.getPageActivity()).dNc().getClassName();
                    if (!"推荐".equals(className)) {
                        ar arVar = new ar("c13652");
                        arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.w("fid", bVar.forumId);
                        arVar.dY("resource_id", className);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    ar arVar2 = new ar("c13643");
                    arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                    arVar2.w("fid", bVar.forumId);
                    arVar2.al("obj_locate", 3);
                    TiebaStatic.log(arVar2);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> c(ViewGroup viewGroup) {
        com.baidu.tieba.square.view.c cVar = new com.baidu.tieba.square.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.square.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> aVar) {
        if (bVar == null || aVar == null || aVar.csN() == null) {
            return null;
        }
        aVar.csN().a(bVar);
        aVar.csN().c(this.hbz);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).dNc().getClassName();
            if (!"推荐".equals(className)) {
                ar arVar = new ar("c13651");
                arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.w("fid", bVar.forumId);
                arVar.dY("resource_id", className);
                TiebaStatic.log(arVar);
            } else {
                ar arVar2 = new ar("c13642");
                arVar2.w("uid", TbadkApplication.getCurrentAccountId());
                arVar2.w("fid", bVar.getForumId());
                arVar2.al("obj_locate", 3);
                TiebaStatic.log(arVar2);
            }
        }
        return aVar.getView();
    }
}
