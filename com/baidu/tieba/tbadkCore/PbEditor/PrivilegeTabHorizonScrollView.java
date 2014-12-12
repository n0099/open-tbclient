package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class PrivilegeTabHorizonScrollView extends HorizontalScrollView {
    private int XN;
    private int XO;
    private TextView XR;
    private LinearLayout.LayoutParams XS;
    private View XU;
    private al bUU;
    private aw bUV;
    private int mCurrentIndex;
    private List<ao> mDatas;

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCurrentIndex = -1;
        init();
    }

    public PrivilegeTabHorizonScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCurrentIndex = -1;
        init();
    }

    public PrivilegeTabHorizonScrollView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        init();
    }

    private void init() {
        removeAllViews();
        setFillViewport(true);
        setHorizontalScrollBarEnabled(false);
        this.bUU = new al(getContext());
        this.bUU.setOrientation(0);
        this.bUU.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bUU.setBaselineAligned(false);
        addView(this.bUU);
        this.XN = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_tb_padding);
        this.XO = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_lr_padding);
        this.bUU.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_6), 0, 0);
        this.XS = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1);
        this.XU = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.XU.setLayoutParams(layoutParams);
        com.baidu.tbadk.core.util.ax.i(this.XU, com.baidu.tieba.v.bg_expression_bar_n);
        this.bUU.addView(this.XU);
    }

    public void setDatas(List<ao> list) {
        this.mDatas = list;
    }

    private TbImageView b(aq aqVar) {
        if (aqVar == null) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        TbImageView tbImageView = new TbImageView(getContext());
        linearLayout.addView(tbImageView, new LinearLayout.LayoutParams(-1, -1));
        com.baidu.tbadk.core.util.ax.i(linearLayout, com.baidu.tieba.v.bg_expression_bar);
        tbImageView.setPadding(this.XO, this.XN, this.XO, this.XN);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        com.baidu.tbadk.core.util.ax.c(tbImageView, aqVar.bUT);
        linearLayout.setOnClickListener(new ar(this, this.bUU.getChildCount() - 1, null));
        this.bUU.addView(linearLayout, this.bUU.getChildCount() - 1, this.XS);
        return tbImageView;
    }

    public void c(aq aqVar) {
        b(aqVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bUU.getChildAt(this.mCurrentIndex);
                linearLayout.setSelected(false);
                ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).afR().bUT);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bUU.getChildAt(this.mCurrentIndex);
            linearLayout2.setSelected(true);
            com.baidu.tbadk.core.util.ax.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).afR().bUS);
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.bUU.removeAllViews();
    }

    public void cm(int i) {
        if (this.XR != null) {
            com.baidu.tbadk.core.util.ax.i((View) this.XR, com.baidu.tieba.v.icon_news_head_prompt_one);
            this.XR.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bUU.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bUU.getChildAt(i2);
            if (childAt != null) {
                com.baidu.tbadk.core.util.ax.i(childAt, com.baidu.tieba.v.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            com.baidu.tbadk.core.util.ax.c(tbImageView, this.mDatas.get(i2).afR().bUS);
                        } else {
                            com.baidu.tbadk.core.util.ax.c(tbImageView, this.mDatas.get(i2).afR().bUT);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(aw awVar) {
        this.bUV = awVar;
    }
}
