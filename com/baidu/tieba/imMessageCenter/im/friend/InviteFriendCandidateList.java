package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends com.baidu.tbadk.core.view.d {
    private int aUM;
    private View.OnClickListener cyh;
    private int eQC;
    private int eQD;
    private HeadImageView eQE;
    private a eQF;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aUM = -1;
        this.mItemHeight = -1;
        this.eQC = -1;
        this.eQD = 4;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aMR()) {
                    InviteFriendCandidateList.this.aMP();
                }
                if (InviteFriendCandidateList.this.eQF != null) {
                    InviteFriendCandidateList.this.eQF.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        Em();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUM = -1;
        this.mItemHeight = -1;
        this.eQC = -1;
        this.eQD = 4;
        this.cyh = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aMR()) {
                    InviteFriendCandidateList.this.aMP();
                }
                if (InviteFriendCandidateList.this.eQF != null) {
                    InviteFriendCandidateList.this.eQF.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        Em();
    }

    public void setMaxCount(int i) {
        this.eQD = i;
    }

    public void a(a aVar) {
        this.eQF = aVar;
    }

    private void Em() {
        this.aUM = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eQC = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aMP();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMP() {
        if (this.eQE == null) {
            this.eQE = aMT();
            this.eQE.setDrawBorder(false);
        }
        this.eQE.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eQE);
    }

    private void aMQ() {
        if (aMR()) {
            this.mLayout.removeView(this.eQE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMR() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eQE;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eQD) {
            HeadImageView aMT = aMT();
            aMT.setIsRound(false);
            aMT.startLoad(aVar.IT(), 12, false);
            if (aMR()) {
                aMT.setTag(aVar);
                aMT.setOnClickListener(this.cyh);
                this.mLayout.addView(aMT, getItemLength());
                scrollTo(getItemLength() * (this.aUM + this.eQC), 0);
            }
            if (getItemLength() >= this.eQD) {
                aMQ();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eQE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aMS() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eQE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aMR()) {
                aMP();
            }
        }
    }

    private HeadImageView aMT() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aUM, this.mItemHeight);
        layoutParams.setMargins(this.eQC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aMR() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
