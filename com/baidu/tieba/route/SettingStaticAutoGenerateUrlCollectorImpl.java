package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class SettingStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("AppsActivityConfig");
        arrayList.add("BrowseSettingActivityConfig");
        arrayList.add("AdSettingActivityConfig");
        arrayList.add("MsgRemindActivityConfig");
        arrayList.add("SystemHelpSettingActivityConfig");
        arrayList.add("MsgReceiveActivityConfig");
        arrayList.add("SecretSettingActivityConfig");
        arrayList.add("AboutActivityConfig");
        arrayList.add("PrivacyPermissionActivityConfig");
        arrayList.add("OfficialAccountPushActivityConfig");
        hashMap.put("com.baidu.tieba.setting.more.SettingStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.setting.more.SettingStatic");
        hashMap.put("2015004", "com.baidu.tieba.setting.more.SettingStatic");
        hashMap.put("2016302", "com.baidu.tieba.setting.more.SettingStatic");
        hashMap.put("2005016", "com.baidu.tieba.setting.more.SettingStatic");
        hashMap.put("2001311", "com.baidu.tieba.setting.more.SettingStatic");
        hashMap.put("2921330", "com.baidu.tieba.setting.more.SettingStatic");
        return hashMap;
    }
}
