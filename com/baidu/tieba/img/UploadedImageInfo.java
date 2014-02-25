package com.baidu.tieba.img;

import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class UploadedImageInfo implements Serializable {
    private String pic_id = null;
    private int width = 0;
    private int height = 0;

    public String toPostString() {
        if (this.pic_id == null) {
            return "";
        }
        return String.format("#(pic,%s,%d,%d)", this.pic_id, Integer.valueOf(this.width), Integer.valueOf(this.height));
    }

    public String toString() {
        return toPostString();
    }

    public String getPic_id() {
        return this.pic_id;
    }

    public void setPic_id(String str) {
        this.pic_id = str;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void parserJson(String str) {
        try {
            parserJson(new JSONObject(str));
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("InfoData", "parserJson", "error = " + e.getMessage());
        }
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.pic_id = jSONObject.optString("pic_id");
                this.width = jSONObject.optInt("width", 0);
                this.height = jSONObject.optInt("height", 0);
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b("InfoData", "parserJson", "error = " + e.getMessage());
            }
        }
    }

    public void logPrint() {
        com.baidu.adp.lib.util.f.d("InfoData", "logPrint", "pic_id = " + this.pic_id);
        com.baidu.adp.lib.util.f.d("InfoData", "logPrint", "width = " + String.valueOf(this.width));
        com.baidu.adp.lib.util.f.d("InfoData", "logPrint", "height = " + String.valueOf(this.height));
    }
}
