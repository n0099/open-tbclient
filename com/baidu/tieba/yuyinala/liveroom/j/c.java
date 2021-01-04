package com.baidu.tieba.yuyinala.liveroom.j;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {

    /* loaded from: classes11.dex */
    public interface a {
        void VP(String str);
    }

    public static void b(com.baidu.tieba.yuyinala.liveroom.data.a aVar, com.baidu.live.im.data.b bVar, JSONObject jSONObject, a aVar2) {
        if (jSONObject != null) {
            new d().a(aVar, bVar, jSONObject, aVar2);
        }
    }

    public static void a(com.baidu.tieba.yuyinala.liveroom.data.a aVar, com.baidu.live.im.data.b bVar, JSONObject jSONObject) {
        new b().a(aVar, bVar, jSONObject, null);
    }
}
