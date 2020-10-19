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
    private View.OnClickListener aEX;
    private LinearLayout jZF;
    private int jZG;
    private int jZH;
    private HeadImageView jZI;
    private a jZJ;
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
        this.jZG = -1;
        this.jZH = 4;
        this.aEX = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jZF.removeView(view);
                if (!InviteFriendCandidateList.this.cQp()) {
                    InviteFriendCandidateList.this.cQn();
                }
                if (InviteFriendCandidateList.this.jZJ != null) {
                    InviteFriendCandidateList.this.jZJ.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jZH = i;
    }

    public void a(a aVar) {
        this.jZJ = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jZG = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jZF = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jZF.setLayoutParams(layoutParams);
        this.jZF.setHorizontalScrollBarEnabled(true);
        this.jZF.setOrientation(0);
        cQn();
        addView(this.jZF);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQn() {
        if (this.jZI == null) {
            this.jZI = cQq();
            this.jZI.setDrawBorder(false);
        }
        this.jZI.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jZF.addView(this.jZI);
    }

    private void cQo() {
        if (cQp()) {
            this.jZF.removeView(this.jZI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cQp() {
        int childCount = this.jZF.getChildCount();
        return childCount > 0 && this.jZF.getChildAt(childCount + (-1)) == this.jZI;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jZH) {
            HeadImageView cQq = cQq();
            cQq.setIsRound(false);
            cQq.startLoad(aVar.bsX(), 12, false);
            if (cQp()) {
                cQq.setTag(aVar);
                cQq.setOnClickListener(this.aEX);
                this.jZF.addView(cQq, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jZG), 0);
            }
            if (getItemLength() >= this.jZH) {
                cQo();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jZF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jZF.getChildAt(i);
            if (childAt != this.jZI && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jZF.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jZF.getChildAt(i);
            if (childAt != this.jZI && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jZF.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jZF.removeView(findViewWithTag);
            if (!cQp()) {
                cQn();
            }
        }
    }

    private HeadImageView cQq() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jZG, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cQp() ? this.jZF.getChildCount() - 1 : this.jZF.getChildCount();
    }
}
