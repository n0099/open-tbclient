package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes4.dex */
public abstract class d {
    public TextView oMc;
    public ImageView oMf;
    public ImageView oMh;
    public TextView jbv = null;
    public TextView mok = null;
    public TextView oMg = null;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
