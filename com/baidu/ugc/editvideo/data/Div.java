package com.baidu.ugc.editvideo.data;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class Div implements Externalizable {
    public int start;
    public int stop;

    public Div() {
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("start", this.start);
            jSONObject.put("stop", this.stop);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public Div(int i, int i2) {
        this.start = i;
        this.stop = i2;
    }

    public void parse(JSONObject jSONObject) {
        this.start = jSONObject.optInt("start");
        this.stop = jSONObject.optInt("stop");
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.start = objectInput.readByte();
        this.stop = objectInput.readByte();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeByte(this.start);
        objectOutput.writeByte(this.stop);
    }
}
