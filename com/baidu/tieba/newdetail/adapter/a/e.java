package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes8.dex */
public class e extends a<by, ThreadCardViewHolder<bz>> {
    private aa<bz> ahf;
    private boolean alQ;
    private s anl;
    public BdUniqueId fJu;
    private TbPageContext<?> mPageContext;

    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alQ = true;
        this.ahf = new aa<bz>() { // from class: com.baidu.tieba.newdetail.adapter.a.e.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                com.baidu.tieba.card.s.cva().mG(true);
                e.this.g(view, bzVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.fJu = bdUniqueId2;
    }

    public void a(s sVar) {
        this.anl = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, bz bzVar) {
        com.baidu.tieba.newdetail.b.a(this, bzVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        y yVar = new y(this.mPageContext.getPageActivity());
        yVar.setFrom("index");
        yVar.setFromCDN(this.alQ);
        aVar.c(yVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        a2.setSourceForPb(17);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(a2);
        threadCardViewHolder.setPageId(this.fJu);
        a(new w() { // from class: com.baidu.tieba.newdetail.adapter.a.e.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder2 = (ThreadCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (e.this.ahf != null) {
                        e.this.ahf.a(threadCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 17, false);
                    threadCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, ThreadCardViewHolder<bz> threadCardViewHolder) {
        if (byVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || byVar.eMv == null) {
            return null;
        }
        byVar.eMv.eQR = getPositionByType(i) + 1;
        threadCardViewHolder.ty().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<bz>) byVar.eMv);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        com.baidu.tieba.newdetail.b.b(this, byVar);
        y yVar = (y) threadCardViewHolder.ty().tr();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.aiw.amp.getLayoutParams();
        layoutParams.width = byVar.eSI;
        layoutParams.height = byVar.eSJ;
        if (yVar.aiw.amp.getVisibility() != 8) {
            yVar.aiw.amp.setLayoutParams(layoutParams);
        }
        return threadCardViewHolder.getView();
    }
}
