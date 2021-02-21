package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes11.dex */
public abstract class d {
    public TextView oYt;
    public ImageView oYw;
    public ImageView oYy;
    public TextView joX = null;
    public TextView myg = null;
    public TextView oYx = null;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
