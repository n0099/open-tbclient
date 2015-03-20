package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public class PbPageReadLocalRequestMessage extends CustomMessage<Object> {
    private String cacheKey;
    private Context context;
    private boolean markCache;
    private String postId;
    private int updateType;

    public PbPageReadLocalRequestMessage() {
        super(2004003);
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getPostId() {
        return this.postId;
    }

    public void setPostId(String str) {
        this.postId = str;
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public void setUpdateType(int i) {
        this.updateType = i;
    }

    public boolean isMarkCache() {
        return this.markCache;
    }

    public void setMarkCache(boolean z) {
        this.markCache = z;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public void setCacheKey(String str) {
        this.cacheKey = str;
    }
}
