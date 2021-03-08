package com.baidu.tieba.personPolymeric.a.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.aa;
import com.baidu.card.ag;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.d;
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
/* loaded from: classes7.dex */
public class i extends com.baidu.adp.widget.ListView.a<l, AutoVideoCardViewHolder<l>> implements com.baidu.tieba.a.f {
    private ab<l> ahy;
    private String ajx;
    public BdUniqueId fIy;
    private int hYK;
    private int mBY;
    private int mBZ;
    private boolean mIsHost;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        return a2(i, view, viewGroup, lVar, (AutoVideoCardViewHolder) autoVideoCardViewHolder);
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.mBY = 0;
        this.mBZ = 0;
        this.hYK = 0;
        this.ahy = new ab<l>() { // from class: com.baidu.tieba.personPolymeric.a.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.blp() != null) {
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
        cPp();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fIy);
        dVar.bs(1024);
        dVar.bs(32768);
        if (this.mBY > 0) {
            dVar.br(this.mBY);
        }
        dVar.aC(false);
        dVar.aD(false);
        dVar.a(new d.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.2
            @Override // com.baidu.card.d.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (view != null && aVar2 != null && view.getId() != -1) {
                    int id = view.getId();
                    if (id == R.id.user_name || id == R.id.user_avatar) {
                        com.baidu.tieba.personPolymeric.a.a(view, aVar2, 1);
                    }
                }
            }
        });
        aVar.a(dVar);
        m mVar = new m(this.mPageContext.getPageActivity());
        mVar.setPageUniqueId(this.fIy);
        mVar.setFrom(ConstantData.VideoLocationType.PERSON_PROFILE);
        mVar.setStageType(null);
        aVar.c(mVar);
        aVar.ti().by(com.baidu.adp.lib.util.l.getDimens(this.mContext, R.dimen.tbds25));
        aVar.a((com.baidu.card.h) new s(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new aa(this.mPageContext.getPageActivity()));
        aVar.a((com.baidu.card.h) new k(this.mPageContext.getPageActivity()));
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.e eVar = new com.baidu.tbadk.core.data.e();
        eVar.eNB = 3;
        eVar.eNH = 3;
        amVar.setAgreeStatisticData(eVar);
        amVar.setFrom(8);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(6);
        amVar.setFromForPb(4);
        aVar.b(amVar);
        ak th = aVar.th();
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(th);
        autoVideoCardViewHolder.setPageId(this.fIy);
        th.a(this.ahy);
        th.setSourceForPb(4);
        autoVideoCardViewHolder.bD(this.mBZ);
        a(new w() { // from class: com.baidu.tieba.personPolymeric.a.a.i.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (i.this.ahy != null) {
                        i.this.ahy.a(threadCardViewHolder.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 4, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0095a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xe(lVar.position + 1);
        if (autoVideoCardViewHolder.tj() != null) {
            autoVideoCardViewHolder.tj().setPage(this.ajx);
        }
        if (!this.mIsHost) {
            autoVideoCardViewHolder.tl();
        }
        if (autoVideoCardViewHolder.tj().td() instanceof am) {
            ((am) autoVideoCardViewHolder.tj().td()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.personPolymeric.a.a.i.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup, view, i));
                    }
                }
            });
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a((ab<T>) this.ahy);
        com.baidu.tieba.personPolymeric.a.j(lVar);
        return autoVideoCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void ED(String str) {
        this.ajx = str;
    }

    public void Ha(int i) {
        this.mBY = i;
    }

    private void cPp() {
        com.baidu.tieba.card.data.k.iCH = "c13542";
    }

    public void setTabType(int i) {
        this.hYK = i;
    }

    public void setIsHost(boolean z) {
        this.mIsHost = z;
    }

    public void GZ(int i) {
        this.mBZ = i;
    }
}
