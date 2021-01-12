package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes10.dex */
public abstract class e {
    private Context mContext;
    public TextView oNI;
    public ImageView oNL;
    public ImageView oNN;
    public ImageView oNO;
    public View oNP;
    public ProgressBar oNQ;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.oNP.setVisibility(4);
            return;
        }
        this.oNP.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.oNO.setVisibility(0);
            this.oNQ.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.oNO.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.ekl() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.oNQ.setVisibility(0);
                    return;
                } else {
                    this.oNQ.setVisibility(8);
                    return;
                }
            }
            this.oNQ.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
