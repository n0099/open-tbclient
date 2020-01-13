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
/* loaded from: classes11.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout dpb;
    private ImageView dpf;
    private HeadImageView jTA;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aKt();
        d(attributeSet);
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        aKt();
        lM(TbadkCoreApplication.getInst().getSkinType());
    }

    public void lM(int i) {
        setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.aEp().a(this.dpf, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.jTA.invalidate();
    }

    public void cFz() {
        if (this.jTA != null) {
            this.jTA.setVisibility(8);
        }
    }

    public void cFA() {
        if (this.jTA != null) {
            this.jTA.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.jTA.startLoad(str, 26, false);
        } else {
            this.jTA.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void aKt() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.dpb = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.jTA = (HeadImageView) findViewById(R.id.icon);
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
