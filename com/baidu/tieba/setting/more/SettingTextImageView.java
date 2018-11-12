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
    private LinearLayout aQY;
    private TextView aQZ;
    private ImageView aRd;
    private HeadImageView gRB;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Jt();
        c(attributeSet);
        fg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Jt();
        fg(TbadkCoreApplication.getInst().getSkinType());
    }

    public void fg(int i) {
        al.c(this.aQZ, e.d.common_color_10039, 1);
        al.b(this.aRd, e.f.icon_arrow_gray_right_n, i);
        this.gRB.invalidate();
    }

    public void bwx() {
        if (this.gRB != null) {
            this.gRB.setVisibility(8);
        }
    }

    public void bwy() {
        if (this.gRB != null) {
            this.gRB.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aQZ.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.gRB.startLoad(str, 26, false);
        } else {
            this.gRB.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Jt() {
        LayoutInflater.from(this.mContext).inflate(e.h.setting_text_image_view, (ViewGroup) this, true);
        this.aQY = (LinearLayout) findViewById(e.g.container);
        this.aQZ = (TextView) findViewById(e.g.text);
        this.gRB = (HeadImageView) findViewById(e.g.icon);
        this.aRd = (ImageView) findViewById(e.g.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, e.l.TbSettingView);
        String string = obtainStyledAttributes.getString(e.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(e.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aQZ.setText(string);
        }
        if (color > -1) {
            this.aQZ.setTextColor(color);
        }
        this.aQY.setClickable(false);
        this.aQY.setFocusable(false);
    }
}
