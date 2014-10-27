package com.baidu.tieba.personInfo;

import java.io.Serializable;
import org.json.JSONObject;
import tbclient.Media;
/* loaded from: classes.dex */
public class PersonInfoMedia implements Serializable {
    private static final long serialVersionUID = 7788318107413815182L;
    private String bigPic;
    private String smallPic;
    private String srcPic;
    private String text;
    private int type;
    private String vhsrc;
    private String vpic;
    private String vsrc;
    private String waterPic;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.type = jSONObject.optInt("type");
            this.smallPic = jSONObject.optString("small_pic");
            this.bigPic = jSONObject.optString("big_pic");
            this.waterPic = jSONObject.optString("water_pic");
            this.vpic = jSONObject.optString("vpic");
            this.vsrc = jSONObject.optString("vsrc");
            this.vhsrc = jSONObject.optString("vhsrc");
            this.srcPic = jSONObject.optString("src_pic");
            this.text = jSONObject.optString("text");
        }
    }

    public void parseProto(Media media) {
        if (media != null) {
            this.type = media.type.intValue();
            this.smallPic = media.small_pic;
            this.bigPic = media.big_pic;
            this.waterPic = media.water_pic;
            this.vpic = media.vpic;
            this.vsrc = media.vsrc;
            this.vhsrc = media.vhsrc;
            this.srcPic = media.src_pic;
            this.text = media.text;
        }
    }

    public int getType() {
        return this.type;
    }

    public String getSmallPic() {
        return this.smallPic;
    }

    public String getBigPic() {
        return this.bigPic;
    }

    public String getWaterPic() {
        return this.waterPic;
    }

    public String getVpic() {
        return this.vpic;
    }

    public String getVsrc() {
        return this.vsrc;
    }

    public String getVhsrc() {
        return this.vhsrc;
    }

    public String getSrcPic() {
        return this.srcPic;
    }

    public String getText() {
        return this.text;
    }
}
