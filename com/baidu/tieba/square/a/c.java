package com.baidu.tieba.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.card.z;
import com.baidu.tieba.square.ForumSquareActivity;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c>> {
    private z<com.baidu.tieba.square.data.b> fsi;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.fsi = new z<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (c.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) c.this.mPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        an anVar = new an("c13652");
                        anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        anVar.t("fid", bVar.forumId);
                        anVar.cI("resource_id", className);
                        TiebaStatic.log(anVar);
                        return;
                    }
                    an anVar2 = new an("c13643");
                    anVar2.t("uid", TbadkApplication.getCurrentAccountId());
                    anVar2.t("fid", bVar.forumId);
                    anVar2.af("obj_locate", 3);
                    TiebaStatic.log(anVar2);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ax */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.square.view.c cVar = new com.baidu.tieba.square.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.square.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> aVar) {
        if (bVar == null || aVar == null || aVar.bFz() == null) {
            return null;
        }
        aVar.bFz().a(bVar);
        aVar.bFz().c(this.fsi);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).getClassName();
            if (!"推荐".equals(className)) {
                an anVar = new an("c13651");
                anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.t("fid", bVar.forumId);
                anVar.cI("resource_id", className);
                TiebaStatic.log(anVar);
            } else {
                an anVar2 = new an("c13642");
                anVar2.t("uid", TbadkApplication.getCurrentAccountId());
                anVar2.t("fid", bVar.getForumId());
                anVar2.af("obj_locate", 3);
                TiebaStatic.log(anVar2);
            }
        }
        return aVar.getView();
    }
}
