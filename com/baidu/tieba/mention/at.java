package com.baidu.tieba.mention;

import android.content.Context;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* loaded from: classes.dex */
public class at extends com.baidu.adp.base.e {
    private BaseFragmentActivity a;
    private av b;

    public at(Context context, al alVar) {
        super(context);
        this.a = (BaseFragmentActivity) context;
        a();
    }

    public void a(long j, int i, String str) {
        CheckPostRequestMessage checkPostRequestMessage = new CheckPostRequestMessage();
        checkPostRequestMessage.setPid(j);
        checkPostRequestMessage.setPostType(i);
        checkPostRequestMessage.setForumName(str);
        sendMessage(checkPostRequestMessage);
    }

    public void a() {
        registerListener(new au(this, 303010));
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(av avVar) {
        this.b = avVar;
    }
}
