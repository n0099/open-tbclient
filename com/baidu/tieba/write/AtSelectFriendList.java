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
    private int CG;
    private final View.OnClickListener aGz;
    private int aVA;
    private int aVB;
    private int aVC;
    private HeadImageView aVD;
    private n bSJ;
    private final Context mContext;
    private LinearLayout mLayout;

    public AtSelectFriendList(Context context) {
        super(context);
        this.CG = -1;
        this.aVA = -1;
        this.aVB = -1;
        this.aVC = 4;
        this.aGz = new m(this);
        this.mContext = context;
        ny();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.CG = -1;
        this.aVA = -1;
        this.aVB = -1;
        this.aVC = 4;
        this.aGz = new m(this);
        this.mContext = context;
        ny();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.aVC = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(n nVar) {
        this.bSJ = nVar;
    }

    private void ny() {
        this.CG = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.aVA = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.aVB = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        MW();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MW() {
        if (this.aVD == null) {
            this.aVD = Na();
            this.aVD.setDrawBorder(false);
        }
        this.aVD.setImageBitmap(com.baidu.tbadk.core.util.aw.bA(com.baidu.tieba.u.icon_add_pop));
        this.mLayout.addView(this.aVD);
    }

    private void MX() {
        if (MY()) {
            this.mLayout.removeView(this.aVD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MY() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.aVD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.aVC) {
            HeadImageView Na = Na();
            Na.setIsRound(false);
            Na.c(metaData.getPortrait(), 12, false);
            if (MY()) {
                Na.setTag(metaData);
                Na.setOnClickListener(this.aGz);
                this.mLayout.addView(Na, getItemLength());
                scrollTo(getItemLength() * (this.CG + this.aVB), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.aVC) {
                MX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.aVD && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.aVD && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!MY()) {
                MW();
            }
        }
    }

    private HeadImageView Na() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.CG, this.aVA);
        layoutParams.setMargins(this.aVB, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return MY() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
