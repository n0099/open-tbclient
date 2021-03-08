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
public class u extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public DarkImageView pbM;
    public TextView pbN;

    @SuppressLint({"InflateParams"})
    public u(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_private_msg_item, (ViewGroup) null);
        this.paG = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.paH = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.paI = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.paD = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.paF = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview_vip);
        this.paA = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.pbM = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_cover);
        this.pbN = (TextView) this.mConvertView.findViewById(a.f.bd_im_chat_shared_content);
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

    public static u p(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof u)) ? new u(context, layoutInflater) : (u) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
        String covers = signleGraphicTextMsg.getCovers();
        if (TextUtils.isEmpty(covers)) {
            covers = signleGraphicTextMsg.getCover();
        }
        com.baidu.yuyinala.privatemessage.implugin.util.b.hE(this.mContext);
        ImageLoader.getInstance().displayImage(covers, this.pbM, com.baidu.yuyinala.privatemessage.implugin.util.b.emJ());
        this.pbN.setText(signleGraphicTextMsg.getDigest());
        super.b(context, chatMsg);
    }
}
