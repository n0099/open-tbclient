package com.baidu.tieba.themeCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
class w implements CustomMessageTask.CustomRunnable<Object> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Object> run(CustomMessage<Object> customMessage) {
        ArrayList<String> aFm;
        if (customMessage != null && (aFm = n.aFl().aFm()) != null && aFm.size() > 0) {
            TbadkCoreApplication.m411getInst().setSkinType(0);
            Iterator<String> it = aFm.iterator();
            while (it.hasNext()) {
                String next = it.next();
                List<b> mT = n.aFl().mT(next);
                if (mT != null && mT.size() > 0) {
                    for (b bVar : mT) {
                        if (bVar != null) {
                            com.baidu.tbadk.core.util.n.cZ(String.valueOf(bVar.getId()) + ".apk");
                        }
                    }
                    n.aFl().mS(next);
                    n.aFl().mR(next);
                }
            }
        }
        return null;
    }
}
