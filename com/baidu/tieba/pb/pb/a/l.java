package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.g {
    final /* synthetic */ k ddT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.ddT = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.w wVar;
        com.baidu.tieba.tbadkCore.w wVar2;
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.tbadkCore.w wVar3;
        com.baidu.tieba.pb.data.e eVar2;
        if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.x) && (xVar = (com.baidu.tieba.tbadkCore.x) obj) != null) {
            eVar = this.ddT.ddq;
            if (eVar.avu() != null) {
                wVar3 = this.ddT.MY;
                if (wVar3.getErrorCode() == 0) {
                    eVar2 = this.ddT.ddq;
                    eVar2.avu().setLike(1);
                    xVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, xVar));
                    return;
                }
            }
        }
        wVar = this.ddT.MY;
        if (!StringUtils.isNull(wVar.getErrorString())) {
            TbadkCoreApplication m411getInst = TbadkCoreApplication.m411getInst();
            wVar2 = this.ddT.MY;
            com.baidu.adp.lib.util.k.showToast(m411getInst, wVar2.getErrorString());
        }
    }
}
