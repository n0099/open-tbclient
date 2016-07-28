package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int Wq;
    private int aLN;
    private View.OnClickListener aXC;
    private int deQ;
    private int deR;
    private HeadImageView deS;
    private a deT;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Wq = -1;
        this.deQ = -1;
        this.deR = -1;
        this.aLN = 4;
        this.aXC = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Wq = -1;
        this.deQ = -1;
        this.deR = -1;
        this.aLN = 4;
        this.aXC = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.aLN = i;
    }

    public void a(a aVar) {
        this.deT = aVar;
    }

    private void initialize() {
        this.Wq = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.deQ = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.deR = this.mContext.getResources().getDimensionPixelSize(u.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        atz();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atz() {
        if (this.deS == null) {
            this.deS = atD();
            this.deS.setDrawBorder(false);
        }
        this.deS.setImageBitmap(av.cA(u.f.icon_add_pop));
        this.mLayout.addView(this.deS);
    }

    private void atA() {
        if (atB()) {
            this.mLayout.removeView(this.deS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean atB() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.deS;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.aLN) {
            HeadImageView atD = atD();
            atD.setIsRound(false);
            atD.c(aVar.getUserPortrait(), 12, false);
            if (atB()) {
                atD.setTag(aVar);
                atD.setOnClickListener(this.aXC);
                this.mLayout.addView(atD, getItemLength());
                scrollTo(getItemLength() * (this.Wq + this.deR), 0);
            }
            if (getItemLength() >= this.aLN) {
                atA();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String atC() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.deS && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!atB()) {
                atz();
            }
        }
    }

    private HeadImageView atD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Wq, this.deQ);
        layoutParams.setMargins(this.deR, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return atB() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
