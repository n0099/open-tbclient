package com.baidu.tieba.n;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.tieba.VideoPlatformStatic;
import org.json.JSONObject;
/* loaded from: classes17.dex */
public interface b {
    JSONObject dkS();

    /* loaded from: classes17.dex */
    public static abstract class a implements b {
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public a(int i) {
            this.state = i;
        }

        @Override // com.baidu.tieba.n.b
        public JSONObject dkS() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", this.state);
                jSONObject.put("timestamp", this.timestamp);
                jSONObject.put(DpStatConstants.KEY_NETWORK_STATUS, VideoPlatformStatic.nj());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    /* renamed from: com.baidu.tieba.n.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static abstract class AbstractC0750b implements b {
        private final String source;
        public final int state;
        private final long timestamp = System.currentTimeMillis();

        public AbstractC0750b(int i, String str) {
            this.state = i;
            this.source = str;
        }

        @Override // com.baidu.tieba.n.b
        public JSONObject dkS() {
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
