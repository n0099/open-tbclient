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
    private int aeW;
    private View.OnClickListener buo;
    private int cVt;
    private int dKI;
    private HeadImageView dKJ;
    private a dKK;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeW = -1;
        this.mItemHeight = -1;
        this.dKI = -1;
        this.cVt = 4;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aBf()) {
                    InviteFriendCandidateList.this.aBd();
                }
                if (InviteFriendCandidateList.this.dKK != null) {
                    InviteFriendCandidateList.this.dKK.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        xb();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeW = -1;
        this.mItemHeight = -1;
        this.dKI = -1;
        this.cVt = 4;
        this.buo = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aBf()) {
                    InviteFriendCandidateList.this.aBd();
                }
                if (InviteFriendCandidateList.this.dKK != null) {
                    InviteFriendCandidateList.this.dKK.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        xb();
    }

    public void setMaxCount(int i) {
        this.cVt = i;
    }

    public void a(a aVar) {
        this.dKK = aVar;
    }

    private void xb() {
        this.aeW = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.f.ds80);
        this.dKI = this.mContext.getResources().getDimensionPixelSize(d.f.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aBd();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBd() {
        if (this.dKJ == null) {
            this.dKJ = aBh();
            this.dKJ.setDrawBorder(false);
        }
        this.dKJ.setImageBitmap(aj.cT(d.g.icon_add_pop));
        this.mLayout.addView(this.dKJ);
    }

    private void aBe() {
        if (aBf()) {
            this.mLayout.removeView(this.dKJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBf() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dKJ;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.cVt) {
            HeadImageView aBh = aBh();
            aBh.setIsRound(false);
            aBh.c(aVar.AS(), 12, false);
            if (aBf()) {
                aBh.setTag(aVar);
                aBh.setOnClickListener(this.buo);
                this.mLayout.addView(aBh, getItemLength());
                scrollTo(getItemLength() * (this.aeW + this.dKI), 0);
            }
            if (getItemLength() >= this.cVt) {
                aBe();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dKJ && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aBg() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dKJ && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aBf()) {
                aBd();
            }
        }
    }

    private HeadImageView aBh() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeW, this.mItemHeight);
        layoutParams.setMargins(this.dKI, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aBf() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
