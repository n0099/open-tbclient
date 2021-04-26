package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class AlaJumpStatStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2911003", "com.baidu.tieba.ala.AlaJumpStatStatic");
        hashMap.put("2002001", "com.baidu.tieba.ala.AlaJumpStatStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AlaLiveRoomActivityConfig");
        arrayList.add("AlaMasterLiveRoomActivityConfig");
        arrayList.add("AlaWriteShareInBarActivityConfig");
        arrayList.add("AlaLiveFloatWindowActivityConfig");
        arrayList.add("AlaPersonCenterActivityConfig");
        hashMap.put("com.baidu.tieba.ala.AlaJumpStatStatic", arrayList);
        return hashMap;
    }
}
