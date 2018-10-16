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
    private int avz;
    private View.OnClickListener coI;
    private int eTT;
    private int eTU;
    private HeadImageView eTV;
    private a eTW;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes4.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.avz = -1;
        this.mItemHeight = -1;
        this.eTT = -1;
        this.eTU = 4;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aTL()) {
                    InviteFriendCandidateList.this.aTJ();
                }
                if (InviteFriendCandidateList.this.eTW != null) {
                    InviteFriendCandidateList.this.eTW.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.avz = -1;
        this.mItemHeight = -1;
        this.eTT = -1;
        this.eTU = 4;
        this.coI = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aTL()) {
                    InviteFriendCandidateList.this.aTJ();
                }
                if (InviteFriendCandidateList.this.eTW != null) {
                    InviteFriendCandidateList.this.eTW.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.eTU = i;
    }

    public void a(a aVar) {
        this.eTW = aVar;
    }

    private void initialize() {
        this.avz = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds80);
        this.eTT = this.mContext.getResources().getDimensionPixelSize(e.C0175e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aTJ();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTJ() {
        if (this.eTV == null) {
            this.eTV = aTN();
            this.eTV.setDrawBorder(false);
        }
        this.eTV.setImageBitmap(al.dm(e.f.icon_add_pop));
        this.mLayout.addView(this.eTV);
    }

    private void aTK() {
        if (aTL()) {
            this.mLayout.removeView(this.eTV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTL() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eTV;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eTU) {
            HeadImageView aTN = aTN();
            aTN.setIsRound(false);
            aTN.startLoad(aVar.IL(), 12, false);
            if (aTL()) {
                aTN.setTag(aVar);
                aTN.setOnClickListener(this.coI);
                this.mLayout.addView(aTN, getItemLength());
                scrollTo(getItemLength() * (this.avz + this.eTT), 0);
            }
            if (getItemLength() >= this.eTU) {
                aTK();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eTV && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aTM() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eTV && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aTL()) {
                aTJ();
            }
        }
    }

    private HeadImageView aTN() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.avz, this.mItemHeight);
        layoutParams.setMargins(this.eTT, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aTL() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
