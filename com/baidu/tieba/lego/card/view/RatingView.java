package com.baidu.tieba.lego.card.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class RatingView extends LinearLayout {
    private a gKw;
    private Context mContext;

    /* loaded from: classes2.dex */
    public static class a {
        public String gKx;
        public Double gKy;
        public String title;
    }

    public RatingView(Context context) {
        this(context, null);
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private ImageView f(Drawable drawable) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    private a yg(String str) {
        a aVar = new a();
        aVar.title = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.title = matcher.group(1);
                    }
                    aVar.gKy = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
                } catch (NumberFormatException e) {
                    aVar.title = str;
                }
            } else {
                aVar.title = str;
            }
        }
        return aVar;
    }

    public void setRating(String str, String str2) {
        this.gKw = yg(str2);
        this.gKw.gKx = str;
        bAX();
    }

    private void bAX() {
        int i;
        removeAllViews();
        if (this.gKw != null) {
            if (!TextUtils.isEmpty(this.gKw.gKx)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.mContext);
                textView.setText(this.gKw.gKx);
                textView.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.fontsize24));
                textView.setTextColor(al.getColor(d.C0236d.cp_cont_d));
                textView.setPadding(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds30), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.gKw.title)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.mContext);
                textView2.setText(this.gKw.title);
                textView2.setTextSize(0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.fontsize24));
                textView2.setTextColor(al.getColor(d.C0236d.cp_cont_d));
                textView2.setPadding(0, 0, com.baidu.adp.lib.util.l.h(this.mContext, d.e.ds6), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            if (this.gKw.gKy != null && !Double.isNaN(this.gKw.gKy.doubleValue())) {
                Integer valueOf = Integer.valueOf(this.gKw.gKy.intValue());
                if (valueOf.intValue() > 10) {
                    valueOf = 10;
                }
                if (valueOf.intValue() < 0) {
                    valueOf = 0;
                }
                int intValue = valueOf.intValue() >> 1;
                for (int i2 = 0; i2 < intValue; i2++) {
                    addView(f(al.getDrawable(d.f.icon_star_full)));
                }
                int i3 = 5 - intValue;
                if (valueOf.intValue() <= 0 || valueOf.intValue() % 2 != 1) {
                    i = i3;
                } else {
                    addView(f(al.getDrawable(d.f.icon_star_half)));
                    i = i3 - 1;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    addView(f(al.getDrawable(d.f.icon_star_empty)));
                }
            }
        }
    }
}
