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
    private int aeb;
    private View.OnClickListener biY;
    private int cgk;
    private int ctu;
    private int dkV;
    private HeadImageView dkW;
    private a dkX;
    private Context mContext;
    private LinearLayout mLayout;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeb = -1;
        this.cgk = -1;
        this.dkV = -1;
        this.ctu = 4;
        this.biY = new i(this);
        this.mContext = context;
        xk();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeb = -1;
        this.cgk = -1;
        this.dkV = -1;
        this.ctu = 4;
        this.biY = new i(this);
        this.mContext = context;
        xk();
    }

    public void setMaxCount(int i) {
        this.ctu = i;
    }

    public void a(a aVar) {
        this.dkX = aVar;
    }

    private void xk() {
        this.aeb = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.cgk = this.mContext.getResources().getDimensionPixelSize(w.f.ds80);
        this.dkV = this.mContext.getResources().getDimensionPixelSize(w.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        avz();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avz() {
        if (this.dkW == null) {
            this.dkW = avD();
            this.dkW.setDrawBorder(false);
        }
        this.dkW.setImageBitmap(aq.cO(w.g.icon_add_pop));
        this.mLayout.addView(this.dkW);
    }

    private void avA() {
        if (avB()) {
            this.mLayout.removeView(this.dkW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean avB() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dkW;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.ctu) {
            HeadImageView avD = avD();
            avD.setIsRound(false);
            avD.c(aVar.AW(), 12, false);
            if (avB()) {
                avD.setTag(aVar);
                avD.setOnClickListener(this.biY);
                this.mLayout.addView(avD, getItemLength());
                scrollTo(getItemLength() * (this.aeb + this.dkV), 0);
            }
            if (getItemLength() >= this.ctu) {
                avA();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkW && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String avC() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dkW && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!avB()) {
                avz();
            }
        }
    }

    private HeadImageView avD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeb, this.cgk);
        layoutParams.setMargins(this.dkV, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return avB() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
