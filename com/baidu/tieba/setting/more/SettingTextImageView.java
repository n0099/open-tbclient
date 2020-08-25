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
    private ImageView eHA;
    private LinearLayout eHv;
    private HeadImageView lRw;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bpY();
        e(attributeSet);
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        bpY();
        pT(TbadkCoreApplication.getInst().getSkinType());
    }

    public void pT(int i) {
        setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
        ap.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.bjq().a(this.eHA, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.lRw.invalidate();
    }

    public void dsh() {
        if (this.lRw != null) {
            this.lRw.setVisibility(8);
        }
    }

    public void dsi() {
        if (this.lRw != null) {
            this.lRw.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.lRw.startLoad(str, 26, false);
        } else {
            this.lRw.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void bpY() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.eHv = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.lRw = (HeadImageView) findViewById(R.id.icon);
        this.eHA = (ImageView) findViewById(R.id.arrow);
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
        this.eHv.setClickable(false);
        this.eHv.setFocusable(false);
    }
}
