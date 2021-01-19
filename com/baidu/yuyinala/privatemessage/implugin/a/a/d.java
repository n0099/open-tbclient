package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
/* loaded from: classes10.dex */
public abstract class d {
    public TextView oNJ;
    public ImageView oNM;
    public ImageView oNO;
    public TextView jjc = null;
    public TextView moR = null;
    public TextView oNN = null;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void b(Context context, ChatMsg chatMsg) {
    }
}
