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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class SettingTextNormalImageView extends FrameLayout {
    private LinearLayout fAp;
    private ImageView fAu;
    private Context mContext;
    private TbImageView nde;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bDf();
        i(attributeSet);
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        bDf();
        sk(TbadkCoreApplication.getInst().getSkinType());
    }

    public void sk(int i) {
        ao.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        SvgManager.bwq().a(this.fAu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
        this.nde.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.nde.bJL();
        this.nde.setConrers(0);
        this.nde.setImageResource(i);
    }

    private void bDf() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.fAp = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.nde = (TbImageView) findViewById(R.id.icon);
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
