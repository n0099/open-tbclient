package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ConsumptionRecordsStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.consumptionRecords.ConsumptionRecordsStatic");
        hashMap.put("3001000", "com.baidu.tieba.consumptionRecords.ConsumptionRecordsStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("ConsumptionRecordsActivityConfig");
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_CONSUMPTION_RECORDS);
        hashMap.put("com.baidu.tieba.consumptionRecords.ConsumptionRecordsStatic", arrayList);
        return hashMap;
    }
}
