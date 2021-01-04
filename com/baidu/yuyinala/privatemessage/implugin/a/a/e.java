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
    public TextView oSk;
    public ImageView oSn;
    public ImageView oSp;
    public ImageView oSq;
    public View oSr;
    public ProgressBar oSs;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oSr.setVisibility(4);
            return;
        }
        this.oSr.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oSq.setVisibility(0);
            this.oSs.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oSq.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.eog() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oSs.setVisibility(0);
                    return;
                } else {
                    this.oSs.setVisibility(8);
                    return;
                }
            }
            this.oSs.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
