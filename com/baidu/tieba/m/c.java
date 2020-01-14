package com.baidu.tieba.m;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public interface c {
    JSONObject cyr();

    /* loaded from: classes8.dex */
    public static abstract class a implements c {
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public a(int i) {
            this.state = i;
        }

        @Override // com.baidu.tieba.m.c
        public JSONObject cyr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.aVk());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b implements c {
        private final String source;
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public b(int i, String str) {
            this.state = i;
            this.source = str;
        }

        @Override // com.baidu.tieba.m.c
        public JSONObject cyr() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put("source", this.source);
                jSONObject.put("timestamp", this.timestamp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
