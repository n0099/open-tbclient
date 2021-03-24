package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes4.dex */
public class PbPageReadLocalRequestMessage extends CustomMessage<Object> {
    public String cacheKey;
    public Context context;
    public boolean markCache;
    public String postId;
    public int updateType;

    public PbPageReadLocalRequestMessage() {
        super(2004003);
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public Context getContext() {
        return this.context;
    }

    public String getPostId() {
        return this.postId;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public boolean isMarkCache() {
        return this.markCache;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setMarkCache(boolean z) {
        this.markCache = z;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }
}
