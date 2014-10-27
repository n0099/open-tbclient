package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Abstract;
/* loaded from: classes.dex */
public class PersonInfoAbstract implements Serializable {
    private static final long serialVersionUID = -4416166520587459871L;
    private String during_time;
    private String link;
    private String src;
    private String text;
    private int type;
    private String un;
    private String voice_md5;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.text = jSONObject.optString("text");
            this.link = jSONObject.optString("link");
            this.src = jSONObject.optString("src");
            this.un = jSONObject.optString("un");
            this.during_time = jSONObject.optString("during_time");
            this.voice_md5 = jSONObject.optString("voice_md5");
        }
    }

    public void parseProto(Abstract r2) {
        if (r2 != null) {
            this.type = r2.type.intValue();
            this.text = r2.text;
            this.link = r2.link;
            this.src = r2.src;
            this.un = r2.un;
            this.during_time = r2.during_time;
            this.voice_md5 = r2.voice_md5;
        }
    }

    public int getType() {
        return this.type;
    }

    public String getText() {
        return this.text;
    }

    public String getLink() {
        return this.link;
    }

    public String getSrc() {
        return this.src;
    }

    public String getUn() {
        return this.un;
    }

    public String getDuring_time() {
        return this.during_time;
    }

    public String getVoice_md5() {
        return this.voice_md5;
    }
}
