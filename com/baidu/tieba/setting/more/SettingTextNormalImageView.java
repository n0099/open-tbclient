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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private ImageView agE;
    private TextView ahI;
    private LinearLayout ceE;
    private TbImageView ium;
    private Context mContext;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        akq();
        c(attributeSet);
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        akq();
        jg(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jg(int i) {
        al.d(this.ahI, d.C0277d.common_color_10039, 1);
        al.b(this.agE, d.f.icon_arrow_gray_right_n, i);
        this.ium.invalidate();
    }

    public void setText(String str) {
        this.ahI.setText(str);
    }

    public void setLocalIcon(int i) {
        this.ium.clearCornerFlag();
        this.ium.setConrers(0);
        this.ium.setImageResource(i);
    }

    private void akq() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_normal_image_view, (ViewGroup) this, true);
        this.ceE = (LinearLayout) findViewById(d.g.container);
        this.ahI = (TextView) findViewById(d.g.text);
        this.ium = (TbImageView) findViewById(d.g.icon);
        this.agE = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.ahI.setText(string);
        }
        if (color > -1) {
            this.ahI.setTextColor(color);
        }
        this.ceE.setClickable(false);
        this.ceE.setFocusable(false);
    }
}
