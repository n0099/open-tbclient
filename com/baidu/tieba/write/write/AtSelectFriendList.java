package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aUZ;
    private LinearLayout iNC;
    private int iND;
    private int iNE;
    private HeadImageView iNF;
    private a lXY;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.iND = -1;
        this.iNE = 4;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.iNC.removeView(view);
                if (!AtSelectFriendList.this.cqr()) {
                    AtSelectFriendList.this.cqp();
                }
                if (AtSelectFriendList.this.lXY != null) {
                    AtSelectFriendList.this.lXY.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.iND = -1;
        this.iNE = 4;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.iNC.removeView(view);
                if (!AtSelectFriendList.this.cqr()) {
                    AtSelectFriendList.this.cqp();
                }
                if (AtSelectFriendList.this.lXY != null) {
                    AtSelectFriendList.this.lXY.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.iNE = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.lXY = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.iND = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.iNC = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.iNC.setLayoutParams(layoutParams);
        this.iNC.setHorizontalScrollBarEnabled(true);
        this.iNC.setOrientation(0);
        cqp();
        addView(this.iNC);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqp() {
        if (this.iNF == null) {
            this.iNF = cqs();
            this.iNF.setDrawBorder(false);
        }
        this.iNF.setImageBitmap(am.getBitmap(R.drawable.icon_add_pop));
        this.iNC.addView(this.iNF);
    }

    private void cqq() {
        if (cqr()) {
            this.iNC.removeView(this.iNF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqr() {
        int childCount = this.iNC.getChildCount();
        return childCount > 0 && this.iNC.getChildAt(childCount + (-1)) == this.iNF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.iNE) {
            HeadImageView cqs = cqs();
            cqs.setIsRound(false);
            cqs.startLoad(metaData.getPortrait(), 12, false);
            if (cqr()) {
                cqs.setTag(metaData);
                cqs.setOnClickListener(this.aUZ);
                this.iNC.addView(cqs, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.iND), 0);
                this.iNC.requestLayout();
            }
            if (getItemLength() >= this.iNE) {
                cqq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.iNC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iNC.getChildAt(i);
            if (childAt != this.iNF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if ((metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) || (metaData2.getName_show() != null && metaData2.getName_show().equals(metaData.getName_show()))) {
                    metaData.setChecked(true);
                    childAt.setTag(metaData);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getDataList() {
        Object tag;
        String name_show;
        int childCount = this.iNC.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iNC.getChildAt(i);
            if (childAt != this.iNF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.iNC.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.iNC.removeView(findViewWithTag);
            if (!cqr()) {
                cqp();
            }
        }
    }

    private HeadImageView cqs() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.iND, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return cqr() ? this.iNC.getChildCount() - 1 : this.iNC.getChildCount();
    }
}
