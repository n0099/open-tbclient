package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.sumeru.universalimageloader.core.assist.FailReason;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener;
import com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener;
import com.baidu.yuyinala.privatemessage.implugin.ui.theme.ThemeManager;
import com.baidu.yuyinala.privatemessage.model.message.SingleGraphicTextMsgExt;
/* loaded from: classes11.dex */
public class r extends d {
    private final TextView anz;
    public ImageView jNe;
    public View mContentView;
    private Context mContext;
    public View mConvertView;
    public ProgressBar mProgressBar;
    private final ImageView oTC;

    public r(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_video_item, (ViewGroup) null);
        this.mProgressBar = (ProgressBar) this.mConvertView.findViewById(a.f.bd_im_chating_progress);
        this.jNe = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_img);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
        this.oSk = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oSn = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.jnJ = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.mtw = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oSo = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        this.oTC = (ImageView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_play_icon);
        this.anz = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_video_duration);
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

    public void elf() {
        this.mProgressBar.setVisibility(0);
    }

    public void elg() {
        this.mProgressBar.setVisibility(4);
    }

    public static r m(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof r)) ? new r(context, layoutInflater) : (r) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void b(Context context, ChatMsg chatMsg) {
        this.jNe.setImageResource(a.e.bd_im_loading_default);
        e(chatMsg);
        try {
            if (this.mContentView != null) {
                if (ThemeManager.enR() == ThemeManager.ThemeMode.NIGHT) {
                    this.mContentView.setBackground(null);
                } else {
                    this.mContentView.setBackground(null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void e(ChatMsg chatMsg) {
        SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
        String covers = signleGraphicTextMsg.getCovers();
        if (TextUtils.isEmpty(covers)) {
            covers = signleGraphicTextMsg.getCover();
        }
        this.anz.setText(new SingleGraphicTextMsgExt(signleGraphicTextMsg).pcx);
        com.baidu.yuyinala.privatemessage.implugin.util.b.hE(this.mContext);
        ImageLoader.getInstance().displayImage(covers, this.jNe, com.baidu.yuyinala.privatemessage.implugin.util.b.enU(), new ImageLoadingListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.r.1
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingStarted(String str, View view) {
                r.this.elf();
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingFailed(String str, View view, FailReason failReason) {
                r.this.elg();
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingComplete(String str, View view, Bitmap bitmap) {
                r.this.elg();
            }

            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingListener
            public void onLoadingCancelled(String str, View view) {
                r.this.elg();
            }
        }, new ImageLoadingProgressListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.r.2
            @Override // com.baidu.sumeru.universalimageloader.core.assist.ImageLoadingProgressListener
            public void onProgressUpdate(String str, View view, int i, int i2) {
                r.this.elf();
            }
        });
    }
}
