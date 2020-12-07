package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.ae;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class m extends a<bl, am<bl>> implements com.baidu.tieba.a.f {
    private String aiw;
    private com.baidu.tbadk.h.f ajQ;
    private v amH;
    private View.OnClickListener amw;
    private PullLeftRefreshLayout.a amx;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.amw = new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.adapter.a.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.amx = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.m.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bHZ() {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.ajQ = new com.baidu.tbadk.h.f<bk>() { // from class: com.baidu.tieba.newdetail.adapter.a.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bk bkVar, int i, long j) {
                if (bkVar == null) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
                    return;
                }
                String forumName = bkVar.getForumName();
                if (au.isForumName(forumName)) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.newdetail.b.c("c13739", bkVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bk bkVar, int i, long j) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.amH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        ae aeVar = new ae(this.mPageContext, this.fzO);
        aeVar.setShowSquareEntrance(false);
        aeVar.setEnableShowInto(false);
        aeVar.setShowMore(false);
        aeVar.setOnRullOkCallbackr(this.amx);
        aeVar.setOnClickRightArrowListener(this.amw);
        aeVar.setOnItemCoverListener(this.ajQ);
        aVar.c(aeVar);
        aVar.tY().bB(0);
        aVar.tY().bD(0);
        aVar.tY().bC(0);
        aVar.tY().bz(0);
        am amVar = new am(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup, this.amH));
        amVar.setPageId(this.fzO);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bl blVar, am<bl> amVar) {
        if (blVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tZ().setPosition(i);
        if (amVar.tZ() instanceof com.baidu.tieba.a.e) {
            amVar.tZ().setPage(this.aiw);
        }
        amVar.b((am<bl>) blVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
