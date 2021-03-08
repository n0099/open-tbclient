package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aFH;
    private int dlK;
    private LinearLayout kRg;
    private int kRh;
    private HeadImageView kRi;
    private final Context mContext;
    private int mItemWidth;
    private int mMaxCount;
    private a ols;

    /* loaded from: classes7.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.dlK = -1;
        this.kRh = -1;
        this.mMaxCount = 4;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kRg.removeView(view);
                if (!AtSelectFriendList.this.cYO()) {
                    AtSelectFriendList.this.cYM();
                }
                if (AtSelectFriendList.this.ols != null) {
                    AtSelectFriendList.this.ols.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.dlK = -1;
        this.kRh = -1;
        this.mMaxCount = 4;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kRg.removeView(view);
                if (!AtSelectFriendList.this.cYO()) {
                    AtSelectFriendList.this.cYM();
                }
                if (AtSelectFriendList.this.ols != null) {
                    AtSelectFriendList.this.ols.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.mMaxCount = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.ols = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dlK = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kRh = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kRg = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kRg.setLayoutParams(layoutParams);
        this.kRg.setHorizontalScrollBarEnabled(true);
        this.kRg.setOrientation(0);
        cYM();
        addView(this.kRg);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYM() {
        if (this.kRi == null) {
            this.kRi = cYP();
            this.kRi.setDrawBorder(false);
        }
        this.kRi.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kRg.addView(this.kRi);
    }

    private void cYN() {
        if (cYO()) {
            this.kRg.removeView(this.kRi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYO() {
        int childCount = this.kRg.getChildCount();
        return childCount > 0 && this.kRg.getChildAt(childCount + (-1)) == this.kRi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cYP = cYP();
            cYP.setIsRound(false);
            cYP.startLoad(metaData.getAvater(), 12, false);
            if (cYO()) {
                cYP.setTag(metaData);
                cYP.setOnClickListener(this.aFH);
                this.kRg.addView(cYP, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kRh), 0);
                this.kRg.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                cYN();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kRg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kRg.getChildAt(i);
            if (childAt != this.kRi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kRg.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kRg.getChildAt(i);
            if (childAt != this.kRi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kRg.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kRg.removeView(findViewWithTag);
            if (!cYO()) {
                cYM();
            }
        }
    }

    private HeadImageView cYP() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dlK);
        layoutParams.setMargins(this.kRh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cYO() ? this.kRg.getChildCount() - 1 : this.kRg.getChildCount();
    }
}
