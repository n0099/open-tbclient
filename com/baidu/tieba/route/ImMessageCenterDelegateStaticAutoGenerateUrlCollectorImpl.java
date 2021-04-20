package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class ImMessageCenterDelegateStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007002", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic");
        hashMap.put("2921002", "com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.imMessageCenter.im.chat.notify.ImMessageCenterDelegateStatic", new ArrayList());
        return hashMap;
    }
}
