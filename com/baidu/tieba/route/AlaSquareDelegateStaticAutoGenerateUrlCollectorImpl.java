package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public final class AlaSquareDelegateStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AlaLiveTabMyConcernActivityConfig");
        arrayList.add("AlaNewSquareSubListActivityConfig");
        arrayList.add(UrlSchemaHelper.JUMP_TO_VIDEO_SQUARE);
        arrayList.add("video/square");
        hashMap.put("com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2007002", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("2921399", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("2002001", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("2911006", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("2001616", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("2911008", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("2913033", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        hashMap.put("3001000", "com.baidu.tieba.ala.alasquare.AlaSquareDelegateStatic");
        return hashMap;
    }
}
