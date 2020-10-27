package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
/* loaded from: classes4.dex */
public class v extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public DarkImageView onh;
    public TextView oni;
    public TextView onj;

    @SuppressLint({"InflateParams"})
    public v(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.h.bd_im_chating_send_shared_item, (ViewGroup) null);
        this.oma = (ImageView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_status);
        this.omb = this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_status_layout);
        this.omc = (ProgressBar) this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_progress);
        this.olX = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview);
        this.olZ = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview_vip);
        this.olU = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_time_txt);
        this.onh = (DarkImageView) this.mConvertView.findViewById(a.g.bd_im_chat_shared_cover);
        this.onj = (TextView) this.mConvertView.findViewById(a.g.bd_im_chat_shared_title);
        this.oni = (TextView) this.mConvertView.findViewById(a.g.bd_im_chat_shared_content);
        this.mContentView = this.mConvertView.findViewById(a.g.bd_im_chating_msg_content_layout);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getContentView() {
        return this.mContentView;
    }

    public static v q(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof v)) ? new v(context, layoutInflater) : (v) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
        String covers = signleGraphicTextMsg.getCovers();
        if (TextUtils.isEmpty(covers)) {
            covers = signleGraphicTextMsg.getCover();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.b.gK(this.mContext);
        ImageLoader.getInstance().displayImage(covers, this.onh, com.baidu.yuyinala.privatemessage.implugin.util.b.eeo());
        this.onj.setText(signleGraphicTextMsg.getTitle());
        this.oni.setText(signleGraphicTextMsg.getDigest());
        super.b(context, chatMsg);
    }
}
