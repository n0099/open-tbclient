package com.baidu.tieba.pb.pb.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.g {
    final /* synthetic */ k dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.dgn = kVar;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        com.baidu.tieba.tbadkCore.x xVar;
        com.baidu.tieba.tbadkCore.x xVar2;
        com.baidu.tieba.tbadkCore.y yVar;
        com.baidu.tieba.pb.data.e eVar;
        com.baidu.tieba.tbadkCore.x xVar3;
        com.baidu.tieba.pb.data.e eVar2;
        if (obj != null && (obj instanceof com.baidu.tieba.tbadkCore.y) && (yVar = (com.baidu.tieba.tbadkCore.y) obj) != null) {
            eVar = this.dgn.dfK;
            if (eVar.avD() != null) {
                xVar3 = this.dgn.Dp;
                if (xVar3.getErrorCode() == 0) {
                    eVar2 = this.dgn.dfK;
                    eVar2.avD().setLike(1);
                    yVar.setLike(1);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS, yVar));
                    return;
                }
            }
        }
        xVar = this.dgn.Dp;
        if (!StringUtils.isNull(xVar.getErrorString())) {
            TbadkCoreApplication m11getInst = TbadkCoreApplication.m11getInst();
            xVar2 = this.dgn.Dp;
            com.baidu.adp.lib.util.k.showToast(m11getInst, xVar2.getErrorString());
        }
    }
}
