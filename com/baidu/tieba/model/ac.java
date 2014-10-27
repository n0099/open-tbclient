package com.baidu.tieba.model;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tieba.message.RequestFriendFeedLocalMessage;
import com.baidu.tieba.message.RequestFriendFeedMessage;
/* loaded from: classes.dex */
public class ac extends com.baidu.adp.base.e {
    private boolean boS;
    private Context mContext;
    private String timeline;

    public ac(Context context) {
        super(context);
        this.mContext = context;
    }

    public String getTimeline() {
        return this.timeline;
    }

    public void setTimeline(String str) {
        this.timeline = str;
    }

    public boolean isUseCache() {
        return this.boS;
    }

    public void setUseCache(boolean z) {
        this.boS = z;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void p(int i, String str) {
        int n = com.baidu.adp.lib.util.m.n(this.mContext);
        int o = com.baidu.adp.lib.util.m.o(this.mContext);
        float f = n / 320.0f;
        int i2 = 1;
        if (com.baidu.tbadk.core.util.az.mD().mF()) {
            i2 = 2;
        }
        RequestFriendFeedMessage requestFriendFeedMessage = new RequestFriendFeedMessage();
        requestFriendFeedMessage.setScrW(n);
        requestFriendFeedMessage.setScrH(o);
        requestFriendFeedMessage.setScrDip(f);
        requestFriendFeedMessage.setqType(i2);
        requestFriendFeedMessage.setLimit(i);
        requestFriendFeedMessage.setTimeline(str);
        super.sendMessage(requestFriendFeedMessage);
    }

    public void q(int i, String str) {
        int n = com.baidu.adp.lib.util.m.n(this.mContext);
        int o = com.baidu.adp.lib.util.m.o(this.mContext);
        float f = n / 320.0f;
        int i2 = 1;
        if (com.baidu.tbadk.core.util.az.mD().mF()) {
            i2 = 2;
        }
        RequestFriendFeedLocalMessage requestFriendFeedLocalMessage = new RequestFriendFeedLocalMessage();
        requestFriendFeedLocalMessage.setScrW(n);
        requestFriendFeedLocalMessage.setScrH(o);
        requestFriendFeedLocalMessage.setScrDip(f);
        requestFriendFeedLocalMessage.setqType(i2);
        requestFriendFeedLocalMessage.setLimit(i);
        requestFriendFeedLocalMessage.setTimeline(str);
        sendMessage(requestFriendFeedLocalMessage);
    }

    public void saveInstance(Bundle bundle) {
    }
}
