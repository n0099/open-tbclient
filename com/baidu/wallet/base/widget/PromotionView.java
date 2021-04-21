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
    public NetImageView f23596a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f23597b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f23598c;

    /* renamed from: d  reason: collision with root package name */
    public View f23599d;

    /* renamed from: e  reason: collision with root package name */
    public NetImageView f23600e;

    public PromotionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void updatePromotionView(String str, String str2, String str3, final String str4) {
        if (this.f23599d != null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
                return;
            }
            this.f23599d.setVisibility(0);
            if (!TextUtils.isEmpty(str4)) {
                this.f23599d.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.PromotionView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent(PromotionView.this.getContext(), WebViewActivity.class);
                        intent.putExtra("jump_url", str4);
                        PromotionView.this.getContext().startActivity(intent);
                    }
                });
            }
            if (!TextUtils.isEmpty(str)) {
                this.f23600e.setImageUrl(str);
                this.f23600e.setVisibility(0);
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f23596a.setVisibility(0);
                this.f23596a.setImageUrl(str2);
            } else {
                this.f23596a.setVisibility(8);
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            this.f23597b.setText(str3);
            this.f23597b.setVisibility(0);
        }
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_promotion_view"), this);
        this.f23599d = findViewById(ResUtils.id(getContext(), "wallet_promotion_all"));
        this.f23600e = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_big_image"));
        this.f23596a = (NetImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_img"));
        this.f23597b = (TextView) findViewById(ResUtils.id(getContext(), "wallet_promotion_txt"));
        ImageView imageView = (ImageView) findViewById(ResUtils.id(getContext(), "wallet_promotion_image_del"));
        this.f23598c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.PromotionView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromotionView.this.f23599d.setVisibility(8);
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
