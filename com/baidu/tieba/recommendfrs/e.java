package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.recommendfrs.a.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> {
    final /* synthetic */ d csB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.csB = dVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        l lVar;
        TbPageContext<?> tbPageContext;
        lVar = this.csB.csn;
        com.baidu.tieba.recommendfrs.data.a jh = lVar.jh(i);
        if (jh != null) {
            TiebaStatic.eventStat(this.csB.getContext(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String ajs = jh.ajs();
            if (!StringUtils.isNull(ajs)) {
                ax uR = ax.uR();
                tbPageContext = this.csB.pageContext;
                uR.b(tbPageContext, new String[]{ajs});
                return;
            }
            this.csB.aX(str, jh.aju());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        l lVar;
        l lVar2;
        if (aVar != null) {
            lVar = this.csB.csn;
            if (lVar != null) {
                lVar2 = this.csB.csn;
                lVar2.setTitle(UtilHelper.getFixedText(aVar.ajt(), 14, true));
            }
        }
    }
}
