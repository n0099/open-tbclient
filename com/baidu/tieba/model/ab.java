package com.baidu.tieba.model;

import android.content.Context;
import android.os.Bundle;
import com.baidu.tieba.message.RequestFriendFeedLocalMessage;
import com.baidu.tieba.message.RequestFriendFeedMessage;
/* loaded from: classes.dex */
public class ab extends com.baidu.adp.base.e {
    private Context a;
    private boolean b;
    private String c;

    public ab(Context context) {
        this.a = context;
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }

    public boolean b() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(Bundle bundle) {
    }

    public void a(int i, String str) {
        int b = com.baidu.adp.lib.util.j.b(this.a);
        int c = com.baidu.adp.lib.util.j.c(this.a);
        float f = b / 320.0f;
        int i2 = 1;
        if (com.baidu.tbadk.core.util.bb.a().b()) {
            i2 = 2;
        }
        RequestFriendFeedMessage requestFriendFeedMessage = new RequestFriendFeedMessage();
        requestFriendFeedMessage.setScrW(b);
        requestFriendFeedMessage.setScrH(c);
        requestFriendFeedMessage.setScrDip(f);
        requestFriendFeedMessage.setqType(i2);
        requestFriendFeedMessage.setLimit(i);
        requestFriendFeedMessage.setTimeline(str);
        super.sendMessage(requestFriendFeedMessage);
    }

    public void b(int i, String str) {
        int b = com.baidu.adp.lib.util.j.b(this.a);
        int c = com.baidu.adp.lib.util.j.c(this.a);
        float f = b / 320.0f;
        int i2 = 1;
        if (com.baidu.tbadk.core.util.bb.a().b()) {
            i2 = 2;
        }
        RequestFriendFeedLocalMessage requestFriendFeedLocalMessage = new RequestFriendFeedLocalMessage();
        requestFriendFeedLocalMessage.setScrW(b);
        requestFriendFeedLocalMessage.setScrH(c);
        requestFriendFeedLocalMessage.setScrDip(f);
        requestFriendFeedLocalMessage.setqType(i2);
        requestFriendFeedLocalMessage.setLimit(i);
        requestFriendFeedLocalMessage.setTimeline(str);
        sendMessage(requestFriendFeedLocalMessage);
    }

    public void b(Bundle bundle) {
    }
}
