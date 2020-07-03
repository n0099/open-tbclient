package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aXG;
    private LinearLayout jeE;
    private int jeF;
    private int jeG;
    private HeadImageView jeH;
    private a jeI;
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
        this.jeF = -1;
        this.jeG = 4;
        this.aXG = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jeE.removeView(view);
                if (!InviteFriendCandidateList.this.cug()) {
                    InviteFriendCandidateList.this.cue();
                }
                if (InviteFriendCandidateList.this.jeI != null) {
                    InviteFriendCandidateList.this.jeI.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jeG = i;
    }

    public void a(a aVar) {
        this.jeI = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jeF = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jeE = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jeE.setLayoutParams(layoutParams);
        this.jeE.setHorizontalScrollBarEnabled(true);
        this.jeE.setOrientation(0);
        cue();
        addView(this.jeE);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cue() {
        if (this.jeH == null) {
            this.jeH = cuh();
            this.jeH.setDrawBorder(false);
        }
        this.jeH.setImageBitmap(an.getBitmap(R.drawable.icon_add_pop));
        this.jeE.addView(this.jeH);
    }

    private void cuf() {
        if (cug()) {
            this.jeE.removeView(this.jeH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cug() {
        int childCount = this.jeE.getChildCount();
        return childCount > 0 && this.jeE.getChildAt(childCount + (-1)) == this.jeH;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jeG) {
            HeadImageView cuh = cuh();
            cuh.setIsRound(false);
            cuh.startLoad(aVar.bda(), 12, false);
            if (cug()) {
                cuh.setTag(aVar);
                cuh.setOnClickListener(this.aXG);
                this.jeE.addView(cuh, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jeF), 0);
            }
            if (getItemLength() >= this.jeG) {
                cuf();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jeE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jeE.getChildAt(i);
            if (childAt != this.jeH && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jeE.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jeE.getChildAt(i);
            if (childAt != this.jeH && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jeE.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jeE.removeView(findViewWithTag);
            if (!cug()) {
                cue();
            }
        }
    }

    private HeadImageView cuh() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jeF, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cug() ? this.jeE.getChildCount() - 1 : this.jeE.getChildCount();
    }
}
