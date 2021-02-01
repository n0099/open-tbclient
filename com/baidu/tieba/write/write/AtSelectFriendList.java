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
/* loaded from: classes8.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aEh;
    private int dkj;
    private LinearLayout kOQ;
    private int kOR;
    private HeadImageView kOS;
    private final Context mContext;
    private int mItemWidth;
    private int mMaxCount;
    private a oiN;

    /* loaded from: classes8.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.dkj = -1;
        this.kOR = -1;
        this.mMaxCount = 4;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kOQ.removeView(view);
                if (!AtSelectFriendList.this.cYA()) {
                    AtSelectFriendList.this.cYy();
                }
                if (AtSelectFriendList.this.oiN != null) {
                    AtSelectFriendList.this.oiN.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.dkj = -1;
        this.kOR = -1;
        this.mMaxCount = 4;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kOQ.removeView(view);
                if (!AtSelectFriendList.this.cYA()) {
                    AtSelectFriendList.this.cYy();
                }
                if (AtSelectFriendList.this.oiN != null) {
                    AtSelectFriendList.this.oiN.b(view, view.getTag());
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
        this.oiN = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dkj = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kOR = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kOQ = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kOQ.setLayoutParams(layoutParams);
        this.kOQ.setHorizontalScrollBarEnabled(true);
        this.kOQ.setOrientation(0);
        cYy();
        addView(this.kOQ);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYy() {
        if (this.kOS == null) {
            this.kOS = cYB();
            this.kOS.setDrawBorder(false);
        }
        this.kOS.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kOQ.addView(this.kOS);
    }

    private void cYz() {
        if (cYA()) {
            this.kOQ.removeView(this.kOS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYA() {
        int childCount = this.kOQ.getChildCount();
        return childCount > 0 && this.kOQ.getChildAt(childCount + (-1)) == this.kOS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cYB = cYB();
            cYB.setIsRound(false);
            cYB.startLoad(metaData.getAvater(), 12, false);
            if (cYA()) {
                cYB.setTag(metaData);
                cYB.setOnClickListener(this.aEh);
                this.kOQ.addView(cYB, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kOR), 0);
                this.kOQ.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                cYz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kOQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kOQ.getChildAt(i);
            if (childAt != this.kOS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kOQ.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kOQ.getChildAt(i);
            if (childAt != this.kOS && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kOQ.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kOQ.removeView(findViewWithTag);
            if (!cYA()) {
                cYy();
            }
        }
    }

    private HeadImageView cYB() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dkj);
        layoutParams.setMargins(this.kOR, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cYA() ? this.kOQ.getChildCount() - 1 : this.kOQ.getChildCount();
    }
}
