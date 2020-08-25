package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.af;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.card.e;
import com.baidu.card.j;
import com.baidu.card.r;
import com.baidu.card.z;
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
/* loaded from: classes18.dex */
public class i extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> implements com.baidu.tieba.a.f {
    private aa<m> aeT;
    private String agH;
    public BdUniqueId ePv;
    private int gQW;
    private int lkK;
    private int lkL;
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
        this.lkK = 0;
        this.lkL = 0;
        this.gQW = 0;
        this.aeT = new aa<m>() { // from class: com.baidu.tieba.personPolymeric.a.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, m mVar) {
                if (view != null && mVar != null && mVar.bce() != null) {
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
        cyk();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<m> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePv);
        eVar.bl(1024);
        eVar.bl(32768);
        if (this.lkK > 0) {
            eVar.bk(this.lkK);
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
        mVar.setPageUniqueId(this.ePv);
        mVar.setFrom(ConstantData.VideoLocationType.PERSON_PROFILE);
        mVar.setStageType(null);
        aVar.c(mVar);
        aVar.tP().br(l.getDimens(this.mContext, R.dimen.tbds25));
        r rVar = new r(this.mPageContext.getPageActivity());
        rVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) rVar);
        af afVar = new af(this.mPageContext.getPageActivity());
        afVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) afVar);
        z zVar = new z(this.mPageContext.getPageActivity());
        zVar.setTopMargin(l.getDimens(this.mContext, R.dimen.tbds32));
        aVar.a((com.baidu.card.h) zVar);
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 3;
        cVar.dWQ = 3;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(8);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        aVar.tP().setBackgroundResource(R.drawable.addresslist_item_bg);
        aj tQ = aVar.tQ();
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(tQ);
        aVar2.setPageId(this.ePv);
        tQ.a(this.aeT);
        tQ.setSourceForPb(4);
        aVar2.by(this.lkL);
        a(new ab() { // from class: com.baidu.tieba.personPolymeric.a.a.i.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof al)) {
                    al alVar = (al) view.getTag();
                    m mVar2 = (m) qVar;
                    mVar2.objType = 1;
                    if (i.this.aeT != null) {
                        i.this.aeT.a(alVar.getView(), mVar2);
                    }
                    ay.a((AbsThreadDataSupport) mVar2, view.getContext(), 4, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    alVar.tR().b(new a.C0095a(1));
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
        mVar.vy(mVar.position + 1);
        if (aVar.tR() != null) {
            aVar.tR().setPage(this.agH);
        }
        if (!this.mIsHost) {
            aVar.tT();
        }
        if (aVar.tR().tL() instanceof am) {
            ((am) aVar.tR().tL()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((v) viewGroup, view, i));
                    }
                }
            });
        }
        aVar.b((com.baidu.card.a) mVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a((aa<T>) this.aeT);
        com.baidu.tieba.personPolymeric.a.h(mVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    public void Fq(int i) {
        this.lkK = i;
    }

    private void cyk() {
        com.baidu.tieba.card.data.l.hmZ = "c13542";
    }

    public void setTabType(int i) {
        this.gQW = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Fp(int i) {
        this.lkL = i;
    }
}
