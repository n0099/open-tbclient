package com.baidu.tieba.imageProblem.logic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.g.b;
import com.baidu.tieba.n;
import com.baidu.tieba.o;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class ImageProblemItemView extends FrameLayout {
    protected LinearLayout agF;
    protected TextView agG;
    protected TextView agH;
    protected ImageView agK;
    protected LinearLayout byD;
    protected TextView byE;
    protected Context mContext;

    public ImageProblemItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        yc();
        c(attributeSet);
    }

    public ImageProblemItemView(Context context) {
        super(context);
        this.mContext = context;
        yc();
    }

    public void displayTip() {
        if (this.agH != null) {
            this.agH.setVisibility(0);
        }
    }

    public void hideTip() {
        if (this.agH != null) {
            this.agH.setVisibility(8);
        }
    }

    public void setTipColor(int i) {
        if (this.agH != null) {
            this.agH.setTextColor(i);
        }
    }

    public void hideArrow() {
        this.agK.setVisibility(8);
    }

    public void displayArrow() {
        this.agK.setVisibility(0);
    }

    public void setArrowImg(int i) {
        this.agK.setImageResource(i);
    }

    public void setHelpText(String str) {
        if (TextUtils.isEmpty(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.byD.getLayoutParams();
            layoutParams.bottomMargin = (int) getResources().getDimension(o.ds26);
            this.byD.setLayoutParams(layoutParams);
            this.byE.setText("");
            this.byE.setVisibility(8);
            return;
        }
        this.byD.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.byD.getLayoutParams();
        layoutParams2.bottomMargin = (int) getResources().getDimension(o.ds10);
        this.byD.setLayoutParams(layoutParams2);
        this.byE.setText(str);
        this.byE.setVisibility(0);
    }

    public void setStatus(int i) {
        if (i == 1) {
            this.agG.setTextColor(getResources().getColor(n.cp_cont_b));
        } else if (i == 2) {
            this.agG.setTextColor(getResources().getColor(n.cp_link_tip_d));
        } else if (i == 3) {
            this.agG.setTextColor(getResources().getColor(n.cp_cont_e));
        }
    }

    public void setText(String str) {
        this.agG.setText(str);
    }

    public void setText(int i) {
        this.agG.setText(i);
    }

    public void setTip(String str) {
        this.agH.setText(str);
    }

    public CharSequence getTip() {
        return this.agH.getText();
    }

    public void setTipBackground(Drawable drawable) {
        this.agH.setBackgroundDrawable(drawable);
    }

    protected void yc() {
        b.hr().a(this.mContext, r.image_problem_item_view, this, true);
        this.agF = (LinearLayout) findViewById(q.container);
        this.agG = (TextView) findViewById(q.text);
        this.agH = (TextView) findViewById(q.tip);
        this.agK = (ImageView) findViewById(q.arrow2);
        this.byD = (LinearLayout) findViewById(q.ll_container);
        this.byE = (TextView) findViewById(q.tv_help);
    }

    protected void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, v.TbSettingView);
        String string = obtainStyledAttributes.getString(0);
        int color = obtainStyledAttributes.getColor(1, -1);
        String string2 = obtainStyledAttributes.getString(3);
        int color2 = obtainStyledAttributes.getColor(4, -1);
        if (string != null) {
            this.agG.setText(string);
        }
        if (color > -1) {
            this.agG.setTextColor(color);
        }
        if (string2 != null) {
            this.agH.setText(string2);
        }
        if (color2 > -1) {
            this.agH.setTextColor(color2);
        }
        obtainStyledAttributes.recycle();
        this.agF.setClickable(false);
        this.agF.setFocusable(false);
        this.agK.setVisibility(4);
    }
}
