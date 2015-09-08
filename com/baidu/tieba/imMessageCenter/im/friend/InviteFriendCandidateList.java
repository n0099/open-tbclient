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
    private int YW;
    private View.OnClickListener aLg;
    private LinearLayout bJL;
    private int bJM;
    private int bJN;
    private int bJO;
    private HeadImageView bJP;
    private a bJQ;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.YW = -1;
        this.bJM = -1;
        this.bJN = -1;
        this.bJO = 4;
        this.aLg = new i(this);
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.YW = -1;
        this.bJM = -1;
        this.bJN = -1;
        this.bJO = 4;
        this.aLg = new i(this);
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.bJO = i;
    }

    public void a(a aVar) {
        this.bJQ = aVar;
    }

    private void initialize() {
        this.YW = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_width);
        this.bJM = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_height);
        this.bJN = this.mContext.getResources().getDimensionPixelSize(i.d.invite_friend_candidate_item_margin);
        this.bJL = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.bJL.setLayoutParams(layoutParams);
        this.bJL.setHorizontalScrollBarEnabled(true);
        this.bJL.setOrientation(0);
        YA();
        addView(this.bJL);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YA() {
        if (this.bJP == null) {
            this.bJP = YE();
            this.bJP.setDrawBorder(false);
        }
        this.bJP.setImageBitmap(al.cu(i.e.icon_add_pop));
        this.bJL.addView(this.bJP);
    }

    private void YB() {
        if (YC()) {
            this.bJL.removeView(this.bJP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean YC() {
        int childCount = this.bJL.getChildCount();
        return childCount > 0 && this.bJL.getChildAt(childCount + (-1)) == this.bJP;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.bJO) {
            HeadImageView YE = YE();
            YE.setIsRound(false);
            YE.d(aVar.getUserPortrait(), 12, false);
            if (YC()) {
                YE.setTag(aVar);
                YE.setOnClickListener(this.aLg);
                this.bJL.addView(YE, getItemLength());
                scrollTo(getItemLength() * (this.YW + this.bJN), 0);
            }
            if (getItemLength() >= this.bJO) {
                YB();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.bJL.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJL.getChildAt(i);
            if (childAt != this.bJP && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String YD() {
        Object tag;
        int childCount = this.bJL.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.bJL.getChildAt(i);
            if (childAt != this.bJP && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.bJL.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.bJL.removeView(findViewWithTag);
            if (!YC()) {
                YA();
            }
        }
    }

    private HeadImageView YE() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.YW, this.bJM);
        layoutParams.setMargins(this.bJN, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return YC() ? this.bJL.getChildCount() - 1 : this.bJL.getChildCount();
    }
}
