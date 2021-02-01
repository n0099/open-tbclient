package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes11.dex */
public abstract class d {
    public TextView oXT;
    public ImageView oXW;
    public ImageView oXY;
    public TextView joJ = null;
    public TextView mxR = null;
    public TextView oXX = null;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
