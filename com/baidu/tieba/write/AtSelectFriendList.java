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
    private int GY;
    private final View.OnClickListener bal;
    private int bbA;
    private int bbB;
    private int bbC;
    private HeadImageView bbD;
    private n cfC;
    private final Context mContext;
    private LinearLayout mLayout;

    public AtSelectFriendList(Context context) {
        super(context);
        this.GY = -1;
        this.bbA = -1;
        this.bbB = -1;
        this.bbC = 4;
        this.bal = new m(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GY = -1;
        this.bbA = -1;
        this.bbB = -1;
        this.bbC = 4;
        this.bal = new m(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bbC = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(n nVar) {
        this.cfC = nVar;
    }

    private void initialize() {
        this.GY = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_width);
        this.bbA = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_height);
        this.bbB = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.invite_friend_candidate_item_margin);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        OC();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        if (this.bbD == null) {
            this.bbD = OG();
            this.bbD.setDrawBorder(false);
        }
        this.bbD.setImageBitmap(com.baidu.tbadk.core.util.bc.ce(com.baidu.tieba.v.icon_add_pop));
        this.mLayout.addView(this.bbD);
    }

    private void OD() {
        if (OE()) {
            this.mLayout.removeView(this.bbD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean OE() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.bbD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bbC) {
            HeadImageView OG = OG();
            OG.setIsRound(false);
            OG.d(metaData.getPortrait(), 12, false);
            if (OE()) {
                OG.setTag(metaData);
                OG.setOnClickListener(this.bal);
                this.mLayout.addView(OG, getItemLength());
                scrollTo(getItemLength() * (this.GY + this.bbB), 0);
                this.mLayout.requestLayout();
            }
            if (getItemLength() >= this.bbC) {
                OD();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.bbD && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
            if (childAt != this.bbD && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
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
            if (!OE()) {
                OC();
            }
        }
    }

    private HeadImageView OG() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.GY, this.bbA);
        layoutParams.setMargins(this.bbB, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return OE() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
