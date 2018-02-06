package com.baidu.tieba.play.monitor;

import com.baidu.tieba.i.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(i iVar, final long j) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.monitor.b.1
                private long gwl = 0;

                @Override // com.baidu.tieba.i.b
                public void M(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void N(JSONObject jSONObject) throws JSONException {
                    this.gwl = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.i.b
                public void O(JSONObject jSONObject) throws JSONException {
                    if (this.gwl != 0 && j != 0 && this.gwl <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.gwl + j);
                    }
                }
            });
        }
    }

    public static void a(i iVar, final long j, final long j2, final long j3, final long j4) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.monitor.b.2
                @Override // com.baidu.tieba.i.b
                public void M(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void N(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void O(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("flow_count", j);
                    jSONObject.put("play_position", j2);
                    jSONObject.put(WebVideoActivityConfig.KEY_VIDEO_DURATION, j3);
                    jSONObject.put("play_seek_position", j4);
                }
            });
        }
    }
}
