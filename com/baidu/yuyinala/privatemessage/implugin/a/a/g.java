package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.RedNotifyMsg;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
/* loaded from: classes4.dex */
public class g extends f {
    private ImageView fZa;
    private Context mContext;
    public View mConvertView;
    public TextView oMl;
    private TextView oMm;
    private TextView oMn;

    @SuppressLint({"InflateParams"})
    public g(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_notice_red, (ViewGroup) null);
        this.oMc = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMl = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_notice);
        this.fZa = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_rednotify_img);
        this.oMm = (TextView) this.mConvertView.findViewById(a.f.bd_im_rednofity_tail);
        this.oMn = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_notice2);
        this.mConvertView.setTag(this);
    }

    public static g a(Context context, LayoutInflater layoutInflater, View view) {
        return (view == null || !(view.getTag() instanceof g)) ? new g(context, layoutInflater) : (g) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public TextView getTextView() {
        return this.oMl;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public View getContentView() {
        return this.oMl;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.f
    public void b(Context context, ChatMsg chatMsg) {
        RedNotifyMsg redNotifyMsg = (RedNotifyMsg) chatMsg;
        this.fZa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.oMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.g.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        ekZ();
    }

    private void ekZ() {
    }
}
