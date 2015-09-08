package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.recommendfrs.a.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> {
    final /* synthetic */ d cAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cAT = dVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        m mVar;
        TbPageContext<?> tbPageContext;
        mVar = this.cAT.cAH;
        com.baidu.tieba.recommendfrs.data.a jR = mVar.jR(i);
        if (jR != null) {
            TiebaStatic.eventStat(this.cAT.getContext(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String anw = jR.anw();
            if (!StringUtils.isNull(anw)) {
                ax uX = ax.uX();
                tbPageContext = this.cAT.pageContext;
                uX.b(tbPageContext, new String[]{anw});
                return;
            }
            this.cAT.bb(str, jR.any());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        m mVar;
        m mVar2;
        if (aVar != null) {
            mVar = this.cAT.cAH;
            if (mVar != null) {
                mVar2 = this.cAT.cAH;
                mVar2.setTitle(UtilHelper.getFixedText(aVar.anx(), 14, true));
            }
        }
    }
}
