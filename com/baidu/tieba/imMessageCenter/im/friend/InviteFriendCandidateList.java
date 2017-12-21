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
    private int aeU;
    private View.OnClickListener bEZ;
    private int dYv;
    private int dYw;
    private HeadImageView dYx;
    private a dYy;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeU = -1;
        this.mItemHeight = -1;
        this.dYv = -1;
        this.dYw = 4;
        this.bEZ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aEe()) {
                    InviteFriendCandidateList.this.aEc();
                }
                if (InviteFriendCandidateList.this.dYy != null) {
                    InviteFriendCandidateList.this.dYy.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wB();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeU = -1;
        this.mItemHeight = -1;
        this.dYv = -1;
        this.dYw = 4;
        this.bEZ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aEe()) {
                    InviteFriendCandidateList.this.aEc();
                }
                if (InviteFriendCandidateList.this.dYy != null) {
                    InviteFriendCandidateList.this.dYy.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wB();
    }

    public void setMaxCount(int i) {
        this.dYw = i;
    }

    public void a(a aVar) {
        this.dYy = aVar;
    }

    private void wB() {
        this.aeU = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dYv = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aEc();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEc() {
        if (this.dYx == null) {
            this.dYx = aEg();
            this.dYx.setDrawBorder(false);
        }
        this.dYx.setImageBitmap(aj.cR(d.f.icon_add_pop));
        this.mLayout.addView(this.dYx);
    }

    private void aEd() {
        if (aEe()) {
            this.mLayout.removeView(this.dYx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aEe() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dYx;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dYw) {
            HeadImageView aEg = aEg();
            aEg.setIsRound(false);
            aEg.startLoad(aVar.AQ(), 12, false);
            if (aEe()) {
                aEg.setTag(aVar);
                aEg.setOnClickListener(this.bEZ);
                this.mLayout.addView(aEg, getItemLength());
                scrollTo(getItemLength() * (this.aeU + this.dYv), 0);
            }
            if (getItemLength() >= this.dYw) {
                aEd();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dYx && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aEf() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dYx && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aEe()) {
                aEc();
            }
        }
    }

    private HeadImageView aEg() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeU, this.mItemHeight);
        layoutParams.setMargins(this.dYv, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aEe() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
