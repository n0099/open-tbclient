package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.recommendfrs.a.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> {
    final /* synthetic */ d cJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cJQ = dVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        m mVar;
        TbPageContext<?> tbPageContext;
        mVar = this.cJQ.cJE;
        com.baidu.tieba.recommendfrs.data.a kG = mVar.kG(i);
        if (kG != null) {
            TiebaStatic.eventStat(this.cJQ.getContext(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String aqw = kG.aqw();
            if (!StringUtils.isNull(aqw)) {
                az uX = az.uX();
                tbPageContext = this.cJQ.pageContext;
                uX.b(tbPageContext, new String[]{aqw});
                return;
            }
            this.cJQ.ba(str, kG.aqy());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        m mVar;
        m mVar2;
        if (aVar != null) {
            mVar = this.cJQ.cJE;
            if (mVar != null) {
                mVar2 = this.cJQ.cJE;
                mVar2.setTitle(UtilHelper.getFixedText(aVar.aqx(), 14, true));
            }
        }
    }
}
