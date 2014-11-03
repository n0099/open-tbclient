package com.baidu.tieba.mention;

import android.content.Context;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class am extends com.baidu.adp.base.e {
    private ao boh;
    private BaseFragmentActivity mActivity;

    static {
        com.baidu.tieba.ai.b(303010, CheckPostResponseMessage.class, false);
    }

    public am(Context context, ae aeVar) {
        super(context);
        this.mActivity = (BaseFragmentActivity) context;
        Tb();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        sendMessage(checkPostRequestMessage);
    }

    public void Tb() {
        registerListener(new an(this, 303010));
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(ao aoVar) {
        this.boh = aoVar;
    }
}
