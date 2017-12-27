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
    private int aTf;
    private View.OnClickListener ctG;
    private HeadImageView eKA;
    private a eKB;
    private int eKy;
    private int eKz;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aTf = -1;
        this.mItemHeight = -1;
        this.eKy = -1;
        this.eKz = 4;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aLf()) {
                    InviteFriendCandidateList.this.aLd();
                }
                if (InviteFriendCandidateList.this.eKB != null) {
                    InviteFriendCandidateList.this.eKB.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DZ();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTf = -1;
        this.mItemHeight = -1;
        this.eKy = -1;
        this.eKz = 4;
        this.ctG = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aLf()) {
                    InviteFriendCandidateList.this.aLd();
                }
                if (InviteFriendCandidateList.this.eKB != null) {
                    InviteFriendCandidateList.this.eKB.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        DZ();
    }

    public void setMaxCount(int i) {
        this.eKz = i;
    }

    public void a(a aVar) {
        this.eKB = aVar;
    }

    private void DZ() {
        this.aTf = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eKy = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aLd();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLd() {
        if (this.eKA == null) {
            this.eKA = aLh();
            this.eKA.setDrawBorder(false);
        }
        this.eKA.setImageBitmap(aj.fQ(d.f.icon_add_pop));
        this.mLayout.addView(this.eKA);
    }

    private void aLe() {
        if (aLf()) {
            this.mLayout.removeView(this.eKA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aLf() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eKA;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eKz) {
            HeadImageView aLh = aLh();
            aLh.setIsRound(false);
            aLh.startLoad(aVar.Is(), 12, false);
            if (aLf()) {
                aLh.setTag(aVar);
                aLh.setOnClickListener(this.ctG);
                this.mLayout.addView(aLh, getItemLength());
                scrollTo(getItemLength() * (this.aTf + this.eKy), 0);
            }
            if (getItemLength() >= this.eKz) {
                aLe();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eKA && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aLg() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eKA && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aLf()) {
                aLd();
            }
        }
    }

    private HeadImageView aLh() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aTf, this.mItemHeight);
        layoutParams.setMargins(this.eKy, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aLf() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
