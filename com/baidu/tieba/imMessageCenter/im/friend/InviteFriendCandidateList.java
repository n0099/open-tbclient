package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aUZ;
    private LinearLayout iNC;
    private int iND;
    private int iNE;
    private HeadImageView iNF;
    private a iNG;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes9.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.iND = -1;
        this.iNE = 4;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.iNC.removeView(view);
                if (!InviteFriendCandidateList.this.cqr()) {
                    InviteFriendCandidateList.this.cqp();
                }
                if (InviteFriendCandidateList.this.iNG != null) {
                    InviteFriendCandidateList.this.iNG.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.iNE = i;
    }

    public void a(a aVar) {
        this.iNG = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.iND = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.iNC = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.iNC.setLayoutParams(layoutParams);
        this.iNC.setHorizontalScrollBarEnabled(true);
        this.iNC.setOrientation(0);
        cqp();
        addView(this.iNC);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqp() {
        if (this.iNF == null) {
            this.iNF = cqs();
            this.iNF.setDrawBorder(false);
        }
        this.iNF.setImageBitmap(am.getBitmap(R.drawable.icon_add_pop));
        this.iNC.addView(this.iNF);
    }

    private void cqq() {
        if (cqr()) {
            this.iNC.removeView(this.iNF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqr() {
        int childCount = this.iNC.getChildCount();
        return childCount > 0 && this.iNC.getChildAt(childCount + (-1)) == this.iNF;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.iNE) {
            HeadImageView cqs = cqs();
            cqs.setIsRound(false);
            cqs.startLoad(aVar.baY(), 12, false);
            if (cqr()) {
                cqs.setTag(aVar);
                cqs.setOnClickListener(this.aUZ);
                this.iNC.addView(cqs, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.iND), 0);
            }
            if (getItemLength() >= this.iNE) {
                cqq();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.iNC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iNC.getChildAt(i);
            if (childAt != this.iNF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.iNC.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iNC.getChildAt(i);
            if (childAt != this.iNF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.iNC.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.iNC.removeView(findViewWithTag);
            if (!cqr()) {
                cqp();
            }
        }
    }

    private HeadImageView cqs() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.iND, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cqr() ? this.iNC.getChildCount() - 1 : this.iNC.getChildCount();
    }
}
