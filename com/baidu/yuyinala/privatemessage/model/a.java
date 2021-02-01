package com.baidu.yuyinala.privatemessage.model;

import android.content.Context;
import com.baidu.android.imsdk.chatmessage.IMediaDeleteChatSessionListener;
import com.baidu.yuyinala.privatemessage.session.b.j;
import java.util.List;
/* loaded from: classes11.dex */
public abstract class a {
    public abstract void a(Context context, j jVar, IMediaDeleteChatSessionListener iMediaDeleteChatSessionListener);

    public abstract void a(Context context, com.baidu.yuyinala.privatemessage.session.b bVar, int i);

    public abstract List<com.baidu.yuyinala.privatemessage.session.b.a> getDataList();

    public void destroy() {
    }
}
