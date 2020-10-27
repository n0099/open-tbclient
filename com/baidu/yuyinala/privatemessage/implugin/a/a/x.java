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
    private final TextView alO;
    public ImageView jgs;
    public View mContentView;
    public View mConvertView;
    private final ImageView onn;

    @SuppressLint({"InflateParams"})
    public x(Context context, LayoutInflater layoutInflater) {
        this.mConvertView = layoutInflater.inflate(a.h.bd_im_chating_send_video_item, (ViewGroup) null);
        this.olU = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_time_txt);
        this.olX = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview);
        this.olZ = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview_vip);
        this.mContentView = this.mConvertView.findViewById(a.g.bd_im_chating_msg_content_layout);
        this.jgs = (ImageView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_content_img);
        this.onn = (ImageView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_play_icon);
        this.alO = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_video_duration);
        this.oma = (ImageView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_status);
        this.omb = this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_status_layout);
        this.omc = (ProgressBar) this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_progress);
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
        com.baidu.yuyinala.privatemessage.implugin.util.b.gK(context);
        a(signleGraphicTextMsg);
        SingleGraphicTextMsgExt singleGraphicTextMsgExt = new SingleGraphicTextMsgExt(signleGraphicTextMsg);
        double d = singleGraphicTextMsgExt.owx;
        String str = singleGraphicTextMsgExt.oww;
        this.alO.setText(singleGraphicTextMsgExt.videoDuration);
        super.b(context, chatMsg);
    }

    private void a(SignleGraphicTextMsg signleGraphicTextMsg) {
        String covers = signleGraphicTextMsg.getCovers();
        if (TextUtils.isEmpty(covers)) {
            covers = signleGraphicTextMsg.getCover();
        }
        ImageLoader.getInstance().displayImage(covers, this.jgs, com.baidu.yuyinala.privatemessage.implugin.util.b.eeo());
    }
}
