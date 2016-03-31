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
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int ZV;
    private View.OnClickListener aXp;
    private int bNN;
    private LinearLayout cvF;
    private int cvG;
    private int cvH;
    private HeadImageView cvI;
    private a cvJ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.ZV = -1;
        this.cvG = -1;
        this.cvH = -1;
        this.bNN = 4;
        this.aXp = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZV = -1;
        this.cvG = -1;
        this.cvH = -1;
        this.bNN = 4;
        this.aXp = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bNN = i;
    }

    public void a(a aVar) {
        this.cvJ = aVar;
    }

    private void initialize() {
        this.ZV = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_width);
        this.cvG = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_height);
        this.cvH = this.mContext.getResources().getDimensionPixelSize(t.e.invite_friend_candidate_item_margin);
        this.cvF = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cvF.setLayoutParams(layoutParams);
        this.cvF.setHorizontalScrollBarEnabled(true);
        this.cvF.setOrientation(0);
        aks();
        addView(this.cvF);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aks() {
        if (this.cvI == null) {
            this.cvI = akw();
            this.cvI.setDrawBorder(false);
        }
        this.cvI.setImageBitmap(at.cR(t.f.icon_add_pop));
        this.cvF.addView(this.cvI);
    }

    private void akt() {
        if (aku()) {
            this.cvF.removeView(this.cvI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aku() {
        int childCount = this.cvF.getChildCount();
        return childCount > 0 && this.cvF.getChildAt(childCount + (-1)) == this.cvI;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bNN) {
            HeadImageView akw = akw();
            akw.setIsRound(false);
            akw.c(aVar.getUserPortrait(), 12, false);
            if (aku()) {
                akw.setTag(aVar);
                akw.setOnClickListener(this.aXp);
                this.cvF.addView(akw, getItemLength());
                scrollTo(getItemLength() * (this.ZV + this.cvH), 0);
            }
            if (getItemLength() >= this.bNN) {
                akt();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.cvF.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cvF.getChildAt(i);
            if (childAt != this.cvI && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String akv() {
        Object tag;
        int childCount = this.cvF.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cvF.getChildAt(i);
            if (childAt != this.cvI && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.cvF.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.cvF.removeView(findViewWithTag);
            if (!aku()) {
                aks();
            }
        }
    }

    private HeadImageView akw() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ZV, this.cvG);
        layoutParams.setMargins(this.cvH, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aku() ? this.cvF.getChildCount() - 1 : this.cvF.getChildCount();
    }
}
