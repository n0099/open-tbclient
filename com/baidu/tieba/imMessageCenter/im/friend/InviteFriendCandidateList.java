package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aGQ;
    private LinearLayout kGg;
    private int kGh;
    private HeadImageView kGi;
    private a kGj;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private int mMaxCount;

    /* loaded from: classes22.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.kGh = -1;
        this.mMaxCount = 4;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kGg.removeView(view);
                if (!InviteFriendCandidateList.this.daP()) {
                    InviteFriendCandidateList.this.daN();
                }
                if (InviteFriendCandidateList.this.kGj != null) {
                    InviteFriendCandidateList.this.kGj.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.mMaxCount = i;
    }

    public void a(a aVar) {
        this.kGj = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kGh = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kGg = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kGg.setLayoutParams(layoutParams);
        this.kGg.setHorizontalScrollBarEnabled(true);
        this.kGg.setOrientation(0);
        daN();
        addView(this.kGg);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daN() {
        if (this.kGi == null) {
            this.kGi = daQ();
            this.kGi.setDrawBorder(false);
        }
        this.kGi.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kGg.addView(this.kGi);
    }

    private void daO() {
        if (daP()) {
            this.kGg.removeView(this.kGi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean daP() {
        int childCount = this.kGg.getChildCount();
        return childCount > 0 && this.kGg.getChildAt(childCount + (-1)) == this.kGi;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView daQ = daQ();
            daQ.setIsRound(false);
            daQ.startLoad(aVar.getUserPortrait(), 12, false);
            if (daP()) {
                daQ.setTag(aVar);
                daQ.setOnClickListener(this.aGQ);
                this.kGg.addView(daQ, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kGh), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                daO();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kGg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGg.getChildAt(i);
            if (childAt != this.kGi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kGg.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGg.getChildAt(i);
            if (childAt != this.kGi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kGg.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kGg.removeView(findViewWithTag);
            if (!daP()) {
                daN();
            }
        }
    }

    private HeadImageView daQ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.kGh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return daP() ? this.kGg.getChildCount() - 1 : this.kGg.getChildCount();
    }
}
