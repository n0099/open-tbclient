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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView agT;
    private TextView aif;
    private LinearLayout cmO;
    private HeadImageView iMQ;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        apq();
        c(attributeSet);
        jT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        apq();
        jT(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jT(int i) {
        al.f(this.aif, R.color.common_color_10039, 1);
        al.b(this.agT, (int) R.drawable.icon_arrow_gray_right_n, i);
        this.iMQ.invalidate();
    }

    public void ciI() {
        if (this.iMQ != null) {
            this.iMQ.setVisibility(8);
        }
    }

    public void ciJ() {
        if (this.iMQ != null) {
            this.iMQ.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.aif.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.iMQ.startLoad(str, 26, false);
        } else {
            this.iMQ.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void apq() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.cmO = (LinearLayout) findViewById(R.id.container);
        this.aif = (TextView) findViewById(R.id.text);
        this.iMQ = (HeadImageView) findViewById(R.id.icon);
        this.agT = (ImageView) findViewById(R.id.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.aif.setText(string);
        }
        if (color > -1) {
            this.aif.setTextColor(color);
        }
        this.cmO.setClickable(false);
        this.cmO.setFocusable(false);
    }
}
