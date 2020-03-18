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
    private LinearLayout dtK;
    private ImageView dtO;
    private TbImageView jWr;
    private Context mContext;
    private TextView textView;

    public SettingTextNormalImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        aMW();
        d(attributeSet);
        mg(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextNormalImageView(Context context) {
        super(context);
        this.mContext = context;
        aMW();
        mg(TbadkCoreApplication.getInst().getSkinType());
    }

    public void mg(int i) {
        am.setViewTextColor(this.textView, R.color.cp_cont_b, 1);
        SvgManager.aGG().a(this.dtO, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
        this.jWr.invalidate();
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setLocalIcon(int i) {
        this.jWr.aSX();
        this.jWr.setConrers(0);
        this.jWr.setImageResource(i);
    }

    private void aMW() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_normal_image_view, (ViewGroup) this, true);
        this.dtK = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.jWr = (TbImageView) findViewById(R.id.icon);
        this.dtO = (ImageView) findViewById(R.id.arrow);
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
        this.dtK.setClickable(false);
        this.dtK.setFocusable(false);
    }
}
