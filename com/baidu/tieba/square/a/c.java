package com.baidu.tieba.square.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.square.ForumSquareActivity;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c>> {
    private aa<com.baidu.tieba.square.data.b> fWN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.fWN = new aa<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (c.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) c.this.mPageContext.getPageActivity()).getClassName();
                    if (!"推荐".equals(className)) {
                        ap apVar = new ap("c13652");
                        apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                        apVar.t("fid", bVar.forumId);
                        apVar.dn("resource_id", className);
                        TiebaStatic.log(apVar);
                        return;
                    }
                    ap apVar2 = new ap("c13643");
                    apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                    apVar2.t("fid", bVar.forumId);
                    apVar2.ah("obj_locate", 3);
                    TiebaStatic.log(apVar2);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> b(ViewGroup viewGroup) {
        com.baidu.tieba.square.view.c cVar = new com.baidu.tieba.square.view.c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new com.baidu.tieba.card.a.a<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.square.data.b bVar, com.baidu.tieba.card.a.a<com.baidu.tieba.square.view.c> aVar) {
        if (bVar == null || aVar == null || aVar.bSs() == null) {
            return null;
        }
        aVar.bSs().a(bVar);
        aVar.bSs().c(this.fWN);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).getClassName();
            if (!"推荐".equals(className)) {
                ap apVar = new ap("c13651");
                apVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
                apVar.t("fid", bVar.forumId);
                apVar.dn("resource_id", className);
                TiebaStatic.log(apVar);
            } else {
                ap apVar2 = new ap("c13642");
                apVar2.t("uid", TbadkApplication.getCurrentAccountId());
                apVar2.t("fid", bVar.getForumId());
                apVar2.ah("obj_locate", 3);
                TiebaStatic.log(apVar2);
            }
        }
        return aVar.getView();
    }
}
