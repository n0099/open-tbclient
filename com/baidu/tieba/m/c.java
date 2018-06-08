package com.baidu.tieba.m;

import com.baidu.ar.constants.HttpConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface c {
    JSONObject bmg();

    /* loaded from: classes2.dex */
    public static abstract class a implements c {
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public a(int i) {
            this.state = i;
        }

        @Override // com.baidu.tieba.m.c
        public JSONObject bmg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put(HttpConstants.TIMESTAMP, this.timestamp);
                jSONObject.put("network_status", VideoPlatformStatic.PZ());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b implements c {
        private final String source;
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public b(int i, String str) {
            this.state = i;
            this.source = str;
        }

        @Override // com.baidu.tieba.m.c
        public JSONObject bmg() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put("source", this.source);
                jSONObject.put(HttpConstants.TIMESTAMP, this.timestamp);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
