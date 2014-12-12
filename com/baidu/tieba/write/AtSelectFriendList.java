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
    private int GS;
    private final View.OnClickListener aYQ;
    private int bae;
    private int baf;
    private int bag;
    private HeadImageView bah;
    private n cee;
    private final Context mContext;
    private LinearLayout mLayout;

    public AtSelectFriendList(Context context) {
        super(context);
        this.GS = -1;
        this.bae = -1;
        this.baf = -1;
        this.bag = 4;
        this.aYQ = new m(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GS = -1;
        this.bae = -1;
        this.baf = -1;
        this.bag = 4;
        this.aYQ = new m(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bag = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(n nVar) {
        this.cee = nVar;
    }

    private void initialize() {
        this.GS = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_width);
        this.bae = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height);
        this.baf = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        Ol();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ol() {
        if (this.bah == null) {
            this.bah = Op();
            this.bah.setDrawBorder(false);
        }
        this.bah.setImageBitmap(com.baidu.tbadk.core.util.ax.bX(com.baidu.tieba.v.icon_add_pop));
        this.mLayout.addView(this.bah);
    }

    private void Om() {
        if (On()) {
            this.mLayout.removeView(this.bah);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean On() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.bah;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bag) {
            HeadImageView Op = Op();
            Op.setIsRound(false);
            Op.d(metaData.getPortrait(), 12, false);
            if (On()) {
                Op.setTag(metaData);
                Op.setOnClickListener(this.aYQ);
                this.mLayout.addView(Op, getItemLength());
                scrollTo(getItemLength() * (this.GS + this.baf), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.bag) {
                Om();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bah && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.bah && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!On()) {
                Ol();
            }
        }
    }

    private HeadImageView Op() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.GS, this.bae);
        layoutParams.setMargins(this.baf, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return On() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
