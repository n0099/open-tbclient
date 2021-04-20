package com.baidu.tieba.lego.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class RatingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18363e;

    /* renamed from: f  reason: collision with root package name */
    public a f18364f;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18365a;

        /* renamed from: b  reason: collision with root package name */
        public String f18366b;

        /* renamed from: c  reason: collision with root package name */
        public Double f18367c;
    }

    public RatingView(Context context) {
        this(context, null);
    }

    public final void a() {
        removeAllViews();
        a aVar = this.f18364f;
        if (aVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.f18365a)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(this.f18363e);
            textView.setText(this.f18364f.f18365a);
            textView.setTextSize(0, l.g(this.f18363e, R.dimen.fontsize24));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            textView.setPadding(0, 0, l.g(this.f18363e, R.dimen.ds30), 0);
            textView.setLayoutParams(layoutParams);
            textView.setIncludeFontPadding(false);
            addView(textView);
        }
        if (!TextUtils.isEmpty(this.f18364f.f18366b)) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            TextView textView2 = new TextView(this.f18363e);
            textView2.setText(this.f18364f.f18366b);
            textView2.setTextSize(0, l.g(this.f18363e, R.dimen.fontsize24));
            textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            textView2.setPadding(0, 0, l.g(this.f18363e, R.dimen.ds6), 0);
            textView2.setLayoutParams(layoutParams2);
            textView2.setIncludeFontPadding(false);
            addView(textView2);
        }
        Double d2 = this.f18364f.f18367c;
        if (d2 == null || Double.isNaN(d2.doubleValue())) {
            return;
        }
        Integer valueOf = Integer.valueOf(this.f18364f.f18367c.intValue());
        if (valueOf.intValue() > 10) {
            valueOf = 10;
        }
        if (valueOf.intValue() < 0) {
            valueOf = 0;
        }
        int intValue = valueOf.intValue() >> 1;
        for (int i = 0; i < intValue; i++) {
            addView(b(SkinManager.getDrawable(R.drawable.icon_star_full)));
        }
        int i2 = 5 - intValue;
        if (valueOf.intValue() > 0 && valueOf.intValue() % 2 == 1) {
            addView(b(SkinManager.getDrawable(R.drawable.icon_star_half)));
            i2--;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            addView(b(SkinManager.getDrawable(R.drawable.icon_star_empty)));
        }
    }

    public final ImageView b(Drawable drawable) {
        ImageView imageView = new ImageView(this.f18363e);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, l.g(this.f18363e, R.dimen.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    public final void c() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public final a d(String str) {
        a aVar = new a();
        aVar.f18366b = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.f18366b = matcher.group(1);
                    }
                    aVar.f18367c = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
                } catch (NumberFormatException unused) {
                    aVar.f18366b = str;
                }
            } else {
                aVar.f18366b = str;
            }
        }
        return aVar;
    }

    public void setRating(String str, String str2) {
        a d2 = d(str2);
        this.f18364f = d2;
        d2.f18365a = str;
        a();
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18363e = context;
        c();
    }
}
