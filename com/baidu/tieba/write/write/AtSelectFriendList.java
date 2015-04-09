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
    private int Tc;
    private final View.OnClickListener aBz;
    private LinearLayout bsB;
    private int bsC;
    private int bsD;
    private int bsE;
    private HeadImageView bsF;
    private r cxg;
    private final Context mContext;

    public AtSelectFriendList(Context context) {
        super(context);
        this.Tc = -1;
        this.bsC = -1;
        this.bsD = -1;
        this.bsE = 4;
        this.aBz = new q(this);
        this.mContext = context;
        initialize();
    }

    public AtSelectFriendList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tc = -1;
        this.bsC = -1;
        this.bsD = -1;
        this.bsE = 4;
        this.aBz = new q(this);
        this.mContext = context;
        initialize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMaxCount(int i) {
        this.bsE = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setItemOPerationHandler(r rVar) {
        this.cxg = rVar;
    }

    private void initialize() {
        this.Tc = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.bsC = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.bsD = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.bsB = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bsB.setLayoutParams(layoutParams);
        this.bsB.setHorizontalScrollBarEnabled(true);
        this.bsB.setOrientation(0);
        VB();
        addView(this.bsB);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (this.bsF == null) {
            this.bsF = VF();
            this.bsF.setDrawBorder(false);
        }
        this.bsF.setImageBitmap(com.baidu.tbadk.core.util.ba.cg(com.baidu.tieba.u.icon_add_pop));
        this.bsB.addView(this.bsF);
    }

    private void VC() {
        if (VD()) {
            this.bsB.removeView(this.bsF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VD() {
        int childCount = this.bsB.getChildCount();
        return childCount > 0 && this.bsB.getChildAt(childCount + (-1)) == this.bsF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(MetaData metaData) {
        if (getItemLength() < this.bsE) {
            HeadImageView VF = VF();
            VF.setIsRound(false);
            VF.c(metaData.getPortrait(), 12, false);
            if (VD()) {
                VF.setTag(metaData);
                VF.setOnClickListener(this.aBz);
                this.bsB.addView(VF, getItemLength());
                scrollTo(getItemLength() * (this.Tc + this.bsD), 0);
                this.bsB.requestLayout();
            }
            if (getItemLength() >= this.bsE) {
                VC();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(MetaData metaData) {
        Object tag;
        int childCount = this.bsB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsB.getChildAt(i);
            if (childAt != this.bsF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && metaData != null) {
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
        int childCount = this.bsB.getChildCount();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsB.getChildAt(i);
            if (childAt != this.bsF && (tag = childAt.getTag()) != null && (tag instanceof MetaData) && (name_show = ((MetaData) tag).getName_show()) != null) {
                arrayList.add(name_show);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(MetaData metaData) {
        View findViewWithTag = this.bsB.findViewWithTag(metaData);
        if (findViewWithTag != null) {
            this.bsB.removeView(findViewWithTag);
            if (!VD()) {
                VB();
            }
        }
    }

    private HeadImageView VF() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Tc, this.bsC);
        layoutParams.setMargins(this.bsD, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getItemLength() {
        return VD() ? this.bsB.getChildCount() - 1 : this.bsB.getChildCount();
    }
}
