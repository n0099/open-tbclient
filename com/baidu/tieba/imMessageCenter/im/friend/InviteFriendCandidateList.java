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
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aBS;
    private LinearLayout jKI;
    private int jKJ;
    private int jKK;
    private HeadImageView jKL;
    private a jKM;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes21.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jKJ = -1;
        this.jKK = 4;
        this.aBS = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jKI.removeView(view);
                if (!InviteFriendCandidateList.this.cMH()) {
                    InviteFriendCandidateList.this.cMF();
                }
                if (InviteFriendCandidateList.this.jKM != null) {
                    InviteFriendCandidateList.this.jKM.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jKK = i;
    }

    public void a(a aVar) {
        this.jKM = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jKJ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jKI = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jKI.setLayoutParams(layoutParams);
        this.jKI.setHorizontalScrollBarEnabled(true);
        this.jKI.setOrientation(0);
        cMF();
        addView(this.jKI);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMF() {
        if (this.jKL == null) {
            this.jKL = cMI();
            this.jKL.setDrawBorder(false);
        }
        this.jKL.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jKI.addView(this.jKL);
    }

    private void cMG() {
        if (cMH()) {
            this.jKI.removeView(this.jKL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cMH() {
        int childCount = this.jKI.getChildCount();
        return childCount > 0 && this.jKI.getChildAt(childCount + (-1)) == this.jKL;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jKK) {
            HeadImageView cMI = cMI();
            cMI.setIsRound(false);
            cMI.startLoad(aVar.bqn(), 12, false);
            if (cMH()) {
                cMI.setTag(aVar);
                cMI.setOnClickListener(this.aBS);
                this.jKI.addView(cMI, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jKJ), 0);
            }
            if (getItemLength() >= this.jKK) {
                cMG();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jKI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jKI.getChildAt(i);
            if (childAt != this.jKL && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jKI.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jKI.getChildAt(i);
            if (childAt != this.jKL && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jKI.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jKI.removeView(findViewWithTag);
            if (!cMH()) {
                cMF();
            }
        }
    }

    private HeadImageView cMI() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jKJ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cMH() ? this.jKI.getChildCount() - 1 : this.jKI.getChildCount();
    }
}
