package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class TbadkStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2156675", "com.baidu.tbadk.coreExtra.messageCenter.TbadkStatic");
        hashMap.put("2002001", "com.baidu.tbadk.coreExtra.messageCenter.TbadkStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("SimpleVideoPlayActivityConfig");
        hashMap.put("com.baidu.tbadk.coreExtra.messageCenter.TbadkStatic", arrayList);
        return hashMap;
    }
}
