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
    private int aAo;
    private View.OnClickListener cud;
    private int ffF;
    private int ffG;
    private HeadImageView ffH;
    private a ffI;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aAo = -1;
        this.mItemHeight = -1;
        this.ffF = -1;
        this.ffG = 4;
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aWn()) {
                    InviteFriendCandidateList.this.aWl();
                }
                if (InviteFriendCandidateList.this.ffI != null) {
                    InviteFriendCandidateList.this.ffI.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aAo = -1;
        this.mItemHeight = -1;
        this.ffF = -1;
        this.ffG = 4;
        this.cud = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aWn()) {
                    InviteFriendCandidateList.this.aWl();
                }
                if (InviteFriendCandidateList.this.ffI != null) {
                    InviteFriendCandidateList.this.ffI.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.ffG = i;
    }

    public void a(a aVar) {
        this.ffI = aVar;
    }

    private void initialize() {
        this.aAo = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds80);
        this.ffF = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aWl();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWl() {
        if (this.ffH == null) {
            this.ffH = aWp();
            this.ffH.setDrawBorder(false);
        }
        this.ffH.setImageBitmap(al.dO(e.f.icon_add_pop));
        this.mLayout.addView(this.ffH);
    }

    private void aWm() {
        if (aWn()) {
            this.mLayout.removeView(this.ffH);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aWn() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.ffH;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.ffG) {
            HeadImageView aWp = aWp();
            aWp.setIsRound(false);
            aWp.startLoad(aVar.Kr(), 12, false);
            if (aWn()) {
                aWp.setTag(aVar);
                aWp.setOnClickListener(this.cud);
                this.mLayout.addView(aWp, getItemLength());
                scrollTo(getItemLength() * (this.aAo + this.ffF), 0);
            }
            if (getItemLength() >= this.ffG) {
                aWm();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.ffH && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aWo() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.ffH && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aWn()) {
                aWl();
            }
        }
    }

    private HeadImageView aWp() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aAo, this.mItemHeight);
        layoutParams.setMargins(this.ffF, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aWn() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
