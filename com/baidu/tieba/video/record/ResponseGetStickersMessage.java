package com.baidu.tieba.video.record;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ResponseGetStickersMessage extends JsonHttpResponsedMessage {
    public List<StickerItem> mStickerItems;

    public ResponseGetStickersMessage() {
        super(CmdConfigHttp.CMD_GET_STICKERS);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() != 0 || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || (optJSONArray = optJSONObject.optJSONArray("list")) == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            StickerItem stickerItem = (StickerItem) OrmObject.objectWithJsonStr(optJSONArray.getString(i2), StickerItem.class);
            if (this.mStickerItems == null) {
                this.mStickerItems = new ArrayList();
            }
            this.mStickerItems.add(stickerItem);
        }
    }

    public List<StickerItem> getStickerItems() {
        return this.mStickerItems;
    }
}
