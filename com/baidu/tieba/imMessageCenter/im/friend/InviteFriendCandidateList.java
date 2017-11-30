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
    private int aeX;
    private View.OnClickListener bER;
    private int dXm;
    private int dXn;
    private HeadImageView dXo;
    private a dXp;
    private Context mContext;
    private int mItemHeight;
    private LinearLayout mLayout;

    /* loaded from: classes2.dex */
    public interface a {
        void b(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context) {
        super(context);
        this.aeX = -1;
        this.mItemHeight = -1;
        this.dXm = -1;
        this.dXn = 4;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aDV()) {
                    InviteFriendCandidateList.this.aDT();
                }
                if (InviteFriendCandidateList.this.dXp != null) {
                    InviteFriendCandidateList.this.dXp.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wD();
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aeX = -1;
        this.mItemHeight = -1;
        this.dXm = -1;
        this.dXn = 4;
        this.bER = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.mLayout.removeView(view);
                if (!InviteFriendCandidateList.this.aDV()) {
                    InviteFriendCandidateList.this.aDT();
                }
                if (InviteFriendCandidateList.this.dXp != null) {
                    InviteFriendCandidateList.this.dXp.b(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        wD();
    }

    public void setMaxCount(int i) {
        this.dXn = i;
    }

    public void a(a aVar) {
        this.dXp = aVar;
    }

    private void wD() {
        this.aeX = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(d.e.ds80);
        this.dXm = this.mContext.getResources().getDimensionPixelSize(d.e.ds12);
        this.mLayout = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.mLayout.setLayoutParams(layoutParams);
        this.mLayout.setHorizontalScrollBarEnabled(true);
        this.mLayout.setOrientation(0);
        aDT();
        addView(this.mLayout);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aDT() {
        if (this.dXo == null) {
            this.dXo = aDX();
            this.dXo.setDrawBorder(false);
        }
        this.dXo.setImageBitmap(aj.cR(d.f.icon_add_pop));
        this.mLayout.addView(this.dXo);
    }

    private void aDU() {
        if (aDV()) {
            this.mLayout.removeView(this.dXo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aDV() {
        int childCount = this.mLayout.getChildCount();
        return childCount > 0 && this.mLayout.getChildAt(childCount + (-1)) == this.dXo;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.dXn) {
            HeadImageView aDX = aDX();
            aDX.setIsRound(false);
            aDX.startLoad(aVar.AP(), 12, false);
            if (aDV()) {
                aDX.setTag(aVar);
                aDX.setOnClickListener(this.bER);
                this.mLayout.addView(aDX, getItemLength());
                scrollTo(getItemLength() * (this.aeX + this.dXm), 0);
            }
            if (getItemLength() >= this.dXn) {
                aDU();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dXo && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String aDW() {
        Object tag;
        int childCount = this.mLayout.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mLayout.getChildAt(i);
            if (childAt != this.dXo && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
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
            if (!aDV()) {
                aDT();
            }
        }
    }

    private HeadImageView aDX() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.aeX, this.mItemHeight);
        layoutParams.setMargins(this.dXm, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return aDV() ? this.mLayout.getChildCount() - 1 : this.mLayout.getChildCount();
    }
}
