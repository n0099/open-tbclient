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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout eVN;
    private ImageView eVS;
    private Context mContext;
    private HeadImageView mqz;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        btD();
        e(attributeSet);
        qE(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        btD();
        qE(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qE(int i) {
        setBackgroundDrawable(ap.oC(R.color.cp_bg_line_e));
        ap.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.bmU().a(this.eVS, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.mqz.invalidate();
    }

    public void dzN() {
        if (this.mqz != null) {
            this.mqz.setVisibility(8);
        }
    }

    public void dzO() {
        if (this.mqz != null) {
            this.mqz.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.mqz.startLoad(str, 26, false);
        } else {
            this.mqz.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void btD() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.eVN = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.mqz = (HeadImageView) findViewById(R.id.icon);
        this.eVS = (ImageView) findViewById(R.id.arrow);
    }

    private void e(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.TbSettingView);
        String string = obtainStyledAttributes.getString(R.styleable.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(R.styleable.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        this.eVN.setClickable(false);
        this.eVN.setFocusable(false);
    }
}
