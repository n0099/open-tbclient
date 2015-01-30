package com.baidu.tieba.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalScrollView {
    private int Hb;
    private final View.OnClickListener bam;
    private int bbB;
    private int bbC;
    private int bbD;
    private HeadImageView bbE;
    private n cfD;
    private final Context mContext;
    private LinearLayout mLayout;

    public AtSelectFriendList(Context context) {
        super(context);
        this.Hb = -1;
        this.bbB = -1;
        this.bbC = -1;
        this.bbD = 4;
        this.bam = new m(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Hb = -1;
        this.bbB = -1;
        this.bbC = -1;
        this.bbD = 4;
        this.bam = new m(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bbD = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(n nVar) {
        this.cfD = nVar;
    }

    private void initialize() {
        this.Hb = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_width);
        this.bbB = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height);
        this.bbC = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        OH();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        if (this.bbE == null) {
            this.bbE = OL();
            this.bbE.setDrawBorder(false);
        }
        this.bbE.setImageBitmap(com.baidu.tbadk.core.util.bc.ce(com.baidu.tieba.v.icon_add_pop));
        this.mLayout.addView(this.bbE);
    }

    private void OI() {
        if (OJ()) {
            this.mLayout.removeView(this.bbE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OJ() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.bbE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bbD) {
            HeadImageView OL = OL();
            OL.setIsRound(false);
            OL.d(metaData.getPortrait(), 12, false);
            if (OJ()) {
                OL.setTag(metaData);
                OL.setOnClickListener(this.bam);
                this.mLayout.addView(OL, getItemLength());
                scrollTo(getItemLength() * (this.Hb + this.bbC), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.bbD) {
                OI();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bbE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.bbE && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.mLayout.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!OJ()) {
                OH();
            }
        }
    }

    private HeadImageView OL() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Hb, this.bbB);
        layoutParams.setMargins(this.bbC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return OJ() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
