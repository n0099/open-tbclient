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
import com.baidu.tieba.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int azM;
    private View.OnClickListener csN;
    private int fcb;
    private int fcc;
    private HeadImageView fcd;
    private a fce;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.azM = -1;
        this.mItemHeight = -1;
        this.fcb = -1;
        this.fcc = 4;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aUZ()) {
                    InviteFriendCandidateList.this.aUX();
                }
                if (InviteFriendCandidateList.this.fce != null) {
                    InviteFriendCandidateList.this.fce.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azM = -1;
        this.mItemHeight = -1;
        this.fcb = -1;
        this.fcc = 4;
        this.csN = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aUZ()) {
                    InviteFriendCandidateList.this.aUX();
                }
                if (InviteFriendCandidateList.this.fce != null) {
                    InviteFriendCandidateList.this.fce.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.fcc = i;
    }

    public void a(a aVar) {
        this.fce = aVar;
    }

    private void initialize() {
        this.azM = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.fcb = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aUX();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUX() {
        if (this.fcd == null) {
            this.fcd = aVb();
            this.fcd.setDrawBorder(false);
        }
        this.fcd.setImageBitmap(al.dO(e.f.icon_add_pop));
        this.mLayout.addView(this.fcd);
    }

    private void aUY() {
        if (aUZ()) {
            this.mLayout.removeView(this.fcd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aUZ() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.fcd;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.fcc) {
            HeadImageView aVb = aVb();
            aVb.setIsRound(false);
            aVb.startLoad(aVar.Kb(), 12, false);
            if (aUZ()) {
                aVb.setTag(aVar);
                aVb.setOnClickListener(this.csN);
                this.mLayout.addView(aVb, getItemLength());
                scrollTo(getItemLength() * (this.azM + this.fcb), 0);
            }
            if (getItemLength() >= this.fcc) {
                aUY();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.fcd && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aVa() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.fcd && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(",");
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
            if (!aUZ()) {
                aUX();
            }
        }
    }

    private HeadImageView aVb() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.azM, this.mItemHeight);
        layoutParams.setMargins(this.fcb, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aUZ() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
