package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int Tc;
    private View.OnClickListener aBz;
    private LinearLayout bsB;
    private int bsC;
    private int bsD;
    private int bsE;
    private HeadImageView bsF;
    private k bsG;
    private Context mContext;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Tc = -1;
        this.bsC = -1;
        this.bsD = -1;
        this.bsE = 4;
        this.aBz = new j(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tc = -1;
        this.bsC = -1;
        this.bsD = -1;
        this.bsE = 4;
        this.aBz = new j(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bsE = i;
    }

    public void a(k kVar) {
        this.bsG = kVar;
    }

    private void initialize() {
        this.Tc = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.bsC = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.bsD = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.bsB = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bsB.setLayoutParams(layoutParams);
        this.bsB.setHorizontalScrollBarEnabled(true);
        this.bsB.setOrientation(0);
        VB();
        addView(this.bsB);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        if (this.bsF == null) {
            this.bsF = VF();
            this.bsF.setDrawBorder(false);
        }
        this.bsF.setImageBitmap(ba.cg(com.baidu.tieba.u.icon_add_pop));
        this.bsB.addView(this.bsF);
    }

    private void VC() {
        if (VD()) {
            this.bsB.removeView(this.bsF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean VD() {
        int childCount = this.bsB.getChildCount();
        return childCount > 0 && this.bsB.getChildAt(childCount + (-1)) == this.bsF;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bsE) {
            HeadImageView VF = VF();
            VF.setIsRound(false);
            VF.c(aVar.getUserPortrait(), 12, false);
            if (VD()) {
                VF.setTag(aVar);
                VF.setOnClickListener(this.aBz);
                this.bsB.addView(VF, getItemLength());
                scrollTo(getItemLength() * (this.Tc + this.bsD), 0);
            }
            if (getItemLength() >= this.bsE) {
                VC();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bsB.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsB.getChildAt(i);
            if (childAt != this.bsF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String VE() {
        Object tag;
        int childCount = this.bsB.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsB.getChildAt(i);
            if (childAt != this.bsF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bsB.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bsB.removeView(findViewWithTag);
            if (!VD()) {
                VB();
            }
        }
    }

    private HeadImageView VF() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Tc, this.bsC);
        layoutParams.setMargins(this.bsD, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return VD() ? this.bsB.getChildCount() - 1 : this.bsB.getChildCount();
    }
}
