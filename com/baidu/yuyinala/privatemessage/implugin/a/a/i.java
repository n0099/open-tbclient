package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.SignleGraphicTextMsg;
import com.baidu.live.sdk.a;
import com.baidu.sumeru.universalimageloader.core.ImageLoader;
import com.baidu.yuyinala.privatemessage.implugin.ui.material.widget.DarkImageView;
/* loaded from: classes4.dex */
public class i extends c {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    public TextView ovD;
    public View ovE;
    public TextView ovF;

    public i(Context context, LayoutInflater layoutInflater) {
        this.ovD = null;
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_graphic_txt, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.ovq = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.ovr = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_title);
        this.ovD = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_content);
        this.ovs = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chating_push_image);
        this.ovE = this.mConvertView.findViewById(a.f.bd_im_seperator);
        this.ovF = (TextView) this.mConvertView.findViewById(a.f.bd_im_readfulltxt);
        this.mConvertView.setTag(this);
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public View getConvertView() {
        return this.mConvertView;
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public View getContentView() {
        return this.mContentView;
    }

    public static c e(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof i)) ? new i(context, layoutInflater) : (i) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.c
    public void b(Context context, ChatMsg chatMsg) {
        if (chatMsg instanceof SignleGraphicTextMsg) {
            SignleGraphicTextMsg signleGraphicTextMsg = (SignleGraphicTextMsg) chatMsg;
            Rect rect = new Rect();
            this.ovs.getWindowVisibleDisplayFrame(rect);
            int width = (int) (rect.width() - (4.0f * context.getResources().getDimension(a.d.bd_im_push_lf)));
            ViewGroup.LayoutParams layoutParams = this.ovs.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) (width / com.baidu.yuyinala.privatemessage.implugin.util.a.b.oEO);
            this.ovs.setLayoutParams(layoutParams);
            this.ovr.setText(signleGraphicTextMsg.getTitle());
            this.ovD.setText(signleGraphicTextMsg.getDigest());
            com.baidu.yuyinala.privatemessage.implugin.util.f.g(context, signleGraphicTextMsg.getMsgTime());
            String cover = signleGraphicTextMsg.getCover();
            if (TextUtils.isEmpty(cover) || cover.length() < 6) {
                this.ovs.setVisibility(8);
                int paddingLeft = this.ovD.getPaddingLeft();
                int paddingRight = this.ovD.getPaddingRight();
                this.ovD.getPaddingTop();
                this.ovD.setPadding(paddingLeft, 0, paddingRight, this.ovD.getPaddingBottom());
            } else {
                com.baidu.yuyinala.privatemessage.implugin.util.b.gK(context);
                ImageLoader.getInstance().displayImage(cover, this.ovs, com.baidu.yuyinala.privatemessage.implugin.util.b.eid());
            }
        }
        efn();
        super.b(context, chatMsg);
    }

    private void efn() {
    }
}
