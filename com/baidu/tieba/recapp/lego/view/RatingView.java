package com.baidu.tieba.recapp.lego.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes26.dex */
public class RatingView extends LinearLayout {
    private Context mContext;
    private a mww;

    /* loaded from: classes26.dex */
    public static class a {
        public String kIw;
        public Double score;
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

    private ImageView h(Drawable drawable) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setPadding(0, 0, l.getDimens(this.mContext, R.dimen.ds4), 0);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    private a RA(String str) {
        a aVar = new a();
        aVar.title = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.title = matcher.group(1);
                    }
                    aVar.score = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
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
        this.mww = RA(str2);
        this.mww.kIw = str;
        dad();
    }

    private void dad() {
        int i;
        removeAllViews();
        if (this.mww != null) {
            if (!TextUtils.isEmpty(this.mww.kIw)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.mContext);
                textView.setText(this.mww.kIw);
                textView.setTextSize(0, l.getDimens(this.mContext, R.dimen.fontsize24));
                textView.setTextColor(ap.getColor(R.color.cp_cont_d));
                textView.setPadding(0, 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.mww.title)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.mContext);
                textView2.setText(this.mww.title);
                textView2.setTextSize(0, l.getDimens(this.mContext, R.dimen.fontsize24));
                textView2.setTextColor(ap.getColor(R.color.cp_cont_d));
                textView2.setPadding(0, 0, l.getDimens(this.mContext, R.dimen.ds6), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            if (this.mww.score != null && !Double.isNaN(this.mww.score.doubleValue())) {
                Integer valueOf = Integer.valueOf(this.mww.score.intValue());
                if (valueOf.intValue() > 10) {
                    valueOf = 10;
                }
                if (valueOf.intValue() < 0) {
                    valueOf = 0;
                }
                int intValue = valueOf.intValue() >> 1;
                for (int i2 = 0; i2 < intValue; i2++) {
                    addView(h(ap.getDrawable(R.drawable.icon_star_full)));
                }
                int i3 = 5 - intValue;
                if (valueOf.intValue() <= 0 || valueOf.intValue() % 2 != 1) {
                    i = i3;
                } else {
                    addView(h(ap.getDrawable(R.drawable.icon_star_half)));
                    i = i3 - 1;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    addView(h(ap.getDrawable(R.drawable.icon_star_empty)));
                }
            }
        }
    }
}
