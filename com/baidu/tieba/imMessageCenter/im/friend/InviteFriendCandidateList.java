package com.baidu.tieba.imMessageCenter.im.friend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HorizontalCustomScrollView;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes16.dex */
public class InviteFriendCandidateList extends HorizontalCustomScrollView {
    private View.OnClickListener aBk;
    private LinearLayout jCa;
    private int jCb;
    private int jCc;
    private HeadImageView jCd;
    private a jCe;
    private Context mContext;
    private int mItemHeight;
    private int mItemWidth;

    /* loaded from: classes16.dex */
    public interface a {
        void a(View view, Object obj);
    }

    public InviteFriendCandidateList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mItemWidth = -1;
        this.mItemHeight = -1;
        this.jCb = -1;
        this.jCc = 4;
        this.aBk = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jCa.removeView(view);
                if (!InviteFriendCandidateList.this.cJa()) {
                    InviteFriendCandidateList.this.cIY();
                }
                if (InviteFriendCandidateList.this.jCe != null) {
                    InviteFriendCandidateList.this.jCe.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jCc = i;
    }

    public void a(a aVar) {
        this.jCe = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jCb = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jCa = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jCa.setLayoutParams(layoutParams);
        this.jCa.setHorizontalScrollBarEnabled(true);
        this.jCa.setOrientation(0);
        cIY();
        addView(this.jCa);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIY() {
        if (this.jCd == null) {
            this.jCd = cJb();
            this.jCd.setDrawBorder(false);
        }
        this.jCd.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jCa.addView(this.jCd);
    }

    private void cIZ() {
        if (cJa()) {
            this.jCa.removeView(this.jCd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJa() {
        int childCount = this.jCa.getChildCount();
        return childCount > 0 && this.jCa.getChildAt(childCount + (-1)) == this.jCd;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jCc) {
            HeadImageView cJb = cJb();
            cJb.setIsRound(false);
            cJb.startLoad(aVar.bps(), 12, false);
            if (cJa()) {
                cJb.setTag(aVar);
                cJb.setOnClickListener(this.aBk);
                this.jCa.addView(cJb, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jCb), 0);
            }
            if (getItemLength() >= this.jCc) {
                cIZ();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jCa.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCa.getChildAt(i);
            if (childAt != this.jCd && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jCa.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCa.getChildAt(i);
            if (childAt != this.jCd && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jCa.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jCa.removeView(findViewWithTag);
            if (!cJa()) {
                cIY();
            }
        }
    }

    private HeadImageView cJb() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jCb, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cJa() ? this.jCa.getChildCount() - 1 : this.jCa.getChildCount();
    }
}
