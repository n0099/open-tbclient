package com.baidu.tieba.write.write;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class AtSelectFriendList extends HorizontalCustomScrollView {
    private int TL;
    private final View.OnClickListener aDv;
    private LinearLayout bvm;
    private int bvn;
    private int bvo;
    private int bvp;
    private HeadImageView bvq;
    private s cBy;
    private final Context mContext;

    public AtSelectFriendList(Context context) {
        super(context);
        this.TL = -1;
        this.bvn = -1;
        this.bvo = -1;
        this.bvp = 4;
        this.aDv = new r(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TL = -1;
        this.bvn = -1;
        this.bvo = -1;
        this.bvp = 4;
        this.aDv = new r(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bvp = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(s sVar) {
        this.cBy = sVar;
    }

    private void initialize() {
        this.TL = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_width);
        this.bvn = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height);
        this.bvo = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_margin);
        this.bvm = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bvm.setLayoutParams(layoutParams);
        this.bvm.setHorizontalScrollBarEnabled(true);
        this.bvm.setOrientation(0);
        WT();
        addView(this.bvm);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        if (this.bvq == null) {
            this.bvq = WX();
            this.bvq.setDrawBorder(false);
        }
        this.bvq.setImageBitmap(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.icon_add_pop));
        this.bvm.addView(this.bvq);
    }

    private void WU() {
        if (WV()) {
            this.bvm.removeView(this.bvq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WV() {
        int childCount = this.bvm.getChildCount();
        return childCount > 0 && this.bvm.getChildAt(childCount + (-1)) == this.bvq;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bvp) {
            HeadImageView WX = WX();
            WX.setIsRound(false);
            WX.c(metaData.getPortrait(), 12, false);
            if (WV()) {
                WX.setTag(metaData);
                WX.setOnClickListener(this.aDv);
                this.bvm.addView(WX, getItemLength());
                scrollTo(getItemLength() * (this.TL + this.bvo), 0);
                this.bvm.requestLayout();
            }
            if (getItemLength() >= this.bvp) {
                WU();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.bvm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvm.getChildAt(i);
            if (childAt != this.bvq && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bvm.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvm.getChildAt(i);
            if (childAt != this.bvq && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.bvm.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bvm.removeView(findViewWithTag);
            if (!WV()) {
                WT();
            }
        }
    }

    private HeadImageView WX() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.TL, this.bvn);
        layoutParams.setMargins(this.bvo, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return WV() ? this.bvm.getChildCount() - 1 : this.bvm.getChildCount();
    }
}
