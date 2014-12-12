package com.baidu.tieba.myCollection;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class EditMarkStatic {
    private static com.baidu.tbadk.mainTab.f aNZ;
    private static com.baidu.tbadk.mainTab.e bwJ;
    private static int msgCount = 0;

    static {
        d dVar = new d(2007007);
        dVar.setPriority(1);
        MessageManager.getInstance().registerListener(dVar);
        MessageManager.getInstance().registerListener(new f(2001124));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001274));
    }
}
