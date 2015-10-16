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
    private TextView alQ;
    private ImageView alU;
    private HeadImageView cOL;
    private LinearLayout container;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        zk();
        c(attributeSet);
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        zk();
        dF(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dF(int i) {
        com.baidu.tbadk.core.util.an.b(this.alQ, i.c.about_tip_color, 1);
        com.baidu.tbadk.core.util.an.c(this.alU, i.e.icon_arrow_right);
        this.cOL.invalidate();
    }

    public void atc() {
        if (this.cOL != null) {
            this.cOL.setVisibility(8);
        }
    }

    public void atd() {
        if (this.cOL != null) {
            this.cOL.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.alQ.setText(str);
    }

    public void G(String str, boolean z) {
        if (z) {
            this.cOL.d(str, 26, false);
        } else {
            this.cOL.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void zk() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_image_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alQ = (TextView) findViewById(i.f.text);
        this.cOL = (HeadImageView) findViewById(i.f.icon);
        this.alU = (ImageView) findViewById(i.f.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.alQ.setText(string);
        }
        if (color > -1) {
            this.alQ.setTextColor(color);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }
}
