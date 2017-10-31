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
    private int aeC;
    private View.OnClickListener byf;
    private int dPs;
    private int dPt;
    private HeadImageView dPu;
    private a dPv;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeC = -1;
        this.mItemHeight = -1;
        this.dPs = -1;
        this.dPt = 4;
        this.byf = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aCr()) {
                    InviteFriendCandidateList.this.aCp();
                }
                if (InviteFriendCandidateList.this.dPv != null) {
                    InviteFriendCandidateList.this.dPv.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeC = -1;
        this.mItemHeight = -1;
        this.dPs = -1;
        this.dPt = 4;
        this.byf = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aCr()) {
                    InviteFriendCandidateList.this.aCp();
                }
                if (InviteFriendCandidateList.this.dPv != null) {
                    InviteFriendCandidateList.this.dPv.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public void setMaxCount(int i) {
        this.dPt = i;
    }

    public void a(a aVar) {
        this.dPv = aVar;
    }

    private void wA() {
        this.aeC = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dPs = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aCp();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCp() {
        if (this.dPu == null) {
            this.dPu = aCt();
            this.dPu.setDrawBorder(false);
        }
        this.dPu.setImageBitmap(aj.cR(d.f.icon_add_pop));
        this.mLayout.addView(this.dPu);
    }

    private void aCq() {
        if (aCr()) {
            this.mLayout.removeView(this.dPu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCr() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dPu;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dPt) {
            HeadImageView aCt = aCt();
            aCt.setIsRound(false);
            aCt.startLoad(aVar.At(), 12, false);
            if (aCr()) {
                aCt.setTag(aVar);
                aCt.setOnClickListener(this.byf);
                this.mLayout.addView(aCt, getItemLength());
                scrollTo(getItemLength() * (this.aeC + this.dPs), 0);
            }
            if (getItemLength() >= this.dPt) {
                aCq();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dPu && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aCs() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dPu && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aCr()) {
                aCp();
            }
        }
    }

    private HeadImageView aCt() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeC, this.mItemHeight);
        layoutParams.setMargins(this.dPs, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aCr() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
