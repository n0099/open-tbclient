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
    private View.OnClickListener aBm;
    private LinearLayout jCg;
    private int jCh;
    private int jCi;
    private HeadImageView jCj;
    private a jCk;
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
        this.jCh = -1;
        this.jCi = 4;
        this.aBm = new View.OnClickListener() { // from class: com.baidu.tieba.imMessageCenter.im.friend.InviteFriendCandidateList.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InviteFriendCandidateList.this.jCg.removeView(view);
                if (!InviteFriendCandidateList.this.cJb()) {
                    InviteFriendCandidateList.this.cIZ();
                }
                if (InviteFriendCandidateList.this.jCk != null) {
                    InviteFriendCandidateList.this.jCk.a(view, view.getTag());
                }
            }
        };
        this.mContext = context;
        initialize();
    }

    public void setMaxCount(int i) {
        this.jCi = i;
    }

    public void a(a aVar) {
        this.jCk = aVar;
    }

    private void initialize() {
        this.mItemWidth = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds80);
        this.jCh = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds12);
        this.jCg = new LinearLayout(this.mContext);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.jCg.setLayoutParams(layoutParams);
        this.jCg.setHorizontalScrollBarEnabled(true);
        this.jCg.setOrientation(0);
        cIZ();
        addView(this.jCg);
        setSmoothScrollingEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cIZ() {
        if (this.jCj == null) {
            this.jCj = cJc();
            this.jCj.setDrawBorder(false);
        }
        this.jCj.setImageBitmap(ap.getBitmap(R.drawable.icon_add_pop));
        this.jCg.addView(this.jCj);
    }

    private void cJa() {
        if (cJb()) {
            this.jCg.removeView(this.jCj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cJb() {
        int childCount = this.jCg.getChildCount();
        return childCount > 0 && this.jCg.getChildAt(childCount + (-1)) == this.jCj;
    }

    public void d(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        if (getItemLength() < this.jCi) {
            HeadImageView cJc = cJc();
            cJc.setIsRound(false);
            cJc.startLoad(aVar.bpt(), 12, false);
            if (cJb()) {
                cJc.setTag(aVar);
                cJc.setOnClickListener(this.aBm);
                this.jCg.addView(cJc, getItemLength());
                scrollTo(getItemLength() * (this.mItemWidth + this.jCh), 0);
            }
            if (getItemLength() >= this.jCi) {
                cJa();
            }
        }
    }

    public boolean e(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        Object tag;
        int childCount = this.jCg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCg.getChildAt(i);
            if (childAt != this.jCj && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a) && ((com.baidu.tbadk.coreExtra.relationship.a) tag).equals(aVar)) {
                aVar.setChecked(true);
                childAt.setTag(aVar);
                return true;
            }
        }
        return false;
    }

    public String getDataList() {
        Object tag;
        int childCount = this.jCg.getChildCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.jCg.getChildAt(i);
            if (childAt != this.jCj && (tag = childAt.getTag()) != null && (tag instanceof com.baidu.tbadk.coreExtra.relationship.a)) {
                if (i > 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(((com.baidu.tbadk.coreExtra.relationship.a) tag).getUserId());
            }
        }
        return sb.toString();
    }

    public void f(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        View findViewWithTag = this.jCg.findViewWithTag(aVar);
        if (findViewWithTag != null) {
            this.jCg.removeView(findViewWithTag);
            if (!cJb()) {
                cIZ();
            }
        }
    }

    private HeadImageView cJc() {
        HeadImageView headImageView = new HeadImageView(this.mContext);
        headImageView.setIsRound(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.mItemWidth, this.mItemHeight);
        layoutParams.setMargins(this.jCh, 0, 0, 0);
        headImageView.setLayoutParams(layoutParams);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return headImageView;
    }

    public int getItemLength() {
        return cJb() ? this.jCg.getChildCount() - 1 : this.jCg.getChildCount();
    }
}
