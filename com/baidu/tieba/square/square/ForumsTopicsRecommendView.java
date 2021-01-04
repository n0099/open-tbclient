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
/* loaded from: classes8.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private final int fnw;
    private View gkJ;
    private ArrayList<bw> grW;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;
    private final int nmW;
    private final int nmX;
    private final int nmY;
    private ArrayList<TbImageView> nmZ;
    private float nna;
    private int nnb;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.nmZ = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.nna = 0.62222224f;
        this.nnb = 0;
        this.grW = null;
        this.gkJ = null;
        this.mContext = context;
        this.nmX = l.getEquipmentWidth(context);
        this.nmW = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.fnw = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.nmY = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.nmZ.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.nmZ.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.nmZ.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.nmZ.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.nmX - (this.nmW * 2)) - this.fnw) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.nna);
        setPadding(this.nmW, 0, this.nmW, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.nmW * 2);
        int i5 = (int) (0.5f + (((i4 - this.fnw) / 2.0f) * this.nna));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.fnw) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.nnb / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.fnw) + (i7 * i5) + this.nmY);
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
                measuredWidth = childAt.getMeasuredWidth() + this.fnw + paddingLeft;
                if (i5 % 2 != 0) {
                    paddingTop = childAt.getMeasuredHeight() + this.fnw + paddingTop;
                }
            }
            i5++;
            paddingLeft = measuredWidth;
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        SY(str);
    }

    private void SY(String str) {
        HeadImageView headImageView;
        if (this.gkJ != null && (headImageView = (HeadImageView) this.gkJ.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
