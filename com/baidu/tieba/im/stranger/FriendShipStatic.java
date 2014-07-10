package com.baidu.tieba.im.stranger;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class FriendShipStatic {
    static {
        e eVar = new e(0);
        eVar.setPriority(-10);
        MessageManager.getInstance().registerListener(2001178, eVar);
    }
}
