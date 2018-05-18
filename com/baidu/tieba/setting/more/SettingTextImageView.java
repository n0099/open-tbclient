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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout aza;
    private TextView azb;
    private ImageView azg;
    private HeadImageView gkO;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        BZ();
        c(attributeSet);
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        BZ();
        eq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eq(int i) {
        ak.c(this.azb, d.C0126d.common_color_10039, 1);
        ak.b(this.azg, d.f.icon_arrow_gray_right_n, i);
        this.gkO.invalidate();
    }

    public void bne() {
        if (this.gkO != null) {
            this.gkO.setVisibility(8);
        }
    }

    public void bnf() {
        if (this.gkO != null) {
            this.gkO.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.azb.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gkO.startLoad(str, 26, false);
        } else {
            this.gkO.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void BZ() {
        LayoutInflater.from(this.mContext).inflate(d.i.setting_text_image_view, (ViewGroup) this, true);
        this.aza = (LinearLayout) findViewById(d.g.container);
        this.azb = (TextView) findViewById(d.g.text);
        this.gkO = (HeadImageView) findViewById(d.g.icon);
        this.azg = (ImageView) findViewById(d.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.m.TbSettingView);
        String string = obtainStyledAttributes.getString(d.m.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.m.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.azb.setText(string);
        }
        if (color > -1) {
            this.azb.setTextColor(color);
        }
        this.aza.setClickable(false);
        this.aza.setFocusable(false);
    }
}
