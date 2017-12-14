package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int aeR;
    private final View.OnClickListener bEV;
    private int dYr;
    private int dYs;
    private HeadImageView dYt;
    private a hkl;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aeR = -1;
        this.mItemHeight = -1;
        this.dYr = -1;
        this.dYs = 4;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aEe()) {
                    AtSelectFriendList.this.aEc();
                }
                if (AtSelectFriendList.this.hkl != null) {
                    AtSelectFriendList.this.hkl.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wB();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeR = -1;
        this.mItemHeight = -1;
        this.dYr = -1;
        this.dYs = 4;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aEe()) {
                    AtSelectFriendList.this.aEc();
                }
                if (AtSelectFriendList.this.hkl != null) {
                    AtSelectFriendList.this.hkl.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.dYs = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.hkl = aVar;
    }

    private void wB() {
        this.aeR = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dYr = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aEc();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEc() {
        if (this.dYt == null) {
            this.dYt = aEg();
            this.dYt.setDrawBorder(false);
        }
        this.dYt.setImageBitmap(aj.cR(d.f.icon_add_pop));
        this.mLayout.addView(this.dYt);
    }

    private void aEd() {
        if (aEe()) {
            this.mLayout.removeView(this.dYt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEe() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dYt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        if (getItemLength() < this.dYs) {
            HeadImageView aEg = aEg();
            aEg.setIsRound(false);
            aEg.startLoad(metaData.getPortrait(), 12, false);
            if (aEe()) {
                aEg.setTag(metaData);
                aEg.setOnClickListener(this.bEV);
                this.mLayout.addView(aEg, getItemLength());
                scrollTo(getItemLength() * (this.aeR + this.dYr), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.dYs) {
                aEd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dYt && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
                MetaData metaData2 = (MetaData) tag;
                if (metaData2.getUserName() != null && metaData2.getUserName().equals(metaData.getUserName())) {
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
        int childCount = this.mLayout.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dYt && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!aEe()) {
                aEc();
            }
        }
    }

    private HeadImageView aEg() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeR, this.mItemHeight);
        layoutParams.setMargins(this.dYr, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aEe() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
