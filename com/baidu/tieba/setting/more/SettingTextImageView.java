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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout aQi;
    private TextView aQj;
    private ImageView aQn;
    private HeadImageView gQc;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jh();
        c(attributeSet);
        eS(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Jh();
        eS(TbadkCoreApplication.getInst().getSkinType());
    }

    public void eS(int i) {
        al.c(this.aQj, e.d.common_color_10039, 1);
        al.b(this.aQn, e.f.icon_arrow_gray_right_n, i);
        this.gQc.invalidate();
    }

    public void bxb() {
        if (this.gQc != null) {
            this.gQc.setVisibility(8);
        }
    }

    public void bxc() {
        if (this.gQc != null) {
            this.gQc.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aQj.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gQc.startLoad(str, 26, false);
        } else {
            this.gQc.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Jh() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_image_view, (ViewGroup) this, true);
        this.aQi = (LinearLayout) findViewById(e.g.container);
        this.aQj = (TextView) findViewById(e.g.text);
        this.gQc = (HeadImageView) findViewById(e.g.icon);
        this.aQn = (ImageView) findViewById(e.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aQj.setText(string);
        }
        if (color > -1) {
            this.aQj.setTextColor(color);
        }
        this.aQi.setClickable(false);
        this.aQi.setFocusable(false);
    }
}
