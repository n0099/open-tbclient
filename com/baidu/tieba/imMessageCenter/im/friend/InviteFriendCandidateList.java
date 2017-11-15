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
    private View.OnClickListener byr;
    private a dPA;
    private int dPx;
    private int dPy;
    private HeadImageView dPz;
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
        this.dPx = -1;
        this.dPy = 4;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aCv()) {
                    InviteFriendCandidateList.this.aCt();
                }
                if (InviteFriendCandidateList.this.dPA != null) {
                    InviteFriendCandidateList.this.dPA.b(view, view.getTag());
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
        this.dPx = -1;
        this.dPy = 4;
        this.byr = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aCv()) {
                    InviteFriendCandidateList.this.aCt();
                }
                if (InviteFriendCandidateList.this.dPA != null) {
                    InviteFriendCandidateList.this.dPA.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wA();
    }

    public void setMaxCount(int i) {
        this.dPy = i;
    }

    public void a(a aVar) {
        this.dPA = aVar;
    }

    private void wA() {
        this.aeC = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dPx = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aCt();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCt() {
        if (this.dPz == null) {
            this.dPz = aCx();
            this.dPz.setDrawBorder(false);
        }
        this.dPz.setImageBitmap(aj.cQ(d.f.icon_add_pop));
        this.mLayout.addView(this.dPz);
    }

    private void aCu() {
        if (aCv()) {
            this.mLayout.removeView(this.dPz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aCv() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dPz;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dPy) {
            HeadImageView aCx = aCx();
            aCx.setIsRound(false);
            aCx.startLoad(aVar.AF(), 12, false);
            if (aCv()) {
                aCx.setTag(aVar);
                aCx.setOnClickListener(this.byr);
                this.mLayout.addView(aCx, getItemLength());
                scrollTo(getItemLength() * (this.aeC + this.dPx), 0);
            }
            if (getItemLength() >= this.dPy) {
                aCu();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dPz && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aCw() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dPz && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aCv()) {
                aCt();
            }
        }
    }

    private HeadImageView aCx() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeC, this.mItemHeight);
        layoutParams.setMargins(this.dPx, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aCv() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
