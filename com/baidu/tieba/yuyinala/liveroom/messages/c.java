package com.baidu.tieba.yuyinala.liveroom.messages;

import com.baidu.live.adp.framework.message.HttpMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class c extends HttpMessage {
    private long mAudienceCount;
    private List<Long> mIds;
    private List<Object> mOriginDatas;

    public c() {
        super(1031044);
        this.mOriginDatas = new ArrayList();
        this.mAudienceCount = 0L;
    }

    public void setListIds(List<Long> list) {
        this.mIds = list;
    }

    public void setAudienceCount(long j) {
        this.mAudienceCount = j;
    }

    public void setParams() {
        addParam("audience_count", this.mAudienceCount);
        if (this.mIds != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.mIds.size(); i++) {
                sb.append(this.mIds.get(i));
                if (i != this.mIds.size() - 1) {
                    sb.append(",");
                }
            }
            addParam("live_ids", sb.toString());
        }
    }
}
