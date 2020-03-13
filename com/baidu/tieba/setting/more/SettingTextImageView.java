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
/* loaded from: classes13.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView dtB;
    private LinearLayout dtx;
    private HeadImageView jUO;
    private Context mContext;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aMS();
        d(attributeSet);
        me(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        aMS();
        me(TbadkCoreApplication.getInst().getSkinType());
    }

    public void me(int i) {
        setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.aGC().a(this.dtB, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        this.jUO.invalidate();
    }

    public void cHf() {
        if (this.jUO != null) {
            this.jUO.setVisibility(8);
        }
    }

    public void cHg() {
        if (this.jUO != null) {
            this.jUO.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.jUO.startLoad(str, 26, false);
        } else {
            this.jUO.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void aMS() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.dtx = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.jUO = (HeadImageView) findViewById(R.id.icon);
        this.dtB = (ImageView) findViewById(R.id.arrow);
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
        this.dtx.setClickable(false);
        this.dtx.setFocusable(false);
    }
}
