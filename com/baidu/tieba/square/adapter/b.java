package com.baidu.tieba.square.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.tieba.square.ForumSquareActivity;
import com.baidu.tieba.square.view.c;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.square.data.b, CardViewHolder<c>> {
    private ab<com.baidu.tieba.square.data.b> hmS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.square.data.b.TYPE);
        this.hmS = new ab<com.baidu.tieba.square.data.b>() { // from class: com.baidu.tieba.square.adapter.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.square.data.b bVar) {
                if (bVar != null && (b.this.mPageContext.getPageActivity() instanceof ForumSquareActivity)) {
                    String className = ((ForumSquareActivity) b.this.mPageContext.getPageActivity()).dLo().getClassName();
                    if (!"推荐".equals(className)) {
                        ar arVar = new ar("c13652");
                        arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                        arVar.v("fid", bVar.forumId);
                        arVar.dR("resource_id", className);
                        TiebaStatic.log(arVar);
                        return;
                    }
                    ar arVar2 = new ar("c13643");
                    arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                    arVar2.v("fid", bVar.forumId);
                    arVar2.ap("obj_locate", 3);
                    TiebaStatic.log(arVar2);
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
        if (bVar == null || cardViewHolder == null || cardViewHolder.ctb() == null) {
            return null;
        }
        cardViewHolder.ctb().a(bVar);
        cardViewHolder.ctb().c(this.hmS);
        if (this.mPageContext.getPageActivity() instanceof ForumSquareActivity) {
            String className = ((ForumSquareActivity) this.mPageContext.getPageActivity()).dLo().getClassName();
            if (!"推荐".equals(className)) {
                ar arVar = new ar("c13651");
                arVar.v("uid", TbadkCoreApplication.getCurrentAccountId());
                arVar.v("fid", bVar.forumId);
                arVar.dR("resource_id", className);
                TiebaStatic.log(arVar);
            } else {
                ar arVar2 = new ar("c13642");
                arVar2.v("uid", TbadkApplication.getCurrentAccountId());
                arVar2.v("fid", bVar.getForumId());
                arVar2.ap("obj_locate", 3);
                TiebaStatic.log(arVar2);
            }
        }
        return cardViewHolder.getView();
    }
}
