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
    final /* synthetic */ b cbE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cbE = bVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void m(int i, String str) {
        k kVar;
        kVar = this.cbE.cbw;
        com.baidu.tieba.recommendfrs.data.a io = kVar.io(i);
        if (io != null) {
            TiebaStatic.eventStat(this.cbE.getFragmentActivity(), "kantie_banner", null, 1, "loc", Integer.valueOf(i), PbChosenActivityConfig.KEY_TID, str);
            String ahs = io.ahs();
            if (!StringUtils.isNull(ahs)) {
                bi.tO().b(this.cbE.getPageContext(), new String[]{ahs});
            } else {
                this.cbE.aX(str, io.ahu());
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        k kVar;
        k kVar2;
        if (aVar != null) {
            kVar = this.cbE.cbw;
            if (kVar != null) {
                kVar2 = this.cbE.cbw;
                kVar2.setTitle(UtilHelper.getFixedText(aVar.aht(), 14, true));
            }
        }
    }
}
