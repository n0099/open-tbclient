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
    private int Ta;
    private View.OnClickListener aBr;
    private LinearLayout bsl;
    private int bsm;
    private int bsn;
    private int bso;
    private HeadImageView bsp;
    private k bsq;
    private Context mContext;

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Ta = -1;
        this.bsm = -1;
        this.bsn = -1;
        this.bso = 4;
        this.aBr = new j(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ta = -1;
        this.bsm = -1;
        this.bsn = -1;
        this.bso = 4;
        this.aBr = new j(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bso = i;
    }

    public void a(k kVar) {
        this.bsq = kVar;
    }

    private void initialize() {
        this.Ta = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_width);
        this.bsm = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_height);
        this.bsn = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.invite_friend_candidate_item_margin);
        this.bsl = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bsl.setLayoutParams(layoutParams);
        this.bsl.setHorizontalScrollBarEnabled(true);
        this.bsl.setOrientation(0);
        Vo();
        addView(this.bsl);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vo() {
        if (this.bsp == null) {
            this.bsp = Vs();
            this.bsp.setDrawBorder(false);
        }
        this.bsp.setImageBitmap(ba.cg(com.baidu.tieba.u.icon_add_pop));
        this.bsl.addView(this.bsp);
    }

    private void Vp() {
        if (Vq()) {
            this.bsl.removeView(this.bsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Vq() {
        int childCount = this.bsl.getChildCount();
        return childCount > 0 && this.bsl.getChildAt(childCount + (-1)) == this.bsp;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bso) {
            HeadImageView Vs = Vs();
            Vs.setIsRound(false);
            Vs.c(aVar.getUserPortrait(), 12, false);
            if (Vq()) {
                Vs.setTag(aVar);
                Vs.setOnClickListener(this.aBr);
                this.bsl.addView(Vs, getItemLength());
                scrollTo(getItemLength() * (this.Ta + this.bsn), 0);
            }
            if (getItemLength() >= this.bso) {
                Vp();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bsl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsl.getChildAt(i);
            if (childAt != this.bsp && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String Vr() {
        Object tag;
        int childCount = this.bsl.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bsl.getChildAt(i);
            if (childAt != this.bsp && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bsl.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bsl.removeView(findViewWithTag);
            if (!Vq()) {
                Vo();
            }
        }
    }

    private HeadImageView Vs() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Ta, this.bsm);
        layoutParams.setMargins(this.bsn, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return Vq() ? this.bsl.getChildCount() - 1 : this.bsl.getChildCount();
    }
}
