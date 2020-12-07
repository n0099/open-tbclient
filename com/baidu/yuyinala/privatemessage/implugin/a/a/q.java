package com.baidu.yuyinala.privatemessage.implugin.a.a;

import android.content.Context;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.HtmlMsg;
import com.baidu.android.imsdk.chatmessage.messages.TextMsg;
import com.baidu.live.sdk.a;
import com.baidu.yuyinala.privatemessage.implugin.a.a;
import com.baidu.yuyinala.privatemessage.implugin.ui.common.EventDispatchRelativeLayout;
import java.net.URLDecoder;
/* loaded from: classes4.dex */
public class q extends d {
    public View mContentView;
    public Context mContext;
    public View mConvertView;
    public TextView oNq;

    public q(Context context, LayoutInflater layoutInflater) {
        this.mContext = context;
        this.mConvertView = layoutInflater.inflate(a.g.bd_im_chating_receive_txt_item, (ViewGroup) null);
        this.oNq = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_txt);
        this.oMa = (TextView) this.mConvertView.findViewById(a.f.bd_im_chating_time_txt);
        this.oMd = (ImageView) this.mConvertView.findViewById(a.f.bd_im_headview);
        this.jbt = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_name);
        this.moi = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_agetime);
        this.oMe = (TextView) this.mConvertView.findViewById(a.f.bd_im_user_constellation);
        this.mContentView = this.mConvertView.findViewById(a.f.bd_im_chating_msg_content_layout);
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

    public static q l(Context context, LayoutInflater layoutInflater, ChatMsg chatMsg, View view) {
        return (view == null || !(view.getTag() instanceof q)) ? new q(context, layoutInflater) : (q) view.getTag();
    }

    @Override // com.baidu.yuyinala.privatemessage.implugin.a.a.d
    public void b(final Context context, ChatMsg chatMsg) {
        Spanned spanned;
        URLSpan[] uRLSpanArr;
        if (chatMsg instanceof TextMsg) {
            String text = ((TextMsg) chatMsg).getText();
            if (text == null || TextUtils.isEmpty(text)) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ReceiveTxtItem", "ReceiveTxtItem>init>sequence is null, msgtext = " + ((TextMsg) chatMsg).getText());
                return;
            }
            this.oNq.setText(text);
            Spannable c = com.baidu.yuyinala.privatemessage.implugin.util.f.c(context, this.oNq.getText());
            if (c != null) {
                this.oNq.setText(c);
                this.oNq.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.oNq.setFocusableInTouchMode(true);
            this.oNq.setFocusable(true);
            this.oNq.setClickable(true);
            this.oNq.setLongClickable(true);
            this.oNq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.q.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    a.f subViewLongClickListener;
                    View contentView = q.this.getContentView();
                    if ((contentView instanceof EventDispatchRelativeLayout) && (subViewLongClickListener = ((EventDispatchRelativeLayout) contentView).getSubViewLongClickListener()) != null) {
                        subViewLongClickListener.ekX();
                        return true;
                    }
                    return true;
                }
            });
        } else if (chatMsg instanceof HtmlMsg) {
            try {
                spanned = Html.fromHtml(URLDecoder.decode(((HtmlMsg) chatMsg).getText()));
            } catch (Exception e) {
                e.printStackTrace();
                spanned = null;
            }
            if (spanned == null || TextUtils.isEmpty(spanned.toString())) {
                com.baidu.yuyinala.privatemessage.implugin.util.c.e("ReceiveTxtItem", "ReceiveTxtItem>init>CharSequence is null, msgtext = " + ((HtmlMsg) chatMsg).getText());
                return;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
            for (final URLSpan uRLSpan : (URLSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), URLSpan.class)) {
                int spanStart = spannableStringBuilder.getSpanStart(uRLSpan);
                int spanEnd = spannableStringBuilder.getSpanEnd(uRLSpan);
                spannableStringBuilder.removeSpan(uRLSpan);
                spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.q.2
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                        com.baidu.yuyinala.privatemessage.implugin.d.b.elg().h(context, uRLSpan.getURL(), false);
                    }
                }, spanStart, spanEnd, 33);
            }
            this.oNq.setMovementMethod(LinkMovementMethod.getInstance());
            this.oNq.setText(spannableStringBuilder);
            this.oNq.setFocusableInTouchMode(true);
            this.oNq.setFocusable(true);
            this.oNq.setClickable(true);
            this.oNq.setLongClickable(true);
            this.oNq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.yuyinala.privatemessage.implugin.a.a.q.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    a.f subViewLongClickListener;
                    View contentView = q.this.getContentView();
                    if ((contentView instanceof EventDispatchRelativeLayout) && (subViewLongClickListener = ((EventDispatchRelativeLayout) contentView).getSubViewLongClickListener()) != null) {
                        subViewLongClickListener.ekX();
                        return true;
                    }
                    return true;
                }
            });
        }
    }
}
