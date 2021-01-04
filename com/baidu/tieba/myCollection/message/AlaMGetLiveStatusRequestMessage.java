package com.baidu.tieba.myCollection.message;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.x;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class AlaMGetLiveStatusRequestMessage extends HttpMessage {
    private List<Object> mOriginDatas;

    public AlaMGetLiveStatusRequestMessage() {
        super(CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED);
        this.mOriginDatas = new ArrayList();
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

    public void setAudienceCount(long j) {
        addParam("audience_count", j);
    }

    public void setOriginData(List<Object> list) {
        if (!x.isEmpty(list)) {
            this.mOriginDatas.clear();
            this.mOriginDatas.addAll(list);
        }
    }

    public List<Object> getOrignData() {
        return this.mOriginDatas;
    }
}
