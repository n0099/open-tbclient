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
    public TextView oMa;
    public ImageView oMd;
    public ImageView oMf;
    public ImageView oMg;
    public View oMh;
    public ProgressBar oMi;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oMh.setVisibility(4);
            return;
        }
        this.oMh.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oMg.setVisibility(0);
            this.oMi.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oMg.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.enZ() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oMi.setVisibility(0);
                    return;
                } else {
                    this.oMi.setVisibility(8);
                    return;
                }
            }
            this.oMi.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
