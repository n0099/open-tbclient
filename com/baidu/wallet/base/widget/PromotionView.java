package com.baidu.wallet.base.widget;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.apollon.base.widget.NetImageView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.paysdk.ui.WebViewActivity;
/* loaded from: classes5.dex */
public class PromotionView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public NetImageView f23573a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23574b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f23575c;

    /* renamed from: d  reason: collision with root package name */
    public View f23576d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f23577e;

    public PromotionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public void updatePromotionView(String str, String str2, String str3, final String str4) {
        if (this.f23576d != null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return;
            }
            this.f23576d.setVisibility(0);
            if (!TextUtils.isEmpty(str4)) {
                this.f23576d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.PromotionView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent(PromotionView.this.getContext(), WebViewActivity.class);
                        intent.putExtra("jump_url", str4);
                        PromotionView.this.getContext().startActivity(intent);
                    }
                });
            }
            if (!TextUtils.isEmpty(str)) {
                this.f23577e.setImageUrl(str);
                this.f23577e.setVisibility(0);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f23573a.setVisibility(0);
                this.f23573a.setImageUrl(str2);
            } else {
                this.f23573a.setVisibility(8);
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            this.f23574b.setText(str3);
            this.f23574b.setVisibility(0);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_promotion_view"), this);
        this.f23576d = findViewById(ResUtils.id(getContext(), "wallet_promotion_all"));
        this.f23577e = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_big_image"));
        this.f23573a = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_img"));
        this.f23574b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_promotion_txt"));
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_image_del"));
        this.f23575c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.PromotionView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromotionView.this.f23576d.setVisibility(8);
            }
        });
    }

    public PromotionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PromotionView(Context context) {
        super(context);
        a();
    }
}
