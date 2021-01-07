package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes11.dex */
public abstract class d {
    public TextView oSk;
    public ImageView oSn;
    public ImageView oSp;
    public TextView jnJ = null;
    public TextView mtw = null;
    public TextView oSo = null;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
