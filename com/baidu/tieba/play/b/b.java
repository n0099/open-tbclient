package com.baidu.tieba.play.b;

import com.baidu.tieba.i.i;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(i iVar, final long j) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.b.b.1
                private long guF = 0;

                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void I(JSONObject jSONObject) throws JSONException {
                    this.guF = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.i.b
                public void J(JSONObject jSONObject) throws JSONException {
                    if (this.guF != 0 && j != 0 && this.guF <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.guF + j);
                    }
                }
            });
        }
    }

    public static void a(i iVar, final long j, final long j2, final long j3, final long j4) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.i.b() { // from class: com.baidu.tieba.play.b.b.2
                @Override // com.baidu.tieba.i.b
                public void H(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void I(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.i.b
                public void J(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("flow_count", j);
                    jSONObject.put("play_position", j2);
                    jSONObject.put("video_duration", j3);
                    jSONObject.put("play_seek_position", j4);
                }
            });
        }
    }
}
