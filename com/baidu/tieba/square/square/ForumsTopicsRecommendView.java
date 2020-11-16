package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private final int eWq;
    private View fTg;
    private ArrayList<bu> fZl;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;
    private final int mTp;
    private final int mTq;
    private final int mTr;
    private ArrayList<TbImageView> mTs;
    private float mTt;
    private int mTu;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mTs = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mTt = 0.62222224f;
        this.mTu = 0;
        this.fZl = null;
        this.fTg = null;
        this.mContext = context;
        this.mTq = l.getEquipmentWidth(context);
        this.mTp = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.eWq = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.mTr = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.mTs.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.mTs.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.mTs.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.mTs.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.mTq - (this.mTp * 2)) - this.eWq) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.mTt);
        setPadding(this.mTp, 0, this.mTp, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.mTp * 2);
        int i5 = (int) (0.5f + (((i4 - this.eWq) / 2.0f) * this.mTt));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.eWq) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.mTu / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.eWq) + (i7 * i5) + this.mTr);
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
                int measuredWidth = childAt.getMeasuredWidth() + this.eWq + i8;
                if (i7 % 2 != 0) {
                    i5 = childAt.getMeasuredHeight() + this.eWq + paddingTop;
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
        Sb(str);
    }

    private void Sb(String str) {
        HeadImageView headImageView;
        if (this.fTg != null && (headImageView = (HeadImageView) this.fTg.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
