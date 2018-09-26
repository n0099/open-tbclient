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
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aqI;
    private View.OnClickListener cgg;
    private int eMl;
    private int eMm;
    private HeadImageView eMn;
    private a eMo;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aqI = -1;
        this.mItemHeight = -1;
        this.eMl = -1;
        this.eMm = 4;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aQx()) {
                    InviteFriendCandidateList.this.aQv();
                }
                if (InviteFriendCandidateList.this.eMo != null) {
                    InviteFriendCandidateList.this.eMo.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        BP();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqI = -1;
        this.mItemHeight = -1;
        this.eMl = -1;
        this.eMm = 4;
        this.cgg = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aQx()) {
                    InviteFriendCandidateList.this.aQv();
                }
                if (InviteFriendCandidateList.this.eMo != null) {
                    InviteFriendCandidateList.this.eMo.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        BP();
    }

    public void setMaxCount(int i) {
        this.eMm = i;
    }

    public void a(a aVar) {
        this.eMo = aVar;
    }

    private void BP() {
        this.aqI = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds80);
        this.eMl = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aQv();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQv() {
        if (this.eMn == null) {
            this.eMn = aQz();
            this.eMn.setDrawBorder(false);
        }
        this.eMn.setImageBitmap(al.dc(e.f.icon_add_pop));
        this.mLayout.addView(this.eMn);
    }

    private void aQw() {
        if (aQx()) {
            this.mLayout.removeView(this.eMn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aQx() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eMn;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eMm) {
            HeadImageView aQz = aQz();
            aQz.setIsRound(false);
            aQz.startLoad(aVar.GK(), 12, false);
            if (aQx()) {
                aQz.setTag(aVar);
                aQz.setOnClickListener(this.cgg);
                this.mLayout.addView(aQz, getItemLength());
                scrollTo(getItemLength() * (this.aqI + this.eMl), 0);
            }
            if (getItemLength() >= this.eMm) {
                aQw();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMn && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aQy() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eMn && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aQx()) {
                aQv();
            }
        }
    }

    private HeadImageView aQz() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aqI, this.mItemHeight);
        layoutParams.setMargins(this.eMl, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aQx() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
