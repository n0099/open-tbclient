package com.baidu.tieba.pb.pb.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.m;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class g extends com.baidu.adp.widget.ListView.a<k, am<k>> {
    private ab<k> agG;
    private v amH;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;

    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<k>() { // from class: com.baidu.tieba.pb.pb.a.g.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, k kVar) {
                t.csh().mj(true);
                if (view != null && kVar != null && kVar.bmn() != null && !StringUtils.isNull(kVar.bmn().getTid())) {
                    g.this.b(view, kVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.amH = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, k kVar) {
        int id = view.getId();
        if (kVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                com.baidu.tieba.pb.c.a.a(kVar, 2);
            } else {
                com.baidu.tieba.pb.c.a.a(kVar, 1);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        aVar.a(new m(this.mPageContext.getPageActivity()));
        am<k> amVar = new am<>(aVar.aL(true).a(BaseCardInfo.SupportType.TOP, viewGroup, this.amH));
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.pb.pb.a.g.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof k) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    k kVar = (k) qVar;
                    kVar.objType = 1;
                    if (g.this.agG != null) {
                        g.this.agG.a(amVar2.getView(), kVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) kVar, view.getContext(), 0, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, k kVar, am<k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.eCR == null) {
            return null;
        }
        kVar.ym(kVar.position + 1);
        amVar.tZ().setPosition(i);
        amVar.a(false, Align.ALIGN_RIGHT_TOP, null);
        amVar.b((am<k>) kVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        com.baidu.tieba.pb.c.a.i(kVar);
        return amVar.getView();
    }
}
