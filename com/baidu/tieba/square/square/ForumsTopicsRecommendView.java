package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private final int fle;
    private View giF;
    private ArrayList<by> gqm;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;
    private final int nsA;
    private final int nsB;
    private ArrayList<TbImageView> nsC;
    private float nsD;
    private int nsE;
    private final int nsz;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.nsC = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.nsD = 0.62222224f;
        this.nsE = 0;
        this.gqm = null;
        this.giF = null;
        this.mContext = context;
        this.nsA = l.getEquipmentWidth(context);
        this.nsz = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.fle = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.nsB = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.nsC.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.nsC.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.nsC.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.nsC.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.nsA - (this.nsz * 2)) - this.fle) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.nsD);
        setPadding(this.nsz, 0, this.nsz, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.nsz * 2);
        int i5 = (int) (0.5f + (((i4 - this.fle) / 2.0f) * this.nsD));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.fle) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.nsE / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.fle) + (i7 * i5) + this.nsB);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt == null) {
                measuredWidth = paddingLeft;
            } else {
                if (i5 % 2 == 0) {
                    paddingLeft = getPaddingLeft();
                }
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                measuredWidth = childAt.getMeasuredWidth() + this.fle + paddingLeft;
                if (i5 % 2 != 0) {
                    paddingTop = childAt.getMeasuredHeight() + this.fle + paddingTop;
                }
            }
            i5++;
            paddingLeft = measuredWidth;
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        SZ(str);
    }

    private void SZ(String str) {
        HeadImageView headImageView;
        if (this.giF != null && (headImageView = (HeadImageView) this.giF.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
