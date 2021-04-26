package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class TbLaunchStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tbadk.TbLaunchStatic");
        hashMap.put("2001142", "com.baidu.tbadk.TbLaunchStatic");
        hashMap.put("2001011", "com.baidu.tbadk.TbLaunchStatic");
        hashMap.put("2001145", "com.baidu.tbadk.TbLaunchStatic");
        hashMap.put("2001148", "com.baidu.tbadk.TbLaunchStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("GroupMsgImageActivityConfig");
        arrayList.add("WXEntryActivityConfig");
        hashMap.put("com.baidu.tbadk.TbLaunchStatic", arrayList);
        return hashMap;
    }
}
