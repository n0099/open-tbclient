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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes13.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private LinearLayout eqD;
    private ImageView eqH;
    private TbImageView lsM;
    private Context mContext;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bdD();
        e(attributeSet);
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        bdD();
        nq(TbadkCoreApplication.getInst().getSkinType());
    }

    public void nq(int i) {
        an.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.aWQ().a(this.eqH, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(an.ls(R.color.cp_bg_line_e));
        this.lsM.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.lsM.bjE();
        this.lsM.setConrers(0);
        this.lsM.setImageResource(i);
    }

    private void bdD() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.eqD = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.lsM = (TbImageView) findViewById(R.id.icon);
        this.eqH = (ImageView) findViewById(R.id.arrow);
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
        this.eqD.setClickable(false);
        this.eqD.setFocusable(false);
    }
}
