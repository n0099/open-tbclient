package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes11.dex */
public class o extends d {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    public DarkImageView oTw;
    public TextView oTx;

    public o(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_private_msg_item, (ViewGroup) null);
        this.oSk = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oSn = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.jnJ = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.mtx = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oSo = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        this.oTw = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_cover);
        this.oTx = (TextView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_content);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public View getContentView() {
        return this.mContentView;
    }

    public static o j(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof o)) ? new o(context, layoutInflater) : (o) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void b(Context context, ChatMsg chatMsg) {
        if (chatMsg instanceof SignleGraphicTextMsg) {
            SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
            String covers = signleGraphicTextMsg.getCovers();
            if (TextUtils.isEmpty(covers)) {
                covers = signleGraphicTextMsg.getCover();
            }
            new SingleGraphicTextMsgExt(signleGraphicTextMsg);
            com.baidu.yuyinala.privatemessage.implugin.util.b.hE(context);
            ImageLoader.getInstance().displayImage(covers, this.oTw, com.baidu.yuyinala.privatemessage.implugin.util.b.enT());
            this.oTx.setText(signleGraphicTextMsg.getDigest());
        }
    }
}
