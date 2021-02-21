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
    private LinearLayout kPe;
    private int kPf;
    private HeadImageView kPg;
    private a kPh;
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
        this.kPf = -1;
        this.mMaxCount = 4;
        this.aEh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kPe.removeView(view);
                if (!InviteFriendCandidateList.this.cYH()) {
                    InviteFriendCandidateList.this.cYF();
                }
                if (InviteFriendCandidateList.this.kPh != null) {
                    InviteFriendCandidateList.this.kPh.b(view, view.getTag());
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
        this.kPh = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dkj = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kPf = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kPe = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kPe.setLayoutParams(layoutParams);
        this.kPe.setHorizontalScrollBarEnabled(true);
        this.kPe.setOrientation(0);
        cYF();
        addView(this.kPe);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cYF() {
        if (this.kPg == null) {
            this.kPg = cYI();
            this.kPg.setDrawBorder(false);
        }
        this.kPg.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.kPe.addView(this.kPg);
    }

    private void cYG() {
        if (cYH()) {
            this.kPe.removeView(this.kPg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cYH() {
        int childCount = this.kPe.getChildCount();
        return childCount > 0 && this.kPe.getChildAt(childCount + (-1)) == this.kPg;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cYI = cYI();
            cYI.setIsRound(false);
            cYI.startLoad(aVar.getUserPortrait(), 12, false);
            if (cYH()) {
                cYI.setTag(aVar);
                cYI.setOnClickListener(this.aEh);
                this.kPe.addView(cYI, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kPf), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                cYG();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kPe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kPe.getChildAt(i);
            if (childAt != this.kPg && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kPe.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kPe.getChildAt(i);
            if (childAt != this.kPg && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kPe.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kPe.removeView(findViewWithTag);
            if (!cYH()) {
                cYF();
            }
        }
    }

    private HeadImageView cYI() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dkj);
        layoutParams.setMargins(this.kPf, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cYH() ? this.kPe.getChildCount() - 1 : this.kPe.getChildCount();
    }
}
