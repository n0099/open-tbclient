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
        ArrayList<String> aHB;
        if (customMessage != null && (aHB = n.aHA().aHB()) != null && aHB.size() > 0) {
            TbadkCoreApplication.m411getInst().setSkinType(0);
            Iterator<String> it = aHB.iterator();
            while (it.hasNext()) {
                String next = it.next();
                List<b> mR = n.aHA().mR(next);
                if (mR != null && mR.size() > 0) {
                    for (b bVar : mR) {
                        if (bVar != null) {
                            com.baidu.tbadk.core.util.n.dc(String.valueOf(bVar.getId()) + ".apk");
                        }
                    }
                    n.aHA().mQ(next);
                    n.aHA().mP(next);
                }
            }
        }
        return null;
    }
}
