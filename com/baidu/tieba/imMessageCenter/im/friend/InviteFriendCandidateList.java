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
/* loaded from: classes4.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aju;
    private int gTL;
    private int gTM;
    private HeadImageView gTN;
    private a gTO;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.gTL = -1;
        this.gTM = 4;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.bEV()) {
                    InviteFriendCandidateList.this.bET();
                }
                if (InviteFriendCandidateList.this.gTO != null) {
                    InviteFriendCandidateList.this.gTO.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.gTL = -1;
        this.gTM = 4;
        this.aju = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.bEV()) {
                    InviteFriendCandidateList.this.bET();
                }
                if (InviteFriendCandidateList.this.gTO != null) {
                    InviteFriendCandidateList.this.gTO.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.gTM = i;
    }

    public void a(a aVar) {
        this.gTO = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.gTL = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        bET();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bET() {
        if (this.gTN == null) {
            this.gTN = bEW();
            this.gTN.setDrawBorder(false);
        }
        this.gTN.setImageBitmap(am.getBitmap(R.drawable.icon_add_pop));
        this.mLayout.addView(this.gTN);
    }

    private void bEU() {
        if (bEV()) {
            this.mLayout.removeView(this.gTN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEV() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.gTN;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.gTM) {
            HeadImageView bEW = bEW();
            bEW.setIsRound(false);
            bEW.startLoad(aVar.asa(), 12, false);
            if (bEV()) {
                bEW.setTag(aVar);
                bEW.setOnClickListener(this.aju);
                this.mLayout.addView(bEW, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.gTL), 0);
            }
            if (getItemLength() >= this.gTM) {
                bEU();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gTN && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gTN && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.mLayout.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.mLayout.removeView(findViewWithTag);
            if (!bEV()) {
                bET();
            }
        }
    }

    private HeadImageView bEW() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.gTL, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return bEV() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
