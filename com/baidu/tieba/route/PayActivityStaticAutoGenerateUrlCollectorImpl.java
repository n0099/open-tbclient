package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class PayActivityStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2001351", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2016457", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2921433", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2921432", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2001451", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2001447", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2921335", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2921393", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2001387", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        hashMap.put("2921539", "com.baidu.tieba.wallet.pay.PayActivityStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_FINANCIAL_FRS_SDK_TAB);
        arrayList.add(UrlSchemaHelper.SCHEMA_TYPE_GOTO_WALLET_SDK_ICACH);
        hashMap.put("com.baidu.tieba.wallet.pay.PayActivityStatic", arrayList);
        return hashMap;
    }
}
