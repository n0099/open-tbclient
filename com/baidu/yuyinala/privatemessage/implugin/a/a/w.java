package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class w extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public TextView onl;

    @SuppressLint({"InflateParams"})
    public w(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.h.bd_im_chating_send_txt_item, (ViewGroup) null);
        this.oma = (ImageView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_status);
        this.omb = this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_status_layout);
        this.omc = (ProgressBar) this.mConvertView.findViewById(a.g.bd_im_chating_msg_send_progress);
        this.onl = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_msg_content_txt);
        this.olX = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview);
        this.olZ = (ImageView) this.mConvertView.findViewById(a.g.bd_im_headview_vip);
        this.olU = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_time_txt);
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

    public static w r(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof w)) ? new w(context, layoutInflater) : (w) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        if (chatMsg instanceof TextMsg) {
            this.onl.setText(((TextMsg) chatMsg).getText());
            Spannable c = com.baidu.yuyinala.privatemessage.implugin.util.f.c(context, this.onl.getText());
            if (c != null) {
                this.onl.setText(c);
                this.onl.setMovementMethod(com.baidu.yuyinala.privatemessage.implugin.ui.common.a.eck());
                this.onl.setFocusable(false);
                this.onl.setClickable(false);
                this.onl.setLongClickable(false);
            }
        }
        super.b(context, chatMsg);
    }
}
