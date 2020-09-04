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
/* loaded from: classes20.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView eHE;
    private LinearLayout eHz;
    private HeadImageView lRL;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bpZ();
        e(attributeSet);
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        bpZ();
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pT(int i) {
        setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
        ap.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.bjq().a(this.eHE, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.lRL.invalidate();
    }

    public void dsm() {
        if (this.lRL != null) {
            this.lRL.setVisibility(8);
        }
    }

    public void dsn() {
        if (this.lRL != null) {
            this.lRL.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.lRL.startLoad(str, 26, false);
        } else {
            this.lRL.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void bpZ() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.eHz = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.lRL = (HeadImageView) findViewById(R.id.icon);
        this.eHE = (ImageView) findViewById(R.id.arrow);
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
        this.eHz.setClickable(false);
        this.eHz.setFocusable(false);
    }
}
