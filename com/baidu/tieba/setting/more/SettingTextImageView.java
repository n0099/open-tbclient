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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView anC;
    private TextView any;
    private HeadImageView cHl;
    private LinearLayout container;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zy();
        c(attributeSet);
        dE(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        zy();
        dE(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dE(int i) {
        com.baidu.tbadk.core.util.al.b(this.any, i.c.about_tip_color, 1);
        com.baidu.tbadk.core.util.al.c(this.anC, i.e.icon_arrow_right);
        this.cHl.invalidate();
    }

    public void aqE() {
        if (this.cHl != null) {
            this.cHl.setVisibility(8);
        }
    }

    public void aqF() {
        if (this.cHl != null) {
            this.cHl.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.any.setText(str);
    }

    public void F(String str, boolean z) {
        if (z) {
            this.cHl.d(str, 26, false);
        } else {
            this.cHl.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void zy() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_image_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.any = (TextView) findViewById(i.f.text);
        this.cHl = (HeadImageView) findViewById(i.f.icon);
        this.anC = (ImageView) findViewById(i.f.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.any.setText(string);
        }
        if (color > -1) {
            this.any.setTextColor(color);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }
}
