package com.baidu.tieba.setting.more;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView ahs;
    private LinearLayout cob;
    private HeadImageView iTi;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqv();
        c(attributeSet);
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        aqv();
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jZ(int i) {
        am.f(this.textView, R.color.common_color_10039, 1);
        am.b(this.ahs, (int) R.drawable.icon_arrow_gray_right_n, i);
        this.iTi.invalidate();
    }

    public void clA() {
        if (this.iTi != null) {
            this.iTi.setVisibility(8);
        }
    }

    public void clB() {
        if (this.iTi != null) {
            this.iTi.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.iTi.startLoad(str, 26, false);
        } else {
            this.iTi.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void aqv() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.cob = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.iTi = (HeadImageView) findViewById(R.id.icon);
        this.ahs = (ImageView) findViewById(R.id.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        this.cob.setClickable(false);
        this.cob.setFocusable(false);
    }
}
