package com.baidu.tieba.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w extends ViewGroup implements com.baidu.tbadk.imageManager.d, com.baidu.tieba.view.s {
    private View agS;
    private ArrayList<ak> bMK;
    private final int bMR;
    private final int bMS;
    private final int bMT;
    private final int bMU;
    private ArrayList<TbImageView> bMV;
    private int bMW;
    private Context mContext;
    private float mHWProportion;
    private int mImageHeight;
    private int mImageWidth;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.bMV = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mHWProportion = 0.62222224f;
        this.bMW = 0;
        this.bMK = null;
        this.agS = null;
        this.mContext = context;
        this.bMT = com.baidu.adp.lib.util.m.n(context);
        this.bMR = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_page_padding);
        this.bMS = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_forum_topic_margin);
        this.bMU = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_forum_topic_paddingBottom);
        ViewGroup viewGroup = (ViewGroup) com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.forums_topics_recommend, this, true);
        this.bMV.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic1));
        this.bMV.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic2));
        this.bMV.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic3));
        this.bMV.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic4));
        this.mImageWidth = ((this.bMT - (this.bMR * 2)) - this.bMS) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.mHWProportion);
        setPadding(this.bMR, 0, this.bMR, 0);
    }

    public boolean L(ArrayList<ak> arrayList) {
        this.bMK = K(arrayList);
        Iterator<TbImageView> it = this.bMV.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        if (this.bMK != null) {
            setVisibility(0);
            M(this.bMK);
            return true;
        }
        setVisibility(8);
        return false;
    }

    private ArrayList<ak> K(ArrayList<ak> arrayList) {
        if (arrayList != null) {
            int size = (arrayList.size() / 2) * 2;
            int i = size <= 4 ? size : 4;
            if (i > 0) {
                return new ArrayList<>(arrayList.subList(0, i));
            }
            return null;
        }
        return null;
    }

    private void M(ArrayList<ak> arrayList) {
        int size = arrayList.size();
        this.bMW = size;
        requestLayout();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = this.bMV.get(i);
            ak akVar = arrayList.get(i);
            tbImageView.setVisibility(0);
            tbImageView.setTag(akVar.kJ());
            tbImageView.setOnClickListener(new x(this, akVar, i));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.bMR * 2);
        int i5 = (int) (0.5f + (((i4 - this.bMS) / 2) * this.mHWProportion));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.bMS) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.bMW / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.bMS) + (i7 * i5) + this.bMU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = paddingLeft;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt == null) {
                int i9 = paddingTop;
                i6 = i8;
                i5 = i9;
            } else {
                if (i7 % 2 == 0) {
                    i8 = getPaddingLeft();
                }
                childAt.layout(i8, paddingTop, childAt.getMeasuredWidth() + i8, childAt.getMeasuredHeight() + paddingTop);
                int measuredWidth = childAt.getMeasuredWidth() + this.bMS + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.bMS + paddingTop;
                    i6 = measuredWidth;
                } else {
                    i5 = paddingTop;
                    i6 = measuredWidth;
                }
            }
            i7++;
            int i10 = i5;
            i8 = i6;
            paddingTop = i10;
        }
    }

    @Override // com.baidu.tieba.view.s
    public void adq() {
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        int i3 = 0;
        this.agS = view;
        try {
            if (this.bMK == null || this.bMK.size() <= 0) {
                return;
            }
            while (true) {
                int i4 = i3;
                if (i4 < this.bMK.size()) {
                    String kJ = this.bMK.get(i4).kJ();
                    if (kJ != null && kJ.length() > 0 && view != null) {
                        HeadImageView headImageView = (HeadImageView) this.agS.findViewWithTag(kJ);
                        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER);
                        headImageView.a(kJ, 10, this.mImageWidth, this.mImageHeight, false);
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ht(str);
    }

    private void ht(String str) {
        HeadImageView headImageView;
        if (this.agS != null && (headImageView = (HeadImageView) this.agS.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
