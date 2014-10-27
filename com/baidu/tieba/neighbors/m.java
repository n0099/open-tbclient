package com.baidu.tieba.neighbors;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.b.a aVar;
        com.baidu.tbadk.b.a aVar2;
        com.baidu.tbadk.b.a aVar3;
        com.baidu.tbadk.b.a aVar4;
        aVar = NeighborsStatic.ant;
        if (aVar != null) {
            aVar2 = NeighborsStatic.ant;
            if (aVar2.ao(false) != null) {
                if (!UtilHelper.isNetOk()) {
                    aVar3 = NeighborsStatic.ant;
                    com.baidu.adp.lib.util.m.showToast(aVar3.getContext(), v.neterror);
                } else if (TbadkApplication.m251getInst().getLocationShared()) {
                    MessageManager messageManager = MessageManager.getInstance();
                    aVar4 = NeighborsStatic.ant;
                    messageManager.sendMessage(new CustomMessage(2002001, aVar4.ao(false)));
                } else {
                    NeighborsStatic.VU();
                }
            }
        }
    }
}
