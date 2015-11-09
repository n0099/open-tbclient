package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int YV;
    private View.OnClickListener aJd;
    private HeadImageView bNA;
    private a bNB;
    private LinearLayout bNw;
    private int bNx;
    private int bNy;
    private int bNz;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.YV = -1;
        this.bNx = -1;
        this.bNy = -1;
        this.bNz = 4;
        this.aJd = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YV = -1;
        this.bNx = -1;
        this.bNy = -1;
        this.bNz = 4;
        this.aJd = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bNz = i;
    }

    public void a(a aVar) {
        this.bNB = aVar;
    }

    private void initialize() {
        this.YV = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bNx = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bNy = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bNw = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bNw.setLayoutParams(layoutParams);
        this.bNw.setHorizontalScrollBarEnabled(true);
        this.bNw.setOrientation(0);
        Zz();
        addView(this.bNw);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zz() {
        if (this.bNA == null) {
            this.bNA = ZD();
            this.bNA.setDrawBorder(false);
        }
        this.bNA.setImageBitmap(an.cw(i.e.icon_add_pop));
        this.bNw.addView(this.bNA);
    }

    private void ZA() {
        if (ZB()) {
            this.bNw.removeView(this.bNA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ZB() {
        int childCount = this.bNw.getChildCount();
        return childCount > 0 && this.bNw.getChildAt(childCount + (-1)) == this.bNA;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bNz) {
            HeadImageView ZD = ZD();
            ZD.setIsRound(false);
            ZD.d(aVar.getUserPortrait(), 12, false);
            if (ZB()) {
                ZD.setTag(aVar);
                ZD.setOnClickListener(this.aJd);
                this.bNw.addView(ZD, getItemLength());
                scrollTo(getItemLength() * (this.YV + this.bNy), 0);
            }
            if (getItemLength() >= this.bNz) {
                ZA();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bNw.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNw.getChildAt(i);
            if (childAt != this.bNA && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String ZC() {
        Object tag;
        int childCount = this.bNw.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bNw.getChildAt(i);
            if (childAt != this.bNA && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bNw.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bNw.removeView(findViewWithTag);
            if (!ZB()) {
                Zz();
            }
        }
    }

    private HeadImageView ZD() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YV, this.bNx);
        layoutParams.setMargins(this.bNy, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return ZB() ? this.bNw.getChildCount() - 1 : this.bNw.getChildCount();
    }
}
