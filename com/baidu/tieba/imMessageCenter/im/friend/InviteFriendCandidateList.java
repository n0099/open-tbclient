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
import com.baidu.tieba.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private int aob;
    private View.OnClickListener cas;
    private int eEZ;
    private int eFa;
    private HeadImageView eFb;
    private a eFc;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aob = -1;
        this.mItemHeight = -1;
        this.eEZ = -1;
        this.eFa = 4;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aOl()) {
                    InviteFriendCandidateList.this.aOj();
                }
                if (InviteFriendCandidateList.this.eFc != null) {
                    InviteFriendCandidateList.this.eFc.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AF();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aob = -1;
        this.mItemHeight = -1;
        this.eEZ = -1;
        this.eFa = 4;
        this.cas = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aOl()) {
                    InviteFriendCandidateList.this.aOj();
                }
                if (InviteFriendCandidateList.this.eFc != null) {
                    InviteFriendCandidateList.this.eFc.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        AF();
    }

    public void setMaxCount(int i) {
        this.eFa = i;
    }

    public void a(a aVar) {
        this.eFc = aVar;
    }

    private void AF() {
        this.aob = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eEZ = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aOj();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOj() {
        if (this.eFb == null) {
            this.eFb = aOn();
            this.eFb.setDrawBorder(false);
        }
        this.eFb.setImageBitmap(am.cT(d.f.icon_add_pop));
        this.mLayout.addView(this.eFb);
    }

    private void aOk() {
        if (aOl()) {
            this.mLayout.removeView(this.eFb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aOl() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eFb;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eFa) {
            HeadImageView aOn = aOn();
            aOn.setIsRound(false);
            aOn.startLoad(aVar.Fu(), 12, false);
            if (aOl()) {
                aOn.setTag(aVar);
                aOn.setOnClickListener(this.cas);
                this.mLayout.addView(aOn, getItemLength());
                scrollTo(getItemLength() * (this.aob + this.eEZ), 0);
            }
            if (getItemLength() >= this.eFa) {
                aOk();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eFb && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aOm() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eFb && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aOl()) {
                aOj();
            }
        }
    }

    private HeadImageView aOn() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aob, this.mItemHeight);
        layoutParams.setMargins(this.eEZ, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aOl() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
