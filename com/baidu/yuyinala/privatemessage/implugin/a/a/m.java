package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes11.dex */
public class m extends d {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public ImageView oZa;
    public TextView oZb;
    AnimationDrawable oZc;
    public ImageView oZd;

    @SuppressLint({"InflateParams"})
    public m(Context context, LayoutInflater layoutInflater, boolean z) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_audio_item, (ViewGroup) null);
        this.oZb = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_length);
        this.oZa = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_audio);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oZd = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_status);
        this.mxR = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oXX = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        if (true == z) {
            this.oZd.setVisibility(4);
        } else {
            this.oZd.setVisibility(0);
        }
        this.oXT = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oXW = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.joJ = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.mContentView.setTag(this);
        this.mConvertView.setTag(this);
    }

    public void startAnim() {
        this.oZd.setVisibility(4);
        this.oZa.setImageDrawable(null);
        this.oZa.setBackgroundResource(ThemeManager.U(this.mContext, a.C0195a.bd_im_anim_playing_left));
        this.oZc = (AnimationDrawable) this.oZa.getBackground();
        this.oZc.setOneShot(false);
        if (!this.oZc.isRunning()) {
            this.oZc.start();
        }
    }

    public void stopAnim() {
        if (this.oZc != null && this.oZc.isRunning()) {
            this.oZc.stop();
        }
        this.oZa.setImageResource(ThemeManager.U(this.mContext, a.e.bd_im_speck_left_3));
        this.oZa.setBackgroundResource(0);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public View getContentView() {
        return this.mContentView;
    }

    public static m h(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof m)) ? new m(context, layoutInflater, chatMsg.isClicked()) : (m) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void b(Context context, ChatMsg chatMsg) {
        AudioMsg audioMsg = (AudioMsg) chatMsg;
        this.oZb.setText(String.format(context.getString(a.h.bd_im_audio_length), Integer.valueOf(audioMsg.getDuration())));
        this.mContentView.setMinimumWidth(a.c(context.getResources().getDimension(a.d.bd_im_audio_msg_min_width), audioMsg.getDuration()));
        if (chatMsg.isClicked()) {
            this.oZd.setVisibility(4);
        } else {
            this.oZd.setVisibility(0);
        }
        ejE();
    }

    private void ejE() {
    }
}
