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
/* loaded from: classes8.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout fAp;
    private ImageView fAu;
    private Context mContext;
    private HeadImageView ndc;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bDg();
        i(attributeSet);
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        bDg();
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void sk(int i) {
        setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
        ao.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        SvgManager.bwr().a(this.fAu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.ndc.invalidate();
    }

    public void dKe() {
        if (this.ndc != null) {
            this.ndc.setVisibility(8);
        }
    }

    public void dKf() {
        if (this.ndc != null) {
            this.ndc.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.ndc.startLoad(str, 26, false);
        } else {
            this.ndc.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void bDg() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.fAp = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.ndc = (HeadImageView) findViewById(R.id.icon);
        this.fAu = (ImageView) findViewById(R.id.arrow);
    }

    private void i(AttributeSet attributeSet) {
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
        this.fAp.setClickable(false);
        this.fAp.setFocusable(false);
    }
}
