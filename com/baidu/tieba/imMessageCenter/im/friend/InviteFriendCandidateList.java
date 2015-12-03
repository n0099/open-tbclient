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
    private int ZH;
    private View.OnClickListener aNE;
    private LinearLayout ccA;
    private int ccB;
    private int ccC;
    private int ccD;
    private HeadImageView ccE;
    private a ccF;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.ZH = -1;
        this.ccB = -1;
        this.ccC = -1;
        this.ccD = 4;
        this.aNE = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ZH = -1;
        this.ccB = -1;
        this.ccC = -1;
        this.ccD = 4;
        this.aNE = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.ccD = i;
    }

    public void a(a aVar) {
        this.ccF = aVar;
    }

    private void initialize() {
        this.ZH = this.mContext.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_width);
        this.ccB = this.mContext.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_height);
        this.ccC = this.mContext.getResources().getDimensionPixelSize(n.d.invite_friend_candidate_item_margin);
        this.ccA = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.ccA.setLayoutParams(layoutParams);
        this.ccA.setHorizontalScrollBarEnabled(true);
        this.ccA.setOrientation(0);
        acF();
        addView(this.ccA);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acF() {
        if (this.ccE == null) {
            this.ccE = acJ();
            this.ccE.setDrawBorder(false);
        }
        this.ccE.setImageBitmap(as.cE(n.e.icon_add_pop));
        this.ccA.addView(this.ccE);
    }

    private void acG() {
        if (acH()) {
            this.ccA.removeView(this.ccE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean acH() {
        int childCount = this.ccA.getChildCount();
        return childCount > 0 && this.ccA.getChildAt(childCount + (-1)) == this.ccE;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.ccD) {
            HeadImageView acJ = acJ();
            acJ.setIsRound(false);
            acJ.d(aVar.getUserPortrait(), 12, false);
            if (acH()) {
                acJ.setTag(aVar);
                acJ.setOnClickListener(this.aNE);
                this.ccA.addView(acJ, getItemLength());
                scrollTo(getItemLength() * (this.ZH + this.ccC), 0);
            }
            if (getItemLength() >= this.ccD) {
                acG();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.ccA.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ccA.getChildAt(i);
            if (childAt != this.ccE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String acI() {
        Object tag;
        int childCount = this.ccA.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.ccA.getChildAt(i);
            if (childAt != this.ccE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.ccA.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.ccA.removeView(findViewWithTag);
            if (!acH()) {
                acF();
            }
        }
    }

    private HeadImageView acJ() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ZH, this.ccB);
        layoutParams.setMargins(this.ccC, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return acH() ? this.ccA.getChildCount() - 1 : this.ccA.getChildCount();
    }
}
