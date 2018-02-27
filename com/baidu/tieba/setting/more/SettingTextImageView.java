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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class SettingTextImageView extends FrameLayout {
    private ImageView boD;
    private LinearLayout box;
    private TextView boy;
    private HeadImageView gOp;
    private Context mContext;

    public SettingTextImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        Ju();
        d(attributeSet);
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public SettingTextImageView(Context context) {
        super(context);
        this.mContext = context;
        Ju();
        hr(TbadkCoreApplication.getInst().getSkinType());
    }

    public void hr(int i) {
        aj.e(this.boy, d.C0141d.common_color_10039, 1);
        aj.b(this.boD, d.f.icon_arrow_gray_right_n, i);
        this.gOp.invalidate();
    }

    public void brV() {
        if (this.gOp != null) {
            this.gOp.setVisibility(8);
        }
    }

    public void brW() {
        if (this.gOp != null) {
            this.gOp.setVisibility(0);
        }
    }

    public void setText(String str) {
        this.boy.setText(str);
    }

    public void X(String str, boolean z) {
        if (z) {
            this.gOp.startLoad(str, 26, false);
        } else {
            this.gOp.startLoad(str, 12, false);
        }
    }

    public void recycle() {
    }

    private void Ju() {
        LayoutInflater.from(this.mContext).inflate(d.h.setting_text_image_view, (ViewGroup) this, true);
        this.box = (LinearLayout) findViewById(d.g.container);
        this.boy = (TextView) findViewById(d.g.text);
        this.gOp = (HeadImageView) findViewById(d.g.icon);
        this.boD = (ImageView) findViewById(d.g.arrow);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, d.l.TbSettingView);
        String string = obtainStyledAttributes.getString(d.l.TbSettingView_settingText);
        int color = obtainStyledAttributes.getColor(d.l.TbSettingView_settingTextColor, -1);
        obtainStyledAttributes.recycle();
        if (string != null) {
            this.boy.setText(string);
        }
        if (color > -1) {
            this.boy.setTextColor(color);
        }
        this.box.setClickable(false);
        this.box.setFocusable(false);
    }
}
