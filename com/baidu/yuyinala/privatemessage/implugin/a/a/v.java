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
/* loaded from: classes10.dex */
public class v extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public DarkImageView oOU;
    public TextView oOV;
    public TextView oOW;

    @SuppressLint({"InflateParams"})
    public v(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_shared_item, (ViewGroup) null);
        this.oNO = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oNP = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oNQ = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.oNL = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.oNN = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview_vip);
        this.oNI = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oOU = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_cover);
        this.oOW = (TextView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_title);
        this.oOV = (TextView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_content);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
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
        com.baidu.yuyinala.privatemessage.implugin.util.b.hC(this.mContext);
        ImageLoader.getInstance().displayImage(covers, this.oOU, com.baidu.yuyinala.privatemessage.implugin.util.b.ejZ());
        this.oOW.setText(signleGraphicTextMsg.getTitle());
        this.oOV.setText(signleGraphicTextMsg.getDigest());
        super.b(context, chatMsg);
    }
}
