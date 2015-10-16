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
    final /* synthetic */ d cIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cIu = dVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        m mVar;
        TbPageContext<?> tbPageContext;
        mVar = this.cIu.cIi;
        com.baidu.tieba.recommendfrs.data.a ks = mVar.ks(i);
        if (ks != null) {
            TiebaStatic.eventStat(this.cIu.getContext(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String apU = ks.apU();
            if (!StringUtils.isNull(apU)) {
                az uW = az.uW();
                tbPageContext = this.cIu.pageContext;
                uW.b(tbPageContext, new String[]{apU});
                return;
            }
            this.cIu.bb(str, ks.apW());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        m mVar;
        m mVar2;
        if (aVar != null) {
            mVar = this.cIu.cIi;
            if (mVar != null) {
                mVar2 = this.cIu.cIi;
                mVar2.setTitle(UtilHelper.getFixedText(aVar.apV(), 14, true));
            }
        }
    }
}
