package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class LocalVideoActivityStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add("RecordVideoActivityConfig");
        arrayList.add("EditVideoActivityConfig");
        arrayList.add("CloudMusicActivityConfig");
        hashMap.put("com.baidu.tieba.video.localvideo.LocalVideoActivityStatic", arrayList);
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2002001", "com.baidu.tieba.video.localvideo.LocalVideoActivityStatic");
        hashMap.put("2921466", "com.baidu.tieba.video.localvideo.LocalVideoActivityStatic");
        return hashMap;
    }
}
