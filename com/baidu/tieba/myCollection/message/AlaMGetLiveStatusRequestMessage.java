package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class AlaMGetLiveStatusRequestMessage extends HttpMessage {
    public List<Object> mOriginDatas;

    public AlaMGetLiveStatusRequestMessage() {
        super(CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED);
        this.mOriginDatas = new ArrayList();
    }

    public List<Object> getOrignData() {
        return this.mOriginDatas;
    }

    public void setAudienceCount(long j) {
        addParam("audience_count", j);
    }

    public void setListIds(List<Long> list) {
        JsonArray jsonArray = new JsonArray();
        jsonArray.add((Number) 0L);
        for (Long l : list) {
            if (l != null) {
                jsonArray.add(l);
            }
        }
        addParam("live_ids", jsonArray.toString());
    }

    public void setOriginData(List<Object> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.mOriginDatas.clear();
        this.mOriginDatas.addAll(list);
    }
}
