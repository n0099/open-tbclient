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
    public TextView oMn;
    public View oMo;
    public TextView oMp;

    public i(Context context, LayoutInflater layoutInflater) {
        this.oMn = null;
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_push_graphic_txt, (ViewGroup) null);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_push_content_view);
        this.oMa = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMb = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_title);
        this.oMn = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_push_content);
        this.oMc = (DarkImageView) this.mConvertView.findViewById(a.f.bd_im_chating_push_image);
        this.oMo = this.mConvertView.findViewById(a.f.bd_im_seperator);
        this.oMp = (TextView) this.mConvertView.findViewById(a.f.bd_im_readfulltxt);
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
            this.oMc.getWindowVisibleDisplayFrame(rect);
            int width = (int) (rect.width() - (4.0f * context.getResources().getDimension(a.d.bd_im_push_lf)));
            ViewGroup.LayoutParams layoutParams = this.oMc.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) (width / com.baidu.yuyinala.privatemessage.implugin.util.a.b.oVy);
            this.oMc.setLayoutParams(layoutParams);
            this.oMb.setText(signleGraphicTextMsg.getTitle());
            this.oMn.setText(signleGraphicTextMsg.getDigest());
            com.baidu.yuyinala.privatemessage.implugin.util.f.i(context, signleGraphicTextMsg.getMsgTime());
            String cover = signleGraphicTextMsg.getCover();
            if (TextUtils.isEmpty(cover) || cover.length() < 6) {
                this.oMc.setVisibility(8);
                int paddingLeft = this.oMn.getPaddingLeft();
                int paddingRight = this.oMn.getPaddingRight();
                this.oMn.getPaddingTop();
                this.oMn.setPadding(paddingLeft, 0, paddingRight, this.oMn.getPaddingBottom());
            } else {
                com.baidu.yuyinala.privatemessage.implugin.util.b.hr(context);
                ImageLoader.getInstance().displayImage(cover, this.oMc, com.baidu.yuyinala.privatemessage.implugin.util.b.enQ());
            }
        }
        ekY();
        super.b(context, chatMsg);
    }

    private void ekY() {
    }
}
