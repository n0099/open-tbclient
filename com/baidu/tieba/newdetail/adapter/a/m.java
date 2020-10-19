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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes21.dex */
public class m extends a<bj, am<bj>> implements com.baidu.tieba.a.f {
    private String aht;
    private com.baidu.tbadk.h.f aiL;
    private v alC;
    private View.OnClickListener alr;
    private PullLeftRefreshLayout.a als;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alr = new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.adapter.a.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.als = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.m.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bAN() {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.aiL = new com.baidu.tbadk.h.f<bi>() { // from class: com.baidu.tieba.newdetail.adapter.a.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bi biVar, int i, long j) {
                if (biVar == null) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
                    return;
                }
                String forumName = biVar.getForumName();
                if (at.isForumName(forumName)) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.newdetail.b.c("c13739", biVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bi biVar, int i, long j) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.alC = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        ae aeVar = new ae(this.mPageContext, this.fey);
        aeVar.setShowSquareEntrance(false);
        aeVar.setEnableShowInto(false);
        aeVar.setShowMore(false);
        aeVar.setOnRullOkCallbackr(this.als);
        aeVar.setOnClickRightArrowListener(this.alr);
        aeVar.setOnItemCoverListener(this.aiL);
        aVar.c(aeVar);
        aVar.tU().bz(0);
        aVar.tU().bB(0);
        aVar.tU().bA(0);
        aVar.tU().bv(0);
        am amVar = new am(aVar.a(true, viewGroup, this.alC));
        amVar.setPageId(this.fey);
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, am<bj> amVar) {
        if (bjVar == null || amVar == null || amVar.getView() == null) {
            return null;
        }
        amVar.tW().setPosition(i);
        if (amVar.tW() instanceof com.baidu.tieba.a.e) {
            amVar.tW().setPage(this.aht);
        }
        amVar.b((am<bj>) bjVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return amVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }
}
