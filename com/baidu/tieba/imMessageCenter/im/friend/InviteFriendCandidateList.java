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
    private View.OnClickListener aEk;
    private LinearLayout ksL;
    private int ksM;
    private int ksN;
    private HeadImageView ksO;
    private a ksP;
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
        this.ksM = -1;
        this.ksN = 4;
        this.aEk = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.ksL.removeView(view);
                if (!InviteFriendCandidateList.this.cVD()) {
                    InviteFriendCandidateList.this.cVB();
                }
                if (InviteFriendCandidateList.this.ksP != null) {
                    InviteFriendCandidateList.this.ksP.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.ksN = i;
    }

    public void a(a aVar) {
        this.ksP = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ksM = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ksL = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.ksL.setLayoutParams(layoutParams);
        this.ksL.setHorizontalScrollBarEnabled(true);
        this.ksL.setOrientation(0);
        cVB();
        addView(this.ksL);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVB() {
        if (this.ksO == null) {
            this.ksO = cVE();
            this.ksO.setDrawBorder(false);
        }
        this.ksO.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.ksL.addView(this.ksO);
    }

    private void cVC() {
        if (cVD()) {
            this.ksL.removeView(this.ksO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVD() {
        int childCount = this.ksL.getChildCount();
        return childCount > 0 && this.ksL.getChildAt(childCount + (-1)) == this.ksO;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.ksN) {
            HeadImageView cVE = cVE();
            cVE.setIsRound(false);
            cVE.startLoad(aVar.getUserPortrait(), 12, false);
            if (cVD()) {
                cVE.setTag(aVar);
                cVE.setOnClickListener(this.aEk);
                this.ksL.addView(cVE, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.ksM), 0);
            }
            if (getItemLength() >= this.ksN) {
                cVC();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.ksL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksL.getChildAt(i);
            if (childAt != this.ksO && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.ksL.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksL.getChildAt(i);
            if (childAt != this.ksO && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.ksL.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.ksL.removeView(findViewWithTag);
            if (!cVD()) {
                cVB();
            }
        }
    }

    private HeadImageView cVE() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.ksM, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cVD() ? this.ksL.getChildCount() - 1 : this.ksL.getChildCount();
    }
}
