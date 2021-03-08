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
    private View.OnClickListener aFH;
    private int dlK;
    private LinearLayout kRg;
    private int kRh;
    private HeadImageView kRi;
    private a kRj;
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
        this.dlK = -1;
        this.kRh = -1;
        this.mMaxCount = 4;
        this.aFH = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kRg.removeView(view);
                if (!InviteFriendCandidateList.this.cYO()) {
                    InviteFriendCandidateList.this.cYM();
                }
                if (InviteFriendCandidateList.this.kRj != null) {
                    InviteFriendCandidateList.this.kRj.b(view, view.getTag());
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
        this.kRj = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dlK = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kRh = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kRg = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kRg.setLayoutParams(layoutParams);
        this.kRg.setHorizontalScrollBarEnabled(true);
        this.kRg.setOrientation(0);
        cYM();
        addView(this.kRg);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYM() {
        if (this.kRi == null) {
            this.kRi = cYP();
            this.kRi.setDrawBorder(false);
        }
        this.kRi.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kRg.addView(this.kRi);
    }

    private void cYN() {
        if (cYO()) {
            this.kRg.removeView(this.kRi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYO() {
        int childCount = this.kRg.getChildCount();
        return childCount > 0 && this.kRg.getChildAt(childCount + (-1)) == this.kRi;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cYP = cYP();
            cYP.setIsRound(false);
            cYP.startLoad(aVar.getUserPortrait(), 12, false);
            if (cYO()) {
                cYP.setTag(aVar);
                cYP.setOnClickListener(this.aFH);
                this.kRg.addView(cYP, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kRh), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                cYN();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kRg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kRg.getChildAt(i);
            if (childAt != this.kRi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kRg.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kRg.getChildAt(i);
            if (childAt != this.kRi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kRg.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kRg.removeView(findViewWithTag);
            if (!cYO()) {
                cYM();
            }
        }
    }

    private HeadImageView cYP() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dlK);
        layoutParams.setMargins(this.kRh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cYO() ? this.kRg.getChildCount() - 1 : this.kRg.getChildCount();
    }
}
