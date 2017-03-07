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
    private int adM;
    private View.OnClickListener bgU;
    private int cft;
    private int csD;
    private int dkf;
    private HeadImageView dkg;
    private a dkh;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.adM = -1;
        this.cft = -1;
        this.dkf = -1;
        this.csD = 4;
        this.bgU = new i(this);
        this.mContext = context;
        wO();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adM = -1;
        this.cft = -1;
        this.dkf = -1;
        this.csD = 4;
        this.bgU = new i(this);
        this.mContext = context;
        wO();
    }

    public void setMaxCount(int i) {
        this.csD = i;
    }

    public void a(a aVar) {
        this.dkh = aVar;
    }

    private void wO() {
        this.adM = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cft = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dkf = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        auF();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auF() {
        if (this.dkg == null) {
            this.dkg = auJ();
            this.dkg.setDrawBorder(false);
        }
        this.dkg.setImageBitmap(aq.cL(w.g.icon_add_pop));
        this.mLayout.addView(this.dkg);
    }

    private void auG() {
        if (auH()) {
            this.mLayout.removeView(this.dkg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean auH() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dkg;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.csD) {
            HeadImageView auJ = auJ();
            auJ.setIsRound(false);
            auJ.c(aVar.Ax(), 12, false);
            if (auH()) {
                auJ.setTag(aVar);
                auJ.setOnClickListener(this.bgU);
                this.mLayout.addView(auJ, getItemLength());
                scrollTo(getItemLength() * (this.adM + this.dkf), 0);
            }
            if (getItemLength() >= this.csD) {
                auG();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkg && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String auI() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkg && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!auH()) {
                auF();
            }
        }
    }

    private HeadImageView auJ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.adM, this.cft);
        layoutParams.setMargins(this.dkf, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return auH() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
