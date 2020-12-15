package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
/* loaded from: classes4.dex */
public abstract class c {
    public TextView oMc;
    public TextView oMd;
    public DarkImageView oMe;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
