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
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
/* loaded from: classes26.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout fqI;
    private ImageView fqN;
    private Context mContext;
    private HeadImageView mXI;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bAL();
        e(attributeSet);
        rY(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        bAL();
        rY(TbadkCoreApplication.getInst().getSkinType());
    }

    public void rY(int i) {
        setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
        ap.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        SvgManager.btW().a(this.fqN, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.mXI.invalidate();
    }

    public void dKo() {
        if (this.mXI != null) {
            this.mXI.setVisibility(8);
        }
    }

    public void dKp() {
        if (this.mXI != null) {
            this.mXI.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.mXI.startLoad(str, 26, false);
        } else {
            this.mXI.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void bAL() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.fqI = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.mXI = (HeadImageView) findViewById(R.id.icon);
        this.fqN = (ImageView) findViewById(R.id.arrow);
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
        this.fqI.setClickable(false);
        this.fqI.setFocusable(false);
    }
}
