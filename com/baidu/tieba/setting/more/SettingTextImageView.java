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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes20.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout ewV;
    private ImageView ewZ;
    private HeadImageView lAd;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bhm();
        e(attributeSet);
        nI(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        bhm();
        nI(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nI(int i) {
        setBackgroundDrawable(ao.lM(R.color.cp_bg_line_e));
        ao.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.baR().a(this.ewZ, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.lAd.invalidate();
    }

    public void dgL() {
        if (this.lAd != null) {
            this.lAd.setVisibility(8);
        }
    }

    public void dgM() {
        if (this.lAd != null) {
            this.lAd.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.lAd.startLoad(str, 26, false);
        } else {
            this.lAd.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void bhm() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.ewV = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.lAd = (HeadImageView) findViewById(R.id.icon);
        this.ewZ = (ImageView) findViewById(R.id.arrow);
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
        this.ewV.setClickable(false);
        this.ewV.setFocusable(false);
    }
}
