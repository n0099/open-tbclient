package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ae;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes7.dex */
public class m extends a<bm, ThreadCardViewHolder<bm>> implements com.baidu.tieba.a.f {
    private String air;
    private com.baidu.tbadk.h.f ajB;
    private View.OnClickListener ami;
    private PullLeftRefreshLayout.a amj;
    private s amu;
    public BdUniqueId fEN;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ami = new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.adapter.a.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.amj = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.m.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bGC() {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.ajB = new com.baidu.tbadk.h.f<bl>() { // from class: com.baidu.tieba.newdetail.adapter.a.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bl blVar, int i, long j) {
                if (blVar == null) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
                    return;
                }
                String forumName = blVar.getForumName();
                if (at.isForumName(forumName)) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.newdetail.b.c("c13739", blVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bl blVar, int i, long j) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.amu = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        ae aeVar = new ae(this.mPageContext, this.fEN);
        aeVar.setShowSquareEntrance(false);
        aeVar.setEnableShowInto(false);
        aeVar.setShowMore(false);
        aeVar.setOnRullOkCallbackr(this.amj);
        aeVar.setOnClickRightArrowListener(this.ami);
        aeVar.setOnItemCoverListener(this.ajB);
        aVar.c(aeVar);
        aVar.tl().bz(0);
        aVar.tl().bB(0);
        aVar.tl().bA(0);
        aVar.tl().bx(0);
        ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amu));
        threadCardViewHolder.setPageId(this.fEN);
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bm bmVar, ThreadCardViewHolder<bm> threadCardViewHolder) {
        if (bmVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
            return null;
        }
        threadCardViewHolder.tm().setPosition(i);
        if (threadCardViewHolder.tm() instanceof com.baidu.tieba.a.e) {
            threadCardViewHolder.tm().setPage(this.air);
        }
        threadCardViewHolder.b((ThreadCardViewHolder<bm>) bmVar);
        threadCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return threadCardViewHolder.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }
}
