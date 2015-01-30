package com.baidu.tieba.model;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tieba.message.RequestFriendFeedLocalMessage;
import com.baidu.tieba.message.RequestFriendFeedMessage;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.f {
    private boolean buD;
    private Context mContext;
    private String timeline;

    public l(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.mContext = baseActivity.getPageContext().getContext();
    }

    public String getTimeline() {
        return this.timeline;
    }

    public void setTimeline(String str) {
        this.timeline = str;
    }

    public boolean UK() {
        return this.buD;
    }

    public void setUseCache(boolean z) {
        this.buD = z;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithBundle(Bundle bundle) {
    }

    public void z(int i, String str) {
        int M = com.baidu.adp.lib.util.l.M(this.mContext);
        int N = com.baidu.adp.lib.util.l.N(this.mContext);
        float f = M / 320.0f;
        int i2 = 1;
        if (bg.pI().pK()) {
            i2 = 2;
        }
        RequestFriendFeedMessage requestFriendFeedMessage = new RequestFriendFeedMessage();
        requestFriendFeedMessage.setScrW(M);
        requestFriendFeedMessage.setScrH(N);
        requestFriendFeedMessage.setScrDip(f);
        requestFriendFeedMessage.setqType(i2);
        requestFriendFeedMessage.setLimit(i);
        requestFriendFeedMessage.setTimeline(str);
        super.sendMessage(requestFriendFeedMessage);
    }

    public void A(int i, String str) {
        int M = com.baidu.adp.lib.util.l.M(this.mContext);
        int N = com.baidu.adp.lib.util.l.N(this.mContext);
        float f = M / 320.0f;
        int i2 = 1;
        if (bg.pI().pK()) {
            i2 = 2;
        }
        RequestFriendFeedLocalMessage requestFriendFeedLocalMessage = new RequestFriendFeedLocalMessage();
        requestFriendFeedLocalMessage.setScrW(M);
        requestFriendFeedLocalMessage.setScrH(N);
        requestFriendFeedLocalMessage.setScrDip(f);
        requestFriendFeedLocalMessage.setqType(i2);
        requestFriendFeedLocalMessage.setLimit(i);
        requestFriendFeedLocalMessage.setTimeline(str);
        sendMessage(requestFriendFeedLocalMessage);
    }

    public void saveInstance(Bundle bundle) {
    }
}
