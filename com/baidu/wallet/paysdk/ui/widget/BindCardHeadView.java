package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
@TargetApi(11)
/* loaded from: classes5.dex */
public class BindCardHeadView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f26138a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26139b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26140c;

    /* renamed from: d  reason: collision with root package name */
    public View f26141d;

    /* renamed from: e  reason: collision with root package name */
    public View f26142e;

    public BindCardHeadView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_head_view"), this);
        this.f26138a = (ImageView) findViewById(ResUtils.id(getContext(), "bind_card_img"));
        this.f26139b = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_title"));
        this.f26140c = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_subtitle"));
        this.f26141d = findViewById(ResUtils.id(getContext(), "bind_card_line"));
        this.f26142e = findViewById(ResUtils.id(getContext(), "bind_card_head_bottom_margin"));
    }

    public void setImageSrcId(int i2) {
        this.f26138a.setImageResource(i2);
    }

    public void setLineVisiable(boolean z) {
        this.f26141d.setVisibility(z ? 0 : 8);
        this.f26142e.setVisibility(z ? 8 : 0);
    }

    public void setSubTitle(CharSequence charSequence) {
        this.f26140c.setText(charSequence);
    }

    public void setSubTitleVisibility(int i2) {
        this.f26140c.setVisibility(i2);
    }

    public void setTitle(CharSequence charSequence) {
        this.f26139b.setText(charSequence);
        if (charSequence instanceof Spannable) {
            this.f26139b.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setTitleVisiable(boolean z) {
        this.f26139b.setVisibility(z ? 0 : 8);
        this.f26140c.setVisibility(z ? 0 : 8);
    }

    public BindCardHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BindCardHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
