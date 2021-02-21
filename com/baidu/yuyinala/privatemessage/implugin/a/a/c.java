package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
/* loaded from: classes11.dex */
public abstract class c {
    public TextView oYt;
    public TextView oYu;
    public DarkImageView oYv;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
