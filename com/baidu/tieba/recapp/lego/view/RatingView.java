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
import com.baidu.tieba.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes13.dex */
public class RatingView extends LinearLayout {
    private a kuN;
    private Context mContext;

    /* loaded from: classes13.dex */
    public static class a {
        public String iNh;
        public Double iNi;
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

    private a Jz(String str) {
        a aVar = new a();
        aVar.title = "";
        if (!TextUtils.isEmpty(str)) {
            Matcher matcher = Pattern.compile("(.*)\\{(.+)\\}").matcher(str);
            if (matcher.find()) {
                try {
                    if (!TextUtils.isEmpty(matcher.group(1))) {
                        aVar.title = matcher.group(1);
                    }
                    aVar.iNi = Double.valueOf(Double.parseDouble(matcher.group(2).trim()));
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
        this.kuN = Jz(str2);
        this.kuN.iNh = str;
        cnQ();
    }

    private void cnQ() {
        int i;
        removeAllViews();
        if (this.kuN != null) {
            if (!TextUtils.isEmpty(this.kuN.iNh)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                TextView textView = new TextView(this.mContext);
                textView.setText(this.kuN.iNh);
                textView.setTextSize(0, l.getDimens(this.mContext, R.dimen.fontsize24));
                textView.setTextColor(am.getColor(R.color.cp_cont_d));
                textView.setPadding(0, 0, l.getDimens(this.mContext, R.dimen.ds30), 0);
                textView.setLayoutParams(layoutParams);
                textView.setIncludeFontPadding(false);
                addView(textView);
            }
            if (!TextUtils.isEmpty(this.kuN.title)) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                TextView textView2 = new TextView(this.mContext);
                textView2.setText(this.kuN.title);
                textView2.setTextSize(0, l.getDimens(this.mContext, R.dimen.fontsize24));
                textView2.setTextColor(am.getColor(R.color.cp_cont_d));
                textView2.setPadding(0, 0, l.getDimens(this.mContext, R.dimen.ds6), 0);
                textView2.setLayoutParams(layoutParams2);
                textView2.setIncludeFontPadding(false);
                addView(textView2);
            }
            if (this.kuN.iNi != null && !Double.isNaN(this.kuN.iNi.doubleValue())) {
                Integer valueOf = Integer.valueOf(this.kuN.iNi.intValue());
                if (valueOf.intValue() > 10) {
                    valueOf = 10;
                }
                if (valueOf.intValue() < 0) {
                    valueOf = 0;
                }
                int intValue = valueOf.intValue() >> 1;
                for (int i2 = 0; i2 < intValue; i2++) {
                    addView(h(am.getDrawable(R.drawable.icon_star_full)));
                }
                int i3 = 5 - intValue;
                if (valueOf.intValue() <= 0 || valueOf.intValue() % 2 != 1) {
                    i = i3;
                } else {
                    addView(h(am.getDrawable(R.drawable.icon_star_half)));
                    i = i3 - 1;
                }
                for (int i4 = 0; i4 < i; i4++) {
                    addView(h(am.getDrawable(R.drawable.icon_star_empty)));
                }
            }
        }
    }
}
