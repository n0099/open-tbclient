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
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView aAU;
    private LinearLayout cBh;
    private HeadImageView iVD;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        asB();
        c(attributeSet);
        jz(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        asB();
        jz(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jz(int i) {
        setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
        am.setViewTextColor(this.textView, R.color.common_color_10039, 1);
        SvgManager.amL().a(this.aAU, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.iVD.invalidate();
    }

    public void ckp() {
        if (this.iVD != null) {
            this.iVD.setVisibility(8);
        }
    }

    public void ckq() {
        if (this.iVD != null) {
            this.iVD.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.iVD.startLoad(str, 26, false);
        } else {
            this.iVD.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void asB() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.cBh = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.iVD = (HeadImageView) findViewById(R.id.icon);
        this.aAU = (ImageView) findViewById(R.id.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        this.cBh.setClickable(false);
        this.cBh.setFocusable(false);
    }
}
