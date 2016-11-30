package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int ZP;
    private int aUq;
    private View.OnClickListener bgP;
    private int cmj;
    private int dxB;
    private HeadImageView dxC;
    private a dxD;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.ZP = -1;
        this.cmj = -1;
        this.dxB = -1;
        this.aUq = 4;
        this.bgP = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZP = -1;
        this.cmj = -1;
        this.dxB = -1;
        this.aUq = 4;
        this.bgP = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.aUq = i;
    }

    public void a(a aVar) {
        this.dxD = aVar;
    }

    private void initialize() {
        this.ZP = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.cmj = this.mContext.getResources().getDimensionPixelSize(r.e.ds80);
        this.dxB = this.mContext.getResources().getDimensionPixelSize(r.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aAI();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAI() {
        if (this.dxC == null) {
            this.dxC = aAM();
            this.dxC.setDrawBorder(false);
        }
        this.dxC.setImageBitmap(at.cO(r.f.icon_add_pop));
        this.mLayout.addView(this.dxC);
    }

    private void aAJ() {
        if (aAK()) {
            this.mLayout.removeView(this.dxC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAK() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dxC;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.aUq) {
            HeadImageView aAM = aAM();
            aAM.setIsRound(false);
            aAM.c(aVar.Ay(), 12, false);
            if (aAK()) {
                aAM.setTag(aVar);
                aAM.setOnClickListener(this.bgP);
                this.mLayout.addView(aAM, getItemLength());
                scrollTo(getItemLength() * (this.ZP + this.dxB), 0);
            }
            if (getItemLength() >= this.aUq) {
                aAJ();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dxC && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aAL() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dxC && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aAK()) {
                aAI();
            }
        }
    }

    private HeadImageView aAM() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ZP, this.cmj);
        layoutParams.setMargins(this.dxB, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aAK() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
