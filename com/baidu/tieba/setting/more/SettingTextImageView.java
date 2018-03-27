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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout boA;
    private TextView boB;
    private ImageView boG;
    private HeadImageView gOF;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jv();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Jv();
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public void hr(int i) {
        aj.e(this.boB, d.C0141d.common_color_10039, 1);
        aj.b(this.boG, d.f.icon_arrow_gray_right_n, i);
        this.gOF.invalidate();
    }

    public void brW() {
        if (this.gOF != null) {
            this.gOF.setVisibility(8);
        }
    }

    public void brX() {
        if (this.gOF != null) {
            this.gOF.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.boB.setText(str);
    }

    public void X(String str, boolean z) {
        if (z) {
            this.gOF.startLoad(str, 26, false);
        } else {
            this.gOF.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Jv() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_image_view, (ViewGroup) this, true);
        this.boA = (LinearLayout) findViewById(d.g.container);
        this.boB = (TextView) findViewById(d.g.text);
        this.gOF = (HeadImageView) findViewById(d.g.icon);
        this.boG = (ImageView) findViewById(d.g.arrow);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.boB.setText(string);
        }
        if (color > -1) {
            this.boB.setTextColor(color);
        }
        this.boA.setClickable(false);
        this.boA.setFocusable(false);
    }
}
