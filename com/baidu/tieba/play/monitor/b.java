package com.baidu.tieba.play.monitor;

import com.baidu.tieba.j.i;
import com.baidu.tieba.recapp.activity.WebVideoActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static void a(i iVar, final long j) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.b.1
                private long ghR = 0;

                @Override // com.baidu.tieba.j.b
                public void S(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void T(JSONObject jSONObject) throws JSONException {
                    this.ghR = jSONObject.optLong("loadingTime");
                }

                @Override // com.baidu.tieba.j.b
                public void U(JSONObject jSONObject) throws JSONException {
                    if (this.ghR != 0 && j != 0 && this.ghR <= 86400000 && j <= 86400000) {
                        jSONObject.put("pbLoadingTime", j);
                        jSONObject.put("pbVideoPreview", this.ghR + j);
                    }
                }
            });
        }
    }

    public static void a(i iVar, final long j, final long j2, final long j3, final long j4) {
        if (iVar != null) {
            iVar.a(new com.baidu.tieba.j.b() { // from class: com.baidu.tieba.play.monitor.b.2
                @Override // com.baidu.tieba.j.b
                public void S(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void T(JSONObject jSONObject) throws JSONException {
                }

                @Override // com.baidu.tieba.j.b
                public void U(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("flow_count", j);
                    jSONObject.put("play_position", j2);
                    jSONObject.put(WebVideoActivityConfig.KEY_VIDEO_DURATION, j3);
                    jSONObject.put("play_seek_position", j4);
                }
            });
        }
    }
}
