package com.baidu.tieba.myCollection.runing;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class TiebaRuningTaskStatic {
    static {
        MessageManager.getInstance().registerListener(new d(2001011));
        MessageManager.getInstance().registerListener(new e(2005016));
    }
}
