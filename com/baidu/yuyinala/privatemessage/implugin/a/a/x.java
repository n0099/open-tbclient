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
/* loaded from: classes10.dex */
public class x extends e {
    private final TextView anQ;
    public ImageView jRs;
    public View mContentView;
    public View mConvertView;
    private final ImageView pbS;

    @SuppressLint({"InflateParams"})
    public x(Context context, LayoutInflater layoutInflater) {
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_video_item, (ViewGroup) null);
        this.paA = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.paD = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.paF = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview_vip);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.jRs = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_img);
        this.pbS = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_play_icon);
        this.anQ = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_video_duration);
        this.paG = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.paH = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.paI = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
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
        com.baidu.yuyinala.privatemessage.implugin.util.b.hE(context);
        a(signleGraphicTextMsg);
        SingleGraphicTextMsgExt singleGraphicTextMsgExt = new SingleGraphicTextMsgExt(signleGraphicTextMsg);
        double d = singleGraphicTextMsgExt.pkO;
        String str = singleGraphicTextMsgExt.pkN;
        this.anQ.setText(singleGraphicTextMsgExt.pkP);
        super.b(context, chatMsg);
    }

    private void a(SignleGraphicTextMsg signleGraphicTextMsg) {
        String covers = signleGraphicTextMsg.getCovers();
        if (TextUtils.isEmpty(covers)) {
            covers = signleGraphicTextMsg.getCover();
        }
        ImageLoader.getInstance().displayImage(covers, this.jRs, com.baidu.yuyinala.privatemessage.implugin.util.b.emJ());
    }
}
