package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.br;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private View eZS;
    private final int eeB;
    private ArrayList<br> ffB;
    private final int lBs;
    private final int lBt;
    private final int lBu;
    private ArrayList<TbImageView> lBv;
    private float lBw;
    private int lBx;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.lBv = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.lBw = 0.62222224f;
        this.lBx = 0;
        this.ffB = null;
        this.eZS = null;
        this.mContext = context;
        this.lBt = l.getEquipmentWidth(context);
        this.lBs = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.eeB = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.lBu = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.lBv.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.lBv.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.lBv.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.lBv.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.lBt - (this.lBs * 2)) - this.eeB) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.lBw);
        setPadding(this.lBs, 0, this.lBs, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.lBs * 2);
        int i5 = (int) (0.5f + (((i4 - this.eeB) / 2.0f) * this.lBw));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.eeB) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.lBx / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.eeB) + (i7 * i5) + this.lBu);
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
                int measuredWidth = childAt.getMeasuredWidth() + this.eeB + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.eeB + paddingTop;
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
        MN(str);
    }

    private void MN(String str) {
        HeadImageView headImageView;
        if (this.eZS != null && (headImageView = (HeadImageView) this.eZS.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
