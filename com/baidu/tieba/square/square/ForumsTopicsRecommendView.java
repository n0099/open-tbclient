package com.baidu.tieba.square.square;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private final int fiN;
    private View ggb;
    private ArrayList<bw> gnp;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;
    private final int nir;
    private final int nis;
    private final int nit;
    private ArrayList<TbImageView> niu;
    private float niv;
    private int niw;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.niu = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.niv = 0.62222224f;
        this.niw = 0;
        this.gnp = null;
        this.ggb = null;
        this.mContext = context;
        this.nis = l.getEquipmentWidth(context);
        this.nir = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.fiN = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.nit = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.niu.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.niu.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.niu.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.niu.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.nis - (this.nir * 2)) - this.fiN) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.niv);
        setPadding(this.nir, 0, this.nir, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.nir * 2);
        int i5 = (int) (0.5f + (((i4 - this.fiN) / 2.0f) * this.niv));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.fiN) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.niw / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.fiN) + (i7 * i5) + this.nit);
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
                measuredWidth = childAt.getMeasuredWidth() + this.fiN + paddingLeft;
                if (i5 % 2 != 0) {
                    paddingTop = childAt.getMeasuredHeight() + this.fiN + paddingTop;
                }
            }
            i5++;
            paddingLeft = measuredWidth;
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        RP(str);
    }

    private void RP(String str) {
        HeadImageView headImageView;
        if (this.ggb != null && (headImageView = (HeadImageView) this.ggb.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
