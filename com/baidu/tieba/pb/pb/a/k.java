package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.g {
    final /* synthetic */ j cKB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cKB = jVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.pb.a.c cVar;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.pb.a.c cVar2;
        if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.x) && (xVar = (com.baidu.tieba.tbadkCore.x) obj) != null) {
            cVar = this.cKB.cJZ;
            if (cVar.aoE() != null) {
                wVar3 = this.cKB.MS;
                if (wVar3.getErrorCode() == 0) {
                    cVar2 = this.cKB.cJZ;
                    cVar2.aoE().setLike(1);
                    xVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
                    return;
                }
            }
        }
        wVar = this.cKB.MS;
        if (!StringUtils.isNull(wVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            wVar2 = this.cKB.MS;
            com.baidu.adp.lib.util.k.showToast(m411getInst, wVar2.getErrorString());
        }
    }
}
