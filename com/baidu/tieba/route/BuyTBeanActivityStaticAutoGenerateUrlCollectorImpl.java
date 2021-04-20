package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.TbConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class BuyTBeanActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.tbean.BuyTBeanActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.tbean.BuyTBeanActivityStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("BuyTBeanActivityConfig");
        arrayList.add("tdoudiscount:");
        arrayList.add(TbConfig.WEB_VIEW_JUMP2NATIVE);
        hashMap.put("com.baidu.tieba.tbean.BuyTBeanActivityStatic", arrayList);
        return hashMap;
    }
}
