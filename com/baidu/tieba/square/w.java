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
    private View agJ;
    private final int bMC;
    private final int bMD;
    private final int bME;
    private final int bMF;
    private ArrayList<TbImageView> bMG;
    private int bMH;
    private ArrayList<ak> bMv;
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
        this.bMG = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mHWProportion = 0.62222224f;
        this.bMH = 0;
        this.bMv = null;
        this.agJ = null;
        this.mContext = context;
        this.bME = com.baidu.adp.lib.util.m.n(context);
        this.bMC = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_page_padding);
        this.bMD = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_forum_topic_margin);
        this.bMF = context.getResources().getDimensionPixelSize(com.baidu.tieba.t.square_forum_topic_paddingBottom);
        ViewGroup viewGroup = (ViewGroup) com.baidu.adp.lib.g.b.ek().a(context, com.baidu.tieba.w.forums_topics_recommend, this, true);
        this.bMG.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic1));
        this.bMG.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic2));
        this.bMG.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic3));
        this.bMG.add((TbImageView) viewGroup.findViewById(com.baidu.tieba.v.forum_topic_pic4));
        this.mImageWidth = ((this.bME - (this.bMC * 2)) - this.bMD) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.mHWProportion);
        setPadding(this.bMC, 0, this.bMC, 0);
    }

    public boolean K(ArrayList<ak> arrayList) {
        this.bMv = J(arrayList);
        Iterator<TbImageView> it = this.bMG.iterator();
        while (it.hasNext()) {
            it.next().setVisibility(8);
        }
        if (this.bMv != null) {
            setVisibility(0);
            L(this.bMv);
            return true;
        }
        setVisibility(8);
        return false;
    }

    private ArrayList<ak> J(ArrayList<ak> arrayList) {
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

    private void L(ArrayList<ak> arrayList) {
        int size = arrayList.size();
        this.bMH = size;
        requestLayout();
        for (int i = 0; i < size; i++) {
            TbImageView tbImageView = this.bMG.get(i);
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
        int i4 = i3 - (this.bMC * 2);
        int i5 = (int) (0.5f + (((i4 - this.bMD) / 2) * this.mHWProportion));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.bMD) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.bMH / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.bMD) + (i7 * i5) + this.bMF);
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
                int measuredWidth = childAt.getMeasuredWidth() + this.bMD + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.bMD + paddingTop;
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
    public void adn() {
    }

    @Override // com.baidu.tieba.view.s
    public void g(View view, int i, int i2) {
        int i3 = 0;
        this.agJ = view;
        try {
            if (this.bMv == null || this.bMv.size() <= 0) {
                return;
            }
            while (true) {
                int i4 = i3;
                if (i4 < this.bMv.size()) {
                    String kJ = this.bMv.get(i4).kJ();
                    if (kJ != null && kJ.length() > 0 && view != null) {
                        HeadImageView headImageView = (HeadImageView) this.agJ.findViewWithTag(kJ);
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
        if (this.agJ != null && (headImageView = (HeadImageView) this.agJ.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
