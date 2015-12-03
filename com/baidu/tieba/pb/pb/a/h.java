package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.x;
import com.baidu.tieba.tbadkCore.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g {
    final /* synthetic */ g cAo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.cAo = gVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        x xVar;
        x xVar2;
        y yVar;
        com.baidu.tieba.pb.a.c cVar;
        x xVar3;
        com.baidu.tieba.pb.a.c cVar2;
        if (obj != null && (obj instanceof y) && (yVar = (y) obj) != null) {
            cVar = this.cAo.cAm;
            if (cVar.ajy() != null) {
                xVar3 = this.cAo.Ml;
                if (xVar3.getErrorCode() == 0) {
                    cVar2 = this.cAo.cAm;
                    cVar2.ajy().setLike(1);
                    yVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
                    return;
                }
            }
        }
        xVar = this.cAo.Ml;
        if (!StringUtils.isNull(xVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            xVar2 = this.cAo.Ml;
            com.baidu.adp.lib.util.k.showToast(m411getInst, xVar2.getErrorString());
        }
    }
}
