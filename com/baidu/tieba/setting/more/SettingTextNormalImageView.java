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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private LinearLayout ehT;
    private ImageView ehX;
    private TbImageView kYP;
    private Context mContext;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bbB();
        e(attributeSet);
        mW(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        bbB();
        mW(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mW(int i) {
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.aUW().a(this.ehX, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(am.le(R.color.cp_bg_line_e));
        this.kYP.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.kYP.bhs();
        this.kYP.setConrers(0);
        this.kYP.setImageResource(i);
    }

    private void bbB() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.ehT = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.kYP = (TbImageView) findViewById(R.id.icon);
        this.ehX = (ImageView) findViewById(R.id.arrow);
    }

    private void e(AttributeSet attributeSet) {
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
        this.ehT.setClickable(false);
        this.ehT.setFocusable(false);
    }
}
