package com.baidu.tieba.play.monitor;

import com.baidu.tieba.k.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(i iVar, final long j, final long j2, final long j3, final long j4) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.k.b() { // from class: com.baidu.tieba.play.monitor.b.1
                @Override // com.baidu.tieba.k.b
                public void dB(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dC(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.k.b
                public void dD(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("flow_count", j);
                    jSONObject.put("play_position", j2);
                    jSONObject.put("video_duration", j3);
                    jSONObject.put("play_seek_position", j4);
                }
            });
        }
    }
}
