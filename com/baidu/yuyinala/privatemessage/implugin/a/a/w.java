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
    public TextView oyk;

    @SuppressLint({"InflateParams"})
    public w(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_txt_item, (ViewGroup) null);
        this.oxa = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oxb = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oxc = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.oyk = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_txt);
        this.owX = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.owZ = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview_vip);
        this.owU = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
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

    public static w r(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof w)) ? new w(context, layoutInflater) : (w) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        if (chatMsg instanceof TextMsg) {
            this.oyk.setText(((TextMsg) chatMsg).getText());
            Spannable c = com.baidu.yuyinala.privatemessage.implugin.util.f.c(context, this.oyk.getText());
            if (c != null) {
                this.oyk.setText(c);
                this.oyk.setMovementMethod(com.baidu.yuyinala.privatemessage.implugin.ui.common.a.efX());
                this.oyk.setFocusable(false);
                this.oyk.setClickable(false);
                this.oyk.setLongClickable(false);
            }
        }
        super.b(context, chatMsg);
    }
}
