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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView ahO;
    private TextView ajd;
    private LinearLayout cpd;
    private HeadImageView iWH;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqJ();
        c(attributeSet);
        kd(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        aqJ();
        kd(TbadkCoreApplication.getInst().getSkinType());
    }

    public void kd(int i) {
        setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
        am.f(this.ajd, R.color.common_color_10039, 1);
        SvgManager.ajv().a(this.ahO, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.iWH.invalidate();
    }

    public void cmE() {
        if (this.iWH != null) {
            this.iWH.setVisibility(8);
        }
    }

    public void cmF() {
        if (this.iWH != null) {
            this.iWH.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.ajd.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.iWH.startLoad(str, 26, false);
        } else {
            this.iWH.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void aqJ() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.cpd = (LinearLayout) findViewById(R.id.container);
        this.ajd = (TextView) findViewById(R.id.text);
        this.iWH = (HeadImageView) findViewById(R.id.icon);
        this.ahO = (ImageView) findViewById(R.id.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.ajd.setText(string);
        }
        if (color > -1) {
            this.ajd.setTextColor(color);
        }
        this.cpd.setClickable(false);
        this.cpd.setFocusable(false);
    }
}
