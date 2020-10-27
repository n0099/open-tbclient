package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes4.dex */
public abstract class e {
    private Context mContext;
    public TextView olU;
    public ImageView olX;
    public ImageView olZ;
    public ImageView oma;
    public View omb;
    public ProgressBar omc;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.omb.setVisibility(4);
            return;
        }
        this.omb.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oma.setVisibility(0);
            this.omc.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oma.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.eex() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.omc.setVisibility(0);
                    return;
                } else {
                    this.omc.setVisibility(8);
                    return;
                }
            }
            this.omc.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
