package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int YN;
    private View.OnClickListener aKT;
    private LinearLayout bJe;
    private int bJf;
    private int bJg;
    private int bJh;
    private HeadImageView bJi;
    private a bJj;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.YN = -1;
        this.bJf = -1;
        this.bJg = -1;
        this.bJh = 4;
        this.aKT = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YN = -1;
        this.bJf = -1;
        this.bJg = -1;
        this.bJh = 4;
        this.aKT = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bJh = i;
    }

    public void a(a aVar) {
        this.bJj = aVar;
    }

    private void initialize() {
        this.YN = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bJf = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bJg = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bJe = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bJe.setLayoutParams(layoutParams);
        this.bJe.setHorizontalScrollBarEnabled(true);
        this.bJe.setOrientation(0);
        Yy();
        addView(this.bJe);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yy() {
        if (this.bJi == null) {
            this.bJi = YC();
            this.bJi.setDrawBorder(false);
        }
        this.bJi.setImageBitmap(al.cq(i.e.icon_add_pop));
        this.bJe.addView(this.bJi);
    }

    private void Yz() {
        if (YA()) {
            this.bJe.removeView(this.bJi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YA() {
        int childCount = this.bJe.getChildCount();
        return childCount > 0 && this.bJe.getChildAt(childCount + (-1)) == this.bJi;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bJh) {
            HeadImageView YC = YC();
            YC.setIsRound(false);
            YC.d(aVar.getUserPortrait(), 12, false);
            if (YA()) {
                YC.setTag(aVar);
                YC.setOnClickListener(this.aKT);
                this.bJe.addView(YC, getItemLength());
                scrollTo(getItemLength() * (this.YN + this.bJg), 0);
            }
            if (getItemLength() >= this.bJh) {
                Yz();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bJe.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJe.getChildAt(i);
            if (childAt != this.bJi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String YB() {
        Object tag;
        int childCount = this.bJe.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJe.getChildAt(i);
            if (childAt != this.bJi && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bJe.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bJe.removeView(findViewWithTag);
            if (!YA()) {
                Yy();
            }
        }
    }

    private HeadImageView YC() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YN, this.bJf);
        layoutParams.setMargins(this.bJg, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return YA() ? this.bJe.getChildCount() - 1 : this.bJe.getChildCount();
    }
}
