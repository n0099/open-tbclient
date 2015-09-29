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
    private TextView alP;
    private ImageView alT;
    private HeadImageView cOm;
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
        com.baidu.tbadk.core.util.am.b(this.alP, i.c.about_tip_color, 1);
        com.baidu.tbadk.core.util.am.c(this.alT, i.e.icon_arrow_right);
        this.cOm.invalidate();
    }

    public void asW() {
        if (this.cOm != null) {
            this.cOm.setVisibility(8);
        }
    }

    public void asX() {
        if (this.cOm != null) {
            this.cOm.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.alP.setText(str);
    }

    public void G(String str, boolean z) {
        if (z) {
            this.cOm.d(str, 26, false);
        } else {
            this.cOm.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void zk() {
        LayoutInflater.from(this.mContext).inflate(i.g.setting_text_image_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(i.f.container);
        this.alP = (TextView) findViewById(i.f.text);
        this.cOm = (HeadImageView) findViewById(i.f.icon);
        this.alT = (ImageView) findViewById(i.f.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, i.j.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.alP.setText(string);
        }
        if (color > -1) {
            this.alP.setTextColor(color);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }
}
