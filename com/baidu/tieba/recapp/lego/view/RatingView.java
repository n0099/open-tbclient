package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class RatingView extends LinearLayout {
    private a gRL;
    private Context mContext;

    /* loaded from: classes3.dex */
    public static class a {
        public String ftA;
        public Double ftB;
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

    private ImageView e(Drawable drawable) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, l.h(this.mContext, e.C0210e.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    private a uJ(String str) {
        a aVar = new a();
        aVar.title = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.title = matcher.group(1);
                    }
                    aVar.ftB = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
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
        this.gRL = uJ(str2);
        this.gRL.ftA = str;
        aZS();
    }

    private void aZS() {
        int i;
        removeAllViews();
        if (this.gRL != null) {
            if (!TextUtils.isEmpty(this.gRL.ftA)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.mContext);
                textView.setText(this.gRL.ftA);
                textView.setTextSize(0, l.h(this.mContext, e.C0210e.fontsize24));
                textView.setTextColor(al.getColor(e.d.cp_cont_d));
                textView.setPadding(0, 0, l.h(this.mContext, e.C0210e.ds30), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.gRL.title)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.mContext);
                textView2.setText(this.gRL.title);
                textView2.setTextSize(0, l.h(this.mContext, e.C0210e.fontsize24));
                textView2.setTextColor(al.getColor(e.d.cp_cont_d));
                textView2.setPadding(0, 0, l.h(this.mContext, e.C0210e.ds6), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            if (this.gRL.ftB != null && !Double.isNaN(this.gRL.ftB.doubleValue())) {
                Integer valueOf = Integer.valueOf(this.gRL.ftB.intValue());
                if (valueOf.intValue() > 10) {
                    valueOf = 10;
                }
                if (valueOf.intValue() < 0) {
                    valueOf = 0;
                }
                int intValue = valueOf.intValue() >> 1;
                for (int i2 = 0; i2 < intValue; i2++) {
                    addView(e(al.getDrawable(e.f.icon_star_full)));
                }
                int i3 = 5 - intValue;
                if (valueOf.intValue() <= 0 || valueOf.intValue() % 2 != 1) {
                    i = i3;
                } else {
                    addView(e(al.getDrawable(e.f.icon_star_half)));
                    i = i3 - 1;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    addView(e(al.getDrawable(e.f.icon_star_empty)));
                }
            }
        }
    }
}
