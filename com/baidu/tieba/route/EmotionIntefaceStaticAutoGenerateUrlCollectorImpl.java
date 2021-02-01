package com.baidu.tieba.route;

import com.baidu.adp.framework.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public final class EmotionIntefaceStaticAutoGenerateUrlCollectorImpl implements d {
    @Override // com.baidu.adp.framework.a.d
    public Map<String, ArrayList<String>> getConfigRouterMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic", new ArrayList());
        return hashMap;
    }

    @Override // com.baidu.adp.framework.a.d
    public Map<String, String> getCmdRouterMap() {
        HashMap hashMap = new HashMap();
        new ArrayList();
        hashMap.put("2010044", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        hashMap.put("2004602", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        hashMap.put("2004603", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        hashMap.put("2004604", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        hashMap.put("2004608", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        hashMap.put("2004609", "com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic");
        return hashMap;
    }
}
