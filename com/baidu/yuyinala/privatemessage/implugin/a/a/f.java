package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes11.dex */
public abstract class f {
    public TextView oXT;

    public abstract void b(Context context, ChatMsg chatMsg);

    public abstract View getContentView();

    public abstract View getConvertView();

    public abstract TextView getTextView();
}
