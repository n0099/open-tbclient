package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int TL;
    private View.OnClickListener aDw;
    private LinearLayout bvn;
    private int bvo;
    private int bvp;
    private int bvq;
    private HeadImageView bvr;
    private k bvs;
    private Context mContext;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.TL = -1;
        this.bvo = -1;
        this.bvp = -1;
        this.bvq = 4;
        this.aDw = new j(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TL = -1;
        this.bvo = -1;
        this.bvp = -1;
        this.bvq = 4;
        this.aDw = new j(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bvq = i;
    }

    public void a(k kVar) {
        this.bvs = kVar;
    }

    private void initialize() {
        this.TL = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_width);
        this.bvo = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height);
        this.bvp = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_margin);
        this.bvn = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bvn.setLayoutParams(layoutParams);
        this.bvn.setHorizontalScrollBarEnabled(true);
        this.bvn.setOrientation(0);
        WU();
        addView(this.bvn);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WU() {
        if (this.bvr == null) {
            this.bvr = WY();
            this.bvr.setDrawBorder(false);
        }
        this.bvr.setImageBitmap(ay.ck(com.baidu.tieba.p.icon_add_pop));
        this.bvn.addView(this.bvr);
    }

    private void WV() {
        if (WW()) {
            this.bvn.removeView(this.bvr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WW() {
        int childCount = this.bvn.getChildCount();
        return childCount > 0 && this.bvn.getChildAt(childCount + (-1)) == this.bvr;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bvq) {
            HeadImageView WY = WY();
            WY.setIsRound(false);
            WY.c(aVar.getUserPortrait(), 12, false);
            if (WW()) {
                WY.setTag(aVar);
                WY.setOnClickListener(this.aDw);
                this.bvn.addView(WY, getItemLength());
                scrollTo(getItemLength() * (this.TL + this.bvp), 0);
            }
            if (getItemLength() >= this.bvq) {
                WV();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bvn.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvn.getChildAt(i);
            if (childAt != this.bvr && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String WX() {
        Object tag;
        int childCount = this.bvn.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvn.getChildAt(i);
            if (childAt != this.bvr && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bvn.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bvn.removeView(findViewWithTag);
            if (!WW()) {
                WU();
            }
        }
    }

    private HeadImageView WY() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.TL, this.bvo);
        layoutParams.setMargins(this.bvp, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return WW() ? this.bvn.getChildCount() - 1 : this.bvn.getChildCount();
    }
}
