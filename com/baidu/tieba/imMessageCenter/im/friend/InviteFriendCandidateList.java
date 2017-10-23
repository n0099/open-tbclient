package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aeh;
    private View.OnClickListener bwB;
    private int dHE;
    private int dHF;
    private HeadImageView dHG;
    private a dHH;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeh = -1;
        this.mItemHeight = -1;
        this.dHE = -1;
        this.dHF = 4;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.azW()) {
                    InviteFriendCandidateList.this.azU();
                }
                if (InviteFriendCandidateList.this.dHH != null) {
                    InviteFriendCandidateList.this.dHH.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wt();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeh = -1;
        this.mItemHeight = -1;
        this.dHE = -1;
        this.dHF = 4;
        this.bwB = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.azW()) {
                    InviteFriendCandidateList.this.azU();
                }
                if (InviteFriendCandidateList.this.dHH != null) {
                    InviteFriendCandidateList.this.dHH.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wt();
    }

    public void setMaxCount(int i) {
        this.dHF = i;
    }

    public void a(a aVar) {
        this.dHH = aVar;
    }

    private void wt() {
        this.aeh = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dHE = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        azU();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azU() {
        if (this.dHG == null) {
            this.dHG = azY();
            this.dHG.setDrawBorder(false);
        }
        this.dHG.setImageBitmap(aj.cQ(d.g.icon_add_pop));
        this.mLayout.addView(this.dHG);
    }

    private void azV() {
        if (azW()) {
            this.mLayout.removeView(this.dHG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azW() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dHG;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dHF) {
            HeadImageView azY = azY();
            azY.setIsRound(false);
            azY.c(aVar.Ak(), 12, false);
            if (azW()) {
                azY.setTag(aVar);
                azY.setOnClickListener(this.bwB);
                this.mLayout.addView(azY, getItemLength());
                scrollTo(getItemLength() * (this.aeh + this.dHE), 0);
            }
            if (getItemLength() >= this.dHF) {
                azV();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dHG && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String azX() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dHG && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!azW()) {
                azU();
            }
        }
    }

    private HeadImageView azY() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeh, this.mItemHeight);
        layoutParams.setMargins(this.dHE, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return azW() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
