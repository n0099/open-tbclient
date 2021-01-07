package com.baidu.tieba.square.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.square.view.c;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, CardViewHolder<c>> {
    private aa<com.baidu.tieba.square.data.b> hnl;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.hnl = new aa<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (b.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) b.this.mPageContext.getPageActivity()).dMV().getClassName();
                    if (!"推荐".equals(className)) {
                        aq aqVar = new aq("c13652");
                        aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                        aqVar.w("fid", bVar.forumId);
                        aqVar.dX("resource_id", className);
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    aq aqVar2 = new aq("c13643");
                    aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                    aqVar2.w("fid", bVar.forumId);
                    aqVar2.an("obj_locate", 3);
                    TiebaStatic.log(aqVar2);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aX */
    public CardViewHolder<c> e(ViewGroup viewGroup) {
        c cVar = new c(this.mPageContext);
        cVar.setTag(this.mPageId);
        return new CardViewHolder<>(cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.square.data.b bVar, CardViewHolder<c> cardViewHolder) {
        if (bVar == null || cardViewHolder == null || cardViewHolder.cvH() == null) {
            return null;
        }
        cardViewHolder.cvH().a(bVar);
        cardViewHolder.cvH().c(this.hnl);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).dMV().getClassName();
            if (!"推荐".equals(className)) {
                aq aqVar = new aq("c13651");
                aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
                aqVar.w("fid", bVar.forumId);
                aqVar.dX("resource_id", className);
                TiebaStatic.log(aqVar);
            } else {
                aq aqVar2 = new aq("c13642");
                aqVar2.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar2.w("fid", bVar.getForumId());
                aqVar2.an("obj_locate", 3);
                TiebaStatic.log(aqVar2);
            }
        }
        return cardViewHolder.getView();
    }
}
