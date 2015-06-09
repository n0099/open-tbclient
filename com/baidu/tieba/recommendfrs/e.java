package com.baidu.tieba.recommendfrs;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PbChosenActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.recommendfrs.a.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> {
    final /* synthetic */ b cbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cbF = bVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void m(int i, String str) {
        k kVar;
        kVar = this.cbF.cbx;
        com.baidu.tieba.recommendfrs.data.a io = kVar.io(i);
        if (io != null) {
            TiebaStatic.eventStat(this.cbF.getFragmentActivity(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String aht = io.aht();
            if (!StringUtils.isNull(aht)) {
                bi.tO().b(this.cbF.getPageContext(), new String[]{aht});
            } else {
                this.cbF.aX(str, io.ahv());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        k kVar;
        k kVar2;
        if (aVar != null) {
            kVar = this.cbF.cbx;
            if (kVar != null) {
                kVar2 = this.cbF.cbx;
                kVar2.setTitle(UtilHelper.getFixedText(aVar.ahu(), 14, true));
            }
        }
    }
}
