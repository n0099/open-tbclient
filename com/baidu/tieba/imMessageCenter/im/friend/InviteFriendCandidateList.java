package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aHh;
    private int dmK;
    private LinearLayout kLr;
    private int kLs;
    private HeadImageView kLt;
    private a kLu;
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
        this.dmK = -1;
        this.kLs = -1;
        this.mMaxCount = 4;
        this.aHh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kLr.removeView(view);
                if (!InviteFriendCandidateList.this.dat()) {
                    InviteFriendCandidateList.this.dar();
                }
                if (InviteFriendCandidateList.this.kLu != null) {
                    InviteFriendCandidateList.this.kLu.b(view, view.getTag());
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
        this.kLu = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dmK = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kLs = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kLr = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kLr.setLayoutParams(layoutParams);
        this.kLr.setHorizontalScrollBarEnabled(true);
        this.kLr.setOrientation(0);
        dar();
        addView(this.kLr);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dar() {
        if (this.kLt == null) {
            this.kLt = dau();
            this.kLt.setDrawBorder(false);
        }
        this.kLt.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.kLr.addView(this.kLt);
    }

    private void das() {
        if (dat()) {
            this.kLr.removeView(this.kLt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dat() {
        int childCount = this.kLr.getChildCount();
        return childCount > 0 && this.kLr.getChildAt(childCount + (-1)) == this.kLt;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView dau = dau();
            dau.setIsRound(false);
            dau.startLoad(aVar.getUserPortrait(), 12, false);
            if (dat()) {
                dau.setTag(aVar);
                dau.setOnClickListener(this.aHh);
                this.kLr.addView(dau, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kLs), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                das();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kLr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kLr.getChildAt(i);
            if (childAt != this.kLt && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kLr.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kLr.getChildAt(i);
            if (childAt != this.kLt && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kLr.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kLr.removeView(findViewWithTag);
            if (!dat()) {
                dar();
            }
        }
    }

    private HeadImageView dau() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dmK);
        layoutParams.setMargins(this.kLs, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return dat() ? this.kLr.getChildCount() - 1 : this.kLr.getChildCount();
    }
}
