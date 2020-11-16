package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aa;
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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.personPolymeric.view.m;
/* loaded from: classes23.dex */
public class i extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> implements com.baidu.tieba.a.f {
    private ab<l> afK;
    private String ahw;
    public BdUniqueId fsa;
    private int hBg;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;
    private int mbR;
    private int mbS;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        return a2(i, view, viewGroup, lVar, (com.baidu.card.a) aVar);
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mbR = 0;
        this.mbS = 0;
        this.hBg = 0;
        this.afK = new ab<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bjd() != null) {
                    int id = view.getId();
                    if (id == R.id.thread_card_root || id == R.id.video_seg_title) {
                        com.baidu.tieba.personPolymeric.a.a(view, lVar, 2);
                    } else if (id == R.id.operable_video_container) {
                        com.baidu.tieba.personPolymeric.a.a(view, lVar, 4);
                    } else if (id == R.id.forum_name_text) {
                        com.baidu.tieba.personPolymeric.a.a(view, lVar, 7);
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsa);
        eVar.bp(1024);
        eVar.bp(32768);
        if (this.mbR > 0) {
            eVar.bo(this.mbR);
        }
        eVar.aE(false);
        eVar.aF(false);
        eVar.a(new e.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.2
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (view != null && aVar2 != null && view.getId() != -1) {
                    int id = view.getId();
                    if (id == R.id.user_name || id == R.id.user_avatar) {
                        com.baidu.tieba.personPolymeric.a.a(view, aVar2, 1);
                    }
                }
            }
        });
        aVar.a(eVar);
        m mVar = new m(this.mPageContext.getPageActivity());
        mVar.setPageUniqueId(this.fsa);
        mVar.setFrom(ConstantData.VideoLocationType.PERSON_PROFILE);
        mVar.setStageType(null);
        aVar.c(mVar);
        aVar.tV().bv(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25));
        aVar.a((com.baidu.card.i) new s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.i) new k(this.mPageContext.getPageActivity()));
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.exI = 3;
        dVar.exO = 3;
        anVar.setAgreeStatisticData(dVar);
        anVar.setFrom(8);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(6);
        anVar.setFromForPb(4);
        aVar.b(anVar);
        ak tU = aVar.tU();
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(tU);
        aVar2.setPageId(this.fsa);
        tU.a(this.afK);
        tU.setSourceForPb(4);
        aVar2.bA(this.mbS);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.personPolymeric.a.a.i.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (i.this.afK != null) {
                        i.this.afK.a(amVar.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 4, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
                }
            }
        });
        return aVar2;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, l lVar, com.baidu.card.a aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.xH(lVar.position + 1);
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.ahw);
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
        aVar.b((com.baidu.card.a) lVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a((ab<T>) this.afK);
        com.baidu.tieba.personPolymeric.a.i(lVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
        this.ahw = str;
    }

    public void HB(int i) {
        this.mbR = i;
    }

    private void cIA() {
        com.baidu.tieba.card.data.k.icn = "c13542";
    }

    public void setTabType(int i) {
        this.hBg = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void HA(int i) {
        this.mbS = i;
    }
}
