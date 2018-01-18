package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends com.baidu.tbadk.core.view.d {
    private int aTe;
    private View.OnClickListener ctQ;
    private int eLY;
    private int eLZ;
    private HeadImageView eMa;
    private a eMb;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aTe = -1;
        this.mItemHeight = -1;
        this.eLY = -1;
        this.eLZ = 4;
        this.ctQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aLk()) {
                    InviteFriendCandidateList.this.aLi();
                }
                if (InviteFriendCandidateList.this.eMb != null) {
                    InviteFriendCandidateList.this.eMb.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DQ();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTe = -1;
        this.mItemHeight = -1;
        this.eLY = -1;
        this.eLZ = 4;
        this.ctQ = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aLk()) {
                    InviteFriendCandidateList.this.aLi();
                }
                if (InviteFriendCandidateList.this.eMb != null) {
                    InviteFriendCandidateList.this.eMb.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DQ();
    }

    public void setMaxCount(int i) {
        this.eLZ = i;
    }

    public void a(a aVar) {
        this.eMb = aVar;
    }

    private void DQ() {
        this.aTe = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eLY = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aLi();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLi() {
        if (this.eMa == null) {
            this.eMa = aLm();
            this.eMa.setDrawBorder(false);
        }
        this.eMa.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eMa);
    }

    private void aLj() {
        if (aLk()) {
            this.mLayout.removeView(this.eMa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLk() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eMa;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eLZ) {
            HeadImageView aLm = aLm();
            aLm.setIsRound(false);
            aLm.startLoad(aVar.Il(), 12, false);
            if (aLk()) {
                aLm.setTag(aVar);
                aLm.setOnClickListener(this.ctQ);
                this.mLayout.addView(aLm, getItemLength());
                scrollTo(getItemLength() * (this.aTe + this.eLY), 0);
            }
            if (getItemLength() >= this.eLZ) {
                aLj();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMa && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aLl() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMa && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aLk()) {
                aLi();
            }
        }
    }

    private HeadImageView aLm() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aTe, this.mItemHeight);
        layoutParams.setMargins(this.eLY, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aLk() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
