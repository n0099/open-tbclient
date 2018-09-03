package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aoc;
    private View.OnClickListener caq;
    private int eEV;
    private int eEW;
    private HeadImageView eEX;
    private a eEY;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aoc = -1;
        this.mItemHeight = -1;
        this.eEV = -1;
        this.eEW = 4;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aOi()) {
                    InviteFriendCandidateList.this.aOg();
                }
                if (InviteFriendCandidateList.this.eEY != null) {
                    InviteFriendCandidateList.this.eEY.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AC();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoc = -1;
        this.mItemHeight = -1;
        this.eEV = -1;
        this.eEW = 4;
        this.caq = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aOi()) {
                    InviteFriendCandidateList.this.aOg();
                }
                if (InviteFriendCandidateList.this.eEY != null) {
                    InviteFriendCandidateList.this.eEY.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AC();
    }

    public void setMaxCount(int i) {
        this.eEW = i;
    }

    public void a(a aVar) {
        this.eEY = aVar;
    }

    private void AC() {
        this.aoc = this.mContext.getResources().getDimensionPixelSize(f.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(f.e.ds80);
        this.eEV = this.mContext.getResources().getDimensionPixelSize(f.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aOg();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOg() {
        if (this.eEX == null) {
            this.eEX = aOk();
            this.eEX.setDrawBorder(false);
        }
        this.eEX.setImageBitmap(am.cT(f.C0146f.icon_add_pop));
        this.mLayout.addView(this.eEX);
    }

    private void aOh() {
        if (aOi()) {
            this.mLayout.removeView(this.eEX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOi() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eEX;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eEW) {
            HeadImageView aOk = aOk();
            aOk.setIsRound(false);
            aOk.startLoad(aVar.Fu(), 12, false);
            if (aOi()) {
                aOk.setTag(aVar);
                aOk.setOnClickListener(this.caq);
                this.mLayout.addView(aOk, getItemLength());
                scrollTo(getItemLength() * (this.aoc + this.eEV), 0);
            }
            if (getItemLength() >= this.eEW) {
                aOh();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eEX && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aOj() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eEX && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aOi()) {
                aOg();
            }
        }
    }

    private HeadImageView aOk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aoc, this.mItemHeight);
        layoutParams.setMargins(this.eEV, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aOi() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
