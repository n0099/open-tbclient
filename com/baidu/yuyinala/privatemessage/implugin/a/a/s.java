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
/* loaded from: classes4.dex */
public class s extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public ImageView oNj;
    public TextView oNk;
    AnimationDrawable oNl;

    public s(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_audio_item, (ViewGroup) null);
        this.oNk = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_length);
        this.oNj = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_audio);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oMf = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.oMc = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMi = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.oMj = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.oMk = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.mContentView.setTag(this);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getConvertView() {
        return this.mConvertView;
    }

    public void startAnim() {
        this.oNj.setImageDrawable(null);
        this.oNj.setBackgroundResource(ThemeManager.U(this.mContext, a.C0205a.bd_im_anim_playing_right));
        this.oNl = (AnimationDrawable) this.oNj.getBackground();
        this.oNl.setOneShot(false);
        if (!this.oNl.isRunning()) {
            this.oNl.start();
        }
    }

    public void stopAnim() {
        if (this.oNl != null && this.oNl.isRunning()) {
            this.oNl.stop();
        }
        this.oNj.setImageResource(ThemeManager.U(this.mContext, a.e.bd_im_speck_right_3));
        this.oNj.setBackgroundResource(0);
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
            this.oNk.setVisibility(0);
            this.oNk.setText(format);
        } else {
            this.oNk.setVisibility(8);
        }
        this.mContentView.setMinimumWidth(a.c(context.getResources().getDimension(a.d.bd_im_audio_msg_min_width), audioMsg.getDuration()));
        ekZ();
        super.b(context, chatMsg);
    }

    private void ekZ() {
    }
}
