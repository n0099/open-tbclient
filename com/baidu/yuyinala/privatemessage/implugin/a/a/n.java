package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ImageMsg;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes4.dex */
public class n extends d {
    public ImageView jAD;
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public ProgressBar mProgressBar;
    public ImageView oNl;

    public n(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_img_item, (ViewGroup) null);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_progress);
        this.jAD = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_img);
        this.oNl = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_cover);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oMa = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMd = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.jbt = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.moi = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oMe = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public View getContentView() {
        return this.mContentView;
    }

    public void ekZ() {
        this.mProgressBar.setVisibility(0);
    }

    public void ela() {
        this.mProgressBar.setVisibility(4);
    }

    public void elb() {
        this.oNl.setVisibility(8);
    }

    public void elc() {
        this.oNl.setVisibility(8);
    }

    public static n i(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof n)) ? new n(context, layoutInflater) : (n) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void b(Context context, ChatMsg chatMsg) {
        ImageMsg imageMsg = (ImageMsg) chatMsg;
        if (imageMsg.getProgress() > 0 && imageMsg.getProgress() < 100) {
            this.mProgressBar.setVisibility(0);
        } else {
            this.mProgressBar.setVisibility(8);
        }
        this.oNl.setVisibility(8);
        this.jAD.setImageResource(a.e.bd_im_loading_default);
        try {
            if (this.mContentView != null) {
                if (ThemeManager.enN() == ThemeManager.ThemeMode.NIGHT) {
                    this.mContentView.setBackground(null);
                } else {
                    this.mContentView.setBackground(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
