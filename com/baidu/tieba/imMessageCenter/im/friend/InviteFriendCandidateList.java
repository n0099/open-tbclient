package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InviteFriendCandidateList extends com.baidu.tbadk.core.view.d {
    private int aUA;
    private View.OnClickListener cxV;
    private int eQq;
    private int eQr;
    private HeadImageView eQs;
    private a eQt;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aUA = -1;
        this.mItemHeight = -1;
        this.eQq = -1;
        this.eQr = 4;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aMQ()) {
                    InviteFriendCandidateList.this.aMO();
                }
                if (InviteFriendCandidateList.this.eQt != null) {
                    InviteFriendCandidateList.this.eQt.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        El();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aUA = -1;
        this.mItemHeight = -1;
        this.eQq = -1;
        this.eQr = 4;
        this.cxV = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aMQ()) {
                    InviteFriendCandidateList.this.aMO();
                }
                if (InviteFriendCandidateList.this.eQt != null) {
                    InviteFriendCandidateList.this.eQt.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        El();
    }

    public void setMaxCount(int i) {
        this.eQr = i;
    }

    public void a(a aVar) {
        this.eQt = aVar;
    }

    private void El() {
        this.aUA = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.eQq = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aMO();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMO() {
        if (this.eQs == null) {
            this.eQs = aMS();
            this.eQs.setDrawBorder(false);
        }
        this.eQs.setImageBitmap(aj.fO(d.f.icon_add_pop));
        this.mLayout.addView(this.eQs);
    }

    private void aMP() {
        if (aMQ()) {
            this.mLayout.removeView(this.eQs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aMQ() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.eQs;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.eQr) {
            HeadImageView aMS = aMS();
            aMS.setIsRound(false);
            aMS.startLoad(aVar.IS(), 12, false);
            if (aMQ()) {
                aMS.setTag(aVar);
                aMS.setOnClickListener(this.cxV);
                this.mLayout.addView(aMS, getItemLength());
                scrollTo(getItemLength() * (this.aUA + this.eQq), 0);
            }
            if (getItemLength() >= this.eQr) {
                aMP();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eQs && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aMR() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.eQs && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aMQ()) {
                aMO();
            }
        }
    }

    private HeadImageView aMS() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aUA, this.mItemHeight);
        layoutParams.setMargins(this.eQq, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aMQ() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
