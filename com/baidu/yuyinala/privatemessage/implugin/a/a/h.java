package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class h extends f {
    private Context mContext;
    public View mConvertView;
    public TextView oMl;

    @SuppressLint({"InflateParams"})
    public h(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_notice_txt, (ViewGroup) null);
        this.oMc = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMl = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_notice);
        this.mConvertView.setTag(this);
    }

    public static h b(Context context, LayoutInflater layoutInflater, View view) {
        return (view == null || !(view.getTag() instanceof h)) ? new h(context, layoutInflater) : (h) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public TextView getTextView() {
        return this.oMl;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public void b(Context context, ChatMsg chatMsg) {
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public View getContentView() {
        return this.oMl;
    }
}
