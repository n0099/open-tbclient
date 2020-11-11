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
/* loaded from: classes22.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aFV;
    private LinearLayout ksb;
    private int ksc;
    private int ksd;
    private HeadImageView kse;
    private a ksf;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes22.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.ksc = -1;
        this.ksd = 4;
        this.aFV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.ksb.removeView(view);
                if (!InviteFriendCandidateList.this.cVX()) {
                    InviteFriendCandidateList.this.cVV();
                }
                if (InviteFriendCandidateList.this.ksf != null) {
                    InviteFriendCandidateList.this.ksf.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.ksd = i;
    }

    public void a(a aVar) {
        this.ksf = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.ksc = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.ksb = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.ksb.setLayoutParams(layoutParams);
        this.ksb.setHorizontalScrollBarEnabled(true);
        this.ksb.setOrientation(0);
        cVV();
        addView(this.ksb);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cVV() {
        if (this.kse == null) {
            this.kse = cVY();
            this.kse.setDrawBorder(false);
        }
        this.kse.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.ksb.addView(this.kse);
    }

    private void cVW() {
        if (cVX()) {
            this.ksb.removeView(this.kse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cVX() {
        int childCount = this.ksb.getChildCount();
        return childCount > 0 && this.ksb.getChildAt(childCount + (-1)) == this.kse;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.ksd) {
            HeadImageView cVY = cVY();
            cVY.setIsRound(false);
            cVY.startLoad(aVar.getUserPortrait(), 12, false);
            if (cVX()) {
                cVY.setTag(aVar);
                cVY.setOnClickListener(this.aFV);
                this.ksb.addView(cVY, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.ksc), 0);
            }
            if (getItemLength() >= this.ksd) {
                cVW();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.ksb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksb.getChildAt(i);
            if (childAt != this.kse && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.ksb.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ksb.getChildAt(i);
            if (childAt != this.kse && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.ksb.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.ksb.removeView(findViewWithTag);
            if (!cVX()) {
                cVV();
            }
        }
    }

    private HeadImageView cVY() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.ksc, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cVX() ? this.ksb.getChildCount() - 1 : this.ksb.getChildCount();
    }
}
