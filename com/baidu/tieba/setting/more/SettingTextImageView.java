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
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SettingTextImageView extends FrameLayout {
    private TextView api;
    private ImageView apm;
    private LinearLayout container;
    private HeadImageView dvQ;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zU();
        c(attributeSet);
        dO(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        zU();
        dO(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dO(int i) {
        com.baidu.tbadk.core.util.as.b(this.api, n.d.about_tip_color, 1);
        com.baidu.tbadk.core.util.as.c(this.apm, n.f.icon_arrow_right);
        this.dvQ.invalidate();
    }

    public void aBm() {
        if (this.dvQ != null) {
            this.dvQ.setVisibility(8);
        }
    }

    public void aBn() {
        if (this.dvQ != null) {
            this.dvQ.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.api.setText(str);
    }

    public void H(String str, boolean z) {
        if (z) {
            this.dvQ.d(str, 26, false);
        } else {
            this.dvQ.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void zU() {
        LayoutInflater.from(this.mContext).inflate(n.h.setting_text_image_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.g.container);
        this.api = (TextView) findViewById(n.g.text);
        this.dvQ = (HeadImageView) findViewById(n.g.icon);
        this.apm = (ImageView) findViewById(n.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.l.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.api.setText(string);
        }
        if (color > -1) {
            this.api.setTextColor(color);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }
}
