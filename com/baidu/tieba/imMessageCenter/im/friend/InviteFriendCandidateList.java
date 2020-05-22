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
    private LinearLayout iMP;
    private int iMQ;
    private int iMR;
    private HeadImageView iMS;
    private a iMT;
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
        this.iMQ = -1;
        this.iMR = 4;
        this.aUZ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.iMP.removeView(view);
                if (!InviteFriendCandidateList.this.cqi()) {
                    InviteFriendCandidateList.this.cqg();
                }
                if (InviteFriendCandidateList.this.iMT != null) {
                    InviteFriendCandidateList.this.iMT.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.iMR = i;
    }

    public void a(a aVar) {
        this.iMT = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.iMQ = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.iMP = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.iMP.setLayoutParams(layoutParams);
        this.iMP.setHorizontalScrollBarEnabled(true);
        this.iMP.setOrientation(0);
        cqg();
        addView(this.iMP);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqg() {
        if (this.iMS == null) {
            this.iMS = cqj();
            this.iMS.setDrawBorder(false);
        }
        this.iMS.setImageBitmap(am.getBitmap(R.drawable.icon_add_pop));
        this.iMP.addView(this.iMS);
    }

    private void cqh() {
        if (cqi()) {
            this.iMP.removeView(this.iMS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cqi() {
        int childCount = this.iMP.getChildCount();
        return childCount > 0 && this.iMP.getChildAt(childCount + (-1)) == this.iMS;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.iMR) {
            HeadImageView cqj = cqj();
            cqj.setIsRound(false);
            cqj.startLoad(aVar.baX(), 12, false);
            if (cqi()) {
                cqj.setTag(aVar);
                cqj.setOnClickListener(this.aUZ);
                this.iMP.addView(cqj, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.iMQ), 0);
            }
            if (getItemLength() >= this.iMR) {
                cqh();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.iMP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iMP.getChildAt(i);
            if (childAt != this.iMS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.iMP.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.iMP.getChildAt(i);
            if (childAt != this.iMS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.iMP.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.iMP.removeView(findViewWithTag);
            if (!cqi()) {
                cqg();
            }
        }
    }

    private HeadImageView cqj() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.iMQ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cqi() ? this.iMP.getChildCount() - 1 : this.iMP.getChildCount();
    }
}
