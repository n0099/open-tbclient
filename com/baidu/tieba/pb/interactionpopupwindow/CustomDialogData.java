package com.baidu.tieba.pb.interactionpopupwindow;

import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class CustomDialogData implements IBaseDialogData {
    public static final String POS_LEFT = "left";
    public static final int TYPE_ADD_THREAD = 2;
    public static final int TYPE_AGREE = 0;
    public static final int TYPE_REPLY = 1;
    public String body;
    public Head head;
    public Button leftButton;
    public Button rightButton;
    public int type = -1;

    /* loaded from: classes5.dex */
    public static class Button implements Serializable {
        public String action;
        public String image;
        public String text;
    }

    /* loaded from: classes5.dex */
    public static class Head implements Serializable {
        public String imageUrl;
        public String text;
    }

    public static CustomDialogData praseJSON(JSONObject jSONObject) {
        CustomDialogData customDialogData = new CustomDialogData();
        JSONObject optJSONObject = jSONObject.optJSONObject("head");
        if (optJSONObject != null) {
            Head head = new Head();
            head.imageUrl = optJSONObject.optString("image");
            head.text = optJSONObject.optString("text");
            customDialogData.head = head;
        }
        customDialogData.body = jSONObject.optString("body");
        JSONArray optJSONArray = jSONObject.optJSONArray("button");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                Button button = new Button();
                button.text = optJSONObject2.optString("text");
                button.action = optJSONObject2.optString("action");
                button.image = optJSONObject2.optString("image");
                if (optJSONObject2.optString("position").equals(POS_LEFT)) {
                    customDialogData.leftButton = button;
                } else {
                    customDialogData.rightButton = button;
                }
            }
        }
        return customDialogData;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getFrom() {
        return this.type;
    }

    @Override // com.baidu.tieba.pb.interactionpopupwindow.IBaseDialogData
    public int getType() {
        return 1;
    }
}
