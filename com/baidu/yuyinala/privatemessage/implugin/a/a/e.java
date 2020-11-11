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
    public TextView ovq;
    public ImageView ovt;
    public ImageView ovv;
    public ImageView ovw;
    public View ovx;
    public ProgressBar ovy;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.ovx.setVisibility(4);
            return;
        }
        this.ovx.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.ovw.setVisibility(0);
            this.ovy.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.ovw.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.eim() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.ovy.setVisibility(0);
                    return;
                } else {
                    this.ovy.setVisibility(8);
                    return;
                }
            }
            this.ovy.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
