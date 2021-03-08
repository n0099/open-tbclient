package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes10.dex */
public abstract class d {
    public TextView paA;
    public ImageView paD;
    public ImageView paF;
    public TextView jqG = null;
    public TextView mAi = null;
    public TextView paE = null;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
