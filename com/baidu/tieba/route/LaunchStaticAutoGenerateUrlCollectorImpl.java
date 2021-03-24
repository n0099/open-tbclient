package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class LaunchStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tbadk.core.LaunchStatic");
        hashMap.put("2006002", "com.baidu.tbadk.core.LaunchStatic");
        hashMap.put("2016301", "com.baidu.tbadk.core.LaunchStatic");
        hashMap.put("2010001", "com.baidu.tbadk.core.LaunchStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("UpdateDialogConfig");
        arrayList.add("UpdateInfoServiceConfig");
        arrayList.add("SyncServiceConfig");
        arrayList.add("TbWebViewActivityConfig");
        arrayList.add("ShareWebActivityConfig");
        arrayList.add("InitUserNameDialogActivityConfig");
        hashMap.put("com.baidu.tbadk.core.LaunchStatic", arrayList);
        return hashMap;
    }
}
