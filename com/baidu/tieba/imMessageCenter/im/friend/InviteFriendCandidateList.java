package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aea;
    private View.OnClickListener bgO;
    private int cdT;
    private int crd;
    private int diE;
    private HeadImageView diF;
    private a diG;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aea = -1;
        this.cdT = -1;
        this.diE = -1;
        this.crd = 4;
        this.bgO = new i(this);
        this.mContext = context;
        xk();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aea = -1;
        this.cdT = -1;
        this.diE = -1;
        this.crd = 4;
        this.bgO = new i(this);
        this.mContext = context;
        xk();
    }

    public void setMaxCount(int i) {
        this.crd = i;
    }

    public void a(a aVar) {
        this.diG = aVar;
    }

    private void xk() {
        this.aea = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cdT = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.diE = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        auy();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        if (this.diF == null) {
            this.diF = auC();
            this.diF.setDrawBorder(false);
        }
        this.diF.setImageBitmap(aq.cO(w.g.icon_add_pop));
        this.mLayout.addView(this.diF);
    }

    private void auz() {
        if (auA()) {
            this.mLayout.removeView(this.diF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auA() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.diF;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.crd) {
            HeadImageView auC = auC();
            auC.setIsRound(false);
            auC.c(aVar.AW(), 12, false);
            if (auA()) {
                auC.setTag(aVar);
                auC.setOnClickListener(this.bgO);
                this.mLayout.addView(auC, getItemLength());
                scrollTo(getItemLength() * (this.aea + this.diE), 0);
            }
            if (getItemLength() >= this.crd) {
                auz();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.diF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String auB() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.diF && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
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
            if (!auA()) {
                auy();
            }
        }
    }

    private HeadImageView auC() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aea, this.cdT);
        layoutParams.setMargins(this.diE, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return auA() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
