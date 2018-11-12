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
    private int awm;
    private View.OnClickListener coU;
    private int eVm;
    private int eVn;
    private HeadImageView eVo;
    private a eVp;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.awm = -1;
        this.mItemHeight = -1;
        this.eVm = -1;
        this.eVn = 4;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aTi()) {
                    InviteFriendCandidateList.this.aTg();
                }
                if (InviteFriendCandidateList.this.eVp != null) {
                    InviteFriendCandidateList.this.eVp.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.awm = -1;
        this.mItemHeight = -1;
        this.eVm = -1;
        this.eVn = 4;
        this.coU = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aTi()) {
                    InviteFriendCandidateList.this.aTg();
                }
                if (InviteFriendCandidateList.this.eVp != null) {
                    InviteFriendCandidateList.this.eVp.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.eVn = i;
    }

    public void a(a aVar) {
        this.eVp = aVar;
    }

    private void initialize() {
        this.awm = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds80);
        this.eVm = this.mContext.getResources().getDimensionPixelSize(e.C0200e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aTg();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTg() {
        if (this.eVo == null) {
            this.eVo = aTk();
            this.eVo.setDrawBorder(false);
        }
        this.eVo.setImageBitmap(al.dA(e.f.icon_add_pop));
        this.mLayout.addView(this.eVo);
    }

    private void aTh() {
        if (aTi()) {
            this.mLayout.removeView(this.eVo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTi() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eVo;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eVn) {
            HeadImageView aTk = aTk();
            aTk.setIsRound(false);
            aTk.startLoad(aVar.IX(), 12, false);
            if (aTi()) {
                aTk.setTag(aVar);
                aTk.setOnClickListener(this.coU);
                this.mLayout.addView(aTk, getItemLength());
                scrollTo(getItemLength() * (this.awm + this.eVm), 0);
            }
            if (getItemLength() >= this.eVn) {
                aTh();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eVo && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aTj() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eVo && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aTi()) {
                aTg();
            }
        }
    }

    private HeadImageView aTk() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.awm, this.mItemHeight);
        layoutParams.setMargins(this.eVm, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aTi() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
