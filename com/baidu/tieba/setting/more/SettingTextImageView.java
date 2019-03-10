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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView agD;
    private TextView ahH;
    private LinearLayout ceE;
    private HeadImageView ius;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        akr();
        c(attributeSet);
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        akr();
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jg(int i) {
        al.d(this.ahH, d.C0236d.common_color_10039, 1);
        al.b(this.agD, d.f.icon_arrow_gray_right_n, i);
        this.ius.invalidate();
    }

    public void caD() {
        if (this.ius != null) {
            this.ius.setVisibility(8);
        }
    }

    public void caE() {
        if (this.ius != null) {
            this.ius.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.ahH.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.ius.startLoad(str, 26, false);
        } else {
            this.ius.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void akr() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_image_view, (ViewGroup) this, true);
        this.ceE = (LinearLayout) findViewById(d.g.container);
        this.ahH = (TextView) findViewById(d.g.text);
        this.ius = (HeadImageView) findViewById(d.g.icon);
        this.agD = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.ahH.setText(string);
        }
        if (color > -1) {
            this.ahH.setTextColor(color);
        }
        this.ceE.setClickable(false);
        this.ceE.setFocusable(false);
    }
}
