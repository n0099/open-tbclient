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
/* loaded from: classes8.dex */
public class SettingTextImageView extends FrameLayout {
    private LinearLayout fxX;
    private ImageView fyc;
    private Context mContext;
    private HeadImageView nig;
    private TextView textView;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        bzE();
        h(attributeSet);
        qJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        bzE();
        qJ(TbadkCoreApplication.getInst().getSkinType());
    }

    public void qJ(int i) {
        setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
        ap.setViewTextColor(this.textView, R.color.CAM_X0105, 1);
        SvgManager.bsR().a(this.fyc, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
        this.nig.invalidate();
    }

    public void dIx() {
        if (this.nig != null) {
            this.nig.setVisibility(8);
        }
    }

    public void dIy() {
        if (this.nig != null) {
            this.nig.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.textView.setText(str);
    }

    public void setIcon(String str, boolean z) {
        if (z) {
            this.nig.startLoad(str, 26, false);
        } else {
            this.nig.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void bzE() {
        LayoutInflater.from(this.mContext).inflate(R.layout.setting_text_image_view, (ViewGroup) this, true);
        this.fxX = (LinearLayout) findViewById(R.id.container);
        this.textView = (TextView) findViewById(R.id.text);
        this.nig = (HeadImageView) findViewById(R.id.icon);
        this.fyc = (ImageView) findViewById(R.id.arrow);
    }

    private void h(AttributeSet attributeSet) {
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
        this.fxX.setClickable(false);
        this.fxX.setFocusable(false);
    }
}
