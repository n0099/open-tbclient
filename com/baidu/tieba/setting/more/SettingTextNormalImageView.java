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
/* loaded from: classes11.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private LinearLayout dpb;
    private ImageView dpf;
    private TbImageView jTG;
    private Context mContext;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aKt();
        d(attributeSet);
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        aKt();
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void lM(int i) {
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.aEp().a(this.dpf, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        this.jTG.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.jTG.aQz();
        this.jTG.setConrers(0);
        this.jTG.setImageResource(i);
    }

    private void aKt() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.dpb = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.jTG = (TbImageView) findViewById(R.id.icon);
        this.dpf = (ImageView) findViewById(R.id.arrow);
    }

    private void d(AttributeSet attributeSet) {
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
        this.dpb.setClickable(false);
        this.dpb.setFocusable(false);
    }
}
