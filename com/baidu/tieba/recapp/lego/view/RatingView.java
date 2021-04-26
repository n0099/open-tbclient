package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class RatingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21018e;

    /* renamed from: f  reason: collision with root package name */
    public a f21019f;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f21020a;

        /* renamed from: b  reason: collision with root package name */
        public String f21021b;

        /* renamed from: c  reason: collision with root package name */
        public Double f21022c;
    }

    public RatingView(Context context) {
        this(context, null);
    }

    public final void a() {
        removeAllViews();
        a aVar = this.f21019f;
        if (aVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.f21020a)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(this.f21018e);
            textView.setText(this.f21019f.f21020a);
            textView.setTextSize(0, l.g(this.f21018e, R.dimen.fontsize24));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            textView.setPadding(0, 0, l.g(this.f21018e, R.dimen.ds30), 0);
            textView.setLayoutParams(layoutParams);
            textView.setIncludeFontPadding(false);
            addView(textView);
        }
        if (!TextUtils.isEmpty(this.f21019f.f21021b)) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            TextView textView2 = new TextView(this.f21018e);
            textView2.setText(this.f21019f.f21021b);
            textView2.setTextSize(0, l.g(this.f21018e, R.dimen.fontsize24));
            textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            textView2.setPadding(0, 0, l.g(this.f21018e, R.dimen.ds6), 0);
            textView2.setLayoutParams(layoutParams2);
            textView2.setIncludeFontPadding(false);
            addView(textView2);
        }
        Double d2 = this.f21019f.f21022c;
        if (d2 == null || Double.isNaN(d2.doubleValue())) {
            return;
        }
        Integer valueOf = Integer.valueOf(this.f21019f.f21022c.intValue());
        if (valueOf.intValue() > 10) {
            valueOf = 10;
        }
        if (valueOf.intValue() < 0) {
            valueOf = 0;
        }
        int intValue = valueOf.intValue() >> 1;
        for (int i2 = 0; i2 < intValue; i2++) {
            addView(b(SkinManager.getDrawable(R.drawable.icon_star_full)));
        }
        int i3 = 5 - intValue;
        if (valueOf.intValue() > 0 && valueOf.intValue() % 2 == 1) {
            addView(b(SkinManager.getDrawable(R.drawable.icon_star_half)));
            i3--;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            addView(b(SkinManager.getDrawable(R.drawable.icon_star_empty)));
        }
    }

    public final ImageView b(Drawable drawable) {
        ImageView imageView = new ImageView(this.f21018e);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, l.g(this.f21018e, R.dimen.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    public final void c() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public final a d(String str) {
        a aVar = new a();
        aVar.f21021b = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.f21021b = matcher.group(1);
                    }
                    aVar.f21022c = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
                } catch (NumberFormatException unused) {
                    aVar.f21021b = str;
                }
            } else {
                aVar.f21021b = str;
            }
        }
        return aVar;
    }

    public void setRating(String str, String str2) {
        a d2 = d(str2);
        this.f21019f = d2;
        d2.f21020a = str;
        a();
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21018e = context;
        c();
    }
}
