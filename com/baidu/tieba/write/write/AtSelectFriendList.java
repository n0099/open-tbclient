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
    private int aet;
    private final View.OnClickListener bwN;
    private int dHS;
    private int dHT;
    private HeadImageView dHU;
    private a gLw;
    private final Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public AtSelectFriendList(Context context) {
        super(context);
        this.aet = -1;
        this.mItemHeight = -1;
        this.dHS = -1;
        this.dHT = 4;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aAb()) {
                    AtSelectFriendList.this.azZ();
                }
                if (AtSelectFriendList.this.gLw != null) {
                    AtSelectFriendList.this.gLw.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aet = -1;
        this.mItemHeight = -1;
        this.dHS = -1;
        this.dHT = 4;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.write.write.AtSelectFriendList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AtSelectFriendList.this.mLayout.removeView(view);
                if (!AtSelectFriendList.this.aAb()) {
                    AtSelectFriendList.this.azZ();
                }
                if (AtSelectFriendList.this.gLw != null) {
                    AtSelectFriendList.this.gLw.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.dHT = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(a aVar) {
        this.gLw = aVar;
    }

    private void wA() {
        this.aet = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dHS = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        azZ();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
        setFocusable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azZ() {
        if (this.dHU == null) {
            this.dHU = aAd();
            this.dHU.setDrawBorder(false);
        }
        this.dHU.setImageBitmap(aj.cR(d.g.icon_add_pop));
        this.mLayout.addView(this.dHU);
    }

    private void aAa() {
        if (aAb()) {
            this.mLayout.removeView(this.dHU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAb() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dHU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(MetaData metaData) {
        if (getItemLength() < this.dHT) {
            HeadImageView aAd = aAd();
            aAd.setIsRound(false);
            aAd.c(metaData.getPortrait(), 12, false);
            if (aAb()) {
                aAd.setTag(metaData);
                aAd.setOnClickListener(this.bwN);
                this.mLayout.addView(aAd, getItemLength());
                scrollTo(getItemLength() * (this.aet + this.dHS), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.dHT) {
                aAa();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dHU && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.dHU && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!aAb()) {
                azZ();
            }
        }
    }

    private HeadImageView aAd() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aet, this.mItemHeight);
        layoutParams.setMargins(this.dHS, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return aAb() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
