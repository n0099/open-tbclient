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
    private View.OnClickListener aDv;
    private LinearLayout bvm;
    private int bvn;
    private int bvo;
    private int bvp;
    private HeadImageView bvq;
    private k bvr;
    private Context mContext;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.TL = -1;
        this.bvn = -1;
        this.bvo = -1;
        this.bvp = 4;
        this.aDv = new j(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TL = -1;
        this.bvn = -1;
        this.bvo = -1;
        this.bvp = 4;
        this.aDv = new j(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bvp = i;
    }

    public void a(k kVar) {
        this.bvr = kVar;
    }

    private void initialize() {
        this.TL = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_width);
        this.bvn = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_height);
        this.bvo = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.o.invite_friend_candidate_item_margin);
        this.bvm = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bvm.setLayoutParams(layoutParams);
        this.bvm.setHorizontalScrollBarEnabled(true);
        this.bvm.setOrientation(0);
        WT();
        addView(this.bvm);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WT() {
        if (this.bvq == null) {
            this.bvq = WX();
            this.bvq.setDrawBorder(false);
        }
        this.bvq.setImageBitmap(ay.ck(com.baidu.tieba.p.icon_add_pop));
        this.bvm.addView(this.bvq);
    }

    private void WU() {
        if (WV()) {
            this.bvm.removeView(this.bvq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean WV() {
        int childCount = this.bvm.getChildCount();
        return childCount > 0 && this.bvm.getChildAt(childCount + (-1)) == this.bvq;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bvp) {
            HeadImageView WX = WX();
            WX.setIsRound(false);
            WX.c(aVar.getUserPortrait(), 12, false);
            if (WV()) {
                WX.setTag(aVar);
                WX.setOnClickListener(this.aDv);
                this.bvm.addView(WX, getItemLength());
                scrollTo(getItemLength() * (this.TL + this.bvo), 0);
            }
            if (getItemLength() >= this.bvp) {
                WU();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bvm.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvm.getChildAt(i);
            if (childAt != this.bvq && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String WW() {
        Object tag;
        int childCount = this.bvm.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bvm.getChildAt(i);
            if (childAt != this.bvq && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bvm.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bvm.removeView(findViewWithTag);
            if (!WV()) {
                WT();
            }
        }
    }

    private HeadImageView WX() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.TL, this.bvn);
        layoutParams.setMargins(this.bvo, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return WV() ? this.bvm.getChildCount() - 1 : this.bvm.getChildCount();
    }
}
