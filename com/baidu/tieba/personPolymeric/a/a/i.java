package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.card.e;
import com.baidu.card.k;
import com.baidu.card.s;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.m;
/* loaded from: classes24.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> implements com.baidu.tieba.a.f {
    private aa<m> afE;
    private String aht;
    public BdUniqueId fey;
    private int hjG;
    private int lJe;
    private int lJf;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.card.a<m> aVar) {
        return a2(i, view, viewGroup, mVar, (com.baidu.card.a) aVar);
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.lJe = 0;
        this.lJf = 0;
        this.hjG = 0;
        this.afE = new aa<m>() { // from class: com.baidu.tieba.personPolymeric.a.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, m mVar) {
                if (view != null && mVar != null && mVar.bfG() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.video_seg_title) {
                        com.baidu.tieba.personPolymeric.a.a(view, mVar, 2);
                    } else if (id == R.id.operable_video_container) {
                        com.baidu.tieba.personPolymeric.a.a(view, mVar, 4);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, mVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cDn();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a<m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fey);
        eVar.bp(1024);
        eVar.bp(32768);
        if (this.lJe > 0) {
            eVar.bo(this.lJe);
        }
        eVar.aE(false);
        eVar.aF(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.2
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (view != null && absThreadDataSupport != null && view.getId() != -1) {
                    int id = view.getId();
                    if (id == R.id.user_name || id == R.id.user_avatar) {
                        com.baidu.tieba.personPolymeric.a.a(view, absThreadDataSupport, 1);
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.tieba.personPolymeric.view.m mVar = new com.baidu.tieba.personPolymeric.view.m(this.mPageContext.getPageActivity());
        mVar.setPageUniqueId(this.fey);
        mVar.setFrom(ConstantData.VideoLocationType.PERSON_PROFILE);
        mVar.setStageType(null);
        aVar.c(mVar);
        aVar.tU().bv(l.getDimens(this.mContext, R.dimen.tbds25));
        s sVar = new s(this.mPageContext.getPageActivity());
        sVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) sVar);
        ag agVar = new ag(this.mPageContext.getPageActivity());
        agVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) agVar);
        com.baidu.card.aa aaVar = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        aaVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.i) aaVar);
        aVar.a((com.baidu.card.i) new k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 3;
        cVar.elg = 3;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(8);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        aVar.tU().setBackgroundResource(R.drawable.addresslist_item_bg);
        ak tV = aVar.tV();
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(tV);
        aVar2.setPageId(this.fey);
        tV.a(this.afE);
        tV.setSourceForPb(4);
        aVar2.bC(this.lJf);
        a(new ab() { // from class: com.baidu.tieba.personPolymeric.a.a.i.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar2 = (m) qVar;
                    mVar2.objType = 1;
                    if (i.this.afE != null) {
                        i.this.afE.a(amVar.getView(), mVar2);
                    }
                    ay.a((AbsThreadDataSupport) mVar2, view.getContext(), 4, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0097a(1));
                }
            }
        });
        return aVar2;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, m mVar, com.baidu.card.a aVar) {
        if (mVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        mVar.wD(mVar.position + 1);
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.aht);
        }
        if (!this.mIsHost) {
            aVar.tY();
        }
        if (aVar.tW().tQ() instanceof an) {
            ((an) aVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((v) viewGroup, view, i));
                    }
                }
            });
        }
        aVar.b((com.baidu.card.a) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a((aa<T>) this.afE);
        com.baidu.tieba.personPolymeric.a.i(mVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    public void Gx(int i) {
        this.lJe = i;
    }

    private void cDn() {
        com.baidu.tieba.card.data.l.hJb = "c13542";
    }

    public void setTabType(int i) {
        this.hjG = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Gw(int i) {
        this.lJf = i;
    }
}
