package com.baidu.tieba.tbadkCore.PbEditor;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import java.util.List;
/* loaded from: classes.dex */
public class PrivilegeTabHorizonScrollView extends HorizontalScrollView {
    private View YA;
    private int Yt;
    private int Yu;
    private TextView Yx;
    private LinearLayout.LayoutParams Yy;
    private al bWN;
    private aw bWO;
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
        this.bWN = new al(getContext());
        this.bWN.setOrientation(0);
        this.bWN.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.bWN.setBaselineAligned(false);
        addView(this.bWN);
        this.Yt = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_tb_padding);
        this.Yu = getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_lr_padding);
        this.bWN.setPadding(0, getResources().getDimensionPixelSize(com.baidu.tieba.u.default_gap_6), 0, 0);
        this.Yy = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(com.baidu.tieba.u.face_tab_widget_width), -1);
        this.YA = new View(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        this.YA.setLayoutParams(layoutParams);
        bc.i(this.YA, com.baidu.tieba.v.bg_expression_bar_n);
        this.bWN.addView(this.YA);
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
        bc.i(linearLayout, com.baidu.tieba.v.bg_expression_bar);
        tbImageView.setPadding(this.Yu, this.Yt, this.Yu, this.Yt);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        bc.c(tbImageView, aqVar.bWM);
        linearLayout.setOnClickListener(new ar(this, this.bWN.getChildCount() - 1, null));
        this.bWN.addView(linearLayout, this.bWN.getChildCount() - 1, this.Yy);
        return tbImageView;
    }

    public void c(aq aqVar) {
        b(aqVar);
        invalidate();
    }

    public void setCurrentTab(int i) {
        if (i != this.mCurrentIndex) {
            if (this.mCurrentIndex != -1) {
                LinearLayout linearLayout = (LinearLayout) this.bWN.getChildAt(this.mCurrentIndex);
                linearLayout.setSelected(false);
                ((TbImageView) linearLayout.getChildAt(0)).setImageResource(this.mDatas.get(this.mCurrentIndex).agv().bWM);
            }
            this.mCurrentIndex = i;
            LinearLayout linearLayout2 = (LinearLayout) this.bWN.getChildAt(this.mCurrentIndex);
            linearLayout2.setSelected(true);
            bc.c((TbImageView) linearLayout2.getChildAt(0), this.mDatas.get(this.mCurrentIndex).agv().bWL);
        }
    }

    public void reset() {
        this.mCurrentIndex = -1;
        this.bWN.removeAllViews();
    }

    public void ct(int i) {
        if (this.Yx != null) {
            bc.i((View) this.Yx, com.baidu.tieba.v.icon_news_head_prompt_one);
            this.Yx.setTextColor(i == 1 ? Color.parseColor("#ffd2d2d2") : -1);
        }
        int childCount = this.bWN.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = this.bWN.getChildAt(i2);
            if (childAt != null) {
                bc.i(childAt, com.baidu.tieba.v.bg_expression_bar);
                if (i2 != childCount - 1) {
                    TbImageView tbImageView = (TbImageView) ((LinearLayout) childAt).getChildAt(0);
                    if (tbImageView != null) {
                        if (i2 == this.mCurrentIndex) {
                            bc.c(tbImageView, this.mDatas.get(i2).agv().bWL);
                        } else {
                            bc.c(tbImageView, this.mDatas.get(i2).agv().bWM);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void setOnTabSelectedListener(aw awVar) {
        this.bWO = awVar;
    }
}
