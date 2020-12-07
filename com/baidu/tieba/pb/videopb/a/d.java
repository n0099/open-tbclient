package com.baidu.tieba.pb.videopb.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.i;
import com.baidu.card.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.data.m;
import java.util.HashMap;
/* loaded from: classes22.dex */
public class d extends com.baidu.adp.widget.ListView.a<bx, am<by>> {
    public BdUniqueId fzO;
    private BdTypeRecyclerView jdj;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        aVar.tY().bA(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds36));
        s sVar = new s(this.mPageContext.getPageActivity());
        sVar.tO();
        aVar.a((i) sVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.EXTEND, viewGroup, this.jdj);
        a2.setSourceForPb(2);
        am<by> amVar = new am<>(a2);
        amVar.setPageId(this.fzO);
        a(new ab() { // from class: com.baidu.tieba.pb.videopb.a.d.1
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if (qVar instanceof bx) {
                    bx bxVar = (bx) qVar;
                    if (bxVar.eCR != null && bxVar.eIK && bxVar.eCR.bqV() != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemID", String.valueOf(bxVar.eCR.bqV().item_id));
                        hashMap.put("source", 3);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(TbadkApplication.getInst().getApplicationContext(), "GameItemDetailsPage", hashMap)));
                    }
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, am<by> amVar) {
        if (bxVar == null || amVar == null || amVar.getView() == null || bxVar.eCR == null) {
            return null;
        }
        bxVar.eCR.eHa = getPositionByType(i) + 1;
        amVar.tZ().setPosition(i);
        amVar.b((am<by>) bxVar.eCR);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    public void a(BdTypeRecyclerView bdTypeRecyclerView) {
        this.jdj = bdTypeRecyclerView;
    }
}
