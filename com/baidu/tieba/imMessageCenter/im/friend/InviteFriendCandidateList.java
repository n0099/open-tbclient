package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int Zj;
    private int aTH;
    private int bRt;
    private View.OnClickListener bgh;
    private int daA;
    private HeadImageView daB;
    private a daC;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Zj = -1;
        this.bRt = -1;
        this.daA = -1;
        this.aTH = 4;
        this.bgh = new i(this);
        this.mContext = context;
        ww();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zj = -1;
        this.bRt = -1;
        this.daA = -1;
        this.aTH = 4;
        this.bgh = new i(this);
        this.mContext = context;
        ww();
    }

    public void setMaxCount(int i) {
        this.aTH = i;
    }

    public void a(a aVar) {
        this.daC = aVar;
    }

    private void ww() {
        this.Zj = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.bRt = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.daA = this.mContext.getResources().getDimensionPixelSize(r.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aue();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aue() {
        if (this.daB == null) {
            this.daB = aui();
            this.daB.setDrawBorder(false);
        }
        this.daB.setImageBitmap(ar.cQ(r.f.icon_add_pop));
        this.mLayout.addView(this.daB);
    }

    private void auf() {
        if (aug()) {
            this.mLayout.removeView(this.daB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aug() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.daB;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.aTH) {
            HeadImageView aui = aui();
            aui.setIsRound(false);
            aui.c(aVar.Al(), 12, false);
            if (aug()) {
                aui.setTag(aVar);
                aui.setOnClickListener(this.bgh);
                this.mLayout.addView(aui, getItemLength());
                scrollTo(getItemLength() * (this.Zj + this.daA), 0);
            }
            if (getItemLength() >= this.aTH) {
                auf();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.daB && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String auh() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.daB && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aug()) {
                aue();
            }
        }
    }

    private HeadImageView aui() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Zj, this.bRt);
        layoutParams.setMargins(this.daA, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aug() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
