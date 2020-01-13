package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.ag;
import com.baidu.card.e;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.z;
import com.baidu.tieba.personPolymeric.view.m;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> implements com.baidu.tieba.a.f {
    private z<l> JE;
    private String Lg;
    public BdUniqueId dxg;
    private int fpl;
    private int jlR;
    private int jlS;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.v$a] */
    @Override // com.baidu.adp.widget.ListView.a
    protected /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        return a2(i, view, viewGroup, lVar, (com.baidu.card.a) aVar);
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jlR = 0;
        this.jlS = 0;
        this.fpl = 0;
        this.JE = new z<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.axQ() != null) {
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
        bNs();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dxg);
        eVar.aI(1024);
        eVar.aI(32768);
        if (this.jlR > 0) {
            eVar.aH(this.jlR);
        }
        eVar.Y(false);
        eVar.Z(false);
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
        mVar.setPageUniqueId(this.dxg);
        mVar.setFrom(ConstantData.VideoLocationType.PERSON_PROFILE);
        aVar.c(mVar);
        aVar.mS().aN(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25));
        if (this.fpl == 2) {
            aVar.a((com.baidu.card.h) new com.baidu.card.i(this.mPageContext.getPageActivity()));
        }
        ag agVar = new ag(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.cJx = 3;
        dVar.cJD = 3;
        agVar.setAgreeStatisticData(dVar);
        agVar.setFrom(8);
        agVar.setStType("personalize_page");
        agVar.setShareReportFrom(6);
        agVar.aV(4);
        aVar.b(agVar);
        aVar.mS().setBackgroundResource(R.drawable.addresslist_item_bg);
        ad mT = aVar.mT();
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(mT);
        aVar2.setPageId(this.dxg);
        mT.a(this.JE);
        mT.aM(4);
        aVar2.aU(this.jlS);
        a(new s() { // from class: com.baidu.tieba.personPolymeric.a.a.i.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar2, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar2 instanceof l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    l lVar = (l) mVar2;
                    lVar.objType = 1;
                    if (i.this.JE != null) {
                        i.this.JE.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 4, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar.mU().b(new a.C0050a(1));
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
        lVar.rm(lVar.position + 1);
        if (aVar.mU() != null) {
            aVar.mU().setPage(this.Lg);
        }
        if (!this.mIsHost) {
            aVar.mW();
        }
        if (aVar.mU().mO() instanceof ag) {
            ((ag) aVar.mU().mO()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((r) viewGroup, view, i));
                    }
                }
            });
        }
        aVar.b((com.baidu.card.a) lVar);
        aVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mU().a((z<T>) this.JE);
        com.baidu.tieba.personPolymeric.a.d(lVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }

    public void zQ(int i) {
        this.jlR = i;
    }

    private void bNs() {
        k.fKw = "c13542";
    }

    public void setTabType(int i) {
        this.fpl = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void zP(int i) {
        this.jlS = i;
    }
}
