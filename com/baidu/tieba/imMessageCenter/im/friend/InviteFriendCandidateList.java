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
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aEh;
    private int dkj;
    private LinearLayout kOQ;
    private int kOR;
    private HeadImageView kOS;
    private a kOT;
    private Context mContext;
    private int mItemWidth;
    private int mMaxCount;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.dkj = -1;
        this.kOR = -1;
        this.mMaxCount = 4;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kOQ.removeView(view);
                if (!InviteFriendCandidateList.this.cYA()) {
                    InviteFriendCandidateList.this.cYy();
                }
                if (InviteFriendCandidateList.this.kOT != null) {
                    InviteFriendCandidateList.this.kOT.b(view, view.getTag());
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
        this.kOT = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dkj = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kOR = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kOQ = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kOQ.setLayoutParams(layoutParams);
        this.kOQ.setHorizontalScrollBarEnabled(true);
        this.kOQ.setOrientation(0);
        cYy();
        addView(this.kOQ);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYy() {
        if (this.kOS == null) {
            this.kOS = cYB();
            this.kOS.setDrawBorder(false);
        }
        this.kOS.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kOQ.addView(this.kOS);
    }

    private void cYz() {
        if (cYA()) {
            this.kOQ.removeView(this.kOS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYA() {
        int childCount = this.kOQ.getChildCount();
        return childCount > 0 && this.kOQ.getChildAt(childCount + (-1)) == this.kOS;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cYB = cYB();
            cYB.setIsRound(false);
            cYB.startLoad(aVar.getUserPortrait(), 12, false);
            if (cYA()) {
                cYB.setTag(aVar);
                cYB.setOnClickListener(this.aEh);
                this.kOQ.addView(cYB, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kOR), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                cYz();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kOQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kOQ.getChildAt(i);
            if (childAt != this.kOS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kOQ.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kOQ.getChildAt(i);
            if (childAt != this.kOS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kOQ.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kOQ.removeView(findViewWithTag);
            if (!cYA()) {
                cYy();
            }
        }
    }

    private HeadImageView cYB() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dkj);
        layoutParams.setMargins(this.kOR, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cYA() ? this.kOQ.getChildCount() - 1 : this.kOQ.getChildCount();
    }
}
