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
import d.a.c.e.p.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class RatingView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f18731e;

    /* renamed from: f  reason: collision with root package name */
    public a f18732f;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18733a;

        /* renamed from: b  reason: collision with root package name */
        public String f18734b;

        /* renamed from: c  reason: collision with root package name */
        public Double f18735c;
    }

    public RatingView(Context context) {
        this(context, null);
    }

    public final void a() {
        removeAllViews();
        a aVar = this.f18732f;
        if (aVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVar.f18733a)) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(this.f18731e);
            textView.setText(this.f18732f.f18733a);
            textView.setTextSize(0, l.g(this.f18731e, R.dimen.fontsize24));
            textView.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            textView.setPadding(0, 0, l.g(this.f18731e, R.dimen.ds30), 0);
            textView.setLayoutParams(layoutParams);
            textView.setIncludeFontPadding(false);
            addView(textView);
        }
        if (!TextUtils.isEmpty(this.f18732f.f18734b)) {
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            TextView textView2 = new TextView(this.f18731e);
            textView2.setText(this.f18732f.f18734b);
            textView2.setTextSize(0, l.g(this.f18731e, R.dimen.fontsize24));
            textView2.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
            textView2.setPadding(0, 0, l.g(this.f18731e, R.dimen.ds6), 0);
            textView2.setLayoutParams(layoutParams2);
            textView2.setIncludeFontPadding(false);
            addView(textView2);
        }
        Double d2 = this.f18732f.f18735c;
        if (d2 == null || Double.isNaN(d2.doubleValue())) {
            return;
        }
        Integer valueOf = Integer.valueOf(this.f18732f.f18735c.intValue());
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
        ImageView imageView = new ImageView(this.f18731e);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, l.g(this.f18731e, R.dimen.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    public final void c() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    public final a d(String str) {
        a aVar = new a();
        aVar.f18734b = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.f18734b = matcher.group(1);
                    }
                    aVar.f18735c = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
                } catch (NumberFormatException unused) {
                    aVar.f18734b = str;
                }
            } else {
                aVar.f18734b = str;
            }
        }
        return aVar;
    }

    public void setRating(String str, String str2) {
        a d2 = d(str2);
        this.f18732f = d2;
        d2.f18733a = str;
        a();
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18731e = context;
        c();
    }
}
