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
    public View oYA;
    public ProgressBar oYB;
    public TextView oYt;
    public ImageView oYw;
    public ImageView oYy;
    public ImageView oYz;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oYA.setVisibility(4);
            return;
        }
        this.oYA.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oYz.setVisibility(0);
            this.oYB.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oYz.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.emL() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oYB.setVisibility(0);
                    return;
                } else {
                    this.oYB.setVisibility(8);
                    return;
                }
            }
            this.oYB.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
