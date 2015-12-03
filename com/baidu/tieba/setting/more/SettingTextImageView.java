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
    private TextView anI;
    private ImageView anM;
    private LinearLayout container;
    private HeadImageView doD;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ai();
        c(attributeSet);
        dU(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Ai();
        dU(TbadkCoreApplication.m411getInst().getSkinType());
    }

    public void dU(int i) {
        com.baidu.tbadk.core.util.as.b(this.anI, n.c.about_tip_color, 1);
        com.baidu.tbadk.core.util.as.c(this.anM, n.e.icon_arrow_right);
        this.doD.invalidate();
    }

    public void azg() {
        if (this.doD != null) {
            this.doD.setVisibility(8);
        }
    }

    public void azh() {
        if (this.doD != null) {
            this.doD.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.anI.setText(str);
    }

    public void I(String str, boolean z) {
        if (z) {
            this.doD.d(str, 26, false);
        } else {
            this.doD.d(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Ai() {
        LayoutInflater.from(this.mContext).inflate(n.g.setting_text_image_view, (ViewGroup) this, true);
        this.container = (LinearLayout) findViewById(n.f.container);
        this.anI = (TextView) findViewById(n.f.text);
        this.doD = (HeadImageView) findViewById(n.f.icon);
        this.anM = (ImageView) findViewById(n.f.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, n.k.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.anI.setText(string);
        }
        if (color > -1) {
            this.anI.setTextColor(color);
        }
        this.container.setClickable(false);
        this.container.setFocusable(false);
    }
}
