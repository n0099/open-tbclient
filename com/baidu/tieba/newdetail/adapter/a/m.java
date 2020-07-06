package com.baidu.tieba.newdetail.adapter.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.ac;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout;
/* loaded from: classes8.dex */
public class m extends a<bh, ak<bh>> implements com.baidu.tieba.a.f {
    private String afG;
    private com.baidu.tbadk.h.f agW;
    private View.OnClickListener ajn;
    private PullLeftRefreshLayout.a ajo;
    private v ajy;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajn = new View.OnClickListener() { // from class: com.baidu.tieba.newdetail.adapter.a.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.ajo = new PullLeftRefreshLayout.a() { // from class: com.baidu.tieba.newdetail.adapter.a.m.2
            @Override // com.baidu.tbadk.widget.horizontalpullview.PullLeftRefreshLayout.a
            public void bkn() {
                m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
            }
        };
        this.agW = new com.baidu.tbadk.h.f<bg>() { // from class: com.baidu.tieba.newdetail.adapter.a.m.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void a(View view, bg bgVar, int i, long j) {
                if (bgVar == null) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumSquareActivityConfig(m.this.mPageContext.getPageActivity(), m.this.mTabName)));
                    return;
                }
                String forumName = bgVar.getForumName();
                if (ar.isForumName(forumName)) {
                    m.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(m.this.mPageContext.getPageActivity()).createNormalCfg(forumName, FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND).setCallFrom(3)));
                    com.baidu.tieba.newdetail.b.b("c13739", bgVar, i + 1);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.h.f
            public void b(View view, bg bgVar, int i, long j) {
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        ac acVar = new ac(this.mPageContext, this.eyE);
        acVar.setShowSquareEntrance(false);
        acVar.setEnableShowInto(false);
        acVar.setShowMore(false);
        acVar.setOnRullOkCallbackr(this.ajo);
        acVar.setOnClickRightArrowListener(this.ajn);
        acVar.setOnItemCoverListener(this.agW);
        aVar.c(acVar);
        aVar.sc().bo(0);
        aVar.sc().bq(0);
        aVar.sc().bp(0);
        aVar.sc().bk(0);
        ak akVar = new ak(aVar.a(true, viewGroup, this.ajy));
        akVar.setPageId(this.eyE);
        return akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bh bhVar, ak<bh> akVar) {
        if (bhVar == null || akVar == null || akVar.getView() == null) {
            return null;
        }
        akVar.se().setPosition(i);
        if (akVar.se() instanceof com.baidu.tieba.a.e) {
            akVar.se().setPage(this.afG);
        }
        akVar.b((ak<bh>) bhVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        return akVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
