package com.baidu.tieba.route;

import com.baidu.adp.framework.cmdRouter.ICmdRouter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class FaceshopStaticAutoGenerateUrlCollectorImpl implements ICmdRouter {
    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2004612", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2004602", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2004610", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2004611", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2001141", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2902013", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2902011", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2902012", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2902015", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("2902014", "com.baidu.tieba.faceshop.FaceshopStatic");
        hashMap.put("3001000", "com.baidu.tieba.faceshop.FaceshopStatic");
        return hashMap;
    }

    @Override // com.baidu.adp.framework.cmdRouter.ICmdRouter
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("UserCollectManageActivityConfig");
        arrayList.add("EmotionPackageDetailActivityConfig");
        arrayList.add("EmotionDetailActivityConfig");
        arrayList.add("UserAlbumActivityConfig");
        arrayList.add("FaceShopActivityConfig");
        arrayList.add("NewFaceShopActivityConfig");
        arrayList.add("FaceGroupMakeActivityConfig");
        arrayList.add("FaceGroupMakeActivityConfig");
        arrayList.add("PickFaceTabActivityConfig");
        arrayList.add("EmotionCenterActivityConfig");
        arrayList.add("SelectSingleForumActivityConfig");
        arrayList.add("CommonEmotionManagerActivityConfig");
        arrayList.add("NativeEmotionManagerActivityConfig");
        arrayList.add("interact/tbowneremoji");
        hashMap.put("com.baidu.tieba.faceshop.FaceshopStatic", arrayList);
        return hashMap;
    }
}
