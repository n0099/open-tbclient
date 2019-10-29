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
    private ImageView aBm;
    private LinearLayout cBY;
    private HeadImageView iWu;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        asD();
        c(attributeSet);
        jA(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        asD();
        jA(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jA(int i) {
        setBackgroundDrawable(am.it(R.color.cp_bg_line_e));
        am.setViewTextColor(this.textView, R.color.common_color_10039, 1);
        SvgManager.amN().a(this.aBm, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.iWu.invalidate();
    }

    public void ckr() {
        if (this.iWu != null) {
            this.iWu.setVisibility(8);
        }
    }

    public void cks() {
        if (this.iWu != null) {
            this.iWu.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.iWu.startLoad(str, 26, false);
        } else {
            this.iWu.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void asD() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.cBY = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.iWu = (HeadImageView) findViewById(R.id.icon);
        this.aBm = (ImageView) findViewById(R.id.arrow);
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
        this.cBY.setClickable(false);
        this.cBY.setFocusable(false);
    }
}
