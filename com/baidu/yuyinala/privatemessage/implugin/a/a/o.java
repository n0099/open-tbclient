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
/* loaded from: classes4.dex */
public class o extends d {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    public DarkImageView onh;
    public TextView oni;

    public o(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.h.bd_im_chating_receive_private_msg_item, (ViewGroup) null);
        this.olU = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_time_txt);
        this.olX = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview);
        this.iJS = (TextView) this.mConvertView.findViewById(a.g.bd_im_user_name);
        this.lTM = (TextView) this.mConvertView.findViewById(a.g.bd_im_user_agetime);
        this.olY = (TextView) this.mConvertView.findViewById(a.g.bd_im_user_constellation);
        this.onh = (DarkImageView) this.mConvertView.findViewById(a.g.bd_im_chat_shared_cover);
        this.oni = (TextView) this.mConvertView.findViewById(a.g.bd_im_chat_shared_content);
        this.mContentView = this.mConvertView.findViewById(a.g.bd_im_chating_msg_content_layout);
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
            com.baidu.yuyinala.privatemessage.implugin.util.b.gK(context);
            ImageLoader.getInstance().displayImage(covers, this.onh, com.baidu.yuyinala.privatemessage.implugin.util.b.eeo());
            this.oni.setText(signleGraphicTextMsg.getDigest());
        }
    }
}
