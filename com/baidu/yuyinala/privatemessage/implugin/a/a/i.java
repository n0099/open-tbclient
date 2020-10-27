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
    public TextView omh;
    public View omi;
    public TextView omj;

    public i(Context context, LayoutInflater layoutInflater) {
        this.omh = null;
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.h.bd_im_chating_push_graphic_txt, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.g.bd_im_chating_push_content_view);
        this.olU = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_time_txt);
        this.olV = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_push_title);
        this.omh = (TextView) this.mConvertView.findViewById(a.g.bd_im_chating_push_content);
        this.olW = (DarkImageView) this.mConvertView.findViewById(a.g.bd_im_chating_push_image);
        this.omi = this.mConvertView.findViewById(a.g.bd_im_seperator);
        this.omj = (TextView) this.mConvertView.findViewById(a.g.bd_im_readfulltxt);
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
            this.olW.getWindowVisibleDisplayFrame(rect);
            int width = (int) (rect.width() - (4.0f * context.getResources().getDimension(a.e.bd_im_push_lf)));
            ViewGroup.LayoutParams layoutParams = this.olW.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) (width / com.baidu.yuyinala.privatemessage.implugin.util.a.b.ovw);
            this.olW.setLayoutParams(layoutParams);
            this.olV.setText(signleGraphicTextMsg.getTitle());
            this.omh.setText(signleGraphicTextMsg.getDigest());
            com.baidu.yuyinala.privatemessage.implugin.util.f.g(context, signleGraphicTextMsg.getMsgTime());
            String cover = signleGraphicTextMsg.getCover();
            if (TextUtils.isEmpty(cover) || cover.length() < 6) {
                this.olW.setVisibility(8);
                int paddingLeft = this.omh.getPaddingLeft();
                int paddingRight = this.omh.getPaddingRight();
                this.omh.getPaddingTop();
                this.omh.setPadding(paddingLeft, 0, paddingRight, this.omh.getPaddingBottom());
            } else {
                com.baidu.yuyinala.privatemessage.implugin.util.b.gK(context);
                ImageLoader.getInstance().displayImage(cover, this.olW, com.baidu.yuyinala.privatemessage.implugin.util.b.eeo());
            }
        }
        eby();
        super.b(context, chatMsg);
    }

    private void eby() {
    }
}
