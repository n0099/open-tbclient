package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class RatingView extends LinearLayout {
    private a grG;
    private Context mContext;

    /* loaded from: classes3.dex */
    public static class a {
        public String eTx;
        public Double eTy;
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

    private ImageView g(Drawable drawable) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, l.f(this.mContext, d.e.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    private a sO(String str) {
        a aVar = new a();
        aVar.title = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.title = matcher.group(1);
                    }
                    aVar.eTy = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
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
        this.grG = sO(str2);
        this.grG.eTx = str;
        aSs();
    }

    private void aSs() {
        int i;
        removeAllViews();
        if (this.grG != null) {
            if (!TextUtils.isEmpty(this.grG.eTx)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.mContext);
                textView.setText(this.grG.eTx);
                textView.setTextSize(0, l.f(this.mContext, d.e.fontsize24));
                textView.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                textView.setPadding(0, 0, l.f(this.mContext, d.e.ds30), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.grG.title)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.mContext);
                textView2.setText(this.grG.title);
                textView2.setTextSize(0, l.f(this.mContext, d.e.fontsize24));
                textView2.setTextColor(am.getColor(d.C0140d.cp_cont_d));
                textView2.setPadding(0, 0, l.f(this.mContext, d.e.ds6), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            if (this.grG.eTy != null && !Double.isNaN(this.grG.eTy.doubleValue())) {
                Integer valueOf = Integer.valueOf(this.grG.eTy.intValue());
                if (valueOf.intValue() > 10) {
                    valueOf = 10;
                }
                if (valueOf.intValue() < 0) {
                    valueOf = 0;
                }
                int intValue = valueOf.intValue() >> 1;
                for (int i2 = 0; i2 < intValue; i2++) {
                    addView(g(am.getDrawable(d.f.icon_star_full)));
                }
                int i3 = 5 - intValue;
                if (valueOf.intValue() <= 0 || valueOf.intValue() % 2 != 1) {
                    i = i3;
                } else {
                    addView(g(am.getDrawable(d.f.icon_star_half)));
                    i = i3 - 1;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    addView(g(am.getDrawable(d.f.icon_star_empty)));
                }
            }
        }
    }
}
