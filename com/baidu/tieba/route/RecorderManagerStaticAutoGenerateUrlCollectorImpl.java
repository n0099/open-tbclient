package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes23.dex */
public final class RecorderManagerStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.audiorecorder.lib.voice.RecorderManagerStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2001271", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic");
        hashMap.put("2001448", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic");
        hashMap.put("2001301", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic");
        hashMap.put("2001291", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic");
        hashMap.put("2001274", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic");
        hashMap.put("2001272", "com.baidu.audiorecorder.lib.voice.RecorderManagerStatic");
        return hashMap;
    }
}
