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
    private int aeR;
    private View.OnClickListener bEV;
    private int dYr;
    private int dYs;
    private HeadImageView dYt;
    private a dYu;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeR = -1;
        this.mItemHeight = -1;
        this.dYr = -1;
        this.dYs = 4;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aEd()) {
                    InviteFriendCandidateList.this.aEb();
                }
                if (InviteFriendCandidateList.this.dYu != null) {
                    InviteFriendCandidateList.this.dYu.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wB();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeR = -1;
        this.mItemHeight = -1;
        this.dYr = -1;
        this.dYs = 4;
        this.bEV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aEd()) {
                    InviteFriendCandidateList.this.aEb();
                }
                if (InviteFriendCandidateList.this.dYu != null) {
                    InviteFriendCandidateList.this.dYu.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wB();
    }

    public void setMaxCount(int i) {
        this.dYs = i;
    }

    public void a(a aVar) {
        this.dYu = aVar;
    }

    private void wB() {
        this.aeR = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dYr = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aEb();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEb() {
        if (this.dYt == null) {
            this.dYt = aEf();
            this.dYt.setDrawBorder(false);
        }
        this.dYt.setImageBitmap(aj.cR(d.f.icon_add_pop));
        this.mLayout.addView(this.dYt);
    }

    private void aEc() {
        if (aEd()) {
            this.mLayout.removeView(this.dYt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEd() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dYt;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dYs) {
            HeadImageView aEf = aEf();
            aEf.setIsRound(false);
            aEf.startLoad(aVar.AQ(), 12, false);
            if (aEd()) {
                aEf.setTag(aVar);
                aEf.setOnClickListener(this.bEV);
                this.mLayout.addView(aEf, getItemLength());
                scrollTo(getItemLength() * (this.aeR + this.dYr), 0);
            }
            if (getItemLength() >= this.dYs) {
                aEc();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dYt && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aEe() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dYt && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aEd()) {
                aEb();
            }
        }
    }

    private HeadImageView aEf() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeR, this.mItemHeight);
        layoutParams.setMargins(this.dYr, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aEd() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
