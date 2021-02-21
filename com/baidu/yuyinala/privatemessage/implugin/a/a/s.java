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
    public ImageView oZA;
    public TextView oZB;
    AnimationDrawable oZC;

    public s(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_audio_item, (ViewGroup) null);
        this.oZB = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_length);
        this.oZA = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_audio);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oYw = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.oYt = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oYz = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oYA = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oYB = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.mContentView.setTag(this);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getConvertView() {
        return this.mConvertView;
    }

    public void startAnim() {
        this.oZA.setImageDrawable(null);
        this.oZA.setBackgroundResource(ThemeManager.U(this.mContext, a.C0195a.bd_im_anim_playing_right));
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
        this.oZA.setImageResource(ThemeManager.U(this.mContext, a.e.bd_im_speck_right_3));
        this.oZA.setBackgroundResource(0);
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
            this.oZB.setVisibility(0);
            this.oZB.setText(format);
        } else {
            this.oZB.setVisibility(8);
        }
        this.mContentView.setMinimumWidth(a.c(context.getResources().getDimension(a.d.bd_im_audio_msg_min_width), audioMsg.getDuration()));
        ejM();
        super.b(context, chatMsg);
    }

    private void ejM() {
    }
}
