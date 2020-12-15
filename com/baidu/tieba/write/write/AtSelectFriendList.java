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
    private LinearLayout kGi;
    private int kGj;
    private HeadImageView kGk;
    private final Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private int mMaxCount;
    private a obb;

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.kGj = -1;
        this.mMaxCount = 4;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kGi.removeView(view);
                if (!AtSelectFriendList.this.daQ()) {
                    AtSelectFriendList.this.daO();
                }
                if (AtSelectFriendList.this.obb != null) {
                    AtSelectFriendList.this.obb.a(view, view.getTag());
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
        this.kGj = -1;
        this.mMaxCount = 4;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.kGi.removeView(view);
                if (!AtSelectFriendList.this.daQ()) {
                    AtSelectFriendList.this.daO();
                }
                if (AtSelectFriendList.this.obb != null) {
                    AtSelectFriendList.this.obb.a(view, view.getTag());
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
        this.obb = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kGj = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kGi = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kGi.setLayoutParams(layoutParams);
        this.kGi.setHorizontalScrollBarEnabled(true);
        this.kGi.setOrientation(0);
        daO();
        addView(this.kGi);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daO() {
        if (this.kGk == null) {
            this.kGk = daR();
            this.kGk.setDrawBorder(false);
        }
        this.kGk.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kGi.addView(this.kGk);
    }

    private void daP() {
        if (daQ()) {
            this.kGi.removeView(this.kGk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean daQ() {
        int childCount = this.kGi.getChildCount();
        return childCount > 0 && this.kGi.getChildAt(childCount + (-1)) == this.kGk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView daR = daR();
            daR.setIsRound(false);
            daR.startLoad(metaData.getAvater(), 12, false);
            if (daQ()) {
                daR.setTag(metaData);
                daR.setOnClickListener(this.aGQ);
                this.kGi.addView(daR, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kGj), 0);
                this.kGi.requestLayout();
            }
            if (getItemLength() >= this.mMaxCount) {
                daP();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(MetaData metaData) {
        Object tag;
        int childCount = this.kGi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGi.getChildAt(i);
            if (childAt != this.kGk && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.kGi.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGi.getChildAt(i);
            if (childAt != this.kGk && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        View findViewWithTag = this.kGi.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.kGi.removeView(findViewWithTag);
            if (!daQ()) {
                daO();
            }
        }
    }

    private HeadImageView daR() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.kGj, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return daQ() ? this.kGi.getChildCount() - 1 : this.kGi.getChildCount();
    }
}
