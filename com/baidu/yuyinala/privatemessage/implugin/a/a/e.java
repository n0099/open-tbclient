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
    public TextView owU;
    public ImageView owX;
    public ImageView owZ;
    public ImageView oxa;
    public View oxb;
    public ProgressBar oxc;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oxb.setVisibility(4);
            return;
        }
        this.oxb.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oxa.setVisibility(0);
            this.oxc.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oxa.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.eik() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oxc.setVisibility(0);
                    return;
                } else {
                    this.oxc.setVisibility(8);
                    return;
                }
            }
            this.oxc.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
