package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PushDialogStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.pushdialog.PushDialogStatic");
        hashMap.put("2921359", "com.baidu.tieba.pushdialog.PushDialogStatic");
        hashMap.put("2921360", "com.baidu.tieba.pushdialog.PushDialogStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("PushDialogActivityConfig");
        hashMap.put("com.baidu.tieba.pushdialog.PushDialogStatic", arrayList);
        return hashMap;
    }
}
