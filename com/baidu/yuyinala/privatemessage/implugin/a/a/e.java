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
    public TextView paA;
    public ImageView paD;
    public ImageView paF;
    public ImageView paG;
    public View paH;
    public ProgressBar paI;

    public abstract View getContentView();

    public abstract View getConvertView();

    public void d(ChatMsg chatMsg) {
        if (chatMsg.isMsgSendSuccess()) {
            this.paH.setVisibility(4);
            return;
        }
        this.paH.setVisibility(0);
        if (chatMsg.getStatus() == 2) {
            this.paG.setVisibility(0);
            this.paI.setVisibility(8);
        } else if (chatMsg.getStatus() == 1) {
            this.paG.setVisibility(8);
            SingleGraphicTextMsgExt singleGraphicTextMsgExt = null;
            if (chatMsg instanceof SignleGraphicTextMsg) {
                singleGraphicTextMsgExt = new SingleGraphicTextMsgExt((SignleGraphicTextMsg) chatMsg);
            }
            if (chatMsg.getMsgType() == 1 || (singleGraphicTextMsgExt != null && singleGraphicTextMsgExt.emV() == SingleGraphicTextMsgExt.SingleGraphicTextType.VIDEOSHARE)) {
                if (chatMsg.isReSend()) {
                    this.paI.setVisibility(0);
                    return;
                } else {
                    this.paI.setVisibility(8);
                    return;
                }
            }
            this.paI.setVisibility(0);
        }
    }

    public void b(Context context, ChatMsg chatMsg) {
        this.mContext = context;
        d(chatMsg);
    }
}
