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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes3.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private ImageView ahs;
    private LinearLayout cob;
    private TbImageView iTj;
    private Context mContext;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aqv();
        c(attributeSet);
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        aqv();
        jZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void jZ(int i) {
        am.f(this.textView, R.color.common_color_10039, 1);
        am.b(this.ahs, (int) R.drawable.icon_arrow_gray_right_n, i);
        this.iTj.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.iTj.clearCornerFlag();
        this.iTj.setConrers(0);
        this.iTj.setImageResource(i);
    }

    private void aqv() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.cob = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.iTj = (TbImageView) findViewById(R.id.icon);
        this.ahs = (ImageView) findViewById(R.id.arrow);
    }

    private void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, c.a.TbSettingView);
        String string = obtainStyledAttributes.getString(5);
        int color = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.textView.setText(string);
        }
        if (color > -1) {
            this.textView.setTextColor(color);
        }
        this.cob.setClickable(false);
        this.cob.setFocusable(false);
    }
}
