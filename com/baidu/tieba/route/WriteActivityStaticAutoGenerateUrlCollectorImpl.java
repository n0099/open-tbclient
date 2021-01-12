package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public final class WriteActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("WriteActivityConfig");
        arrayList.add("TransmitPostEditActivityConfig");
        arrayList.add("VcodeActivityConfig");
        arrayList.add("AlbumActivityConfig");
        arrayList.add("NewVcodeActivityConfig");
        arrayList.add("NewVcodeActivityConfig");
        arrayList.add("AtListActivityConfig");
        arrayList.add("WriteImageActivityConfig");
        arrayList.add("WriteMulitImageActivityConfig");
        arrayList.add("TransmitForumActivityConfig");
        arrayList.add("SelectForumActivityConfig");
        arrayList.add("HotTopicChangeActivityConfig");
        arrayList.add("AccountAccessActivityConfig");
        arrayList.add("AddLinkActivityConfig");
        hashMap.put("com.baidu.tieba.write.write.WriteActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.write.write.WriteActivityStatic");
        hashMap.put("2016301", "com.baidu.tieba.write.write.WriteActivityStatic");
        hashMap.put("2001449", "com.baidu.tieba.write.write.WriteActivityStatic");
        return hashMap;
    }
}
