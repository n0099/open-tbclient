package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes11.dex */
public abstract class e {
    private Context mContext;
    public TextView oXT;
    public ImageView oXW;
    public ImageView oXY;
    public ImageView oXZ;
    public View oYa;
    public ProgressBar oYb;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oYa.setVisibility(4);
            return;
        }
        this.oYa.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oXZ.setVisibility(0);
            this.oYb.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oXZ.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.emD() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oYb.setVisibility(0);
                    return;
                } else {
                    this.oYb.setVisibility(8);
                    return;
                }
            }
            this.oYb.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
