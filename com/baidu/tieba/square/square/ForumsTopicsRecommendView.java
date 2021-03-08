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
/* loaded from: classes7.dex */
public class ForumsTopicsRecommendView extends ViewGroup implements com.baidu.tbadk.imageManager.b {
    private final int fmE;
    private View gki;
    private ArrayList<by> grV;
    private Context mContext;
    private int mImageHeight;
    private int mImageWidth;
    private final int nuE;
    private final int nuF;
    private final int nuG;
    private ArrayList<TbImageView> nuH;
    private float nuI;
    private int nuJ;

    public ForumsTopicsRecommendView(Context context) {
        this(context, null);
    }

    public ForumsTopicsRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.nuH = new ArrayList<>(4);
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.nuI = 0.62222224f;
        this.nuJ = 0;
        this.grV = null;
        this.gki = null;
        this.mContext = context;
        this.nuF = l.getEquipmentWidth(context);
        this.nuE = context.getResources().getDimensionPixelSize(R.dimen.ds20);
        this.fmE = context.getResources().getDimensionPixelSize(R.dimen.ds14);
        this.nuG = context.getResources().getDimensionPixelSize(R.dimen.ds22);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.forums_topics_recommend, (ViewGroup) this, true);
        this.nuH.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic1));
        this.nuH.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic2));
        this.nuH.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic3));
        this.nuH.add((TbImageView) viewGroup.findViewById(R.id.forum_topic_pic4));
        this.mImageWidth = ((this.nuF - (this.nuE * 2)) - this.fmE) / 2;
        this.mImageHeight = (int) (this.mImageWidth * this.nuI);
        setPadding(this.nuE, 0, this.nuE, 0);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = i3 - (this.nuE * 2);
        int i5 = (int) (0.5f + (((i4 - this.fmE) / 2.0f) * this.nuI));
        for (int i6 = 0; i6 < childCount; i6++) {
            getChildAt(i6).measure(((i4 - this.fmE) / 2) + 1073741824, i5 + 1073741824);
        }
        int i7 = this.nuJ / 2;
        setMeasuredDimension(i3, ((i7 - 1) * this.fmE) + (i7 * i5) + this.nuG);
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
                measuredWidth = childAt.getMeasuredWidth() + this.fmE + paddingLeft;
                if (i5 % 2 != 0) {
                    paddingTop = childAt.getMeasuredHeight() + this.fmE + paddingTop;
                }
            }
            i5++;
            paddingLeft = measuredWidth;
        }
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
        Tf(str);
    }

    private void Tf(String str) {
        HeadImageView headImageView;
        if (this.gki != null && (headImageView = (HeadImageView) this.gki.findViewWithTag(str)) != null) {
            headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            headImageView.invalidate();
        }
    }
}
