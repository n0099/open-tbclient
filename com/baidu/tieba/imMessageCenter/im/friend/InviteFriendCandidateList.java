package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aRw;
    private int aal;
    private LinearLayout cgA;
    private int cgB;
    private int cgC;
    private int cgD;
    private HeadImageView cgE;
    private a cgF;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aal = -1;
        this.cgB = -1;
        this.cgC = -1;
        this.cgD = 4;
        this.aRw = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aal = -1;
        this.cgB = -1;
        this.cgC = -1;
        this.cgD = 4;
        this.aRw = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.cgD = i;
    }

    public void a(a aVar) {
        this.cgF = aVar;
    }

    private void initialize() {
        this.aal = this.mContext.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_width);
        this.cgB = this.mContext.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_height);
        this.cgC = this.mContext.getResources().getDimensionPixelSize(n.e.invite_friend_candidate_item_margin);
        this.cgA = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.cgA.setLayoutParams(layoutParams);
        this.cgA.setHorizontalScrollBarEnabled(true);
        this.cgA.setOrientation(0);
        adO();
        addView(this.cgA);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adO() {
        if (this.cgE == null) {
            this.cgE = adS();
            this.cgE.setDrawBorder(false);
        }
        this.cgE.setImageBitmap(as.cx(n.f.icon_add_pop));
        this.cgA.addView(this.cgE);
    }

    private void adP() {
        if (adQ()) {
            this.cgA.removeView(this.cgE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean adQ() {
        int childCount = this.cgA.getChildCount();
        return childCount > 0 && this.cgA.getChildAt(childCount + (-1)) == this.cgE;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cgD) {
            HeadImageView adS = adS();
            adS.setIsRound(false);
            adS.d(aVar.getUserPortrait(), 12, false);
            if (adQ()) {
                adS.setTag(aVar);
                adS.setOnClickListener(this.aRw);
                this.cgA.addView(adS, getItemLength());
                scrollTo(getItemLength() * (this.aal + this.cgC), 0);
            }
            if (getItemLength() >= this.cgD) {
                adP();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.cgA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cgA.getChildAt(i);
            if (childAt != this.cgE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String adR() {
        Object tag;
        int childCount = this.cgA.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.cgA.getChildAt(i);
            if (childAt != this.cgE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.cgA.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.cgA.removeView(findViewWithTag);
            if (!adQ()) {
                adO();
            }
        }
    }

    private HeadImageView adS() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aal, this.cgB);
        layoutParams.setMargins(this.cgC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return adQ() ? this.cgA.getChildCount() - 1 : this.cgA.getChildCount();
    }
}
