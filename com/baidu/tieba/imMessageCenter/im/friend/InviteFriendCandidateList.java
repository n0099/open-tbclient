package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener bOj;
    private int ekU;
    private int ekV;
    private HeadImageView ekW;
    private a ekX;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view2, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.ekU = -1;
        this.ekV = 4;
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                InviteFriendCandidateList.this.mLayout.removeView(view2);
                if (!InviteFriendCandidateList.this.aHM()) {
                    InviteFriendCandidateList.this.aHK();
                }
                if (InviteFriendCandidateList.this.ekX != null) {
                    InviteFriendCandidateList.this.ekX.b(view2, view2.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.ekU = -1;
        this.ekV = 4;
        this.bOj = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                InviteFriendCandidateList.this.mLayout.removeView(view2);
                if (!InviteFriendCandidateList.this.aHM()) {
                    InviteFriendCandidateList.this.aHK();
                }
                if (InviteFriendCandidateList.this.ekX != null) {
                    InviteFriendCandidateList.this.ekX.b(view2, view2.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.ekV = i;
    }

    public void a(a aVar) {
        this.ekX = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.ekU = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aHK();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHK() {
        if (this.ekW == null) {
            this.ekW = aHO();
            this.ekW.setDrawBorder(false);
        }
        this.ekW.setImageBitmap(ak.cO(d.f.icon_add_pop));
        this.mLayout.addView(this.ekW);
    }

    private void aHL() {
        if (aHM()) {
            this.mLayout.removeView(this.ekW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aHM() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.ekW;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.ekV) {
            HeadImageView aHO = aHO();
            aHO.setIsRound(false);
            aHO.startLoad(aVar.BH(), 12, false);
            if (aHM()) {
                aHO.setTag(aVar);
                aHO.setOnClickListener(this.bOj);
                this.mLayout.addView(aHO, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.ekU), 0);
            }
            if (getItemLength() >= this.ekV) {
                aHL();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.ekW && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aHN() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.ekW && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aHM()) {
                aHK();
            }
        }
    }

    private HeadImageView aHO() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.ekU, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aHM() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
