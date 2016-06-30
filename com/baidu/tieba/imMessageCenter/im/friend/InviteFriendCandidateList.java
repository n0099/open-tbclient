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
    private int VH;
    private int aKU;
    private View.OnClickListener aWE;
    private int dbS;
    private int dbT;
    private HeadImageView dbU;
    private a dbV;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.VH = -1;
        this.dbS = -1;
        this.dbT = -1;
        this.aKU = 4;
        this.aWE = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.VH = -1;
        this.dbS = -1;
        this.dbT = -1;
        this.aKU = 4;
        this.aWE = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.aKU = i;
    }

    public void a(a aVar) {
        this.dbV = aVar;
    }

    private void initialize() {
        this.VH = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.dbS = this.mContext.getResources().getDimensionPixelSize(u.e.ds80);
        this.dbT = this.mContext.getResources().getDimensionPixelSize(u.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        asN();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asN() {
        if (this.dbU == null) {
            this.dbU = asR();
            this.dbU.setDrawBorder(false);
        }
        this.dbU.setImageBitmap(av.cA(u.f.icon_add_pop));
        this.mLayout.addView(this.dbU);
    }

    private void asO() {
        if (asP()) {
            this.mLayout.removeView(this.dbU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asP() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dbU;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.aKU) {
            HeadImageView asR = asR();
            asR.setIsRound(false);
            asR.c(aVar.getUserPortrait(), 12, false);
            if (asP()) {
                asR.setTag(aVar);
                asR.setOnClickListener(this.aWE);
                this.mLayout.addView(asR, getItemLength());
                scrollTo(getItemLength() * (this.VH + this.dbT), 0);
            }
            if (getItemLength() >= this.aKU) {
                asO();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dbU && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String asQ() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dbU && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!asP()) {
                asN();
            }
        }
    }

    private HeadImageView asR() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.VH, this.dbS);
        layoutParams.setMargins(this.dbT, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return asP() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
