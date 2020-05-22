package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.ah;
import com.baidu.card.e;
import com.baidu.card.j;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.k;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.personPolymeric.view.m;
/* loaded from: classes11.dex */
public class i extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> implements com.baidu.tieba.a.f {
    private aa<l> adt;
    private String aeX;
    public BdUniqueId epM;
    private int glW;
    private int kqO;
    private int kqP;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.aa$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        return a2(i, view, viewGroup, lVar, (com.baidu.card.a) aVar);
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.kqO = 0;
        this.kqP = 0;
        this.glW = 0;
        this.adt = new aa<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.aOi() != null) {
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
        cgg();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aY(1024);
        eVar.aY(32768);
        if (this.kqO > 0) {
            eVar.aX(this.kqO);
        }
        eVar.aC(false);
        eVar.aD(false);
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
        m mVar = new m(this.mPageContext.getPageActivity());
        mVar.setPageUniqueId(this.epM);
        mVar.setFrom(ConstantData.VideoLocationType.PERSON_PROFILE);
        aVar.c(mVar);
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25));
        aVar.a((com.baidu.card.h) new j(this.mPageContext.getPageActivity()));
        ah ahVar = new ah(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dAZ = 3;
        cVar.dBf = 3;
        ahVar.setAgreeStatisticData(cVar);
        ahVar.setFrom(8);
        ahVar.setStType("personalize_page");
        ahVar.setShareReportFrom(6);
        ahVar.bm(4);
        aVar.b(ahVar);
        aVar.rK().setBackgroundResource(R.drawable.addresslist_item_bg);
        ae rL = aVar.rL();
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(rL);
        aVar2.setPageId(this.epM);
        rL.a(this.adt);
        rL.setSourceForPb(4);
        aVar2.bl(this.kqP);
        a(new x() { // from class: com.baidu.tieba.personPolymeric.a.a.i.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof l) && (view.getTag() instanceof ag)) {
                    ag agVar = (ag) view.getTag();
                    l lVar = (l) oVar;
                    lVar.objType = 1;
                    if (i.this.adt != null) {
                        i.this.adt.a(agVar.getView(), lVar);
                    }
                    au.a((AbsThreadDataSupport) lVar, view.getContext(), 4, false, com.baidu.card.f.a((t) viewGroup2, view, i));
                    agVar.rM().b(new a.C0097a(1));
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
        lVar.sr(lVar.position + 1);
        if (aVar.rM() != null) {
            aVar.rM().setPage(this.aeX);
        }
        if (!this.mIsHost) {
            aVar.rO();
        }
        if (aVar.rM().rG() instanceof ah) {
            ((ah) aVar.rM().rG()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((t) viewGroup, view, i));
                    }
                }
            });
        }
        aVar.b((com.baidu.card.a) lVar);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a((aa<T>) this.adt);
        com.baidu.tieba.personPolymeric.a.h(lVar);
        return aVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
        this.aeX = str;
    }

    public void Br(int i) {
        this.kqO = i;
    }

    private void cgg() {
        k.gHr = "c13542";
    }

    public void setTabType(int i) {
        this.glW = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void Bq(int i) {
        this.kqP = i;
    }
}
