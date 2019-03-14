package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private final int bTo;
    private View cOt;
    private ArrayList<bd> dCk;
    private final int iBT;
    private final int iBU;
    private final int iBV;
    private ArrayList<TbImageView> iBW;
    private float iBX;
    private int iBY;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.iBW = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.iBX = 0.62222224f;
        this.iBY = 0;
        this.dCk = null;
        this.cOt = null;
        this.mContext = context;
        this.iBU = l.aO(context);
        this.iBT = context.getResources().getDimensionPixelSize(d.e.ds20);
        this.bTo = context.getResources().getDimensionPixelSize(d.e.ds14);
        this.iBV = context.getResources().getDimensionPixelSize(d.e.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(d.h.forums_topics_recommend, (ViewGroup) this, true);
        this.iBW.add((TbImageView) viewGroup.findViewById(d.g.forum_topic_pic1));
        this.iBW.add((TbImageView) viewGroup.findViewById(d.g.forum_topic_pic2));
        this.iBW.add((TbImageView) viewGroup.findViewById(d.g.forum_topic_pic3));
        this.iBW.add((TbImageView) viewGroup.findViewById(d.g.forum_topic_pic4));
        this.mImageWidth = ((this.iBU - (this.iBT * 2)) - this.bTo) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.iBX);
        setPadding(this.iBT, 0, this.iBT, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.iBT * 2);
        int i5 = (int) (0.5f + (((i4 - this.bTo) / 2.0f) * this.iBX));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.bTo) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.iBY / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.bTo) + (i7 * i5) + this.iBV);
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
                int measuredWidth = childAt.getMeasuredWidth() + this.bTo + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.bTo + paddingTop;
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

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        Cl(str);
    }

    private void Cl(String str) {
        HeadImageView headImageView;
        if (this.cOt != null && (headImageView = (HeadImageView) this.cOt.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
