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
    private int aeW;
    private View.OnClickListener bvd;
    private int cWn;
    private int dLD;
    private HeadImageView dLE;
    private a dLF;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeW = -1;
        this.mItemHeight = -1;
        this.dLD = -1;
        this.cWn = 4;
        this.bvd = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aBq()) {
                    InviteFriendCandidateList.this.aBo();
                }
                if (InviteFriendCandidateList.this.dLF != null) {
                    InviteFriendCandidateList.this.dLF.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        xb();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeW = -1;
        this.mItemHeight = -1;
        this.dLD = -1;
        this.cWn = 4;
        this.bvd = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aBq()) {
                    InviteFriendCandidateList.this.aBo();
                }
                if (InviteFriendCandidateList.this.dLF != null) {
                    InviteFriendCandidateList.this.dLF.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        xb();
    }

    public void setMaxCount(int i) {
        this.cWn = i;
    }

    public void a(a aVar) {
        this.dLF = aVar;
    }

    private void xb() {
        this.aeW = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dLD = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aBo();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        if (this.dLE == null) {
            this.dLE = aBs();
            this.dLE.setDrawBorder(false);
        }
        this.dLE.setImageBitmap(aj.cT(d.g.icon_add_pop));
        this.mLayout.addView(this.dLE);
    }

    private void aBp() {
        if (aBq()) {
            this.mLayout.removeView(this.dLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBq() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dLE;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cWn) {
            HeadImageView aBs = aBs();
            aBs.setIsRound(false);
            aBs.c(aVar.AS(), 12, false);
            if (aBq()) {
                aBs.setTag(aVar);
                aBs.setOnClickListener(this.bvd);
                this.mLayout.addView(aBs, getItemLength());
                scrollTo(getItemLength() * (this.aeW + this.dLD), 0);
            }
            if (getItemLength() >= this.cWn) {
                aBp();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dLE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aBr() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dLE && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aBq()) {
                aBo();
            }
        }
    }

    private HeadImageView aBs() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeW, this.mItemHeight);
        layoutParams.setMargins(this.dLD, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aBq() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
