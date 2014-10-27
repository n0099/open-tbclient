package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Voice;
/* loaded from: classes.dex */
public class PersonInfoPostVoice implements Serializable {
    private static final long serialVersionUID = 481452998956093435L;
    private int duringTime;
    private int type;
    private String voiceMd5;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.duringTime = jSONObject.optInt("during_time");
            this.voiceMd5 = jSONObject.optString("voice_md5");
        }
    }

    public void parseProto(Voice voice) {
        if (voice != null) {
            this.type = voice.type.intValue();
            this.duringTime = voice.during_time.intValue();
            this.voiceMd5 = voice.voice_md5;
        }
    }

    public int getType() {
        return this.type;
    }

    public int getDuringTime() {
        return this.duringTime;
    }

    public String getVoiceMd5() {
        return this.voiceMd5;
    }
}
