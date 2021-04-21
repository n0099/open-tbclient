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
    public ImageView f26065a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26066b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26067c;

    /* renamed from: d  reason: collision with root package name */
    public View f26068d;

    /* renamed from: e  reason: collision with root package name */
    public View f26069e;

    public BindCardHeadView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_head_view"), this);
        this.f26065a = (ImageView) findViewById(ResUtils.id(getContext(), "bind_card_img"));
        this.f26066b = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_title"));
        this.f26067c = (TextView) findViewById(ResUtils.id(getContext(), "bind_card_subtitle"));
        this.f26068d = findViewById(ResUtils.id(getContext(), "bind_card_line"));
        this.f26069e = findViewById(ResUtils.id(getContext(), "bind_card_head_bottom_margin"));
    }

    public void setImageSrcId(int i) {
        this.f26065a.setImageResource(i);
    }

    public void setLineVisiable(boolean z) {
        this.f26068d.setVisibility(z ? 0 : 8);
        this.f26069e.setVisibility(z ? 8 : 0);
    }

    public void setSubTitle(CharSequence charSequence) {
        this.f26067c.setText(charSequence);
    }

    public void setSubTitleVisibility(int i) {
        this.f26067c.setVisibility(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f26066b.setText(charSequence);
        if (charSequence instanceof Spannable) {
            this.f26066b.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setTitleVisiable(boolean z) {
        this.f26066b.setVisibility(z ? 0 : 8);
        this.f26067c.setVisibility(z ? 0 : 8);
    }

    public BindCardHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BindCardHeadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
