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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private LinearLayout fkc;
    private ImageView fkh;
    private Context mContext;
    private TbImageView mJh;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bxV();
        e(attributeSet);
        qZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        bxV();
        qZ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qZ(int i) {
        ap.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.brn().a(this.fkh, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(ap.oX(R.color.cp_bg_line_e));
        this.mJh.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.mJh.bEy();
        this.mJh.setConrers(0);
        this.mJh.setImageResource(i);
    }

    private void bxV() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.fkc = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.mJh = (TbImageView) findViewById(R.id.icon);
        this.fkh = (ImageView) findViewById(R.id.arrow);
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
        this.fkc.setClickable(false);
        this.fkc.setFocusable(false);
    }
}
