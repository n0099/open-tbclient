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
    public TextView oMc;
    public ImageView oMf;
    public ImageView oMh;
    public ImageView oMi;
    public View oMj;
    public ProgressBar oMk;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oMj.setVisibility(4);
            return;
        }
        this.oMj.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oMi.setVisibility(0);
            this.oMk.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oMi.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.eoa() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oMk.setVisibility(0);
                    return;
                } else {
                    this.oMk.setVisibility(8);
                    return;
                }
            }
            this.oMk.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
