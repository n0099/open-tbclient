package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aet;
    private View.OnClickListener bwN;
    private int dHS;
    private int dHT;
    private HeadImageView dHU;
    private a dHV;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aet = -1;
        this.mItemHeight = -1;
        this.dHS = -1;
        this.dHT = 4;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aAb()) {
                    InviteFriendCandidateList.this.azZ();
                }
                if (InviteFriendCandidateList.this.dHV != null) {
                    InviteFriendCandidateList.this.dHV.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aet = -1;
        this.mItemHeight = -1;
        this.dHS = -1;
        this.dHT = 4;
        this.bwN = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aAb()) {
                    InviteFriendCandidateList.this.azZ();
                }
                if (InviteFriendCandidateList.this.dHV != null) {
                    InviteFriendCandidateList.this.dHV.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public void setMaxCount(int i) {
        this.dHT = i;
    }

    public void a(a aVar) {
        this.dHV = aVar;
    }

    private void wA() {
        this.aet = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dHS = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        azZ();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azZ() {
        if (this.dHU == null) {
            this.dHU = aAd();
            this.dHU.setDrawBorder(false);
        }
        this.dHU.setImageBitmap(aj.cR(d.g.icon_add_pop));
        this.mLayout.addView(this.dHU);
    }

    private void aAa() {
        if (aAb()) {
            this.mLayout.removeView(this.dHU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aAb() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dHU;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dHT) {
            HeadImageView aAd = aAd();
            aAd.setIsRound(false);
            aAd.c(aVar.Aq(), 12, false);
            if (aAb()) {
                aAd.setTag(aVar);
                aAd.setOnClickListener(this.bwN);
                this.mLayout.addView(aAd, getItemLength());
                scrollTo(getItemLength() * (this.aet + this.dHS), 0);
            }
            if (getItemLength() >= this.dHT) {
                aAa();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dHU && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aAc() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dHU && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
            if (!aAb()) {
                azZ();
            }
        }
    }

    private HeadImageView aAd() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aet, this.mItemHeight);
        layoutParams.setMargins(this.dHS, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aAb() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
