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
    private LinearLayout kGi;
    private int kGj;
    private HeadImageView kGk;
    private a kGl;
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
        this.kGj = -1;
        this.mMaxCount = 4;
        this.aGQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kGi.removeView(view);
                if (!InviteFriendCandidateList.this.daQ()) {
                    InviteFriendCandidateList.this.daO();
                }
                if (InviteFriendCandidateList.this.kGl != null) {
                    InviteFriendCandidateList.this.kGl.a(view, view.getTag());
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
        this.kGl = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kGj = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kGi = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kGi.setLayoutParams(layoutParams);
        this.kGi.setHorizontalScrollBarEnabled(true);
        this.kGi.setOrientation(0);
        daO();
        addView(this.kGi);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void daO() {
        if (this.kGk == null) {
            this.kGk = daR();
            this.kGk.setDrawBorder(false);
        }
        this.kGk.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kGi.addView(this.kGk);
    }

    private void daP() {
        if (daQ()) {
            this.kGi.removeView(this.kGk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean daQ() {
        int childCount = this.kGi.getChildCount();
        return childCount > 0 && this.kGi.getChildAt(childCount + (-1)) == this.kGk;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView daR = daR();
            daR.setIsRound(false);
            daR.startLoad(aVar.getUserPortrait(), 12, false);
            if (daQ()) {
                daR.setTag(aVar);
                daR.setOnClickListener(this.aGQ);
                this.kGi.addView(daR, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kGj), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                daP();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kGi.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGi.getChildAt(i);
            if (childAt != this.kGk && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kGi.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGi.getChildAt(i);
            if (childAt != this.kGk && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kGi.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kGi.removeView(findViewWithTag);
            if (!daQ()) {
                daO();
            }
        }
    }

    private HeadImageView daR() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.kGj, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return daQ() ? this.kGi.getChildCount() - 1 : this.kGi.getChildCount();
    }
}
