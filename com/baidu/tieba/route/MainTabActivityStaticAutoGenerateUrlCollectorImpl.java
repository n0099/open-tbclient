package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class MainTabActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(UrlSchemaHelper.GOTO_ENTERFORUM_TAB);
        arrayList.add(UrlSchemaHelper.GOTO_RECOMMNEDS_FRS_TAB);
        arrayList.add("n/video/opersquare?jump_to_publish_video_thread=1");
        arrayList.add("tiebavr:");
        arrayList.add("tieba://homepage_livetab?");
        hashMap.put("com.baidu.tieba.tblauncher.MainTabActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002004", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
        hashMap.put("2012111", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
        hashMap.put("2012118", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
        hashMap.put("2001626", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
        hashMap.put("2015002", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
        hashMap.put("3001000", "com.baidu.tieba.tblauncher.MainTabActivityStatic");
        return hashMap;
    }
}
