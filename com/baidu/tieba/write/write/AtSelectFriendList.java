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
/* loaded from: classes3.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private final View.OnClickListener aGQ;
    private LinearLayout kGg;
    private int kGh;
    private HeadImageView kGi;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private int mMaxCount;
    private a oaZ;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.kGh = -1;
        this.mMaxCount = 4;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kGg.removeView(view);
                if (!AtSelectFriendList.this.daP()) {
                    AtSelectFriendList.this.daN();
                }
                if (AtSelectFriendList.this.oaZ != null) {
                    AtSelectFriendList.this.oaZ.a(view, view.getTag());
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
        this.kGh = -1;
        this.mMaxCount = 4;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kGg.removeView(view);
                if (!AtSelectFriendList.this.daP()) {
                    AtSelectFriendList.this.daN();
                }
                if (AtSelectFriendList.this.oaZ != null) {
                    AtSelectFriendList.this.oaZ.a(view, view.getTag());
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
        this.oaZ = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kGh = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kGg = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kGg.setLayoutParams(layoutParams);
        this.kGg.setHorizontalScrollBarEnabled(true);
        this.kGg.setOrientation(0);
        daN();
        addView(this.kGg);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daN() {
        if (this.kGi == null) {
            this.kGi = daQ();
            this.kGi.setDrawBorder(false);
        }
        this.kGi.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kGg.addView(this.kGi);
    }

    private void daO() {
        if (daP()) {
            this.kGg.removeView(this.kGi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean daP() {
        int childCount = this.kGg.getChildCount();
        return childCount > 0 && this.kGg.getChildAt(childCount + (-1)) == this.kGi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView daQ = daQ();
            daQ.setIsRound(false);
            daQ.startLoad(metaData.getAvater(), 12, false);
            if (daP()) {
                daQ.setTag(metaData);
                daQ.setOnClickListener(this.aGQ);
                this.kGg.addView(daQ, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kGh), 0);
                this.kGg.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                daO();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kGg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGg.getChildAt(i);
            if (childAt != this.kGi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kGg.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGg.getChildAt(i);
            if (childAt != this.kGi && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kGg.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kGg.removeView(findViewWithTag);
            if (!daP()) {
                daN();
            }
        }
    }

    private HeadImageView daQ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.kGh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return daP() ? this.kGg.getChildCount() - 1 : this.kGg.getChildCount();
    }
}
