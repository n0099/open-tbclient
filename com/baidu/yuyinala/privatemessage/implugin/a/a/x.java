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
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes4.dex */
public class x extends e {
    private final TextView alU;
    public ImageView jnb;
    public View mContentView;
    public View mConvertView;
    private final ImageView oym;

    @SuppressLint({"InflateParams"})
    public x(Context context, LayoutInflater layoutInflater) {
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_video_item, (ViewGroup) null);
        this.owU = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.owX = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.owZ = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview_vip);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.jnb = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_img);
        this.oym = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_play_icon);
        this.alU = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_video_duration);
        this.oxa = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oxb = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oxc = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
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

    public static x s(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof x)) ? new x(context, layoutInflater) : (x) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
        com.baidu.yuyinala.privatemessage.implugin.util.b.gI(context);
        a(signleGraphicTextMsg);
        SingleGraphicTextMsgExt singleGraphicTextMsgExt = new SingleGraphicTextMsgExt(signleGraphicTextMsg);
        double d = singleGraphicTextMsgExt.oHt;
        String str = singleGraphicTextMsgExt.oHs;
        this.alU.setText(singleGraphicTextMsgExt.videoDuration);
        super.b(context, chatMsg);
    }

    private void a(SignleGraphicTextMsg signleGraphicTextMsg) {
        String covers = signleGraphicTextMsg.getCovers();
        if (TextUtils.isEmpty(covers)) {
            covers = signleGraphicTextMsg.getCover();
        }
        ImageLoader.getInstance().displayImage(covers, this.jnb, com.baidu.yuyinala.privatemessage.implugin.util.b.eib());
    }
}
