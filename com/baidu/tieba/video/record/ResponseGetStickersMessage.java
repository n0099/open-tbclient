package com.baidu.tieba.video.record;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ResponseGetStickersMessage extends JsonHttpResponsedMessage {
    private List<StickerItem> mStickerItems;

    public ResponseGetStickersMessage() {
        super(1003368);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONArray = optJSONObject.optJSONArray("list")) != null && optJSONArray.length() > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < optJSONArray.length()) {
                    StickerItem stickerItem = (StickerItem) OrmObject.objectWithJsonStr(optJSONArray.getString(i3), StickerItem.class);
                    if (this.mStickerItems == null) {
                        this.mStickerItems = new ArrayList();
                    }
                    this.mStickerItems.add(stickerItem);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public List<StickerItem> getStickerItems() {
        return this.mStickerItems;
    }
}
