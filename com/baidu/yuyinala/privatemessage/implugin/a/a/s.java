package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.AudioMsg;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
/* loaded from: classes11.dex */
public class s extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public ImageView oZa;
    public TextView oZb;
    AnimationDrawable oZc;

    public s(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_audio_item, (ViewGroup) null);
        this.oZb = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_length);
        this.oZa = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_audio);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oXW = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.oXT = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oXZ = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oYa = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oYb = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.mContentView.setTag(this);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getConvertView() {
        return this.mConvertView;
    }

    public void startAnim() {
        this.oZa.setImageDrawable(null);
        this.oZa.setBackgroundResource(ThemeManager.U(this.mContext, a.C0195a.bd_im_anim_playing_right));
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
        this.oZa.setImageResource(ThemeManager.U(this.mContext, a.e.bd_im_speck_right_3));
        this.oZa.setBackgroundResource(0);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getContentView() {
        return this.mContentView;
    }

    public static s n(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof s)) ? new s(context, layoutInflater) : (s) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public void b(Context context, ChatMsg chatMsg) {
        AudioMsg audioMsg = (AudioMsg) chatMsg;
        String format = String.format(context.getString(a.h.bd_im_audio_length), Integer.valueOf(audioMsg.getDuration()));
        if (chatMsg.getStatus() == 0) {
            this.oZb.setVisibility(0);
            this.oZb.setText(format);
        } else {
            this.oZb.setVisibility(8);
        }
        this.mContentView.setMinimumWidth(a.c(context.getResources().getDimension(a.d.bd_im_audio_msg_min_width), audioMsg.getDuration()));
        ejE();
        super.b(context, chatMsg);
    }

    private void ejE() {
    }
}
