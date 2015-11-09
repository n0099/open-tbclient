package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.tbadkCore.w;
import com.baidu.tieba.tbadkCore.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.g {
    final /* synthetic */ g chR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.chR = gVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        w wVar;
        w wVar2;
        x xVar;
        com.baidu.tieba.pb.a.c cVar;
        w wVar3;
        com.baidu.tieba.pb.a.c cVar2;
        if (obj != null && (obj instanceof x) && (xVar = (x) obj) != null) {
            cVar = this.chR.chP;
            if (cVar.afg() != null) {
                wVar3 = this.chR.LU;
                if (wVar3.getErrorCode() == 0) {
                    cVar2 = this.chR.chP;
                    cVar2.afg().setLike(1);
                    xVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
                    return;
                }
            }
        }
        wVar = this.chR.LU;
        if (!StringUtils.isNull(wVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            wVar2 = this.chR.LU;
            com.baidu.adp.lib.util.k.showToast(m411getInst, wVar2.getErrorString());
        }
    }
}
