package com.baidu.tieba.monitor.a;

import com.baidu.tieba.monitor.VideoMonitorStatic;
import org.json.JSONObject;
/* loaded from: classes.dex */
public interface c {
    JSONObject aNo();

    /* loaded from: classes.dex */
    public static abstract class a implements c {
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public a(int i) {
            this.state = i;
        }

        @Override // com.baidu.tieba.monitor.a.c
        public JSONObject aNo() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put("network_status", VideoMonitorStatic.aNn());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }
}
