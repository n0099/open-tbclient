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
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int Zr;
    private int aSp;
    private View.OnClickListener bdP;
    private int drU;
    private int drV;
    private HeadImageView drW;
    private a drX;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.Zr = -1;
        this.drU = -1;
        this.drV = -1;
        this.aSp = 4;
        this.bdP = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Zr = -1;
        this.drU = -1;
        this.drV = -1;
        this.aSp = 4;
        this.bdP = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.aSp = i;
    }

    public void a(a aVar) {
        this.drX = aVar;
    }

    private void initialize() {
        this.Zr = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.drU = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.drV = this.mContext.getResources().getDimensionPixelSize(r.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        ayL();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ayL() {
        if (this.drW == null) {
            this.drW = ayP();
            this.drW.setDrawBorder(false);
        }
        this.drW.setImageBitmap(av.cN(r.f.icon_add_pop));
        this.mLayout.addView(this.drW);
    }

    private void ayM() {
        if (ayN()) {
            this.mLayout.removeView(this.drW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayN() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.drW;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.aSp) {
            HeadImageView ayP = ayP();
            ayP.setIsRound(false);
            ayP.c(aVar.Ar(), 12, false);
            if (ayN()) {
                ayP.setTag(aVar);
                ayP.setOnClickListener(this.bdP);
                this.mLayout.addView(ayP, getItemLength());
                scrollTo(getItemLength() * (this.Zr + this.drV), 0);
            }
            if (getItemLength() >= this.aSp) {
                ayM();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.drW && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String ayO() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.drW && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!ayN()) {
                ayL();
            }
        }
    }

    private HeadImageView ayP() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.Zr, this.drU);
        layoutParams.setMargins(this.drV, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return ayN() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
