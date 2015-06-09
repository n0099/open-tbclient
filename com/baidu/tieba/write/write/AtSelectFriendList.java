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
    private final View.OnClickListener aDw;
    private LinearLayout bvn;
    private int bvo;
    private int bvp;
    private int bvq;
    private HeadImageView bvr;
    private s cBz;
    private final Context mContext;

    public AtSelectFriendList(Context context) {
        super(context);
        this.TL = -1;
        this.bvo = -1;
        this.bvp = -1;
        this.bvq = 4;
        this.aDw = new r(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TL = -1;
        this.bvo = -1;
        this.bvp = -1;
        this.bvq = 4;
        this.aDw = new r(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bvq = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(s sVar) {
        this.cBz = sVar;
    }

    private void initialize() {
        this.TL = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_width);
        this.bvo = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height);
        this.bvp = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_margin);
        this.bvn = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bvn.setLayoutParams(layoutParams);
        this.bvn.setHorizontalScrollBarEnabled(true);
        this.bvn.setOrientation(0);
        WU();
        addView(this.bvn);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WU() {
        if (this.bvr == null) {
            this.bvr = WY();
            this.bvr.setDrawBorder(false);
        }
        this.bvr.setImageBitmap(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.icon_add_pop));
        this.bvn.addView(this.bvr);
    }

    private void WV() {
        if (WW()) {
            this.bvn.removeView(this.bvr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WW() {
        int childCount = this.bvn.getChildCount();
        return childCount > 0 && this.bvn.getChildAt(childCount + (-1)) == this.bvr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bvq) {
            HeadImageView WY = WY();
            WY.setIsRound(false);
            WY.c(metaData.getPortrait(), 12, false);
            if (WW()) {
                WY.setTag(metaData);
                WY.setOnClickListener(this.aDw);
                this.bvn.addView(WY, getItemLength());
                scrollTo(getItemLength() * (this.TL + this.bvp), 0);
                this.bvn.requestLayout();
            }
            if (getItemLength() >= this.bvq) {
                WV();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.bvn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvn.getChildAt(i);
            if (childAt != this.bvr && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bvn.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvn.getChildAt(i);
            if (childAt != this.bvr && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.bvn.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bvn.removeView(findViewWithTag);
            if (!WW()) {
                WU();
            }
        }
    }

    private HeadImageView WY() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.TL, this.bvo);
        layoutParams.setMargins(this.bvp, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return WW() ? this.bvn.getChildCount() - 1 : this.bvn.getChildCount();
    }
}
