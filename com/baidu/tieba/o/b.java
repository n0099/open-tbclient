package com.baidu.tieba.o;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public interface b {
    JSONObject dCL();

    /* loaded from: classes23.dex */
    public static abstract class a implements b {
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public a(int i) {
            this.state = i;
        }

        @Override // com.baidu.tieba.o.b
        public JSONObject dCL() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.getNetwork());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: com.baidu.tieba.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public static abstract class AbstractC0820b implements b {
        private final String source;
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public AbstractC0820b(int i, String str) {
            this.state = i;
            this.source = str;
        }

        @Override // com.baidu.tieba.o.b
        public JSONObject dCL() {
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
