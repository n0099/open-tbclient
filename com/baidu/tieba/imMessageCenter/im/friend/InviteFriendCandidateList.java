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
    private View.OnClickListener aCu;
    private int dhV;
    private LinearLayout kGM;
    private int kGN;
    private HeadImageView kGO;
    private a kGP;
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
        this.dhV = -1;
        this.kGN = -1;
        this.mMaxCount = 4;
        this.aCu = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.kGM.removeView(view);
                if (!InviteFriendCandidateList.this.cWC()) {
                    InviteFriendCandidateList.this.cWA();
                }
                if (InviteFriendCandidateList.this.kGP != null) {
                    InviteFriendCandidateList.this.kGP.b(view, view.getTag());
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
        this.kGP = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.dhV = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.kGN = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.kGM = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.kGM.setLayoutParams(layoutParams);
        this.kGM.setHorizontalScrollBarEnabled(true);
        this.kGM.setOrientation(0);
        cWA();
        addView(this.kGM);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cWA() {
        if (this.kGO == null) {
            this.kGO = cWD();
            this.kGO.setDrawBorder(false);
        }
        this.kGO.setImageBitmap(ao.getBitmap(R.drawable.icon_add_pop));
        this.kGM.addView(this.kGO);
    }

    private void cWB() {
        if (cWC()) {
            this.kGM.removeView(this.kGO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cWC() {
        int childCount = this.kGM.getChildCount();
        return childCount > 0 && this.kGM.getChildAt(childCount + (-1)) == this.kGO;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.mMaxCount) {
            HeadImageView cWD = cWD();
            cWD.setIsRound(false);
            cWD.startLoad(aVar.getUserPortrait(), 12, false);
            if (cWC()) {
                cWD.setTag(aVar);
                cWD.setOnClickListener(this.aCu);
                this.kGM.addView(cWD, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.kGN), 0);
            }
            if (getItemLength() >= this.mMaxCount) {
                cWB();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.kGM.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGM.getChildAt(i);
            if (childAt != this.kGO && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.kGM.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.kGM.getChildAt(i);
            if (childAt != this.kGO && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.kGM.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.kGM.removeView(findViewWithTag);
            if (!cWC()) {
                cWA();
            }
        }
    }

    private HeadImageView cWD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.dhV);
        layoutParams.setMargins(this.kGN, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cWC() ? this.kGM.getChildCount() - 1 : this.kGM.getChildCount();
    }
}
