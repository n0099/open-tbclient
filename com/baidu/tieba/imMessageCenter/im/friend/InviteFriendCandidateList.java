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
    private int bRE;
    private View.OnClickListener dYB;
    private int gVL;
    private int gVM;
    private HeadImageView gVN;
    private a gVO;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.bRE = -1;
        this.mItemHeight = -1;
        this.gVL = -1;
        this.gVM = 4;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.bIk()) {
                    InviteFriendCandidateList.this.bIi();
                }
                if (InviteFriendCandidateList.this.gVO != null) {
                    InviteFriendCandidateList.this.gVO.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bRE = -1;
        this.mItemHeight = -1;
        this.gVL = -1;
        this.gVM = 4;
        this.dYB = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.bIk()) {
                    InviteFriendCandidateList.this.bIi();
                }
                if (InviteFriendCandidateList.this.gVO != null) {
                    InviteFriendCandidateList.this.gVO.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.gVM = i;
    }

    public void a(a aVar) {
        this.gVO = aVar;
    }

    private void initialize() {
        this.bRE = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.gVL = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        bIi();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        if (this.gVN == null) {
            this.gVN = bIm();
            this.gVN.setDrawBorder(false);
        }
        this.gVN.setImageBitmap(am.ij(R.drawable.icon_add_pop));
        this.mLayout.addView(this.gVN);
    }

    private void bIj() {
        if (bIk()) {
            this.mLayout.removeView(this.gVN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIk() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.gVN;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.gVM) {
            HeadImageView bIm = bIm();
            bIm.setIsRound(false);
            bIm.startLoad(aVar.aqg(), 12, false);
            if (bIk()) {
                bIm.setTag(aVar);
                bIm.setOnClickListener(this.dYB);
                this.mLayout.addView(bIm, getItemLength());
                scrollTo(getItemLength() * (this.bRE + this.gVL), 0);
            }
            if (getItemLength() >= this.gVM) {
                bIj();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gVN && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String bIl() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.gVN && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!bIk()) {
                bIi();
            }
        }
    }

    private HeadImageView bIm() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.bRE, this.mItemHeight);
        layoutParams.setMargins(this.gVL, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return bIk() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
