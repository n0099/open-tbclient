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
/* loaded from: classes10.dex */
public class p extends d {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    public DarkImageView oOU;
    public TextView oOV;
    public TextView oOW;

    public p(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_shared_item, (ViewGroup) null);
        this.oNI = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oNL = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.jjc = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.moR = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oNM = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        this.oOU = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_cover);
        this.oOW = (TextView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_title);
        this.oOV = (TextView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_content);
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

    public static p k(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof p)) ? new p(context, layoutInflater) : (p) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void b(Context context, ChatMsg chatMsg) {
        if (chatMsg instanceof SignleGraphicTextMsg) {
            SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
            String covers = signleGraphicTextMsg.getCovers();
            if (TextUtils.isEmpty(covers)) {
                covers = signleGraphicTextMsg.getCover();
            }
            com.baidu.yuyinala.privatemessage.implugin.util.b.hC(context);
            ImageLoader.getInstance().displayImage(covers, this.oOU, com.baidu.yuyinala.privatemessage.implugin.util.b.ejZ());
            this.oOW.setText(signleGraphicTextMsg.getTitle());
            this.oOV.setText(signleGraphicTextMsg.getDigest());
            this.mContentView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.p.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.yuyinala.privatemessage.implugin.util.c.d("", "click share content");
                }
            });
        }
    }
}
