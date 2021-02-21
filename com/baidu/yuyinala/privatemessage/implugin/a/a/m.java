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
    public ImageView oZA;
    public TextView oZB;
    AnimationDrawable oZC;
    public ImageView oZD;

    @SuppressLint({"InflateParams"})
    public m(Context context, LayoutInflater layoutInflater, boolean z) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_audio_item, (ViewGroup) null);
        this.oZB = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_length);
        this.oZA = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_audio);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oZD = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_status);
        this.myg = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oYx = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        if (true == z) {
            this.oZD.setVisibility(4);
        } else {
            this.oZD.setVisibility(0);
        }
        this.oYt = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oYw = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.joX = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.mContentView.setTag(this);
        this.mConvertView.setTag(this);
    }

    public void startAnim() {
        this.oZD.setVisibility(4);
        this.oZA.setImageDrawable(null);
        this.oZA.setBackgroundResource(ThemeManager.U(this.mContext, a.C0195a.bd_im_anim_playing_left));
        this.oZC = (AnimationDrawable) this.oZA.getBackground();
        this.oZC.setOneShot(false);
        if (!this.oZC.isRunning()) {
            this.oZC.start();
        }
    }

    public void stopAnim() {
        if (this.oZC != null && this.oZC.isRunning()) {
            this.oZC.stop();
        }
        this.oZA.setImageResource(ThemeManager.U(this.mContext, a.e.bd_im_speck_left_3));
        this.oZA.setBackgroundResource(0);
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
        this.oZB.setText(String.format(context.getString(a.h.bd_im_audio_length), Integer.valueOf(audioMsg.getDuration())));
        this.mContentView.setMinimumWidth(a.c(context.getResources().getDimension(a.d.bd_im_audio_msg_min_width), audioMsg.getDuration()));
        if (chatMsg.isClicked()) {
            this.oZD.setVisibility(4);
        } else {
            this.oZD.setVisibility(0);
        }
        ejM();
    }

    private void ejM() {
    }
}
