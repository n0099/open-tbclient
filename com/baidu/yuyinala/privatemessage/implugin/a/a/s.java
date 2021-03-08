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
/* loaded from: classes10.dex */
public class s extends e {
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public ImageView pbH;
    public TextView pbI;
    AnimationDrawable pbJ;

    public s(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_send_audio_item, (ViewGroup) null);
        this.pbI = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_audio_length);
        this.pbH = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_audio);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.paD = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.paA = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.paG = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status);
        this.paH = this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_status_layout);
        this.paI = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_msg_send_progress);
        this.mContentView.setTag(this);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.e
    public View getConvertView() {
        return this.mConvertView;
    }

    public void startAnim() {
        this.pbH.setImageDrawable(null);
        this.pbH.setBackgroundResource(ThemeManager.U(this.mContext, a.C0201a.bd_im_anim_playing_right));
        this.pbJ = (AnimationDrawable) this.pbH.getBackground();
        this.pbJ.setOneShot(false);
        if (!this.pbJ.isRunning()) {
            this.pbJ.start();
        }
    }

    public void stopAnim() {
        if (this.pbJ != null && this.pbJ.isRunning()) {
            this.pbJ.stop();
        }
        this.pbH.setImageResource(ThemeManager.U(this.mContext, a.e.bd_im_speck_right_3));
        this.pbH.setBackgroundResource(0);
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
            this.pbI.setVisibility(0);
            this.pbI.setText(format);
        } else {
            this.pbI.setVisibility(8);
        }
        this.mContentView.setMinimumWidth(a.c(context.getResources().getDimension(a.d.bd_im_audio_msg_min_width), audioMsg.getDuration()));
        ejW();
        super.b(context, chatMsg);
    }

    private void ejW() {
    }
}
