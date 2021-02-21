package com.baidu.tieba.pb.videopb.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ak;
import com.baidu.card.h;
import com.baidu.card.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.data.m;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class d extends com.baidu.adp.widget.ListView.a<ca, ThreadCardViewHolder<cb>> {
    public BdUniqueId fGZ;
    private BdTypeRecyclerView jqY;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.fGZ = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.ti().by(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36));
        s sVar = new s(this.mPageContext.getPageActivity());
        sVar.sY();
        aVar.a((h) sVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.jqY);
        a2.setSourceForPb(2);
        ThreadCardViewHolder<cb> threadCardViewHolder = new ThreadCardViewHolder<>(a2);
        threadCardViewHolder.setPageId(this.fGZ);
        a(new w() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (nVar instanceof ca) {
                    ca caVar = (ca) nVar;
                    if (caVar.eJQ != null && caVar.eQe && caVar.eJQ.bpW() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemID", String.valueOf(caVar.eJQ.bpW().item_id));
                        hashMap.put("source", 3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                    }
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, ThreadCardViewHolder<cb> threadCardViewHolder) {
        if (caVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || caVar.eJQ == null) {
            return null;
        }
        caVar.eJQ.eOs = getPositionByType(i) + 1;
        threadCardViewHolder.tj().setPosition(i);
        threadCardViewHolder.b((ThreadCardViewHolder<cb>) caVar.eJQ);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        this.jqY = bdTypeRecyclerView;
    }
}
