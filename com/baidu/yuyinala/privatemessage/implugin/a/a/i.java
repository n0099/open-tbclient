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
/* loaded from: classes10.dex */
public class i extends c {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    public TextView paN;
    public View paO;
    public TextView paP;

    public i(Context context, LayoutInflater layoutInflater) {
        this.paN = null;
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_graphic_txt, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.paA = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.paB = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_title);
        this.paN = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_content);
        this.paC = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chating_push_image);
        this.paO = this.mConvertView.findViewById(a.f.bd_im_seperator);
        this.paP = (TextView) this.mConvertView.findViewById(a.f.bd_im_readfulltxt);
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
            this.paC.getWindowVisibleDisplayFrame(rect);
            int width = (int) (rect.width() - (4.0f * context.getResources().getDimension(a.d.bd_im_push_lf)));
            ViewGroup.LayoutParams layoutParams = this.paC.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) (width / com.baidu.yuyinala.privatemessage.implugin.util.a.b.pjX);
            this.paC.setLayoutParams(layoutParams);
            this.paB.setText(signleGraphicTextMsg.getTitle());
            this.paN.setText(signleGraphicTextMsg.getDigest());
            com.baidu.yuyinala.privatemessage.implugin.util.f.h(context, signleGraphicTextMsg.getMsgTime());
            String cover = signleGraphicTextMsg.getCover();
            if (TextUtils.isEmpty(cover) || cover.length() < 6) {
                this.paC.setVisibility(8);
                int paddingLeft = this.paN.getPaddingLeft();
                int paddingRight = this.paN.getPaddingRight();
                this.paN.getPaddingTop();
                this.paN.setPadding(paddingLeft, 0, paddingRight, this.paN.getPaddingBottom());
            } else {
                com.baidu.yuyinala.privatemessage.implugin.util.b.hE(context);
                ImageLoader.getInstance().displayImage(cover, this.paC, com.baidu.yuyinala.privatemessage.implugin.util.b.emJ());
            }
        }
        ejW();
        super.b(context, chatMsg);
    }

    private void ejW() {
    }
}
