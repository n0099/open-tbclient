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
    private int CH;
    private final View.OnClickListener aGJ;
    private int aVO;
    private int aVP;
    private int aVQ;
    private HeadImageView aVR;
    private n bSY;
    private final Context mContext;
    private LinearLayout mLayout;

    public AtSelectFriendList(Context context) {
        super(context);
        this.CH = -1;
        this.aVO = -1;
        this.aVP = -1;
        this.aVQ = 4;
        this.aGJ = new m(this);
        this.mContext = context;
        ny();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CH = -1;
        this.aVO = -1;
        this.aVP = -1;
        this.aVQ = 4;
        this.aGJ = new m(this);
        this.mContext = context;
        ny();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aVQ = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(n nVar) {
        this.bSY = nVar;
    }

    private void ny() {
        this.CH = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.aVO = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.aVP = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        Na();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Na() {
        if (this.aVR == null) {
            this.aVR = Ne();
            this.aVR.setDrawBorder(false);
        }
        this.aVR.setImageBitmap(com.baidu.tbadk.core.util.aw.bA(com.baidu.tieba.u.icon_add_pop));
        this.mLayout.addView(this.aVR);
    }

    private void Nb() {
        if (Nc()) {
            this.mLayout.removeView(this.aVR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Nc() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.aVR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.aVQ) {
            HeadImageView Ne = Ne();
            Ne.setIsRound(false);
            Ne.c(metaData.getPortrait(), 12, false);
            if (Nc()) {
                Ne.setTag(metaData);
                Ne.setOnClickListener(this.aGJ);
                this.mLayout.addView(Ne, getItemLength());
                scrollTo(getItemLength() * (this.CH + this.aVP), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aVQ) {
                Nb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.aVR && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.aVR && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!Nc()) {
                Na();
            }
        }
    }

    private HeadImageView Ne() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.CH, this.aVO);
        layoutParams.setMargins(this.aVP, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return Nc() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
