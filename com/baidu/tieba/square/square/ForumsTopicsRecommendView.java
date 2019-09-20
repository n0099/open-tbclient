package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private View cZX;
    private final int cdn;
    private ArrayList<be> dRB;
    private final int jen;
    private final int jeo;
    private final int jep;
    private ArrayList<TbImageView> jeq;
    private float jer;
    private int jes;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.jeq = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.jer = 0.62222224f;
        this.jes = 0;
        this.dRB = null;
        this.cZX = null;
        this.mContext = context;
        this.jeo = l.af(context);
        this.jen = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.cdn = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.jep = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.jeq.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.jeq.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.jeq.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.jeq.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.jeo - (this.jen * 2)) - this.cdn) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.jer);
        setPadding(this.jen, 0, this.jen, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.jen * 2);
        int i5 = (int) (0.5f + (((i4 - this.cdn) / 2.0f) * this.jer));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.cdn) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.jes / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.cdn) + (i7 * i5) + this.jep);
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
                int measuredWidth = childAt.getMeasuredWidth() + this.cdn + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.cdn + paddingTop;
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
        EW(str);
    }

    private void EW(String str) {
        HeadImageView headImageView;
        if (this.cZX != null && (headImageView = (HeadImageView) this.cZX.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
