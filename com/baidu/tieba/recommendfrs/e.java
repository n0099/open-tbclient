package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.recommendfrs.a.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> {
    final /* synthetic */ d cHV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cHV = dVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void o(int i, String str) {
        m mVar;
        TbPageContext<?> tbPageContext;
        mVar = this.cHV.cHJ;
        com.baidu.tieba.recommendfrs.data.a kq = mVar.kq(i);
        if (kq != null) {
            TiebaStatic.eventStat(this.cHV.getContext(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String apO = kq.apO();
            if (!StringUtils.isNull(apO)) {
                ay uV = ay.uV();
                tbPageContext = this.cHV.pageContext;
                uV.b(tbPageContext, new String[]{apO});
                return;
            }
            this.cHV.bb(str, kq.apQ());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        m mVar;
        m mVar2;
        if (aVar != null) {
            mVar = this.cHV.cHJ;
            if (mVar != null) {
                mVar2 = this.cHV.cHJ;
                mVar2.setTitle(UtilHelper.getFixedText(aVar.apP(), 14, true));
            }
        }
    }
}
